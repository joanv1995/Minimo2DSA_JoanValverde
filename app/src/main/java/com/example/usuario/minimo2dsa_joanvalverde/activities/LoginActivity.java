package com.example.usuario.minimo2dsa_joanvalverde.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.minimo2dsa_joanvalverde.R;
import com.example.usuario.minimo2dsa_joanvalverde.service.ApiServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    EditText userName;
    String playerName;
    EditText password;
    String pass;
    Button login;
    String TAG = "minimo2";
    private static final String URL_BASE = "http://10.193.222.188:8080/eetac/restauracio/"; ///mi local host

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.usuarioname);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName.setTypeface(null, Typeface.NORMAL);
                userName.setTextColor(Color.parseColor("#000000"));//negro
                userName.setText("");

            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                password.setTypeface(null, Typeface.NORMAL);
                password.setTextColor(Color.parseColor("#000000"));
                password.setText("");
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerName = userName.getText().toString();
                pass = password.getText().toString();
                connectApiService();


            }
        });

    }
    public void connectApiService(){
        if (this.retrofit == null) {
            this.retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiServiceClient service = retrofit.create(ApiServiceClient.class);

        Call<Boolean> call = service.loginUser(playerName,pass);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.body()){
                    Log.i(TAG,"Conexión establecida y usuario aceptado");
                    Toast.makeText(LoginActivity.this, "Usuario correcto!", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(getApplicationContext(),UserZoneActivity.class);

                    it.putExtra("user",playerName);
                    startActivity(it);


                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
               Log.e(TAG, t.getMessage());

            }
        });


    }
}
