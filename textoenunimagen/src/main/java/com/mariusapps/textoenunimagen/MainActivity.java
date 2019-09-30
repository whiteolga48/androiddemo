package com.mariusapps.textoenunimagen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    ImageView imageView ;
    EditText editText;
    Button button;
    TextView textView;


    //https://blog.uptech.team/how-to-create-beautiful-text-stickers-for-android-10eeea0cee09

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView3);




        //to get screen width and hight
//        DisplayMetrics displaymetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

//        String  mensaje= "Adiosssss";
//

        String mensaje = editText.getText().toString();
        textView.setText(mensaje);
        Log.d("**", mensaje);


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
           public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
               switch (actionId){
                    case EditorInfo.IME_ACTION_DONE:
                    case EditorInfo.IME_ACTION_NEXT:
                   case EditorInfo.IME_ACTION_PREVIOUS:

//                       drawCenter();

                       return true;                }
               return false;
            }
        });
    }

//    private void DibujarTextoEnImagen() {
//        String mensaje = editText.getText().toString();
//        textView.setText(mensaje);
//
//
//        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.green);
//        int width = bm.getWidth();
//        int height = bm.getHeight();
//        Bitmap newImage = Bitmap.createBitmap(width, height, config);
//
//        Canvas lienzo = new Canvas(newImage);
//        lienzo.drawBitmap(bm, 0, 0, null);
//
//
//        // Initialize a new Paint instance to draw the text
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(getResources().getColor(android.R.color.white));
//        paint.setTextSize(64);
//
//        int xPos = (lienzo.getWidth() / 2);
//        int yPos = (int) ((lienzo.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2)) ;
//        lienzo.drawText(mensaje, xPos, yPos, paint);
//
//
////
//        paint.setTextAlign(Paint.Align.CENTER);
//        imageView.setImageBitmap(newImage);
//
//
//
//    }

    private Rect r = new Rect();

    private void drawCenter(Canvas canvas, Paint paint, String text) {

        String mensaje = editText.getText().toString();

        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(mensaje, x, y, paint);
    }


    private Bitmap getScreenViewBitmap(View relativeLayout) {

//        relativeLayout = findViewById(R.id.IdlinearLayout);
        relativeLayout.setDrawingCacheEnabled(true);
        relativeLayout.buildDrawingCache(true);
        // creates immutable clone
        Bitmap b = Bitmap.createBitmap(relativeLayout.getDrawingCache());
        relativeLayout.setDrawingCacheEnabled(false);

    }
}
