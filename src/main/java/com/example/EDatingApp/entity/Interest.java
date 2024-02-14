package com.example.EDatingApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    private String likes;
    private String dislikes;
    private String hobbies;
    private String profileUrl;
    private String about;

    @Transient
    private int userAccountId;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
}
