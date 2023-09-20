package whattimeisit.simplemod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.crafting.CraftingManager;
import net.minecraft.core.item.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import net.minecraft.core.block.*;
import net.minecraft.client.sound.block.*;
import net.minecraft.core.block.material.*;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import turniplabs.halplibe.helper.*;

import whattimeisit.simplemod.config.SimpleModConfig;
import whattimeisit.simplemod.item.ItemBackpack;
import whattimeisit.simplemod.item.ItemMintSlush;
import whattimeisit.simplemod.item.ItemToolScythe;

public class SimpleMod implements ModInitializer {
    public static final String MOD_ID = "simplemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    //Blocks
    public static final Block cardboard = new BlockBuilder(MOD_ID)
            .setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
            .setHardness(1.0f)
            .setResistance(1.0f)
            .setTextures("cardboard.png")
            .setFlammability(2, 2)
            .build(new Block("cardboard", 524, Material.wood));
    public static final Block mintCrop = new BlockBuilder(MOD_ID)
            .setBlockSound(BlockSounds.GRASS)
            .setBlockModel(new BlockModelRenderBlocks(1))
            .build(new BlockMintCrop("mintcrop",525));
    //Items


    public static final Item mintSlush = ItemHelper.createItem(MOD_ID, new ItemFood("mintslush", SimpleModConfig.mintSlush, 5, false), "mintslush", "mint_slush.png");
    public static final Item toolScythe = ItemHelper.createItem(MOD_ID, new ItemToolScythe("scythe",SimpleModConfig.scythe), "tool.scythe", "scythe.png");

    public static final Item itemBackpack = ItemHelper.createItem(MOD_ID, new ItemBackpack("backpack",SimpleModConfig.backpack), "tool.backpack", "scythe.png");

    //Recipes


    @Override
    public void onInitialize() {
        LOGGER.info("SimpleMod initialized.");

        CraftingManager craftingManager = CraftingManager.getInstance();
        //craftingManager.addRecipe(new ItemStack(SimpleMod.mintSlush, 4), "##", "##", Character.valueOf('#'), Block.dirt);


    }
}
