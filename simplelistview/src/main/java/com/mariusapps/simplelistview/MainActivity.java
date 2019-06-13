package com.mariusapps.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView listView;

    Integer [] numeros = new Integer[]{

            1,2,2,5,125,52,52,
            644,522,60000,25,2520,352,675,88


    };

    String [] valores = new String[]
            {"Pepe", "Ana","jose","Andrés","Mario","Francisco","Nines","Rosa",
            "Andreu","Marta","Maria","Jose Andrés","Marina","Maribble","Isa","Cisco"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.lv_listview);

       // ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,numeros);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,valores);

        listView.setAdapter(adapter);



    }
}
