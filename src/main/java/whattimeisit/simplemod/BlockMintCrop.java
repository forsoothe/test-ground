package whattimeisit.simplemod;

import turniplabs.halplibe.helper.TextureHelper;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockCrops;
import net.minecraft.core.block.material.*;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;


public class BlockMintCrop extends BlockCrops {
    int[] stage0 = TextureHelper.getOrCreateBlockTexture(SimpleMod.MOD_ID, "mint_stage0.png");
    int[] stage1 = TextureHelper.getOrCreateBlockTexture(SimpleMod.MOD_ID, "mint_stage1.png");
    int[] stage2 = TextureHelper.getOrCreateBlockTexture(SimpleMod.MOD_ID, "mint_stage2.png");
    public final int[] growthStageTextures = new int[]{texCoordToIndex(stage0[0], stage0[1]), texCoordToIndex(stage1[0], stage1[1]), texCoordToIndex(stage2[0], stage2[1])};

    public BlockMintCrop(String key, int id){
        super(key,id);
        this.setTickOnLoad(true);
    }
    public boolean canThisPlantGrowOnThisBlockID(int i) {
        return i == Block.grass.id;
    }
    @Override
    public void fertilize(World world, int x, int y, int z) {
        world.setBlockAndMetadataWithNotify(x, y, z, this.id,world.getBlockMetadata(x, y, z)+1);
    }
    @Override
    public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
        if (meta < 0 || meta > 2) {
            meta = 2;
        }
        return this.growthStageTextures[meta];
    }
}
