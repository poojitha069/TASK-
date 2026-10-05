package com.shoppingmall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingmall.entity.GuestBook;
import com.shoppingmall.repository.GuestBookRepository;

@Service
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    public GuestBookService(GuestBookRepository guestBookRepository) {
        this.guestBookRepository = guestBookRepository;
    }

    public GuestBook addGuestBook(GuestBook guestBook) {

        guestBook.setStatus("OPEN");

        return guestBookRepository.save(guestBook);
    }

    public List<GuestBook> getAllGuestBooks() {

        return guestBookRepository.findAll();
    }

    public GuestBook updateGuestBook(Long id, GuestBook guestBookDetails) {

        GuestBook existingGuestBook =
                guestBookRepository.findById(id).orElse(null);

        if (existingGuestBook != null) {

            existingGuestBook.setShopId(guestBookDetails.getShopId());
            existingGuestBook.setCustomerName(guestBookDetails.getCustomerName());
            existingGuestBook.setMessage(guestBookDetails.getMessage());
            existingGuestBook.setStatus(guestBookDetails.getStatus());

            return guestBookRepository.save(existingGuestBook);
        }

        return null;
    }

    public void deleteGuestBook(Long id) {

        guestBookRepository.deleteById(id);
    }
}