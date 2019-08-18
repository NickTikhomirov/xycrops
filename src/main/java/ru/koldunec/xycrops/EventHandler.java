package ru.koldunec.xycrops;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void plantCrystal(PlayerInteractEvent.RightClickBlock e){
        World w = e.getWorld();
        BlockPos b = e.getPos();
        ItemStack i = e.getItemStack();
        if(w.getBlockState(b).getBlock().equals(Blocks.FARMLAND)&& e.getFace()!=null){
            if(e.getFace().equals(EnumFacing.UP) && !i.isEmpty()){
                if(i.getItem().equals(Item.getByNameOrId("projectx:xycronium_crystal"))){
                    if(w.isAirBlock(b.up())){
                        i.shrink(1);
                        w.setBlockState(b.up(),getByMeta(i.getMetadata()).getDefaultState());
                    }
                }
            }
        }
    }

    private static Block getByMeta(int i){
        switch(i){
            case 0: return xycrops.proxy.blue;
            case 1: return xycrops.proxy.green;
            case 2: return xycrops.proxy.red;
            case 3: return xycrops.proxy.black;
            default: return xycrops.proxy.white;
        }
    }
}
