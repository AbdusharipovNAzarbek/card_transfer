package com.company.card_transfer.service;

import com.company.card_transfer.entity.Outcome;
import com.company.card_transfer.repository.OutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutcomeService {
    @Autowired
    OutcomeRepository outcomeRepository;


    public List<Outcome> getAll(int page, int size, String username) {
        Pageable pageable = PageRequest.of(page, size);
        return outcomeRepository.findAllByToCardUsername(username, pageable);
    }

    public Outcome getOne(Integer id, String username) {
        return outcomeRepository.findByIdAndToCardUsername(id, username).orElse(null);

    }
}