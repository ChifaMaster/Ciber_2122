package com.example.proyecto_final_grupo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;


public class MainActivity extends AppCompatActivity {

    String usutxt;
    int passtxt;
    EditText main_edit_login;
    EditText main_password_login;
    Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();



        ContentValues tabla_usuario7 = new ContentValues();
        tabla_usuario7.put("usuario", "admin1");
        tabla_usuario7.put("nombre","otronombre");
        tabla_usuario7.put("password", "admin".hashCode());
        db.insert("usuario",null,tabla_usuario7);

        ContentValues tabla_usuario = new ContentValues();


        tabla_usuario.put("DNI", "prueba");
        tabla_usuario.put("nombre", "admin");
        tabla_usuario.put("apellidos", "admin");
        tabla_usuario.put("usuario", "admin");
        tabla_usuario.put("password", "admin".hashCode());
        tabla_usuario.put("email", "admin@admin.com");
        tabla_usuario.put("ultima_conexion", String.valueOf(LocalDateTime.now()));
        //tabla_usuario.put("id_usuario",1);
        // tabla_usuario.put("id_departamento",1);
        tabla_usuario.put("permisos",0);

        db.insert("usuario",null,tabla_usuario);

        ContentValues tabla_departamento = new ContentValues();
        ContentValues tabla_departamento2 = new ContentValues();
        ContentValues tabla_departamento3 = new ContentValues();

        //tabla_departamento.put("id_departamento",0);

        tabla_departamento.put("nombre","informatica");
        db.insert("departamento",null,tabla_departamento);

        tabla_departamento3.put("nombre","rrhh");
        db.insert("departamento",null,tabla_departamento3);

        ContentValues tabla_proyecto1 = new ContentValues();
        tabla_proyecto1.put("nombre","app android");
        db.insert("proyecto",null,tabla_proyecto1);

        ContentValues tabla_proyecto2 = new ContentValues();
        tabla_proyecto2.put("nombre","app web");
        db.insert("proyecto",null,tabla_proyecto2);

        //ContentValues tabla_proyecto3 = new ContentValues();
        //db.insert("proyecto",null,tabla_proyecto3);
        Button main_bt_1 = findViewById(R.id.main_bt1);

        main_bt_1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                EditText main_edit_login = findViewById(R.id.main_edit_login);
                EditText main_password_login = findViewById(R.id.main_edit_password);

                /*Cursor cursor=dbHelper.ConsultarUsuPas(main_edit_login.getText().toString(),main_password_login.getText().toString().hashCode());

                if(cursor.getCount()>0){
                    Intent inicio = new Intent(getApplicationContext(), HomeActivity.class);
                    inicio.putExtra("nameusuario", main_edit_login.getText().toString());
                    startActivity(inicio);
                }else {
                    Toast.makeText(getApplicationContext(),"Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }

                main_edit_login.setText("");
                main_password_login.setText("");
                main_edit_login.setText("");*/


                //login bueno

                user = new Usuario();

                usutxt = main_edit_login.getText().toString();
                passtxt = main_password_login.getText().toString().hashCode();

                //Cursor rs = dbHelper.getData(usutxt, passtxt);

                Cursor rs = dbHelper.getData(usutxt,passtxt);
                //Cursor rs = db.query("usuario", new String[]{"id_usuario","usuario","password"},"usuario" + "=? AND password =?",new String[]{usutxt, String.valueOf(passtxt)},null,null,null);

                if(rs.moveToFirst()) {




                    Toast.makeText(MainActivity.this, "Se ha iniciado sesión correctamente", Toast.LENGTH_SHORT).show();

                    Intent intentHome = new Intent(MainActivity.this, HomeActivity.class);

                    startActivity(intentHome);

                    //if (rs != null && !rs.isClosed())  {
                    //    rs.close();
                    //}
                } else {
                    Toast.makeText(MainActivity.this, "Inicio de sesión inválido", Toast.LENGTH_SHORT).show();
                }}



        });


    }
}