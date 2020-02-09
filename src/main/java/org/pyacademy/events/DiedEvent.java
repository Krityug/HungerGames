package org.pyacademy.events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.remain.Remain;


public class DiedEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        Remain.sendActionBar(player,Common.colorize("&BEarned &A64+XP Points"));
    }
}
