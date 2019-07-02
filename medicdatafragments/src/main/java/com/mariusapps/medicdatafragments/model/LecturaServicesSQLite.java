package com.mariusapps.medicdata.model;

import android.content.Context;

import com.mariusapps.medicdata.database.DatabaseHelper;

import java.util.Date;
import java.util.List;

public class LecturaServicesSQLite implements LecturaServices {


    private Context contexto;
    private DatabaseHelper myDB;

    public LecturaServicesSQLite(Context context){
        this.contexto = context;
        myDB = new DatabaseHelper(contexto);}


    @Override
    public Lectura create(Lectura lectura) {
        return myDB.createLectura(lectura);
    }

    @Override
    public Lectura read(Integer codigo) {
        return null;
    }

    @Override
    public Lectura update(Lectura lectura) {
        return null;
    }

    @Override
    public boolean delete(Integer codigo) {

        //return myDB.dele

        return false;

    }

    @Override
    public List<Lectura> getAll() {
        return myDB.getAll();
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2) {
        return null;
    }
}
