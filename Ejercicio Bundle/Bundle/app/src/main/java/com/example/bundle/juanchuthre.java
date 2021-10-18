package com.example.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class juanchuthre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juanchuthre);

        Intent in = getIntent();
        String mensaje = in.getStringExtra("nombre");

        TextView vista= findViewById(R.id.vista);

        vista.setText(mensaje);


    }
}