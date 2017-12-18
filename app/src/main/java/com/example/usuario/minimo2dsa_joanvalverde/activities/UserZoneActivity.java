package com.example.usuario.minimo2dsa_joanvalverde.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.usuario.minimo2dsa_joanvalverde.R;

public class UserZoneActivity extends AppCompatActivity {
    String nombre;
    TextView name;
    Button productos;
    Button pedidos;
    int oper =0;
    Button realizarpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_zone);
        Intent in = getIntent();
       nombre= in.getStringExtra("user");
       name = (TextView) findViewById(R.id.username);
       productos = (Button) findViewById(R.id.productos);
       pedidos = (Button) findViewById(R.id.pedidos);
       realizarpedido = (Button) findViewById(R.id.realizarpedido);
       name.setText("Benvenido "+nombre);

       productos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               oper=1;
               connectApiService();

           }
       });
       pedidos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               oper=2;
               connectApiService();

           }
       });
        realizarpedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oper=3;
                connectApiService();

            }
        });


    }
    public void connectApiService(){


    }
}
