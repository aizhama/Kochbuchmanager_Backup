package de.itech.kochbuchmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Entity
@Table(name = "recipe", schema = "manager")
public class Recipe {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recipe_id;

    @Getter
    @Setter
    @Column(unique = true, name = "TITLE")
    private String title;

    @Getter
    @Setter
    @Column(name = "CATAGORY")
    private String catagory;

    @Getter
    @Setter
    @Column(name = "LEVEL")
    private String level;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Getter
    @Setter
    @Lob
    @Column(name = "METHOD")
    private String method;

    @Getter
    @Setter
    @OneToMany(mappedBy = "recipe")
    private Set<Recipe_Ingredient> ingredients;
}
