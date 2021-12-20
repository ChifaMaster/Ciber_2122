package com.example.proyecto_final_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class info_usuario extends AppCompatActivity {

    long UserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_usuario);

        DbHelper DbHelper = new DbHelper(this);

        TextView usuario_nombre = findViewById(R.id.usu_nom);
        TextView apellidos = findViewById(R.id.apellidos);
        TextView DNI = findViewById(R.id.DNI);
        TextView Nombre_usuario = findViewById(R.id.nombre_usuario);
        TextView ultima_conexion = findViewById(R.id.ultima_conexion);

        Button main_back = findViewById(R.id.button_back);

        //Intent intent = getIntent();
        //Bundle data1 = intent.getExtras();


























        usuario_nombre.setText(DbHelper.getNombre().toString());
        apellidos.setText(DbHelper.getApellidos().toString());
        DNI.setText(DbHelper.getDNI().toString());
        Nombre_usuario.setText(DbHelper.getUser().toString());
        ultima_conexion.setText(DbHelper.getDate());






        main_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent volver = new Intent(getApplicationContext(), HomeActivity.class);
                //startActivity(volver);
                finish();
            }
        });


    }
}