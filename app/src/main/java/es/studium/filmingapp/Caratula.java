package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Caratula extends AppCompatActivity implements View.OnClickListener {
    ConstraintLayout layout;
    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caratula);
        layout = findViewById(R.id.CaratulaView);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            img = extras.getInt("img");
            layout.setBackground(ContextCompat.getDrawable(this, img));
        }
        layout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}