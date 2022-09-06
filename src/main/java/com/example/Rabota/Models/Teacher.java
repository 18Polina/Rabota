package com.example.Rabota.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String surname;
    private String name;
    private String middlename;
    private String bthday;
    private int yearprepodav;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getBthday() {
        return bthday;
    }

    public void setBthday(String bthday) {
        this.bthday = bthday;
    }

    public int getYearprepodav() {
        return yearprepodav;
    }

    public void setYearprepodav(int yearprepodav) {
        this.yearprepodav = yearprepodav;
    }

    public Teacher(String surname, String name, String middlename, String bthday, int yearprepodav) {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.bthday = bthday;
        this.yearprepodav = yearprepodav;
    }

    public Teacher() {
    }
}
