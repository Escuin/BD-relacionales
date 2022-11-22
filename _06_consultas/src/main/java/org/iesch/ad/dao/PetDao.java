package org.iesch.ad.dao;

import jakarta.persistence.*;
import org.iesch.ad.dto.MascotaNombreChip;
import org.iesch.ad.modelo.Pet;

import java.util.List;

public class PetDao {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public PetDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
    public List<Pet> buscaTodasLasMascotas(){
        Query queryPets = entityManager.createQuery("select e from Pet e");
        return queryPets.getResultList();

    }

    //Mostrar solo el nombre del perro y si tiene chip para el usuario q le pases como parametro
    public List<MascotaNombreChip> buscaTodasLasMascotasMostrandoSoloNombreYchip(int owner){
        Query queryPets = entityManager.createQuery("select new org.iesch.ad.dto.MascotaNombreChip(e.name,e.hasChip) from Pet e where owner.id = :owner").setParameter("owner", owner);
        return queryPets.getResultList();

    }








}
