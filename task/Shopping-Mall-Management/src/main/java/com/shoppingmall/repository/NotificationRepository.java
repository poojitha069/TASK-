package com.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmall.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}