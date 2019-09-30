package com.mariusapps.simplelistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    ListView listView;
    private String nombres[]={"Pepe", "Ana","jose","Andrés","Mario","Francisco","Nines","Rosa",
            "Andreu","Marta","Maria","Jose Andrés","Marina","Maribble","Isa","Cisco"};
    private String edades[]={"20","25","35","15","26","65","72","49",
                             "50","21","85","18","22","65","69","41"};



    /*Integer [] numeros = new Integer[]{

            1,2,2,5,125,52,52,
            644,522,60000,25,2520,352,675,88


    };




    String [] valores = new String[]
            {"Pepe", "Ana","jose","Andrés","Mario","Francisco","Nines","Rosa",
            "Andreu","Marta","Maria","Jose Andrés","Marina","Maribble","Isa","Cisco"};*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById( R.id.tv1 );
        listView = findViewById(R.id.lv_listview);

       // ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,numeros);
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this,R.layout.item_listview,nombres);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText( "La edad de " + listView.getItemAtPosition( position )+ " es " + edades[position] + " años" );
            }
        } );






    }
}
