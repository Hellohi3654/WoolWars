package me.cubecrafter.woolwars.game.arena;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ArenaState {

    WAITING("Waiting"),
    STARTING("Starting"),
    PLAYING("Playing"),
    RESTARTING("Restarting");

    @Getter private final String name;

}
