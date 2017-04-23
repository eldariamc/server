package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityTomahawk;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Tomahawk;

/**
 * Created by David on 14/01/2017.
 */
public class CraftTomahawk extends CraftProjectile implements Tomahawk {

	public CraftTomahawk(CraftServer server, EntityTomahawk entity) {
		super(server, entity);
	}

	@Override
	public EntityTomahawk getHandle() {
		return (EntityTomahawk) entity;
	}

	@Override
	public String toString() {
		return "CraftTomahawk";
	}

	public EntityType getType() {
		return EntityType.TOMAHAWK;
	}
}
