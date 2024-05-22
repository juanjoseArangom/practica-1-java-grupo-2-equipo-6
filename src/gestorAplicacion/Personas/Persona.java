package gestorAplicacion.Personas;

public abstract class Persona {
    // Atributos
    protected String nombre;
    protected int cedula;

    // Constructores
    public Persona() {
    }

    public Persona(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    // Getters
    public abstract void tilina();
}
