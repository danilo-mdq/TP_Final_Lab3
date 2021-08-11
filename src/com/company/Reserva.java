package com.company;

import java.time.LocalDate;


public class Reserva {

    private String numeroHabitacion;
    private String dniPasajero;
    private LocalDate fechaIn;
    private LocalDate fechaOut;
    private Double precio;

    private boolean activo = true;

    public Reserva() {
    }

    public Reserva(String numeroHabitacion, String dniPasajero, LocalDate fechaIn, LocalDate fechaOut, Double precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.dniPasajero = dniPasajero;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.precio = precio;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getDniPasajero() {
        return dniPasajero;
    }

    public void setDniPasajero(String dniPasajero) {
        this.dniPasajero = dniPasajero;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public LocalDate getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(LocalDate fechaOut) {
        this.fechaOut = fechaOut;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return  "Habitacion Nro..." + this.numeroHabitacion + "\n" +
                "DNI Pasajero.........." + this.dniPasajero + "\n" +
                "Fecha de entrada.........." + this.fechaIn + "\n" +
                "Fecha de salida.........." + this.fechaOut + "\n" +
                "Precio.... $" + this.precio + "\n";
    }
}
