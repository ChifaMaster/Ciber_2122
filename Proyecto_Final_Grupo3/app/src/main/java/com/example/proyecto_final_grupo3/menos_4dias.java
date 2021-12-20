package com.example.proyecto_final_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class menos_4dias extends AppCompatActivity {

    ArrayList<Departamentos> departamentos_nom;
    ArrayList<Proyecto> pro_nom;
    int id_depar;
    int id_pro;
    EditText edit_peaje;
    EditText edit_parking;
    EditText edit_distancia;
    Button main_volver1;
    Button main_añadirgastos;
    Spinner spinner;
    Spinner spin_departamento;
    Spinner spin_proyecto;
    SQLiteDatabase db;
    String suma;
    //String kilometraje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menos4dias);

        DbHelper dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        //botones
        main_volver1 = findViewById(R.id.main_volver1);
        main_añadirgastos = findViewById(R.id.main_añadirmasgastos);


        //edit_text
        edit_peaje = findViewById(R.id.edit_peaje);
        edit_parking = findViewById(R.id.edit_parking);
        edit_distancia = findViewById(R.id.edit_distancia);


        //spinners
        spinner = findViewById(R.id.desplazamiento);
        spin_departamento = findViewById(R.id.departamento);
        spin_proyecto = findViewById(R.id.spin_proyecto);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.desplazamiento, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        //obtener departamentos
        departamentos_nom = dbHelper.getDepartamentos();
        ArrayAdapter<Departamentos> dep = new ArrayAdapter<Departamentos>(this, android.R.layout.simple_spinner_dropdown_item, departamentos_nom);
        spin_departamento.setAdapter(dep);



        //obetener proyectos
        pro_nom =dbHelper.getProyecto_2();
        ArrayAdapter<Proyecto> pro = new ArrayAdapter<Proyecto>(this, android.R.layout.simple_spinner_dropdown_item, pro_nom);
        spin_proyecto.setAdapter(pro);


        main_volver1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        main_añadirgastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String departamento = spin_departamento.getSelectedItem().toString();
                    String proyectos = spin_proyecto.getSelectedItem().toString();
                    String desplazamiento = spinner.getSelectedItem().toString();
                    String peaje = edit_peaje.getText().toString();
                    String parking = edit_parking.getText().toString();
                    String distancia_recorrida = edit_distancia.getText().toString();
                    //String suma = (distancia_recorrida*peaje)+parking;


                    int peaje_num = Integer.parseInt(peaje);
                    int parking_num = Integer.parseInt(parking);
                    int distancia_recorridanum = Integer.parseInt(distancia_recorrida);
                    double kilometraje = 0.3;

                    int sum_multiplicacion = (int) (distancia_recorridanum*kilometraje);
                    int suma = sum_multiplicacion + parking_num + peaje_num;

                    for(Proyecto pro: pro_nom) {
                        if(pro.getNombre().equals(proyectos)){
                            id_pro = pro.getId_proyecto();
                            break;
                        }
                    }

                    for (Departamentos dep: departamentos_nom) {
                        if(dep.getNombre().equals(departamento)){
                            id_depar = dep.getId_departamento();
                            break;
                        }
                    }



                    ContentValues form_menos4dias = new ContentValues();

                    form_menos4dias.put("transporte",desplazamiento);
                    form_menos4dias.put("peaje",peaje);
                    form_menos4dias.put("parking",parking);
                    form_menos4dias.put("distancia_recorrida",distancia_recorrida);
                    form_menos4dias.put("id_departamento",id_depar);
                    form_menos4dias.put("id_proyecto",id_pro);
                    form_menos4dias.put("precioTotal",suma);
                    db.insert("gestion_de_gastos",null,form_menos4dias);
                    Toast.makeText(menos_4dias.this, "Se han añadido los gastos", Toast.LENGTH_SHORT).show();


            }

        });






    }

}