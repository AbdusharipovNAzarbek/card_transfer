package com.company.card_transfer.payload;

import lombok.Data;

@Data

public class TransferDto {
    private Integer from_card_id;
    private Integer to_card_id;
    private Double amount;

}
