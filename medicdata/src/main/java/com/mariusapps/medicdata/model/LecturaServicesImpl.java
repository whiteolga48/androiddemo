package com.mariusapps.medicdata.model;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import static android.content.ContentValues.TAG;

public class LecturaServicesImpl implements LecturaServices {

    private static final Map<Integer,Lectura> LECTURAS;

    private static  final LecturaServicesImpl INSTANCE = new LecturaServicesImpl();

    static {

        // treemap para orden natural
        LECTURAS = new TreeMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY/ HH:mm:ss", Locale.getDefault() );

        Date fecha0 =null;
        Date fecha1= null;
        Date fecha2= null;
        Date fecha3= null;
        Date fecha4= null;
        Date fecha5= null;
        Date fecha6= null;
        Date fecha7= null;
        Date fecha8= null;
        Date fecha9= null;


        try {
            fecha0 = sdf.parse("01/01/2019 01:20:10");

            Log.d( "**","fecha"+ fecha0.toString() );
            fecha1 = sdf.parse("02/01/2019 12:17:22");
            fecha2 = sdf.parse("03/01/2019 5:20:32");
            fecha3 = sdf.parse("04/01/2019 04:45:05");
            fecha4 = sdf.parse("05/01/2019 08:35:10");
            fecha5 = sdf.parse("06/01/2019 02:55:11");
            fecha6 = sdf.parse("07/01/2019 04:45:14");
            fecha7 = sdf.parse("08/01/2019 07:48:21");
            fecha8 = sdf.parse("09/01/2019 09:27:22");
            fecha9 = sdf.parse("01/01/2019 11:20:50");
        } catch (ParseException e) {
            e.printStackTrace();
        }



        Lectura l0 = new Lectura(fecha0,97.6,91.2,105.3,41.390205, 2.154007);
        Lectura l1 = new Lectura(fecha1,95.3,90.5,102.7,41.390205, 2.154007);
        Lectura l2 = new Lectura(fecha2,94.1,90.3,102.9,41.390205, 2.154007);
        Lectura l3 = new Lectura(fecha3,94.4,91.1,103.3,41.390205, 2.154007);
        Lectura l4 = new Lectura(fecha4,93.5,92.8,104.5,41.390205, 2.154007);
        Lectura l5 = new Lectura(fecha5,93.9,90.7,104.7,41.390205, 2.154007);
        Lectura l6 = new Lectura(fecha6,93.5,91.9,105.1,41.390205, 2.154007);
        Lectura l7 = new Lectura(fecha7,93.6,92.0,101.6,41.390205, 2.154007);
        Lectura l8 = new Lectura(fecha8,92.9,94.1,103.2,41.390205, 2.154007);
        Lectura l9 = new Lectura(fecha9,92.0,92.5,102.9,41.390205, 2.154007);



        l0.setCodigo(100);
        l1.setCodigo(101);
        l2.setCodigo(102);
        l3.setCodigo(103);
        l4.setCodigo(104);
        l5.setCodigo(105);
        l6.setCodigo(106);
        l7.setCodigo(107);
        l8.setCodigo(108);
        l9.setCodigo(109);

        Log.d( "****", "Lectura " +l0 );

        LECTURAS.put(l0.getCodigo(),l0);
        LECTURAS.put(l1.getCodigo(),l1);
        LECTURAS.put(l2.getCodigo(),l2);
        LECTURAS.put(l3.getCodigo(),l3);
        LECTURAS.put(l4.getCodigo(),l4);
        LECTURAS.put(l5.getCodigo(),l5);
        LECTURAS.put(l6.getCodigo(),l6);
        LECTURAS.put(l7.getCodigo(),l7);
        LECTURAS.put(l8.getCodigo(),l8);
        LECTURAS.put(l9.getCodigo(),l9);


    }



    private LecturaServicesImpl(){


    }


    public  static  LecturaServicesImpl getInstance(){

        return INSTANCE;

    }

    @Override
    public Lectura create(Lectura lectura) {

        // hemos de calcular el nuevo código...
        Integer maxCode = ((TreeMap<Integer,Lectura> )LECTURAS).lastKey();
        Integer newCode = maxCode++;
        lectura.setCodigo(newCode);
        return LECTURAS.put(lectura.getCodigo(),lectura);
    }

    @Override
    public Lectura read(Integer codigo) {
        return LECTURAS.get(codigo);
    }

    @Override
    public Lectura update(Lectura lectura) {


        boolean lecturaExiste = LECTURAS.containsKey((lectura.getCodigo()));

        if (lectura.getCodigo() == null || !lecturaExiste){

           // throw new ilegaal .......

        }


        return LECTURAS.put(lectura.getCodigo(),lectura);
    }

    @Override
    public boolean delete(Integer codigo) {

        Lectura lectura = LECTURAS.remove(codigo);



        return lectura == null? false:true;
    }

    @Override
    public List<Lectura> getAll() {




        return new ArrayList<Lectura>(LECTURAS.values());
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2) {

        List<Lectura > lecturas = new ArrayList<>();

      for (Lectura lectura: getAll()){

          Date fechaHora = lectura.getFechaHora();

          if (fechaHora.after(fecha1)&& fechaHora.before(fecha2)){


              lecturas.add(lectura);

          }



      }


        return null;
    }
}
