package org.pyacademy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;
import org.pyacademy.commands.*;
import org.pyacademy.events.DiedEvent;
import org.pyacademy.events.LobbyScoreBoard;
import org.pyacademy.events.Protection;
import org.pyacademy.notifications.EarningSystemAnnouncements;
import org.pyacademy.packages.EarningSystemCommand;
import org.pyacademy.packages.MySqlManagerCommand;
import org.pyacademy.settings.Settings;
import java.util.Arrays;
import java.util.List;

public final class HungerGames extends SimplePlugin {

    private EarningSystemAnnouncements earningSystemAnnouncements;

    @Override
    protected void onPluginStart() {

        Common.ADD_LOG_PREFIX = true;
        Common.ADD_TELL_PREFIX = true;

        int Members = Bukkit.getServer().getOnlinePlayers().size();

        Common.log("Hunger Games game mode has been enabled");
        Common.log("Tracking Online Players:" + " " + Members);


        //Commands has been registered below.
        registerCommand(new ClassesOPCommand());
        registerCommand(new UpgradesCommand());
        registerCommand(new ProfileCommand());
        registerCommand(new EarningSystemCommand());
        registerCommand(new ReloadCommand());
        registerCommand(new MySqlManagerCommand());
        registerCommand(new SlayerCommand());


        //Bukkit Runnables has been registered below.
        earningSystemAnnouncements = new EarningSystemAnnouncements();
        earningSystemAnnouncements.runTaskTimer(this,0,10*300);

        //Events has been registered below.
            Bukkit.getPluginManager().registerEvents(new LobbyScoreBoard(),this);
            Bukkit.getPluginManager().registerEvents(new DiedEvent(),this);
            Bukkit.getPluginManager().registerEvents(new Protection(),this);

    }


    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        for (Block b : e.blockList()) {
            final BlockState state = b.getState();

            b.setType(Material.AIR); // Stop item drops from spawning.

            int delay = 20;

            if ((b.getType() == Material.SAND) || (b.getType() == Material.GRAVEL)) {
                delay += 1;
            }

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    state.update(true, false);
                }
            }, delay);
        }
    }

    @Override
    public List<Class<? extends YamlStaticConfig>> getSettings() {
        return Arrays.asList(Settings.class);
    }
}
