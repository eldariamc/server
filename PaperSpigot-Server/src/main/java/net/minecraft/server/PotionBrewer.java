//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import java.util.*;

public class PotionBrewer {
	public static final String a = null;
	public static final String b = "-0+1-2-3&4-4+13";
	public static final String c = "+0-1-2-3&4-4+13";
	public static final String d = "-0-1+2-3&4-4+13";
	public static final String e = "-0+3-4+13";
	public static final String f = "+0-1+2-3&4-4+13";
	public static final String g = "+0-1-2+3&4-4+13";
	public static final String h = "+0+1-2-3&4-4+13";
	public static final String i = "-5+6-7";
	public static final String j = "+5-6-7";
	public static final String k = "+14&13-13";
	public static final String l = "-0+1+2-3+13&4-4";
	public static final String m = "+0-1+2+3+13&4-4";
	public static final String rabbitFootEffect = "+0+1-2+3&4-4+13";
	public static final String featherEffect = "+0+1+2-3&4-4+13";
	public static final String hasteEffect = "+0+1+2+3&4-4+13";
	private static final HashMap effectDurations = new HashMap();
	private static final HashMap effectAmplifiers = new HashMap();
	private static final HashMap p = new HashMap();
	private static final String[] appearances = new String[]{"potion.prefix.mundane", "potion.prefix.uninteresting",
			"potion.prefix.bland", "potion.prefix.clear", "potion.prefix.milky", "potion.prefix.diffuse",
			"potion.prefix.artless", "potion.prefix.thin", "potion.prefix.awkward", "potion.prefix.flat",
			"potion.prefix.bulky", "potion.prefix.bungling", "potion.prefix.buttered", "potion.prefix.smooth",
			"potion.prefix.suave", "potion.prefix.debonair", "potion.prefix.thick", "potion.prefix.elegant",
			"potion.prefix.fancy", "potion.prefix.charming", "potion.prefix.dashing", "potion.prefix.refined",
			"potion.prefix.cordial", "potion.prefix.sparkling", "potion.prefix.potent", "potion.prefix.foul",
			"potion.prefix.odorless", "potion.prefix.rank", "potion.prefix.harsh", "potion.prefix.acrid",
			"potion.prefix.gross", "potion.prefix.stinky"};


	public static boolean a(int var0, int var1) {
		return (var0 & 1 << var1) != 0;
	}

	private static int c(int var0, int var1) {
		return a(var0, var1)?1:0;
	}

	private static int d(int var0, int var1) {
		return a(var0, var1)?0:1;
	}

	public static int a(int var0) {
		return a(var0, 5, 4, 3, 2, 1);
	}

	public static int a(Collection var0) {
		int var1 = 3694022;
		if(var0 != null && !var0.isEmpty()) {
			float var2 = 0.0F;
			float var3 = 0.0F;
			float var4 = 0.0F;
			float var5 = 0.0F;
			Iterator var6 = var0.iterator();

			while(var6.hasNext()) {
				MobEffect var7 = (MobEffect)var6.next();
				int var8 = MobEffectList.byId[var7.getEffectId()].j();

				for(int var9 = 0; var9 <= var7.getAmplifier(); ++var9) {
					var2 += (float)(var8 >> 16 & 255) / 255.0F;
					var3 += (float)(var8 >> 8 & 255) / 255.0F;
					var4 += (float)(var8 >> 0 & 255) / 255.0F;
					++var5;
				}
			}

			var2 = var2 / var5 * 255.0F;
			var3 = var3 / var5 * 255.0F;
			var4 = var4 / var5 * 255.0F;
			return (int)var2 << 16 | (int)var3 << 8 | (int)var4;
		} else {
			return var1;
		}
	}

	public static boolean b(Collection var0) {
		Iterator var1 = var0.iterator();

		MobEffect var2;
		do {
			if(!var1.hasNext()) {
				return true;
			}

			var2 = (MobEffect)var1.next();
		} while(var2.isAmbient());

		return false;
	}

	public static String c(int var0) {
		int var1 = a(var0);
		return appearances[var1];
	}

	private static int a(boolean var0, boolean var1, boolean var2, int var3, int var4, int var5, int var6) {
		int var7 = 0;
		if(var0) {
			var7 = d(var6, var4);
		} else if(var3 != -1) {
			if(var3 == 0 && h(var6) == var4) {
				var7 = 1;
			} else if(var3 == 1 && h(var6) > var4) {
				var7 = 1;
			} else if(var3 == 2 && h(var6) < var4) {
				var7 = 1;
			}
		} else {
			var7 = c(var6, var4);
		}

		if(var1) {
			var7 *= var5;
		}

		if(var2) {
			var7 *= -1;
		}

		return var7;
	}

	private static int h(int var0) {
		int var1;
		for(var1 = 0; var0 > 0; ++var1) {
			var0 &= var0 - 1;
		}

		return var1;
	}

	private static int a(String var0, int var1, int var2, int var3) {
		if(var1 < var0.length() && var2 >= 0 && var1 < var2) {
			int var4 = var0.indexOf(124, var1);
			int var5;
			int var17;
			if(var4 >= 0 && var4 < var2) {
				var5 = a(var0, var1, var4 - 1, var3);
				if(var5 > 0) {
					return var5;
				} else {
					var17 = a(var0, var4 + 1, var2, var3);
					return var17 > 0?var17:0;
				}
			} else {
				var5 = var0.indexOf(38, var1);
				if(var5 >= 0 && var5 < var2) {
					var17 = a(var0, var1, var5 - 1, var3);
					if(var17 <= 0) {
						return 0;
					} else {
						int var18 = a(var0, var5 + 1, var2, var3);
						return var18 <= 0?0:(var17 > var18?var17:var18);
					}
				} else {
					boolean var6 = false;
					boolean var7 = false;
					boolean var8 = false;
					boolean var9 = false;
					boolean var10 = false;
					byte var11 = -1;
					int var12 = 0;
					int var13 = 0;
					int var14 = 0;

					for(int var15 = var1; var15 < var2; ++var15) {
						char var16 = var0.charAt(var15);
						if(var16 >= 48 && var16 <= 57) {
							if(var6) {
								var13 = var16 - 48;
								var7 = true;
							} else {
								var12 *= 10;
								var12 += var16 - 48;
								var8 = true;
							}
						} else if(var16 == 42) {
							var6 = true;
						} else if(var16 == 33) {
							if(var8) {
								var14 += a(var9, var7, var10, var11, var12, var13, var3);
								var9 = false;
								var10 = false;
								var6 = false;
								var7 = false;
								var8 = false;
								var13 = 0;
								var12 = 0;
								var11 = -1;
							}

							var9 = true;
						} else if(var16 == 45) {
							if(var8) {
								var14 += a(var9, var7, var10, var11, var12, var13, var3);
								var9 = false;
								var10 = false;
								var6 = false;
								var7 = false;
								var8 = false;
								var13 = 0;
								var12 = 0;
								var11 = -1;
							}

							var10 = true;
						} else if(var16 != 61 && var16 != 60 && var16 != 62) {
							if(var16 == 43 && var8) {
								var14 += a(var9, var7, var10, var11, var12, var13, var3);
								var9 = false;
								var10 = false;
								var6 = false;
								var7 = false;
								var8 = false;
								var13 = 0;
								var12 = 0;
								var11 = -1;
							}
						} else {
							if(var8) {
								var14 += a(var9, var7, var10, var11, var12, var13, var3);
								var9 = false;
								var10 = false;
								var6 = false;
								var7 = false;
								var8 = false;
								var13 = 0;
								var12 = 0;
								var11 = -1;
							}

							if(var16 == 61) {
								var11 = 0;
							} else if(var16 == 60) {
								var11 = 2;
							} else if(var16 == 62) {
								var11 = 1;
							}
						}
					}

					if(var8) {
						var14 += a(var9, var7, var10, var11, var12, var13, var3);
					}

					return var14;
				}
			}
		} else {
			return 0;
		}
	}

	public static List getEffects(int var0, boolean var1) {
		ArrayList var2 = null;
		MobEffectList[] var3 = MobEffectList.byId;
		int var4 = var3.length;

		for(int var5 = 0; var5 < var4; ++var5) {
			MobEffectList var6 = var3[var5];
			if(var6 != null && (!var6.i() || var1)) {
				String var7 = (String)effectDurations.get(Integer.valueOf(var6.getId()));
				if(var7 != null) {
					int var8 = a(var7, 0, var7.length(), var0);
					if(var8 > 0) {
						int var9 = 0;
						String var10 = (String)effectAmplifiers.get(Integer.valueOf(var6.getId()));
						if(var10 != null) {
							var9 = a(var10, 0, var10.length(), var0);
							if(var9 < 0) {
								var9 = 0;
							}
						}

						if(var6.isInstant()) {
							var8 = 1;
						} else {
							var8 = 1200 * (var8 * 3 + (var8 - 1) * 2);
							var8 >>= var9;
							var8 = (int)Math.round((double)var8 * var6.getDurationModifier());
							if((var0 & 16384) != 0) {
								var8 = (int)Math.round((double)var8 * 0.75D + 0.5D);
							}
						}

						if(var2 == null) {
							var2 = new ArrayList();
						}

						MobEffect var11 = new MobEffect(var6.getId(), var8, var9);
						if((var0 & 16384) != 0) {
							var11.setSplash(true);
						}

						var2.add(var11);
					}
				}
			}
		}

		return var2;
	}

	private static int a(int var0, int var1, boolean var2, boolean var3, boolean var4) {
		if(var4) {
			if(!a(var0, var1)) {
				return 0;
			}
		} else if(var2) {
			var0 &= ~(1 << var1);
		} else if(var3) {
			if((var0 & 1 << var1) == 0) {
				var0 |= 1 << var1;
			} else {
				var0 &= ~(1 << var1);
			}
		} else {
			var0 |= 1 << var1;
		}

		return var0;
	}

	public static int a(int var0, String var1) {
		byte var2 = 0;
		int var3 = var1.length();
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		int var8 = 0;

		for(int var9 = var2; var9 < var3; ++var9) {
			char var10 = var1.charAt(var9);
			if(var10 >= 48 && var10 <= 57) {
				var8 *= 10;
				var8 += var10 - 48;
				var4 = true;
			} else if(var10 == 33) {
				if(var4) {
					var0 = a(var0, var8, var6, var5, var7);
					var7 = false;
					var5 = false;
					var6 = false;
					var4 = false;
					var8 = 0;
				}

				var5 = true;
			} else if(var10 == 45) {
				if(var4) {
					var0 = a(var0, var8, var6, var5, var7);
					var7 = false;
					var5 = false;
					var6 = false;
					var4 = false;
					var8 = 0;
				}

				var6 = true;
			} else if(var10 == 43) {
				if(var4) {
					var0 = a(var0, var8, var6, var5, var7);
					var7 = false;
					var5 = false;
					var6 = false;
					var4 = false;
					var8 = 0;
				}
			} else if(var10 == 38) {
				if(var4) {
					var0 = a(var0, var8, var6, var5, var7);
					var7 = false;
					var5 = false;
					var6 = false;
					var4 = false;
					var8 = 0;
				}

				var7 = true;
			}
		}

		if(var4) {
			var0 = a(var0, var8, var6, var5, var7);
		}

		return var0 & 32767;
	}

	public static int a(int var0, int var1, int var2, int var3, int var4, int var5) {
		return (a(var0, var1)?16:0) | (a(var0, var2)?8:0) | (a(var0, var3)?4:0) | (a(var0, var4)?2:0) | (a(var0, var5)?1:0);
	}

	static {
		effectDurations.put(MobEffectList.REGENERATION.getId(), "0 & !1 & !2 & !3 & 0+6");
		effectDurations.put(MobEffectList.FASTER_MOVEMENT.getId(), "!0 & 1 & !2 & !3 & 1+6");
		effectDurations.put(MobEffectList.FIRE_RESISTANCE.getId(), "0 & 1 & !2 & !3 & 0+6");
		effectDurations.put(MobEffectList.HEAL.getId(), "0 & !1 & 2 & !3");
		effectDurations.put(MobEffectList.POISON.getId(), "!0 & !1 & 2 & !3 & 2+6");
		effectDurations.put(MobEffectList.WEAKNESS.getId(), "!0 & !1 & !2 & 3 & 3+6");
		effectDurations.put(MobEffectList.HARM.getId(), "!0 & !1 & 2 & 3");
		effectDurations.put(MobEffectList.SLOWER_MOVEMENT.getId(), "!0 & 1 & !2 & 3 & 3+6");
		effectDurations.put(MobEffectList.INCREASE_DAMAGE.getId(), "0 & !1 & !2 & 3 & 3+6");
		effectDurations.put(MobEffectList.NIGHT_VISION.getId(), "!0 & 1 & 2 & !3 & 2+6");
		effectDurations.put(MobEffectList.INVISIBILITY.getId(), "!0 & 1 & 2 & 3 & 2+6");
		effectDurations.put(MobEffectList.WATER_BREATHING.getId(), "0 & !1 & 2 & 3 & 2+6");
		effectDurations.put(MobEffectList.JUMP.getId(), "0 & 1 & !2 & 3 & 3+6");
		effectDurations.put(MobEffectList.FEATHER_FALLING.getId(),  "0 & 1 & 2 & !3");
		effectDurations.put(MobEffectList.FASTER_DIG.getId(), "0 & 1 & 2 & 3");
		effectAmplifiers.put(MobEffectList.FASTER_MOVEMENT.getId(), "5");
		effectAmplifiers.put(MobEffectList.FASTER_DIG.getId(), "5");
		effectAmplifiers.put(MobEffectList.INCREASE_DAMAGE.getId(), "5");
		effectAmplifiers.put(MobEffectList.REGENERATION.getId(), "5");
		effectAmplifiers.put(MobEffectList.HARM.getId(), "5");
		effectAmplifiers.put(MobEffectList.HEAL.getId(), "5");
		effectAmplifiers.put(MobEffectList.RESISTANCE.getId(), "5");
		effectAmplifiers.put(MobEffectList.POISON.getId(), "5");
		effectAmplifiers.put(MobEffectList.JUMP.getId(), "5");
		effectAmplifiers.put(MobEffectList.FEATHER_FALLING.getId(), "5");
		effectAmplifiers.put(MobEffectList.FASTER_DIG.getId(), "5");
	}
}
