package com.example.animallist.model.link;

import javax.persistence.*;

@Table(name = "links")
@Entity
public class Link {

    public Link() {}

    public Link(int id, int userId, int animalId) {
        this.id = id;
        this.userId = userId;
        this.animalId = animalId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "animal_id")
    private int animalId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}
