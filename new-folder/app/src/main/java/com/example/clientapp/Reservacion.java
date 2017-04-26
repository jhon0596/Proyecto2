package com.example.clientapp;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Reservacion extends AppCompatActivity {
    static final int check = 1111;// se usa paar iniciar activity result
    private TextView txtOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion);
        txtOutput = (TextView) findViewById(R.id.textView);
    }
    public void ButtonVoz(View v){
        Intent i =  new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Diga sus sintomas");
        startActivityForResult(i,check);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == check && resultCode == RESULT_OK){
            ArrayList<String> results  =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String text = results.get(0);
            txtOutput.setText(text);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
