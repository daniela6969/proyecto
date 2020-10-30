package edu.galileo.android.moviemanager.fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.DetailActivity;
import edu.galileo.android.moviemanager.activities.DetailActivityFact;
import edu.galileo.android.moviemanager.adapters.RecyclerViewAdapter;

public class carrito extends Fragment {

    @BindView(R.id.rvMovies)
    RecyclerView rvCarrito;
    @BindView(R.id.my_fabdolar)
    FloatingActionButton  my_fab;


    //Creo mi lista que almacena carrito de compras
    //private static List<Producto> miCarrito;

    //Mi lista de carrito de compras obtenida
   /* public static List<Producto> getMiCarrito() {
        return miCarrito;
    }*/


    public carrito() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_carrito, container, false);

        ButterKnife.bind(this, view);

        //carga los datos
        //initializeData();

        if(verificarListaVacia()){
            my_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorNegro)));

        }else{
            my_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorVerde)));

        }

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvCarrito.setHasFixedSize(true);
        rvCarrito.setLayoutManager(llm);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this.getContext(), DetailActivity.getListaCarrito());
        rvCarrito.setAdapter(adapter);

        //Botón flotante
        my_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(DetailActivity.getListaCarrito().isEmpty()){
                    my_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorNegro)));
                    Snackbar.make(view, "No hay factura ",
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else{
                    /*Snackbar.make(view, "Factura: "+Obtener_factura(),
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();*/
                   my_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorVerde)));
                    Intent intent = new Intent(getContext(), DetailActivityFact.class);
                    getContext().startActivity(intent);


                }
            }
        });
        return view;
    }

    @Override
    public void onResume() {

        super.onResume();
        this.onCreate(null);
    }

    //verificarListaCompra
    public boolean verificarListaVacia(){
        if(DetailActivity.getListaCarrito().isEmpty()){
            return true;
        }
        return false;
    }
    //Cargo los datos
    /*public  void initializeData() {
        miCarrito = new ArrayList<>();
        for(Producto listaJuegos: DetailActivity.getListaCarrito()){
            miCarrito.add(listaJuegos);
        }
    }*/

    //Calcula la factura
   /* public String Obtener_factura() {
        DecimalFormat formateador = new DecimalFormat("####.##");
        String result = "";
        double total = 0.0;
        for (Producto listaJuegos : DetailActivity.getListaCarrito()) {
            if (listaJuegos.getOferta().contains("N")) {
                total = total + listaJuegos.getPrice();
            } else {
                total = total + Double.parseDouble(listaJuegos.getPrecioDescuento());
            }
        }
        return result=(String.valueOf(total));
    }*/



}

