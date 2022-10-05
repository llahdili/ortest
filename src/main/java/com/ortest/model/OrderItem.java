package com.ortest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ortest.mapstruct.OrderDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "prix_unitaire")
    private String prixUnitaire;

    @Column(name = "prix_ttc")
    private float prixTTC;

    @Column(name = "tva_produit")
    private float productTVA;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
