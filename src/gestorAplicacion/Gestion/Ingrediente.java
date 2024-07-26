package gestorAplicacion.Gestion;
import java.util.ArrayList;
import java.util.Date;

public class Ingrediente {
    private String nombre;
    private double cantidad;
    private Date fechaCaducidad;
    private int precio;
    private int inventario;
    private static ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();

    // Constructor
    public Ingrediente() {
    }

    public Ingrediente(String nombre, double cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
        listaIngredientes.add(this);
    }
    public Ingrediente(String nombre, double cantidad, Date fechaCaducidad, int precio, int inventario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
        this.precio = precio;
        this.inventario = inventario;
        listaIngredientes.add(this);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getInventario() {
        return inventario;
    }

    public static ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public static void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        Ingrediente.listaIngredientes = listaIngredientes;
    }

}

