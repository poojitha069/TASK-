package com.shoppingmall.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.entity.Shop;
import com.shoppingmall.service.ShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Long id) {

        Shop shop = shopService.getShopById(id);

        if (shop != null) {
            return ResponseEntity.ok(shop);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(
            @PathVariable Long id,
            @RequestBody Shop shopDetails) {

        Shop updatedShop = shopService.updateShop(id, shopDetails);

        if (updatedShop != null) {
            return ResponseEntity.ok(updatedShop);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id) {

        Shop shop = shopService.getShopById(id);

        if (shop != null) {
            shopService.deleteShop(id);
            return ResponseEntity.ok("Shop deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}