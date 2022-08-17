package br.com.sistema.logistica.poc.util;

import java.util.Calendar;

public class DateUtil {

    private DateUtil(){

    }

    public  static String getInicioAnoVigente(){
        return getAno().toString()+"-01-01";
    }

    public  static String getFinalAnoVigente(){
         return getAno().toString()+"-12-31";
    }

    private static Integer getAno(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
