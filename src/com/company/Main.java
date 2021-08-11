package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Administrador admin = new Administrador("Bruno", "Fabrizio", "40579965", "brunofz", "1759");

        /*
        Administrador admin2 = new Administrador("Danilo", "Suarez", "33102857", "danilomdq", "2481");

        Conserje conserje = new Conserje("Ezequiel", "Rage", "27123123", "eze", "1234");

        Pasajero pasajero = new Pasajero("Carlos", "Miranda", "32123123", "charly", "1234", "Funes 2461", "2236688139", "charly@gmail.com");
        Pasajero pasajero1 = new Pasajero("Gina", "Fabrizio", "30123543", "gi", "1234", "Las heras 2461", "223599889", "gina@gmail.com");
        Pasajero pasajero2 = new Pasajero("Gustavo", "Manzo", "47676667", "gustavo", "1234", "20 de Septiembre 2461", "223887767", "gustavo@gmail.com");
        Hotel.getUsuarioList().add(admin);
        Hotel.getUsuarioList().add(admin2);
        Hotel.getUsuarioList().add(conserje);
        Hotel.getUsuarioList().add(pasajero);
        Hotel.getUsuarioList().add(pasajero1);
        Hotel.getUsuarioList().add(pasajero2);

        Habitacion habi = new Habitacion("1", "1", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi1 = new Habitacion("1", "2", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi2 = new Habitacion("1", "3", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi3 = new Habitacion("1", "4", TipoDeHabitacion.INDIVIDUAL, 333.45, EstadoHabitacion.LIBRE);
        Habitacion habi13 = new Habitacion("2", "5", TipoDeHabitacion.TRIPLE, 900.3, EstadoHabitacion.LIBRE);
        Habitacion habi14 = new Habitacion("2", "6", TipoDeHabitacion.TRIPLE, 900.3, EstadoHabitacion.LIBRE);
        Habitacion habi15 = new Habitacion("2", "7", TipoDeHabitacion.TRIPLE, 900.3, EstadoHabitacion.LIBRE);
        Habitacion habi16 = new Habitacion("2", "8", TipoDeHabitacion.TRIPLE, 900.3, EstadoHabitacion.LIBRE);
        Habitacion habi27 = new Habitacion("3", "9", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi24 = new Habitacion("3", "10", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi23 = new Habitacion("3", "11", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi21 = new Habitacion("3", "12", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi28 = new Habitacion("3", "13", TipoDeHabitacion.QUEEN, 650.7, EstadoHabitacion.LIBRE);
        Habitacion habi29 = new Habitacion("4", "14", TipoDeHabitacion.DOBLE, 550.9, EstadoHabitacion.LIBRE);
        Habitacion habi30 = new Habitacion("4", "15", TipoDeHabitacion.DOBLE, 550.9, EstadoHabitacion.LIBRE);
        Habitacion habi31 = new Habitacion("4", "16", TipoDeHabitacion.DOBLE, 550.9, EstadoHabitacion.LIBRE);
        Habitacion habi33 = new Habitacion("4", "17", TipoDeHabitacion.DOBLE, 550.9, EstadoHabitacion.LIBRE);
        Hotel.getHabitacionList().add(habi);
        Hotel.getHabitacionList().add(habi1);
        Hotel.getHabitacionList().add(habi2);
        Hotel.getHabitacionList().add(habi3);
        Hotel.getHabitacionList().add(habi13);
        Hotel.getHabitacionList().add(habi14);
        Hotel.getHabitacionList().add(habi15);
        Hotel.getHabitacionList().add(habi16);
        Hotel.getHabitacionList().add(habi27);
        Hotel.getHabitacionList().add(habi24);
        Hotel.getHabitacionList().add(habi23);
        Hotel.getHabitacionList().add(habi21);
        Hotel.getHabitacionList().add(habi28);
        Hotel.getHabitacionList().add(habi29);
        Hotel.getHabitacionList().add(habi30);
        Hotel.getHabitacionList().add(habi31);
        Hotel.getHabitacionList().add(habi33);


        admin.guardarListaUsuarioArchivo();
        admin.guardarListaHabitacionArchivo();
        admin.guardarListaReservaArchivo();
*/
//////////////////////////////////////////////////////////////////////////////////////////

        admin.cargarListaUsuarioArchivo();
        admin.cargarListaHabitacionArchivo();
        admin.cargarListaReservaArchivo();

        sistemaHoteleria();

        admin.guardarListaUsuarioArchivo();
        admin.guardarListaHabitacionArchivo();
        admin.guardarListaReservaArchivo();
    }

    public static void sistemaHoteleria() {

        Scanner scanner = new Scanner(System.in);
        int com;

        Habitacion habitacion = null;
        Conserje conserje = null;
        Administrador admin = null;
        Pasajero pasajero = null;

        do {

            System.out.println("Hotel");

            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");

            com = scanner.nextInt();

            switch (com) {

                ///Iniciar sesion
                case 1:
                    System.out.println("inicio de sesion");

                    Usuario user = Hotel.inicioDeSesion();

                    if (user != null) {
                        if (user.getClass().equals(Conserje.class)) {
                            com = 1;
                            conserje = (Conserje) user;

                        } else if (user.getClass().equals(Administrador.class)) {
                            com = 2;
                            admin = (Administrador) user;

                        } else {
                            pasajero = (Pasajero) user;
                            com = 3;
                        }

                    } else {
                        System.out.println("No se econtro al usuario.");
                        com = 4;
                    }

                    switch (com) {

                        ///menu conserje
                        case 1:
                            do {
                                int com2;

                                System.out.println("Menu Conserje\n");
                                System.out.println("1. Realizar CheckIn");
                                System.out.println("2. Realizar CheckOut");
                                System.out.println("3. Realizar Reserva");
                                System.out.println("4. Buscar Pasajeros");
                                System.out.println("5. Mostrar habitaciones por tipo");
                                System.out.println("6. Mostrar habitaciones por estado");
                                System.out.println("7. Mostrar reservas activas");
                                System.out.println("8. Cancelar reserva");
                                System.out.println("9. Modificar mis datos");
                                System.out.println("\n0. Salir");

                                com = scanner.nextInt();

                                switch (com) {

                                    ///CheckIn
                                    case 1:
                                        conserje.checkIn();
                                        break;

                                    //CheckOut
                                    case 2:
                                        conserje.checkOut();
                                        break;

                                    ///Reservar
                                    case 3:
                                        conserje.reservar();
                                        break;
                                    //Buscar pasajeros
                                    case 4:


                                        do {
                                            System.out.println("Buscar pasajeros por:");
                                            System.out.println("1. Nombre");
                                            System.out.println("2. Apellido");
                                            System.out.println("3. Dni");
                                            System.out.println("4. Usuario");
                                            System.out.println("\n0. Salir");

                                            com2 = scanner.nextInt();

                                            switch (com2) {
                                                //Nombre
                                                case 1:
                                                    System.out.println("Ingrese el nombre:  ");
                                                    String nombre = scanner.next();
                                                    System.out.println(conserje.buscarPasajerosNombre(nombre));
                                                    break;
                                                //Apellido
                                                case 2:
                                                    System.out.println("Ingrese el apellido:  ");
                                                    String apellido = scanner.next();
                                                    System.out.println(conserje.buscarPasajerosApellido(apellido));
                                                    break;
                                                //Dni
                                                case 3:
                                                    System.out.print("Ingrese DNI: ");
                                                    String dni = scanner.next();
                                                    System.out.println(conserje.buscarPasajerosDni(dni));
                                                    break;
                                                //Usuario
                                                case 4:
                                                    System.out.println("Ingrese el usuario:  ");
                                                    String usuario = scanner.next();
                                                    System.out.println(conserje.buscarPasajerosUsuario(usuario));
                                                    break;
                                            }

                                        } while (com2 != 0);

                                        break;

                                    case 5:

                                        do {
                                            System.out.println("Tipos de habitaciones");
                                            System.out.println("1. Individual");
                                            System.out.println("2. Doble");
                                            System.out.println("3. Triple");
                                            System.out.println("4. Queen");
                                            System.out.println("\n0. Salir");

                                            com2 = scanner.nextInt();

                                            switch (com2) {
                                                //INDIVIDUAL
                                                case 1:
                                                    conserje.mostrarHabitacionesTipo(TipoDeHabitacion.INDIVIDUAL);
                                                    break;
                                                //Doble
                                                case 2:
                                                    conserje.mostrarHabitacionesTipo(TipoDeHabitacion.DOBLE);
                                                    break;
                                                //Triple
                                                case 3:
                                                    conserje.mostrarHabitacionesTipo(TipoDeHabitacion.TRIPLE);
                                                    break;
                                                //Queen
                                                case 4:
                                                    conserje.mostrarHabitacionesTipo(TipoDeHabitacion.QUEEN);
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com2 != 0);

                                        break;

                                    case 6:

                                        do {
                                            System.out.println("Estado de la habitacion: ");
                                            System.out.println("1. Libre");
                                            System.out.println("2. Ocupada");
                                            System.out.println("3. Reservada");
                                            System.out.println("4. En Limpieza");
                                            System.out.println("5. En Reparacion");
                                            System.out.println("\n0. Salir");


                                            com2 = scanner.nextInt();

                                            switch (com2) {

                                                case 1:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.LIBRE);
                                                    break;

                                                case 2:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.OCUPADA);
                                                    break;

                                                case 3:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.RESERVADA);
                                                    break;

                                                case 4:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.LIMPIEZA);
                                                    break;

                                                case 5:
                                                    conserje.mostrarHabitacionesEstado(EstadoHabitacion.REPARACION);
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com2 != 0);

                                        break;

                                    case 7:
                                        conserje.mostrarReservas();
                                        break;

                                    case 8:
                                        conserje.cancelarReserva();
                                        break;

                                    case 9:
                                        conserje.modificarConserje(conserje);
                                        break;

                                    case 0:
                                        break;
                                }
                            } while (com != 0);
                            break;

                        //Menu admin
                        case 2:
                            do {
                                int com1;

                                System.out.println("Menu Administrador");
                                System.out.println("1. Realizar CheckIn");
                                System.out.println("2. Realizar CheckOut");
                                System.out.println("3. Realizar Reserva");
                                System.out.println("4. Buscar Pasajeros");
                                System.out.println("5. Mostrar habitaciones por tipo");
                                System.out.println("6. Mostrar habitaciones por estado");
                                System.out.println("7. Mostrar reservas activas");
                                System.out.println("8. Cancelar reserva");
                                System.out.println("9. Crear Usuario");
                                System.out.println("10. Modificar Usuarios");
                                System.out.println("11. Modificar Habitaciones");
                                System.out.println("12. Realizar Back-Up");
                                System.out.println("\n0. Salir");

                                com = scanner.nextInt();

                                switch (com) {
                                    //Realizar CheckIn
                                    case 1:
                                        admin.checkIn();
                                        break;
                                    //Realizar CheckOut
                                    case 2:
                                        admin.checkOut();
                                        break;
                                    //Realizar Reserva
                                    case 3:
                                        admin.reservar();
                                        break;
                                    //Buscar Pasajeros
                                    case 4:

                                        do {
                                            System.out.println("Buscar pasajeros por:");
                                            System.out.println("1. Nombre");
                                            System.out.println("2. Apellido");
                                            System.out.println("3. Dni");
                                            System.out.println("4. Usuario");
                                            System.out.println("\n0. Salir");

                                            com1 = scanner.nextInt();

                                            switch (com1) {
                                                //Nombre
                                                case 1:
                                                    System.out.println("Ingrese el nombre:  ");
                                                    String nombre = scanner.next();
                                                    System.out.println(admin.buscarPasajerosNombre(nombre));
                                                    break;
                                                //Apellido
                                                case 2:
                                                    System.out.println("Ingrese el apellido:  ");
                                                    String apellido = scanner.next();
                                                    System.out.println(admin.buscarPasajerosApellido(apellido));
                                                    break;
                                                //Dni
                                                case 3:
                                                    System.out.print("Ingrese DNI: ");
                                                    String dni = scanner.next();
                                                    System.out.println(admin.buscarPasajerosDni(dni));
                                                    break;
                                                //Usuario
                                                case 4:
                                                    System.out.println("Ingrese el usuario:  ");
                                                    String usuario = scanner.next();
                                                    System.out.println(admin.buscarPasajerosUsuario(usuario));
                                                    break;
                                            }

                                        } while (com1 != 0);
                                        break;

                                    case 5:
                                        do {
                                            System.out.println("Tipos de habitaciones");
                                            System.out.println("1. Individual");
                                            System.out.println("2. Doble");
                                            System.out.println("3. Triple");
                                            System.out.println("4. Queen");
                                            System.out.println("\n0. Salir");

                                            com1 = scanner.nextInt();

                                            switch (com1) {
                                                //INDIVIDUAL
                                                case 1:
                                                    admin.mostrarHabitacionesTipo(TipoDeHabitacion.INDIVIDUAL);
                                                    break;
                                                //Doble
                                                case 2:
                                                    admin.mostrarHabitacionesTipo(TipoDeHabitacion.DOBLE);
                                                    break;
                                                //Triple
                                                case 3:
                                                    admin.mostrarHabitacionesTipo(TipoDeHabitacion.TRIPLE);
                                                    break;
                                                //Queen
                                                case 4:
                                                    admin.mostrarHabitacionesTipo(TipoDeHabitacion.QUEEN);
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com1 != 0);

                                        break;

                                    case 6:

                                        do {
                                            System.out.println("Estado de la habitacion: ");
                                            System.out.println("1. Libre");
                                            System.out.println("2. Ocupada");
                                            System.out.println("3. Reservada");
                                            System.out.println("4. En Limpieza");
                                            System.out.println("5. En Reparacion");
                                            System.out.println("0. Salir");


                                            com1 = scanner.nextInt();

                                            switch (com1) {

                                                case 1:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.LIBRE);
                                                    break;

                                                case 2:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.OCUPADA);
                                                    break;

                                                case 3:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.RESERVADA);
                                                    break;

                                                case 4:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.LIMPIEZA);
                                                    break;

                                                case 5:
                                                    admin.mostrarHabitacionesEstado(EstadoHabitacion.REPARACION);
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com1 != 0);

                                        break;

                                    case 7:
                                        admin.mostrarReservas();
                                        break;

                                    case 8:
                                        admin.cancelarReserva();
                                        break;

                                    //Crear Usuario
                                    case 9:
                                        do {
                                            System.out.println("Que tipo de usuario desea crear?: ");
                                            System.out.println("1. Pasajero");
                                            System.out.println("2. Conserje");
                                            System.out.println("3. Administrador");
                                            System.out.println("0. Salir");

                                            com1 = scanner.nextInt();
                                            switch (com1) {
                                                //Pasajer
                                                case 1:
                                                    admin.crearPasajero();
                                                    System.out.println("El nuevo pasajero fue creado con exito. \n\n");
                                                    break;
                                                //Conserje
                                                case 2:
                                                    admin.crearConserje();
                                                    System.out.println("El nuevo Conserje fue creado con exito. \n\n");

                                                    break;
                                                //Administrador
                                                case 3:
                                                    admin.crearAdministrador();
                                                    System.out.println("El nuevo Administrador fue creado con exito. \n\n");

                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com1 != 0);
                                        break;

                                    //Modificar usuarios
                                    case 10:

                                        do {

                                            System.out.println("Modificar usuarios");
                                            System.out.println("1. Modificar");
                                            System.out.println("2. Dar de baja/alta");
                                            System.out.println("0. Salir");

                                            com1 = scanner.nextInt();

                                            switch (com1) {

                                                case 1:
                                                    System.out.println("Ingrese el dni del usuario: ");
                                                    String dni = scanner.next();
                                                    Usuario user1 = admin.buscarUsuario(dni);

                                                    if (user1 != null) {
                                                        if (user1.getClass().equals(Conserje.class)) {
                                                            admin.modificarConserje((Conserje) user1);

                                                        } else if (user1.getClass().equals(Administrador.class)) {
                                                            admin.modificarAdministrador((Administrador) user1);

                                                        } else {
                                                            admin.modificarPasajero((Pasajero) user1);
                                                        }

                                                    } else {
                                                        System.out.println("No se econtro el usuario.");
                                                    }

                                                    break;

                                                case 2:
                                                    System.out.print("Ingrese el DNI del usuario: ");
                                                    String dni1 = scanner.next();
                                                    admin.darBajaAlta(admin.buscarUsuarioSinFil(dni1));
                                                    break;

                                                case 0:
                                                    break;
                                            }

                                        } while (com1 != 0);

                                        break;

                                    case 11:
                                        admin.modificarHabitacion();
                                        break;

                                    //Realizar Back-Up
                                    case 12:
                                        admin.guardarListaUsuarioArchivo();
                                        admin.guardarListaHabitacionArchivo();
                                        admin.guardarListaReservaArchivo();
                                        System.out.println("Backup realizado con exito!");
                                        break;

                                    default:
                                }
                            } while (com != 0);
                            break;

                        //Menu Pasajero
                        case 3:
                            do {
                                System.out.println("Menu Pasajero\n");
                                System.out.println("1. Realizar reserva remota");
                                System.out.println("2. Ver mis datos");
                                System.out.println("3. Ver mi reserva");
                                System.out.println("4. Cancelar mi reserva");
                                System.out.println("5. Modificar mis datos");
                                System.out.println("\n0. Salir");

                                com = scanner.nextInt();

                                switch (com) {

                                    case 1:
                                        pasajero.reservaRemota(pasajero);
                                        break;

                                    case 2:
                                        System.out.println(pasajero);
                                        break;

                                    case 3:
                                        pasajero.verMiReserva();
                                        break;

                                    case 4:
                                        pasajero.cancelarMiReserva();
                                        break;

                                    case 5:
                                        pasajero.modificarPasajero();
                                        break;

                                    case 0:
                                        break;

                                    default:

                                }
                            } while (com != 0);
                            break;

                        case 4:
                            break;

                        default:
                    }

                    break;

                case 2:
                    System.out.println("Registrarse");
                    Hotel.registroPasajero();
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
            }
        } while (com != 3);
    }
}

