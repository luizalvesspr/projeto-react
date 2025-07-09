package com.projretohd.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class ServiceOffered implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "duration_minutes")
    private Integer durationInMinutes;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "active")
    private boolean active;

    public ServiceOffered() {
        this.createdDate = LocalDate.now();
        this.active = true;
    }

    public ServiceOffered(String name, String description, BigDecimal price, Integer durationInMinutes) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
        this.createdDate = LocalDate.now();
        this.active = true;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ServiceOffered [id=" + id + ", name=" + name + ", price=" + price + ", duration=" + durationInMinutes + "]";
    }
}
