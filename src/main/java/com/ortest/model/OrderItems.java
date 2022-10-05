package com.ortest.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
public class OrderItems {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private int quantity;
    @JsonIgnore
    @ManyToOne
    private Orders orders;

    @ManyToOne
    private Products products;

}
