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
    
    public void delCliente(String dni){
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < clientes.length && !encontrado){
            if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni))
                encontrado=true;
            else
                posicion++;
        }
        if (encontrado){
            for (int i=posicion; i < clientes.length - 1; i++){
                clientes[i]=clientes[i+1];
            }
            clientes [clientes.length - 1] = null;
        }
        else
            throw new ExcepcionAlquilerVehiculos ("No existe el cliente.");
        
    }
    
    public Turismo getTurismo(String matricula){
        int posicion=0;
        boolean encontrado=false;
        while (posicion < turismos.length && !encontrado){
            if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula))
                encontrado=true;
            else
                posicion++;
        }
        if (encontrado)
            return turismos[posicion];
        else 
            return null;
    }
    
    public void addTurismo(Turismo turismo){
        int posicion = 0;
	boolean posicionEncontrada = false;
	while (posicion < turismos.length && !posicionEncontrada) {
		if (turismos[posicion] == null)
			posicionEncontrada = true;
		else
			if (turismos[posicion].getMatricula().equals(turismo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un turismo con esa matricula.");
			else
				posicion++;
	}
	if (posicionEncontrada)
		turismos[posicion] = turismo;
	else
		throw new ExcepcionAlquilerVehiculos("No pueden añadirse más turismos.");
	}
    
    public void delTurismo(String matricula){
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < turismos.length && !encontrado){
            if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula))
                encontrado=true;
            else
                posicion++;
        }
        if (encontrado){
            for (int i=posicion; i < turismos.length - 1; i++){
                turismos[i]=turismos[i+1];
            }
            turismos [turismos.length - 1] = null;
        }
        else
            throw new ExcepcionAlquilerVehiculos ("No existe el turismo.");
    }
    
    public void openAlquiler(Cliente cliente, Turismo turismo){
        int posicionAlquiler = 0;
        boolean alquilerEncontrado = false;
        while (posicionAlquiler < alquileres.length && !alquilerEncontrado){
            if (alquileres[posicionAlquiler]==null)
                alquilerEncontrado=true;
            else
                posicionAlquiler++;
        }
        if (alquilerEncontrado)
            if (turismo.getDisponible())
                alquileres[posicionAlquiler]=new Alquiler(cliente, turismo);
            else
                throw new ExcepcionAlquilerVehiculos("El turismo no está disponible.");
        else
            throw new ExcepcionAlquilerVehiculos("No pueden abrirse más alquileres.");
    }
    
    public void closeAlquiler(Cliente cliente, Turismo turismo){
        int posicionAlquiler = 0;
        boolean alquilerEncontrado = false;
        while (posicionAlquiler < alquileres.length && !alquilerEncontrado){
            if (alquileres[posicionAlquiler].getCliente() == cliente && alquileres[posicionAlquiler].getTurismo()==turismo)
                alquilerEncontrado=true;
            else
                posicionAlquiler++;
        }
        if (alquilerEncontrado) {
            for (int i=posicionAlquiler; i < alquileres.length - 1; i++){
                alquileres[i]=alquileres[i+1];
            }
            alquileres[alquileres.length-1]=null;
        } else
            throw new ExcepcionAlquilerVehiculos("No existe dicho alquiler.");
    }
    
}
