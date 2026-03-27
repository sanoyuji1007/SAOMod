package com.github.sanoyuji1007.SAOMod.block;

import com.github.sanoyuji1007.SAOMod.SaoMod;
import com.github.sanoyuji1007.SAOMod.item.SaoModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SaoModBlocks {
    //  レジストリの作成
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, SaoMod.MOD_ID);

    //  レジストリにブロックを登録
    //  ダイヤモンドブロックの設定をコピー
    //  金床の設置音を設定
    public static final RegistryObject<Block>ORIHALCON_BLOCK =registerBlockItem("orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));

    public static final RegistryObject<Block>RAW_ORIHALCON_BLOCK =registerBlockItem("raw_orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));

    private static <T extends Block>RegistryObject<T>registerBlockItem(String name, Supplier<T> supplier){
        RegistryObject<T>block=BLOCKS.register(name,supplier);
        SaoModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(),new Item.Properties()));
        return block;
    }

    //  レジストリをイベントバスに登録する
    public static void reister(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
