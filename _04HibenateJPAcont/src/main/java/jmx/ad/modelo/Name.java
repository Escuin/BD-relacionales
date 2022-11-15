package jmx.ad.modelo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class Name {

    private String firstName;

    private String middleName;

    private String lastName;

    // getters and setters omitted
}
