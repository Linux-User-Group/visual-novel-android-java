package com.example.cantmakeyouloveme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private String URL = "http://192.168.1.7/novel/login.php";

    private StringRequest stringRequest;
    private RequestQueue requestQueue;
    String nama, pass, login;

    TextInputEditText txtNama, txtPass;
    TextView txtStatus, txtRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        txtNama = (TextInputEditText)findViewById(R.id.txtNama);
        txtPass = (TextInputEditText)findViewById(R.id.txtPass);
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        txtRegister = (TextView)findViewById(R.id.txtRegister);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = txtNama.getText().toString().trim();
                pass = txtPass.getText().toString().trim();

                if (nama.equals("") || pass.equals("")){

                    txtStatus.setText("Nama dan password jangan kosong");

                } else {
                    stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            startActivity(new Intent(getApplicationContext(), PopUpLogin.class));
//                            txtStatus.setText("Berhasil Login");
//                            txtStatus.setText(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            txtStatus.setText(error.toString());
                        }
                    }) {
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("nama", nama);
                            data.put("password", pass);
                            return data;
                        }
                    };

                    requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }


            }
        });

    }
}