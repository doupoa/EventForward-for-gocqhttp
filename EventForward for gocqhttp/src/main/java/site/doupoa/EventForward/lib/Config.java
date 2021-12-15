package site.doupoa.EventForward.lib;

import site.doupoa.EventForward.EventForward;


public class Config {
    public static String url = "127.0.0.1";
    public static String port = "2333";
    public static String group_id = "123456789";
//    public static Boolean I_ChatEvent = false;
    public static Boolean O_ChatEvent = true;
    public static Boolean PlayerLoginEvent = true;
    public static Boolean PlayerLogoutEvent = true;
    public static Boolean PlayerDeadthEvent = true;

    public static void loadConfig(){
        EventForward.plugin.saveDefaultConfig();
        EventForward.plugin.reloadConfig();

        setValue();
    }

    private static String getString(String path) {
        return EventForward.plugin.getConfig().getString(path);
    }

    private static Boolean getBoolean(String path) {
        return EventForward.plugin.getConfig().getBoolean(path);
    }

    public static void setValue() {
        url = getString("url");
        port = getString("port");
        group_id = getString("group_id");
//        I_ChatEvent = getBoolean("I_ChatEvent");
        O_ChatEvent = getBoolean("O_ChatEvent");
        PlayerLoginEvent = getBoolean("PlayerLoginEvent");
        PlayerLogoutEvent = getBoolean("PlayerLogoutEvent");
        PlayerDeadthEvent = getBoolean("PlayerDeadthEvent");
    }
}
