package gestorAplicacion.Personas;
import java.util.ArrayList;
import gestorAplicacion.Gestion.*;

public class Cliente extends Persona{
    // Atributos
    private Factura factura;
    private Mesa mesa;
    private Restaurante restaurante;
    private String afiliacion;
    private int puntosAcumulados;
    private ArrayList<Plato> platosFavoritos = new ArrayList<Plato>();
    private String placaVehiculo;

    // Constructores
    public Cliente(){};
    public Cliente (String nombre, int cedula, String afiliacion, String placaVehiculo){
        super(nombre, cedula);
        this.afiliacion = afiliacion;
        this.placaVehiculo = placaVehiculo;
    }



}
