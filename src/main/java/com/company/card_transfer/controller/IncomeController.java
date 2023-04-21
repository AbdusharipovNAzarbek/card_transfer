package com.company.card_transfer.controller;

import com.company.card_transfer.entity.Income;
import com.company.card_transfer.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.company.card_transfer.security.JwtFilter.username;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @GetMapping
    public ResponseEntity<List<Income>> getAll(@RequestParam int page, @RequestParam int size) {
        List<Income> incomes = incomeService.getAll(page, size, username);
        return ResponseEntity.ok(incomes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getAll(@PathVariable Integer id) {
        Income income = incomeService.getOne(id, username);
        return ResponseEntity.status(income != null ? 200 : 404).body(income);
    }

}
