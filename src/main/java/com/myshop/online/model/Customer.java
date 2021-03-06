package com.myshop.online.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Table(name="customers")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String address;
    @NotNull
    @Column
    private String phoneNumber;

    @NotNull
    @Column
    private String email;

    @NotNull
    @Column
    String password;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column
    @Builder.Default
    private String role = "USER";



    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList;

}













