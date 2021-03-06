package com.llighter.demo;

import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;


    public BankTransaction(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }


    public LocalDate getDate() {
        return this.date;
    }


    public double getAmount() {
        return this.amount;
    }


    public String getDescription() {
        return this.description;
    }


    @Override
    public String toString() {
        return "BankTransaction {" +
            " date='" + getDate() + "'" +
            ", amount='" + getAmount() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankTransaction that = (BankTransaction) o;
        return Objects.equals(date, that.date) && amount == that.amount && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }


    
}
