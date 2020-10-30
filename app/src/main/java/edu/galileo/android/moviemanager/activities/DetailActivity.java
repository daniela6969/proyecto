package edu.galileo.android.moviemanager.activities;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import edu.galileo.android.moviemanager.fragments.carrito;
import edu.galileo.android.moviemanager.models.Producto;

import static edu.galileo.android.moviemanager.R.*;
//import edu.galileo.android.moviemanager.models.Producto;

public class DetailActivity extends AppCompatActivity {

    static Producto producto;
    @BindView(id.ivMovieBackdrop)
    ImageView ivMovieBackdrop;
    @BindView(id.tvOverview)
    TextView tvOverview;
    @BindView(id.imagenJuego)
    ImageView imagenJuego;

    Context context;
    carrito carrritoC;
    static List<Producto> listaCarrito = new ArrayList<Producto>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_game_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = findViewById(id.fab);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();

        //obtiene los datos del Inten
        obtenerDatos(extras);

        //Para que se cambien los iconos
        cambiarIcono(fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              if(validaRepetido()){
                  listaCarrito.remove(producto);
                  fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color.colorAccent)));
                  fab.setImageResource(drawable.ic_add_black_24dp);
                  //fab.setBackgroundColor(123456);
                  Snackbar.make(view, " retirado del carrito de compras", Snackbar.LENGTH_LONG).setAction("Action", null).show();

              }
              else{
                  listaCarrito.add(producto);
                  fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color.colorNegro)));
                  fab.setImageResource(drawable.ic_remove_black_24dp);
                  //fab.setBackgroundColor(123456);
                  Snackbar.make(view, "agregado al carrito de compras", Snackbar.LENGTH_LONG).setAction("Action", null).show();

              }


            }


        });

    }

    public void cambiarIcono(FloatingActionButton fab){
        if(validaRepetido()){
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color.colorRojo)));
            fab.setImageResource(drawable.ic_remove_black_24dp);
            //fab.setBackgroundColor((int)color.colorRojo);

        }else{
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color.colorAccent)));
            fab.setImageResource(drawable.ic_add_black_24dp);
            //fab.setBackgroundColor((int)color.colorAzul);


        }
    }
    //Obtener Datos
    public void obtenerDatos(Bundle extras){
        if (extras != null) {
            producto = (Producto) extras.getSerializable("MOVIE");
            this.setTitle(producto.getTitle());
            tvOverview.setText(producto.getShortdesc());
            ObtenerImagenes(context,imagenJuego,producto.getUrl_image());
            ObtenerImagenes(context,ivMovieBackdrop,producto.getUrl_imagen_poster());

        }
    }

    //valida producto repetido
    public boolean validaRepetido(){
        for(Producto listaNew:getListaCarrito()){
            if(listaNew.getId()==(producto.getId())){
                return true;
            }
        }
        return false;
    }

    //Obtine las imagenes
    public void ObtenerImagenes(Context contex,ImageView ivPoster,String recurso){
        if (recurso.isEmpty()) { //url.isEmpty()
            Picasso.with(context)
                    .load(drawable.notfound)
                    .placeholder(drawable.notfound)
                    .error(drawable.notfound)
                    .into(ivPoster);

        }else{
            Picasso.with(context)
                    .load(recurso)
                    .error(drawable.tenor)
                    .placeholder(drawable.tenor)
                    .into(ivPoster); //this is your ImageView
        }

    }
    //Obtenemos la lista Carrito
    public static List<Producto> getListaCarrito() {
        return listaCarrito;
    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        onPostResume();
        return true;
    }




}
