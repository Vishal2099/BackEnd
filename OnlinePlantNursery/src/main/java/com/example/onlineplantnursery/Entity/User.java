package com.example.onlineplantnursery.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "userrecord")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min = 2, max = 20)
    @NotNull(message = "Pls Enter User Name!")
    private String username;
    @Size(min = 2, max = 20)

    @NotNull(message = "Pls Enter Password!")
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
