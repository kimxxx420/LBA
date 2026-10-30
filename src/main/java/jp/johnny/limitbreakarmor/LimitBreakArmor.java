package jp.johnny.limitbreakarmor;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

/** Extra armor-based reduction after vanilla armor calculations. */
@EventBusSubscriber(modid = LimitBreakArmor.MOD_ID)
public final class LimitBreakArmor {
    public static final String MOD_ID = "limitbreakarmor";

    // Adjustable: 10,000,000 armor => ~99.90% additional reduction.
    private static final double ARMOR_SCALE = 10_000.0;
    // Never reduce to zero: even immense armor leaves at least 0.01%.
    private static final double MAX_EXTRA_REDUCTION = 0.9999;

    private LimitBreakArmor() {}

    @SubscribeEvent
    public static void onLivingDamagePre(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        float incoming = event.getNewDamage();
        if (!(incoming > 0.0f) || !Float.isFinite(incoming)) return;
        double armor = player.getAttributeValue(Attributes.ARMOR);
        if (!Double.isFinite(armor) || armor <= 0.0) return;
        double extraReduction = Math.min(MAX_EXTRA_REDUCTION, armor / (armor + ARMOR_SCALE));
        event.setNewDamage((float) (incoming * (1.0 - extraReduction)));
    }
}
