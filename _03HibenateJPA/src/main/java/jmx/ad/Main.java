package jmx.ad;

import jmx.ad.modelo.Empleado;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creamos las EntityManagerFactory para manejar las entidades y transacciones

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            System.out.println("Select al vuelo");
            Query queryTodosEmpleados = entityManager.createQuery("select e from Empleado e");
            List<Empleado> listaEmpleados = queryTodosEmpleados.getResultList();
            listaEmpleados.forEach(System.out::println);

            System.out.println("inserciones de un objeto en BBDD");

            Empleado empleadotmp = Empleado.builder().dni("18445968J").nombre("Victor").apellidos("Fuertes").build();
        /*transaction.begin();
        entityManager.persist(empleadotmp);
        transaction.commit();*/

            //Update
            System.out.println("actualizando el usuario id=2");
            Empleado update = entityManager.find(Empleado.class, 2);
            update.setNombre("Donald");
            update.setApellidos("Pato");
            update.setDni("18445999J");
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
            System.out.println("Hemos realizado un update");
            //Delete
            System.out.println("Eliminamos el Empleado 2");
            transaction.begin();
            entityManager.remove(update);
            transaction.commit();
            System.out.println("Hemos borrado " + update);


        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }






    }
}