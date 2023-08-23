package gg.jps.battleroyale;

import gg.jps.battleroyale.chest.ChestManager;
import gg.jps.battleroyale.config.ConfigManager;
import gg.jps.battleroyale.game.GameManager;
import gg.jps.battleroyale.kit.KitManager;
import gg.jps.battleroyale.level.LevelManager;
import gg.jps.battleroyale.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BattleRoyale extends JavaPlugin {

    private static BattleRoyale instance;

    private ChestManager chestManager;
    private ConfigManager configManager;
    private GameManager gameManager;
    private KitManager kitManager;
    private LevelManager levelManager;
    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        registerManagers();

        Bukkit.getOnlinePlayers().forEach(player -> {
            configManager.getSettings().ifPresent(settings -> player.sendMessage(settings.getMinPlayer() + ""));
            kitManager.selectKit(player);
        });
    }

    private void registerManagers() {
        configManager = new ConfigManager();
        gameManager = new GameManager();
        kitManager = new KitManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void reload() {
        configManager.reload();
        gameManager.reload();
        kitManager.reload();
    }

    public static BattleRoyale getInstance() {
        return instance;
    }
}
