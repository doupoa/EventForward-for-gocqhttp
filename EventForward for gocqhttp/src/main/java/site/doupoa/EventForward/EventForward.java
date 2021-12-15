
package site.doupoa.EventForward;
//包

import org.bukkit.plugin.java.JavaPlugin;
import site.doupoa.EventForward.events.O_ChatEvent;
import site.doupoa.EventForward.events.PlayerDeadEvent;
import site.doupoa.EventForward.events.PlayerLoginEvent;
import site.doupoa.EventForward.events.PlayerLogoutEvent;
import site.doupoa.EventForward.lib.Config;
import site.doupoa.EventForward.utils.GetRequest;


public final class EventForward extends JavaPlugin{
    public static EventForward plugin;
    @Override
    public void onEnable() {
        // 插件加载事件
        plugin = this;
        Config.loadConfig();//加载配置项
        GetRequest.LoadQueue(); //创建列表并开始监控

        if(Config.O_ChatEvent){ //注册玩家聊天事件监听器
            getServer().getPluginManager().registerEvents(new O_ChatEvent(), this);
        }

        if(Config.PlayerLoginEvent){ //注册玩家登入事件监听器
            getServer().getPluginManager().registerEvents(new PlayerLoginEvent(), this);
        }

        if(Config.PlayerLogoutEvent){ //注册玩家登出事件监听器
            getServer().getPluginManager().registerEvents(new PlayerLogoutEvent(), this);
        }

        if (Config.PlayerDeadthEvent) {
            getServer().getPluginManager().registerEvents(new PlayerDeadEvent(),this);
        }
        getLogger().info("EventForward加载完成");
    }

    @Override
    public void onDisable() {
        //插件卸载事件
        getLogger().info("EventForward卸载完成");
    }

}