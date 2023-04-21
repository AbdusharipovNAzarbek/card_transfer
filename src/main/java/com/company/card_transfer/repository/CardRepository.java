package com.company.card_transfer.repository;

import com.company.card_transfer.entity.Card;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Integer> {
    List<Card> findAllCardByUsername(String username);
    Optional<Card> findCardByUsernameAndId(String username, Integer id);
    boolean existsByCardNumber(String cardNumber);
}
