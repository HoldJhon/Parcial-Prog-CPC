package com.molano.formulariocomp;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jhonm
 */
public class Conexion {

    private static Conexion intance = null;
    private Connection conectar;
    private String BD = "jdbc:postgresql://ec2-44-195-132-31.compute-1.amazonaws.com:5432/df9fe5lfros5mi";
    private String usuario = "hycbiggayrodtn";
    private String contra = "579f77334c029327c34b51ca5b23e745937ca1efd8f6c62c64349a4492fa35b3";

    public Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            conectar = (Connection) DriverManager.getConnection(BD, usuario, contra);
        } catch (Exception e) {
        }
    }

    public static Conexion getIntance() {
        if (intance == null) {
            intance = new Conexion();
        }
        return intance;
    }

    public Connection getConexion() {
        return conectar;
    }

    public void cerrarConexion() {
        intance = null;
    }
}
