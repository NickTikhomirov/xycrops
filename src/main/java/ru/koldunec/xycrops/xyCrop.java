package ru.koldunec.xycrops;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;


abstract class xyCrop extends BlockCrops {
    public static final PropertyInteger Age = PropertyInteger.create("age1", 0, 4);
    private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
    };

    public xyCrop(String name){
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(Age,0));
    }

    public AxisAlignedBB getBoundingBox(IBlockState blockState, IBlockAccess source, BlockPos position) {
        return CROPS_AABB[(blockState.getValue(this.getAgeProperty())).intValue()];
    }

    protected int getBonemealAgeIncrease(World world) {
        return MathHelper.getInt(world.rand, 1, 2);
    }
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos position) {
        return EnumPlantType.Crop;
    }


    @Override
    public int getMaxAge() {
        return 4;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return this.getAge(state);
    }


    @Override
    protected Item getSeed() {
        return getCrystal().getItem();
    }

    @Override
    protected Item getCrop() {
        return getCrystal().getItem();
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        //super.getDrops(drops, world, pos, state, fortune);
        if(getAge(state)!=4){
            drops.add(getCrystal());
            return;
        }
        ItemStack a = getCrystal();
        a.setCount(xycrops.random.nextInt(2)+3);
        drops.add(a);
    }

    abstract public ItemStack getCrystal();

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(getAge(state)==4 && !worldIn.isRemote && !playerIn.isSneaking()){
            ItemStack a = getCrystal();
            a.setCount(xycrops.random.nextInt(2)+2);
            if(!playerIn.inventory.addItemStackToInventory(a))
                playerIn.dropItem(a,false);
            worldIn.setBlockState(pos,this.withAge(0));
            return true;
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
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
