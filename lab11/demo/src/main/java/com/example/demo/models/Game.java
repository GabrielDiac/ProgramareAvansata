package com.example.demo.models;


import javax.persistence.*;

@Table(name = "game", schema = "testare", catalog = "")
@Entity
public class Game {

    private int id;
    private String name;
    private int p1ID;
    private int p2ID;
    private String result;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "p1ID")
    public int getP1ID() {
        return p1ID;
    }

    public void setP1ID(int p1ID) {
        this.p1ID = p1ID;
    }

    public int getP2ID() {
        return p2ID;
    }

    @Basic
    @Column(name = "p2ID")
    public void setP2ID(int p2ID) {
        this.p2ID = p2ID;
    }
}
