package com.company.card_transfer.controller;

import com.company.card_transfer.payload.Response;
import com.company.card_transfer.payload.TransferDto;
import com.company.card_transfer.security.JwtFilter;
import com.company.card_transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    @Autowired
    TransferService transferService;
    String username = JwtFilter.username;

    @PostMapping
    public ResponseEntity<Response> createTransfer(@Valid @RequestBody TransferDto transferDto) {
        Response response = transferService.createTransfer(transferDto, username);
        return ResponseEntity.status(response.isStatus() ? 202 : 409).body(response);
    }
}
