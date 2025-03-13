package net.doodcraft.arclightInteractionFix;

import org.bukkit.Bukkit;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.UUID;


public final class ArclightInteractionFix extends JavaPlugin implements Listener {

    private final HashSet<UUID> recentlyInteracted = new HashSet<>();
    private final HashSet<UUID> recentlyDropped = new HashSet<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        recentlyDropped.add(player.getUniqueId());

        Bukkit.getScheduler().runTaskLater(this, () -> recentlyDropped.remove(player.getUniqueId()), 1L);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        recentlyInteracted.add(event.getPlayer().getUniqueId());

        Bukkit.getScheduler().runTaskLater(this, () -> {
            recentlyInteracted.remove(event.getPlayer().getUniqueId());
        }, 2L);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onAnimation(PlayerAnimationEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        if (recentlyDropped.contains(playerId)) return;

        Bukkit.getScheduler().runTaskLater(this, () -> {
            if (!recentlyInteracted.contains(playerId)) {
                PlayerInteractEvent fakeEvent = new PlayerInteractEvent(
                        player,
                        Action.LEFT_CLICK_AIR,
                        player.getInventory().getItemInMainHand(),
                        null,
                        BlockFace.SELF,
                        EquipmentSlot.HAND
                );
                Bukkit.getPluginManager().callEvent(fakeEvent);
            }
        }, 1L);
    }
}
