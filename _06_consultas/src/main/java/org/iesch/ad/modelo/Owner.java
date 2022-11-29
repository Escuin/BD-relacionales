
package org.iesch.ad.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
//named query que nos busque la gente con correo especifico x ej: @gmail
    @NamedQuery(name = "dueno.BuscaCorreos", query = "FROM Owner o where o.mail like :correo")
    public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String surname;
    @Column(name = "email")
    String mail;
    @OneToMany
    @JoinColumn(name = "owner_id")
    List<Pet> ownerList;


    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                '}' + "\n";
    }


        public String toStringConMascotas() {
            return "Owner{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", mail='" + mail + '\'' +
                    ", ownerList=" + ownerList +
                    '}';
        }

        public addPet (Pet p){

        }


}
