package gestorAplicacion.Gestion;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<Plato> platos = new ArrayList<Plato>();

    public Pedido(){};

    public void agregarPlato(Plato plato){
        platos.add(plato);
    }
}
