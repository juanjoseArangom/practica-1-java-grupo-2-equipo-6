package gestorAplicacion.Personas;
import java.util.ArrayList;
import gestorAplicacion.Gestion.*;

public class Cliente extends Persona{
    private Factura factura;
    private Mesa mesa;
    private Restaurante restaurante;
    private String afiliacion;
    private int puntosAcumulados;
    private ArrayList<Plato> platosFavoritos = new ArrayList<Plato>();
    private String placaVehiculo;

    public Cliente (String nombre, int cedula, String afiliacion, String placaVehiculo){
        super(nombre, cedula);
        this.afiliacion = afiliacion;
        this.placaVehiculo = placaVehiculo;
    }



}
