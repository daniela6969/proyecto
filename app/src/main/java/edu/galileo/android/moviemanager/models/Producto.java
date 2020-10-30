package edu.galileo.android.moviemanager.models;


import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable{

    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    private double price;
    private String url_image;
    private String url_imagen_poster;
    private String oferta;
    private int descuento;
    private String precioDescuento;

public Producto(){}


    public Producto(int id, String title, String shortdesc, double rating, double price, String url_image, String url_imagen_poster, String oferta, int descuento, String precioDescuento) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.url_image = url_image;
        this.url_imagen_poster = url_imagen_poster;
        this.oferta = oferta;
        this.descuento = descuento;
        this.precioDescuento = precioDescuento;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getUrl_image() {
        return url_image;
    }

    public String getUrl_imagen_poster() {
        return url_imagen_poster;
    }

    public String getOferta() {
        return oferta;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDescuento() {
        return descuento;
    }

    public String getPrecioDescuento() {
        return precioDescuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setPrecioDescuento(String precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    @Override
    public int hashCode() {

        return id;
    }
}
