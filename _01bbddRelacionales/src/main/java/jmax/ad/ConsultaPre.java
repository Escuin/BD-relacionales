package jmax.ad;

import java.sql.*;



public class ConsultaPre {


    static final String IP = "";
    static final String PUERTO = "3306";
    static final String BBDD = "persona";
    static final String CADENA_CONEXION = "jdbc:mysql://"+IP+":"+PUERTO+"/" + BBDD;
    static final String USUARIO = "";
    static final String PASS = "";

    public static void main(String[] args) {



        try {
            Connection miConexion = DriverManager.getConnection(CADENA_CONEXION,USUARIO,PASS);



            PreparedStatement sentencia = miConexion.prepareStatement("Select * from person where money > ?");
            sentencia.setString(1,"800");
            ResultSet miResultSet = sentencia.executeQuery();

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