package com.aswebshop.demo.endpoints;

import com.aswebshop.demo.entitiy.Bestellung;
import com.aswebshop.demo.service.BestellungService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bestellungen")
@CrossOrigin(origins = "*")
public class Bestellungendpoint {

    private final BestellungService bestellungService;

    public Bestellungendpoint(BestellungService bestellungService) {
        this.bestellungService = bestellungService;
    }

    @GetMapping
    public List<Bestellung> findAll() {
        return bestellungService.findAllBestellungen();
    }

    @PutMapping("totalprice")
    public void updateTotalPrice(@RequestBody Bestellung bestellung) {
        bestellungService.updateBestellung(bestellung.getUser_id(), bestellung.getTotal_amount(),bestellung.getBestellStatus());
    }

}
