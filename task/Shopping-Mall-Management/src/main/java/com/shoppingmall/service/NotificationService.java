package com.shoppingmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingmall.entity.Notification;
import com.shoppingmall.repository.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification sendNotification(Notification notification) {

        notification.setStatus("SENT");

        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }
}