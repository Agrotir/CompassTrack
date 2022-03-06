package me.cheezelzz.compasstrack;

import java.util.Objects;

import org.bukkit.World.Environment;

public class PlayerMapKey {

    String playerName;
    Environment environment;

    public PlayerMapKey(String playerName, Environment environment) {
        this.playerName = playerName;
        this.environment = environment;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        PlayerMapKey p = (PlayerMapKey) ob;

        return Objects.equals(playerName, p.getPlayerName()) && environment.equals(p.getEnvironment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, environment);
    }

}
