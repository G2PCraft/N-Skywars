package com.nekota.mc.skywars.Map;

import org.bukkit.Location;

public class Region {
	private Location l1;
	private Location l2;
	public Region(Location l1, Location l2) {
		int x1, x2, y1, y2, z1, z2;
		if (l1.getBlockX() >= l2.getBlockX()) {
			x1 = l2.getBlockX();
			x2 = l1.getBlockX();
		} else {
			x1 = l1.getBlockX();
			x2 = l2.getBlockX();
		}
		if (l1.getBlockY() >= l2.getBlockY()) {
			y1 = l2.getBlockY();
			y2 = l1.getBlockY();
		} else {
			y1 = l1.getBlockY();
			y2 = l2.getBlockY();
		}
		if (l1.getBlockZ() >= l2.getBlockZ()) {
			z1 = l2.getBlockZ();
			z2 = l1.getBlockZ();
		} else {
			z1 = l1.getBlockZ();
			z2 = l2.getBlockZ();
		}
		this.l1 = new Location(l1.getWorld(), x1, y1, z1);
		this.l2 = new Location(l2.getWorld(), x2, y2, z2);
	}
	
	public String toString() {
		return "Region{" + l1.toString() + "," + l2.toString() + "}";
	}
	
	public Location getLocation1() {
		return this.l1;
	}
	
	public Location getLocation2() {
		return this.l2;
	}
	
	public boolean isInRegion(Location loc) {
		if (loc.getBlockX() >= l1.getBlockX() && loc.getBlockX() <= l2.getBlockX()) {
			if (loc.getBlockY() >= l1.getBlockY() && loc.getBlockY() <= l2.getBlockY()) {
				if (loc.getBlockZ() >= l1.getBlockZ() && loc.getBlockZ() <= l2.getBlockZ()) {
					return true;
				}
			}
		}
		return false;
	}
}
