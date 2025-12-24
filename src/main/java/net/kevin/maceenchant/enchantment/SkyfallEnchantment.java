package net.kevin.maceenchant.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;

public class SkyfallEnchantment extends Enchantment {

    public SkyfallEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        // Only works on items containing "mace" in the item ID or path
        try {
            return Registries.ITEM.getId(stack.getItem()).getPath().toLowerCase().contains("mace");
        } catch (Exception e) {
            // Fallback to string check if registry lookup fails
            return stack.getItem().toString().toLowerCase().contains("mace");
        }
    }
}
