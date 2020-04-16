package laboratorio3;

/**
 * @author Emanuel Martínez Pinzón
 */
import laboratorio3.Carro;
import java.util.ArrayList;
import laboratorio3.Puesto;
import presentacion.Ventana;

public class Parqueadero {
    ArrayList<Puesto> Puesto;
    ArrayList<Carro> Carro;
    ArrayList<Moto> Moto;
    ArrayList<Bicicleta> Bicicleta;
    
    private int tarifaHora;
    private int tarifaFraccion;
    private int totalRecaudado;
    
    int CantidadCarros;
    int CantidadMotos;
    int CantidadBicicletas;
    
    public Parqueadero(){
        this.Puesto = new ArrayList<Puesto>();
        this.Carro = new ArrayList<Carro>();
        this.Moto = new ArrayList<Moto>();
        this.Bicicleta = new ArrayList<Bicicleta>();
        this.crearPuestos();
        
        CantidadCarros = this.Carro.size();
        CantidadMotos = this.Moto.size();
        CantidadBicicletas = this.Bicicleta.size();
    }
    
    private void crearPuestos(){
        for(int i=0; i<25; i++){
            if(CantidadCarros < 12 ){
                this.Puesto.add(new Puesto(i+1));
            } else {
                Ventana.imp("No hay puestos para parquear más carros");
                return;
            }
            if(CantidadMotos < 8 ){
                this.Puesto.add(new Puesto(i+1));
            } else {
                Ventana.imp("No hay puestos para parquear más motos");
                return;
            }
            if(CantidadBicicletas < 6 ){
                this.Puesto.add(new Puesto(i+1));
            } else {
                Ventana.imp("No hay puestos para parquear más bicicletas");
                return;
            }
            
            }
            
    }
    
    //-----------------------REQUERIMIENTOS FUNCIONALES-----------------------//
    public String parquearCarro(String placa, String hora, String minuto){
        
        if(this.buscarCarro(placa) != null)
            return "El carro ya esta parqueado en un puesto";
        
        if(this.puestoVacioc()!=-1){
            Carro carro = new Carro(placa, hora, minuto);
            this.Puesto.get(this.puestoVacioc()).asignarPuestoc(carro);
            this.Puesto.get(this.puestoVacioc()).setEstado("Ocupado");
            return "Carro parqueado con exito";
        }         
        return null;
        
   }
    public String retirarCarro(String placa, String hora, String minutos){
        String mensaje = "No se ha podido retirar el carro";
        
        int precioc = this.calcularPrecio(hora, minutos, this.buscarCarro(placa));
        
        for(int i=0; i<=this.Puesto.size(); i++)
            if(this.Puesto.get(i).getCarro()!= null && 
                    this.Puesto.get(i).getCarro().getPlaca().equalsIgnoreCase(placa)){
                this.Puesto.get(i).setCarro(null);
                this.Puesto.get(i).setEstado("Libre");
                return "Se ha retirado correctamente, debe pagar "+precioc;
            }
                
        return mensaje;
    }
    
    public String parquearMoto(String Placam, String horam, String minutom){
        
        if(this.buscarMoto(Placam) != null)
            return "La moto ya esta parqueada en un puesto";
        
        if(this.puestoVaciom()!=-1){
            Moto moto = new Moto(Placam, horam, minutom);
            this.Puesto.get(this.puestoVaciom()).asignarPuestom(moto);
            this.Puesto.get(this.puestoVaciom()).setEstado("Ocupado");
            return "Moto parqueada con exito";
        }
        return null;
            
        
    }
    
    public String retirarMoto(String Placam, String horam, String minutosm){
        String mensaje = "No se ha podido retirar la moto";
        
        int preciom = this.calcularPrecio(horam, minutosm, this.buscarMoto(Placam));
        
        for(int i=0; i<=this.Puesto.size(); i++)
            if(this.Puesto.get(i).getMoto()!= null && 
                    this.Puesto.get(i).getMoto().getPlacam().equalsIgnoreCase(Placam)){
                this.Puesto.get(i).setMoto(null);
                this.Puesto.get(i).setEstado("Libre");
                return "Se ha retirado correctamente, debe pagar "+preciom;
            }
                
        return mensaje;
    }
    
    public String parquearBicicleta( String NUMERO, String horab, String minutob){
        
        if(this.buscarBicicleta(NUMERO) != null)
            return "La bicicleta ya esta parqueada en un puesto";
        
        if(this.puestoVaciob()!=-1){
            Bicicleta bicicleta = new Bicicleta(NUMERO, horab, minutob);
            this.Puesto.get(this.puestoVaciob()).asignarPuestob(bicicleta);
            this.Puesto.get(this.puestoVaciob()).setEstado("Ocupado");
            return "Moto parqueada con exito";
        }
        return null;
            
        
    }
    
    public String retirarBicicleta(String NUMERO, String horab, String minutosb){
        String mensaje = "No se ha podido retirar la bicicleta";
        
        int preciob = this.calcularPrecio(horab, minutosb, this.buscarBicicleta(NUMERO));
        
        for(int i=0; i<=this.Puesto.size(); i++)
            if(this.Puesto.get(i).getMoto()!= null && 
                    this.Puesto.get(i).getBicicleta().getNUMERO().equalsIgnoreCase(NUMERO)){
                this.Puesto.get(i).setBicicleta(null);
                this.Puesto.get(i).setEstado("Libre");
                return "Se ha retirado correctamente, debe pagar "+preciob;
            }
                
        return mensaje;
    }
    
    public String InfoPuestosLibres(){
        String libres = "";
        
        for(Puesto p: Puesto)
            if(p!=null && p.getEstado().equalsIgnoreCase("Libre"))
                libres += p.libreString()+"\n\n";
                
        return libres;
    }
    
    //----------------------REQUERIMIENTOS OPERACIONALES----------------------//
    public Carro buscarCarro(String placa){
        Carro carro = null;
        
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Ocupado") && 
                    p.getCarro().getPlaca().equalsIgnoreCase(placa))
                carro = p.getCarro();
        
        return carro;
    }
    
    public int puestoVacioc(){
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Libre"))
                return (p.getNumero()-1);
        
        return -1;
    }
    
        public Moto buscarMoto(String Placam){
        Moto moto = null;
        
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Ocupado") && 
                    p.getMoto().getPlacam().equalsIgnoreCase(Placam))
                moto = p.getMoto();
        
        return moto;
    }
        public int puestoVaciom(){
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Libre"))
                return (p.getNumero()-1);
        
        return -1;
    }
    
        public Bicicleta buscarBicicleta(String NUMERO){
        Bicicleta bicicleta = null;
        
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Ocupado") && 
                    p.getBicicleta().getNUMERO().equalsIgnoreCase(NUMERO))
                bicicleta = p.getBicicleta();
        
        return bicicleta;
    }
    
    public int puestoVaciob(){
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Libre"))
                return (p.getNumero()-1);
        
        return -1;
    }
    
    public int calcularPrecio(String horaSalida, String minutoSalida, Carro carro){
        int costo = 0;
        
        int cantHoras = Integer.parseInt(horaSalida)-Integer.parseInt(Carro.getHora());
        int cantMinutos = Integer.parseInt(minutoSalida)-Integer.parseInt(Carro.getMinuto());
        
        int costoHora = cantHoras*this.getTarifaHora();
        int costoFraccion = 0;
        
        if(cantMinutos>0)
            costoFraccion = this.getTarifaFraccion();
        
        costo = costoHora+costoFraccion;
        
        this.setTotalRecaudado(this.getTotalRecaudado()+costoHora+costoFraccion);
        
        return costo;
    }
    
    public int calcularPrecio(String horaSalida, String minutoSalida, Moto moto){
        int costo = 0;
        
        int cantHoras = Integer.parseInt(horaSalida)-Integer.parseInt(moto.getHora());
        int cantMinutos = Integer.parseInt(minutoSalida)-Integer.parseInt(moto.getMinuto());
        
        int costoHora = cantHoras*this.getTarifaHora();
        int costoFraccion = 0;
        
        if(cantMinutos>0)
            costoFraccion = this.getTarifaFraccion();
        
        costo = costoHora+costoFraccion;
        
        this.setTotalRecaudado(this.getTotalRecaudado()+costoHora+costoFraccion);
        
        return costo;
    }
    
    public int calcularPrecio(String horaSalida, String minutoSalida, Bicicleta bicicleta){
        int costo = 0;
        
        int cantHoras = Integer.parseInt(horaSalida)-Integer.parseInt(moto.getHora());
        int cantMinutos = Integer.parseInt(minutoSalida)-Integer.parseInt(moto.getMinuto());
        
        int costoHora = cantHoras*this.getTarifaHora();
        int costoFraccion = 0;
        
        if(cantMinutos>0)
            costoFraccion = this.getTarifaFraccion();
        
        costo = costoHora+costoFraccion;
        
        this.setTotalRecaudado(this.getTotalRecaudado()+costoHora+costoFraccion);
        
        return costo;
    }

    public String concatenarPlacasCarros(){
        String carros = "";
        
        for(int i=0; i<this.Puesto.size();i++)
            if(this.Puesto.get(i).getEstado().equalsIgnoreCase("Ocupado"))
                carros += this.Puesto.get(i).getCarro().getPlaca()+"~";
        
        return carros;
    }
    
    public String concatenarInfoCarros(){
        String info = "";
        
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Ocupado"))
                info += p.toString()+"\n\n";
        
        return info;
    }
    
    //------------------------Getter's y Setter's-----------------------------//
    public int getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(int tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public int getTarifaFraccion() {
        return tarifaFraccion;
    }

    public void setTarifaFraccion(int tarifaFraccion) {
        this.tarifaFraccion = tarifaFraccion;
    }

    public int getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(int totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }
}
