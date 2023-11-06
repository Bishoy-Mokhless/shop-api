package com.shop.Shop.Repository;

import com.shop.Shop.Model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {
    List<Shop> getShopByDistrict(String district);
    Optional<List<Shop>> findAllByDistrict(String district);

}
