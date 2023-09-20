/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package whattimeisit.simplemod.container;

import java.util.List;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.Container;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.core.player.inventory.slot.Slot;

public class ContainerBackpack extends Container {
    private IInventory inventory;
    private int numberOfRows;

    public ContainerBackpack(IInventory iinventory) {
        this.inventory = iinventory;
        this.numberOfRows = iinventory.getSizeInventory() / 9;
        int i = (this.numberOfRows - 4) * 18;
        for (int j = 0; j < this.numberOfRows; ++j) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(iinventory, i1 + j * 9, 8 + i1 * 18, 18 + j * 18));
            }
        }
        for (int k = 0; k < 3; ++k) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(iinventory, j1 + k * 9 + 9, 8 + j1 * 18, 103 + k * 18 + i));
            }
        }
        for (int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(iinventory, l, 8 + l * 18, 161 + i));
        }
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityplayer) {
        return this.inventory.canInteractWith(entityplayer);
    }

    @Override
    public List<Integer> getMoveSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
        int chestSize = this.numberOfRows * 9;
        if (slot.id >= 0 && slot.id < chestSize) {
            return this.getSlots(0, chestSize, false);
        }
        if (action == InventoryAction.MOVE_ALL) {
            if (slot.id >= chestSize && slot.id < chestSize + 27) {
                return this.getSlots(chestSize, 27, false);
            }
            if (slot.id >= chestSize + 27 && slot.id < chestSize + 36) {
                return this.getSlots(chestSize + 27, 9, false);
            }
        } else if (slot.id >= chestSize && slot.id < chestSize + 36) {
            return this.getSlots(chestSize, 36, false);
        }
        return null;
    }

    @Override
    public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
        int chestSize = this.numberOfRows * 9;
        if (slot.id < chestSize) {
            return this.getSlots(chestSize, 36, true);
        }
        return this.getSlots(0, chestSize, false);
    }
}

