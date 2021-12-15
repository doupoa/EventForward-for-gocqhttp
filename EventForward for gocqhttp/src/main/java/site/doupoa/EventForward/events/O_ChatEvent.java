package site.doupoa.EventForward.events;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import site.doupoa.EventForward.utils.GetRequest;

//此文件用于处理玩家聊天事件
public class O_ChatEvent implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerSay(AsyncPlayerChatEvent event) { //玩家聊天事件
        Player p = event.getPlayer();
        GetRequest.addToList(p.getName() + "说：" + event.getMessage());
    }
}


