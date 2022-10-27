package com.molano.formulariocomp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jhonm
 */
public class Conexion {

    Connection con;
    private static Conexion intance = null;
    private String url = "jdbc:postgresql://localhost:5432/bd_molano";
    private String user = "postgres";
    private String pss = "117";

    private Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pss);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar la base de datos: " + ex.getMessage());;
        }
    }

    public static Conexion getIntance() {
        if (intance == null) {
            intance = new Conexion();
        }
        return intance;
    }

    public Connection getCnn() {
        return con;
    }

    public void cerrarConexion() {
        intance = null;
    }
}
