package com.yyzstudy.zeshuailand.model.po;


import javax.persistence.*;
import java.util.List;

@Entity(name = "Role")
@Table(name = "role")
public class Role {


    @Id
    private int id;


    @Column(name = "name")
    private String name;


    public Role() {
    }
    public Role(int id){
        this.id = id;
    }


    public Role(int id, String name) {
        this.id = id;
        this.name = name;
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
}
