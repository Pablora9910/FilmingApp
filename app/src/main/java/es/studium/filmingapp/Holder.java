package es.studium.filmingapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder implements  View.OnClickListener{
    private final ImageView imgCaratula;
    private final TextView titulo;
    private final rowClickListener listener;

    public Holder(@NonNull View itemView, rowClickListener listener) {
        super(itemView);
        imgCaratula = itemView.findViewById(R.id.imgView);
        titulo = itemView.findViewById(R.id.titulo);
        this.listener = listener;
        imgCaratula.setOnClickListener(this);
        titulo.setOnClickListener(this);
    }
    public void binRowPelicula(@NonNull PeliculaPOJO pelicula)
    {
        titulo.setText(pelicula.getTitulo());
        imgCaratula.setImageResource(pelicula.getCaratula());
    }

    public void binRowSerie(@NonNull SeriePOJO serie)
    {
        titulo.setText(serie.getTitulo());
        imgCaratula.setImageResource(serie.getCaratula());
    }


    @Override
    public void onClick(View v) {
        listener.onClick(v,getAdapterPosition(), imgCaratula,titulo);

    }


}
