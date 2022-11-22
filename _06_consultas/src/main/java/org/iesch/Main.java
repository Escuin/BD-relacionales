package org.iesch;

import org.iesch.ad.dao.OwnerDao;
import org.iesch.ad.dao.PetDao;
import org.iesch.ad.modelo.Pet;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        PetDao petDao = new PetDao();
        OwnerDao ownerDao = new OwnerDao();
        /*List list = ownerDao.buscaTodasLasMascotas(1);
        System.out.println(list);*/

        List list = petDao.buscaTodasLasMascotasMostrandoSoloNombreYchip(1);
        System.out.println(list);



    }
}