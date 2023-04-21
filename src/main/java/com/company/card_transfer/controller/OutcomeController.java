package com.company.card_transfer.controller;

import com.company.card_transfer.entity.Outcome;
import com.company.card_transfer.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.company.card_transfer.security.JwtFilter.username;

@RestController
@RequestMapping("/api/outcome")
public class OutcomeController {
    @Autowired
    OutcomeService outcomeService;

    @GetMapping
    public ResponseEntity<List<Outcome>> getAll(@RequestParam int page, @RequestParam int size) {
        List<Outcome> incomes = outcomeService.getAll(page, size, username);
        return ResponseEntity.ok(incomes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Outcome> getAll(@PathVariable Integer id) {
        Outcome income = outcomeService.getOne(id, username);
        return ResponseEntity.status(income != null ? 200 : 404).body(income);
    }

}
