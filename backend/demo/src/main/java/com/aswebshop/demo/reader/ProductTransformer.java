package com.aswebshop.demo.reader;

import com.aswebshop.demo.converter.Base64Converter;
import com.aswebshop.demo.entitiy.Product;

import java.io.IOException;

public class ProductTransformer implements DataTransformer<Product>{

    private final Base64Converter base64Converter;

    public ProductTransformer(Base64Converter base64Converter) {
        this.base64Converter = base64Converter;
    }

    @Override
    public Product transform(String line) throws IOException {
        String[] columns = line.split(";");
        String product_name = columns[0];
        String description = columns[1];
        String ausgabedatum = columns[2];
        Float price = Float.valueOf(columns[3]);
        String image = base64Converter.convertImgToBase64String(columns[4]);
        return new Product(product_name,description,ausgabedatum,price,image);
    }
}
