package com.shop.Shop.Service;

import com.shop.Shop.Model.Shop;
import com.shop.Shop.Repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ShopServiceImplementation implements ShopService {
    ShopRepository shopRepository;
    @Autowired
    public ShopServiceImplementation(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Optional<Shop> getShopById(int id) {
        return shopRepository.findById(id);
    }

    @Override
    public List<Shop> getShopsByDistrict(String district) {
        return shopRepository.getShopByDistrict(district);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> addShop(Shop newShop) {
        shopRepository.save(newShop);
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> deleteShopById(int id) {
        shopRepository.deleteById(id);
        return shopRepository.findAll();
    }
}
