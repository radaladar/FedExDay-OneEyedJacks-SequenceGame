package com.sequencegame.oneeyedjacks.fedexday.greenfox.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rita on 2017-01-26.
 */
@Getter
@Setter
public class Team {
    private String color;
    private List<Player> players;
    private int sequence;

    public Team() {
        players = new ArrayList<>();
        sequence = 0;
    }

    public void addNewPlayer(Player player) {
        players.add(player);
    }
}
