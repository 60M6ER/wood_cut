package ru.bomber.survivalfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bomber.survivalfabric.callBacks.AttackTreeListener;

public class SurvivalFabric implements ModInitializer {
    Logger logger = LoggerFactory.getLogger(SurvivalFabric.class);
    @Override
    public void onInitialize() {
        logger.info("Survival fabric mod Main class initialize");

        AttackBlockCallback.EVENT.register(new AttackTreeListener());
        logger.info("Register attack tree listener");
    }
}
