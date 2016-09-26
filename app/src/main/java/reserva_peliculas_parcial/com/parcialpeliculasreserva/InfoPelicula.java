package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class InfoPelicula extends AppCompatActivity {

    private TextView etNombrePelicula, etduracion, etgenero, etcalidad, etsinopsis, etranking;
    String nombrePeli, duracion, genero, calidad, sinopsis, ranking, foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pelicula);

        //Recibo las variables del intent anterior para usarlas
        String nombrepelicula = getIntent().getStringExtra("nombrepelicula");

        DBHelper admin = new DBHelper(this, "Unac", null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM peliculas WHERE nombrepeli='"+nombrepelicula+"' ", null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                nombrePeli = c.getString(1);
                duracion = c.getString(2);
                genero = c.getString(3);
                calidad = c.getString(4);
                sinopsis = c.getString(6);
                ranking = c.getString(7);
            } while(c.moveToNext());
        }

        // traigo todos los elements por id para asignarles la variable por defecto con el dato que ya traje
        etNombrePelicula = (TextView)findViewById(R.id.txtNombre);
        etduracion = (TextView)findViewById(R.id.txtduracion);
        etgenero = (TextView)findViewById(R.id.txtgenero);
        etcalidad = (TextView)findViewById(R.id.txtcalidad);
        etsinopsis = (TextView)findViewById(R.id.txtsinopsis);
        etranking = (TextView)findViewById(R.id.txtranking);

        etNombrePelicula.setText(nombrePeli);
        etduracion.setText(duracion);
        etgenero.setText(genero);
        etcalidad.setText(calidad);
        etsinopsis.setText(sinopsis);
        etranking.setText(ranking);
    }

    public void reservar(View v){
        Intent ven = new Intent(this, Reserva.class);
        ven.putExtra("nombrePelicula", nombrePeli);
        startActivity(ven);
    }
}
