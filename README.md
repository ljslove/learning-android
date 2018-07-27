# learning-android
learning android

Acitivity学习：
一。隐式Intent
可以使用Android内置的，也可以自己定义
（1）隐式Intent的过滤有action，category和data
默认的category必须添加到AndroidManifest文件中，不然Activity无法响应
（2）Android内置的Action可以到API中查看
（3）data还没有找到去哪里查看？
http表示启动浏览器
geo表示显示地理位置
del表示拨打电话

Broadcast:
SendBroadcast应用发送标准广播和有序广播
FirstReceiver应用：接收静态的默认广播，接收来自SendBroadcast的标准广播（动态）和有序广播（静态）
SecondReceiver应用：接收来自SendBroadcast的标准广播（动态）和有序广播（静态，并阻断广播）
ThirdReceiver应用：接收来自SendBroadcast的有序广播（静态），因为SecondBroadc将广播阻断，所以该应用接收不到广播

ContentProvider:
ContentProvider需要另外两个类：
SQLiteOpenHelper创建数据库和表
SQLiteDatabase对表进行增删改查等操作

