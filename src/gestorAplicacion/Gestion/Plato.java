package gestorAplicacion.Gestion;
import java.util.ArrayList;

public class Plato {
    //Atributos
    private String nombre;
    private int precio;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private float calificacion;
    private boolean recomendado;
    private int cantidadCalificaciones;
    public static int vecesPedido;

    //Constructores
    public Plato() {}
    public Plato(String nombre, int precio, ArrayList<Ingrediente> ingredientes, float calificacion, boolean recomendado, int cantidadCalificaciones) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.calificacion = calificacion;
        this.recomendado = recomendado;
        this.cantidadCalificaciones = cantidadCalificaciones;
    }
}
