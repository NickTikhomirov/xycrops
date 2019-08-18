package ru.koldunec.xycrops;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CommonProxy {
    public Block blue = new xyBlue();
    public Block green = new xyGreen();
    public Block red = new xyRed();
    public Block black = new xyBlack();
    public Block white = new xyWhite();


    public void preInit(FMLPreInitializationEvent event)
    {
        ForgeRegistries.BLOCKS.register(blue);
        ForgeRegistries.BLOCKS.register(green);
        ForgeRegistries.BLOCKS.register(red);
        ForgeRegistries.BLOCKS.register(black);
        ForgeRegistries.BLOCKS.register(white);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public void init(FMLInitializationEvent event)
    {

    }
}
