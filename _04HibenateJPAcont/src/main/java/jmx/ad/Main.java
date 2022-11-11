package jmx.ad;

import jmx.ad.Controlador.MiControlador;
import jmx.ad.modelo.Empleado;


import java.util.List;

public class Main {
    public static void main(String[] args) {

        MiControlador miControlador = new MiControlador();
        //insert
        //Empleado e1 = Empleado.builder().nombre("Pedro").apellidos("Perez").dni("00000000S").build();
        //miControlador.insert(e1);

        //update 3 | José      | Chapi   | 18000002J
//        Empleado empleadoEnBBDD = Empleado.builder().nombre("José").apellidos("Chapi").dni("18000002J").id(3).build();
//        Empleado empleadoNew = Empleado.builder().nombre("José").apellidos("Fuertes NO").dni("18000002J").id(3).build();
//        miControlador.update(empleadoEnBBDD,empleadoNew);

        //delete
      //  Empleado empleadoBorrar = Empleado.builder().id(3).build();
        //miControlador.borra(empleadoBorrar);

        //select
       // Empleado empleado = miControlador.busca(7);
       // System.out.println(empleado);

        //Select All
        // miControlador.buscaTodos().forEach(System.out::println);
        //System.out.println(miControlador.buscaTodos());
        //miControlador.buscaTodos().forEach(empleado -> System.out.println(empleado));




        miControlador.cierra();




    }
}