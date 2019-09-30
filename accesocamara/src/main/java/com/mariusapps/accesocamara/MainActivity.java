package com.mariusapps.accesocamara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrirCamara;
    private Button btnGuardarFoto;
    private ImageView imageView;
    private Bitmap imagenActual = null;




    // También vamos a matener una referencia a la imagen "actual" en forma de bitmap


        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAbrirCamara = findViewById(R.id.btn_camara);
        btnGuardarFoto = findViewById(R.id.btn_guardar);
        imageView = findViewById(R.id.imageView);


        btnGuardarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                guardarFoto();

            }
        });

       btnAbrirCamara.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               abrirCamara();


           }
       });





    }

        // estes es el método que sabe que se ha realizado una foto
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

            if (requestCode==1 && resultCode == RESULT_OK){
                Bundle extras = data.getExtras(); // referencia al Bundle a partir del intent

                Bitmap imagenBitmap = (Bitmap) extras.get("data"); // hay que saber que se llama data la key del mapa

                imageView.setImageBitmap(imagenBitmap);

                imagenActual = imagenBitmap;

                // Como posiblemente guarde este bitmap en el sistema de archivos, me interesara guardar eol, bitmap en la variable de instancia imagen>Actual



            }
   }





    private void abrirCamara() {


        Intent hacerFotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        if(hacerFotoIntent.resolveActivity(getPackageManager()) !=null){

            startActivityForResult(hacerFotoIntent, 1);

        }
    }


    private File createImageFile () throws IOException {


            String strName = "name" + ((int)(Math.random()*1000));

            // El contrucctor de file necesito 2 parametros,

            // 1 - el directorio de nuestra app
            // 2-CONOCER EL NOMBRE DEL ARCHIVO

            File file = new File(this.getFilesDir(),strName);

            return file;

    }

    private void guardarFoto(){


            try {

                File file = createImageFile();
                Log.d("**","file: " + file.getAbsolutePath());
                OutputStream out = new FileOutputStream(file); // la tuberia

                // vamos a enviar la imagen actual atraves del Stream

                imagenActual.compress(Bitmap.CompressFormat.JPEG,100,out);
                out.flush();// lleva la orden de que la imagen "fluya por la tubería"
                out.close();



            }catch (Exception e){

                e.printStackTrace();

            }




    }
}
