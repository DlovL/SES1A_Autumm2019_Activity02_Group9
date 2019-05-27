package com.example.administrator.mydairy;

/**
 * Created by ztt on 2019-05-19.
 */

public class Charity {
    private int id;
    private String name;
    private String address;
    private double juli;
    private String date;
    private String username;
    public Charity(){};
    public Charity(String name,String address){
        this.name = name;
        this.address = address;
    }
    public Charity(String name,String address,double juli){
        this.name = name;
        this.address = address;
        this.juli = juli;
    }
    public Charity(String name,String address,String date){
        this.name = name;
        this.address = address;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getJuli() {
        return juli;
    }

    public void setJuli(double juli) {
        this.juli = juli;
    }
}
