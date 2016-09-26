package reserva_peliculas_parcial.com.parcialpeliculasreserva;

/**
 * Created by Kevin Andrés Prieto on 25/09/2016.
 */
public class OperacionesBD {

    public static final String Table1="usuarios";
    public static final String id="id";
    public static final String usuario="usuario";
    public static final String contrasena="contrasena";
    public static final String nombre="nombre";

    public static final String Table2="peliculas";
    public static final String idpelis="idpelis";
    public static final String nombrepeli="nombrepeli";
    public static final String duracion="duracion";
    public static final String genero="genero";
    public static final String calidad="calidad";
    public static final String cover="cover";
    public static final String sinopsis="sinopsis";
    public static final String ranking="ranking";
    public static final String precioXdia="precioXdia";

    public static final String Table3="reservas";
    public static final String peliculaAreservar="peliculaAreservar";
    public static final String usuarioQreserva="usuarioQreserva";
    public static final String fechaInicio="fechaInicio";
    public static final String fechaFin="fechaFin";
    public static final String diasReserva="diasReserva";
    public static final String costo="costo";


    public static final String sentencia1="CREATE TABLE "+Table1+ " ("
            +id+ " VARCHAR( 12 ) PRIMARY KEY NOT NULL,"
            +usuario+ " VARCHAR( 10 ) NOT NULL,"
            +contrasena+ " VARCHAR( 20 ) NOT NULL,"
            +nombre+ " VARCHAR( 40 ) );";

    public static final String sentencia2="CREATE TABLE "+Table2+ " ("
            +idpelis+ " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            +nombrepeli+ " VARHCAR ( 30 ) NOT NULL, "+duracion+ " VARCHAR ( 20 ) NOT NULL,"
            +genero+ " VARCHAR ( 20 ) NOT NULL, "+calidad+ " VARCHAR ( 15 ) NOT NULL,"
            +cover+ " VARCHAR ( 20 ) NOT NULL,"
            +sinopsis+ " VARCHAR( 12 ) NOT NULL,"+ranking+" VARCHAR (12) NOT NULL, "+precioXdia+" VARCHAR (12);";

    public static final String sentencia3="CREATE TABLE "+Table3+ " ("
            +peliculaAreservar+ " VARCHAR( 40 ) PRIMARY KEY NOT NULL,"
            +usuarioQreserva+ " VARCHAR( 40 ) NOT NULL,"
            +fechaInicio+ " VARCHAR( 20 ) NOT NULL,"
            +fechaFin+ " VARCHAR( 20 ), "+costo+" VARCHAR ( 12 );";
}
