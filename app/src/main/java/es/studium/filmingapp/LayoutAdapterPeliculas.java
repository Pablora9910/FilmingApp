package es.studium.filmingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LayoutAdapterPeliculas extends RecyclerView.Adapter<Holder> {

    private final List<PeliculaPOJO> peliculas;
    private final rowClickListener listener;

    public LayoutAdapterPeliculas(List<PeliculaPOJO> peliculas, rowClickListener listener) {
        this.peliculas = peliculas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new Holder(row,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binRowPelicula(peliculas.get(position));
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }
}
