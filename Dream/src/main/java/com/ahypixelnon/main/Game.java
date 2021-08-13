package com.ahypixelnon.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> streak;

    public Game(Arena arena) {
        this.arena = arena;
        this.streak = new HashMap<>();
    }

    public void start() {
        arena.setState(GameState.LIVE);

        arena.sendMesssage(ChatColor.GREEN + "Dream Mlg Practice has started, avoid falldamage!");

        for (UUID uuid : arena.getPlayers()) {
            streak.put(uuid, 0);

        }
    }

    public void addStreak(Player player) {
        int s = streak.get(player.getUniqueId()) + 1;

        if (s == 10) {
            arena.sendMesssage(ChatColor.GREEN + " OH GEORGE!!!");

            arena.reset();
            return;
        }

        streak.put(player.getUniqueId(), s);
    }

}

