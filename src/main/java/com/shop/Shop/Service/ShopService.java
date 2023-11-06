package com.shop.Shop.Service;

import com.shop.Shop.Model.Shop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ShopService {
    public Optional<Shop> getShopById(int id);
    public List<Shop> getShopsByDistrict(String district);
    public List<Shop> getAllShops();
    public List<Shop> addShop(Shop newShop);
    public List<Shop> deleteShopById(int id);

}
