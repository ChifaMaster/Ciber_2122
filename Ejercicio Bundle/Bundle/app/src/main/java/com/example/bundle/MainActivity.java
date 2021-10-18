package com.example.bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText main_tx_nombre = findViewById(R.id.main_tx_nombre);
        Button main_bt_enviar = findViewById(R.id.main_bt_enviar);




        main_bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = new Bundle();
                b.putString("nombre",main_tx_nombre.getText().toString());
                Intent in = new Intent(MainActivity.this,juanchuthre.class);
                in.putExtras(b);
                startActivity(in);

            }
        });


    }
}