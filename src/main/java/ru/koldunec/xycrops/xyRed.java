package ru.koldunec.xycrops;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xyRed extends xyCrop {
    public xyRed(){
        super("xycrop_red");
    }

    @Override
    public ItemStack getCrystal() {
        return new ItemStack(Item.getByNameOrId("projectx:xycronium_crystal"),1,2);
    }
}
