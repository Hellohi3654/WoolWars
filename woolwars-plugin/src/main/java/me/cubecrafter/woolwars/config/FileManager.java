package me.cubecrafter.woolwars.config;

import lombok.Getter;
import me.cubecrafter.woolwars.WoolWars;
import me.cubecrafter.woolwars.utils.TextUtil;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    private final WoolWars plugin;
    private final File configFile;
    private final File messagesFile;
    private final File powerUpsFile;
    @Getter private YamlConfiguration config;
    @Getter private YamlConfiguration messages;
    @Getter private YamlConfiguration powerUps;

    public FileManager(WoolWars plugin) {
        this.plugin = plugin;
        configFile = new File(plugin.getDataFolder(), "config.yml");
        messagesFile = new File(plugin.getDataFolder(), "messages.yml");
        powerUpsFile = new File(plugin.getDataFolder(), "powerups.yml");
        reload();
    }

    private void createFiles() {
        new File(plugin.getDataFolder(), "arenas").mkdirs();
        File kitsFolder = new File(plugin.getDataFolder(), "kits");
        if (kitsFolder.mkdirs()) {
            List<String> defaultKits = Arrays.asList("archer", "assault", "engineer", "golem", "swordsman", "tank");
            defaultKits.forEach(kit -> plugin.saveResource("kits/" + kit + ".yml", false));
        }
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
        if (!messagesFile.exists()) {
            plugin.saveResource("messages.yml", false);
        }
        if (!powerUpsFile.exists()) {
            plugin.saveResource("powerups.yml", false);
        }
    }

    public void save() {
        try {
            config.save(configFile);
            messages.save(messagesFile);
            powerUps.save(powerUpsFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void reload() {
        createFiles();
        config = YamlConfiguration.loadConfiguration(configFile);
        TextUtil.info("config.yml loaded!");
        messages = YamlConfiguration.loadConfiguration(messagesFile);
        TextUtil.info("messages.yml loaded!");
        powerUps = YamlConfiguration.loadConfiguration(powerUpsFile);
        TextUtil.info("powerups.yml loaded!");
    }

    public File[] getArenaFiles() {
        return new File(plugin.getDataFolder(), "arenas").listFiles((dir, name) -> name.endsWith(".yml"));
    }

    public File[] getKitFiles() {
        return new File(plugin.getDataFolder(), "kits").listFiles((dir, name) -> name.endsWith(".yml"));
    }

}