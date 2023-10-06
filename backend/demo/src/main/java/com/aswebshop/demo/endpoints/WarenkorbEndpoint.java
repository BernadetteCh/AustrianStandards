package com.aswebshop.demo.endpoints;

import com.aswebshop.demo.entitiy.Product;
import com.aswebshop.demo.entitiy.Warenkorb;
import com.aswebshop.demo.service.BestellungService;
import com.aswebshop.demo.service.ProductService;
import com.aswebshop.demo.service.WarenkorbService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/warenkorb")
@CrossOrigin(origins = "*")
public class WarenkorbEndpoint {
    private final WarenkorbService warenkorbService;
    private final BestellungService bestellungService;
    private final ProductService productService;

    public WarenkorbEndpoint(WarenkorbService warenkorbService, BestellungService bestellungService, ProductService productService) {
        this.warenkorbService = warenkorbService;
        this.bestellungService = bestellungService;
        this.productService = productService;
    }

    @GetMapping("/allOrders/{userId}")
    public List<Product> getAllProductsFromWarenkorb(@PathVariable Long userId) {
        List<Long> productIds = warenkorbService.getAllProducts(userId);
        List<Product> products = productService.findAllById(productIds);
        return products;
    }

    @GetMapping("/quantity/{product_id}")
    public Integer getProduct(@PathVariable Integer product_id) {
        Integer quantity = warenkorbService.findProduct(product_id);
        return quantity;
    }

    @DeleteMapping("/delete")
    public List<Product> deleteProduct(@RequestBody Warenkorb warenkorb) {
        warenkorbService.deleteProduct(((int) warenkorb.getProduct_id()));
        List<Long> productIds = warenkorbService.getAllProducts(warenkorb.getUser_id());
        List<Product> products = productService.findAllById(productIds);
        return products;
    }

   @PutMapping("/put")
    public void updateWarenkorb(@RequestBody Warenkorb warenkorb) {
            warenkorbService.updateWarenkorb(warenkorb.getUser_id(),warenkorb.getProduct_id(),warenkorb.getQuantity());
    }




}
