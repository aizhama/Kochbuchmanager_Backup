package de.itech.kochbuchmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Entity
@Table(name = "ingredient", schema = "manager")
public class Ingedient {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredient_id;

    @Getter
    @Setter
    @Column(unique = true, name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "ingredient_trait",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "trait_id")
    )
    private Set<Trait> traits;


}
