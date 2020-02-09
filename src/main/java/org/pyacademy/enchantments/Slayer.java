package org.pyacademy.enchantments;


import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleEnchantment;

public class Slayer extends SimpleEnchantment {

    @Getter
    private static final Enchantment instance = new Slayer();


    protected Slayer() {
        super("Slayer",6);
    }

    @Override
    protected void onBreakBlock(int level, BlockBreakEvent event) {

        Block block = event.getBlock();
        Player player = event.getPlayer();

        Common.tell(player,"&7You just broke" + " " + ChatColor.YELLOW + " " + block);

    }
}
