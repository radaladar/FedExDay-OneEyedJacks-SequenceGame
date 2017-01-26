package com.sequencegame.oneeyedjacks.fedexday.greenfox.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Rita on 2017-01-26.
 */
@Setter
@Getter
public class BoardCard extends Card {
    private Boolean hasChip;
    private String chipColor;

    public BoardCard(String typeGivenBySpecialCharacterAndNumber) {
        super(typeGivenBySpecialCharacterAndNumber);
    }
}
