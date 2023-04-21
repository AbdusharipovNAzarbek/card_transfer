package com.company.card_transfer.payload;

import lombok.Data;

import java.util.Date;

@Data
public class CardDto {
  private String cardNumber;
  private Double balance;
  private Date date;

}
