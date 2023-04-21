package com.company.card_transfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Card fromCard;
    @OneToOne
    private Card toCard;
    private Double amount;
    private LocalDateTime date = LocalDateTime.now();

    public Income(Card fromCard, Card toCard, Double amount) {
        this.fromCard = fromCard;
        this.toCard = toCard;
        this.amount = amount;
    }
}
