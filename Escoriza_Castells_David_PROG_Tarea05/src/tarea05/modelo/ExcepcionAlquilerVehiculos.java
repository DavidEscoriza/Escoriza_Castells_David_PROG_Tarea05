package tarea05.modelo;

/**
 *
 * @author David
 */
public class ExcepcionAlquilerVehiculos extends RuntimeException{
    
   private static final long serialVersionUID=1L;
    
   public ExcepcionAlquilerVehiculos (String mensaje){
	super(mensaje);
   }
}
