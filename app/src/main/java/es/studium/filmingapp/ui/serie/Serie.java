package es.studium.filmingapp.ui.serie;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.Caratula;
import es.studium.filmingapp.DescripcionPelicula;
import es.studium.filmingapp.DescripcionSerie;
import es.studium.filmingapp.LayoutAdapterPeliculas;
import es.studium.filmingapp.LayoutAdapterSeries;
import es.studium.filmingapp.R;
import es.studium.filmingapp.SeriePOJO;
import es.studium.filmingapp.rowClickListener;

public class Serie extends Fragment {

    private SerieViewModel mViewModel;

    public static Serie newInstance() {
        return new Serie();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista  = inflater.inflate(R.layout.serie_fragment, container, false);
        setupRecyclerViewPelicula(vista);
        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SerieViewModel.class);
        // TODO: Use the ViewModel
    }
    private void setupRecyclerViewPelicula(View vista)
    {
        RecyclerView recyclerViewSerie = (RecyclerView) vista.findViewById(R.id.recyclerViewSerie);
        final List<SeriePOJO> series = buildSeries();
        recyclerViewSerie.setAdapter(new LayoutAdapterSeries(series, new rowClickListener() {
            @Override
            public void onClick(View v, int position, ImageView img, TextView titulo) {
                if (v.equals(img))
                {
                    Intent inte = new Intent(getContext(), Caratula.class);
                    inte.putExtra("img", series.get(position).getCaratula());
                    startActivity(inte);
                }
                if (v.equals(titulo))
                {
                    Intent intent = new Intent(getContext(),DescripcionSerie.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("serie",series.get(position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        }));
        //  String text = position + " " + peliculas.get(position).getTitulo();
        // Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
        //VERTICAL
        recyclerViewSerie.setLayoutManager(new LinearLayoutManager(getContext()));
        //HORIZONTAL
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewSerie.getContext(),((LinearLayoutManager) recyclerViewSerie.getLayoutManager()).getOrientation());
        recyclerViewSerie.addItemDecoration(dividerItemDecoration);

    }
    @NonNull
    private List<SeriePOJO> buildSeries()
    {
        List<SeriePOJO> series = new ArrayList<>();
        series.add(new SeriePOJO(R.drawable.berserk,getString(R.string.tituloBerserk),getString(R.string.directorBerserk),getString(R.string.repartoBerserk),3,getString(R.string.sinopsisBerserk),2));
        series.add(new SeriePOJO(R.drawable.dragonball,getString(R.string.tituloDragonBall),getString(R.string.directorDragonBall),getString(R.string.repartoDragonBall),3,getString(R.string.sinopsisDragonBall),9));
        series.add(new SeriePOJO(R.drawable.kimetsu,getString(R.string.tituloKimetsu),getString(R.string.directorKimetsu),getString(R.string.repartoKimetsu),3,getString(R.string.sinopsisKimetsu),2));
        series.add(new SeriePOJO(R.drawable.mod,getString(R.string.tituloMob),getString(R.string.directorMob),getString(R.string.repartoMob),3,getString(R.string.sinopsisMob),2));
        series.add(new SeriePOJO(R.drawable.myhero,getString(R.string.tituloMyHero),getString(R.string.directorMyHero),getString(R.string.repartoMyHero),3,getString(R.string.sinopsisMyHero),5));
        series.add(new SeriePOJO(R.drawable.naruto,getString(R.string.tituloNaruto),getString(R.string.directorNaruto),getString(R.string.repartoNaruto),3,getString(R.string.sinopsisNaruto),3));
        series.add(new SeriePOJO(R.drawable.onepiece,getString(R.string.tituloOnePiece),getString(R.string.directorOnePiece),getString(R.string.repartoOnePiece),3,getString(R.string.sinopsisOnePiece),10));
        series.add(new SeriePOJO(R.drawable.onepuchman,getString(R.string.tituloOnePunch),getString(R.string.directorOnePunch),getString(R.string.repartoOnePunch),5,getString(R.string.sinopsisOnePunch),2));
        series.add(new SeriePOJO(R.drawable.singeki,getString(R.string.tituloSingeki),getString(R.string.directorSingeki),getString(R.string.repartoSingeki),5,getString(R.string.sinopsisSingeki),2));

        return series;
    }

}