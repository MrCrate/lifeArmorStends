package ru.mrc.dev;

import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeArmorStend extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof ArmorStand) {
            ArmorStand armorStand = (ArmorStand) event.getEntity();

            if (isArmorStandPlacementDenied(armorStand)) {
                event.setCancelled(true);
            }
        }
    }

    private boolean isArmorStandPlacementDenied(ArmorStand armorStand) {
        // Примеры условий, при которых запрещается установка стойки для брони

        // Пример 1: Запрещаем установку стоек для брони в определенной области мира
        if (armorStand.getLocation().getBlockY() < 64) {
            return true;
        }

        // Пример 2: Запрещаем установку стоек для брони с определенным именем
        if (armorStand.getCustomName() != null && armorStand.getCustomName().equalsIgnoreCase("NoArmorStand")) {
            return true;
        }
        return true;
    }

}
