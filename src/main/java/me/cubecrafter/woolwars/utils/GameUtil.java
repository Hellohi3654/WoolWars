package me.cubecrafter.woolwars.utils;

import lombok.experimental.UtilityClass;
import me.cubecrafter.woolwars.WoolWars;
import me.cubecrafter.woolwars.arena.Arena;
import me.cubecrafter.woolwars.arena.GameState;
import me.cubecrafter.woolwars.kits.Kit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@UtilityClass
public class GameUtil {

    public Arena getArenaByPlayer(Player player) {
        return GameUtil.getArenas().stream().filter(arena -> arena.getPlayers().contains(player) || arena.getSpectators().contains(player)).findAny().orElse(null);
    }

    public Arena getArenaByName(String name) {
        return WoolWars.getInstance().getGameManager().getArena(name);
    }

    public Kit getKit(String id) {
        return WoolWars.getInstance().getKitManager().getKit(id);
    }

    public boolean isSpectating(Player player) {
        return GameUtil.getArenas().stream().anyMatch(arena -> arena.getSpectators().contains(player));
    }

    public boolean isPlaying(Player player) {
        return GameUtil.getArenas().stream().anyMatch(arena -> arena.getPlayers().contains(player));
    }

    public List<Arena> getArenas() {
        return new ArrayList<>(WoolWars.getInstance().getGameManager().getArenas().values());
    }

    public List<Kit> getKits() {
        return new ArrayList<>(WoolWars.getInstance().getKitManager().getKits().values());
    }

    public void joinRandom(Player player) {
        List<Arena> available = GameUtil.getArenas().stream().filter(arena -> arena.getGameState().equals(GameState.WAITING) || arena.getGameState().equals(GameState.STARTING)).collect(Collectors.toList());
        Arena random = available.stream().max(Comparator.comparing(arena -> arena.getPlayers().size()))
                .orElse(available.get(new Random().nextInt(available.size())));
        random.addPlayer(player);
    }

}
