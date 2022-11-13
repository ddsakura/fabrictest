package fabrictest.ftest1;

import fabrictest.ftest1.blocks.BoxBlock;
import fabrictest.ftest1.blocks.BoxBlockEntity;
import fabrictest.ftest1.blocks.BoxScreenHandler;
import fabrictest.ftest1.blocks.MyBlock;
import fabrictest.ftest1.items.MyItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Ftest1 implements ModInitializer {

    // an instance of our new item
    public static final MyItem CUSTOM_ITEM = new MyItem();
    public static final MyItem CUSTOM_ITEM2 = new MyItem(new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block EXAMPLE_BLOCK = new MyBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

    public static final Block BOX = new BoxBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD));
    public static final Item BOX_ITEM = new BlockItem(BOX, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockEntityType<BoxBlockEntity> BOX_ENTITY = FabricBlockEntityTypeBuilder.create(BoxBlockEntity::new, BOX).build();
    public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(BoxScreenHandler::new);

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("tutorial", "custom_item"), CUSTOM_ITEM);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "custom_item2"), CUSTOM_ITEM2);

        Registry.register(Registry.BLOCK, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.BLOCK, new Identifier("tutorial", "box"), BOX);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "box"), BOX_ITEM);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("tutorial", "box"), BOX_ENTITY);
        Registry.register(Registry.SCREEN_HANDLER, new Identifier("tutorial", "box"), BOX_SCREEN_HANDLER);
    }
}
