package com.example.proyecto_final_grupo3.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.proyecto_final_grupo3.R;
import com.example.proyecto_final_grupo3.mas_4dias;
import com.example.proyecto_final_grupo3.menos_4dias;

public class NotificationsFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        Button main_mas4dias = view.findViewById(R.id.main_mas4dias);
        Button main_menos4dias = view.findViewById(R.id.main_menos4dias);

        main_mas4dias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masdias = new Intent(getActivity(), mas_4dias.class);
                startActivity(masdias);
            }
        });

        main_menos4dias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menos4dias = new Intent(getActivity(), menos_4dias.class);
                startActivity(menos4dias);
            }
        });

        return view;
    }


}