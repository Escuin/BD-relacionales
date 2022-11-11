package jmx.ad.Controlador;

import jmx.ad.modelo.Account;
import jmx.ad.modelo.Bank;
import jmx.ad.modelo.Empleado;
import lombok.NoArgsConstructor;

//import javax.persistence.*;//Al subir a Hibernate 6 PETA
import jakarta.persistence.*;//Trabaja con Hibernate 6
import java.util.List;


public class MiControlador {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public MiControlador() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    //CRUD

    //Create
    public void insert (Empleado empleado){
        try {
            transaction.begin();
            entityManager.persist(empleado);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
           }
        }

    }

    //Update
    public void update (Empleado empleadoOld,Empleado empleadoNew ){
            try{
            Empleado update = entityManager.find(Empleado.class, empleadoOld.getId());
            update.setNombre(empleadoNew.getNombre());
            update.setApellidos(empleadoNew.getApellidos());
            update.setDni(empleadoNew.getDni()); //Se puede simplificar????
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
            }finally {
                if (transaction.isActive()){
                    transaction.rollback();
                }
            }


    }

    public void borra (Empleado empleado){

        try{
            transaction.begin();
        Empleado aborrar = entityManager.find(Empleado.class, empleado.getId());
           entityManager.remove(aborrar);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public Empleado busca (int id){

        return entityManager.find(Empleado.class, id);


    }

    public List<Empleado> buscaTodos(){
        Query queryTodosEmpleados = entityManager.createQuery("select e from Empleado e");//Si quereis lo quitais en casa
        return queryTodosEmpleados.getResultList();

    }





    //Close
    public void cierra (){
        entityManager.close();
        entityManagerFactory.close();
    }

    public void saveBank (Bank banco){
        try {
            transaction.begin();
            entityManager.persist(banco);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }

    }

    public Bank buscaBanco(long l) {
        return entityManager.find(Bank.class, l);
    }

    public Account buscaCuenta (Long id){

        return entityManager.find(Account.class, id);

    }

}
