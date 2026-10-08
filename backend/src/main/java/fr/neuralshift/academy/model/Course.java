package fr.neuralshift.academy.model;

import java.math.BigDecimal;

@Entity                       // cette classe = une table "course"
public class Course {
    @Id                       // clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private BigDecimal price;
    private boolean published;

    // + getters et setters : Cmd + N > Getter and Setter > tout sélectionner
}
