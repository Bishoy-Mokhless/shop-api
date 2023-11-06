package com.shop.Shop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shop {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String code;
    private String district;
    private Boolean status;


}
