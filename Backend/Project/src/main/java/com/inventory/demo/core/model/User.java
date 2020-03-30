package com.inventory.demo.core.model;

import javax.management.relation.Role;

@Entity
public class User {
    @Id
    @GeneratedValue
    UUID id;
    int userRole;
    String firstname;
    String lastname;

    public User(){}

    public User(UUID id, int userRole, String firstname, String lastname) {
        this.id = id;
        this.userRole = userRole;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public UUID getId() {
        return id;
    }

    public int getUserRole() {
        return userRole;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
