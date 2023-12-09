package com.reactive.homebanking.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("AccountQueue")
public class Account
{
    private String id;
    private BigDecimal totalBalance;
    private String cliente;

    public Account(){}

    public Account(BigDecimal totalBalance, String cliente) {
        this.totalBalance = totalBalance;
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "M_CuentaMongo{" +
                "id='" + id + '\'' +
                ", totalBalance=" + totalBalance +
                ", cliente=" + cliente +
                '}';
    }
}
