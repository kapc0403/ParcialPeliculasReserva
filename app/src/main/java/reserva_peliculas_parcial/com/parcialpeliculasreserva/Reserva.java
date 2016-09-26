package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.content.ContentValues;
import android.content.DialogInterface;
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

    EditText et1,et2, et3, et4, et5;
    String nombre, costoPelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        nombre = getIntent().getStringExtra("nombrePelicula");
        costoPelicula = getIntent().getStringExtra("costo");

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
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

        int costoCalculado = Integer.parseInt(String.valueOf(et5.getText()))*Integer.parseInt(costoPelicula);

        //Obtener los valores para poder insertar
        ContentValues values = new ContentValues();
        values.put("usuarioQreserva", usuarioQreserva);
        values.put("peliculaAreservar", nombrePelicula);
        values.put("fechaInicio", fechaInicio);
        values.put("fechaFin", fechaFin);
        values.put("costo", costoCalculado);

        db.insert("reservas", null, values);
        db.close();


                new AlertDialog.Builder(Reserva.this)
                .setTitle("Reserva Exitosa")
                .setMessage(usuarioQreserva+", acabas de reservas la pelicula - "+ nombrePelicula+" -. Desde el "+fechaInicio+" hasta el "+fechaFin+" con un costo total de $"+ costoCalculado)
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ven = new Intent(Reserva.this, listaPeliculas.class);
                        startActivity(ven);
                    }
                }).create().show();



    }

}
