package site.doupoa.EventForward.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import site.doupoa.EventForward.utils.GetRequest;

public class PlayerLoginEvent implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerJoin(AsyncPlayerPreLoginEvent event) { //玩家加入服务器事件
        GetRequest.addToList(event.getName()+"登入了游戏");
    }
}
