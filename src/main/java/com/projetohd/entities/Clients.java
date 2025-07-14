package com.projetohd.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@Table(name = "clients")
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document")
    private String document;

    @Column(name = "fullname", nullable = false, length = 300)
    private String fullname;
    
    @Column(name = "username", nullable = false, length = 300)
    private String username;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "email", length = 60)
    private String email;
    
    @Column(name = "registered_date")
    private LocalDate registeredDate;
    
    @Column(nullable = false, length = 100)
	private String password;
    
    @Embedded
    private Address address;

    public Clients() {}

    public Clients(String document, String fullname, String username, String phone, String email, String password, Address address) {
        this.document = document;
        this.username = username;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.registeredDate = LocalDate.now();
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

   

    public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(document, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Clients other = (Clients) obj;
        return Objects.equals(document, other.document) && Objects.equals(username, other.username);
    }

	@Override
	public String toString() {
		return "Clients [id=" + id + ", document=" + document + ", username=" + username + ", phone=" + phone + ", email="
				+ email + ", registeredDate=" + registeredDate + ", address=" + address + "]";
	}
    
}
