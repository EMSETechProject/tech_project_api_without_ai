package com.robin.camarasa.nutritvecoach.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SuppressWarnings("serial")
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @SuppressWarnings("unused")
    public Recipe() {
    }

    public Recipe(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
