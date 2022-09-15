/*
 * Wool Wars
 * Copyright (C) 2022 CubeCrafter Development
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.cubecrafter.woolwars;

import lombok.Getter;
import me.cubecrafter.woolwars.arena.ArenaManager;
import me.cubecrafter.woolwars.commands.CommandManager;
import me.cubecrafter.woolwars.config.Configuration;
import me.cubecrafter.woolwars.config.FileManager;
import me.cubecrafter.woolwars.database.Database;
import me.cubecrafter.woolwars.database.PlayerDataManager;
import me.cubecrafter.woolwars.hooks.PlaceholderHook;
import me.cubecrafter.woolwars.kits.KitManager;
import me.cubecrafter.woolwars.listeners.ArenaListener;
import me.cubecrafter.woolwars.listeners.BlockListener;
import me.cubecrafter.woolwars.listeners.ChatListener;
import me.cubecrafter.woolwars.listeners.DamageListener;
import me.cubecrafter.woolwars.listeners.InteractListener;
import me.cubecrafter.woolwars.listeners.InventoryListener;
import me.cubecrafter.woolwars.listeners.JoinQuitListener;
import me.cubecrafter.woolwars.listeners.MoveListener;
import me.cubecrafter.woolwars.listeners.RewardsListener;
import me.cubecrafter.woolwars.listeners.ScoreboardHandler;
import me.cubecrafter.woolwars.party.provider.InternalProvider;
import me.cubecrafter.woolwars.party.provider.PAFProvider;
import me.cubecrafter.woolwars.party.provider.PartyProvider;
import me.cubecrafter.woolwars.powerup.PowerUpManager;
import me.cubecrafter.woolwars.utils.TextUtil;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public final class WoolWars extends JavaPlugin {

    @Getter
    private static WoolWars instance;
    private ArenaManager arenaManager;
    private FileManager fileManager;
    private CommandManager commandManager;
    private Database storage;
    private KitManager kitManager;
    private ScoreboardHandler scoreboardHandler;
    private PlayerDataManager playerDataManager;
    private PowerUpManager powerupManager;
    private PartyProvider partyProvider;

    @Override
    public void onEnable() {
        instance = this;
        TextUtil.info(" __      __        _  __      __           ");
        TextUtil.info(" \\ \\    / /__  ___| | \\ \\    / /_ _ _ _ ___");
        TextUtil.info("  \\ \\/\\/ / _ \\/ _ \\ |  \\ \\/\\/ / _` | '_(_-<");
        TextUtil.info("   \\_/\\_/\\___/\\___/_|   \\_/\\_/\\__,_|_| /__/");
        TextUtil.info("");
        TextUtil.info("Author: CubeCrafter");
        TextUtil.info("Version: " + getDescription().getVersion());
        TextUtil.info("Running on: " + getServer().getVersion());
        TextUtil.info("Java Version: " + System.getProperty("java.version"));
        fileManager = new FileManager(this);
        storage = new Database();
        arenaManager = new ArenaManager(this);
        commandManager = new CommandManager(this);
        scoreboardHandler = new ScoreboardHandler();
        powerupManager = new PowerUpManager();
        kitManager = new KitManager(this);
        playerDataManager = new PlayerDataManager(this);
        kitManager.load();
        playerDataManager.load();
        Arrays.asList(new InventoryListener(), new ArenaListener(), new BlockListener(), new JoinQuitListener(this),
                        new ChatListener(), new InteractListener(), new MoveListener(), new DamageListener())
                .forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
        if (Configuration.REWARD_COMMANDS_ENABLED.getAsBoolean()) {
            getServer().getPluginManager().registerEvents(new RewardsListener(), this);
        }
        registerHooks();
        new Metrics(this, 14788);
    }

    @Override
    public void onDisable() {
        playerDataManager.save();
        storage.close();
        arenaManager.disableArenas();
        scoreboardHandler.disable();
        getServer().getScheduler().cancelTasks(this);
    }

    private void registerHooks() {
        if (isPAPIEnabled()) {
            new PlaceholderHook().register();
            TextUtil.info("Hooked into PlaceholderAPI!");
        }
        if (getServer().getPluginManager().isPluginEnabled("Spigot-Party-API-PAF")) {
            partyProvider = new PAFProvider();
            TextUtil.info("Hooked into Party And Friends!");
        } else {
            partyProvider = new InternalProvider();
        }
    }

    public boolean isPAPIEnabled() {
        return getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");
    }

}
