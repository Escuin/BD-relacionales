package jmax.ad;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    //https://logging.apache.org/log4j/2.x/manual/configuration.html
//https://howtodoinjava.com/log4j2/log4j2-properties-example/

    /*
pudiendo adoptar el "nivel" los siguientes valores:
        trace
        debug
        info
        warn
        error
        fatal*/


    public static void main(String[] args) {

        log.trace("Comienza el programa");
        int resultado = suma (-3,80);
        log.debug("resultado = " + resultado);
        System.out.println(resultado);

    }

    private static int suma(int i, int i1) {
        log.trace("Entramos a suma-...............................");
        log.debug(i + " " + i1);

        if (i<0 || i1<0){

            log.error("paso numeros negativos ");
            throw new RuntimeException("Error numeros negativos");
        }

        log.trace("Salimos de suma ................");
        return i + i1;
    }
}