package org.iesch;

import org.iesch.ad.dao.OwnerDao;
import org.iesch.ad.dao.PetDao;
import org.iesch.ad.modelo.Owner;
import org.iesch.ad.modelo.Pet;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        PetDao petDao = new PetDao();
        OwnerDao ownerDao = new OwnerDao();
        /*List list = ownerDao.buscaTodasLasMascotas(1);
        System.out.println(list);*/

        /*List list = petDao.buscaTodasLasMascotasMostrandoSoloNombreYchip(1);
        System.out.println(list);*/

       /* List list = ownerDao.buscaPorCorreo("@google.co.uk");
        System.out.println(list);*/

        //Consulta: Encuentra las mascotas de los dueños cuyo nombre empieza por R
        /*List list = petDao.petsWithOwnerLike("R%");
        System.out.println(list);*/

        //Consulta: Encuentra las mascotas de los dueños cuto nombre es del tipo  ?a% siendo ? cualquier letra
       /* List list = petDao.petsWithOwnerLike("_a%");
        System.out.println(list);
*/
        //Consulta: Encuenta los dueños que tengan apellido = Godfroy
//        List<Owner> consulta = ownerDao.buscaApellido("GodFroy");
//        System.out.println(consulta);
//        consulta.forEach(owner -> System.out.println(owner.toStringSinListaMascotas()));


        //Consulta: Encuentra los dueños que tengan mascotas con chip, cuyo peso sea >150Kg
		//https://docs.jboss.org/hibernate/core/3.6/reference/es-ES/html/queryhql.html#queryhql-joins
//        List<Owner> consulta4 = ownerDao.buscaMascotasChipPeso150();
//        System.out.println(consulta4);
        //Mrcs
       /*List<Owner> consultaDg = petDao.OwnerBuscaChipMas150();
        System.out.println(consultaDg);*/


        //Consulta: Encuentra los dueños que tengan mascotas con typo %dragon, pesen >20Kg y el dueño tenga correo like %.com
        /*List<Owner> consulta4 = petDao.duenosDragones();
        System.out.println(consulta4);*/


        //Inserta un nuevo dueño, pero primero chequea que no existe.
        //buscar que no existe un owner con el mismo nombre y apellido
        //si existe no insertamos
        //si no existe insertamos.
        /*Owner o = Owner.builder().name("Rafa").surname("Nadal").mail("rafa@rafanadal.com").build();
        ownerDao.insertaPrevioCheck(o);*/


        //inserta una nueva mascota al owner con id 830;

        Pet p = Pet.builder().breed("Pastor").type("Perro").hasChip(true).name("Capullito").weight(35).build();
        ownerDao.insertaMascotaAndId(p,830);











    }
}