package laboratorio3;

import laboratorio3.Carro;

/**
 * @author Emanuel Martínez Pinzón
 */

public class Puesto {
    private int numero;
    private String estado;
    private Carro carro;
    private Moto moto;
    private Bicicleta bicicleta;
    
    public Puesto(int numero){
        this.numero = numero;
        this.estado = "Libre";
    }
    
    public void asignarPuesto(Carro carro){
        this.carro = carro;
    }
    public void asignarPuesto(Moto moto){
        this.moto = moto;
    }
    public void asignarPuesto(Bicicleta bicicleta){
        this.bicicleta = bicicleta;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Carro getCarro() {
        return carro;
    }
    public Moto getMoto() {
        return moto;
    }
    public Bicicleta getBicicleta() {
        return bicicleta;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    public void setMoto(Moto moto) {
        this.moto = moto;
    }
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }    
    public String libreString(){
        return "Puesto: "+this.getNumero()
            +"\nEstado: "+this.getEstado();
    }
    
    public String toString(){
        return "Puesto: "+this.getNumero()
            +"\nEstado: "+this.getEstado()
            +"\nPlaca del carro: "+this.getCarro().getPlaca()
            +"\nPlaca del carro: "+this.getMoto().getPlaca()
            +"\nHora: "+this.getCarro().getHora()+":"+this.getCarro().getMinuto();
            +"\nHora: "+this.getCarro().getHora()+":"+this.getMoto().getMinuto();
            +"\nHora: "+this.getCarro().getHora()+":"+this.getBicicleta().getMinuto();
    }
}
