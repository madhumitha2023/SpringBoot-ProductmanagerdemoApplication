package co.pragra.learning.productmanagerdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String review;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @ManyToOne
    @JsonIgnore
    private Product product;
}
