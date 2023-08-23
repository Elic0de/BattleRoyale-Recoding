package gg.jps.battleroyale.config;

import gg.jps.battleroyale.BattleRoyale;
import gg.jps.battleroyale.util.JsonUtil;

import java.io.File;
import java.util.Optional;

public class ConfigManager {

    private final File folder = BattleRoyale.getInstance().getDataFolder();

    private Settings settings;

    public ConfigManager() {
        load();
    }

    private void load() {
        JsonUtil.loadFromJsonFile(folder, "settings", Settings.class).ifPresentOrElse(
                config -> settings = config,
                () -> {
                    JsonUtil.saveJsonFile(folder, "settings", new Settings());
                    load();
                }
        );
    }

    public void reload() {
        load();
    }

    public Optional<Settings> getSettings() {
        return Optional.ofNullable(settings);
    }
}
