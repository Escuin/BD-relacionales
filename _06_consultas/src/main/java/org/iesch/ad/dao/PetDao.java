package org.iesch.ad.dao;

import jakarta.persistence.*;
import org.iesch.ad.dto.MascotaNombreChip;
import org.iesch.ad.modelo.Owner;
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


    public List<Pet> petsWithOwnerLike(String consulta) {
        Query queryPets = entityManager.createQuery("select e from Pet e where e.owner.name like :consulta").setParameter("consulta", consulta);
        return queryPets.getResultList();
    }


    public List<Owner> duenosDragones() {
        Query queryBuscaOwnerConDragonMenosDe20CorreoPuntoCom = entityManager
                .createQuery("select e.owner from Pet e where e.type like '%dragon' and e.weight > 20 and e.owner.mail like '%.com' ");
        return queryBuscaOwnerConDragonMenosDe20CorreoPuntoCom.getResultList();
    }

    public List<Owner>  OwnerBuscaChipMas150() {
        //Long numero = (Long) entityManager.createQuery("select count(e.owner) from Pet e where e.hasChip = 'true' and e.weight < 150").getSingleResult();
        Query queryOwnerBuscaChipMas150 = entityManager.createQuery("select e.owner from Pet e where e.hasChip = 'true' and e.weight < 150");

        return queryOwnerBuscaChipMas150.getResultList();

    }


}
