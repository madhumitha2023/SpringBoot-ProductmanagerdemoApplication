package co.pragra.learning.productmanagerdemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TABLE_USER")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private Date createDate;
    private Date updateDate;

//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private List<Review> reviews;


}
