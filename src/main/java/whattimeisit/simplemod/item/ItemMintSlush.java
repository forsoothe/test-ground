package whattimeisit.simplemod.item;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemMintSlush extends ItemFood {

    public ItemMintSlush(String name, int id, int healAmount, boolean favouriteWolfMeat) {
        super(name, id, healAmount, favouriteWolfMeat);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (entityplayer.health < 20 && itemstack.consumeItem(entityplayer)) {
            entityplayer.heal(this.healAmount);
        }
        return itemstack;
    }

}
