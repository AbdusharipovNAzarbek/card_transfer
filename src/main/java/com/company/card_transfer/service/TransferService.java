package com.company.card_transfer.service;

import com.company.card_transfer.entity.Card;
import com.company.card_transfer.entity.Income;
import com.company.card_transfer.entity.Outcome;
import com.company.card_transfer.payload.Response;
import com.company.card_transfer.payload.TransferDto;
import com.company.card_transfer.repository.CardRepository;
import com.company.card_transfer.repository.IncomeRepository;
import com.company.card_transfer.repository.OutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    OutcomeRepository outcomeRepository;

    @Autowired
    IncomeRepository incomeRepository;

    public Response createTransfer(TransferDto transferDto, String username) {
        Optional<Card> optionalFromCard = cardRepository.findCardByUsernameAndId(username, transferDto.getFrom_card_id());
        if (optionalFromCard.isEmpty()) {
            return new Response("Sizda Bunday karta mavjud emas", false);
        }
        Optional<Card> optionalToCard = cardRepository.findById(transferDto.getTo_card_id());
        if (optionalToCard.isEmpty()) {
            return new Response("Siz o'tkazmoqchi bo'lgan karta topilmadi", false);
        }
        if (optionalToCard.get().isActive()) {
            return new Response("Siz pul o'tkazmoqchi bo'lgan karta bloklangan", false);
        }

        if (optionalFromCard.get().isActive()) {
            return new Response("Sizning ushbu kartangiz bloklangan", false);
        }

        Card card = optionalFromCard.get();

        Double balance = card.getBalance();
        if (balance < (transferDto.getAmount() * 1.01)) {
            return new Response("Sizning hisobingizda o'tkazmani amalga oshirish uchun mablag' yetarli emas", false);
        }
        card.setBalance(balance - (transferDto.getAmount() * 1.01));
        cardRepository.save(card);
        Outcome outcome = new Outcome(optionalFromCard.get(), optionalToCard.get(), transferDto.getAmount(), transferDto.getAmount() * 1.01);
        outcomeRepository.save(outcome);
        Income income = new Income(optionalFromCard.get(), optionalToCard.get(), transferDto.getAmount());
        incomeRepository.save(income);
        return new Response("O'tkzama muvaffaqiyatli amalga oshirildi", true);
    }
}
