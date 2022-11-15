package jmx.ad.dao;

import jakarta.persistence.*;
import jmx.ad.modelo.Persona;

import java.util.List;

public class PersonaDao {


    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public PersonaDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void cierra (){
        entityManager.close();
        entityManagerFactory.close();
    }

    //CRUD
    public void insert (Persona persona){
        try {
            transaction.begin();
            entityManager.persist(persona);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }

    }

    //Update
    public void update (Persona personaOld,Persona personaNew ){
        try{
            Persona update = entityManager.find(Persona.class, personaOld.getDni());
            update.setNombre(personaNew.getNombre());
            update.setApellido(personaNew.getApellido());
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }


    }

    public void borra (Persona persona){

        try{
            transaction.begin();
            Persona aborrar = entityManager.find(Persona.class, persona.getDni());
            entityManager.remove(aborrar);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public Persona busca (String dni){

        return entityManager.find(Persona.class, dni);


    }

    public List<Persona> buscaTodos(){
        Query queryTodosPersonas = entityManager.createQuery("select e from Persona e");//Si quereis lo quitais en casa
        return queryTodosPersonas.getResultList();

    }


}
