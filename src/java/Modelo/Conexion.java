/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Esteban
 */
public class Conexion {

    private String username = "root";
    private String password = "";
    private String hostName = "localhost";
    private String pot = "3306";
    private String database = "databaseproducts";
    private String className = "com.mysql.cj.jdbc.Driver";
//    private String url = "jdbc:mysql://" + hostName + ":" + port + "/" + database;
    private String url = "jdbc:mysql://localhost/databaseproducts?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    jdbc:mysql://localhost/db?
    private Connection cnx;

    public Conexion() {
        try {
            Class.forName(className);
            cnx = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {

            System.err.println(e.getMessage());
        } catch (SQLException esql) {
            System.err.println(esql.getMessage());
        }

    }

    public Connection getConnection() {
        return cnx;
    }

}
