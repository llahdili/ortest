package com.ortest.model;

import com.ortest.utils.Statu;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Setter
@Getter
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_created")
    private Date dateCreatedOrder;

    @Column(name = "reference")
    private String reference;

    @Column(name = "totale_ttc")
    private float totaleTTC;

    @Column(name = "totale_hors_tax")
    private float totaleHorsTax;

    @Column(name = "active")
    private boolean active;

    @Column(name = "status")
    private Statu statu;

    @Column(name = "validation")
    private boolean validation;
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();
*/
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems = new HashSet<>();



}
