package tarea05.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David
 */
public class Alquiler {
    private Cliente cliente;
    private Turismo turismo;
    private Date fecha;
    private int dias;
    
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat ("dd/mm/yyyy HH:mm");
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    private final double PRECIO_DIA = 30;
    
    public Alquiler (Cliente cliente, Turismo turismo){
        this.cliente=cliente;
        this.turismo=turismo;
        fecha=new Date();
        dias=0;
        turismo.setDisponible(false);
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public Turismo getTurismo(){
        return turismo;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public int getDias(){
        return dias;
    }
    
    public void close(){
        Date ahora = new Date();
	dias = difDias(fecha, ahora);
	turismo.setDisponible(true);
    }
    
    private int difDias(Date fechaInicio, Date fechaFin){
        long milisegundos = fechaFin.getTime() - fechaInicio.getTime();
	long diasAlquilado = milisegundos / MS_DIA;
	return (int) diasAlquilado + 1;
    }
    
    public double getPrecio(){
        return dias*PRECIO_DIA+turismo.getCilindrada()/100;
    }
    
    public String toString(){
        return "DNI cliente: "+cliente.getDni()+"\nMatricula vehiculo: "+turismo.getMatricula()+"\nFecha de alquier: "+FORMATO_FECHA.format(fecha)+"\nDías: "+dias+"\nPrecio"+getPrecio()+"\n--------------------";
    }
    
}
