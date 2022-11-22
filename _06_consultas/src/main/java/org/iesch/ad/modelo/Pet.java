package org.iesch.ad.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String breed;
    String type;
    boolean hasChip;
    Double weight;
    @ManyToOne
    private Owner owner;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", type='" + type + '\'' +
                ", hasChip=" + hasChip +
                ", weight=" + weight +
                ", owner=" + owner.getName() +" " + owner.getSurname() +
                '}' + "\n";
    }


}
