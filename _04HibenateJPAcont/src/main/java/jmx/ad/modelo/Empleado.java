package jmx.ad.modelo;

import lombok.*;

//import javax.persistence.*; //para la versión 5 de hibernate
import jakarta.persistence.*; //para la versión 6 de hibernate
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table (name="empleado",
        uniqueConstraints =  @UniqueConstraint(
        name = "dni_unico",
        columnNames = {
                "dni"}))  //elimino la anotación ya que se llama igual la tabla y la clase, si quieres que la tabla se llame de otra manera debes indicarlo, Cuidado con las mayusculas y minusculas...

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;

    @ManyToOne
    private Departamento departamento;



}
