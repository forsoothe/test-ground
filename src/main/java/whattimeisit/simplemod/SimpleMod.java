package whattimeisit.simplemod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import turniplabs.halplibe.helper.BlockBuilder;

import net.minecraft.core.block.*;
import net.minecraft.client.sound.block.*;
import net.minecraft.core.block.material.*;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;

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
    public static final Block mintcrop = new BlockBuilder(MOD_ID)
            .setBlockSound(BlockSounds.GRASS)
            .setBlockModel(new BlockModelRenderBlocks(1))
            .build(new BlockMintCrop("mintcrop",525));

    @Override
    public void onInitialize() {
        LOGGER.info("simplemod initialized.");
    }}
