package com.projetohd.entities;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("IndividualClient")
@Table(name = "individual_clients", uniqueConstraints = {
    @UniqueConstraint(columnNames = "cpf")
})
public class IndividualClient extends Clients {
    private static final long serialVersionUID = 1L;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "age", nullable = false)
    private int age;

 

    public IndividualClient(String username,String fullname, String phone, String email,String password, Address address,
                            String cpf, LocalDate birthDate) {
        super(cpf,username,fullname, phone, email, password, address); 
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.age = calculateAge(birthDate);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        this.age = calculateAge(birthDate);
    }

    public int getAge() {
        return age;
    }

    private int calculateAge(LocalDate birthDate) {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
