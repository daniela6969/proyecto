package edu.galileo.android.moviemanager.models;

import java.util.ArrayList;
import java.util.List;

import edu.galileo.android.moviemanager.fragments.NowPlayingFragment;

public class ProductoRepository {
    Producto producto;

    public static ArrayList<Producto> imageMovieArrayList= new ArrayList<Producto>();


    public  ProductoRepository() {
        if(producto==null){
            producto=new Producto();
        }

    }


    public Producto getProducto() {
        return producto;
    }


    public static void initializeData() {
        imageMovieArrayList.removeAll(getImageMovieArrayList());


        imageMovieArrayList.add(new Producto(1,"PIZZA"," NUEVA 6 QUESOS",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1539278104.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1539278104.png",
                "N",10,"20"));

        imageMovieArrayList.add(new Producto(2,"PIZZA"," NEW YORK NEW YORK",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127478.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127478.png",
                "N",10,"20"));
        imageMovieArrayList.add(new Producto(3,"PIZZA"," HAWAIIAN",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127520.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127520.png",
                "N",10,"20"));
        imageMovieArrayList.add(new Producto(4,"PIZZA","CHICKEN BACON RANCH",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127534.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127534.png",
                "N",10,"20"));
        imageMovieArrayList.add(new Producto(5,"PIZZA"," CHICKEN BBQ",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127554.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127554.png",
                "N",10,"20"));
        imageMovieArrayList.add(new Producto(6,"PIZZA"," VEGETARIANA",2.6,120.0
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127567.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127567.png",
                "N",10,"20"));
        imageMovieArrayList.add(new Producto(7,"PIZZA"," POMODORO",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127578.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127578.png",
                "N",10,"20"));
        imageMovieArrayList.add(new Producto(8,"PIZZA","BOOM DE JAMÓN",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127589.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127589.png",
                "N",10,"20"));
        imageMovieArrayList.add(new Producto(9,"PIZZA"," CAMPESTRE",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127600.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127600.png",
                "N",10,"20"));
        imageMovieArrayList.add(new Producto(10,"PIZZA","  ALL THE MEATS",2.6,14.99
                ,"https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127638.png",
                "https://www.papajohns.com.ec/media/restaurantes/4/menu/1558127638.png",
                "N",10,"20"));
    }


    public static ArrayList<Producto> getImageMovieArrayList() {
        return imageMovieArrayList;
    }
}
