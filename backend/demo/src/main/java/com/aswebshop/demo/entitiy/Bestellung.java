package com.aswebshop.demo.entitiy;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Bestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int user_id;
    private double total_amount;
    private BestellStatus bestellStatus;

    public Bestellung(int user_id, double total_amount, BestellStatus bestellStatus) {
        this.user_id = user_id;
        this.total_amount = total_amount;
        this.bestellStatus = bestellStatus;
    }

    public Bestellung(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public BestellStatus getBestellStatus() {
        return bestellStatus;
    }

    public void setBestellStatus(BestellStatus bestellStatus) {
        this.bestellStatus = bestellStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bestellung that = (Bestellung) o;
        return id == that.id && user_id == that.user_id && Double.compare(that.total_amount, total_amount) == 0 && bestellStatus == that.bestellStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, total_amount, bestellStatus);
    }

}
