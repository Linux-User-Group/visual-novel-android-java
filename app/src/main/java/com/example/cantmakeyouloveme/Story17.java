package com.example.cantmakeyouloveme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Story17 extends AppCompatActivity {

    private TextView txtStatus;

    //local server
//    private String URL = "http://192.168.1.7/novel/story/story17.php";

    //online serve
    private String URL = "https://novelfaris.000webhostapp.com/story/story17.php";

    private StringRequest stringRequest;
    private RequestQueue requestQueue;

    private JSONObject jsonObj, jsonData;
    private JSONArray jsonStory;
    private String id, category, text;
    int i;

    private ArrayAdapter adapter_text;
    ArrayList arrayList;

    ImageView femaleChar;
    Animation slideDown;
    TextView txtStory;
    LinearLayout textStory;

    ImageView maleChar1, femaleChar1;

    BankStory bankStory;
    ControllerStory controllerStory;

    MediaPlayer audio;

    public void getStory(){

        stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

//                System.out.println(response);
                text = response;
//                txtStatus.setText(response.toString());
                try {
                    jsonObj = new JSONObject(response);
                    jsonStory = jsonObj.getJSONArray("data");
//                    System.out.println(jsonMhs.toString());

                    for (int i = 0; i < jsonStory.length(); i++){
                        jsonData = jsonStory.getJSONObject(i);
                        id = jsonData.getString("id");
                        category = jsonData.getString("category");
                        text = jsonData.getString("text");

                        bankStory = new BankStory(id, category, text);
                        controllerStory.simpan(bankStory);

                    }

                    text = controllerStory.getArrayList().get(i).getText();

                    new Handler().postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            txtStory.setText(text);
                        }
                    }, 500);

                    clickStory(controllerStory);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                txtStatus.setText(error.toString());
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        controllerStory = new ControllerStory();
        i = 0;
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_story17);

        Intent intent = getIntent();

        audio = MediaPlayer.create(this, R.raw.sound2);
        audio.setVolume(1,1);
        audio.start();

        txtStory = (TextView)findViewById(R.id.txtStory);
        maleChar1 = (ImageView)findViewById(R.id.maleChar1);
        femaleChar1 = (ImageView)findViewById(R.id.femaleChar1);
        textStory = (LinearLayout)findViewById(R.id.textStory);

        slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);

//        maleChar1.setAnimation(slideDown);
//        femaleChar1.setAnimation(slideDown);
        getStory();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                txtStory.setText(text);
            }
        }, 500);
    }

    public void clickStory(ControllerStory cr){
        textStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i >= 0 && i < cr.getSize()){
                    txtStory.setText(controllerStory.getArrayList().get(i).getText());
                    i++;
                } else {
                    startActivity(new Intent(getApplicationContext(), Home.class));
                    audio.setVolume(0,0);
                    audio.stop();

                }

            }
        });
    }
}