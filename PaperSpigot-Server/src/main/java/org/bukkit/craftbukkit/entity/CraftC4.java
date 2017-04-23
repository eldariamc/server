package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityC4;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.C4;
import org.bukkit.entity.EntityType;

/**
 * Created by David on 18/12/2016.
 */
public class CraftC4 extends CraftProjectile implements C4 {
	public CraftC4(CraftServer server, EntityC4 entity) {
		super(server, entity);
	}

	@Override
	public EntityC4 getHandle() {
		return (EntityC4) entity;
	}

	@Override
	public String toString() {
		return "CraftC4";
	}

	public EntityType getType() {
		return EntityType.C4;
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
