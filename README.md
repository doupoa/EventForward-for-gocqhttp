# EventForward-for-gocqhttp
将spigot_mc服务器所捕获事件直接转发至go-cqhttp

此项目编译后可以直接运行，也可以在此基础上添加自己想要转发的事件

目前已支持转发的事件有：

1. 玩家聊天事件
2. 玩家登入游戏事件
3. 玩家登出游戏事件
4. 玩家死亡事件（含坐标）

以上功能按我服需要制作，已完全满足我服日常需要

# 运行方法：
编译前可预先定义目标Q群，或更改对应的请求方式。编译后即可直接运行。

若直接编译，使用时请先加载一次插件，待配置文件出现后配置相关参数，配置完重启服务器即可。

# go-cqhttp相关设置
请启动正向http服务。地址端口自行配置。

# 配置文件
输出后的配置文件可能会有中文乱码现象，在此贴出原配置文件。
```yaml

# Socket 服务器地址
url: '127.0.0.1'

# Socket 服务器端口
port: '5700'

# 目标Q群
group_id: '123456789'

#转发玩家聊天 - 游戏至外部
O_ChatEvent: true

# 玩家登入事件
PlayerLoginEvent: true

# 玩家登出事件
PlayerLogoutEvent: true

# 玩家死亡事件
PlayerDeadthEvent: true

```

# 相关链接
[go-cqhttp](https://github.com/Mrs4s/go-cqhttp)
