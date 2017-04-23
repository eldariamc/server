//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombatTracker {
	private final List a = new ArrayList();
	private final EntityLiving b;
	private int c;
	private int d;
	private int e;
	private boolean f;
	private boolean g;
	private String h;

	public CombatTracker(EntityLiving var1) {
		this.b = var1;
	}

	public void a() {
		this.j();
		if(this.b.h_().canClimb) {
			Block var1 = this.b.world.getType(MathHelper.floor(this.b.locX), MathHelper.floor(this.b.boundingBox.b), MathHelper.floor(this.b.locZ));
			if(var1 instanceof BlockLadder) {
				this.h = "ladder";
			} else if(var1 == Blocks.VINE) {
				this.h = "vines";
			}
		} else if(this.b.M()) {
			this.h = "water";
		}

	}

	public void a(DamageSource var1, float var2, float var3) {
		this.g();
		this.a();
		CombatEntry var4 = new CombatEntry(var1, this.b.ticksLived, var2, var3, this.h, this.b.fallDistance);
		this.a.add(var4);
		this.c = this.b.ticksLived;
		this.g = true;
		if(var4.f() && !this.f && this.b.isAlive()) {
			this.f = true;
			this.d = this.b.ticksLived;
			this.e = this.d;
			this.b.bu();
		}

	}

	public IChatBaseComponent b() {
		if(this.a.size() == 0) {
			return new ChatMessage("death.attack.generic", new Object[]{this.b.getScoreboardDisplayName()});
		} else {
			CombatEntry var1 = this.i();
			CombatEntry var2 = (CombatEntry)this.a.get(this.a.size() - 1);
			IChatBaseComponent var3 = var2.h();
			Entity var4 = var2.a().getEntity();
			Object var6;
			if(var1 != null && var2.a() == DamageSource.FALL) {
				IChatBaseComponent var5 = var1.h();
				if(var1.a() != DamageSource.FALL && var1.a() != DamageSource.OUT_OF_WORLD) {
					if(var5 == null || var3 != null && var5.equals(var3)) {
						if(var3 != null) {
							ItemStack var9 = var4 instanceof EntityLiving?((EntityLiving)var4).be():null;
							if(var9 != null && var9.hasName()) {
								var6 = new ChatMessage("death.fell.finish.item", new Object[]{this.b.getScoreboardDisplayName(), var3, var9.E()});
							} else {
								var6 = new ChatMessage("death.fell.finish", new Object[]{this.b.getScoreboardDisplayName(), var3});
							}
						} else {
							var6 = new ChatMessage("death.fell.killer", new Object[]{this.b.getScoreboardDisplayName()});
						}
					} else {
						Entity var7 = var1.a().getEntity();
						ItemStack var8 = var7 instanceof EntityLiving?((EntityLiving)var7).be():null;
						if(var8 != null && var8.hasName()) {
							var6 = new ChatMessage("death.fell.assist.item", new Object[]{this.b.getScoreboardDisplayName(), var5, var8.E()});
						} else {
							var6 = new ChatMessage("death.fell.assist", new Object[]{this.b.getScoreboardDisplayName(), var5});
						}
					}
				} else {
					var6 = new ChatMessage("death.fell.accident." + this.a(var1), new Object[]{this.b.getScoreboardDisplayName()});
				}
			} else {
				var6 = var2.a().getLocalizedDeathMessage(this.b);
			}

			return (IChatBaseComponent)var6;
		}
	}

	public EntityLiving c() {
		EntityLiving var1 = null;
		EntityHuman var2 = null;
		float var3 = 0.0F;
		float var4 = 0.0F;
		Iterator var5 = this.a.iterator();

		while(true) {
			CombatEntry var6;
			do {
				do {
					if(!var5.hasNext()) {
						if(var2 != null && var4 >= var3 / 3.0F) {
							return var2;
						}

						return var1;
					}

					var6 = (CombatEntry)var5.next();
					if(var6.a().getEntity() instanceof EntityHuman && (var2 == null || var6.c() > var4)) {
						var4 = var6.c();
						var2 = (EntityHuman)var6.a().getEntity();
					}
				} while(!(var6.a().getEntity() instanceof EntityLiving));
			} while(var1 != null && var6.c() <= var3);

			var3 = var6.c();
			var1 = (EntityLiving)var6.a().getEntity();
		}
	}

	private CombatEntry i() {
		CombatEntry var1 = null;
		CombatEntry var2 = null;
		byte var3 = 0;
		float var4 = 0.0F;

		for(int var5 = 0; var5 < this.a.size(); ++var5) {
			CombatEntry var6 = (CombatEntry)this.a.get(var5);
			CombatEntry var7 = var5 > 0?(CombatEntry)this.a.get(var5 - 1):null;
			if((var6.a() == DamageSource.FALL || var6.a() == DamageSource.OUT_OF_WORLD) && var6.i() > 0.0F && (var1 == null || var6.i() > var4)) {
				if(var5 > 0) {
					var1 = var7;
				} else {
					var1 = var6;
				}

				var4 = var6.i();
			}

			if(var6.g() != null && (var2 == null || var6.c() > (float)var3)) {
				var2 = var6;
			}
		}

		if(var4 > 5.0F && var1 != null) {
			return var1;
		} else if(var3 > 5 && var2 != null) {
			return var2;
		} else {
			return null;
		}
	}

	private String a(CombatEntry var1) {
		return var1.g() == null?"generic":var1.g();
	}

	private void j() {
		this.h = null;
	}

	public void g() {
		int var1 = this.f?300:100;
		if(this.g && (!this.b.isAlive() || this.b.ticksLived - this.c > var1)) {
			boolean var2 = this.f;
			this.g = false;
			this.f = false;
			this.e = this.b.ticksLived;
			if(var2) {
				this.b.bv();
			}

			this.a.clear();
		}

	}
}
