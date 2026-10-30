package jp.johnny.limitbreakarmor;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

/**
 * Additional armor-based protection at the final living-damage stage.
 * This is intentionally independent of vanilla armor bypass tags, so damage
 * sources that reach this event (including magic and armor-piercing damage)
 * receive the same additional reduction. Direct health changes do not.
 */
@EventBusSubscriber(modid = LimitBreakArmor.MOD_ID)
public final class LimitBreakArmor {
    public static final String MOD_ID = "limitbreakarmor";

    // 10,000,000 armor => ~99.99% additional reduction (capped below).
    private static final double ARMOR_SCALE = 1_000.0;
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
        // Applies regardless of the damage source, provided it reaches this event.
        double extraReduction = Math.min(MAX_EXTRA_REDUCTION, armor / (armor + ARMOR_SCALE));
        event.setNewDamage((float) (incoming * (1.0 - extraReduction)));
    }
}
