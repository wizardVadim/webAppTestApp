package com.example.animallist.model.user;

import com.example.animallist.model.animal.Animal;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User(){}

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Login is not empty")
    @Size(min = 3, max = 10, message = "Min = 3, Max = 10")
    private String login;

    @NotEmpty(message = "Password is not empty")
    @Size(min = 3, max = 15, message = "Min = 3, Max = 15")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
