package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Reserva extends AppCompatActivity {

    EditText et1,et2,et3,et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        String nombre = getIntent().getStringExtra("nombrePelicula");

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        //Se le envia al campo et2(Nombre Pelicula) la variable que traemos con el intent
        et2.setText(nombre);
    }

    public void registrarPeli(View view){
        DBHelper admin= new DBHelper(this, "Unac", null, 1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String usuarioQreserva = et1.getText().toString();
        String nombrePelicula = et2.getText().toString();
        String fechaInicio = et3.getText().toString();
        String fechaFin = et4.getText().toString();


        int costoCalculado = Integer.parseInt(fechaFin) - Integer.parseInt(fechaInicio);


        //Obtener los valores para poder insertar
        ContentValues values = new ContentValues();
        values.put("usuarioQreserva", usuarioQreserva);
        values.put("peliculaAreservar", nombrePelicula);
        values.put("fechaInicio", fechaInicio);
        values.put("fechaFin", fechaFin);
        values.put("costo", costoCalculado);

        db.insert("reservas", null, values);
        db.close();

        Intent ven = new Intent(this, listaPeliculas.class);
        startActivity(ven);
    }

}
