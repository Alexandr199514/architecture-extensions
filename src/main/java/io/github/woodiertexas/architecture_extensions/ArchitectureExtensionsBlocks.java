package io.github.woodiertexas.architecture_extensions;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ArchitectureExtensionsBlocks {

    // Creating items/blocks/etc and defining their properties
    public static final ArchBlock STONE_BRICK_ARCH = new ArchBlock(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    public static final CircleCorner STONE_BRICK_CIRCLE_CORNER = new CircleCorner(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    public static final PostBlock STONE_BRICK_POST = new PostBlock(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());

    // Half Pillars
    public static final ColumnBlock STONE_BRICK_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(4f).nonOpaque());
    public static final ColumnBlock SANDSTONE_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock QUARTZ_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());
    public static final ColumnBlock ROSE_QUARTZ_COLUMN = new ColumnBlock(QuiltBlockSettings.of(Material.STONE).strength(3f).nonOpaque());

    static {

        String[] blocksArray = {"stone_brick_arch", "stone_brick_circle_corner", "stone_brick_column", "sandstone_column",
                "quartz_column", "rose_quartz_column", "stone_brick_post"
        };

        Block[] anotherBlocksArray = {STONE_BRICK_ARCH, STONE_BRICK_CIRCLE_CORNER, STONE_BRICK_COLUMN, SANDSTONE_COLUMN,
                QUARTZ_COLUMN, ROSE_QUARTZ_COLUMN, STONE_BRICK_POST
        };

        // Checks to see if the arrays are of the same length. If not, stop the Minecraft process.
        if (blocksArray.length != anotherBlocksArray.length) {
            throw new RuntimeException("Mismatched array lengths.\nLength of blocksArray: " + blocksArray.length +
                    "\nLength of anotherBlocksArray: " + anotherBlocksArray.length);
        }

        // Loops through the length of both arrays and registers the blocks found in said arrays.
        for (int i = 0; i < blocksArray.length; i++) {
            Registry.register(Registry.BLOCK, new Identifier("architecture_extensions", blocksArray[i]), anotherBlocksArray[i]);
            Registry.register(Registry.ITEM, new Identifier("architecture_extensions", blocksArray[i]),
                    new BlockItem(anotherBlocksArray[i], new QuiltItemSettings().group(ItemGroup.DECORATIONS)));
        }
    }

    public static void init() {}
}
