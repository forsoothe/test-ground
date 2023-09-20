package whattimeisit.simplemod.item;

import net.minecraft.client.player.controller.PlayerController;
import net.minecraft.core.block.Block;

import net.minecraft.core.entity.EntityLiving;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.ItemToolShears;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemToolScythe extends ItemToolShears {
    public ItemToolScythe(String name, int id) {
        super(name, id);
    }
    @Override
    public boolean onBlockDestroyed(ItemStack itemstack, int id, int x, int y, int z, EntityLiving entityliving) {
        Block blocklist = Block.blocksList[id];
        if (blocklist != null && (blocklist.getHardness() > 0.0f || this.isSilkTouch())) {
            itemstack.damageItem(1, entityliving);
        }
        for (int x2 = x-1; x2 < x+2; x2++) {
            for (int z2 = z-1; z2 < z+2; z2++) {
                int blockID = entityliving.world.getBlockId(x2, y, z2);
                if(blockID == 0)
                    continue;
                Block breakList = Block.blocksList[blockID];
                if(breakList.getHardness() == 0.0f) {
                    entityliving.world.setBlock(x2, y, z2, 0);
                }
            }
        }
        return true;
    }
}
