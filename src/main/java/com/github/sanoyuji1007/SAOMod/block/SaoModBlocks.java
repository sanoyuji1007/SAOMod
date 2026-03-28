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
    /**
     * オリハルコンブロックの登録オブジェクト。
     *ダイヤモンドブロックと同等の性質を持ち、金属的な音を再生する。
     */
    public static final RegistryObject<Block>ORIHALCON_BLOCK =registerBlockItem("orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));
    /**
     * オリハルコンの鉱石の登録オブジェクト。
     *ダイヤモンドブロックと同等の性質を持ち、金属的な音を再生する。
     */
    public static final RegistryObject<Block>RAW_ORIHALCON_BLOCK =registerBlockItem("raw_orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));
    /**
     * SAOブロックの登録オブジェクト。
     *ダイヤモンドブロックと同等の性質を持ち、金属的な音を再生する。
     */
    public static final RegistryObject<Block>SAO_BLOCK =registerBlockItem("sao_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));



    //  ブロックと対応するBlockItemを同時に登録するヘルパーメソッド。
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
