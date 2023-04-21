package com.company.card_transfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Card fromCard;
    @OneToOne
    private Card toCard;
    private Double amount;
    private Double commisionAmount;
    private LocalDateTime date = LocalDateTime.now();

    public Outcome(Card fromCard, Card toCard, Double amount, Double commisionAmount) {
        this.fromCard = fromCard;
        this.toCard = toCard;
        this.amount = amount;
        this.commisionAmount = commisionAmount;
    }
}
