package jmx.ad;

import jmx.ad.Controlador.MiControlador;
import jmx.ad.dao.ContactDao;
import jmx.ad.dao.PersonaDao;
import jmx.ad.dao.TrabajoDao;
import jmx.ad.modelo.*;


import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //MiControlador miControlador = new MiControlador();
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


        //Trabajamos con los bancos:
        /*miControlador.saveBank(Bank.builder().nombre("BBVA").build());
        miControlador.saveBank(Bank.builder().nombre("Santander").build());
        miControlador.saveBank(Bank.builder().nombre("Sabadell").build());
        miControlador.saveBank(Bank.builder().nombre("La Caixa").build());
*/
       // Bank bbva = miControlador.buscaBanco(1L);
       // Bank banco2 = miControlador.buscaBanco(2L);

        /*System.out.println(bbva.getNombre());
        Account cuenta1 = Account.builder().date(LocalDate.now()).amount(new BigDecimal("3000")).build();
        Account cuenta2 = Account.builder().date(LocalDate.now()).amount(new BigDecimal("4000")).build();
        Account cuenta3 = Account.builder().date(LocalDate.now()).amount(new BigDecimal("3500")).build();
        Account cuenta4 = Account.builder().date(LocalDate.now()).amount(new BigDecimal("3125")).build();
        Account cuenta5 = Account.builder().date(LocalDate.now()).amount(new BigDecimal("300")).build();
        Account cuenta6 = Account.builder().date(LocalDate.now()).amount(new BigDecimal("33000")).build();
        Account cuenta7 = Account.builder().date(LocalDate.now()).amount(new BigDecimal("32500")).build();
        Account cuenta8 = Account.builder().date(LocalDate.now()).amount(new BigDecimal("30")).build();
        bbva.addBankAccount(cuenta1);
        bbva.addBankAccount(cuenta2);
        bbva.addBankAccount(cuenta3);
        banco2.addBankAccount(cuenta4);
        banco2.addBankAccount(cuenta5);
        banco2.addBankAccount(cuenta6);
        banco2.addBankAccount(cuenta7);
        bbva.addBankAccount(cuenta8);

        miControlador.saveBank(bbva);
        miControlador.saveBank(banco2);
*/

        //System.out.println(bbva);

        //Ejemplo con ManytoOne EAGER
       // Empleado empleado = miControlador.busca(7);
        //System.out.println(empleado.getNombre());
        //System.out.println(empleado);

        //Muestra solo el nombre del banco
        //@OneToMany Lazy
        //Bank banco = miControlador.buscaBanco(1L);
        //System.out.println(banco.getNombre());
        //Accedo a algo q no tiene cargado
        //System.out.println(banco);


        //Busco una cuenta y devuelve el banco al que pertenece!

       // Account cuenta = miControlador.buscaCuenta(1L);
        //System.out.println(cuenta);





       // miControlador.cierra();

        //Trabajando con DAO
/*

        ContactDao contactDao = new ContactDao();
        URL url = null;
        try {
            url = new URL("http://www.as.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Name nombre = Name.builder().firstName("Juan").lastName("Moreno").middleName("Manuel").build();
        contactDao.insert(Contact.builder().website(url).id(1).name(nombre).build());


        contactDao.cierra();
*/

        //Ejemplo OneToOne Persona trabajo con DAO

        PersonaDao personaDao = new PersonaDao();
        TrabajoDao trabajoDao = new TrabajoDao();

        /*Persona p1 = Persona.builder().dni("18444555A").nombre("Pepito").apellido("Lopez").build();
        Trabajo t1 = Trabajo.builder().nombre("Soldador").turno("Noches").fin(LocalTime.of(6,00)).inicio(LocalTime.of(22,0)).build();
        personaDao.insert(p1);
        trabajoDao.insert(t1);

        p1.setTrabajo(t1);
        t1.setPersona(p1);
        personaDao.insert(p1);
        trabajoDao.insert(t1);*/


        Persona persona = personaDao.busca("18444555A");
        System.out.println(persona);




    }
}