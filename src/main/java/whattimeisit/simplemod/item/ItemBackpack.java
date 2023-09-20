package whattimeisit.simplemod.item;


import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.core.world.World;
import whattimeisit.simplemod.container.BackpackInventory;

public class ItemBackpack extends Item {
    public ItemBackpack(String name, int id) {
        super(name, id);
    }
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        int s = 0;
        entityplayer.displayGUIChest(ItemBackpack.getInventory(world,s));
        return itemstack;
    }
    public static IInventory getInventory(World world, int s) {
        BackpackInventory backpack = new BackpackInventory();
        return backpack;
    }
}
