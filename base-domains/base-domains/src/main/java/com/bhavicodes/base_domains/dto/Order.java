package com.bhavicodes.base_domains.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    private String oderId;
    private String name;
    private int qty;
    private double price;

}
