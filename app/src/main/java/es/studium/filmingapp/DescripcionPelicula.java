package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DescripcionPelicula extends AppCompatActivity implements View.OnClickListener {
    ImageView imgCaratula ;
    TextView textTitulo,textDirector,textReparto,textSinopsis;
    RatingBar ratingBar;
    PeliculaPOJO pelicula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_pelicula);

        Bundle extras = getIntent().getExtras();
        imgCaratula = findViewById(R.id.imageViewCaratula);
        textTitulo = findViewById(R.id.textViewTitulo);
        textDirector = findViewById(R.id.textViewDirector);
        textReparto = findViewById(R.id.textViewRepartp);
        textSinopsis = findViewById(R.id.textViewSinopsis);
        ratingBar = findViewById(R.id.ratingBarPelicula);
        imgCaratula.setOnClickListener(this);

        if(extras != null)
        {
           pelicula = (PeliculaPOJO) extras.getSerializable("pelicula");
           Drawable carat = getDrawable(pelicula.getCaratula());
           ratingBar.setRating(pelicula.getClasificacion());
           imgCaratula.setImageDrawable(carat);
           textTitulo.setText(getString(R.string.Titulo)+" "+pelicula.getTitulo());
           textDirector.setText(getString(R.string.Director)+" "+pelicula.getDirector());
           textReparto.setText(getString(R.string.Reparto)+" "+pelicula.getReparto());
           textSinopsis.setText(getString(R.string.Sinopsis)+" "+pelicula.getSinopsis());

        }
    }

    @Override
    public void onClick(View v) {
        Intent inte = new Intent(this, Caratula.class);
        inte.putExtra("img", pelicula.getCaratula());
        startActivity(inte);
    }
}