package jmx.ad.dao;

import jakarta.persistence.*;
import jmx.ad.modelo.Trabajo;

import java.util.List;

public class TrabajoDao {


    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public TrabajoDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void cierra (){
        entityManager.close();
        entityManagerFactory.close();
    }

    //CRUD
    public void insert (Trabajo trabajo){
        try {
            transaction.begin();
            entityManager.persist(trabajo);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }

    }

    //Update
    public void update (Trabajo trabajoOld,Trabajo trabajoNew ){
        try{
            Trabajo update = entityManager.find(Trabajo.class, trabajoOld.getId());
            update.setNombre(trabajoNew.getNombre());
            update.setTurno(trabajoNew.getTurno());
            update.setInicio(trabajoNew.getInicio());
            update.setFin(trabajoNew.getFin());
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }


    }

    public void borra (Trabajo trabajo){

        try{
            transaction.begin();
            Trabajo aborrar = entityManager.find(Trabajo.class, trabajo.getId());
            entityManager.remove(aborrar);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public Trabajo busca (int id){

        return entityManager.find(Trabajo.class, id);


    }

    public List<Trabajo> buscaTodos(){
        Query queryTodosTrabajos = entityManager.createQuery("select e from Trabajo e");//Si quereis lo quitais en casa
        return queryTodosTrabajos.getResultList();

    }


}
