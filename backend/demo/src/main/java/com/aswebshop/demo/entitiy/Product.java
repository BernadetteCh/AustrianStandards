package com.aswebshop.demo.entitiy;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String  product_name;
    private String description;
    private String ausgabedatum;
    private float price;
    @Column(length = 1000000)
    private String image;


    public Product(String product_name, String description, String weight, float price, String image) {
        this.product_name = product_name;
        this.description = description;
        this.ausgabedatum = weight;
        this.price = price;
        this.image = image;
    }

    public Product(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAusgabedatum() {
        return ausgabedatum;
    }

    public void setAusgabedatum(String ausgabedatum) {
        this.ausgabedatum = ausgabedatum;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Float.compare(product.price, price) == 0  && Objects.equals(product_name, product.product_name) && Objects.equals(description, product.description) && Objects.equals(ausgabedatum, product.ausgabedatum) && Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product_name, description, ausgabedatum, price, image);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", ausgabedatum='" + ausgabedatum + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}

