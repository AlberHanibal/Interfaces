package com.example;

public class Comensal {

    private String primerPlato;
    private String bebida;
    private String comentario;
    private boolean descuento;
    private boolean tarjeta;

    public Comensal() {
        primerPlato = "";
        bebida = "";
        comentario = "";
        descuento = false;
        tarjeta = false;
    }

    public Comensal(String primerPlato, String bebida, String comentario, boolean descuento, boolean tarjeta) {
        this.primerPlato = primerPlato;
        this.bebida = bebida;
        this.comentario = comentario;
        this.descuento = descuento;
        this.tarjeta = tarjeta;
    }

    public String getPrimerPlato() {
        return primerPlato;
    }

    public String getBebida() {
        return bebida;
    }

    public String getComentario() {
        return comentario;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public boolean isTarjeta() {
        return tarjeta;
    }

    public void setPrimerPlato(String primerPlato) {
        this.primerPlato = primerPlato;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public void setTarjeta(boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "Comensal [primerPlato=" + primerPlato + ", bebida=" + bebida + ", comentario=" + comentario
                + ", descuento=" + descuento + ", tarjeta=" + tarjeta + "]";
    }

    
}
