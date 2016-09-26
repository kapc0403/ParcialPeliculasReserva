package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Reserva extends AppCompatActivity {

    private TextView etNombrePelicula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        String nombre = getIntent().getStringExtra("nombrePelicula");
        etNombrePelicula = (TextView)findViewById(R.id.etNombrePelicula);
        etNombrePelicula.setText(nombre);

    }
}
