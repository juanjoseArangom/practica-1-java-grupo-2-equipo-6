package gestorAplicacion.Gestion;
import gestorAplicacion.Personas.*;
import java.time.*;
import java.util.*;

public class Reserva {
    private LocalDate fecha;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Reserva(LocalDate fecha){
        this.fecha = fecha;
    }
}
