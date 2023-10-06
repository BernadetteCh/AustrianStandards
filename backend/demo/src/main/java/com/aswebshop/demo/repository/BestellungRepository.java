package com.aswebshop.demo.repository;

import com.aswebshop.demo.entitiy.BestellStatus;
import com.aswebshop.demo.entitiy.Bestellung;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BestellungRepository extends JpaRepository<Bestellung, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Bestellung b SET b.user_id = :userId, b.total_amount= :totalAmount, b.bestellStatus = :bestellstatus")
    Integer updateBestellung(@Param("userId") int userId, @Param("totalAmount") double totalAmount, @Param("bestellstatus") BestellStatus bestellStatus);

}
