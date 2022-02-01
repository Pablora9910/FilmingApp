package es.studium.filmingapp.ui.pelicula;

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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.Caratula;
import es.studium.filmingapp.DescripcionPelicula;
import es.studium.filmingapp.LayoutAdapterPeliculas;
import es.studium.filmingapp.PeliculaPOJO;
import es.studium.filmingapp.R;
import es.studium.filmingapp.rowClickListener;

public class Pelicula extends Fragment  {

    private PeliculaViewModel mViewModel;

    public static Pelicula newInstance() {
        return new Pelicula();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista  = inflater.inflate(R.layout.pelicula_fragment, container, false);
        setupRecyclerViewPelicula(vista);
        return vista;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PeliculaViewModel.class);
        // TODO: Use the ViewModel
    }

    private void setupRecyclerViewPelicula(View vista)
    {
        RecyclerView recyclerViewPeliculas = (RecyclerView) vista.findViewById(R.id.recyclerViewPelicula);
        final List<PeliculaPOJO> peliculas = buildPeliculas();
        recyclerViewPeliculas.setAdapter(new LayoutAdapterPeliculas(peliculas, new rowClickListener() {
            @Override
            public void onClick(View v, int position, ImageView img, TextView titulo) {
                if (v.equals(img))
                {
                    Intent inte = new Intent(getContext(), Caratula.class);
                    inte.putExtra("img", peliculas.get(position).getCaratula());
                    startActivity(inte);
                }
                if (v.equals(titulo))
                {
                    Intent inte = new Intent(getContext(), DescripcionPelicula.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("pelicula", peliculas.get(position));
                    inte.putExtras(bundle);
                    startActivity(inte);
                }
            }
        }));
        //VERTICAL
        recyclerViewPeliculas.setLayoutManager(new LinearLayoutManager(getContext()));
        //HORIZONTAL
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewPeliculas.getContext(),((LinearLayoutManager) recyclerViewPeliculas.getLayoutManager()).getOrientation());
        recyclerViewPeliculas.addItemDecoration(dividerItemDecoration);

    }
    @NonNull
    private List<PeliculaPOJO> buildPeliculas()
    {
        List<PeliculaPOJO> peliculas = new ArrayList<>();
        peliculas.add(new PeliculaPOJO(R.drawable.broly,getString(R.string.tituloBroly),getString(R.string.directorBroly),getString(R.string.repartoBroly),4,getString(R.string.sinopsisBroly)));
        peliculas.add(new PeliculaPOJO(R.drawable.boruto,getString(R.string.tituloBoruto),getString(R.string.directorBoruto),getString(R.string.repartoBotuto),3,getString(R.string.sinopsisBoruto)));
        peliculas.add(new PeliculaPOJO(R.drawable.doraemonimperio,getString(R.string.tituloDoraemon),getString(R.string.directorDoraemon),getString(R.string.repartoDoraemon),3,getString(R.string.sinopsisDoraemon)));
        peliculas.add(new PeliculaPOJO(R.drawable.tren,getString(R.string.tituloTren),getString(R.string.directorTren),getString(R.string.repartoTren),3,getString(R.string.sinopsisTren)));
        peliculas.add(new PeliculaPOJO(R.drawable.eldespertar,getString(R.string.tituloEldespertar),getString(R.string.directorEldespertar),getString(R.string.repartoEldespertar),3,getString(R.string.sinopsisEldespertar)));
        peliculas.add(new PeliculaPOJO(R.drawable.yourname,getString(R.string.tituloYourname),getString(R.string.directorYourname),getString(R.string.repartoYourname),3,getString(R.string.sinopsisYoruname)));
        peliculas.add(new PeliculaPOJO(R.drawable.monoke,getString(R.string.tituloMononoke),getString(R.string.directorMononoke),getString(R.string.repartoMononoke),3,getString(R.string.sinopsisMononoke)));


        return peliculas;
    }

}