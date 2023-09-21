package com;

public class Donor {
    private int id;
    private String name;
    private String email;
    private String bloodType;
    private String contact;
    
    // Constructors, getters, and setters
    
    public String setName(String name) {
        return this.name = name;
    }
    
    public String setEmail(String email) {
        return this.email = email;
    }
    
    public String setBloodType(String bloodType) {
        return this.bloodType = bloodType;
    }
    
    public String setContact(String contact) {
        return this.contact = contact;
    }
}