package com.mariusapps.fragmentshelloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private final int[] BOTONES_MENU={R.id.boton1, R.id.boton2,R.id.boton3};

    public MenuFragment() {
        // Required empty public constructor
    }

    // Bundle nos permite pasar o ricibir datos de un sitio a otro

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        ImageButton botonMenu;

        for(int i = 0; i < BOTONES_MENU.length; i++){

            // almacenamos en botonMenu todos y cada unos de los botones...

            botonMenu = (ImageButton) miMenu.findViewById(BOTONES_MENU[i]);

            final int queBoton = i;

            botonMenu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // Hemos de detectar en que actividad nos encontramos...
                    Activity estaActividad = getActivity();

                    //Hay que enviar la información al interface ComunicaMenu
                    Log.d("**","pulsamos y enviamos info del boton: " + queBoton);
                    ((ComunicaMenu) estaActividad).menu(queBoton);

                }
            });

        }


        return miMenu;
    }

}