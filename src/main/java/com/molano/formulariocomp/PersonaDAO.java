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

    Conexion cn = Conexion.getIntance();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public PersonaDAO() {
    }

    public void nuevouser(PersonaDTO u) {
        con = cn.getCnn();
        String sql = "insert into usuario(nombre, apellido, correo, clave) values (?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getClave());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    public ArrayList<PersonaDTO> traerListaUsers() {
        con = cn.getCnn();
        ArrayList<PersonaDTO> lista = new ArrayList();
        try {
            ps = con.prepareStatement("select * from usuario;");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new PersonaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cn.cerrarConexion();
        }
        return lista;
    }
}
