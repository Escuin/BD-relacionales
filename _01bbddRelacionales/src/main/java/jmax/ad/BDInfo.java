package jmax.ad;

//conection.getMetadata

import java.net.SocketTimeoutException;
import java.sql.*;

public class BDInfo {
    static final String IP = "";
    static final String PUERTO = "3306";
    static final String BBDD = "persona";
    static final String CADENA_CONEXION = "jdbc:mysql://"+IP+":"+PUERTO+"/" + BBDD;
    static final String USUARIO = "";
    static final String PASS = "";

    public static void main(String[] args) {



        try {
            Connection miConexion = DriverManager.getConnection(CADENA_CONEXION,USUARIO,PASS);

            DatabaseMetaData bbddinfo = miConexion.getMetaData();

            System.out.println(bbddinfo.getDatabaseProductName());
            System.out.println(bbddinfo.getDatabaseProductVersion());
            ResultSet result = bbddinfo.getCatalogs();
            while (result.next()) {
                System.out.println(result.getString(1));
            }



            miConexion.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
