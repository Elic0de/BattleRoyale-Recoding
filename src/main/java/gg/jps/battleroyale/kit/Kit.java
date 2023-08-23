package gg.jps.battleroyale.kit;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.math.BigDecimal;

@Getter
public class Kit {

    private final String id;

    private final String name;

    private final String description;

    private final Material icon;

    private final ItemStack[] contents;

    private final BigDecimal coins;

    private final BigDecimal requiredJP;

    private final int requiredLevel;

    public Kit(String id, String name, String description, Material icon, ItemStack[] contents, BigDecimal coins, BigDecimal requiredJP, int requiredLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.contents = contents;
        this.coins = coins;
        this.requiredJP = requiredJP;
        this.requiredLevel = requiredLevel;
    }

    public void select(Player player) {
        player.getInventory().setContents(contents);
        player.getInventory().addItem(new ItemStack(Material.YELLOW_DYE));
    }
}
