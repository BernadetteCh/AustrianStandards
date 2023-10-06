package com.aswebshop.demo.repository;

import com.aswebshop.demo.entitiy.Warenkorb;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WarenkorbRepository extends JpaRepository<Warenkorb, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Warenkorb w SET w.quantity = :quantity WHERE w.product_id = :product_id")
    Integer updateWarenkorb(@Param("quantity") int quantity, @Param("product_id") int product_id);

    @Modifying
    @Transactional
    @Query("SELECT w.product_id FROM Warenkorb w WHERE w.user_id = :userId")
    List<Long> findAllWarenkörbeOfUserId(long userId);



    @Query("SELECT SUM(w.quantity) FROM Warenkorb w WHERE w.product_id = :productId")
    Integer findWarenkorb(@Param("productId") int productId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Warenkorb w WHERE w.product_id = :id")
    Integer deleteAllById(int id);

    @Query("SELECT w FROM Warenkorb w WHERE w.product_id = :productId")
    Warenkorb findByProductId(@Param("productId") int productId);


}
