package ru.koldunec.xycrops;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xyBlack extends xyCrop {
    public xyBlack(){
        super("xycrop_black");
    }

    @Override
    public ItemStack getCrystal() {
        return new ItemStack(Item.getByNameOrId("projectx:xycronium_crystal"),1,3);
    }


}
