package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        et1= (EditText) findViewById(R.id.etCodigo);
        et2= (EditText) findViewById(R.id.etNombre);
        et3= (EditText) findViewById(R.id.etUsuario);
        et4= (EditText) findViewById(R.id.etContraseña);
    }

    public void registrar(View view){
        DBHelper admin= new DBHelper(this, "Unac", null, 1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String codigo = et1.getText().toString();
        String nombre = et2.getText().toString();
        String usuario = et3.getText().toString();
        String contrasena = et4.getText().toString();

        //Obtener los valores para poder insertar
        ContentValues values = new ContentValues();
        values.put("id", codigo);
        values.put("usuario", usuario);
        values.put("contrasena", contrasena);
        values.put("nombre", nombre);

        db.insert("usuarios", null, values);
        db.close();

        Intent ven = new Intent(this, MainActivity.class);
        startActivity(ven);
    }


    public void cancelar(View view){
        finish();
    }


}
