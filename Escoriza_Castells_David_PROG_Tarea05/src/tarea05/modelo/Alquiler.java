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
    
    
    
    
}
