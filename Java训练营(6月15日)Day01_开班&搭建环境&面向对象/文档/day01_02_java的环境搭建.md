# JDK下载与安装

## 一、JDK下载步骤

- Java已经被Oracle收购，进入Oracle官网下载

![](img/2019050701.png)

![](img/2019050702.png)

![](img/2019050703.png)

![](img/2019050704.png)

![](img/2019050705.png)

![](img/2019050706.png)

## 二、安装之后目录

![](img/2019050707.png)

![](img/2019050708.png)

## 三、配置环境变量

![](img/2019050709.png)

![](img/20190507010.png)



```
我的电脑 --> 页面空白处，鼠标右键 --> 属性
--> 左侧边栏 高级系统设置 --> 环境变量


新建：
变量名:JAVA_HOME
变量值:D:\Program Files\Java\jdk1.8.0_211
		就是jdk的安装目录

新建:
变量名:CLASSPATH
变量值:.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar

修改:
变量名:path
添加内容:
	;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;
```



![JAVA_HOME](img\JAVA_HOME.png)

![CLASS_PATH](img\CLASS_PATH.png)



![PATH修改](img\PATH修改.png)



## 四、测试是否安装成功

打开终端：

方法一：开始|Windows系统|命令提示符

方法二：搜索框里直接搜索：命令提示符或者cmd

方法三：快捷键：win+R键，然后输入cmd



![](img/20190507011.png)

![](img/20190507012.png)

