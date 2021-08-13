package com.ahypixelnon.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GameListener implements Listener {

    @EventHandler
    public void onClutch(EntityDamageEvent e) {

        e.getEntity();

        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            if (Manager.isPlaying(player) && Manager.getArena(player).getState().equals(GameState.LIVE)) {
                player.sendMessage(ChatColor.GREEN + "Streak +1");

                Manager.getArena(player).getGame().addStreak(player);


            }
        }
    }
        @EventHandler
        public void onQuit(PlayerQuitEvent e) {

            Player player = e.getPlayer();

            if (Manager.isPlaying(player)) {
                Manager.getArena(player).removePlayer(player);
            }
        }
    }

