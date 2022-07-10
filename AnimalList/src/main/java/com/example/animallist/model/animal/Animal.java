package com.example.animallist.model.animal;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "animals")
public class Animal {
    public Animal() {
    }

    public Animal(int typeId, Date dateOfBorn, int id, String name) {
        this.typeId = typeId;
        this.dateOfBorn = dateOfBorn;
        this.id = id;
        this.name = name;
    }

    @Column(name = "typeid")
    @JoinColumn(table = "animaltypes", name = "id")
    @Min(0)
    @Max(10)
    private int typeId;

    @Column(name = "dateofborn")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBorn;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Name is not empty")
    @Size(min = 3, max = 10, message = "MIN = 3, MAX = 10 symbols")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Date getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(Date dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
