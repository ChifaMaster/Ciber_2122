package com.example.tarjeta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarjeta.interfaces.TarjetaAPI;
import com.example.tarjeta.models.Tarjeta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    TextView num_tarjeta;
    Button boton_ver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num_tarjeta = findViewById(R.id.num_tarjeta);
        boton_ver = findViewById(R.id.boton_ver);
        find();

    }

    private void find(){
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://10.122.27.162:4000/infocards2/user1").build();
        num_tarjeta.setText(retrofit.toString());
    }
}