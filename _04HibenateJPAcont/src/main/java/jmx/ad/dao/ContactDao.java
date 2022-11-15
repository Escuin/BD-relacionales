package jmx.ad.dao;

import jakarta.persistence.*;
import jmx.ad.modelo.Contact;


import java.util.List;

public class ContactDao {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public ContactDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void cierra (){
        entityManager.close();
        entityManagerFactory.close();
    }
    
    //CRUD
    public void insert (Contact contact){
        try {
            transaction.begin();
            entityManager.persist(contact);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }

    }

    //Update
    public void update (Contact contactOld,Contact contactNew ){
        try{
            Contact update = entityManager.find(Contact.class, contactOld.getId());
            update.setName(contactNew.getName());
            update.setNotes(contactNew.getNotes());
            update.setWebsite(contactNew.getWebsite());
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }


    }

    public void borra (Contact contact){

        try{
            transaction.begin();
            Contact aborrar = entityManager.find(Contact.class, contact.getId());
            entityManager.remove(aborrar);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    public Contact busca (int id){

        return entityManager.find(Contact.class, id);


    }

    public List<Contact> buscaTodos(){
        Query queryTodosContacts = entityManager.createQuery("select e from Contact e");//Si quereis lo quitais en casa
        return queryTodosContacts.getResultList();

    }


}
