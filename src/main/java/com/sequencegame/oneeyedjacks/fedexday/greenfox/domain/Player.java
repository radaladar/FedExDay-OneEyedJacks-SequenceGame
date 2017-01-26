/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player {
    @Id
    private int id;
    private String name;
    private List<Card> hand;

    public void addNewCardToHand(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        Card cardPlayed = hand.get(index);
        hand.remove(cardPlayed);
        return cardPlayed;
    }

    public int getNumberOfCardsInHand() {
        return hand.size();
    }
}
