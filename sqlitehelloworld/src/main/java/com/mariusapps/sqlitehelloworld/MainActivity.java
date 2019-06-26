package com.mariusapps.sqlitehelloworld;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText  et_nombre;
    EditText et_apellido1;
    EditText et_apellido2;


    Button btn_crear;
    Button btn_listar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = findViewById(R.id.id_et_nombre);
        et_apellido1 = findViewById(R.id.id_et_primerApellido);
        et_apellido2 = findViewById(R.id.id_et_segundoApellido);


        btn_crear = findViewById(R.id.id_btn_crear);
        btn_listar = findViewById(R.id.id_btn_listar);

         myDB= new DatabaseHelper(this);

        btn_crear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String nombre = et_nombre.getText().toString();
                String apellido1 = et_apellido1.getText().toString();
                String apellido2 = et_apellido2.getText().toString();


               String nombreCompleto = apellido1 + " " + apellido2 + ","+nombre;
                Toast.makeText(MainActivity.this, nombreCompleto,Toast.LENGTH_LONG).show();

                myDB.insertData(nombre,apellido1,apellido2);

            }
        });



        btn_listar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Cursor cursor =  myDB.getAll();

                // que hace un cursor aquí


                if(cursor==null ||cursor.getCount()==0){

                    return;
                }

                while (cursor.moveToNext()){

                    int codigo = cursor.getInt(0);
                    String nombre = cursor.getString(1);
                    String apellido1 = cursor.getString(2);
                    String apellido2 = cursor.getString(3);

                    String amigo =  codigo + ": " + nombre + " " + apellido1 + " " + apellido2;
                }

            }
        });


    }
}
