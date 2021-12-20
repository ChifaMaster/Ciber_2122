package com.example.proyecto_final_grupo3.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.proyecto_final_grupo3.R;

public class DashboardFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Button change = (Button)view.findViewById(R.id.ver_tarjeta);



        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new Intent(getContext(), com.example.proyecto_final_grupo3.Request.class);
                startActivity(change);
            }
        });
     return view;
    }







}