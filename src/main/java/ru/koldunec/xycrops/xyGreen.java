package ru.koldunec.xycrops;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xyGreen extends xyCrop {
    public xyGreen(){
        super("xycrop_green");
        this.setDefaultState(this.blockState.getBaseState().withProperty(Age,0));
    }

    @Override
    public ItemStack getCrystal() {
        return new ItemStack(Item.getByNameOrId("projectx:xycronium_crystal"),1,1);
    }


}
