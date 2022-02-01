package es.studium.filmingapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public interface rowClickListener {
    void onClick(View v, int position, ImageView img,TextView titulo);
}
