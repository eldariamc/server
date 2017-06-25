//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

public class ItemGoldenApple extends ItemFood {
	public ItemGoldenApple(int var1, float var2, boolean var3) {
		super(var1, var2, var3);
		this.a(true);
	}

	public EnumItemRarity f(ItemStack var1) {
		return var1.getData() == 0?EnumItemRarity.RARE:EnumItemRarity.EPIC;
	}

	protected void c(ItemStack var1, World var2, EntityHuman var3) {
		if(!var2.isStatic) {
			int damage = var1.getData();
			var3.addEffect(new MobEffect(damage == 2 ? MobEffectList.HEALTH_BOOST.id : MobEffectList.ABSORPTION.id, 2400, damage == 2 ? 1 :0));

			if (damage > 0) {
				var3.addEffect(new MobEffect(MobEffectList.REGENERATION.id, damage == 2 ? 160 : 600, damage == 2 ? 1 : 4));
				if (damage != 2) {
					var3.addEffect(new MobEffect(MobEffectList.RESISTANCE.id, 6000, 0));
					var3.addEffect(new MobEffect(MobEffectList.FIRE_RESISTANCE.id, 6000, 0));
				}
			}
		}

		if(var1.getData() == 0) {
			super.c(var1, var2, var3);
		}

	}
}
