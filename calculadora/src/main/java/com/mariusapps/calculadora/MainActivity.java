package com.mariusapps.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText display;

    private double valor = 0.0;
    private double operando1 = 0.0;

    private TextView resultado;

    private String operacion = "";

    private String parteNumero = "entera";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.et_display);
        resultado = findViewById(R.id.et_resultado);


        resultado.setText("");


    }


    public void botonPulsado(View view) {

        int cifra = -1;
        String accion = "";

        switch (view.getId()) {


            case R.id.btn_cero:
                cifra = 0;
                break;

            case R.id.btn_1:
                cifra = 1;
                break;

            case R.id.btn_2:
                cifra = 2;
                break;

            case R.id.btn_3:
                cifra = 3;
                break;

            case R.id.btn_4:
                cifra = 4;
                break;

            case R.id.btn_5:
                cifra = 5;
                break;


            case R.id.btn_6:
                cifra = 6;
                break;


            case R.id.btn_7:
                cifra = 7;
                break;


            case R.id.btn_8:
                cifra = 8;
                break;


            case R.id.btn_9:
                cifra = 9;
                break;


            case R.id.btn_multiplicar:
                break;


            case R.id.btn_sumar:
                operacion = "sumar";
                accion = "operar";
                break;

            case R.id.btn_restar:
                operacion = "restar";
                accion = "operar";
                break;


            case R.id.btn_division:

                operacion = "dividir";
                accion = "operar";
                break;

            case R.id.btn_igual:
                accion = "calcular";
                break;


            case R.id.btn_punto:
                parteNumero = "decimal";
                break;

            case R.id.btn_ce:
                valor = 0.0;
                parteNumero = "entera";
                operacion = "";
        }


        if (operacion == ""){

            display.setText("");

        }

        if (cifra >= 0) {

            concatenarNumeros(cifra);

            Log.d("CALCULATOR", "concatenando cifra...");

        }

        Toast.makeText(getApplicationContext(), "Pulsado: " + cifra, Toast.LENGTH_SHORT).show();


        if (accion.equals("operar")) {
            Log.d("CALCULATOR", "operación");
            operando1 = valor;
            valor = 0.0;
        }

        if (accion.equals("calcular")) {

            Log.d("CALCULATOR", "botón igual...");

            switch (operacion) {

                case "sumar":
                    valor = operando1 + valor;
                    break;
                case "restar":
                    valor = operando1 - valor;
                    break;
                case "multiplicar":
                    valor = operando1 * valor;
                    break;
                case "dividir":
                    valor = operando1 / valor;
                    break;

            }

        }


       resultado.setText(String.valueOf(valor));

        Log.d("CALCULATOR", String.valueOf(valor));


    }


    private void concatenarNumeros(int cifra) {
        if (parteNumero.equals("entera")) {
            Log.d("CALCULATOR", "concatenando parte entera");
        valor *= 10;   
        valor += cifra;}


     else{


            Log.d("CALCULATOR", "concatenando parte decimal");
        }

    }
}