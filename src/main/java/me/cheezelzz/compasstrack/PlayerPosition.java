package me.cheezelzz.compasstrack;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerPosition {

    Double x;
    Double y;
    Double z;

    public PlayerPosition(Player p) {
        this.x = p.getLocation().getX();
        this.y = p.getLocation().getY();
        this.z = p.getLocation().getZ();
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public void setLocation(Location l) {
        setX(l.getX());
        setY(l.getY());
        setZ(l.getZ());
    }

    public Location getLocation(Player p) {
        return new Location(p.getWorld(), x, y, z);
    }

}
