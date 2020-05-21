package com.myshop.online.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
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
    @Column
    private Date orderDate;

    @Column
    private int orderNum;

    @Column
    private double amount;

    @Column
    private String customerName;

    @Column
    private String customerAddress;

    @Column
    private String customerEmail;

    @Column
    private String customerPhone;

    @OneToMany
    private List<ProductInCart> productInCartList;

    public void setId(String toString) {
    }
}













