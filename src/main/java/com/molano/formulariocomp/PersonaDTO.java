import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jhon
 */
public class PersonaDTO implements Serializable{
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;

    public PersonaDTO(String nombre, String apellido, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }

    public PersonaDTO() {
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.clave = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" + "nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", clave=" + clave + '}';
    }
}
