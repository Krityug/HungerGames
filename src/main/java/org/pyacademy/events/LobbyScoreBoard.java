package org.pyacademy.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleScoreboard;


public class LobbyScoreBoard implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        String name = Bukkit.getServer().getName();

        SimpleScoreboard scoreboard = new SimpleScoreboard();
        scoreboard.setTitle(Common.colorize("&E&LHUNGER GAMES"));
        scoreboard.addRows("");
        scoreboard.addRows("&FPlayer:" + ChatColor.YELLOW + " " + player.getDisplayName());
        scoreboard.addRows(ChatColor.DARK_GRAY + " " + name);
        scoreboard.addRows("");
        scoreboard.addRows("&FTotal Kills: &E5k");
        scoreboard.addRows("&FGames Played: &E3");
        scoreboard.addRows("");
        scoreboard.addRows("&FLast Joined: &7Today");
        scoreboard.addRows("&FYour Class: &EWarrior");
        scoreboard.addRows("");
        scoreboard.addRows("&BChest Found: &76,000");
        scoreboard.addRows("&6Coins Earned: &75K");
        scoreboard.addRows("");
        scoreboard.addRows("&Emc.hypexmc.net");
        scoreboard.show(player);
 }

    }
