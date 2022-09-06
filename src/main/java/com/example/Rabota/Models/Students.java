package com.example.Rabota.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String lastname;
    private String name;
    private String middlename;
    private String birthday;
    private int groupp;

    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getMiddlename() {return middlename;}

    public void setMiddlename(String middlename) {this.middlename = middlename;}

    public String getBirthday() {return birthday;}

    public void setBirthday(String birthday) {this.birthday = birthday;}

    public int getGroupp() {return groupp;}

    public void setGroupp(int groupp) {this.groupp = groupp;}

    public Students() {}

    public Students(String lastname, String name, String middlename, String birthday, int groupp) {
        this.lastname = lastname;
        this.name = name;
        this.middlename = middlename;
        this.birthday = birthday;
        this.groupp = groupp;
    }


}

