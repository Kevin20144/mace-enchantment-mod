package net.kevin.maceenchant;

import net.fabricmc.api.ModInitializer;
import net.kevin.maceenchant.enchantment.SkyfallEnchantment;
import net.kevin.maceenchant.event.MaceHitHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MaceEnchantMod implements ModInitializer {

    public static final Enchantment SKYFALL = new SkyfallEnchantment();

    @Override
    public void onInitialize() {
        // Register the Skyfall enchantment
        Registry.register(
            Registries.ENCHANTMENT,
            new Identifier("maceenchant", "skyfall"),
            SKYFALL
        );

        // Register the event handler
        MaceHitHandler.register();
    }
}
