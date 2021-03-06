package edu.galileo.android.moviemanager.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.DetailActivity;
//import edu.galileo.android.moviemanager.fragments.NowPlayingFragment;
//import edu.galileo.android.moviemanager.models.Movie;
import edu.galileo.android.moviemanager.models.Producto;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Producto> productos;
    Context context;
    //Array para el filtro
   /* public static ArrayList<Producto> imageModelArrayList= new ArrayList<Producto>();
    private ArrayList<Producto> arraylist;*/



    public RecyclerViewAdapter(Context context, List<Producto> movies){
        this.productos = movies;
        this.context = context;

    }

    private Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(v);
    }

    public boolean pintarCR(Producto producto){
            for(Producto pintarProducto:DetailActivity.getListaCarrito()){
             if(pintarProducto.getTitle().equals(producto.getTitle())){
                return true;
             }
            }
            return false;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Producto producto = productos.get(position);
        //cambio de color


        holder.txtTitulo.setText(producto.getTitle());
        holder.txtDescripcion.setText(producto.getShortdesc());
        holder.textViewRating.setText(String.valueOf(producto.getRating()));
        //holder.ratingBar.setNumStars((int)producto.getRating());
        holder.ratingBar.setRating((float) producto.getRating());
        if(producto.getOferta().contains("S")){

            //Normal
            holder.txtPrecio.setText(String.valueOf(producto.getPrecioDescuento()));
            holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));
            //Tachado
            holder.textPrecioDescuento.setPaintFlags(holder.textPrecioDescuento.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);

            //descuesto
            holder.textViewPrice_s2.setText("$");
            holder.textViewPrice_s2.setTextColor(Color.parseColor("#c0c0c0"));
            holder.textPrecioDescuento.setText(String.valueOf(producto.getPrice()));
            holder.textPrecioDescuento.setTextColor(Color.parseColor("#c0c0c0"));
            //holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));

        }else{
            holder.txtPrecio.setText(String.valueOf(producto.getPrice()));
        }

        ObtenerImagenes(producto,holder);
       


    }



    //Obtener Imagenes
    public void ObtenerImagenes(Producto producto,ViewHolder holder){
        if (producto.getUrl_image().isEmpty()) { //url.isEmpty()
            Picasso.with(context)
                    .load(R.drawable.notfound)
                    .placeholder(R.drawable.notfound)
                    .error(R.drawable.notfound)
                    .into(holder.imPortada);

        }else{
            Picasso.with(context)
                    .load(producto.getUrl_image())
                    .error(R.drawable.tenor)
                    .placeholder(R.drawable.tenor)
                    .into(holder.imPortada); //this is your ImageView
        }

    }


    @Override
    public int getItemCount() {
        return productos.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.ivMovieImage)
        ImageView imPortada;
        @BindView(R.id.textViewTitle)
        TextView txtTitulo;
        @BindView(R.id.textViewShortDesc)
        TextView txtDescripcion;
        @BindView(R.id.textViewPrice)
        TextView txtPrecio;
        @BindView(R.id.textViewRating)
        TextView textViewRating;
        @BindView(R.id.cvMovie)
        CardView cvMovie;
        @BindView(R.id.textPrecioDescuento)
        TextView textPrecioDescuento;
        @BindView(R.id.textOferta)
        TextView textOferta;
        @BindView(R.id.textViewPrice_s2)
        TextView textViewPrice_s2;
        @BindView(R.id.myRatingBar)
        RatingBar ratingBar;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Producto movie = productos.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra("MOVIE", movie);
            getContext().startActivity(intent);

        }
    }


}
