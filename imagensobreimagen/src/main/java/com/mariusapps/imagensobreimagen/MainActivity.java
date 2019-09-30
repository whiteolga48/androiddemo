package com.mariusapps.imagensobreimagen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(android.R.color.white)); // Text Color


        Bitmap jungle = BitmapFactory.decodeResource(getResources(),R.drawable.jungle).copy(Bitmap.Config.ARGB_8888,true);
        Bitmap dino = BitmapFactory.decodeResource(getResources(), R.drawable.dinosaurio);

        Canvas canvas = new Canvas(jungle);

        canvas.drawBitmap(dino, (jungle.getWidth()) / 4, 250, new Paint());
        imageView.setImageBitmap(jungle);

    }
}
