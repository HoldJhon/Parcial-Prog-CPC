package com.molano.formulariocomp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhonm
 */
public class PersonaDAO {

    private static final String SQL_READALL = "select * from usuario ";
    private static final Conexion con = Conexion.getIntance();

    public PersonaDAO() {
        con.conectar();
    }

    public List<PersonaDTO> readAll() {
        List<PersonaDTO> lista = null;
        PreparedStatement ps;
        try {
            ps = con.getConexion().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                PersonaDTO obj = new PersonaDTO(rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("clave"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex);
        }
        return lista;
    }
}
