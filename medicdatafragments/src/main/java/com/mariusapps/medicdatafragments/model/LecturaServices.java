package com.mariusapps.medicdatafragments.model;

import java.util.Date;
import java.util.List;

public interface LecturaServices {
    Lectura create(Lectura lectura);

    Lectura read(Integer codigo);

    Lectura update(Lectura lectura);

    boolean delete(Integer codigo);

    List<Lectura> getAll();

    List<Lectura> getBetweenDates(Date fecha1, Date fecha2);
}
