package com.mariusapps.constrainlayouthelloworld;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

        private Date  fecha = new Date();
        private TextView textViewSegundos;

  /*  static{

        Log.d("INFO","SE INICIALIZA EL MUNDO ESTÁTICO");

    }

    public MainActivity(){

       Log.d("INFO","DENTRO DEL MÉTODO CONSTRUCCTOR");
    }*/

   //TextView textView = (TextView) findViewById(R.id.tv_segundos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("INFO","DENTRO DEL ON CREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewSegundos = (TextView) findViewById(R.id.tv_segundos);



    }


    @Override
    protected void onPause() {
        super.onPause();

        Log.d("INFO", "ON PAUSE");

        /*Long tsLong1 = System.currentTimeMillis()/1000;
        String ts1 = tsLong1.toString();
        Log.d("segundosOnPause",ts1);*/

        fecha = new Date();


    }


    @Override
    protected void onResume() {
        super.onResume();
       Log.d("INFO", "ON RESUME");
       long milisegundos = (new Date()).getTime()-fecha.getTime();
       StringBuilder sb = new StringBuilder();

       sb.append(milisegundos/1000).append(" segundos en segundo plano ");
       textViewSegundos.setText(sb.toString());




    }



}




