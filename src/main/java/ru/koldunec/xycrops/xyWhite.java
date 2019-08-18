package ru.koldunec.xycrops;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xyWhite extends xyCrop {
    public xyWhite(){
        super("xycrop_white");
    }

    @Override
    public ItemStack getCrystal() {
        return new ItemStack(Item.getByNameOrId("projectx:xycronium_crystal"),1,4);
    }

}
