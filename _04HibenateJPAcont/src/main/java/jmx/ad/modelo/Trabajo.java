package jmx.ad.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    String turno;
    LocalTime inicio;
    LocalTime fin;
    @OneToOne
    Persona persona;

    @Override
    public String toString() {
        return "Trabajo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", turno='" + turno + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", persona=" + persona.getDni() + " " + persona.getNombre() + " " + persona.getApellido()+
                '}';
    }
}
