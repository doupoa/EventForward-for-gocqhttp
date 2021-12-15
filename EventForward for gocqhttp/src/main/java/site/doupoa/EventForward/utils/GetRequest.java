package site.doupoa.EventForward.utils;
import org.bukkit.scheduler.BukkitRunnable;
import site.doupoa.EventForward.EventForward;
import site.doupoa.EventForward.lib.Config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GetRequest {
    public static Queue<String> queue;
    public static void linkedList() {
        queue = new LinkedList<>(); //创建消息队列
    }

    private static String sendGet(String message) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = "http://"+Config.url + ":" + Config.port + "/send_group_msg?group_id=" + Config.group_id + "&message=" + URLEncoder.encode(message,"UTF-8");
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.55 Safari/537.36 Edg/96.0.1054.43");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    public static void LoadQueue() { //创建列表并开始监控
        if (EventForward.plugin != null) {
            linkedList();//创建消息队列
            new BukkitRunnable() {
                @Override
                public void run() {
                    try {
                        if (queue.peek() != null) { //如果列表不为空
                            String re = sendGet(queue.poll());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.runTaskTimer(EventForward.plugin, 0L, 20L * 2); // 两秒检查一次列表
        }
    }

    public static void addToList(String text){ //添加已经实例化的json数据到队列
        if(text != null){
            queue.offer(text);
        }
    }
}



