package com.example.proyecto_final_grupo3.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.proyecto_final_grupo3.Fichar;
import com.example.proyecto_final_grupo3.R;
import com.example.proyecto_final_grupo3.editar_usuario;

public class HomeFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        Button bt_informacion = (Button) view.findViewById(R.id.info_usuario);
        Button bt_editar = (Button) view.findViewById(R.id.edit_usuario);
        Button bt_fichar = (Button) view.findViewById(R.id.main_fichar1);

        bt_fichar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fichar = new Intent(getActivity(), Fichar.class);
                startActivity(fichar);
            }
        });

        bt_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(getActivity(), editar_usuario.class);
                startActivity(editar);
            }
        });

        bt_informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info_usuario = new Intent(getActivity(), com.example.proyecto_final_grupo3.info_usuario.class);
                startActivity(info_usuario);
            }
        });
        return view;
    }



}