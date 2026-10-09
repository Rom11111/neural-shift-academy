package fr.neuralshift.academy.model;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
// + getters et setters : Cmd + N > Getter and Setter > tout sélectionner
}
