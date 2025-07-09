package com.projretohd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;



@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "company_clients")
public class CompanyClient extends Clients {
    private static final long serialVersionUID = 1L;

    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "corporate_name", length = 255, nullable = false)
    private String corporateName;

    public CompanyClient() {}

    public CompanyClient(String cnpj, String name, String phone, String email, Address address, String corporateName) {
        super(cnpj, name, phone, email, address);
        this.cnpj = cnpj;
        this.corporateName = corporateName;
    }


    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
}
