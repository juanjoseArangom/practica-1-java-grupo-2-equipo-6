package gestorAplicacion.Gestion;
import java.util.ArrayList;

import gestorAplicacion.Personas.Cliente;

public class Mesa {
    // Atributos
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    private int valorTotal;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private int numMesa;
    private int numAsientos = 4;
    private Reserva reserva;
    private Restaurante restaurante;
    private boolean VIP;
    private static int contadorMesas = 1;
    private ArrayList<Integer> coordenada = new ArrayList<Integer>();
    // private ArrayList<Decoracion> decoracionesMesa;

    // Constructores

    public Mesa (){}

    public Mesa (int numAsientos, boolean VIP){
        this.numAsientos = numAsientos;
        this.VIP = VIP;
        this.numMesa = contadorMesas;
        contadorMesas++;
    }

    // Metodos

    public void agregarFactura(Factura factura){
        facturas.add(factura);
    }

    public void setNumMesa(int numMesa){
        this.numMesa = numMesa;
    }

    public int getNumMesa(){
        return numMesa;
    }

    public void setNumAsientos(int numAsientos){
        this.numAsientos = numAsientos;
    }

    public int getNumAsientos(){
        return numAsientos;
    }

    public void setReserva(Reserva reserva){
        this.reserva = reserva;
    }

    public Reserva getReserva(){
        return reserva;
    }

    public void setRestaurante(Restaurante restaurante){
        this.restaurante = restaurante;
    }

    public Restaurante getRestaurante(){
        return restaurante;
    }

    public void setVIP(boolean VIP){
        this.VIP = VIP;
    }

    public boolean getVIP(){
        return VIP;
    }

    public void setCoordenada(ArrayList<Integer> coordenada){
        this.coordenada = coordenada;
    }

    public ArrayList<Integer> getCoordenada(){
        return coordenada;
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes){
        this.clientes = clientes;
    }

    public void setFacturas(ArrayList<Factura> facturas){
        this.facturas = facturas;
    }

    public ArrayList<Factura> getFacturas(){
        return facturas;
    }

    public void setValorTotal(int valorTotal){
        this.valorTotal = valorTotal;
    }

    public int getValorTotal(){
        return valorTotal;
    }

}
