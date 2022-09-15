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

package me.cubecrafter.woolwars.config;

import lombok.RequiredArgsConstructor;
import me.cubecrafter.woolwars.WoolWars;

import java.util.List;

@RequiredArgsConstructor
public enum Messages {

    PREFIX("prefix"),
    ARENA_NOT_FOUND("general.arena-not-found"),
    NO_ARENAS_AVAILABLE("general.no-arenas-available"),
    ALREADY_IN_ARENA("general.already-in-arena"),
    ALREADY_IN_SETUP_MODE("general.already-in-setup-mode"),
    GAME_ALREADY_STARTED("general.game-already-started"),
    ARENA_FULL("general.arena-full"),
    PLAYER_JOIN_ARENA("game.player-join"),
    PLAYER_LEAVE_ARENA("game.player-leave"),
    START_CANCELLED("game.start-cancelled"),
    UNKNOWN_COMMAND("general.unknown-command"),
    ONLY_PLAYER_COMMAND("general.only-player-command"),
    NO_PERMISSION("general.no-permission"),
    CANT_BREAK_BLOCK("game.cant-break-block"),
    CANT_PLACE_BLOCK("game.cant-place-block"),
    CENTER_LOCKED("game.center-locked"),
    COMMAND_BLOCKED("general.command-blocked"),
    CONFIG_RELOADED("general.config-reloaded"),
    PARTY_NOT_LEADER("party.not-leader"),
    PARTY_TOO_BIG("party.too-big"),
    PARTY_OFFLINE_MEMBERS("party.offline-members"),
    PARTY_MEMBERS_IN_ARENA("party.members-in-arena"),
    DEATH_TITLE("game.player-death.title"),
    DEATH_SUBTITLE("game.player-death.subtitle"),
    ALL_PLAYERS_DEAD("game.all-players-dead"),
    DEATH_BY_FALL("game.player-death.fall"),
    DEATH_BY_LAVA("game.player-death.lava"),
    DEATH_BY_VOID("game.player-death.void"),
    DEATH_GENERIC("game.player-death.generic"),
    KILL_MESSAGE("game.player-death.kill-message"),
    KIT_ALREADY_SELECTED("game.kits.kit-already-selected"),
    KIT_SELECTED("game.kits.kit-selected"),
    KIT_STATUS_SELECTED("game.kits.kit-status-selected"),
    KIT_STATUS_NOT_SELECTED("game.kits.kit-status-not-selected"),
    ABILITY_CANT_USE("game.kits.ability-cant-use"),
    ABILITY_ALREADY_USED("game.kits.ability-already-used"),
    ABILITY_USE("game.kits.ability-use"),
    TIME_LEFT_COUNTDOWN("game.round-time-left-countdown"),
    TEAM_WON_FORMAT("game.game-end.stats-message.team-winner-format"),
    TEAM_LOST_FORMAT("game.game-end.stats-message.team-loser-format"),
    NONE_FORMAT("game.game-end.stats-message.none-format"),
    END_GAME_STATS_FORMAT("game.game-end.stats-message.statistic-format"),
    END_GAME_MESSAGE("game.game-end.stats-message.message"),
    WINNER_TITLE("game.game-end.winner-team.title"),
    WINNER_SUBTITLE("game.game-end.winner-team.subtitle"),
    LOSER_TITLE("game.game-end.loser-team.title"),
    LOSER_SUBTITLE("game.game-end.loser-team.subtitle"),
    ROUND_WIN_TITLE("game.round-end.winner-team.title"),
    ROUND_WIN_SUBTITLE("game.round-end.winner-team.subtitle"),
    ROUND_LOSE_TITLE("game.round-end.loser-team.title"),
    ROUND_LOSE_SUBTITLE("game.round-end.loser-team.subtitle"),
    ROUND_DRAW_TITLE("game.round-end.draw.title"),
    ROUND_DRAW_SUBTITLE("game.round-end.draw.subtitle"),
    ROUND_START_COUNTDOWN_TITLE("game.round-start.countdown-title"),
    ROUND_START_COUNTDOWN_SUBTITLE("game.round-start.countdown-subtitle"),
    GAME_START_MESSAGE("game.start-message"),
    NO_STATS_ACHIEVED("game.round-end.stats-message.no-stats-achieved"),
    STATS_MESSAGE("game.round-end.stats-message.message"),
    STATS_KILLS("game.round-end.stats-message.kills-format"),
    STATS_PLACED_WOOL("game.round-end.stats-message.wool-placed-format"),
    STATS_BROKEN_BLOCKS("game.round-end.stats-message.blocks-broken-format"),
    PRE_ROUND_TITLE("game.pre-round.title"),
    PRE_ROUND_SUBTITLE("game.pre-round.subtitle"),
    ROUND_START_TITLE("game.round-start.title"),
    ROUND_START_SUBTITLE("game.round-start.subtitle"),
    SHIFT_TO_SELECT_KIT("game.kits.shift-to-select-kit"),
    GAME_START_COUNTDOWN("game.start-countdown"),
    GAME_STATE_WAITING("game.game-states.waiting"),
    GAME_STATE_STARTING("game.game-states.starting"),
    GAME_STATE_PRE_ROUND("game.game-states.pre-round"),
    GAME_STATE_ACTIVE_ROUND("game.game-states.active-round"),
    GAME_STATE_ROUND_OVER("game.game-states.round-over"),
    GAME_STATE_GAME_ENDED("game.game-states.game-ended"),
    SCOREBOARD_TEAM_FORMAT("scoreboard.team-format"),
    SCOREBOARD_TITLE("scoreboard.title"),
    SCOREBOARD_LOBBY("scoreboard.lobby"),
    SCOREBOARD_WAITING("scoreboard.waiting"),
    SCOREBOARD_STARTING("scoreboard.starting"),
    SCOREBOARD_PLAYING("scoreboard.playing");

    private final String path;

    public String getAsString() {
        return WoolWars.getInstance().getFileManager().getMessages().getString(path);
    }

    public List<String> getAsStringList() {
        return WoolWars.getInstance().getFileManager().getMessages().getStringList(path);
    }

}
