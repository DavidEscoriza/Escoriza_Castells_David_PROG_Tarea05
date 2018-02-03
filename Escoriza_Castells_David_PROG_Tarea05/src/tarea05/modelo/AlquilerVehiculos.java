package tarea05.modelo;

/**
 *
 * @author David
 */
public class AlquilerVehiculos {
    private Cliente[] clientes;
    private Turismo[] turismos;
    private Alquiler[] alquileres;
    
    private final int MAX_CLIENTES=30;
    private final int MAX_TURISMOS=30;
    private final int MAX_ALQUILERES=30;

    public AlquilerVehiculos(){
        clientes = new Cliente[MAX_CLIENTES];
	turismos= new Turismo[MAX_TURISMOS];
	alquileres = new Alquiler[MAX_ALQUILERES];
    }
    
    public Cliente[] getClientes() {
	return clientes;
    }
	
    public Turismo[] getTurismos() {
	return turismos;
    }
	
    public Alquiler[] getAlquileres() {
	return alquileres;
    }

    public Cliente getCliente(String dni){
        int posicion=0;
        boolean encontrado=false;
        while (posicion < clientes.length && !encontrado){
            if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni))
                encontrado=true;
            else
                posicion++;
        }
        if (encontrado)
            return clientes[posicion];
        else 
            return null;
    }
    
    public void addCliente(Cliente cliente){
        int posicion = 0;
	boolean posicionEncontrada = false;
	while (posicion < clientes.length && !posicionEncontrada) {
		if (clientes[posicion] == null)
			posicionEncontrada = true;
		else
			if (clientes[posicion].getDni().equals(cliente.getDni()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI.");
			else
				posicion++;
	}
	if (posicionEncontrada)
		clientes[posicion] = cliente;
	else
		throw new ExcepcionAlquilerVehiculos("No pueden añadirse más clientes.");
	}

    
    
    
    
    
}
