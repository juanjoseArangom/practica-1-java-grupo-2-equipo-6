package uiMain;

import gestorAplicacion.Gestion.*;
import gestorAplicacion.Entorno.*;
import gestorAplicacion.Personas.*;

import java.util.*;

public class Main {
    static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
    static ArrayList<Zona> zonas = new ArrayList<Zona>();
    static ArrayList<String> nombreZonas = new ArrayList<String>();
    static {
        //Creamos ciudades de muestra
        Ciudad ciudad1 = new Ciudad("Medellín");
        ciudades.add(ciudad1);
        Ciudad ciudad2 = new Ciudad("Bogotá");
        ciudades.add(ciudad2);

        //Creamos zonas de muestra
        zonas.add(new Zona(4378, "Robledo", ciudad1));
        zonas.add(new Zona(7426, "Aranjuez", ciudad1));
        zonas.add(new Zona(193134, "Kennedy", ciudad2));

        //Creamos mesas de muestra


        //Agregamos el nombre de las zonas al array nombreZonas
        for (Zona zona : zonas) {
            nombreZonas.add(zona.getNombre());
        }

        //Agregamos las zonas creadas al array zonas de su respectiva ciudad
        for (Ciudad ciudad : ciudades) {
            for (Zona zona : zonas) {
                if (zona.getCiudad() == ciudad) {
                    ciudad.getZonas().add(zona);
                }
            }
        }

    }
    public static void main(String[] args) {
        menuPrincipal();
    }

    //Muestra el menú principal del programa
    static void menuPrincipal() {
        limpiarPantalla();
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Qué desea hacer?
                    1. Reservar Mesa.
                    2. Ordenar Comida.
                    3. Dejar Restaurante
                    4. Agregar Sede.
                    5. Crear Evento.
                    6. Salir.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Interacción 1.");
                    encendido = false;
                    break;
                case 2:
                    limpiarPantalla();
                    System.out.println("Funcionalidad 2.");
                    encendido = false;
                    break;
                case 3:
                    limpiarPantalla();
                    dejarRestaurante();
                    System.out.println("Funcionalidad 3.");
                    encendido = false;
                    break;
                case 4:
                    limpiarPantalla();
                    agregarSede();
                    encendido = false;
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("Funcionalidad 5.");
                    encendido = false;
                    break;
                case 6:
                    limpiarPantalla();
                    System.out.println("Se cierra el programa.");
                    encendido = false;
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 6].");
                    break;
            }
        } while (encendido);
    }
    static Scanner consola = new Scanner(System.in);

    static String readString() {
        return consola.nextLine();
    }
    static int readInt() {
        String numero = readString();
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            System.out.println("Ingrese un número enteor válido. Ej: 172, 92, 5");
            return readInt();
        }
    }

    static String capitalize(String text) {
        char[] letrasIndividuales = text.toLowerCase().toCharArray();
        boolean espacioBlanco = true;
        for(int i = 0; i < letrasIndividuales.length; i++) {
            if(Character.isLetter(letrasIndividuales[i])) {
                if(espacioBlanco) {
                    letrasIndividuales[i] = Character.toUpperCase(letrasIndividuales[i]);
                    espacioBlanco = false;
                }
            }
            else {
                espacioBlanco = true;
            }
        }
        return String.valueOf(letrasIndividuales);
    }

    // Funcionalidad 3: Dejar Restaurante

    public static void dejarRestaurante() {
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Algún cliente desea dejar el restaurante?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Ingrese el número de la mesa que va a dejar el restaurante");
                    int numeroMesa = readInt();
                    for (Mesa mesas : Restaurante.mesas){
                        if (mesas.getNumMesa() == numeroMesa){
                            cobrarFactura(mesas);
                            break;
                        }
                        else {
                            System.out.println("No se encontró la mesa.");
                        }
                        menuPrincipal();
                    }
                    encendido = false;
                    break;
                case 2:
                    limpiarPantalla();
                    menuPrincipal();
                    encendido = false;
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }
        } while (encendido);
    }

    // Interacción 1: cobrarFactura

    public static void cobrarFactura(Mesa mesa) {
        boolean encendido = true;
        do {
            System.out.println("Interacción 1.");
            int valorFactura = mesa.getFacturaUnificada().getValor();
            System.out.println("El valor de la factura es: " + valorFactura);
            System.out.println("""
                    ¿Desea agregar propina?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Por favor ingrese el valor de la propina.");
                    int propina = readInt();
                    mesa.getFacturaUnificada().setPropina(propina);
                    mesa.getFacturaUnificada().setValor(mesa.getFacturaUnificada().getValor() + propina);
                    System.out.println("El valor de la factura con propina es: " + mesa.getFacturaUnificada().getValor());

                    break;
                case 2:
                    ;
                    break;
                default:
                    System.out.println("Número no válido.");
                    break;
            }
        } while (encendido);
    }

    public static void separarFactura(Mesa mesa){
        boolean encendido = true;
        do {
            System.out.println("Interacción 2.");
            System.out.println("¿Desea separar la factura?");
            System.out.println("""
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Por favor ingrese el número de personas que van a pagar la factura.");
                    int numeroPersonas = readInt();
                    if (numeroPersonas == mesa.getClientes().size()){
                        int valorFactura = mesa.getFacturaUnificada().getValor();
                        int valorPorPersona = valorFactura / numeroPersonas;
                        System.out.println("El valor por persona es: " + valorPorPersona);
                    }
                    else{
                        System.out.println("Ingrese las cédulas de las personas que pagarán la factura.");
                        ArrayList<Cliente> clientesPagadores = new ArrayList<Cliente>();
                        for (int i = 0; i < numeroPersonas; i++){
                            int cedula = readInt();
                            if (cedula == mesa.getClientes().get(i).getCedula()){
                                clientesPagadores.add(mesa.getClientes().get(i));
                                for (Cliente cliente : clientesPagadores){
                                    boolean encendido2 = true;
                                    do {
                                        System.out.println("Ingrese la cantidad que desea pagar.");
                                        int valor = readInt();
                                        if (valor >= mesa.getFacturaUnificada().getValor()) {
                                            System.out.println("El valor ingresado es mayor al valor de la factura.");
                                        } else {
                                            mesa.getFacturaUnificada().setValor(mesa.getFacturaUnificada().getValor() - valor);
                                            System.out.println("El valor restante de la factura es: " + mesa.getFacturaUnificada().getValor());
                                            encendido2 = false;
                                        }
                                    } while(encendido2);
                                    System.out.println("Escoja el método de pago.");
                                    System.out.println("""
                                            1. Efectivo.
                                            2. Tarjeta.
                                            3. Cheque.
                                            4. Otro.
                                            Escriba un número para elegir su opción.""");
                                    int metodoPago = readInt();
                                    ArrayList<String> metodosPago = new ArrayList<String>();
                                    switch (metodoPago) {
                                        case 1:
                                            mesa.getFacturaUnificada().setMetodoPago("Efectivo");
                                            metodosPago.add("Efectivo");
                                            break;
                                        case 2:
                                            cliente.getFactura().setMetodoPago("Tarjeta");
                                            metodosPago.add("Tarjeta");
                                            break;
                                        case 3:
                                            cliente.getFactura().setMetodoPago("Cheque");
                                            metodosPago.add("Cheque");
                                            break;
                                        case 4:
                                            cliente.getFactura().setMetodoPago("Otro");
                                            metodosPago.add("Otro");
                                            break;
                                        default:
                                            System.out.println("Número no válido");
                                            break;
                                    }
                                }
                                if (valorFactura == 0){
                                    System.out.println("La factura ha sido pagada.");
                                }
                            }
                            else {
                                System.out.println("Cédula no válida.");
                            }

                        }
                    }
                    break;
                case 2:
                    ;
                    break;
                default:
                    System.out.println("Número no válido.");
                    break;
            }

        } while (encendido);
    }

    //Funcionalidad 4: Agregar Sede
    public static void agregarSede() {
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Desea añadir una nueva sede?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Interacción 1.");
                    Restaurante restaurante = elegirZona(new Restaurante());

                    System.out.println(restaurante);
                    encendido = false;
                    break;
                case 2:
                    limpiarPantalla();
                    menuPrincipal();
                    encendido = false;
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }
        } while (encendido);
    }

    //Funcionalidad 4. Interacción 1: Elegir Zona
    public static Restaurante elegirZona(Restaurante restaurante) {
        boolean encendido = true;
        do {
            System.out.println("Ciudades:");
            listadoCiudades();
            System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
                    "requerida escriba 0.");
            int eleccion1 = readInt();
            if (eleccion1 > ciudades.size() || eleccion1 < 0) {
                System.out.println("Ingrese un número válido [1 - " + ciudades.size() + "].");
            } else {
                limpiarPantalla();
                if (!(eleccion1 == 0)) { //Si se encuentra la ciudad
                    Ciudad ciudad = ciudades.get(eleccion1 - 1);
                    restaurante = parametrosBasicos(ciudad, restaurante);

                } else { //Si no se encuentra la ciudad
                    System.out.println("Por favor ingrese el nombre de la ciudad.");
                    Ciudad ciudad = new Ciudad(capitalize(readString()));
                    ciudades.add(ciudad);
                    System.out.println("Por favor ingrese la cantidad de zonas que tiene la ciudad.");
                    int cantidadZonas = readInt();
                    //Este ciclo for se encarga de la creación de las zonas de la nueva ciudad.
                    for (int i = 1; i <= cantidadZonas; i++) {
                        System.out.println("Por favor ingrese el nombre de la zona #" + i + '.');
                        String nombreZona = readString();
                        System.out.println("Por favor ingrese la población de la zona #" + i + '.');
                        int poblacionZona = readInt();
                        ciudad.getZonas().add(new Zona(poblacionZona, capitalize(nombreZona), ciudad));
                        ciudad.actualizarPoblacion();
                        System.out.println(ciudad.getZonas().getLast());
                    }
                    limpiarPantalla();
                    restaurante = parametrosBasicos(ciudad, restaurante);
                }
                encendido = false;
            }
        } while (encendido);
        return restaurante;
    }

    //Este método se encarga de definir los parámetros básicos del restaurante: Ciudad, Zona, Zona VIP y Calificación
    public static Restaurante parametrosBasicos(Ciudad ciudad, Restaurante restaurante) {
        System.out.println("Zonas de " + ciudad.getNombre() + ":");
        listadoZonasCiudad(ciudad);
        System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                "requerida escriba 0.");
        int eleccionZona1 = readInt();
        if (eleccionZona1 > ciudades.size() || eleccionZona1 < 0) {
            System.out.println("Ingrese un número válido [1 - " + ciudad.getZonas().size() + "].");
        } else {
            limpiarPantalla();
            if (!(eleccionZona1 == 0)) { //Si se encuentra la zona
                restaurante.setCiudad(ciudad);
                restaurante.setZona(ciudad.getZonas().get(eleccionZona1 - 1));
                System.out.println("¿El restaurante tendrá zona VIP?\n1. Sí.\n2. No.\nEscriba un número para elegir.");
                int tieneVIP = readInt();
                if (tieneVIP == 1) {
                    restaurante.setZonaVIP(true);
                } else if (tieneVIP == 2) {
                } else {
                    System.out.println("Número no válido");
                }
                restaurante.setCalificacion((int) (Math.random() * 5) + 1);

            } else { //Si no se encuentra la zona
                System.out.println("Por favor ingrese el nombre de la zona.");
                String nombreZona = readString();
                System.out.println("Por favor ingrese la población de la zona.");
                int poblacionZona = readInt();
                ciudad.getZonas().add(new Zona(poblacionZona, capitalize(nombreZona), ciudad));
                ciudad.actualizarPoblacion();
                restaurante.setCiudad(ciudad);
                System.out.println("Zonas de " + ciudad.getNombre() + ":");
                listadoZonasCiudad(ciudad);
                System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                        "requerida escriba 0.");
                int eleccionZona2 = readInt();
                if (eleccionZona2 > ciudades.size() || eleccionZona2 < 0) {
                    System.out.println("Ingrese un número válido [1 - " + ciudad.getZonas().size() + "].");
                } else {
                    restaurante.setZona(ciudad.getZonas().get(eleccionZona2 - 1));
                    limpiarPantalla();
                    System.out.println("¿El restaurante tendrá zona VIP?\n1. Sí.\n2. No.\nEscriba un número para elegir.");
                    int tieneVIP = readInt();
                    if (tieneVIP == 1) {
                        restaurante.setZonaVIP(true);
                    } else if (tieneVIP == 2) {

                    } else {
                        System.out.println("Número no válido");
                    }
                    restaurante.setCalificacion((int) (Math.random() * 5) + 1);
                }

            }
        }
        return restaurante;
    }

    //Este método se encarga de organizar en orden alfabético el listado de ciudades para luego imprimir un listado
    //numerado desde 1 con el nombre de estas.
    public static void listadoCiudades() {
        ciudades.sort(new Comparator<Ciudad>() {
            @Override
            public int compare(Ciudad o1, Ciudad o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + ciudades.get(i).getNombre() + '.');
        }
    }

    //Este método se encarga de organizar en orden alfabético el listado de zonas de una ciudad en específico para
    // luego imprimir un listado de estas numeradas desde el 1.
    public static void listadoZonasCiudad(Ciudad ciudad) {
        ciudad.getZonas().sort(new Comparator<Zona>() {
            @Override
            public int compare(Zona o1, Zona o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        for (int i = 0; i < ciudad.getZonas().size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + ciudad.getZonas().get(i).getNombre() + '.');
        }
        ciudad.actualizarPoblacion();
    }

    //Este método se encarga de limpiar la pantalla del ejecutable.
    public static void limpiarPantalla(){
        try {
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando= new ArrayList<>();
            if(sistemaOperativo.contains("Windows")){
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");
            } else {
                comando.add("clear");
            }
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
    }

}