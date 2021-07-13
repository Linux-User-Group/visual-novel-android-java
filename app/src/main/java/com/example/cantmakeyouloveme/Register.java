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

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    //local server
//    private String URL = "http://192.168.1.7/novel/auth/register.php";

    //online serve
    private String URL = "https://novelfaris.000webhostapp.com/auth/register.php";

    private StringRequest stringRequest;
    private RequestQueue requestQueue;
    String nama, pass, email;

    TextInputEditText txtNama, txtEmail, txtPass;
    TextView txtStatus;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        txtNama = (TextInputEditText)findViewById(R.id.txtNama);
        txtEmail = (TextInputEditText)findViewById(R.id.txtEmail);
        txtPass = (TextInputEditText)findViewById(R.id.txtPass);
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = txtNama.getText().toString().trim();
                email = txtEmail.getText().toString().trim();
                pass = txtPass.getText().toString().trim();

                if (nama.equals("") || email.equals("") || pass.equals("")){

                    txtStatus.setText("Semua kolom jangan kosong");

                } else {
                    stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
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
                            data.put("email", email);
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