package edu.galileo.android.moviemanager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.adapters.RecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Producto;
import edu.galileo.android.moviemanager.models.ProductoRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {


    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
   /* @BindView(R.id.search)
    SearchView searchView;*/



    private RecyclerViewAdapter adapter;
   // private List<Movie> movies;
    public static ArrayList<Producto> imageMovieArrayList2= new ArrayList<Producto>();

        public void CargarLista(){
            imageMovieArrayList2.removeAll(imageMovieArrayList2);
            for(Producto lista:ProductoRepository.getImageMovieArrayList()){
                if(lista.getOferta().contains
                        ("N")) {
                    imageMovieArrayList2.add(lista);
                }
        }
        }

    public NowPlayingFragment() {
        // Required empty public constructor
    }

   // @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this, view);
        ProductoRepository.initializeData();
        CargarLista();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);


        adapter = new RecyclerViewAdapter(getContext(), imageMovieArrayList2);
        rvMovies.setAdapter(adapter);
    
        return view;
    }






}

