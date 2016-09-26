package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Reserva extends AppCompatActivity {

    EditText et1,et2, et3, et4;


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

    public void reservarPelicula(View v){
        DBHelper admin= new DBHelper(this, "Unac", null, 1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String usuarioQreserva = et1.getText().toString();
        String nombrePelicula = et2.getText().toString();
        String fechaInicio = et4.getText().toString();
        String fechaFin = et4.getText().toString();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dateInicio = null;
        try {
            dateInicio = formato.parse(fechaInicio);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateFIn = null;
        try {
            dateFIn = formato.parse(fechaFin);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendarInicio = Calendar.getInstance();
        Calendar calendarFinal = Calendar.getInstance();

        calendarInicio.setTime(dateInicio);
        calendarFinal.setTime(dateFIn);

        // obtenemos el valor de las fechas en milisegundos
        double milisegundos1 = calendarInicio.getTimeInMillis();
        double milisegundos2 = calendarFinal.getTimeInMillis();

        // tomamos la diferencia
        double diferenciaMilisegundos = milisegundos2 - milisegundos1;

        double diffdias = Math.abs ( diferenciaMilisegundos / (24 * 60 * 60 * 1000) );

        // devolvemos el resultado en un string

        int costoCalculado = Integer.parseInt(String.valueOf(diffdias));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("debes: "+ costoCalculado)
                .setTitle("Prueba dialog");



        //Obtener los valores para poder insertar
        ContentValues values = new ContentValues();
        values.put("usuarioQreserva", usuarioQreserva);
        values.put("peliculaAreservar", nombrePelicula);
        values.put("fechaInicio", fechaInicio);
        values.put("fechaFin", fechaFin);
        values.put("costo", fechaFin);

        db.insert("reservas", null, values);
        db.close();

        Intent ven = new Intent(this, listaPeliculas.class);
        startActivity(ven);
    }

}
