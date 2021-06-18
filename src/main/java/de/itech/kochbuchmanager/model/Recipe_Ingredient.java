package de.itech.kochbuchmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "recipe_ingredient", schema = "manager")
public class Recipe_Ingredient {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recipe_ingredient_id;

    @ManyToOne
    @MapsId("recipe_id")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @MapsId("ingredient_id")
    @JoinColumn(name = "ingredient_id")
    private Ingedient ingredient;

    @Getter
    @Setter
    @Column(name = "AMOUNT")
    private int amount;

    @Getter
    @Setter
    @Column(name = "UNIT")
    private String unit;

}
