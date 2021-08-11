package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;


public class Pasajero extends Usuario implements Serializable {

    private String direccion;
    private String telefono;
    private String email;
    private Reserva reserva = null;

    public Pasajero() {
    }


    public Pasajero(String nombre, String apellido, String dni, String usuario, String constrasena, String direccion, String telefono, String email) {
        super(nombre, apellido, dni, usuario, constrasena);
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }


    public void modificarPasajero() {

        int com;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Modificar Pasajero");

            System.out.println(this);

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
                    this.setNombre(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Ingrese nuevo apellido");
                    this.setApellido(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Ingrese nuevo dni");
                    this.setDni(scanner.nextLine());
                    break;

                case 4:
                    System.out.println("Ingrese nuevo usuario");
                    this.setUsuario(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Ingrese nueva contraseña");
                    this.setConstrasena(scanner.nextLine());
                    break;

                case 6:
                    System.out.println("Ingrese nuevo direccion");
                    this.setDireccion(scanner.nextLine());
                    break;

                case 7:
                    System.out.println("Ingrese nuevo telefono");
                    this.setTelefono(scanner.nextLine());
                    break;

                case 8:
                    System.out.println("Ingrese nuevo email");
                    this.setEmail(scanner.nextLine());
                    break;

            }


        } while (com != 0);
    }


    public Habitacion buscarMiHabitacion() {
        for (Habitacion habitacion : Hotel.getHabitacionList()) {
            if (habitacion.getDniPasajero() != null && habitacion.getDniPasajero().equals(this.getDni())) {
                return habitacion;
            }
        }
        return null;
    }

    public void reservaRemota(Pasajero pasajero) {

        Scanner scanner = new Scanner(System.in);
        Conserje conserje = new Conserje();

        String com = "s";

        Habitacion habitacion = null;

        while (com.equals("s")) {
            int opt;

            System.out.println("Reserva\n");
            System.out.println("Seleccione el Tipo de habitacion");
            System.out.println("1. Individual");
            System.out.println("2. Doble");
            System.out.println("3. Triple");
            System.out.println("4. Queen");

            opt = scanner.nextInt();

            switch (opt) {
                //INDIVIDUAL
                case 1:
                    habitacion = conserje.buscarHabitacionDisponible(TipoDeHabitacion.INDIVIDUAL);
                    break;
                //Doble
                case 2:
                    habitacion = conserje.buscarHabitacionDisponible(TipoDeHabitacion.DOBLE);
                    break;
                //Triple
                case 3:
                    habitacion = conserje.buscarHabitacionDisponible(TipoDeHabitacion.TRIPLE);
                    break;
                //Queen
                case 4:
                    habitacion = conserje.buscarHabitacionDisponible(TipoDeHabitacion.QUEEN);
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


                habitacion.setDniPasajero(pasajero.getDni());
                habitacion.setEstado(EstadoHabitacion.RESERVADA);
                habitacion.setCheckOut(null);

                int anio, mes, dia;

                System.out.println("Ingrese fecha de entrada: ");
                System.out.print("Año: ");
                anio = scanner.nextInt();
                System.out.print("Mes: ");
                mes = scanner.nextInt();
                System.out.print("Dia: ");
                dia = scanner.nextInt();

                LocalDate fechaIn = LocalDate.of(anio, mes, dia);

                System.out.println("Ingrese fecha de salida: ");
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

                Reserva reserva = new Reserva(habitacion.getNumero(), pasajero.getDni(), fechaIn, fechaOut, conserje.calcularPrecioDias(habitacion, valorComida, fechaIn, fechaOut));

                this.reserva = reserva;

                Hotel.getReservaList().add(reserva);

                System.out.println("La reserva se ha realizado exitosamente!");
            }
        }
    }

    public void verMiReserva() {
        if (this.reserva != null) {
            System.out.println("Mi reserva: \n");
            System.out.println(reserva);
        } else {
            System.out.println("Usted no realizo una reserva. \n\n");
        }

    }

    public void cancelarMiReserva() {
        if (this.reserva != null) {
            int index = Hotel.getReservaList().indexOf(reserva);
            Hotel.getReservaList().get(index).setActivo(false);
            this.reserva = null;
            Habitacion habitacion = buscarMiHabitacion();
            habitacion.setRegimenComida(null);
            habitacion.setEstado(EstadoHabitacion.LIBRE);
            habitacion.setDniPasajero(null);
            System.out.println("Se ha cancelado la reserva");
        }else{
            System.out.println("Usted no realizo una reserva. \n\n");
        }

    }

    @Override
    public String toString() {
        return super.toString() +
                "Direccion........" + direccion + "\n" +
                "Telefono........." + telefono + "\n" +
                "Email............" + email + "\n";
    }
}
