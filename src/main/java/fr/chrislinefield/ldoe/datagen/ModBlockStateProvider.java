package fr.chrislinefield.ldoe.datagen;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LDOEMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RADIOACTIVE_BLOCK);
        blockWithItem(ModBlocks.BARBED_WIRE);
        blockWithItem(ModBlocks.QUICKSAND);
        blockWithItem(ModBlocks.WORKBENCH);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
