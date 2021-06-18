package de.itech.kochbuchmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@Entity
@Table(name = "users", schema = "manager")
public class User {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

/*    @Getter
    @Setter
    @Column(name = "ACCOUNT_ACTIVE")
    private boolean accountActive;*/

    @Getter
    @Setter
    @Column(name = "USERNAME")
    private String username;

/*
    @Getter
    @Setter
    @Column(unique = true, name = "EMAIL")
    private String email;
*/

/*    @Getter
    @Setter
    @Column(name = "PASSWORD")
    private String password;

    @Getter
    @Setter
    @Column(name = "PASSWORD_SET_ON")
    private LocalDate passwordSetOn;*/

    @Getter
    @Setter
    @Column(name = "ROLE")
    private String role;
}
