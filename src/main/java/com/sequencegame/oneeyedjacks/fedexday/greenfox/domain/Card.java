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
    private String value;
    private Boolean hasChip;
    private String chipColor;

    public Card(int id, String suit, String name, String value) {
        this.id = id;
        this.suit = suit;
        this.name = name;
        this.value = value;
    }
}