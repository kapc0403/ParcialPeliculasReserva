package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //se crean las variables
    EditText et1, et2;
    private Cursor fila;
    String usua, usuario, consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.etUsuario);
        et2 = (EditText) findViewById(R.id.etContraseña);
    }

    public void ingresar(View v){
        DBHelper admin = new DBHelper(this, "Unac", null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();
        fila = db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"'and contrasena='"+contrasena+"'", null);

        consulta = "SELECT * FROM peliculas ORDER BY nombrepeli ASC";
        if (fila.moveToFirst() == true) {
            usua = fila.getString(0);
            String pass = fila.getString(1);
            if (usuario.equals(usua) && contrasena.equals(pass)) {
                Intent ven = new Intent(this, listaPeliculas.class);
                ven.putExtra("user", usuario);
                ven.putExtra("consulta", consulta);
                startActivity(ven);
            }
        }else
                Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
    }


    public void salir(View v){
        finish();
    }

    public void registrarLayout(View v){
        Intent ven = new Intent(this, Registro.class);
        startActivity(ven);
    }

    public void contacto(View v){
        Intent Con = new Intent(this, Contacto.class);
        startActivity(Con);
    }

}
