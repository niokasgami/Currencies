package net.niokasgami.currencies;

import net.darkhax.bookshelf.registry.RegistryHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "currencies", name = "Town Currencies",version = "1.0.0", dependencies = "required-after:bookshelf")
public class Currencies {

    public static RegistryHelper REGISTRY = new RegistryHelper("currencies").setTab(CreativeTabs.MISC).enableAutoRegistration();

    public static Item itemCopperCoins;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        itemCopperCoins = REGISTRY.registerItem(new Item(), "coin_copper");
        // test
    }
}
