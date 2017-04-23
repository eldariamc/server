package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityDynamite;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Dynamite;
import org.bukkit.entity.EntityType;

/**
 * Created by David on 18/12/2016.
 */
public class CraftDynamite extends CraftProjectile implements Dynamite {

	public CraftDynamite(CraftServer server, EntityDynamite entity) {
		super(server, entity);
	}

	@Override
	public EntityDynamite getHandle() {
		return (EntityDynamite) entity;
	}

	@Override
	public String toString() {
		return "CraftDynamite";
	}

	public EntityType getType() {
		return EntityType.DYNAMITE;
	}

	@Override
	public void setYield(float yield) {

	}

	@Override
	public float getYield() {
		return 0;
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {

	}

	@Override
	public boolean isIncendiary() {
		return false;
	}
}
