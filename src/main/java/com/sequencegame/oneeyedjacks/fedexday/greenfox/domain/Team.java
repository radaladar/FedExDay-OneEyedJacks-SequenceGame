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
    private int colorCode;
    private List<Player> players;
    private int sequence;
    private int currentlyActivePlayer;

    public Team() {
        players = new ArrayList<>();
        sequence = 0;
        currentlyActivePlayer = 0;
    }

    public void addNewPlayer(Player player) {
        players.add(player);
    }

    public Player getActivePlayer() {
        Player activePlayer = players.get(currentlyActivePlayer);
        if (currentlyActivePlayer < players.size() - 1) {
            currentlyActivePlayer++;
        } else {
            currentlyActivePlayer = 0;
        }
        return activePlayer;
    }
}
