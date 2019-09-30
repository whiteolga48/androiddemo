package com.mariusapps.calculadora;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //https://www.dev2qa.com/android-calculator-example-source-code/

    private EditText display;

    private double operando1 = 0.0;
    private double operando2 = 0.0;
    private double resultadoOperacion = 0.0;
    private String operacion;

    private String operador= "";

    private String parteNumero="entera";



    private DecimalFormat decimalFormat = new DecimalFormat("#.###");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.et_display);
        TextView resultado = (TextView) findViewById(R.id.et_resultado);


        resultado.setText("");


    }


    public void botonPulsado(View view) {

        int valorBoton = -1;
        String accion = "";

        String operacion = null;
        switch (view.getId()) {


            case R.id.btn_cero:
                valorBoton = 0;
                break;


            case R.id.btn_1:
                valorBoton = 1;
                break;

            case R.id.btn_2:
                valorBoton = 2;
                break;

            case R.id.btn_3:
                valorBoton = 3;
                break;

            case R.id.btn_4:
                valorBoton = 4;
                break;

            case R.id.btn_5:
                valorBoton = 5;
                break;


            case R.id.btn_6:
                valorBoton = 6;
                break;


            case R.id.btn_7:
                valorBoton = 7;
                break;


            case R.id.btn_8:
                valorBoton = 8;
                break;


            case R.id.btn_9:
                valorBoton = 9;
                break;


            case R.id.btn_multiplicar:

                 operador = "*" ;
                 accion = "operar";
                 break;


            case R.id.btn_sumar:
                operador = "+";
                accion = "operar";
                break;

            case R.id.btn_restar:
               operador = "-";
                accion = "operar";
                break;


            case R.id.btn_division:

                operador = "/";
                accion = "operar";
                break;

            case R.id.btn_igual:
                accion = "calcular";
                break;


            case R.id.btn_punto:
                parteNumero = "decimal";

               Log.d("*****", String.valueOf(parteNumero));
                break;

            case R.id.btn_ce:
                    resultadoOperacion = 0.0;
                    parteNumero = "entera";
                    operacion = "borrar";
        }


        assert operacion != null;

        display.setText("");

        if (valorBoton >= 0) {

            concatenarNumeros(valorBoton);

            Log.d("CALCULATOR", "concatenando cifra...");

        }

        Toast.makeText(getApplicationContext(), "Pulsado: " + valorBoton, Toast.LENGTH_SHORT).show();


        if (accion.equals("operar")) {
            Log.d("CALCULATOR", "operación");
            operando2 = operando1;
            operando1 = 0.0;
        }

        if (accion.equals("calcular")) {

            Log.d("CALCULATOR", "botón igual...");

            switch (operador) {

                case "+":
                    resultadoOperacion = operando1 + operando2;
                    break;
                case "-":
                    resultadoOperacion = operando1 - operando2;
                    break;
                case "*":
                    resultadoOperacion = operando1 * operando2;
                    break;
                case "/":
                    resultadoOperacion = operando1 / operando2;
                    break;

            }

        }


         display.setText(String.valueOf(resultadoOperacion));

        Log.d("CALCULATOR", String.valueOf(resultadoOperacion));


    }


    private void concatenarNumeros(int cifra) {
        if (parteNumero.equals("entera")) {
            Log.d("CALCULATOR", "concatenando parte entera");
        operando1 *= 10;
        operando1 += cifra;}


     else{


            String strValor = String.valueOf(operando1);
            Log.d("*******",strValor);
            String[] partes = strValor.split("[.]");
            Log.d("******", Arrays.toString(partes));
            partes[1] = partes[1].equals("0")? String.valueOf(cifra) : partes[1] + cifra;
            double valor = Double.parseDouble(partes[0] + "." + partes[1]);


            
        }

        display.setText(String.valueOf(resultadoOperacion));
    }
}