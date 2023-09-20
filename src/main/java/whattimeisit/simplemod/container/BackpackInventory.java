/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package whattimeisit.simplemod.container;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.ListTag;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;

import java.util.HashMap;
import java.util.Map;

public class BackpackInventory implements IInventory {
    private static Map nameToClassMap = new HashMap();
    private static Map classToNameMap = new HashMap();
    private ItemStack[] chestContents = new ItemStack[36];


    private static void addMapping(Class class1, String s) {
        if (classToNameMap.containsKey(s)) {
            throw new IllegalArgumentException("Duplicate id: " + s);
        }
        nameToClassMap.put(s, class1);
        classToNameMap.put(class1, s);
    }
    public void writeIDToNBT(CompoundTag nbttagcompound) {
        String s = (String)classToNameMap.get(this.getClass());
        if (s == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        }
        nbttagcompound.putString("id", s);
    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.chestContents[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.chestContents[i] != null) {
            if (this.chestContents[i].stackSize <= j) {
                ItemStack itemstack = this.chestContents[i];
                this.chestContents[i] = null;
                this.onInventoryChanged();
                return itemstack;
            }
            ItemStack itemstack1 = this.chestContents[i].splitStack(j);
            if (this.chestContents[i].stackSize <= 0) {
                this.chestContents[i] = null;
            }
            this.onInventoryChanged();
            return itemstack1;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        this.chestContents[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "Chest";
    }

    public void readFromNBT(CompoundTag nbttagcompound) {
        //writeIDToNBT(nbttagcompound);//gotta be changed to read something?
        ListTag nbttaglist = nbttagcompound.getList("Items");
        this.chestContents = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            CompoundTag nbttagcompound1 = (CompoundTag)nbttaglist.tagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 0xFF;
            if (j < 0 || j >= this.chestContents.length) continue;
            this.chestContents[j] = ItemStack.readItemStackFromNbt(nbttagcompound1);
        }
    }

    public void writeToNBT(CompoundTag nbttagcompound) {
        writeIDToNBT(nbttagcompound);
        ListTag nbttaglist = new ListTag();
        for (int i = 0; i < this.chestContents.length; ++i) {
            if (this.chestContents[i] == null) continue;
            CompoundTag nbttagcompound1 = new CompoundTag();
            nbttagcompound1.putByte("Slot", (byte)i);
            this.chestContents[i].writeToNBT(nbttagcompound1);
            nbttaglist.addTag(nbttagcompound1);
        }
        nbttagcompound.put("Items", nbttaglist);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public void onInventoryChanged() {
    }
    public boolean canInteractWith(EntityPlayer var1){
        return true;
    }
}

