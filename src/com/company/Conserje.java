package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


public class Conserje extends Usuario implements Descuento {


    public Conserje() {
    }

    public Conserje(String nombre, String apellido, String dni, String usuario, String constrasena) {
        super(nombre, apellido, dni, usuario, constrasena);
    }

    public Habitacion buscarHabitacionDisponible(TipoDeHabitacion tipo) {
        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getTipo().equals(tipo)) {
                if (habitacion.getEstado().equals(EstadoHabitacion.LIBRE)) {
                    return habitacion;
                }
            }
        }
        return null;
    }

    public void mostrarHabitacionesEstado(EstadoHabitacion estado) {
        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getEstado().equals(estado)) {
                System.out.println(habitacion);
            }
        }
    }


    public void mostrarHabitacionesTipo(TipoDeHabitacion tipo) {
        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getTipo().equals(tipo)) {
                System.out.println(habitacion);
            }
        }
    }

    public Pasajero buscarPasajerosUsuario(String user) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario instanceof Pasajero && usuario.isActivo() && usuario.getUsuario().equals(user)) {
                return (Pasajero) usuario;
            }
        }

        return null;
    }

    public Pasajero buscarPasajerosNombre(String nombre) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario instanceof Pasajero && usuario.isActivo() && usuario.getNombre().equals(nombre)) {
                return (Pasajero) usuario;
            }
        }
        return null;
    }

    public Pasajero buscarPasajerosApellido(String apellido) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario instanceof Pasajero && usuario.isActivo() && usuario.getApellido().equals(apellido)) {
                return (Pasajero) usuario;
            }
        }
        return null;
    }

    public Pasajero buscarPasajerosDni(String dni) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario instanceof Pasajero && usuario.isActivo() && usuario.getDni().equals(dni)) {
                return (Pasajero) usuario;
            }
        }
        return null;
    }


    public void mostrarReservas() {
        for (Reserva reserva : Hotel.getReservaList()) {
            if (reserva.isActivo()) {
                System.out.println(reserva);
            }
        }
    }

    public Conserje buscarConserjeDni(String dni) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario instanceof Conserje && usuario.isActivo() && usuario.getDni().equals(dni)) {
                return (Conserje) usuario;
            }
        }
        return null;
    }

    public void modificarConserje(Conserje conserje) {

        int com;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Modificar Conserje");

            System.out.println(conserje);

            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. DNI");
            System.out.println("4. Usuario");
            System.out.println("5. Contraseña");

            System.out.println("\n0. Salir");

            com = scanner.nextInt();

            scanner.nextLine();

            switch (com) {

                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    conserje.setNombre(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Ingrese nuevo apellido");
                    conserje.setApellido(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Ingrese nuevo dni");
                    conserje.setDni(scanner.nextLine());
                    break;

                case 4:
                    System.out.println("Ingrese nuevo usuario");
                    conserje.setUsuario(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Ingrese nueva contraseña");
                    conserje.setConstrasena(scanner.nextLine());
                    break;
            }


        } while (com != 0);
    }


    public Pasajero crearPasajero() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Ingrese direccion: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese mail: ");
        String mail = scanner.nextLine();

        Pasajero nuevoPasajero = new Pasajero(nombre, apellido, dni, usuario, contrasena, direccion, telefono, mail);
        Hotel.getUsuarioList().add(nuevoPasajero);
        return nuevoPasajero;
    }


    public Reserva buscarReservaPasajero(String dni) {
        for (Reserva reserva : Hotel.getReservaList()) {
            if (reserva.getDniPasajero().equals(dni)) {
                return reserva;
            }
        }
        return null;
    }

    public Habitacion buscarHabitacionNro(String nro) {
        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getNumero().equals(nro)) {
                return habitacion;
            }
        }
        return null;

    }

    public void checkIn() {

        Scanner scanner = new Scanner(System.in);

        String com;

        Habitacion habitacion = null;
        System.out.print("Tiene una reserva? [s/n]: ");
        com = scanner.nextLine();

        if (com.equals("s")) {
            Reserva reserva;
            String dni;

            while (com.equals("s")) {

                System.out.print("Ingrese numero de DNI del pasajero: ");
                dni = scanner.nextLine();

                reserva = buscarReservaPasajero(dni);

                if (reserva != null) {
                    com = "n";

                    habitacion = buscarHabitacionNro(reserva.getNumeroHabitacion());

                    System.out.println("Se le asigno la habitacion nro: " + habitacion.getNumero());
                    System.out.println(" ");

                    Pasajero pasajero2 = buscarPasajerosDni(reserva.getDniPasajero());
                    pasajero2.setReserva(null);
                    habitacion.setDniPasajero(reserva.getDniPasajero());
                    habitacion.setCheckIn(LocalDate.now());
                    habitacion.setEstado(EstadoHabitacion.OCUPADA);
                    habitacion.setCheckOut(null);

                    reserva.setActivo(false);

                } else {
                    System.out.print("No se encontro la reserva. Desea buscar otra vez? [s/n]: ");
                    com = scanner.nextLine();
                }
            }

        } else {

            com = "s";

            while (com.equals("s")) {

                int opt;

                System.out.println("Tipos de habitaciones: \n");
                System.out.println("1. Individual");
                System.out.println("2. Doble");
                System.out.println("3. Triple");
                System.out.println("4. Queen");

                opt = scanner.nextInt();

                switch (opt) {
                    //INDIVIDUAL
                    case 1:
                        habitacion = buscarHabitacionDisponible(TipoDeHabitacion.INDIVIDUAL);
                        break;
                    //Doble
                    case 2:
                        habitacion = buscarHabitacionDisponible(TipoDeHabitacion.DOBLE);
                        break;
                    //Triple
                    case 3:
                        habitacion = buscarHabitacionDisponible(TipoDeHabitacion.TRIPLE);
                        break;
                    //Queen
                    case 4:
                        habitacion = buscarHabitacionDisponible(TipoDeHabitacion.QUEEN);
                        break;

                    default:
                }

                if (habitacion != null) {
                    com = "n";

                    System.out.println("Se le asigno la habitacion nro: " + habitacion.getNumero());
                    System.out.println(" ");

                    System.out.println("Que tipo de regimen de comida desea?");

                    System.out.println("1. Media pension");
                    System.out.println("2. Pension completa");

                    int com1 = scanner.nextInt();

                    if (com1 == 1) {
                        habitacion.setRegimenComida(RegimenComida.MEDIA_PENSION);
                    } else {
                        habitacion.setRegimenComida(RegimenComida.PENSION_COMPLETA);
                    }

                    System.out.print("Ingrese el usuario del pasajero: ");

                    scanner.next();
                    String usuario = scanner.next();

                    Pasajero pasajero = buscarPasajerosUsuario(usuario);

                    if (pasajero == null) {
                        pasajero = crearPasajero();
                    }

                    System.out.println("Datos del pasajero: \n");
                    System.out.println(pasajero);
                    System.out.println(" ");

                    habitacion.setDniPasajero(pasajero.getDni());
                    habitacion.setCheckIn(LocalDate.now());
                    habitacion.setEstado(EstadoHabitacion.OCUPADA);
                    habitacion.setCheckOut(null);

                    System.out.println("El CheckIn fue realizado con exito! \n\n");

                } else {
                    System.out.print("No hay habitaciones disponibles de ese tipo, desea buscar habitaciones de otro tipo?: [s/n]");
                    com = scanner.next();
                }
            }

        }
    }

    public Habitacion buscarHabitacionPasajero(String dni) {

        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getDniPasajero() != null && habitacion.getDniPasajero().equals(dni)) {
                return habitacion;
            }
        }
        return null;
    }

    public int calcularTotalDias(LocalDate desde, LocalDate hasta) {

        Period period = Period.between(desde, hasta);
        int periodo = period.getDays();

        if (periodo == 0) {
            periodo = 1;
        }

        return periodo;

    }

    public double calcularPrecioDias(Habitacion habitacion, double comida, LocalDate desde, LocalDate hasta) {
        if (habitacion != null) {
            return (habitacion.getPrecio() + comida) * calcularTotalDias(desde, hasta);
        }
        return 0;
    }

    public void checkOut() {

        double total;
        String com = "s";

        Scanner scanner = new Scanner(System.in);

        while (com.equals("s")) {

            System.out.println("Ingrese DNI del pasajero: ");

            String dni = scanner.nextLine();

            Habitacion habitacion = buscarHabitacionPasajero(dni);

            if (habitacion != null) {
                com = "n";

                habitacion.setCheckOut(LocalDate.now());

                double valorComida;

                if (habitacion.getRegimenComida() == RegimenComida.PENSION_COMPLETA) {
                    valorComida = 200;
                } else {
                    valorComida = 100;
                }

                total = calcularPrecioDias(habitacion, valorComida, habitacion.getCheckIn(), habitacion.getCheckOut());

                double descuento = 0;
                String opcion;
                int opt;
                System.out.print("¿Tiene voucher de descuento? [s/n]: ");
                opcion = scanner.next();

                if (opcion.equals("s")) {

                    System.out.println("Elija el descuento: ");
                    System.out.println("1. 5% ");
                    System.out.println("2. 10% ");
                    System.out.println("3. 15% ");
                    System.out.println("0. No aplicar descuento");

                    opt = scanner.nextInt();
                    switch (opt) {
                        case 1:
                            descuento = 5;
                            break;
                        case 2:
                            descuento = 10;
                            break;
                        case 3:
                            descuento = 15;
                            break;
                    }

                    if (descuento != 0) {
                        total = aplicarDescuento(descuento, total);
                    }
                }
                habitacion.setCheckIn(null);
                habitacion.setEstado(EstadoHabitacion.LIBRE);
                habitacion.setDniPasajero(null);
                habitacion.setRegimenComida(null);

                System.out.println(" ");
                System.out.println("Usted debe pagar:" + total);
                System.out.println(" ");
                System.out.println("Gracias por su visita");

            } else {

                System.out.print("No se ha encontrado una habitacion con ese pasajero. Desea volver a buscar? [s/n]: ");
                com = scanner.nextLine();
            }
        }

    }


    public void reservar() {

        Scanner scanner = new Scanner(System.in);

        String com = "s";

        Habitacion habitacion = null;

        while (com.equals("s")) {
            int opt;

            System.out.println("¿Que tipo de habitacion desea elegir?\n");
            System.out.println("1. Individual");
            System.out.println("2. Doble");
            System.out.println("3. Triple");
            System.out.println("4. Queen");

            opt = scanner.nextInt();

            switch (opt) {
                //INDIVIDUAL
                case 1:
                    habitacion = buscarHabitacionDisponible(TipoDeHabitacion.INDIVIDUAL);
                    break;
                //Doble
                case 2:
                    habitacion = buscarHabitacionDisponible(TipoDeHabitacion.DOBLE);
                    break;
                //Triple
                case 3:
                    habitacion = buscarHabitacionDisponible(TipoDeHabitacion.TRIPLE);
                    break;
                //Queen
                case 4:
                    habitacion = buscarHabitacionDisponible(TipoDeHabitacion.QUEEN);
                    break;
            }

            if (habitacion == null) {
                System.out.println("No hay habitaciones disponibles de ese tipo, esea buscar habitaciones de otro tipo?: [s/n]");
                com = scanner.next();

            } else {
                com = "n";

                System.out.println("Se le asigno la habitacion nro: " + habitacion.getNumero());


                System.out.println("Que tipo de regimen de comida desea?");

                System.out.println("1. Media pension");
                System.out.println("2. Pension completa");

                int com1 = scanner.nextInt();

                if (com1 == 1) {
                    habitacion.setRegimenComida(RegimenComida.MEDIA_PENSION);
                } else {
                    habitacion.setRegimenComida(RegimenComida.PENSION_COMPLETA);
                }

                System.out.print("Ingrese el usuario del pasajero: ");
                String usuario = scanner.next();

                Pasajero pasajero = buscarPasajerosUsuario(usuario);

                if (pasajero == null) {
                    pasajero = crearPasajero();
                }

                habitacion.setDniPasajero(pasajero.getDni());
                habitacion.setEstado(EstadoHabitacion.RESERVADA);
                habitacion.setCheckOut(null);

                int anio, mes, dia;

                System.out.println("ingrese fecha de entrada: ");
                System.out.print("Año: ");
                anio = scanner.nextInt();
                System.out.print("Mes: ");
                mes = scanner.nextInt();
                System.out.print("Dia: ");
                dia = scanner.nextInt();

                LocalDate fechaIn = LocalDate.of(anio, mes, dia);

                System.out.println("ingrese fecha de salida: ");
                System.out.print("Año: ");
                anio = scanner.nextInt();
                System.out.print("Mes: ");
                mes = scanner.nextInt();
                System.out.print("Dia: ");
                dia = scanner.nextInt();

                LocalDate fechaOut = LocalDate.of(anio, mes, dia);

                double valorComida;

                if (habitacion.getRegimenComida() == RegimenComida.PENSION_COMPLETA) {
                    valorComida = 200;
                } else {
                    valorComida = 100;
                }


                Reserva reserva = new Reserva(habitacion.getNumero(), pasajero.getDni(), fechaIn, fechaOut, calcularPrecioDias(habitacion, valorComida, fechaIn, fechaOut));

                pasajero.setReserva(reserva);
                Hotel.getReservaList().add(reserva);
                System.out.println("Reserva realizada con exito ");
                System.out.println("-------------------------------------------");
            }
        }
    }

    public void cancelarReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cancelar Reserva\n");

        System.out.print("Ingrese DNI del pasajero:");
        String dni = scanner.next();
        Reserva reserva = buscarReservaPasajero(dni);

        if (reserva != null) {

            reserva.setActivo(false);

            Habitacion habitacion = buscarHabitacionPasajero(dni);

            if (habitacion != null) {
                habitacion.setEstado(EstadoHabitacion.LIBRE);
                habitacion.setDniPasajero(null);
                habitacion.setRegimenComida(null);
            }

            Pasajero pasajero = buscarPasajerosDni(dni);

            if (pasajero != null) {
                pasajero.setReserva(null);
            }

            System.out.println("Se ha cancelado la reserva.\n\n");
        } else {
            System.out.println("El pasajero no realizo una reserva.\n\n");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double aplicarDescuento(double porcentaje, double total) {
        total -= (total * porcentaje) / 100;
        return total;
    }
}




