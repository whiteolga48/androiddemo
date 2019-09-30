package com.mariusapps.medicdatafragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaLecturasFragment2 extends Fragment {

    ListView lista;
    public ListaLecturasFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view = inflater.inflate(R.layout.activitylistalectura, container, false);

     lista =(ListView) view.findViewById(R.id.lv_lista);
        lista.setAdapter(new Adaptador(getActivity()));

        return view;}







//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        lista = (ListView) view.findViewById(R.id.lv_lista);
//        lista.setAdapter(new Adaptador(getActivity()));
//
//    }

}
