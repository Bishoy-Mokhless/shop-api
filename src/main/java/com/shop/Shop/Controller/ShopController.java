package com.shop.Shop.Controller;

import com.shop.Shop.Model.Response;
import com.shop.Shop.Model.Shop;
import com.shop.Shop.Service.ShopService;
import com.shop.Shop.Service.ShopServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class ShopController {
    ShopService shopService;
    @Autowired
    public ShopController(ShopServiceImplementation shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getShopById(@PathVariable int id) {
        Optional<Shop> shop = shopService.getShopById(id);

        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .message("Shop retrieved successfully")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(shop.orElse(null))
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/district/{district}")
    public ResponseEntity<Response> getShopsByDistrict(@PathVariable String district) {
        List<Shop> shops = shopService.getShopsByDistrict(district);

        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .message("Shops retrieved successfully")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(shops)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> getAllShops() {
        List<Shop> shops = shopService.getAllShops();

        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .message("All shops retrieved successfully")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(shops)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response> addShop(@RequestBody Shop newShop) {
        List<Shop> shops = shopService.addShop(newShop);

        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .message("Shop added successfully")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .data(shops)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteShopById(@PathVariable int id) {
        List<Shop> shops = shopService.deleteShopById(id);

        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .message("Shop deleted successfully")
                .status(HttpStatus.NO_CONTENT)
                .statusCode(HttpStatus.NO_CONTENT.value())
                .data(shops)
                .build();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }


}
