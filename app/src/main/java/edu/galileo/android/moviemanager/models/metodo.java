package edu.galileo.android.moviemanager.models;

import java.text.DecimalFormat;

public class metodo {

    DecimalFormat formateador1 = new DecimalFormat("####.##");

    public String convertir (String x){
        String conver = String.valueOf(x);
        Double dd = Double.parseDouble(conver);
        String results = "";
        Double total = 0.0;
        total = dd * 0.12;

        return results=formateador1.format (total);
    }

    public Double converDouble (String x){
        String conver = String.valueOf(x);
        Double dd = Double.parseDouble(conver);
        String results = "";
        Double total = 0.0;
        total = dd * 0.12;

        return total;
    }
}
