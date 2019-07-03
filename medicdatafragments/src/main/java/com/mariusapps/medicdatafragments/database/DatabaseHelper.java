package com.mariusapps.medicdatafragments.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mariusapps.medicdatafragments.model.Lectura;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MEDICDATA"; // nombre base de datos
    private static final String LECTURAS_TABLE = "LECTURAS"; // nombre de la tabla

    private SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private static final String COL_0 = "CODIGO";
    private static final String COL_1 = "FECHA_HORA";
    private static final String COL_2 = "PESO";
    private static final String COL_3 = "DIASTOLICA";
    private static final String COL_4 = "SISTOLICA";
    private static final String COL_5 = "LONGITUD";
    private static final String COL_6 = "LATITUD";

    // constructor tiene que pasarle a su papa el contexto, nombre de la BASE DE DATOS, FACTIRIA DE CURSORES, VERSION NUMERO )

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /*  CREATE TABLE LECTURAS(
           0     CODIGO      INTEGER PRIMARY KEY AUTOINCREMENT,
           1     FECHA_HORA  TEXT NOT NULL,
           2     PESO        REAL NOT NULL,
           3     DIASTOLICA  REAL NOT NULL,
           4     SISTOLICA   REAL NOT NULL,
           5     LONGITUD    REAL,
           6     LATITUD     REAL) */

        // CREAMOS EL ESQUEMA DE LA TABLA O DE LAS TABLAS

        // AQUI HAY DDL Y TAMBIEN DML (SI QUEREMOS QUE HAYAN DATOS EN LAS TABLAS )

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + LECTURAS_TABLE + " (")
                .append(COL_0).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(COL_1).append(" TEXT NOT NULL, ")
                .append(COL_2).append(" REAL NOT NULL, ")
                .append(COL_3).append(" REAl NOT NULL, ")
                .append(COL_4).append(" REAL NOT NULL, ")
                .append(COL_5).append(" REAL, ")
                .append(COL_6).append(" REAL)");

        String strDDL = sb.toString();




        db.execSQL(strDDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        // aqui escribiremos la lógica cuando tengamos que actualizar

        // este upgrade sera diferente para cada situación, por ejemplo en el paso de la version 1 a 2 se requiere una columna nueva

        // en el paso de la 2 a las 3 se requiere una tabla nueva , con datos

        // db.execSQL("DROP TABLE IF EXISTS " + LECTURAS_TABLE); // esto borrar todos los datos
        //onCreate(db);
    }



    //Métodos para ser consumidos por otras clases

    public Lectura createLectura(Lectura lectura){
        SQLiteDatabase db = getWritableDatabase();  // a travers de db puedo hacer operaciones
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, getStringFromDate(lectura.getFechaHora())); // recibe un date y devuelve un string formateado como fecha
        contentValues.put(COL_2, lectura.getPeso());
        contentValues.put(COL_3, lectura.getDiastolica()); // columna y dato extraido de lectura
        contentValues.put(COL_4, lectura.getSistolica());
        contentValues.put(COL_5, lectura.getLongitud());
        contentValues.put(COL_6, lectura.getLatitud());


        // NULL COLUM HACK SE UTILIZA SI PRETENDRENOS INSERTAR UN REGISTRO
        // CON VALOREL NULL. EN ESTE CASO CONTENT VALUES ESTARÁ VACIO SIN PUT

        long resultado = db.insert(LECTURAS_TABLE,null,contentValues);  //Insertar

        // INSERT NOS DEVUELBE UN LONG ... LA ID DEL REGISTRO QUE ACABA DE GENERQAR

        // 0-1 SI ALGO HA IDO MAL.....

        // a la lectura que nos llegaba sin codigo le asignamos su código y la devolvemos
        lectura.setCodigo((int) resultado);


        Log.d("******","Vamos a dar de alta: " + lectura.toString());
        return resultado == -1 ? null: lectura;
    }


    /*public void  createLectura(double peso,
                               double diastolica,
                               double sistolica,
                               Date fechaHora,
                               double longitud,
                                double latitud)

    return null;*/

    public List<Lectura> getAll(){

        String query = "SELECT  * FROM " + LECTURAS_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        List<Lectura> lecturas = new ArrayList<Lectura>();

        if (cursor != null && cursor.getCount() > 0){

            while (cursor.moveToNext()){

                Integer codigo = cursor.getInt(0);
                String strFecha = cursor.getString(1);
                Date fecha = getDateFromString(strFecha);
                double peso = cursor.getDouble(2);
                double diastolica = cursor.getDouble(3);
                double sistolica = cursor.getDouble(4);
                double longitud = cursor.getDouble(5);
                double latitud = cursor.getDouble(6);

                Lectura lectura = new Lectura(fecha,peso,diastolica,sistolica,longitud,latitud);
                lectura.setCodigo(codigo);
                lecturas.add(lectura);

            }




        }

        Log.d("**GetAll**",lecturas.toString());

        return lecturas;
    }

    public Integer deleteLectura(Integer id) {

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(LECTURAS_TABLE, //table name
                COL_0 + " = ?" ,  // selections
                new String[] {Integer.toString(id)});



    }


    public  List<Lectura> getBetweenDates(Date desde, Date hasta){



        return null;
    }


    //**************************************************
    //  Métodos Privados
    //**************************************************

    private String getStringFromDate(Date date){
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return SDF.format(date);

        // recibe date devuelve string
    }

    private Date getDateFromString(String strFecha){
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Date date = null;
        try {
            date = SDF.parse(strFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
        // recibe una string y devuelve una fecha

    }


    public void transferencia (){

        // BEGINGTRANSACTION

        // Leemos saldo  (READ)
        //si saldo cubre importe a transferir....

        // descntamos importe a cuenta origen

        //  int a = 10/0; //petaria

        // incrementamos importe a cuenta Destino


        //ENTRANSTACTON
    }


}
