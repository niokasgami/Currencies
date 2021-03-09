package net.niokasgami.currencies;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
@Mod(modid = Currencies.MOD_ID, version = "1.0")
public class Currencies {

    public static final String MOD_ID = "currencies";

    public static final Item COPPER_COIN = new Item();
    public static final Item IRON_COIN = new Item();
    public static final Item IRON_COIN_PILE = new Item();
    //public static final Item GOLD_COIN = new Item();


    private static final CreativeTabs TAB = new CreativeTabs(MOD_ID){

        public ItemStack getTabIconItem(){
            return new ItemStack((COPPER_COIN));
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        createModel(COPPER_COIN);
        createModel(IRON_COIN);
        createModel(IRON_COIN_PILE);
    }
    private static void createModel(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItems("copper_coin", COPPER_COIN));
        registry.register(createItems("iron_coin", IRON_COIN));
        registry.register(createItems("iron_coin_pile", IRON_COIN_PILE));
    }

    private static Item createItems(String name, Item item){
        item.setRegistryName(name);
        item.setUnlocalizedName(MOD_ID + "." + name);
        item.setCreativeTab(TAB);
        return item;
    }
}
