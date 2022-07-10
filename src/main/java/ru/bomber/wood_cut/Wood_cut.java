package ru.bomber.wood_cut;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bomber.wood_cut.callbacks.BreakBlockCallback;
import ru.bomber.wood_cut.callbacks.OnBreakBlockListener;

public class Wood_cut implements ModInitializer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Wood_cut.class);
    @Override
    public void onInitialize() {
        LOGGER.info("Initialize main wood cut.");

        OnBreakBlockListener.EVENT.register(new BreakBlockCallback());
        LOGGER.info("Register attack tree listener");
    }
}
