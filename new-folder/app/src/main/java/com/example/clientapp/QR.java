package com.example.clientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QR extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private EditText correo;// el texto que guarda la direccion de correo
    private ZXingScannerView QRScanner;// crea el QR scanner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
    }
    public void buttononClickQR(View v){
        correo = (EditText) findViewById(R.id.email);//consigue direcciond de correo
        String direccion = correo.getText().toString();
        enviarQR(direccion);
    }

    private void enviarQR(String direccion) {
        String[] to = new String[]{direccion};
        String subject = ("Su codigo QR");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);//se usa cuando se le quiere enviar algo a una direccion
        emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT,"http://www.qrcode.es/wp-content/themes/ultra/qrcdr/qrcodes/3cb5c9086d10309c04292c251ff01742.png?1493075689282");//envia link de QR
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }
    public void buttonAnalizarQR(View v){
        QRScanner = new ZXingScannerView(getApplicationContext());
        setContentView(QRScanner);
        QRScanner.setResultHandler(this);//manejador de respuestas usa el de esta clase
        QRScanner.startCamera();
    }


    @Override
    public void handleResult(Result result) {
        Intent intent=new Intent(QR.this,Citas.class);
        startActivity(intent);
    }
}
