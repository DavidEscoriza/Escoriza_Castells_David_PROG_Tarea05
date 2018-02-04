package tarea05.aplicacion;

import tarea05.modelo.Alquiler;
import tarea05.modelo.AlquilerVehiculos;
import tarea05.modelo.Cliente;
import tarea05.modelo.ExcepcionAlquilerVehiculos;
import tarea05.modelo.Turismo;
import utilidades.Entrada;

/**
 *
 * @author David
 */
public class Principal {
    public static void main (String[]args){
        AlquilerVehiculos miAlquiler=new AlquilerVehiculos();
        int opcion;
        
        
        do {
            System.out.println("Alquiler de Vehículos");
            System.out.println("---------------------");
            System.out.println("1. Añadir cliente.");
            System.out.println("2. Borrar cliente.");
            System.out.println("3. Listar clientes.");
            System.out.println("4. Añadir vehiculo.");
            System.out.println("5. Borrar vehiculo.");
            System.out.println("6. Listar vehículos.");
            System.out.println("7. Abrir alquiler.");
            System.out.println("8. Cerrar alquiler.");
            System.out.println("9. Listar alquileres.");
            System.out.println("0. Salir.");
            
            System.out.println("\nSelecciona una opción (0-9)");
            opcion = Entrada.entero();
            
            while (opcion<0 || opcion >9) {
                System.out.println("Opción inválida. ");
                System.out.print("Selecciona una opción (0-9)");
                opcion = Entrada.entero();
            }
            
            switch (opcion){
                case 1:
                    Cliente nuevoCliente=null;
                    do {
			System.out.println("\nAñadir cliente");
			System.out.println("--------------");
			System.out.print("Nombre: ");
			String nombre = Entrada.cadena();
			System.out.print("DNI: ");
			String dni = Entrada.cadena();
			System.out.print ("Teléfono: ");
			String telefono = Entrada.cadena();
			System.out.print("Dirección: ");
			String direccion = Entrada.cadena();
			System.out.print("Localidad: ");
			String localidad = Entrada.cadena();
			System.out.print("Código postal: ");
			String codigoPostal = Entrada.cadena();
			try {
				nuevoCliente = new Cliente(nombre, dni, telefono, direccion, localidad, codigoPostal);
			} catch (ExcepcionAlquilerVehiculos eav) {
				System.out.println("ERROR: "+eav.getMessage());
				System.out.println("Vuelve a introducir los datos de forma correcta");
			}
                    } while (nuevoCliente == null);
                    try {
                        miAlquiler.addCliente(nuevoCliente);
                    } catch (ExcepcionAlquilerVehiculos eav) {
			System.out.println("ERROR: "+eav.getMessage());
			System.out.println("Vuelve a introducir los datos de forma correcta");
                    }
                    break;
                
                case 2:
                    System.out.println("\nBorrar cliente");
                    System.out.println("--------------");
                    System.out.print("Introduce DNI: ");
                    String dniBorrar=Entrada.cadena();
                    try {
			miAlquiler.delCliente(dniBorrar);
			System.out.println("Cliente borrado.\n");
                    } catch (Exception e) {
			System.out.println("ERROR: "+ e.getMessage());
                    }
                    break;
                
                case 3:
                    System.out.println("\nListado de clientes");
                    System.out.println("-------------------");
                    for (Cliente cliente: miAlquiler.getClientes()) {
			if (cliente != null)
				System.out.println(cliente);
                    }
                    System.out.println("");
                    break;
                
                case 4:
                    Turismo nuevoTurismo=null;
                    System.out.println("\nAñadir vehículo");
                    System.out.println("---------------");
                    System.out.print("Matrícula: ");
                    String matricula = Entrada.cadena();
                    System.out.print("Marca: ");
                    String marca = Entrada.cadena();
                    System.out.print("Modelo: ");
                    String modelo = Entrada.cadena();
                    System.out.print("Cilindrada: ");
                    int cilindrada = Entrada.entero();
                    try {
			nuevoTurismo = new Turismo(matricula, marca, modelo, cilindrada);
			miAlquiler.addTurismo(nuevoTurismo);
                    } catch (ExcepcionAlquilerVehiculos eav) {
                        System.out.println("ERROR: "+ eav.getMessage());
                    }
                    break;
                
                case 5: 
                    System.out.println("\nBorrar vehículo");
                    System.out.println("---------------");
                    System.out.print("\nIntroduce la matrícula del vehículo a borrar: ");
                    String matriculaBorrar = Entrada.cadena();
                    try {
			miAlquiler.delTurismo(matriculaBorrar);
			System.out.println("Turismo borrado.");
                    } catch (ExcepcionAlquilerVehiculos eav) {
			System.out.printf("ERROR: "+eav.getMessage());
                    }
                    break;  
                
                case 6:
                    System.out.println("\nListado de turismos");
                    System.out.println("--------------------");
                    for (Turismo turismo: miAlquiler.getTurismos()) {
                        if (turismo != null)
                            System.out.println(turismo);
			}
                    System.out.println("");
                    break;
                    
                case 7:
                    Alquiler nuevoAlquiler = null;
                    System.out.println("\nAbrir alquiler");
                    System.out.println("---------------");
                    System.out.print("\nIntroduce el DNI del cliente: ");
                    String dniAlquiler = Entrada.cadena();
                    Cliente clienteAlquiler = miAlquiler.getCliente(dniAlquiler);
                    if (clienteAlquiler == null){
                        System.out.println("ERROR: No existe un cliente con ese DNI.");
                        break;
                    }
                    System.out.print("\nIntroduce la matrícula del turismo: ");
                    String matriculaAlquiler = Entrada.cadena();
                    Turismo turismoAlquiler = miAlquiler.getTurismo(matriculaAlquiler);
                    if (turismoAlquiler == null){
                        System.out.println("ERROR: No existe un vehículo con dicha matrícula.");
                        break;
                    }
                    try {
                        miAlquiler.openAlquiler(clienteAlquiler, turismoAlquiler);
                    } catch (ExcepcionAlquilerVehiculos eav){
                        System.out.println("ERROR: "+eav.getMessage());
                    }
                    break;
                
                case 8:
                    System.out.println("\nCerrar alquiler");
                    System.out.println("--------------");
                    System.out.print("\nIntroduce el DNI del cliente: ");
                    String dniCloseAlquiler = Entrada.cadena();
                    Cliente clienteCloseAlquiler = miAlquiler.getCliente(dniCloseAlquiler);
                    if (clienteCloseAlquiler == null){
			System.out.println("ERROR: No existe un cliente con ese DNI");
                        break;
                    }
                    System.out.print("\nIntroduce la matrícula del turismo: ");
                    String matriculaCloseAlquiler = Entrada.cadena();
                    Turismo turismoCloseAlquiler = miAlquiler.getTurismo(matriculaCloseAlquiler);
                    if (turismoCloseAlquiler == null){
                        System.out.println("ERROR: No existe un vehículo con dicha matrícula.");
                        break;
                    }
                    try{
                        miAlquiler.closeAlquiler(clienteCloseAlquiler, turismoCloseAlquiler);
                    } catch (ExcepcionAlquilerVehiculos eav){
                        System.out.println("ERROR: "+eav.getMessage());                        
                    }
                    break;
                    
                case 9:
                    System.out.println("\nListado de alquileres");
                    System.out.println("---------------------");
                    for (Alquiler alquiler: miAlquiler.getAlquileres()) {
			if (alquiler != null)
                            System.out.println(alquiler);
                    }
                    System.out.println("");
                    break;
            }
        } while (opcion!=0);        
    }
}
