package de.itech.kochbuchmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "trait", schema = "manager")
public class Trait {

    //Auto fill on creation?
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long trait_id;

    @Getter
    @Setter
    @Column(unique = true, name = "NAME")
    private String name;
}
