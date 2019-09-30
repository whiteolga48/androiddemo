package com.mariusapps.accesocontactos;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnBuscarContactos;
    private TextView textViewContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscarContactos = findViewById(R.id.button);
        textViewContactos = findViewById(R.id.textView);

        btnBuscarContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obtenerDatos();

            }
        });




    }


    private void obtenerDatos(){

        String[] colummnas = new String[]{


          // Especificamos las colummnas de la proyección, si necesitamos más
          // Nombre del contactos
          // codigo del contacto _ID
          // telefono del contacto
          // tipo de telefono
          // CommonDataKinds (tipos de datos comunes)



                ContactsContract.Data._ID,  // codigo del contacto _ID
                ContactsContract.Data.DISPLAY_NAME,  // Nombre del contactos
                ContactsContract.CommonDataKinds.Phone.NUMBER, // telefono del contacto
                ContactsContract.CommonDataKinds.Phone.TYPE



                };

                String filtro =

                        // MIMMETYPE (TIPO DE CONTENIDO)
                        ContactsContract.Data.MIMETYPE + " = '" +

                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "  +
                        ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";

        Log.d("**","filtro: " + filtro);


        String orden = ContactsContract.Data.DISPLAY_NAME + " ASC ...";


        Cursor cursor =  getContentResolver().query(

                ContactsContract.Data.CONTENT_URI,   // URI DE CONTENIDO PARA LOS CONTACTOS mapa de tablas
                colummnas,                               // LAS COLUMMNAS QUE NOS INTERESA
                filtro,                                     // LA CLAUSULA DEL FILTRO
                null,                           // NO HAY PARAMETROS
                orden                                       // CRITRIO DE ORDENACION

        );

        // Ahora que tenemos el cursor, lo vamos a iterar

        // En cada iteracion vamos a extraer la información haciendo referencia al número de la colummna


        while (cursor.moveToNext()){


            textViewContactos.append("Identificador: " + cursor.getString(0) + "\n");
            textViewContactos.append("Nombre: " + cursor.getString(1) + "\n");
            textViewContactos.append("Teléfono: " + cursor.getString(2) + "\n");
            textViewContactos.append("Tipo de teléfono: " + cursor.getString(3) + "\n\n\\");


        }


    }

        // Contact.Data es la tabla interna donde se guarda la información de contactos.

        // Obtenemos una tabla, ahi decidiremos que colummnas nos interesan, hacemos una query(una  consulta)

        // vamos a poder fuiltrar y oredenar, obtenemos un cursor y lo itereamos, e iremos extrayewndo la información que
        // hemos solicitado
        // objetivo obtener un cursor
        // el cursor nos lo da el content.resolver tenemos que utilizar una query
        // uri indentificador unico de recursos
        // CONTENT_URI es una constante que accede a contactos
        // Proyección (Las columnnas que necesitamos), necesitamos un array de strings con los nombre de las colummnas
        //









    }


