package net.kevin.maceenchant.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.kevin.maceenchant.MaceEnchantMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public class MaceHitHandler {

    public static void register() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient()) {
                // Use EnchantmentHelper to check for the Skyfall enchantment (robust)
                int level = EnchantmentHelper.getLevel(MaceEnchantMod.SKYFALL, player.getMainHandStack());
                if (level > 0 && entity instanceof LivingEntity target) {
                    // Base extra damage
                    float baseExtra = 6.0F;

                    // Calculate a falling boost based on fall distance (medium scaling)
                    float fallBoost = 0.0F;
                    float fallDistance = player.fallDistance;
                    if (fallDistance > 2.0F) {
                        // Start giving bonus after 2 blocks of fall; scale by 1.5 and clamp to +0–8
                        fallBoost = Math.min(8.0F, (fallDistance - 2.0F) * 1.5F);
                    }

                    target.damage(DamageSource.player(player), baseExtra + fallBoost);
                }
            }
            return ActionResult.PASS;
        });
    }
}
