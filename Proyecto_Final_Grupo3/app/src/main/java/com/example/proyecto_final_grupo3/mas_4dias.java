package com.example.proyecto_final_grupo3;

import static android.R.style.Theme_Holo_Dialog;

import static java.time.temporal.ChronoUnit.*;



import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.type.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class mas_4dias extends AppCompatActivity {

    ArrayList<Departamentos> departamentos_nomb;
    ArrayList<Proyecto> pro_nomb;
    Spinner departament;
    Spinner proyect;
    Spinner tipo_tarjeta;
    EditText edit_peaje;
    EditText edit_parking;
    EditText edit_distancia;
    EditText edit_ciudad;
    Button main_btiniciofecha;
    Button main_btfinfecha;
    TextView text_fechaini;
    TextView text_fechafin;
    String date_ini;
    String date_fin;
    String tipo_tarjeta_selected;
    Date data_inicio;
    Date data_fin;
    Date date1;
    Date date2;
    Date date1_eur;
    Date date2_eur;
    DateTime date_i;
    DateTime date_f;
    long mUserId;
    DatePickerDialog.OnDateSetListener setListener;
    int id_pro;
    int id_depar;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas4dias);

        DbHelper dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        Button main_volver = findViewById(R.id.main_volver);
        Button main_añadirgastos = findViewById(R.id.main_masgastos1);
        main_btiniciofecha = findViewById(R.id.main_bt_iniciofecha);
        main_btfinfecha = findViewById(R.id.main_btfinfecha);

        departament = (Spinner) findViewById(R.id.spinner_department);
        proyect = (Spinner) findViewById(R.id.spin_proyect);
        tipo_tarjeta = (Spinner) findViewById(R.id.spinner_tipotarjeta);

        edit_peaje = findViewById(R.id.edit_peaje);
        edit_parking = findViewById(R.id.edit_parking);
        edit_distancia = findViewById(R.id.edit_distancia);
        edit_ciudad = findViewById(R.id.edit_ciudad);

        text_fechaini = findViewById(R.id.text_iniciofecha);
        text_fechafin = findViewById(R.id.text_finfecha);



        text_fechaini.setVisibility(View.GONE);
        text_fechafin.setVisibility(View.GONE);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_tarjeta, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_tarjeta.setAdapter(adapter);

        departamentos_nomb = dbHelper.getDepartamentos();
        ArrayAdapter<Departamentos> dep = new ArrayAdapter<Departamentos>(this, android.R.layout.simple_spinner_dropdown_item, departamentos_nomb);
        departament.setAdapter(dep);

        pro_nomb = dbHelper.getProyecto_2();
        ArrayAdapter<Proyecto> proy = new ArrayAdapter<Proyecto>(this, android.R.layout.simple_spinner_dropdown_item, pro_nomb);
        proyect.setAdapter(proy);


        main_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        main_btiniciofecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        mas_4dias.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        date_ini = day+"/"+month+"/"+year;
                        text_fechaini.setVisibility(View.VISIBLE);
                        text_fechaini.setText(date_ini);

                    }
                },year,month,day);
                datePickerDialog.show();




            }
        });




        Calendar calendar_fin = Calendar.getInstance();
        final int year_fin = calendar_fin.get(Calendar.YEAR);
        final int month_fin = calendar_fin.get(Calendar.MONTH);
        final int day_fin = calendar_fin.get(Calendar.DAY_OF_MONTH);

        main_btfinfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        mas_4dias.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int yearf, int monthf, int dayOfMonthf) {
                        monthf = monthf+1;
                        date_fin = dayOfMonthf+"/"+monthf+"/"+yearf;
                        text_fechafin.setVisibility(View.VISIBLE);
                        text_fechafin.setText(date_fin);
                    }
                },year_fin,month_fin,day_fin);
                datePickerDialog.show();

            }
        });

        main_añadirgastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Convertir la fecha que esta en string a date, y date restar las fecha inicio fecha fin
                // y convertir las fechas a int para los dias que ha estado fuera

                tipo_tarjeta_selected = tipo_tarjeta.getSelectedItem().toString();

                if (tipo_tarjeta_selected.equals("Europea")){
                    String proyectos = proyect.getSelectedItem().toString();
                    String departamento = departament.getSelectedItem().toString();
                    String peaje = edit_peaje.getText().toString();
                    String ciudad = edit_ciudad.getText().toString();
                    String parking = edit_parking.getText().toString();
                    int preciotot = 60;
                    //dias que va  a estar por la dieta









                    for(Proyecto pro: pro_nomb) {
                      if(pro.getNombre().equals(proyectos)){
                          id_pro = pro.getId_proyecto();
                           break;
                        }
                    }

                    for (Departamentos dep: departamentos_nomb) {
                     if(dep.getNombre().equals(departamento)){
                          id_depar = dep.getId_departamento();
                          break;
                        }
                    }

                    /*SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        date_i = dates.parse(date_ini);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        date_f = dates.parse(date_fin);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    long difference = Math.abs(date_i.getTime() - date_f.getTime());
                    long differenceDates = difference / (1000 * 60 * 60 * 24);
                    int days = Long.valueOf(differenceDates).intValue();

                    int precioTOT = preciotot*days;*/


                    String fffinicio = text_fechaini.getText().toString();
                    String fffin = text_fechafin.getText().toString();

                    try {
                        date1_eur=new SimpleDateFormat("dd/MM/yyyy").parse(fffinicio);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        date2_eur=new SimpleDateFormat("dd/MM/yyyy").parse(fffin);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    long diferencia_eur = date1_eur.getTime() - date2_eur.getTime();
                    long diff_eur = (diferencia_eur / (1000 * 60 * 60 *24));
                    int days = Long.valueOf(diff_eur).intValue();

                    int precioTOT = preciotot*days;


                    ContentValues form_mas4dias = new ContentValues();
                    form_mas4dias.put("peaje",peaje);
                    form_mas4dias.put("parking",parking);
                    form_mas4dias.put("ciudad",ciudad);
                    form_mas4dias.put("id_departamento",id_depar);
                    form_mas4dias.put("id_proyecto",id_pro);
                    form_mas4dias.put("fecha_ini", String.valueOf(date1_eur));
                    form_mas4dias.put("fecha_fin", String.valueOf(date2_eur));
                    form_mas4dias.put("precioTotal",precioTOT);
                    form_mas4dias.put("dias_fuera",days);
                    db.insert("gestion_de_gastos",null,form_mas4dias);
                    Toast.makeText(mas_4dias.this, "Se ha insertado la dieta", Toast.LENGTH_SHORT).show();

                }
                if (tipo_tarjeta_selected.equals("Internacional")) {
                    String proyectos = proyect.getSelectedItem().toString();
                    String departamento = departament.getSelectedItem().toString();
                    //String peaje = edit_peaje.getText().toString();
                    String ciudad = edit_ciudad.getText().toString();
                    //String parking = edit_parking.getText().toString();
                    int precio_tot = 100;
                    //dias que va  a estar por la dieta


                    for(Proyecto pro: pro_nomb) {
                        if(pro.getNombre().equals(proyectos)){
                            id_pro = pro.getId_proyecto();
                            break;
                        }
                    }

                    for (Departamentos dep: departamentos_nomb) {
                        if(dep.getNombre().equals(departamento)){
                            id_depar = dep.getId_departamento();
                            break;
                        }
                    }

                    /*try {
                        data_inicio = dateFormat.parse(date_ini);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        data_fin = dateFormat_fin.parse(date_fin);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }*/
                    //long difference = Math.abs(data_inicio.getDate() - data_fin.getDate());

                    //int dias = (int)difference;


                    /*SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        date_i = dates.parse(date_ini);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        date_f = dates.parse(date_fin);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    long difference = Math.abs(date_i.getTime() - date_f.getTime());
                    long differenceDates = difference / (1000 * 60 * 60 * 24);
                    int days = Long.valueOf(differenceDates).intValue();

                    int precioTOT = precio_tot*days;*/















                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    String ffinicio = text_fechaini.getText().toString();
                    String fffin = text_fechafin.getText().toString();


                    try {
                        date1=new SimpleDateFormat("dd/MM/yyyy").parse(ffinicio);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        date2=new SimpleDateFormat("dd/MM/yyyy").parse(fffin);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }












                    long diferencia = date1.getTime() - date2.getTime();
                    long diff = (diferencia / (1000 * 60 * 60 *24));
                    int days = Long.valueOf(diff).intValue();

                    int precioTOT = precio_tot*days;


                    ContentValues form_mas4dias_int = new ContentValues();
                    //form_mas4dias_int.put("peaje",peaje);
                    //form_mas4dias_int.put("parking",parking);




                    form_mas4dias_int.put("ciudad",ciudad);
                    form_mas4dias_int.put("id_departamento",id_depar);
                    form_mas4dias_int.put("id_proyecto",id_pro);
                    form_mas4dias_int.put("precioTotal",precio_tot);
                    form_mas4dias_int.put("fecha_ini", String.valueOf(date1));
                    form_mas4dias_int.put("fecha_fin", String.valueOf(date2));
                    form_mas4dias_int.put("dias_fuera", days);
                    form_mas4dias_int.put("precioTotal",precioTOT);
                    db.insert("gestion_de_gastos",null,form_mas4dias_int);
                    Toast.makeText(mas_4dias.this, "Se ha insertado la dieta", Toast.LENGTH_SHORT).show();


                }




            }
        });


    }
}