package gg.jps.battleroyale.player;

public class GamePlayer {

    private final Level level;

    public GamePlayer(Level level) {
        this.level = level;
    }

    public void levelUp() {
        level.levelUp();
    }
}
