package tarea05.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author David
 */
public class Turismo {
    private String matricula, marca, modelo;
    private int cilindrada;
    private boolean disponible;
    
    public Turismo (String matricula, String marca, String modelo, int cilindrada){
        if (!compruebaMatricula (matricula))
            throw new ExcepcionAlquilerVehiculos ("La matrícula es inválida.");
        this.matricula=matricula;
        this.marca=marca;
        this.modelo=modelo;
        if (cilindrada<=0)
            throw new ExcepcionAlquilerVehiculos ("La cilindrada debe ser mayor que 0.");
        this.cilindrada=cilindrada;
    }
    
    public Turismo(Turismo otroTurismo){
        matricula=otroTurismo.matricula;
        marca=otroTurismo.marca;
        modelo=otroTurismo.modelo;
        cilindrada=otroTurismo.cilindrada;
        disponible=otroTurismo.disponible;
    }
    
    private boolean compruebaMatricula(String matricula){
        Pattern p = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
        Matcher m=p.matcher(matricula);
        return m.matches();
    }
    
}
