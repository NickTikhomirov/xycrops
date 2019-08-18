package ru.koldunec.xycrops;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(modid = xycrops.MODID, name = xycrops.NAME, version = xycrops.VERSION, dependencies = "required-after:projectx")
public class xycrops
{
    public static final String MODID = "xycrops";
    public static final String NAME = "Xycronium Crops";
    public static final String VERSION = "1.0";
    @SidedProxy(clientSide = "ru.koldunec.xycrops.ClientProxy", serverSide = "ru.koldunec.xycrops.CommonProxy")
    public static CommonProxy proxy;
    public static Logger logger;
    public static Random random = new Random();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        proxy.init(event);
    }

}
