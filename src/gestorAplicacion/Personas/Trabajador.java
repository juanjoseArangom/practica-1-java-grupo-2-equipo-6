package gestorAplicacion.Personas;
import java.util.ArrayList;

public class Trabajador extends Persona{
    private String especialidad;
    private int salario;
    private boolean ocupado;
    private float calificacion;
    private ArrayList<String> reseñas = new ArrayList<String>();

    public Trabajador(String nombre, int cedula, String especialidad, int salario){
        super(nombre, cedula);
        this.especialidad = especialidad;
        this.salario = salario;
        this.ocupado = false;
        this.calificacion = 0;
    }

}
