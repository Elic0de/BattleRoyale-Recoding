package gg.jps.battleroyale.game;

import gg.jps.battleroyale.util.FileUtil;
import gg.jps.battleroyale.util.JsonUtil;

import java.io.File;
import java.util.HashMap;

public class GameManager {

    private final File folder = FileUtil.getFolderFromPath("games");

    private final HashMap<String, Game> games = new HashMap<>();

    private void load() {
        JsonUtil.loadFromJsonFileAll(folder, Game.class).forEach(game -> games.put(game.getId(), game));
    }

    public void reload() {
        games.clear();
        load();
    }

    public void join() {

    }

    public void leave() {

    }

    public void nextArena() {

    }

}