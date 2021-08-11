package com.company;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Administrador extends Conserje {

    public Administrador() {
    }

    public Administrador(String nombre, String apellido, String dni, String usuario, String constrasena) {
        super(nombre, apellido, dni, usuario, constrasena);
    }

    public void crearConserje() {

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


        Conserje nuevoConserje = new Conserje(nombre, apellido, dni, usuario, contrasena);

        Hotel.getUsuarioList().add(nuevoConserje);
    }

    public void crearAdministrador() {

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


        Administrador nuevoAdministrador = new Administrador(nombre, apellido, dni, usuario, contrasena);

        Hotel.getUsuarioList().add(nuevoAdministrador);
    }

    public void modificarAdministrador(Administrador administrador) {

        int com;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Modificar Administrador");

            System.out.println(administrador);

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
                    administrador.setNombre(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Ingrese nuevo apellido");
                    administrador.setApellido(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Ingrese nuevo dni");
                    administrador.setDni(scanner.nextLine());
                    break;

                case 4:
                    System.out.println("Ingrese nuevo usuario");
                    administrador.setUsuario(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Ingrese nueva contraseña");
                    administrador.setConstrasena(scanner.nextLine());
                    break;
            }


        } while (com != 0);
    }

    public Usuario buscarUsuario(String dni) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario.isActivo() && usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioSinFil(String dni) {
        for (Usuario usuario : Hotel.getUsuarioList()) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    public void darBajaAlta(Usuario user) {

        Scanner scanner = new Scanner(System.in);
        String com;

        if (user != null && user.isActivo()) {
            System.out.println("Desea darlo de baja?: [s/n]");
            com = scanner.next();

            if (com.equals("s")) {
                System.out.println("Se ha realizado la baja");
                user.setActivo(false);
            } else {
                System.out.println("No se ha realizado la baja.");
            }

        } else if (user != null && !user.isActivo()) {

            System.out.println("Desea darlo de alta?: [s/n]");
            com = scanner.next();

            if (com.equals("s")) {
                System.out.println("Se ha realizado el alta");
                user.setActivo(true);
            } else {
                System.out.println("No se ha realizado el alta");
            }
        } else {
            System.out.println("\nNo se ha encontrado al usuario.\n");
        }
    }

    public void modificarPasajero(Pasajero pasajero) {

        int com;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Modificar Pasajero");

            System.out.println(pasajero);

            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. DNI");
            System.out.println("4. Usuario");
            System.out.println("5. Contraseña");
            System.out.println("6. Direccion");
            System.out.println("7. Telefono");
            System.out.println("8. Email");
            System.out.println("0. Salir");

            com = scanner.nextInt();

            scanner.nextLine();

            switch (com) {

                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    pasajero.setNombre(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Ingrese nuevo apellido");
                    pasajero.setApellido(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Ingrese nuevo dni");
                    pasajero.setDni(scanner.nextLine());
                    break;

                case 4:
                    System.out.println("Ingrese nuevo usuario");
                    pasajero.setUsuario(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Ingrese nueva contraseña");
                    pasajero.setConstrasena(scanner.nextLine());
                    break;

                case 6:
                    System.out.println("Ingrese nuevo direccion");
                    pasajero.setDireccion(scanner.nextLine());
                    break;

                case 7:
                    System.out.println("Ingrese nuevo telefono");
                    pasajero.setTelefono(scanner.nextLine());
                    break;

                case 8:
                    System.out.println("Ingrese nuevo email");
                    pasajero.setEmail(scanner.nextLine());
                    break;

            }


        } while (com != 0);
    }


    public void modPrecioTipoHabitacion(TipoDeHabitacion tipo, double nuevoPrecio) {
        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getTipo().equals(tipo)) {
                habitacion.setPrecio(nuevoPrecio);
            }
        }
    }


    public void modificarHabitacion() {

        int com;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Modificar Habitaciones \n\n");
            System.out.println("1. Modificar Estado");
            System.out.println("2. Modificar Precio");
            System.out.println("\n0. Atras");

            com = scanner.nextInt();

            switch (com) {

                case 1:
                    System.out.println("Modificar estado de la habitacion\n\n");

                    System.out.println("Ingrese el numero de la habitacion: ");
                    String nro = scanner.next();
                    Habitacion habitacion = buscarHabitacionNro(nro);

                    System.out.println("Estado: " + habitacion.getEstado());

                    System.out.println("Elija el nuevo estado\n");
                    System.out.println("1. Libre");
                    System.out.println("2. Ocupada");
                    System.out.println("3. Reservada");
                    System.out.println("4. Limpieza");
                    System.out.println("5. Reparacion");

                    System.out.println("\n0. Atras");

                    int com1 = scanner.nextInt();

                    switch (com1) {

                        case 1:
                            habitacion.setEstado(EstadoHabitacion.LIBRE);
                            break;
                        case 2:
                            habitacion.setEstado(EstadoHabitacion.OCUPADA);
                            break;
                        case 3:
                            habitacion.setEstado(EstadoHabitacion.RESERVADA);
                            break;
                        case 4:
                            habitacion.setEstado(EstadoHabitacion.LIMPIEZA);
                            break;
                        case 5:
                            habitacion.setEstado(EstadoHabitacion.REPARACION);
                            break;

                        case 0:
                            break;

                        default:
                    }

                    break;

                case 2:
                    System.out.println("Modificar precio de las habitaciones\n\n");

                    System.out.println("Elija el tipo de habitacion\n");
                    System.out.println("1. Individual");
                    System.out.println("2. Doble");
                    System.out.println("3. Triple");
                    System.out.println("4. Queen");

                    System.out.println("0. Atras");

                    int com2 = scanner.nextInt();

                    double precio = 0;

                    if (com2 != 0) {
                        System.out.print("Ingrese nuevo precio: $");
                        precio = scanner.nextDouble();
                    }

                    switch (com2) {

                        case 1:
                            modPrecioTipoHabitacion(TipoDeHabitacion.INDIVIDUAL, precio);
                            break;

                        case 2:
                            modPrecioTipoHabitacion(TipoDeHabitacion.DOBLE, precio);
                            break;

                        case 3:
                            modPrecioTipoHabitacion(TipoDeHabitacion.TRIPLE, precio);
                            break;

                        case 4:
                            modPrecioTipoHabitacion(TipoDeHabitacion.QUEEN, precio);
                            break;

                        case 0:
                            break;
                    }
                    break;
            }
        } while (com != 0);
    }

    public void guardarListaUsuarioArchivo() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("usuariosList.json"), Hotel.getUsuarioList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarListaUsuarioArchivo() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Usuario.class);
        try {
            List<Usuario> usuarioList = mapper.readValue(new File("usuariosList.json"), javaType);
            Hotel.setUsuarioList(usuarioList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void guardarListaReservaArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("reservasList.json"), Hotel.getReservaList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarListaReservaArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Reserva.class);

        try {
            List<Reserva> reservasList = mapper.readValue(new File("reservasList.json"), javaType);
            Hotel.setReservaList(reservasList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void guardarListaHabitacionArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("habitacionesList.json"), Hotel.getHabitacionList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarListaHabitacionArchivo() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Habitacion.class);

        try {
            List<Habitacion> habitacionesList = mapper.readValue(new File("habitacionesList.json"), javaType);
            Hotel.setHabitacionList(habitacionesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
