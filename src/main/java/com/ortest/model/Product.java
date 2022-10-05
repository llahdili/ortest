package com.ortest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Data
@Table(name = "product")
@Entity
@NoArgsConstructor
public class Product {

        @Id
        @GeneratedValue(strategy = AUTO)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "unit_price")
        @NonNull
        private float unitPrice;

        @Column(name = "product_active")
        private boolean active=true;

        @Column(name = "units_in_stock")
        private int unitsInStock;

        @Column(name = "date")
        private String dateCreatedProdut;

        @Column(name="traking")
        private String reference;

}
