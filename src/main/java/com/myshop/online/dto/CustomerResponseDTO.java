package com.myshop.online.dto;

import com.myshop.online.model.Customer;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class CustomerResponseDTO {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public static CustomerResponseDTO from(Customer user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }
}
