package jmax.ad;

import java.sql.*;

//lanzar dos veces.
// antes de la segunda
// poner ID como PK para q falle.


public class Transac {


    static final String IP = "";
    static final String PUERTO = "3306";
    static final String BBDD = "persona";
    static final String CADENA_CONEXION = "jdbc:mysql://"+IP+":"+PUERTO+"/" + BBDD;
    static final String USUARIO = "";
    static final String PASS = "";

    public static void main(String[] args) {

        Connection miConexion = null;

        try {
             miConexion = DriverManager.getConnection(CADENA_CONEXION,USUARIO,PASS);

            miConexion.setAutoCommit(false);

            Statement miStatement = miConexion.createStatement();

            String sql1 = "update person set money  = " + 1300.5 + "where id = 1000";
            miStatement.executeUpdate(sql1);
            String sql2 = "insert into person (id, name, last_name, email, gender, ip_address, money) values (1005, 'Matias', 'Calvo', 'matias0@cafepress.com', 'Male', '199.47.218.139', 1015.39);";
            miStatement.executeUpdate(sql2);
            miConexion.commit();
            System.out.println("Operacion realizada correctamente");
            miConexion.close();



        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            try {
                System.out.println("Hacemos rollback");
                miConexion.rollback();
                miConexion.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }


    }
}