package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DescripcionSerie extends AppCompatActivity implements View.OnClickListener {
    ImageView imgCaratula ;
    TextView textTitulo,textDirector,textReparto,textSinopsis,textPuntuacion,textTemporadas;
    SeriePOJO serie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_serie);

        Bundle extras = getIntent().getExtras();
        imgCaratula = findViewById(R.id.imageViewCaratula);
        textTitulo = findViewById(R.id.textViewTitulo);
        textDirector = findViewById(R.id.textViewDirector);
        textReparto = findViewById(R.id.textViewRepartp);
        textSinopsis = findViewById(R.id.textViewSinopsis);
        textPuntuacion = findViewById(R.id.textViewPuntuacion);
        textTemporadas = findViewById(R.id.textViewTemporada);
        imgCaratula.setOnClickListener(this);
        if(extras != null)
        {
            serie = (SeriePOJO) extras.getSerializable("serie");

            Drawable carat = getDrawable(serie.getCaratula());
            textPuntuacion.setText(serie.getClasificacion()+"");
            imgCaratula.setImageDrawable(carat);
            textTitulo.setText(serie.getTitulo());
            textDirector.setText(serie.getDirector());
            textReparto.setText(serie.getReparto());
            textSinopsis.setText(serie.getSinopsis());
            textTemporadas.setText("N Temporadas: "+serie.getTemporadas());

        }
    }

    @Override
    public void onClick(View v) {
        if(v.equals(imgCaratula))
        {
            Intent inte = new Intent(this, Caratula.class);
            inte.putExtra("img", serie.getCaratula());
            startActivity(inte);
        }

    }
}