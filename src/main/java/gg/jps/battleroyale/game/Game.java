package gg.jps.battleroyale.game;

import gg.jps.battleroyale.player.GamePlayer;
import lombok.Getter;

@Getter
public class Game {

    private final String id;

    public Game(String id) {

        this.id = id;
    }

    public void join(GamePlayer player) {
    }

    public void leave(GamePlayer player) {
    }

    public void start() {

    }

    public void won() {

    }

    public void end() {

    }

    public void reset() {

    }

}
