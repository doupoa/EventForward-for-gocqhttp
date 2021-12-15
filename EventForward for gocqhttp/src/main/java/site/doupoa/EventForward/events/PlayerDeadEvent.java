package site.doupoa.EventForward.events;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import site.doupoa.EventForward.utils.GetRequest;

public class PlayerDeadEvent implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event){
        String msg = event.getDeathMessage();
        Player entity = event.getEntity();
        Location location = entity.getLocation();
        int x = (int) location.getX();
        int y = (int) location.getY();
        int z = (int) location.getZ();
        GetRequest.addToList(msg + " - ["+x+","+y+","+z+"]");
    }
}
