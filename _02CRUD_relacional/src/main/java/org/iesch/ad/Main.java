package org.iesch.ad;

import org.iesch.ad.controlador.MiControlador;
import org.iesch.ad.modelo.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Realizamos nuestro primer CRUD");

        MiControlador miControlador = new MiControlador();


        Person p = new Person(1100, "Chanchito", "Cagon", "chanchi@aa.es", "Trans", "192.168.1.2", 8000F);
        miControlador.inserta(p);

        //dame todas las personas.
        List lista = miControlador.dameTodasLasPersonas();
        lista.forEach(System.out::println);


    }
}