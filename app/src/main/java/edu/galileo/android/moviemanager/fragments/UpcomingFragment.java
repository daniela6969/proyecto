package edu.galileo.android.moviemanager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.adapters.RecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Producto;
import edu.galileo.android.moviemanager.models.ProductoRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Producto> ListaOfertas = new ArrayList<>();



    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);

        ButterKnife.bind(this, view);

        //carga los datos
       // ProductoRepository.initializeData();
        initializeData();

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this.getContext(), ListaOfertas);
        rvMovies.setAdapter(adapter);

        return view;
    }


    //carga la lista de ofertas
    private void initializeData() {
        ListaOfertas.removeAll(ListaOfertas);
        for(Producto listaJuegos: ProductoRepository.getImageMovieArrayList()){
            if(listaJuegos.getOferta().contains("S")){
                //listaJuegos.setPrecioDescuento(String.valueOf(listaJuegos.getPrice()-(listaJuegos.getPrice()*listaJuegos.getDescuento()/100)));
                listaJuegos.setPrecioDescuento(String.valueOf(listaJuegos.getPrice()-(listaJuegos.getDescuento())));
                //listaJuegos.setDescuento(listaJuegos.getDescuento()/100);
                ListaOfertas.add(listaJuegos);
            }

        }
    }

}
