package com.mariusapps.sqlitehelloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public  static final String DATABASE_NAME = "amigos.db";

    public static final String AMIGOS_TABLE = "AMIGOS";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOMBRE";
    public static final String COL_3 = "APELLIDO1";
    public static final String COL_4 = "APELLIDO2";


    // contrucutor que recibe el contexto , nombre base de datos, fábrica de cursores, version de la base de datos)
    public DatabaseHelper( Context context) {
        super(context,DATABASE_NAME , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // ESTE METODO ES INVOCADO CUANDO SE CREA LA BASE DE DATOS POR PRIMERA VEZ de forma automatica
        // Se tendrá que ejecutar una sentencia de DDL (DATA DEFINITION LANGUAJE)

        // se entra caundo se llama al metodo getWritableDatabase


        StringBuilder strSQL = new StringBuilder();

        strSQL.append("CREATE TABLE ")
                .append(AMIGOS_TABLE).append(" (")
                .append(COL_1).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(COL_2).append(" TEXT NOT NULL, ")
                .append(COL_3).append(" TEXT NOT NULL, ")
                .append(COL_4).append(" TEXT)");

        Log.d("******", strSQL.toString());

        db.execSQL(strSQL.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // ENTRAMOS AQUI CUANDO SE DETECTA UN CAMBIO DE VERSION
        // NORMALMENTE ESTO CONLLEVA LA CREACIÓN DE NUEVAS TABLAS O COLUMNAS EN
        // TABLAS YA EXIXTENTES
        // drop table elimina la tabala y onCreate() vuelve a crear el esquema desde cero

        db.execSQL("DROP TABLE IF EXISTS " + AMIGOS_TABLE );

        onCreate(db);

    }

    // MÉTODOS PARA REALIZAR OPERACIONES CRUD

    public boolean insertData(String nombre, String apellido1, String apellido2){

        SQLiteDatabase db = this.getWritableDatabase();

        // 3 manewrAS DE OBTENER EL NOMBRE DE LA BASE DE DATOS

        //String nombreBaseDatos


        // contenedor de valores
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,nombre);
        contentValues.put(COL_3,apellido1);
        contentValues.put(COL_4,apellido2);


       long resultado=  db.insert(AMIGOS_TABLE, null, contentValues);

       // si resultado es = -1  es que algo ha ido mal
        // si resultado es>= 0 nos indica el numero de registros afectados


        return resultado == -1 ? false:true;

    }



    public Cursor getAll(){

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + AMIGOS_TABLE,null);

        return cursor;

        /*
            QUE ES SELECTIONARGS?
            ES UN ARRARY DSTRINGS
            EN LA CONSULTA PUEDEN HABER ?S  QUE SERÁN SUSTITUIDOS POR LOS VALORES DE ESTE

            EJEMPLO:

            SELECT * FROM AMIGOS WHERE nombres = ? AND apellidi1 LIKE ?%

            String []

         */


    }



}
