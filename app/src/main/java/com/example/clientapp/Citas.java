package com.example.clientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Citas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
    }
    public void buttononClickReservacion(View v){
        Intent intent = new Intent(v.getContext(),Reservacion.class);
        startActivity(intent);
    }
    public void buttononClickCancelar(View v){
        Intent intent = new Intent(v.getContext(),CancelarCita.class);
        startActivity(intent);
    }
}
