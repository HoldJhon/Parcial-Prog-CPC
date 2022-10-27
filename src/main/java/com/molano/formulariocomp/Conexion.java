package com.molano.formulariocomp;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jhonm
 */
public class Conexion {

    private static Conexion con;
    private Connection conectar;
    private String BD;
    private String usuario;
    private String contra;

    public Conexion(Connection conectar, String BD, String usuario, String contra) {
        this.conectar = conectar;
        this.BD = BD;
        this.usuario = usuario;
        this.contra = contra;
    }

    public Conexion() {
        this.conectar = null;
        this.BD = "bd_molano";
        this.usuario = "postgres";
        this.contra = "117";
    }

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            this.BD = "jdbc:postgresql://ec2-44-195-132-31.compute-1.amazonaws.com:5432/df9fe5lfros5mi";
            this.usuario = "hycbiggayrodtn";
            this.contra = "579f77334c029327c34b51ca5b23e745937ca1efd8f6c62c64349a4492fa35b3";
            this.conectar = (Connection) DriverManager.getConnection(BD, usuario, contra);
        } catch (ClassNotFoundException | HeadlessException | SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
    }

    public Connection getConexion() {
        return conectar;
    }

    public static Conexion getIntance() {
        if (con == null) {
            con = new Conexion();
        }
        return con;
    }
}
