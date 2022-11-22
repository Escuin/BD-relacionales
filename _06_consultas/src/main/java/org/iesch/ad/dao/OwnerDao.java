package org.iesch.ad.dao;

import jakarta.persistence.*;
import org.iesch.ad.modelo.Pet;

import java.util.List;

public class OwnerDao {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public OwnerDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public List<Pet> buscaTodasLasMascotas(int id){
        Query queryPets = entityManager.createQuery("select e from Pet e where id = :id").setParameter("id", id);
        return queryPets.getResultList();

    }

}
