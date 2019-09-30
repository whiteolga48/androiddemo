package com.mariusapps.medicdatafragments;


import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.mariusapps.medicdatafragments.model.Lectura;
import com.mariusapps.medicdatafragments.model.LecturaServices;
import com.mariusapps.medicdatafragments.model.LecturaServicesSQLite;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFragment1 extends Fragment {


    EditText editPeso;
    EditText editDiastolica;
    EditText editSistolica;
    private LecturaServices lecturaServices;
    private Button enviar;

    public FormularioFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.activity_formulario, container, false);

        editPeso = view.findViewById(R.id.idPeso);
        editDiastolica = view.findViewById(R.id.id_Diastólica_formulario);
        editSistolica = view.findViewById(R.id.id_siastolica_formulario);
        lecturaServices = new LecturaServicesSQLite(getActivity());

        view.findViewById(R.id.idButtonEnviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                double peso = Double.parseDouble(editPeso.getText().toString());
                double diastolica = Double.parseDouble(editDiastolica.getText().toString());
                double sistolica = Double.parseDouble(editSistolica.getText().toString());

                Lectura lectura = new Lectura(new Date(), peso, diastolica, sistolica, 0, 0);

                // 2.- Persistimos objeto Lectura

                lecturaServices.create(lectura);

                Log.d("***", "onClick: " + lectura);

//                // 3.- Substituyo el fragmento actual por el de la lista...
//
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.destino, new ListadoFragment());
//                fragmentTransaction.commit();
            }
        });


        return view;

    }


}









