package com.company;



import java.time.LocalDate;


public class Habitacion {


    private String piso;
    private String numero;
    private TipoDeHabitacion tipo;

    private RegimenComida regimenComida;

    private Double precio;

    private String dniPasajero;

    private LocalDate checkIn;
    private LocalDate checkOut;
    private EstadoHabitacion Estado;



    public Habitacion() {
    }


    public Habitacion(String piso, String numero, TipoDeHabitacion tipo, Double precio, EstadoHabitacion estado) {
        this.piso = piso;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.Estado = estado;
    }

    public RegimenComida getRegimenComida() {
        return regimenComida;
    }

    public void setRegimenComida(RegimenComida regimenComida) {
        this.regimenComida = regimenComida;
    }

    public String getDniPasajero() {
        return dniPasajero;
    }

    public void setDniPasajero(String dniPasajero) {
        this.dniPasajero = dniPasajero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoDeHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeHabitacion tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public EstadoHabitacion getEstado() {
        return Estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        Estado = estado;
    }


    @Override
    public String toString() {
        return "Habitacion:\n\n" +
                "Piso.........." + piso + "\n" +
                "Numero........" + numero + "\n" +
                "Tipo.........." + tipo + "\n" +
                "Precio........" + precio +"\n"+
                "Pasajero DNI......" + dniPasajero +"\n"+
                "CheckIn......." + checkIn+"\n" +
                "CheckOut......" + checkOut+"\n" +
                "Estado........" + Estado +"\n" +
                "Regimen......" + regimenComida ;
    }
}
