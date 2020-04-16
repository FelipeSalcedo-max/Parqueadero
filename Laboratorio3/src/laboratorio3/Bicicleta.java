/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3;

/**
 *
 * @author RetailAdmin
 */
public class Bicicleta {
    private int NUMERO;
    private String hora;
    private String minuto;

    public Bicicleta(int NUMERO, String hora, String minuto){
        this.NUMERO = NUMERO;
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public int getnumero() {
        return NUMERO;
    }

    public void setnumero(int NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }
    
}
