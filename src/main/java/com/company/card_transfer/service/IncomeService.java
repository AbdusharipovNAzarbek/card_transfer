package com.company.card_transfer.service;

import com.company.card_transfer.entity.Income;
import com.company.card_transfer.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    @Autowired
    IncomeRepository incomeRepository;


    public List<Income> getAll(int page, int size, String username) {
        Pageable pageable = PageRequest.of(page, size);
        return incomeRepository.findAllByFromCardUsername(username, pageable);
    }

    public Income getOne(Integer id, String username) {
        return incomeRepository.findByIdAndFromCardUsername(id, username).orElse(null);
    }
}
