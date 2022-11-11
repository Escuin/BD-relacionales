package jmx.ad.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bank_id")//evita la creación de N:N
    private List<Account> bankAccounts;

    public void addBankAccount (Account bankAccount){
        bankAccounts.add(bankAccount);
    }

    public void removeBankAccount (Account bankAccount){
        bankAccounts.remove(bankAccount);
    }

}
