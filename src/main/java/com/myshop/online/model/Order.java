package com.myshop.online.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="orders")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<ProductInCart> productInCartList;

}













