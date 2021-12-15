package site.doupoa.EventForward.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import site.doupoa.EventForward.utils.GetRequest;

public class PlayerLogoutEvent implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) { //玩家离开服务器事件
        Player p = event.getPlayer();
        GetRequest.addToList(ChatColor.stripColor(p.getName().trim())+"登出了游戏");
    }

}
