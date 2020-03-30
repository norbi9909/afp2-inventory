package com.inventory.demo.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue
    UUID id;
    int userRole;
    String firstName;
    String lastName;

    public User(){}

    public User(UUID id, int userRole, String firstName, String lastName) {
        this.id = id;
        this.userRole = userRole;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public int getUserRole() {
        return userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
