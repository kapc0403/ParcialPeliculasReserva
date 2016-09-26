package reserva_peliculas_parcial.com.parcialpeliculasreserva;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Kevin Andrés Prieto on 25/09/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(OperacionesBD.sentencia1); //Usuarios
        db.execSQL(OperacionesBD.sentencia2); //Peliculas

        db.execSQL("insert into usuarios values(01,'admin','admin','Kevin Prieto')");
        db.execSQL("insert into usuarios values(02,'invitado','invitado','Angelica Garnica')");

        db.execSQL("insert into peliculas values(01,'Los siete magnificos','uno:50:00','Accion','Blu Ray', 'imagenaca', 'El usuario a  la hora de reservar una película podrá seleccionar fecha de inicio y fecha final, automáticamente el sistema calculara el costo del alquiler según la cantidad de días.','cinco')");
        db.execSQL("insert into peliculas values(02,'EL conjuro','dos:10:00','Terror','Blu Ray 3D', 'imagenaca', 'Inicio y fecha final, automáticamente el sistema calculara el costo del alquiler según la cantidad de días.','tres')");
        db.execSQL("insert into peliculas values(03,'Central Intelligence','uno:20:00','Comedias','Blu Ray 3D', 'imagenaca', 'Inicio y fecha final, automáticamente el sistema calculara el costo del alquiler según la cantidad de días.','tres')");
        db.execSQL("insert into peliculas values(04,'The Dead Room','dos:50:00','Terror','Blu Ray', 'imagenaca', 'Inicio y fecha final, automáticamente el sistema calculara el costo del alquiler según la cantidad de días.','tres')");
        db.execSQL("insert into peliculas values(05,'Terrafomars','uno:40:00','Terror','Blu Ray', 'imagenaca', 'Inicio y fecha final, automáticamente el sistema calculara el costo del alquiler según la cantidad de días.','tres')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
    }


}
