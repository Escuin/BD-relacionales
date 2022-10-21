package jmax.ad;

import java.sql.*;

/*

JDBC
Java DataBase Connectity
Puente entre la app java y el SGBD
Clases a manejar --> Java.sql	Javax.sql
Lo más importante:
Clase: DriverManager
Interfaces:	Resultset 	Connection 	Statement	Datasource

Proceso a seguir:

1 establecer la conexion
2 crear objeto de tipo Statement
3 Ejecutar sentencia SQL
4 Leer el Resultset
5 Tratar excepciones BIEN
 */

public class Main {

    static final String IP = "";
    static final String PUERTO = "3306";
    static final String BBDD = "persona";
    static final String CADENA_CONEXION = "jdbc:mysql://"+IP+":"+PUERTO+"/" + BBDD;
    static final String USUARIO = "";
    static final String PASS = "";

    public static void main(String[] args) {



        try {
            Connection miConexion = DriverManager.getConnection(CADENA_CONEXION,USUARIO,PASS);

            Statement miStatement = miConexion.createStatement();

            ResultSet miResultSet = miStatement.executeQuery("Select * from person limit 10");

            while (miResultSet.next()){

                //realizable en una misma linea....
                System.out.print (miResultSet.getInt(1) + " ");
                System.out.print (miResultSet.getString(2)+ " ");
                System.out.print (miResultSet.getString(3)+ " ");

                System.out.print(miResultSet.getString("email")+ " ");
                System.out.print (miResultSet.getString(5)+ " ");
                System.out.print (miResultSet.getString(6)+ " ");
                System.out.print (miResultSet.getFloat(7)+ " ");
                System.out.println();

            }
            miConexion.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}