package me.cubecrafter.woolwars.config;

import lombok.RequiredArgsConstructor;
import me.cubecrafter.woolwars.WoolWars;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;

@RequiredArgsConstructor
public enum Menus {

    // ARENAS MENU

    ARENAS_MENU_TITLE("arenas-menu.title"),
    ARENAS_MENU_ROWS("arenas-menu.rows"),
    ARENAS_MENU_FILLER("arenas-menu.filler"),
    ARENAS_MENU_FILLER_ENABLED("arenas-menu.filler.enabled"),
    ARENAS_MENU_FILLER_SLOTS("arenas-menu.filler.slots"),
    ARENAS_MENU_ARENA_ITEM("arenas-menu.items.arena-item"),
    ARENAS_MENU_ARENA_ITEM_SLOTS("arenas-menu.items.arena-item.slots"),
    ARENAS_MENU_ARENA_ITEM_DISPLAYNAME("arenas-menu.items.arena-item.displayname"),
    ARENAS_MENU_ARENA_ITEM_LORE("arenas-menu.items.arena-item.lore"),
    ARENAS_MENU_CLOSE_ITEM("arenas-menu.items.close-item"),
    ARENAS_MENU_CLOSE_ITEM_SLOT("arenas-menu.items.close-item.slot"),

    // STATS MENU

    STATS_MENU_TITLE("stats-menu.title"),
    STATS_MENU_ROWS("stats-menu.rows"),
    STATS_MENU_FILLER("stats-menu.filler"),
    STATS_MENU_FILLER_ENABLED("stats-menu.filler.enabled"),
    STATS_MENU_FILLER_SLOTS("stats-menu.filler.slots"),
    STATS_MENU_WINS_ITEM("stats-menu.items.wins-item"),
    STATS_MENU_WINS_ITEM_SLOT("stats-menu.items.wins-item.slot"),
    STATS_MENU_LOSSES_ITEM("stats-menu.items.losses-item"),
    STATS_MENU_LOSSES_ITEM_SLOT("stats-menu.items.losses-item.slot"),
    STATS_MENU_GAMES_PLAYED_ITEM("stats-menu.items.games-played-item"),
    STATS_MENU_GAMES_PLAYED_ITEM_SLOT("stats-menu.items.games-played-item.slot"),
    STATS_MENU_KILLS_ITEM("stats-menu.items.kills-item"),
    STATS_MENU_KILLS_ITEM_SLOT("stats-menu.items.kills-item.slot"),
    STATS_MENU_DEATHS_ITEM("stats-menu.items.deaths-item"),
    STATS_MENU_DEATHS_ITEM_SLOT("stats-menu.items.deaths-item.slot"),
    STATS_MENU_PLACED_WOOL_ITEM("stats-menu.items.placed-wool-item"),
    STATS_MENU_PLACED_WOOL_ITEM_SLOT("stats-menu.items.placed-wool-item.slot"),
    STATS_MENU_BROKEN_BLOCKS_ITEM("stats-menu.items.broken-blocks-item"),
    STATS_MENU_BROKEN_BLOCKS_ITEM_SLOT("stats-menu.items.broken-blocks-item.slot"),
    STATS_MENU_POWERUPS_COLLECTED_ITEM("stats-menu.items.powerups-collected-item"),
    STATS_MENU_POWERUPS_COLLECTED_ITEM_SLOT("stats-menu.items.powerups-collected-item.slot"),
    STATS_MENU_CLOSE_ITEM("stats-menu.items.close-item"),
    STATS_MENU_CLOSE_ITEM_SLOT("stats-menu.items.close-item.slot"),

    // KITS MENU

    ;

    private final String path;

    public String getAsString() {
        return WoolWars.getInstance().getFileManager().getMenus().getString(path);
    }

    public int getAsInt() {
        return WoolWars.getInstance().getFileManager().getMenus().getInt(path);
    }

    public double getAsDouble() {
        return WoolWars.getInstance().getFileManager().getMenus().getDouble(path);
    }

    public List<Integer> getAsIntegerList() {
        return WoolWars.getInstance().getFileManager().getMenus().getIntegerList(path);
    }

    public boolean getAsBoolean() {
        return WoolWars.getInstance().getFileManager().getMenus().getBoolean(path);
    }

    public ConfigurationSection getAsConfigSection() {
        return WoolWars.getInstance().getFileManager().getMenus().getConfigurationSection(path);
    }

    public List<String> getAsStringList() {
        return WoolWars.getInstance().getFileManager().getMenus().getStringList(path);
    }

}
