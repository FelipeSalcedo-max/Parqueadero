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
public class Moto {
    private String Placam;
    private String horam;
    private String minutom;

    public Moto(String Placam, String horam, String minutom){
        this.Placam = Placam;
        this.horam = horam;
        this.minutom = minutom;
    }
    
    public String getPlacam() {
        return Placam;
    }

    public void setPlaca(String Placa) {
        this.Placam = Placam;
    }

    public String getHoram() {
        return horam;
    }

    public void setHora(String hora) {
        this.horam = horam;
    }

    public String getMinutom() {
        return minutom;
    }

    public void setMinutom(String minutom) {
        this.minutom = minutom;
    }
}
