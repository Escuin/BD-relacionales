package org.iesch.ad.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String marca;
    String modelo;
    String color;
    @OneToMany
    @JoinColumn(name = "coche_id")
    List<Mecanico> mecanicoList;
}
