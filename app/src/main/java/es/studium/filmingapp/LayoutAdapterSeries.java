package es.studium.filmingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LayoutAdapterSeries extends RecyclerView.Adapter<Holder>{
    private final List<SeriePOJO> series;
    private final rowClickListener listener;

    public LayoutAdapterSeries(List<SeriePOJO> series, rowClickListener listener) {
        this.series = series;
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
        holder.binRowSerie(series.get(position));
    }

    @Override
    public int getItemCount() {
        return series.size();
    }
}
