package com.edelweiss.playerex.mixin;

import com.edelweiss.playerex.cache.PlayerEXCacheData;
import com.edelweiss.playerex.cache.PlayerEXCacheInternal;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.level.UnmodifiableLevelProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(UnmodifiableLevelProperties.class)
abstract class UnmodifiableLevelPropertiesMixin implements PlayerEXCacheData {
    @Final
    @Shadow
    private ServerWorldProperties worldProperties;

    @NotNull
    @Override
    public PlayerEXCacheInternal playerEXCache() {
        return ((PlayerEXCacheData) this.worldProperties).playerEXCache();
    }
}
