package tarea05.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
    private String nombre, dni, telefono, direccion, localidad, codigoPostal;
    private int identificador;
    private static int numClientes=0;
   
    public Cliente(String nombre, String dni, String telefono, String direccion, String localidad, String codigoPostal){
        this.nombre=nombre;
        if (!compruebaDni(dni))
            throw new ExcepcionAlquilerVehiculos("DNI inválido");
        this.dni=dni;
        this.telefono=telefono;
        this.direccion=direccion;
        this.localidad=localidad;
        if (!compruebaCodigoPostal(codigoPostal))
            throw new ExcepcionAlquilerVehiculos("Código postal inválido");
        this.codigoPostal=codigoPostal;
        numClientes++;
        identificador = numClientes;
    }
    
    public Cliente(Cliente otroCliente){
        nombre=otroCliente.nombre;
        dni=otroCliente.dni;
        telefono=otroCliente.telefono;
        direccion=otroCliente.direccion;
        localidad=otroCliente.localidad;
        codigoPostal=otroCliente.codigoPostal;
        identificador=otroCliente.identificador;
    }
    
    private boolean compruebaDni(String dni){
        Pattern p=Pattern.compile("[0-9]{8}[A-Z]");
        Matcher m;
        
        m=p.matcher(dni);
        return m.matches();
    }
    
    private boolean compruebaCodigoPostal(String codigoPostal){
    Pattern p=Pattern.compile("[0-9]{5}");
    Matcher m;
        
    m=p.matcher(codigoPostal);
    return m.matches();
    }
    
        public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public int getIdentificador() {
        return identificador;
    }

    public static int getNumClientes() {
        return numClientes;
    }
    
    public String toString(){
        return "Nombre: "+nombre+"\nDNI: "+dni+"\nTelefono: "+telefono+"\nDirección: "+direccion+"\nLocalidad: "+localidad+"\nCódigo postal: "+codigoPostal+"\nIdentificador: "+identificador+"\n--------------------";
    }
}
