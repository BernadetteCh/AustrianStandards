package com.aswebshop.demo.endpoints;

import com.aswebshop.demo.entitiy.Product;
import com.aswebshop.demo.entitiy.Warenkorb;
import com.aswebshop.demo.repository.ProductRepository;
import com.aswebshop.demo.repository.WarenkorbRepository;
import com.aswebshop.demo.service.BestellungService;
import com.aswebshop.demo.service.ProductService;
import com.aswebshop.demo.service.UserService;
import com.aswebshop.demo.service.WarenkorbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@WebMvcTest
class WarenkorbEndpointTest {
    @MockBean
    ProductService productService;
    @MockBean
    WarenkorbEndpoint warenkorbEndpoint;
    @MockBean
    BestellungService bestellungService;
    @MockBean
    UserService userService;
    @MockBean
    WarenkorbService warenkorbService;
    @MockBean
    ProductRepository productRepository;
    @MockBean
    WarenkorbRepository warenkorbRepository;
    @Autowired
    MockMvc mockMvc;

    @Test
    void getProduct(){
        Integer productId = 1;
        Integer expectedQuantity = 5;
        when(warenkorbRepository.findByProductId(1)).thenReturn(new Warenkorb(1,productId,expectedQuantity));
        when(warenkorbService.findProduct(productId)).thenReturn(5);
        assertEquals(expectedQuantity,warenkorbService.findProduct(productId));
    }

    @Test
    void getAllProductsFromWarenkorb() {
       float price = 60.21F;
        when(warenkorbService.getAllProducts(1l)).thenReturn(List.of(1L));
        when(productService.findAllById(List.of(1L))).thenReturn(List.of(new Product("","","",price,"")));
        assertEquals(List.of(new Product("","","",price,"")),productService.findAllById(List.of(1L)));
    }
}