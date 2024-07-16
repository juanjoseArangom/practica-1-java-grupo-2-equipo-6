package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Personas.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    //Atributos
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Plato> menu = new ArrayList<Plato>();
    public static ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    public static ArrayList<ArrayList<Casilla>> disposicion = new ArrayList<ArrayList<Casilla>>();
    private Ciudad ciudad;
    private Zona zona;
    private boolean zonaVIP;
    private float calificacion;
    private int cantidadCalificaciones;
    private ArrayList<Ingrediente> bodega = new ArrayList<Ingrediente>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private ArrayList<String> reseñas = new ArrayList<String>();
    private ArrayList<Plato> platosRecomendados = new ArrayList<Plato>();
    private ArrayList<Plato> platosDescuento = new ArrayList<Plato>();

    //Constructores
    public Restaurante() {}
    public Restaurante(Ciudad ciudad, Zona zona, boolean zonaVIP) {
        this.ciudad = ciudad;
        this.zona = zona;
        this.zonaVIP = zonaVIP;
    }

    //Métodos
    static Scanner consola = new Scanner(System.in);
    static String readString() {
        return consola.nextLine();
    }
    static int readInt() {
        return Integer.parseInt(consola.nextLine());
    }
    public boolean isZonaVIP() {
        return zonaVIP;
    }
    public void setZonaVIP(boolean zonaVIP) {
        this.zonaVIP = zonaVIP;
    }
    public Zona getZona() {
        return zona;
    }
    public void setZona(Zona zona) {
        this.zona = zona;
    }
    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public float getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(float calificacion) {
        this.calificacion = (getCalificacion()+calificacion)/(cantidadCalificaciones+1);
        cantidadCalificaciones++;
    }
    public void añadirReseña(String reseña) {
        reseñas.add(reseña);
    }
    public void agregarPlatoRecomendado(Plato plato) {
        platosRecomendados.add(plato);
    }
    public void eliminarPlatoRecomendado(Plato plato) {
        platosRecomendados.remove(plato);
    }
    public void agregarPlatoDescuento(Plato plato) {
        platosDescuento.add(plato);
    }
    public void eliminarPlatoDescuento(Plato plato) {
        platosDescuento.remove(plato);
    }
    public ArrayList<Plato> getPlatosRecomendados() {
        return platosRecomendados;
    }
    public ArrayList<Plato> getPlatosDescuento() {
        return platosDescuento;
    }
    public void eliminarPlato(Plato plato) {
        menu.remove(plato);
    }
    public void agregarPlato(Plato plato) {
        menu.add(plato);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Restaurante{");
        sb.append("zona=").append(zona);
        sb.append(", zonaVIP=").append(zonaVIP);
        sb.append(", calificacion=").append(calificacion);
        sb.append('}');
        return sb.toString();
    }
    //    FUNCIONALIDAD NUMERO 4: agregarSede
//    Interacción 1: elegirCiudad

}
