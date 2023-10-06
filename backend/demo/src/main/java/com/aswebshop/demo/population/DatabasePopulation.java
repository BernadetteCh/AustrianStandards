package com.aswebshop.demo.population;

import com.aswebshop.demo.converter.Base64Converter;
import com.aswebshop.demo.entitiy.*;
import com.aswebshop.demo.io.FileReader;
import com.aswebshop.demo.reader.DataReader;
import com.aswebshop.demo.reader.ProductTransformer;
import com.aswebshop.demo.repository.BestellungRepository;
import com.aswebshop.demo.repository.ProductRepository;
import com.aswebshop.demo.repository.WarenkorbRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class DatabasePopulation {

    @Bean
    ApplicationRunner populate(
            BestellungRepository bestellungRepository,
            ProductRepository productRepository,
            WarenkorbRepository warenkorbRepository) {
        return args -> {
            String productsPath = "C:\\Users\\berni\\Desktop\\MyProjects\\ASWebshop\\backend\\demo\\src\\main\\resources\\csvFiles\\products.csv";
            FileReader fileReader = new FileReader();
            DataReader dataReader = new DataReader(fileReader);
            Base64Converter base64Converter = new Base64Converter();
            ProductTransformer productTransformer = new ProductTransformer(base64Converter);
            List<Product> products = dataReader.read(productsPath, productTransformer);
            productRepository.saveAll(products);
            warenkorbRepository.save(new Warenkorb(1,0,0));
            bestellungRepository.save(new Bestellung(1,0.0, BestellStatus.AUSSTEHEND));
        };
    }
}
