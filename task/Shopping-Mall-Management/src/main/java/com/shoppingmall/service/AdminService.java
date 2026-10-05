package com.shoppingmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingmall.entity.Shop;
import com.shoppingmall.repository.ShopRepository;

@Service
public class AdminService {

    private final ShopRepository shopRepository;

    public AdminService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> getPendingShops() {

        return shopRepository.findAll()
                .stream()
                .filter(shop -> "PENDING".equalsIgnoreCase(shop.getShopStatus()))
                .toList();
    }

    public Shop approveShop(Long id) {

        Shop shop = shopRepository.findById(id).orElse(null);

        if (shop != null) {
            shop.setShopStatus("APPROVED");
            return shopRepository.save(shop);
        }

        return null;
    }

    public Shop rejectShop(Long id) {

        Shop shop = shopRepository.findById(id).orElse(null);

        if (shop != null) {
            shop.setShopStatus("REJECTED");
            return shopRepository.save(shop);
        }

        return null;
    }
}