package com.example.proyecto_final_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.proyecto_final_grupo3.ui.home.HomeFragment;

public class editar_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        EditText edit_nombre = findViewById(R.id.edit_nombre);
        EditText edit_apellidos = findViewById(R.id.edit_apellidos);
        EditText edit_correo = findViewById(R.id.edit_correo);
        EditText edit_usuario = findViewById(R.id.edit_usuario2);


        Button main_back = findViewById(R.id.back_bt);
        Button bt_savename = findViewById(R.id.bt_savenombre);
        Button change_user = findViewById(R.id.change_user);
        Button change_name = findViewById(R.id.change_name);
        Button change_apellidos = findViewById(R.id.change_apellidos);
        Button change_email = findViewById(R.id.change_email);
        Button bt_saveuser = findViewById(R.id.bt_saveuser);
        Button bt_saveemail = findViewById(R.id.bt_saveemail2);
        Button bt_saveapellidos = findViewById(R.id.bt_saveapellidos);
        ImageButton img_deluser = findViewById(R.id.del_user);
        ImageButton img_delnom = findViewById(R.id.ic_delnom);
        ImageButton img_delapellidos = findViewById(R.id.ic_delapellidos);
        ImageButton img_delcorreo = findViewById(R.id.ic_delcorreo);


        edit_usuario.setVisibility(View.GONE);
        bt_saveuser.setVisibility(View.GONE);
        edit_nombre.setVisibility(View.GONE);
        edit_correo.setVisibility(View.GONE);
        bt_saveuser.setVisibility(View.GONE);
        bt_savename.setVisibility(View.GONE);
        bt_saveemail.setVisibility(View.GONE);
        edit_apellidos.setVisibility(View.GONE);
        bt_saveapellidos.setVisibility(View.GONE);
        img_deluser.setVisibility(View.GONE);
        img_delnom.setVisibility(View.GONE);
        img_delapellidos.setVisibility(View.GONE);
        img_delcorreo.setVisibility(View.GONE);

        change_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_usuario.setVisibility(View.VISIBLE);
                bt_saveuser.setVisibility(View.VISIBLE);
                img_deluser.setVisibility(View.VISIBLE);


                bt_saveuser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("usuario", edit_usuario.getText().toString());
                        db.update("usuario", contentValues,null,null);


                    }
                });

                img_deluser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edit_usuario.setVisibility(View.GONE);
                        bt_saveuser.setVisibility(View.GONE);
                        img_deluser.setVisibility(View.GONE);
                    }
                });

            }
        });



        change_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_nombre.setVisibility(View.VISIBLE);
                bt_savename.setVisibility(View.VISIBLE);
                img_delnom.setVisibility(View.VISIBLE);


                bt_savename.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("nombre", edit_nombre.getText().toString());
                        db.update("usuario", contentValues,null,null);

                    }
                });
                img_delnom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edit_nombre.setVisibility(View.GONE);
                        bt_savename.setVisibility(View.GONE);
                        img_delnom.setVisibility(View.GONE);
                    }
                });
            }
        });

        change_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_correo.setVisibility(View.VISIBLE);
                bt_saveemail.setVisibility(View.VISIBLE);
                img_delcorreo.setVisibility(View.VISIBLE);


                bt_saveemail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("email", edit_correo.getText().toString());
                        db.update("usuario", contentValues,null,null);

                    }
                });

                img_delcorreo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edit_correo.setVisibility(View.GONE);
                        bt_saveemail.setVisibility(View.GONE);
                        img_delcorreo.setVisibility(View.GONE);
                    }
                });

            }
        });

        change_apellidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_apellidos.setVisibility(View.VISIBLE);
                bt_saveapellidos.setVisibility(View.VISIBLE);
                img_delapellidos.setVisibility(View.VISIBLE);


                bt_saveapellidos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("apellidos", edit_apellidos.getText().toString());
                        db.update("usuario", contentValues,null,null);
                    }
                });
                img_delapellidos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edit_apellidos.setVisibility(View.GONE);
                        bt_saveapellidos.setVisibility(View.GONE);
                        img_delapellidos.setVisibility(View.GONE);
                    }
                });
            }
        });


        main_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}