package com.bhavicodes.base_domains.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEvent {

    private String message;
    private Order order;
    private String  status;
}
