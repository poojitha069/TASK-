package com.shoppingmall.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.entity.Shop;
import com.shoppingmall.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/pending-shops")
    public List<Shop> getPendingShops() {
        return adminService.getPendingShops();
    }

    @PutMapping("/shops/{id}/approve")
    public ResponseEntity<Shop> approveShop(@PathVariable Long id) {

        Shop shop = adminService.approveShop(id);

        if (shop != null) {
            return ResponseEntity.ok(shop);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/shops/{id}/reject")
    public ResponseEntity<Shop> rejectShop(@PathVariable Long id) {

        Shop shop = adminService.rejectShop(id);

        if (shop != null) {
            return ResponseEntity.ok(shop);
        }

        return ResponseEntity.notFound().build();
    }
}