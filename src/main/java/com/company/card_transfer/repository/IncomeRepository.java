package com.company.card_transfer.repository;

import com.company.card_transfer.entity.Card;
import com.company.card_transfer.entity.Income;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IncomeRepository extends JpaRepository <Income,Integer>{
    List<Income> findAllByFromCardUsername(String fromCard_username, Pageable pageable);
    Optional<Income> findByIdAndFromCardUsername(Integer id, String fromCard_username);
}
