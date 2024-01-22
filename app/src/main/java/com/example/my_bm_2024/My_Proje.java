package com.example.my_bm_2024;

public class My_Proje {
    String name;
    String Lastname;
    String email;


    public My_Proje(String name) {
        this.name = name;
    }

    public My_Proje(String name, String email, String lastname) {
        this.name = name;
        this.email = email;
        Lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}
