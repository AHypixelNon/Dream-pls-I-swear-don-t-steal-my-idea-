package com.ahypixelnon.main;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private Arena arena;
    private int seconds;
    public Countdown(Arena arena) {
        this.arena = arena;
        this.seconds = Config.getCountDownSeconds();

    }

    public void begin() {
        arena.setState(GameState.COUNTDOWN);
        this.runTaskTimer(Main.getInstance(), 0, 20);
    }

    @Override
    public void run() {
        if (seconds == 0) {
            cancel();
            arena.start();
            return;
        }

        if (seconds % 5 == 0) {
            if (seconds == 1) {
                arena.sendMesssage(ChatColor.GREEN + "Dream MLG Practice will start in one second!");
            } else {
                arena.sendMesssage(ChatColor.GREEN + "Dream MLG Practice will start in " + seconds + " seconds!");

            }
        }

        if (arena.getPlayers().size() < Config.getRequiredPlayers()) {
            cancel();
            arena.setState(GameState.RECRUITING);
            arena.sendMesssage(ChatColor.RED + "Too few Speedrunners, Mlg Practice Stopped.");
            return;
        }

        seconds--;
    }

}
