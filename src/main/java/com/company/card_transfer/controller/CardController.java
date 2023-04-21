package com.company.card_transfer.controller;

import com.company.card_transfer.entity.Card;
import com.company.card_transfer.payload.CardDto;
import com.company.card_transfer.payload.Response;
import com.company.card_transfer.security.JwtFilter;
import com.company.card_transfer.security.JwtProvider;
import com.company.card_transfer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;
    String username = JwtFilter.username;


    @GetMapping
    public ResponseEntity<List<Card>> getAll() {
        List<Card> cardList = cardService.getAll(username);
        return ResponseEntity.ok(cardList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getOne(@PathVariable Integer id) {
        Card card = cardService.getOne(id, username);
        return ResponseEntity.status(card != null ? 200 : 404).body(card);
    }

    @PostMapping
    public ResponseEntity<Response> addCard(@RequestBody CardDto cardDto) {
        Response response = cardService.addCard(cardDto, username);
        return ResponseEntity.status(response.isStatus() ? 201 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        Response response = cardService.delete(id);
        return ResponseEntity.status(response.isStatus() ? 204 : 409).body(response);
    }
}
