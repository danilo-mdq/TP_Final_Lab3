package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public  class Hotel {


    private static List<Usuario> usuarioList = new ArrayList<>();

    private static List<Habitacion> habitacionList = new ArrayList<>();

    private static List<Reserva> reservaList = new ArrayList<>();

    public static List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public static void setUsuarioList(List<Usuario> usuarioList) {
        Hotel.usuarioList = usuarioList;
    }

    public static List<Habitacion> getHabitacionList() {
        return habitacionList;
    }

    public static void setHabitacionList(List<Habitacion> habitacionList) {
        Hotel.habitacionList = habitacionList;
    }

    public static List<Reserva> getReservaList() {
        return reservaList;
    }

    public static void setReservaList(List<Reserva> reservaList) {
        Hotel.reservaList = reservaList;
    }

    public static Usuario inicioDeSesion() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Usuario: ");
        String user = scanner.nextLine();

        System.out.print("Contraseña: ");
        String pass = scanner.nextLine();

        for (Usuario usuario : usuarioList) {

            if (usuario.isActivo() && usuario.getUsuario().equals(user) && usuario.getConstrasena().equals(pass)) {

                return usuario;
            }
        }
        return null;
    }

    public static void registroPasajero(){

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

            usuarioList.add(nuevoPasajero);

        }

}
