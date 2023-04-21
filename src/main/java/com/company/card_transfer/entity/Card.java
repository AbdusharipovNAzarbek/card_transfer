package com.company.card_transfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String cardNumber;
    private Double balance;
    private Date expirationDate = new Date(System.currentTimeMillis() + 157_680_000_000L);
    private boolean active = true;

    public Card(String username, String cardNumber, Double balance) {
        this.username = username;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }
}
