package com.example.proyecto_final_grupo3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fichar extends AppCompatActivity {

    ArrayList<Proyecto> pro_nomb;
    SQLiteDatabase db;
    int id_pro;
    TextView txt_horaentrada_fichar;
    TextView txt_horasalida_fichar;
    Time timeStart;
    Time timeFinish;
    int t1Hour, t1Minute, t2Hour, t2Minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichar);
        DbHelper dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();



        Button main_volver = findViewById(R.id.main_back);
        Button main_fichar = findViewById(R.id.main_fichar1);
        Button añadir_btfichar = findViewById(R.id.fichar_añaditbt);


        txt_horaentrada_fichar = findViewById(R.id.txt_horaentrada_fichar);
        txt_horasalida_fichar = findViewById(R.id.txt_horasalida_fichar);

        Spinner proyecto_spinner_fichar = findViewById(R.id.fichar_spinner_pro);


        txt_horaentrada_fichar.setVisibility(View.GONE);
        txt_horasalida_fichar.setVisibility(View.GONE);

        añadir_btfichar.setVisibility(View.GONE);

        proyecto_spinner_fichar.setVisibility(View.GONE);

        pro_nomb = dbHelper.getProyecto_2();
        ArrayAdapter<Proyecto> proy = new ArrayAdapter<Proyecto>(this, android.R.layout.simple_spinner_dropdown_item, pro_nomb);
        proyecto_spinner_fichar.setAdapter(proy);



        main_fichar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt_horaentrada_fichar.setVisibility(View.VISIBLE);
                txt_horasalida_fichar.setVisibility(View.VISIBLE);

                proyecto_spinner_fichar.setVisibility(View.VISIBLE);
                añadir_btfichar.setVisibility(View.VISIBLE);
            }
        });




        txt_horaentrada_fichar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        Fichar.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;


                                Calendar cal = Calendar.getInstance();





                                cal.set(0,0,0,t1Hour,t1Minute);
                                txt_horaentrada_fichar.setText(android.text.format.DateFormat.format("hh:mm", cal));





                            }
                        },12,0,true
                );

                timePickerDialog.updateTime(t1Hour,t1Minute);
                timePickerDialog.show();
            }
        });

        txt_horasalida_fichar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog2 = new TimePickerDialog(
                        Fichar.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t2Hour = hourOfDay;
                                t2Minute = minute;


                                Calendar cal2 = Calendar.getInstance();





                                cal2.set(0,0,0,t2Hour,t2Minute);
                                txt_horasalida_fichar.setText(android.text.format.DateFormat.format("hh:mm", cal2));





                            }
                        },12,0,true
                );

                timePickerDialog2.updateTime(t2Hour,t2Minute);
                timePickerDialog2.show();
            }





        });

        añadir_btfichar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String proyectos = proyecto_spinner_fichar.getSelectedItem().toString();
                String h_entrada = txt_horaentrada_fichar.getText().toString();
                String h_salida = txt_horasalida_fichar.getText().toString();


                DateFormat formatter = new SimpleDateFormat("hh:mm");

                try {
                    timeStart = new Time(formatter.parse(h_entrada).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                DateFormat formatterdos = new SimpleDateFormat("hh:mm");

                try {
                    timeFinish = new Time(formatterdos.parse(h_salida).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                for(Proyecto pro: pro_nomb) {
                    if(pro.getNombre().equals(proyectos)){
                        id_pro = pro.getId_proyecto();
                        break;
                    }
                }


                SimpleDateFormat sdf = new SimpleDateFormat("HH");
                SimpleDateFormat sdf2 = new SimpleDateFormat("HH");


                int intStart = Integer.parseInt(sdf.format(timeStart));
                int intFinish = Integer.parseInt(sdf2.format(timeFinish));

                int difference_time = intStart - intFinish;






                if (difference_time <= 8){
                    ContentValues form_fichar = new ContentValues();



                    form_fichar.put("hora_entrada", String.valueOf(timeStart));
                    form_fichar.put("hora_salida",String.valueOf(timeFinish));
                    form_fichar.put("fecha",String.valueOf(LocalDateTime.now()));
                    form_fichar.put("horas_metidas",difference_time);
                    form_fichar.put("id_proyecto",id_pro);
                    db.insert("fichaje",null,form_fichar);
                    Toast.makeText(getApplicationContext(),"Datos insertados", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Tiene que ser menos de 8 horas", Toast.LENGTH_LONG).show();
                }


















            }
        });
        main_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}