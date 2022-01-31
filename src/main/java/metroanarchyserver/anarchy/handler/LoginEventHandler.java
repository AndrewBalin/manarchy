package metroanarchyserver.anarchy.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginEventHandler implements Listener {


    @EventHandler
    public void handleJoinEvent(PlayerJoinEvent event) {
        DatabaseHandler db = new DatabaseHandler();
        Player player = event.getPlayer();
        String nick = player.getName();

        ResultSet result =  db.checkLoginUser(nick);
        try {
            result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (result.getString("nick") != null) {
                try {
                    String pass = result.getString("password");
                } catch (SQLException e) {
                    e.printStackTrace();
                    player.sendMessage("§l§f[§aMetroAnarchyLogin§f] " + "§rТы ещё не зарегестрирован!?, скорее присоединяйся к нам! §o***§n§3http://t.me/MetroAnarhyBot§r§o***");
                }
                    player.sendMessage("§l§f[§aMetroAnarchyLogin§f] " + "§rВойди в аккаунт (§b/login <§3код подтверждения§b>§r)");
                    player.sendMessage("§l§f[§aMetroAnarchyLogin§f] " + "§rКод подтверждения отправлен ботом, проверь соцсети!");
                }

            else {
                player.sendMessage("§l§f[§aMetroAnarchyLogin§f] " + "§rТы ещё не зарегестрирован!?, скорее присоединяйся к нам! §o***§n§3http://t.me/MetroAnarhyBot§r§o***");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            player.sendMessage("§l§f[§aMetroAnarchyLogin§f] " + "§rТы ещё не зарегестрирован!?, скорее присоединяйся к нам! §o***§n§3http://t.me/MetroAnarhyBot§r§o***");
        }


    }


}

