package org.iesch.ad.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    int id;
    String name;
    String last_name;
    String email;
    String gender;
    String ip_address;
    float money;


}
