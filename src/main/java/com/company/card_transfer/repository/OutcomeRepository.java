package com.company.card_transfer.repository;

import com.company.card_transfer.entity.Income;
import com.company.card_transfer.entity.Outcome;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {

    List<Outcome> findAllByToCardUsername(String username, Pageable pageable);

    Optional<Outcome> findByIdAndToCardUsername(Integer id, String username);
}
