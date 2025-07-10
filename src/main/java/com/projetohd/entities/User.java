package com.projetohd.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users", uniqueConstraints = {
@UniqueConstraint(columnNames = "username")
})
public class User implements Serializable {


private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false, unique = true, length = 60)
private String username;

@Column(nullable = false, length = 100)
private String password;

@Enumerated(EnumType.STRING)
@Column(nullable = false, length = 20)
private UserRole role;

@Column(length = 255)
private String fullName;

@Column(length = 60)
private String email;
@Column(name = "registered_date")
private LocalDate registereddate;

public User() {}

public User(String username, String password, UserRole role, String fullName, String email) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.fullName = fullName;
    this.email = email;
    this.registereddate = LocalDate.now();
}

// Getters and setters

public Long getId() {
    return id;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public UserRole getRole() {
    return role;
}

public void setRole(UserRole role) {
    this.role = role;
}

public String getFullName() {
    return fullName;
}

public void setFullName(String fullName) {
    this.fullName = fullName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

// equals and hashCode (baseado em username)

public LocalDate getRegistereddate() {
	return registereddate;
}

public void setRegistereddate(LocalDate registereddate) {
	this.registereddate = registereddate;
}

@Override
public int hashCode() {
    return username != null ? username.hashCode() : 0;
}

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof User)) return false;
    User other = (User) obj;
    return username != null && username.equals(other.getUsername());
}

@Override
public String toString() {
    return "User{id=" + id + ", username='" + username + "', role=" + role + "}";
}
}
