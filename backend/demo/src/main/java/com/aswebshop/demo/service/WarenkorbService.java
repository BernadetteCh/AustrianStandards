package com.aswebshop.demo.service;


import com.aswebshop.demo.entitiy.Warenkorb;
import com.aswebshop.demo.repository.WarenkorbRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarenkorbService {

    private final WarenkorbRepository warenkorbRepository;

    public WarenkorbService(WarenkorbRepository warenkorbRepository) {
        this.warenkorbRepository = warenkorbRepository;
    }


    public void updateWarenkorb(int userId, int productId, int quantity) {
        Warenkorb warenkorb = warenkorbRepository.findByProductId(productId);
        if (warenkorb == null) {
            warenkorbRepository.save(new Warenkorb(userId, productId, quantity));
        } else {
            warenkorbRepository.updateWarenkorb(quantity, productId);
        }
    }

    public List<Long> getAllProducts(long userId) {
        return warenkorbRepository.findAllWarenkörbeOfUserId(userId);
    }

    public void deleteProduct(int productId) {
          warenkorbRepository.deleteAllById(productId);

    }

    public Integer findProduct(int product_id) {
        Integer quantity = warenkorbRepository.findWarenkorb(product_id);
        return quantity;
    }
}
