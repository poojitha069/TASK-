package com.shoppingmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingmall.entity.Shop;
import com.shoppingmall.repository.ShopRepository;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop addShop(Shop shop) {
    	shop.setShopStatus("PENDING");

        return shopRepository.save(shop);
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Shop getShopById(Long id) {
        return shopRepository.findById(id).orElse(null);
    }

    public Shop updateShop(Long id, Shop shopDetails) {

        Shop existingShop = shopRepository.findById(id).orElse(null);

        if (existingShop != null) {
            existingShop.setShopName(shopDetails.getShopName());
            existingShop.setOwnerName(shopDetails.getOwnerName());
            existingShop.setCategory(shopDetails.getCategory());
            existingShop.setContactNumber(shopDetails.getContactNumber());
            existingShop.setEmail(shopDetails.getEmail());
            existingShop.setShopNumber(shopDetails.getShopNumber());

            return shopRepository.save(existingShop);
        }

        return null;
    }

    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}