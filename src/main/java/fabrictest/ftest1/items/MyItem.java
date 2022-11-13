package fabrictest.ftest1.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MyItem extends Item {
    public MyItem() {
        super(new FabricItemSettings().group(ItemGroup.MISC));
    }

    public MyItem(Settings abc) {
        super(abc);
    }
}
