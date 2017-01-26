/// Created by BB on 2017-01-26.
package com.sequencegame.oneeyedjacks.fedexday.greenfox.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Card {
    private int id;
    private String suit;
    private String name;

    public Card(String suit, String name) {
        this.suit = suit;
        this.name = name;
    }

    public Card(String typeGivenBySpecialCharacterAndNumber) {
        if (typeGivenBySpecialCharacterAndNumber.equals("WC")) {
            suit = "none";
            name = "wildCard";
        } else {
            suit = String.valueOf(typeGivenBySpecialCharacterAndNumber.charAt(0));
            name = String.valueOf(typeGivenBySpecialCharacterAndNumber.charAt(1));
        }
    }

    @Override
    public boolean equals(Object obj) {
        Card cardTocompare = (Card) obj;
        return this.suit == cardTocompare.suit && this.name == cardTocompare.name;
    }

    @Override
    public String toString() {
        return suit + name;
    }
}
