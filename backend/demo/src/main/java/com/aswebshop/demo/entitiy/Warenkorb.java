package com.aswebshop.demo.entitiy;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Warenkorb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int user_id;
    private int product_id;
    private int quantity;

    public Warenkorb(int user_id, int product_id, int quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Warenkorb() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warenkorb warenkorb = (Warenkorb) o;
        return id == warenkorb.id && user_id == warenkorb.user_id && product_id == warenkorb.product_id && quantity == warenkorb.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, product_id, quantity);
    }

    @Override
    public String toString() {
        return "Warenkorb{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}
