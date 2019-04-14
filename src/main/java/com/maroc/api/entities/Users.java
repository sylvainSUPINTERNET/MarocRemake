package com.maroc.api.entities;


import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Entity
//https://projectlombok.org/features/Data (utilise pas ici)
@Table(name = "users")
public class Users implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @NotEmpty @Size(min=2, max=50) private String firstname;
    @NotEmpty @Size(min=2, max=50) private String lastname;

    /**
     * Call via callback
     */
    private Date createdAt;
    private Date updatedAt;

    public Users(){}

    public Users(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @PrePersist
    public void setCreatedAt(){
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt(){
        this.updatedAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }


}
