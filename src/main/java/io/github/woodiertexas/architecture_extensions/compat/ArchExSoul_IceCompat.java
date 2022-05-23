package io.github.woodiertexas.architecture_extensions.compat;

import io.github.woodiertexas.architecture_extensions.blocks.ColumnBlock;
import io.github.woodiertexas.architecture_extensions.blocks.PostBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArchExSoul_IceCompat {
    // Columns
    public static final ColumnBlock HARDENED_LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock LIGHTSTONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock POLISHED_LIGHTSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final ColumnBlock SOUL_ICE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));
    public static final ColumnBlock SOUL_ICE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));
    public static final ColumnBlock POLISHED_SOUL_ICE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));

    // Post Blocks
    public static final PostBlock HARDENED_LIGHTSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final PostBlock LIGHTSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final PostBlock LIGHTSTONE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final PostBlock POLISHED_LIGHTSTONE_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final PostBlock SOUL_ICE_POST = new PostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));
    public static final PostBlock SOUL_ICE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));
    public static final PostBlock POLISHED_SOUL_ICE_POST = new PostBlock(QuiltBlockSettings.of(Material.ICE).strength(3f).sounds(BlockSoundGroup.GLASS));

    // Roof Blocks


    static {
        /*
        List of blocks to be registered in key, value pairs.
        For example, "cobblestone_column, COBBLESTONE_COLUMN"
         */
        Map<String, Block> blocks = new LinkedHashMap<>();
        blocks.put("hardened_lightstone_column", HARDENED_LIGHTSTONE_COLUMN);
        blocks.put("lightstone_column", LIGHTSTONE_COLUMN);
        blocks.put("lightstone_brick_column", LIGHTSTONE_BRICK_COLUMN);
        blocks.put("polished_lightstone_column", POLISHED_LIGHTSTONE_COLUMN);
        blocks.put("polished_soul_ice_column", POLISHED_SOUL_ICE_COLUMN);
        blocks.put("soul_ice_column", SOUL_ICE_COLUMN);
        blocks.put("soul_ice_brick_column", SOUL_ICE_BRICK_COLUMN);
        blocks.put("hardened_lightstone_post", HARDENED_LIGHTSTONE_POST);
        blocks.put("lightstone_post", LIGHTSTONE_POST);
        blocks.put("lightstone_brick_post", LIGHTSTONE_BRICK_POST);
        blocks.put("polished_lightstone_post", POLISHED_LIGHTSTONE_POST);
        blocks.put("polished_soul_ice_post", POLISHED_SOUL_ICE_POST);
        blocks.put("soul_ice_post", SOUL_ICE_POST);
        blocks.put("soul_ice_brick_post", SOUL_ICE_BRICK_POST);

        // Registering the blocks and corresponding block items.
        for (Map.Entry<String, Block> entry : blocks.entrySet()) {
            Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", entry.getKey()), entry.getValue());
            Registry.register(Registry.ITEM, new Identifier("architecture_extensions", entry.getKey()),
                    new BlockItem(entry.getValue(), new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
        }

    }

    public static void init() {}
}
