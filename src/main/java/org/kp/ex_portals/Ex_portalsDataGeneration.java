package org.kp.ex_portals;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.kp.ex_portals.datagen.*;

public class Ex_portalsDataGeneration implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
    }
}
