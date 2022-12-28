/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class TipoDeDato {
    private String TipoDato;
    private int Cantidad;
    private String OrdenAcsendnete;
    private String OrdenDesendente;

    public String getOrdenAcsendnete() {
        return OrdenAcsendnete;
    }

    public void setOrdenAcsendnete(String OrdenAcsendnete) {
        this.OrdenAcsendnete = OrdenAcsendnete;
    }

    public String getOrdenDesendente() {
        return OrdenDesendente;
    }

    public void setOrdenDesendente(String OrdenDesendente) {
        this.OrdenDesendente = OrdenDesendente;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getTipoDato() {
        return TipoDato;
    }

    public void setTipoDato(String TipoDato) {
        this.TipoDato = TipoDato;
    }

}
