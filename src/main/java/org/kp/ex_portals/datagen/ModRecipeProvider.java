package org.kp.ex_portals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.RiftItems;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerCompactingRecipe(exporter, RecipeCategory.MISC, RiftItems.RiftShard,RiftBlocks.StablePortalTransm);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,RiftItems.RiftPickaxe,1)
                .pattern("@@@")
                .pattern(" ! ")
                .pattern(" ! ")
                .input('@',RiftItems.ProccesedRiftShard)
                .input('!', Items.STICK)
                .criterion(hasItem(RiftItems.ProccesedRiftShard),conditionsFromItem(RiftItems.ProccesedRiftShard))
                .offerTo(exporter,new Identifier(Ex_portals.ModID,getRecipeName(RiftItems.RiftPickaxe)));
    }

}
