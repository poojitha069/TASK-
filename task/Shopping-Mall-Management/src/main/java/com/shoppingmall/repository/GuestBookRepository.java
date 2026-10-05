package com.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingmall.entity.GuestBook;

public interface GuestBookRepository extends JpaRepository<GuestBook, Long> {

}