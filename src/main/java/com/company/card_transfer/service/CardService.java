package com.company.card_transfer.service;

import com.company.card_transfer.entity.Card;
import com.company.card_transfer.payload.CardDto;
import com.company.card_transfer.payload.Response;
import com.company.card_transfer.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    String username;

    public List<Card> getAll(String username) {


        return cardRepository.findAllCardByUsername(username);
    }

    public Card getOne(Integer id, String username) {
        return cardRepository.findCardByUsernameAndId(username, id).orElse(null);
    }

    public Response addCard(CardDto cardDto, String username) {
        if (cardRepository.existsByCardNumber(cardDto.getCardNumber())) {
            return new Response("BUnday karta avval qo'shilgan", false);
        }
        Card card = new Card(username, cardDto.getCardNumber(), cardDto.getBalance());
        cardRepository.save(card);
        return new Response("Karta muvaffaqiyatliu oqshildi", true);
    }

    public Response delete(Integer id) {
        try {
            cardRepository.deleteById(id);
            return new Response("Karta o'chirildi", true);
        } catch (Exception e1) {
            return new Response("Krta ochirilmadi", false);
        }
    }
}
