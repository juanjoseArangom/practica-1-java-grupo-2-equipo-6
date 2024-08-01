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
        //Test funcionalidad 3
        Restaurante restaurante1 = new Restaurante();
        Mesa mesa1 = new Mesa(3, false);
        restaurante1.agregarMesa(mesa1);


        //Creamos clientes de muestra para la mesa 1
        ArrayList <Cliente> clientesMesa1 = new ArrayList<Cliente>();
        Cliente cliente1 = new Cliente("Juan", 001, "Estrella", "1234567");
        clientesMesa1.add(cliente1);
        Cliente cliente2 = new Cliente("Pedro", 002, "Estrellita", "7654321");
        clientesMesa1.add(cliente2);
        Cliente cliente3 = new Cliente("María", 003, null, "9876543");
        clientesMesa1.add(cliente3);
        mesa1.setClientes(clientesMesa1);

        //Creamos ingredientes y platos de muestra
        Ingrediente Tomate = new Ingrediente("Tomate", 500);
        Ingrediente Lechuga = new Ingrediente("Lechuga", 300);
        ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<Ingrediente>();
        ingredientesEnsalada.add(Tomate);
        ingredientesEnsalada.add(Lechuga);
        Plato Ensalada = new Plato("Ensalada", 19000, ingredientesEnsalada);

        Ingrediente Carne = new Ingrediente("Carne", 1000);
        Ingrediente Pan = new Ingrediente("Pan", 500);
        ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<Ingrediente>();
        ingredientesHamburguesa.add(Carne);
        ingredientesHamburguesa.add(Pan);
        Plato Hamburguesa = new Plato("Hamburguesa", 25000, ingredientesHamburguesa);

        Ingrediente Arroz = new Ingrediente("Arroz", 800);
        Ingrediente Pollo = new Ingrediente("Pollo", 700);
        ArrayList<Ingrediente> ingredientesArroz = new ArrayList<Ingrediente>();
        ingredientesArroz.add(Arroz);
        ingredientesArroz.add(Pollo);
        Plato ArrozConPollo = new Plato("Arroz con pollo", 20000, ingredientesArroz);

        //Creamos pedidos de muestra
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        Pedido pedido3 = new Pedido();

        pedido1.agregarPlato(Ensalada);
        pedido2.agregarPlato(Hamburguesa);
        pedido3.agregarPlato(ArrozConPollo);

        //Creamos facturas de muestra
        Factura factura1 = new Factura(pedido1, "Efectivo", false, 0);
        Factura factura2 = new Factura(pedido2, "Tarjeta", false, 0);
        Factura factura3 = new Factura(pedido3, "Efectivo", false, 0);
        cliente1.setFactura(factura1);
        cliente2.setFactura(factura2);
        cliente3.setFactura(factura3);





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
            System.out.println("Ingrese un número entero válido. Ej: 172, 92, 5");
            return readInt();
        }
    }

    static float readFloat(){
        String numero = readString();
        try {
            return Float.parseFloat(numero);
        } catch (NumberFormatException ex) {
            System.out.println("Ingrese un número decimal válido. Ej: 2.5, 7.2, 5.1");
            return readFloat();
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
    // Este método es el encargado de cobrar la factura de una mesa en específico. Es la primera interacción de la funcionalidad número 3.
    public static void cobrarFactura(Mesa mesa) {
        boolean encendido = true;
        do {
            System.out.println("Interacción 1.");
            int valorFactura = 0;
            for (Cliente cliente : mesa.getClientes()) {
                valorFactura += cliente.getFactura().calcularValor();
            }
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
                    valorFactura += propina;
                    mesa.setValorTotal(valorFactura);
                    System.out.println("El valor de la factura con propina es: " + valorFactura);
                    separarFactura(mesa);
                    liberarMesa(mesa);
                    encendido = false;
                    break;
                case 2:
                    System.out.println("El valor de la factura sin propina es: " + valorFactura);
                    mesa.setValorTotal(valorFactura);
                    separarFactura(mesa);
                    liberarMesa(mesa);
                    encendido = false;
                    break;
                default:
                    System.out.println("Número no válido.");
                    break;
            }
        } while (encendido);
    }

    // Este método pertenece a la primera interacción y se encarga de separar y cobrar la factura de la mesa que desea dejar el restaurante.
    public static void separarFactura(Mesa mesa) {
        boolean encendido = true;
        do {
            System.out.println("¿Desea separar la factura?");
            System.out.println("""
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Por favor ingrese el número de personas que van a pagar la factura.");
                    int cedula = 0;
                    int numeroPersonas = readInt();
                    if (numeroPersonas == mesa.getClientes().size()) {
                        ArrayList<Cliente> clientesPagadores = new ArrayList<Cliente>();
                        System.out.println("¿Todos desean pagar el mismo monto?");
                        System.out.println("""
                                1. Sí.
                                2. No.
                                Escriba un número para elegir su opción.""");
                        int eleccion2 = readInt();
                        switch (eleccion2) {
                            case 1:
                                int valorFactura = mesa.getValorTotal();
                                int valorPorPersona = valorFactura / numeroPersonas;
                                System.out.println("El valor por persona es: " + valorPorPersona);
                                limpiarPantalla();
                                clientesPagadores = mesa.getClientes();
                                for (Cliente clientePagador : clientesPagadores) {
                                    escogerMetodoPago(clientePagador);
                                    int valorFinalPorPersona = aplicarDescuentosCuenta(clientePagador, valorPorPersona);
                                    boolean transaccionConfirmada = false;
                                        do {
                                            System.out.println("Descuento por afiliación: " + (valorPorPersona - valorFinalPorPersona));
                                            System.out.println("¿Desea confirmar la transacción con un valor de: " + valorFinalPorPersona + "?");
                                            System.out.println("""
                                                    1. Sí.
                                                    2. No.
                                                    Escriba un número para elegir su opción.""");
                                            int confirmacion = readInt();
                                            switch (confirmacion) {
                                                case 1:
                                                    System.out.println("Transacción confirmada.");
                                                    clientePagador.getFactura().pagar();
                                                    mesa.setValorTotal(mesa.getValorTotal() - valorPorPersona);
                                                    transaccionConfirmada = true;
                                                    break;
                                                case 2:
                                                    break;
                                                default:
                                                    System.out.println("Número no válido.");
                                                    break;
                                            }
                                        } while (!transaccionConfirmada);

                                }
                                if (mesa.getValorTotal() == 0) {
                                    System.out.println("La factura ha sido pagada. Esperamos que vuelvan pronto!!!");
                                }
                                break;
                            case 2:
                                System.out.println("Cada persona pagará lo que consumió.");
                                for (Cliente cliente : mesa.getClientes()) {
                                    System.out.println(cliente.getNombre() + " debe pagar: " + cliente.getFactura().getValor());
                                    escogerMetodoPago(cliente);
                                    int valorFinalFactura = aplicarDescuentosCuenta(cliente, cliente.getFactura().getValor());
                                    boolean transaccionConfirmada = false;
                                    do {
                                        System.out.println("¿Desea confirmar la transacción con un valor de: " + valorFinalFactura + "?");
                                        System.out.println("""
                                                1. Sí.
                                                2. No.
                                                Escriba un número para elegir su opción.""");
                                        int confirmacion = readInt();
                                        switch (confirmacion) {
                                            case 1:
                                                System.out.println("Transacción confirmada.");
                                                cliente.getFactura().pagar();
                                                mesa.setValorTotal(mesa.getValorTotal() - cliente.getFactura().getValor());
                                                transaccionConfirmada = true;
                                                break;
                                            case 2:
                                                break;
                                            default:
                                                System.out.println("Número no válido.");
                                                break;
                                        }
                                    } while (!transaccionConfirmada);
                                }
                                if (mesa.getValorTotal() == 0) {
                                    System.out.println("La factura ha sido pagada. Esperamos que vuelvan pronto!!!");
                                }
                                break;
                        }
                    } else {
                        ArrayList<Cliente> clientesPagadores = new ArrayList<Cliente>(numeroPersonas);
                        int personasProcesadas = 0;

                        while (mesa.getValorTotal() > 0 && personasProcesadas < numeroPersonas) {
                            for (int j = 0; j < numeroPersonas; j++) {
                                System.out.println("Ingrese la cédula de la persona que pagará la factura.");
                                cedula = readInt();  // Asegúrate de tener el método readInt() definido adecuadamente

                                // Verificar si la cédula ingresada corresponde a algún cliente
                                boolean cedulaValida = false;
                                Cliente clientePagador = null;
                                for (Cliente cliente : mesa.getClientes()) {
                                    if (cliente.getCedula() == cedula) {
                                        cedulaValida = true;
                                        clientePagador = cliente;
                                        clientesPagadores.add(cliente);
                                        break;
                                    }
                                }
                                if (cedulaValida) {
                                    System.out.println("Ingrese la cantidad que desea pagar.");
                                    int valor = readInt();
                                    if (valor > mesa.getValorTotal()) {
                                        System.out.println("El valor ingresado es mayor al valor de la factura.");
                                    } else {
                                        escogerMetodoPago(clientePagador);
                                        int valorFinalPersona = aplicarDescuentosCuenta(clientePagador, valor);
                                        mesa.setValorTotal(mesa.getValorTotal() - valor + (valor - valorFinalPersona));
                                        System.out.println("El pago final fue: " + valorFinalPersona);
                                        System.out.println("El valor restante de la factura es: " + mesa.getValorTotal());
                                    }
                                    personasProcesadas++;
                                    if (mesa.getValorTotal() <= 0) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Cédula no válida.");
                                }
                            }
                        }

                        if (mesa.getValorTotal() != 0) {
                            System.out.println("La factura aún no ha sido pagada.");
                            System.out.println("Seleccione el cliente que pagará la factura.");
                            for (int i = 0; i < clientesPagadores.size(); i++) {
                                System.out.println(i + 1 + ". " + clientesPagadores.get(i).getNombre());
                            }
                            int clienteAPagar = readInt();
                            System.out.println("Debe pagar el total restante de: " + mesa.getValorTotal());
                            System.out.println("¿Desea confirmar la transacción?");
                            System.out.println("""
                                            1. Sí.
                                            2. No.
                                            Escriba un número para elegir su opción.""");
                            int confirmacion = readInt();
                            switch (confirmacion) {
                                case 1:
                                    System.out.println("Transacción confirmada.");
                                    mesa.setValorTotal(0);
                                    break;
                                case 2:
                                default:
                                    System.out.println("Número no válido.");
                                    break;
                            }
                        }

                        System.out.println("La factura ha sido pagada.");
//                        ArrayList<Cliente> clientesPagadores = new ArrayList<Cliente>(numeroPersonas);
//                        do {
//                            for (int j = 0; j < numeroPersonas + 1; j++) {
//                                System.out.println("Ingrese la cédula de la persona que pagará la factura.");
//                                cedula = readInt();  // Asegúrate de tener el método readInt() definido adecuadamente
//
//                                // Verificar si la cédula ingresada corresponde a algún cliente
//                                boolean cedulaValida = false;
//                                Cliente clientePagador = null;
//                                for (Cliente cliente : mesa.getClientes()) {
//                                    if (cliente.getCedula() == cedula) {
//                                        cedulaValida = true;
//                                        clientePagador = cliente;
//                                        clientesPagadores.add(cliente);
//                                        break;
//                                    }
//                                }
//                                if (cedulaValida) {
//                                    System.out.println("Ingrese la cantidad que desea pagar.");
//                                    int valor = readInt();
//                                    if (valor > mesa.getValorTotal()) {
//                                        System.out.println("El valor ingresado es mayor al valor de la factura.");
//                                    } else {
//                                        escogerMetodoPago(clientePagador);
//                                        int valorFinalPersona = aplicarDescuentosCuenta(clientePagador, valor);
//                                        if (mesa.getValorTotal() - valor - (valor - valorFinalPersona) >= 0){
//                                                mesa.setValorTotal(mesa.getValorTotal() - valor - (valor - valorFinalPersona));
//                                        } else {
//                                                mesa.setValorTotal(0);
//                                        }
//                                        System.out.println("El pago final fue: " + valorFinalPersona);
//                                        System.out.println("El valor restante de la factura es: " + mesa.getValorTotal());
//                                    }
//                                } else {
//                                    System.out.println("Cédula no válida.");
//                                }
//                            } if (mesa.getValorTotal() != 0){
//                                System.out.println("La factura aún no ha sido pagada.");
//                                System.out.println("Seleccione el cliente que pagará la factura.");
//                                for (int i = 0; i < clientesPagadores.size(); i++) {
//                                    System.out.println(i + 1 + ". " + clientesPagadores.get(i).getNombre());
//                                }
//                                int clienteAPagar = readInt();
//                                System.out.println("Debe pagar el total restante de: " + mesa.getValorTotal());
//                                System.out.println("¿Desea confirmar la transacción?");
//                                System.out.println("""
//                                        1. Sí.
//                                        2. No.
//                                        Escriba un número para elegir su opción.""");
//                                int confirmacion = readInt();
//                                switch (confirmacion) {
//                                    case 1:
//                                        System.out.println("Transacción confirmada.");
//                                        mesa.setValorTotal(0);
//                                        break;
//                                    case 2:
//
//                                    default:
//                                        System.out.println("Número no válido.");
//                                        break;
//                                }
//                            }
//                        } while (mesa.getValorTotal() > 0);
//                        System.out.println("La factura ha sido pagada.");


//                        do {
//                        for (int j = 0; j < numeroPersonas - 1; j++) {
//                            System.out.println("Ingrese la cédula de la persona que pagará la factura.");
//                            cedula = readInt();
//                            if (cedula == mesa.getClientes().get(j).getCedula()) {
//                                clientesPagadores.add(mesa.getClientes().get(j));
//                                int valor = 0;
//                                for (Cliente cliente : clientesPagadores) {
//                                        System.out.println("Ingrese la cantidad que desea pagar.");
//                                        valor = readInt();
//                                        if (valor > mesa.getValorTotal()) {
//                                            System.out.println("El valor ingresado es mayor al valor de la factura.");
//                                        } else {
//                                            escogerMetodoPago(cliente);
//                                            int valorFinalPersona = aplicarDescuentosCuenta(cliente, valor);
//                                            if (mesa.getValorTotal() - valor - (valor - valorFinalPersona) >= 0){
//                                                mesa.setValorTotal(mesa.getValorTotal() - valor - (valor - valorFinalPersona));
//                                            } else {
//                                                mesa.setValorTotal(0);
//                                            }
//                                            System.out.println("Se aplicaron descuentos por afiliación. El pago final fue: " + valorFinalPersona);
//                                            System.out.println("El valor restante de la factura es: " + mesa.getValorTotal());
//                                            }
//                                    }
//                                    System.out.println("La factura ha sido pagada.");
//                                }else {
//                                System.out.println("Cédula no válida.");
//                                }
//                            }
//                        }while (mesa.getValorTotal() != 0);
                    }
                    encendido = false;
                    break;
                case 2:
                    limpiarPantalla();
                    System.out.println("Ingrese la cédula del cliente que realizará el pago.");
                    int cedulaCliente = readInt();
                    for (Cliente cliente : mesa.getClientes()) {
                        if (cliente.getCedula() == cedulaCliente) {
                            escogerMetodoPago(cliente);
                            boolean transaccionConfirmada = false;
                            do {
                                System.out.println("¿Desea confirmar la transacción con un valor de: " + mesa.getValorTotal() + "?");
                                System.out.println("""
                                        1. Sí.
                                        2. No.
                                        Escriba un número para elegir su opción.""");
                                int confirmacion = readInt();
                                switch (confirmacion) {
                                    case 1:
                                        System.out.println("Transacción confirmada.");
                                        for (Cliente clientes : mesa.getClientes()) {
                                            clientes.getFactura().pagar();
                                        }
                                        mesa.setValorTotal(0);
                                        transaccionConfirmada = true;
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Número no válido.");
                                        break;
                                }
                            } while (!transaccionConfirmada);
                        }
                        if (mesa.getValorTotal() == 0) {
                            System.out.println("La factura ha sido pagada. Esperamos que vuelvan pronto!!!");
                        }
                        // aplicarBeneficios(UNICAMENTE AL CLIENTE QUE REALIZÓ EL PAGO){}
                        encendido = false;
                        break;
            }
            default:
                System.out.println("Número no válido.");
                break;
        }
        } while (encendido);
    }

    // Este método se encarga de dar las opciones de método de pago a la hora de cobrar la factura.
    public static void escogerMetodoPago(Cliente clientePagador) {
        System.out.println("Por favor escoja el método de pago: " + clientePagador.getNombre());
        System.out.println("""
                1. Efectivo.
                2. Tarjeta.
                3. Cheque.
                4. Puntos.
                Escriba un número para elegir su opción.""");
        int metodoPago = readInt();
        ArrayList<String> metodosPago = new ArrayList<String>();
        switch (metodoPago) {
            case 1:
                clientePagador.getFactura().setMetodoPago("Efectivo");
                metodosPago.add("Efectivo");
                break;
            case 2:
                clientePagador.getFactura().setMetodoPago("Tarjeta");
                metodosPago.add("Tarjeta");
                break;
            case 3:
                clientePagador.getFactura().setMetodoPago("Cheque");
                metodosPago.add("Cheque");
                break;
            case 4:
                clientePagador.getFactura().setMetodoPago("Puntos");
                metodosPago.add("Puntos");
                break;
            default:
                System.out.println("Número no válido");
                break;
        }
    }

    // Interacción 2: liberarMesa

    public static void liberarMesa(Mesa mesa){
        boolean encendido = true;
        do {
            System.out.println("Interacción 2.");
            System.out.println("¿Algún cliente desea reservar nuevamente?");
            System.out.println("""
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion){
                case 1:
                    System.out.println("¿Cuántos clientes desean hacer una reservación?");
                    int numeroClientes = readInt();
                    for (int i = 0; i < numeroClientes; i++){
                        System.out.println("Ingrese la cédula del cliente que desea reservar.");
                        int cedula = readInt();
                        for (Cliente cliente : mesa.getClientes()){
                            if (cliente.getCedula() == cedula){
                                if (cliente.getAfiliacion() != null){
                                    // reservarMesa(mesa, cliente);
                                    // aplicarDescuentos(){}
                                } else {
                                    System.out.println("¿Desea afiliarse?");
                                    System.out.println("""
                                            1. Sí.
                                            2. No.
                                            Escriba un número para elegir su opción.""");
                                    int eleccion2 = readInt();
                                    switch (eleccion2){
                                        case 1:
                                            System.out.println("¿Qué nivel de afiliación desea?");
                                            System.out.println("""
                                                    1. Estrellita.
                                                    2. Estrella.
                                                    3. Super estrellota.
                                                    Escriba un número para elegir su opción.""");
                                            int nivelAfiliacion = readInt();
                                            switch (nivelAfiliacion){
                                                case 1:
                                                    boolean transaccionConfirmada = false;
                                                    do {
                                                        System.out.println("¿Desea confirmar la transacción con un valor de: 35.900?");
                                                        System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                        int confirmacion = readInt();
                                                        switch (confirmacion) {
                                                            case 1:
                                                                System.out.println("Transacción confirmada.");
                                                                cliente.setAfiliacion("Estrellita");
                                                                transaccionConfirmada = true;
                                                                break;
                                                            case 2:
                                                                System.out.println("Afiliación no confirmada.");
                                                                break;
                                                            default:
                                                                System.out.println("Número no válido.");
                                                                break;
                                                        }
                                                    } while (!transaccionConfirmada);
                                                    // aplicarDescuentos(){} Se aplican descuentos a la reserva que va a realizar.
                                                    break;
                                                case 2:
                                                    boolean transaccionConfirmada2 = false;
                                                    do {
                                                        System.out.println("¿Desea confirmar la transacción con un valor de: 48.900?");
                                                        System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                        int confirmacion = readInt();
                                                        switch (confirmacion) {
                                                            case 1:
                                                                System.out.println("Transacción confirmada.");
                                                                cliente.setAfiliacion("Estrella");
                                                                transaccionConfirmada2 = true;
                                                                break;
                                                            case 2:
                                                                System.out.println("Afiliación no confirmada.");
                                                                break;
                                                            default:
                                                                System.out.println("Número no válido.");
                                                                break;
                                                        }
                                                    } while (!transaccionConfirmada2);
                                                    // aplicarDescuentos(){} Se aplican descuentos a la reserva que va a realizar.
                                                    break;
                                                case 3:
                                                    boolean transaccionConfirmada3 = false;
                                                    do {
                                                        System.out.println("¿Desea confirmar la transacción con un valor de: 65.900?");
                                                        System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                        int confirmacion = readInt();
                                                        switch (confirmacion) {
                                                            case 1:
                                                                System.out.println("Transacción confirmada.");
                                                                cliente.setAfiliacion("Super estrellota");
                                                                transaccionConfirmada3 = true;
                                                                break;
                                                            case 2:
                                                                System.out.println("Afiliación no confirmada.");
                                                                break;
                                                            default:
                                                                System.out.println("Número no válido.");
                                                                break;
                                                        }
                                                    } while (!transaccionConfirmada3);
                                                    // aplicarDescuentos(){} Se aplican descuentos a la reserva que va a realizar.
                                                    break;
                                                default:
                                                    System.out.println("Número no válido.");
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            // reservarMesa (mesa, cliente);
                                            break;
                                    }
                                }
                            }
                        }
                    } encendido = false;
                    break;
                case 2:
                    for (Cliente cliente : mesa.getClientes()){
                        if (cliente.getAfiliacion() == null){
                            System.out.println("¿Desea afiliarse?");
                            System.out.println("""
                                    1. Sí.
                                    2. No.
                                    Escriba un número para elegir su opción.""");
                            int eleccion3 = readInt();
                            switch (eleccion3){
                                case 1:
                                    System.out.println("¿Qué nivel de afiliación desea?");
                                    System.out.println("""
                                            1. Estrellita.
                                            2. Estrella.
                                            3. Super estrellota.
                                            Escriba un número para elegir su opción.""");
                                    int nivelAfiliacion = readInt();
                                    switch (nivelAfiliacion){
                                        case 1:
                                            boolean transaccionConfirmada = false;
                                            do {
                                                System.out.println("¿Desea confirmar la transacción con un valor de: 35.900?");
                                                System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                int confirmacion = readInt();
                                                switch (confirmacion) {
                                                    case 1:
                                                        System.out.println("Transacción confirmada.");
                                                        cliente.setAfiliacion("Estrellita");
                                                        transaccionConfirmada = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("Afiliación no confirmada.");
                                                        break;
                                                    default:
                                                        System.out.println("Número no válido.");
                                                        break;
                                                }
                                            } while (!transaccionConfirmada);
                                            break;
                                        case 2:
                                            boolean transaccionConfirmada2 = false;
                                            do {
                                                System.out.println("¿Desea confirmar la transacción con un valor de: 48.900?");
                                                System.out.println("""
                                                        1. Sí.
                                                        2. No.
                                                        Escriba un número para elegir su opción.""");
                                                int confirmacion = readInt();
                                                switch (confirmacion) {
                                                    case 1:
                                                        System.out.println("Transacción confirmada.");
                                                        cliente.setAfiliacion("Estrella");
                                                        transaccionConfirmada2 = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("Afiliación no confirmada.");
                                                        break;
                                                    default:
                                                        System.out.println("Número no válido.");
                                                        break;
                                                }
                                            } while (!transaccionConfirmada2);
                                        case 3:
                                            boolean transaccionConfirmada3 = false;
                                            do {
                                                System.out.println("¿Desea confirmar la transacción con un valor de: 65.900?");
                                                System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                int confirmacion = readInt();
                                                switch (confirmacion) {
                                                    case 1:
                                                        System.out.println("Transacción confirmada.");
                                                        cliente.setAfiliacion("Super estrellota");
                                                        transaccionConfirmada3 = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("Afiliación no confirmada.");
                                                        break;
                                                    default:
                                                        System.out.println("Número no válido.");
                                                        break;
                                                }
                                            } while (!transaccionConfirmada3);
                                        default:
                                            System.out.println("Número no válido.");
                                            break;
                                    } calificarRestaurante(mesa);
                                    break;
                                case 2:
                                    break;
                            }
                        } else {
                            calificarRestaurante(mesa);
                        }
                    }
            }
        } while (encendido);
    }

    public static void calificarRestaurante(Mesa mesa) {
        for (Cliente cliente : mesa.getClientes()) {
            System.out.println("Por favor califique el restaurante.");
            System.out.println("Ingrese una calificación del 1 al 5.");
            float calificacion = readFloat();
            if (calificacion >= 1 && calificacion <= 5) {
                System.out.println("Gracias por su calificación.");
                mesa.getRestaurante().setCalificacion(calificacion);
            } else {
                System.out.println("Ingrese una calificación válida.");
            }
            System.out.println("¿Desea añadir una reseña?");
            System.out.println("""
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Por favor ingrese su reseña.");
                    String reseña = readString();
                    mesa.getRestaurante().añadirReseña(reseña);
                    if (cliente.getAfiliacion() != null) {
                        cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        System.out.println("Gracias por su reseña. Obtuvo un punto extra por ayudarnos a mejorar.");
                    } else {
                        System.out.println("Gracias por su reseña.");
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Número no válido.");
                    break;
            }
            System.out.println("Ingrese una calificación para su plato.");
            System.out.println("Ingrese una calificación del 1 al 5.");
            float calificacionPlato = readFloat();
            for (Plato plato : cliente.getFactura().getPedido().getPlatos()) {
                if (calificacionPlato >= 1 && calificacionPlato <= 5) {
                    if (calificacionPlato >= 4.5) {
                        cliente.agregarPlatoFavorito(plato);
                    }
                    plato.setCalificacion(calificacionPlato);
                    System.out.println("Gracias por su calificación.");
                    actualizarPlatos(plato, mesa);
                    actualizarMenu(mesa);
                } else {
                    System.out.println("Ingrese una calificación válida.");
                }
            }
        }
        mesa.setClientes(null);
    }

    // Interacción 3: actualizarRestaurante
    public static void actualizarPlatos(Plato platoCalificado, Mesa mesa){
        if (platoCalificado.getCalificacion() >= 4.5 && platoCalificado.getCantidadCalificaciones() >= 3){
            mesa.getRestaurante().agregarPlatoRecomendado(platoCalificado);
            platoCalificado.setRecomendado(true);
            platoCalificado.setPrecio((int) (platoCalificado.getPrecio() + (platoCalificado.getPrecio() * 0.2)));
        }
        if (platoCalificado.getCalificacion() <= 3.7 && platoCalificado.getCantidadCalificaciones() >= 3){
            mesa.getRestaurante().agregarPlatoDescuento(platoCalificado);
            platoCalificado.setPrecio((int) (platoCalificado.getPrecio() - (platoCalificado.getPrecio() * 0.15)));
        }

    }

    public static Restaurante actualizarMenu(Mesa mesa){
        Restaurante restaurante = mesa.getRestaurante();
        for (Plato plato : mesa.getRestaurante().getPlatosRecomendados()){
            if (plato.getPedidosRecomendados() >= 2){
                if (plato.getCalificacion() > 4.5){
            } else {
                restaurante.eliminarPlatoRecomendado(plato);
                plato.setPrecio((int) (plato.getPrecio() - (plato.getPrecio() * 0.2)));
            }
            }
        }
        for (Plato plato : mesa.getRestaurante().getPlatosDescuento()){
            if (plato.getPedidosRecomendados() >= 2){
                if (plato.getCalificacion() < 3.7){
                    restaurante.eliminarPlato(plato);
                    System.out.println("El plato " + plato.getNombre() + " ha sido eliminado del menú.");
                    System.out.println("¿Qué desea hacer?");
                    System.out.println("""
                            1. Añadir otro plato.
                            2. Traer un plato de otra sede.
                            Escriba un número para elegir su opción.""");
                    int eleccion = readInt();
                    switch (eleccion){
                        case 1:
                            System.out.println("Por favor ingrese el nombre del plato.");
                            String nombrePlato = readString();
                            System.out.println("Por favor ingrese el precio del plato.");
                            int precioPlato = readInt();
                            System.out.println("Por favor ingrese los ingredientes del plato.");
                            ArrayList<Ingrediente> ingredientes = new ArrayList<>();
                            while (true){
                                System.out.println("Por favor ingrese el nombre del ingrediente o Stop para detenerse:");
                                String nombreIngrediente = readString();
                                for (Ingrediente ingrediente : Ingrediente.getListaIngredientes()){
                                    if (ingrediente.getNombre().equals(nombreIngrediente)){
                                        ingredientes.add(ingrediente);
                                        break;
                                    }
                                }
                                if (nombreIngrediente.equals("Stop")){
                                    break;
                                }
                            }
                            restaurante.agregarPlato(new Plato(nombrePlato, precioPlato, ingredientes));
                            System.out.println("Se ha añadido un nuevo plato al menú.");
                            break;
                        case 2:
                            System.out.println("Por favor ingrese el nombre del plato.");
//                            String nombrePlato2 = readString();
//                            for (Restaurante restaurante1 : Restaurante.restaurantes){
//                                for (Plato plato1 : restaurante1.getMenu()){
//                                    if (plato1.getNombre().equals(nombrePlato2)){
//                                        restaurante.getMenu().add(plato1);
//                                    }
//                                }
//                            }
                            break;
                        default:
                            System.out.println("Número no válido.");
                            break;
                    }
                } else {
                    restaurante.eliminarPlatoDescuento(plato);
                    plato.setPrecio((int) (plato.getPrecio() + (plato.getPrecio() * 0.15)));
                }
            }
        }
        return restaurante;
    }

    public static int aplicarDescuentosCuenta(Cliente cliente, int valorPorPersona) {
        int valorFinal = 0;
        if (cliente.getAfiliacion() != null) {
            valorFinal = valorPorPersona;
            System.out.println("Se aplicaron descuentos por su nivel de afiliación.");
            if (cliente.getAfiliacion().equals("Estrellita")) {
                switch (cliente.getFactura().getMetodoPago()) {
                    case "Efectivo" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.05));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.07));;
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        }
                    }
                    case "Tarjeta" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.03));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.05));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        }
                    }
                    case "Cheque" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.02));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 0);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.03));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        }
                    }
                    case "Puntos" -> {
                    }
                }
            } else if (cliente.getAfiliacion().equals("Estrella")) {
                switch (cliente.getFactura().getMetodoPago()) {
                    case "Efectivo" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.07));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.15));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 4);
                        }
                    }
                    case "Tarjeta" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.08));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.15));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 4);
                        }
                    }
                    case "Cheque" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.02));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 0);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.1));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        }
                    }
                    case "Puntos" -> {
                    }
                }
            } else if (cliente.getAfiliacion().equals("Super estrellota")) {
                switch (cliente.getFactura().getMetodoPago()) {
                    case "Efectivo" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.1));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 6);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.2));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 8);
                        }
                    }
                    case "Tarjeta" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.15));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 6);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.25));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 8);
                        }
                    }
                    case "Cheque" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.05));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.08));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        }
                    }
                    case "Puntos" -> {
                    }
                }
        }
        } else {
            valorFinal = valorPorPersona;
        }
        return valorFinal;
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