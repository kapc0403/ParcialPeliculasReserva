package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class listaPeliculas extends AppCompatActivity {
    Cursor registros;
    //Encapsulo en variables los datos de la pelicula que esta en el do while paa pasarlos por intent al infopelicula
    String nombrepelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_peliculas);

        ArrayList<String> pelis = new ArrayList<>();
        DBHelper admin = new DBHelper(this, "Unac", null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String q = "SELECT * FROM peliculas ORDER BY nombrepeli ASC";
        registros = db.rawQuery(q, null);
        if (registros.moveToFirst()) {
            do {
                pelis.add(registros.getString(1));
            } while (registros.moveToNext());
        }

        ListView lv = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.itemlayout, R.id.txt, pelis);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new ItemList());

    }


    class ItemList implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup vg = (ViewGroup) view;
            TextView tv = (TextView) vg.findViewById(R.id.txt);
            Intent ven = new Intent(listaPeliculas.this, InfoPelicula.class);
            nombrepelicula = tv.getText().toString() ;
            ven.putExtra("nombrepelicula", nombrepelicula);
            startActivity(ven);

        }
    }

}
