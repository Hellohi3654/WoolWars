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

package me.cubecrafter.woolwars.party.provider;

import de.simonsator.partyandfriends.spigot.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.spigot.api.pafplayers.PAFPlayerManager;
import de.simonsator.partyandfriends.spigot.api.party.PartyManager;
import de.simonsator.partyandfriends.spigot.api.party.PlayerParty;
import me.cubecrafter.woolwars.party.Party;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PAFProvider implements PartyProvider {

    @Override
    public Party getParty(Player player) {
        PAFPlayer pafPlayer = PAFPlayerManager.getInstance().getPlayer(player.getUniqueId());
        PlayerParty pafParty = PartyManager.getInstance().getParty(pafPlayer);
        if (pafParty == null) return null;
        Party party = new Party(Bukkit.getPlayer(pafParty.getLeader().getUniqueId()));
        for (PAFPlayer pafMember : pafParty.getPlayers()) {
            party.addMember(pafMember.getUniqueId());
        }
        return party;
    }

    @Override
    public Party createParty(Player leader) {
        return null;
    }

    @Override
    public boolean hasParty(Player player) {
        return getParty(player) != null;
    }

    @Override
    public void disbandParty(Party party) {}

}

