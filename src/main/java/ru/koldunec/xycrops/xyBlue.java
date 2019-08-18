package ru.koldunec.xycrops;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class xyBlue extends xyCrop {
    public static final PropertyInteger Age = PropertyInteger.create("age1", 0, 4);
    public xyBlue(){
        super("xycrop_blue");
    }

    @Override
    public ItemStack getCrystal() {
        return new ItemStack(Item.getByNameOrId("projectx:xycronium_crystal"),1,0);
    }


    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {Age});
    }

    @Override
    protected PropertyInteger getAgeProperty() {
        return Age;
    }
}
