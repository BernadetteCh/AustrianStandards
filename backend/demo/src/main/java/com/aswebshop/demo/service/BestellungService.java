package com.aswebshop.demo.service;

import com.aswebshop.demo.entitiy.BestellStatus;
import com.aswebshop.demo.entitiy.Bestellung;
import com.aswebshop.demo.repository.BestellungRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan
public class BestellungService {

    private final BestellungRepository bestellungRepository;

    public BestellungService(BestellungRepository bestellungRepository) {
        this.bestellungRepository = bestellungRepository;
    }

    public void updateBestellung(int userId, double totalAmount, BestellStatus bestellStatus) {
        bestellungRepository.updateBestellung(userId, totalAmount, bestellStatus);
    }

    public List<Bestellung> findAllBestellungen() {
        return bestellungRepository.findAll();
    }


}
