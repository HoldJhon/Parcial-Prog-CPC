package com.molano.formulariocomp;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jhonm
 */
public class PersonaDTO implements Serializable {

    private int id;
    private String nombres;
    private String telefono;
    private String correo;
    private String clave;

    public PersonaDTO() {
    }

    public PersonaDTO(int id, String nombres, String telefono, String correo, String clave) {
        this.id = id;
        this.nombres = nombres;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }

    public PersonaDTO(String nombres, String telefono, String correo, String clave) {
        this.nombres = nombres;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", telefono=" + telefono + ", correo=" + correo + ", clave=" + clave + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nombres);
        hash = 79 * hash + Objects.hashCode(this.telefono);
        hash = 79 * hash + Objects.hashCode(this.correo);
        hash = 79 * hash + Objects.hashCode(this.clave);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonaDTO other = (PersonaDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return Objects.equals(this.clave, other.clave);
    }
}
