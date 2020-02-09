package org.pyacademy.events;


import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Protection implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.ADVENTURE);
    }

    @EventHandler
    public void HungerLvl(FoodLevelChangeEvent event) {
        event.setCancelled(true);

        if(event.getEntityType() == EntityType.PLAYER) {
            event.setFoodLevel(20);
        }
    }

    @EventHandler
    public void HealthLvl(EntityDamageEvent entityDamageEvent) {
        if(entityDamageEvent.getEntityType() == EntityType.PLAYER) {
            entityDamageEvent.setCancelled(true);
        }
    }
}
