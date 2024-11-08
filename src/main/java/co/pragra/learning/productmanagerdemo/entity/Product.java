package co.pragra.learning.productmanagerdemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID id;
    private String name;
    private String description;
    private double cost;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Review> reviews;
}
