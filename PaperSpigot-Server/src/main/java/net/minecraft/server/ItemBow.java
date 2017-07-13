package net.minecraft.server;

import org.bukkit.event.entity.EntityCombustEvent;

public class ItemBow extends Item {

    public static final String[] a = new String[] { "pulling_0", "pulling_1", "pulling_2"};

    private double arrowDamage = 2.0;
    private int arrowKnockback = 0;

    public ItemBow() {
        this.maxStackSize = 1;
        this.setMaxDurability(384);
        this.a(CreativeModeTab.j);
    }

    public void a(ItemStack itemstack, World world, EntityHuman entityhuman, int i) {
        boolean flag = entityhuman.abilities.canInstantlyBuild || EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_INFINITE.id, itemstack) > 0;

        if (flag || entityhuman.inventory.b(Items.ARROW)) {
            int j = this.d_(itemstack) - i;
            float f = (float) j / 20.0F;

            f = (f * f + f * 2.0F) / 3.0F;
            if ((double) f < 0.1D) {
                return;
            }

            if (f > 1.0F) {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(world, entityhuman, f * 2.0F);
            // Eldaria - apply custom values
            entityarrow.b(arrowDamage);
            entityarrow.knockbackStrength = arrowKnockback;

            if (f == 1.0F) {
                entityarrow.setCritical(true);
            }

            int k = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_DAMAGE.id, itemstack);

            if (k > 0) {
                entityarrow.b(entityarrow.e() + (double) k * 0.5D + 0.5D);
            }

            int l = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK.id, itemstack);

            if (l > 0) {
                entityarrow.setKnockbackStrength(entityarrow.knockbackStrength + l);
            }

            if (EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_FIRE.id, itemstack) > 0) {
                // CraftBukkit start - call EntityCombustEvent
                EntityCombustEvent event = new EntityCombustEvent(entityarrow.getBukkitEntity(), 100);
                entityarrow.world.getServer().getPluginManager().callEvent(event);

                if (!event.isCancelled()) {
                    entityarrow.setOnFire(event.getDuration());
                }
                // CraftBukkit end
            }

            // CraftBukkit start
            org.bukkit.event.entity.EntityShootBowEvent event = org.bukkit.craftbukkit.event.CraftEventFactory.callEntityShootBowEvent(entityhuman, itemstack, entityarrow, f);
            if (event.isCancelled()) {
                event.getProjectile().remove();
                return;
            }

            if (event.getProjectile() == entityarrow.getBukkitEntity()) {
                world.addEntity(entityarrow);
            }
            // CraftBukkit end

            itemstack.damage(1, entityhuman);
            world.makeSound(entityhuman, "random.bow", 1.0F, 1.0F / (g.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            if (flag) {
                entityarrow.fromPlayer = 2;
            } else {
                entityhuman.inventory.a(Items.ARROW);
            }

            if (!world.isStatic) {
                // world.addEntity(entityarrow); // CraftBukkit - moved up
            }
        }
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        return itemstack;
    }

    public int d_(ItemStack itemstack) {
        return 72000;
    }

    public EnumAnimation d(ItemStack itemstack) {
        return EnumAnimation.BOW;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (entityhuman.abilities.canInstantlyBuild || entityhuman.inventory.b(Items.ARROW)) {
            entityhuman.a(itemstack, this.d_(itemstack));
        }

        return itemstack;
    }

    public int c() {
        return 1;
    }

    public double getArrowDamage() {
        return arrowDamage;
    }

    public ItemBow setArrowDamage(double arrowDamage) {
        this.arrowDamage = arrowDamage;
        return this;
    }

    public int getArrowKnockback() {
        return arrowKnockback;
    }

    public ItemBow setArrowKnockback(int arrowKnockback) {
        this.arrowKnockback = arrowKnockback;
        return this;
    }
}
