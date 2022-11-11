package com.molano.formulariocomp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonm
 */
public class PersonaDAO {

    Conexion conex = Conexion.getIntance();
    Connection conec;
    PreparedStatement ps;
    ResultSet rs;

    public PersonaDAO() {
    }

    public void nuevoUsuario(PersonaDTO usuario) {
        conec = conex.getConexion();
        String sql = "INSERT INTO USUARIO(nombre, telefono, correo, contrasena) values (?,?,?,?);";
        try {
            ps = conec.prepareStatement(sql);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getTelefono());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getClave());
            ps.execute();
        } catch (SQLException ex) {
        } finally {
            conex.cerrarConexion();
        }
    }

    public ArrayList<PersonaDTO> traerListaUsuarios() {
        conec = conex.getConexion();
        ArrayList<PersonaDTO> lista = new ArrayList<>();
        try {
            ps = conec.prepareStatement("SELECT * FROM usuario;");
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new PersonaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }
}
