package metroanarchyserver.anarchy;

import metroanarchyserver.anarchy.handler.LoginEventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class metroanarchy extends JavaPlugin implements Listener {

    Logger log = getLogger();

    @Override
    public void onEnable() {

        log.info("MetroAnarchy plugin has been enabled!");
        getServer().getPluginManager().registerEvents(new LoginEventHandler(), this);

    }

    @Override
    public void onDisable() {

        log.info("MetroAnarchy plugin has been disabled!");

    }
}