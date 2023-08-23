package gg.jps.battleroyale.kit;

import gg.jps.battleroyale.util.FileUtil;
import gg.jps.battleroyale.util.JsonUtil;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KitManager {

    private final File folder = FileUtil.getFolderFromPath("kit");

    private final Map<String, Kit> kits = new HashMap<>();

    public KitManager() {
        load();
    }

    public void selectKit(Player player) {
        findKitById("test").ifPresent(kit -> kit.select(player));
    }

    private Optional<Kit> findKitById(String name) {
        return Optional.ofNullable(kits.get(name));
    }

    private void load() {
        JsonUtil.loadFromJsonFileAll(folder, Kit.class).forEach(kit -> kits.put(kit.getId(), kit));
    }

    public void reload() {
        kits.clear();
        load();
    }

    public void save() {
        kits.values().forEach(kit -> JsonUtil.saveJsonFile(folder, kit.getId(), kit));
    }
}
