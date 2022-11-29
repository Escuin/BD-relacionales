package org.iesch.ad.dao;

import jakarta.persistence.*;
import org.iesch.ad.modelo.Owner;
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

    //deberia estar en PETDAO!!!! Perdon!
    public List<Pet> buscaTodasLasMascotas(int id){
        Query queryPets = entityManager.createQuery("select e from Pet e where id = :id").setParameter("id", id);
        return queryPets.getResultList();

    }

    public List<Owner> buscaPorCorreo(String dominio){
        TypedQuery<Owner> namedQueryCorreo = entityManager.createNamedQuery("dueno.BuscaCorreos", Owner.class );
        namedQueryCorreo.setParameter("correo","%"+dominio);
        return namedQueryCorreo.getResultList();
    }

    public List<Owner> buscaApellido(String apellido) {
        Query queryPets = entityManager.createQuery("select e from Owner e where e.surname = :apellido").setParameter("apellido", apellido);
        return queryPets.getResultList();
    }

    public List<Owner> buscaMascotasChipPeso150() {
        //sql = "select o.* from pet p join owner o  on o.id = p.owner_id where haschip  = true and weight > 150;"
        //Query queryPets = entityManager.createQuery("select e.owner from Pet e where e.hasChip = true and e.weight > 150");
        Query queryPets = entityManager.createQuery("select o from Pet as p join Owner as o  with o.id = p.owner.id where p.hasChip  = true and p.weight > 150");
        return queryPets.getResultList();
    }

    public void insertaPrevioCheck (Owner o){
        Query consulta = entityManager.createQuery("select count(o) from Owner o where name = :nombre and surname  = :apellido").setParameter("nombre", o.getName()).setParameter("apellido", o.getSurname());
        if(consulta.getResultList().isEmpty()){

            transaction.begin();
        entityManager.persist(o);
        transaction.commit();
        }else System.out.println("YA existía");


    }

    public void insertaMascotaAndId(Pet p, int id){
        Owner o = entityManager.find(Owner.class, id);
        o.



    }


}
