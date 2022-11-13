package fabrictest.ftest1.client;

import fabrictest.ftest1.Ftest1;
import fabrictest.ftest1.blocks.PositionedScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class Ftest1Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(Ftest1.BOX_SCREEN_HANDLER, PositionedScreen::new);
    }
}
