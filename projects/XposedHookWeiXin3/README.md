**本工程目标——通过本工程 click 事件来打开微信并获取微信附近的人信息**

<img src="image/nearby.png" width="280px" height="500px"/>

**本工程基于[微信7.0.4版本源码](../../docs/weixin_7.0.4_source)**

**思路分析:**

1. 通过Xposed hook 微信主界面 LauncherUI 并在 afterHookedMethod 方法内为当前activity注册一个广播；

2. 本工程click后发送一条广播；

3. LauncherUI 广播接收到广播消息后执行打开**附近的人**操作；

4. 根据微信逆向的代码找到**附近的人**的类相关方法并hook，从而获取到对应的附近人列表并保存；

**原理: 广播可以实现进程间通信**





