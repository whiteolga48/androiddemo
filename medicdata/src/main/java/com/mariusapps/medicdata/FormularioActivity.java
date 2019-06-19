package com.mariusapps.medicdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mariusapps.medicdata.model.Lectura;
import com.mariusapps.medicdata.model.LecturaServices;
import com.mariusapps.medicdata.model.LecturaServicesImpl;

import java.util.Date;

public class FormularioActivity extends AppCompatActivity {

    private LecturaServices lecturaServices = null;



    private Button enviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);


        lecturaServices=LecturaServicesImpl.getInstance();

           }

        public void enviar (View view){

            Log.d("***","Entramos en enviar ");

            //double peso =0;
            //double diastolica = 0;
            //double sistolica = 0

            EditText editPeso = (EditText) findViewById(R.id.idPeso);
            EditText editDiastolica = (EditText) findViewById(R.id.id_Diastólica_formulario);
            EditText editSistolica = (EditText) findViewById(R.id.id_siastolica_formulario);

            double peso = Double.parseDouble(editPeso.getText().toString());
            double diastolica = Double.parseDouble(editDiastolica.getText().toString());
            double sistolica = Double.parseDouble(editSistolica.getText().toString());


            Lectura lectura = new Lectura(new Date(),peso,diastolica,sistolica);

            lecturaServices.create(lectura);

            Intent intent = new Intent(this,MainActivity.class);

            startActivity(intent);



        ;




        }


}



