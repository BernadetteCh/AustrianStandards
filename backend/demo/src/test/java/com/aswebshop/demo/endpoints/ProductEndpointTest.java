package com.aswebshop.demo.endpoints;

import com.aswebshop.demo.repository.ProductRepository;
import com.aswebshop.demo.repository.WarenkorbRepository;
import com.aswebshop.demo.service.BestellungService;
import com.aswebshop.demo.service.ProductService;
import com.aswebshop.demo.service.UserService;
import com.aswebshop.demo.service.WarenkorbService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest
class ProductEndpointTest {
    @MockBean
    ProductService productService;
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

    String allproducts = "/products";


    @Test
    void getAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(allproducts)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}