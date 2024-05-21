package gestorAplicacion.Personas;

public abstract class Persona {
    protected String nombre;
    protected int cedula;

    public Persona(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public abstract void tilin();
}
