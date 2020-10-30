package edu.galileo.android.moviemanager.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.DetailActivity;
import edu.galileo.android.moviemanager.adapters.RecyclerViewAdapter;
import edu.galileo.android.moviemanager.adapters.RecyclerViewAdapterFact;
import edu.galileo.android.moviemanager.models.Producto;
import edu.galileo.android.moviemanager.models.metodo;


public class facturaFragment extends Fragment {


    metodo met = new metodo();

    @BindView(R.id.rvJuegos)
    RecyclerView rvJuegos;
    @BindView(R.id.txtTotal)
    TextView txtTotal;
    @BindView(R.id.txtDesceuntos)
    TextView txtDesceuntos;
    @BindView(R.id.txtIva)
    TextView txtIva;
    @BindView(R.id.txtTotalPagar)
    TextView txtTotalPagar;
    @BindView(R.id.idNitems)
    TextView idNitems;

   /* @BindView(R.id.search)
    SearchView searchView;*/

    DecimalFormat formateador = new DecimalFormat("####.####");
    DecimalFormat formateador1 = new DecimalFormat("####.##");
    private double totalIva = 0.0;

    private RecyclerViewAdapter adapter;
    // private List<Movie> movies;
    public static ArrayList<Producto> imageMovieArrayList2= new ArrayList<Producto>();

    public facturaFragment() {
        // Required empty public constructor
    }

    // @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_factura, container, false);
        ButterKnife.bind(this, view);
        //ProductoRepository.initializeData();
        //CargarLista();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvJuegos.setHasFixedSize(true);
        rvJuegos.setLayoutManager(llm);

        RecyclerViewAdapterFact adapter = new RecyclerViewAdapterFact(this.getContext(), DetailActivity.getListaCarrito());
        rvJuegos.setAdapter(adapter);

        idNitems.setText(String.valueOf(DetailActivity.getListaCarrito().size()));
        txtTotal.setText(Obtener_SubTotal());
        txtDesceuntos.setText("- "+Obtener_TotalDescuestos());
        txtDesceuntos.setTextColor(Color.parseColor("#ff0000"));
        txtIva.setText(""+Obtener_Iva());
        txtTotalPagar.setText(Obtener_TotalFactura());

        return view;
    }

    //Calcula la factura
    public String Obtener_TotalFactura() {
        String result = "";
        double total = 0.0;
        double t = 0.0;
        for (Producto listaJuegos : DetailActivity.getListaCarrito()) {
            if (listaJuegos.getOferta().contains("N")) {
                total = total + listaJuegos.getPrice();
            } else {
                total = total + Double.parseDouble(listaJuegos.getPrecioDescuento());
            }
        }

        t = total + met.converDouble(Obtener_TotalFactura1());

        return result=formateador.format (t);
    }

    public String Obtener_TotalFactura1() {
        String result = "";
        double total = 0.0;
        for (Producto listaJuegos : DetailActivity.getListaCarrito()) {
            if (listaJuegos.getOferta().contains("N")) {
                total = total + listaJuegos.getPrice();
            } else {
                total = total + Double.parseDouble(listaJuegos.getPrecioDescuento());
            }
        }
        return ""+total;
    }

    //Calcula la factura
    public String Obtener_TotalDescuestos() {
        String results = "";
        double descuestos=0.0;

        for (Producto listaJuegos : DetailActivity.getListaCarrito()) {
            if (listaJuegos.getOferta().contains("S")) {
                descuestos = descuestos + ( listaJuegos.getPrice()-Double.parseDouble(listaJuegos.getPrecioDescuento()));
            }
        }
        return results=formateador.format (descuestos);
    }

    public String Obtener_Iva() {

        return met.convertir(Obtener_TotalFactura1());
    }

    //Calcula la factura
    public String Obtener_SubTotal() {
        double total = 0.0;
        String results = "";

        for (Producto listaJuegos : DetailActivity.getListaCarrito()) {
            total = total + listaJuegos.getPrice();
        }
        return results=formateador.format (total);
    }

}