package com.example.tarjeta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarjeta.interfaces.TarjetaAPI;
import com.example.tarjeta.models.Tarjeta;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.BreakIterator;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    TextView num_tarjeta;
    Button ver_tarjeta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num_tarjeta = findViewById(R.id.num_tarjeta);
        ver_tarjeta = findViewById(R.id.ver_tarjeta);

        ver_tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = getString("http://10.122.27.162:4000/infocards2/user1/");
                num_tarjeta.setText(mensaje);
            }
        });



    }
    public static  String getString(String path) {
        URL url;
        OkHttpClient client = new OkHttpClient();

        try {
            url = new URL(path);
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Log.e("Mensaje",response.body().string());
                return response.body().string();
            }
        } catch (Exception ex) {
            return null;
        }
    }


}
