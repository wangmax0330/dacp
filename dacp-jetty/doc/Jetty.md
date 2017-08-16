
#Jetty 

###jetty  安装
* 配置JETTY_HOME
* 执行start.jar
```bash
Administrator@W7GFA5T7SFGRBNY MINGW64 /d/Protable/jetty-distribution-9.3.12.v20160915
$ java -jar start.jar
2016-10-18 10:59:18.626:INFO::main: Logging initialized @2259ms
2016-10-18 10:59:18.817:WARN:oejs.HomeBaseWarning:main: This instance of Jetty is not running from a separate {jetty.base} directory, this is not recommended.  See documentation at http://www.eclipse.org/jetty/documentation/current/startup.html
2016-10-18 10:59:19.067:INFO:oejs.Server:main: jetty-9.3.12.v20160915
2016-10-18 10:59:19.088:INFO:oejdp.ScanningAppProvider:main: Deployment monitor [file:///D:/Protable/jetty-distribution-9.3.12.v20160915/webapps/] at interval 1
2016-10-18 10:59:19.233:INFO:oejs.AbstractConnector:main: Started ServerConnector@17f4da92{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
2016-10-18 10:59:19.234:INFO:oejs.Server:main: Started @2867ms
```

###配置jetty 



###HTTPS 启动
```bash
Administrator@W7GFA5T7SFGRBNY MINGW64 /d/Protable/jetty-distribution-9.3.12.v20160915/webapps
$ java -jar ../start.jar jetty.port=8081  --add-to-startd=https
INFO: server          initialised (transitively) in ${jetty.base}\start.d\server.ini
INFO: ssl             initialised (transitively) in ${jetty.base}\start.d\ssl.ini
INFO: https           initialised in ${jetty.base}\start.d\https.ini
DOWNLOAD: https://raw.githubusercontent.com/eclipse/jetty.project/master/jetty-server/src/test/config/etc/keystore?id=master to ${jetty.base}\etc\keystore
INFO: Base directory was modified

Administrator@W7GFA5T7SFGRBNY MINGW64 /d/Protable/jetty-distribution-9.3.12.v20160915/webapps
$ java -jar ../start.jar jetty.port=8081
```
--add-to-startd执行如下操作：
1. 创建https.ini文件激活和配置https连接器模块。https模块增加etc/jetty-https.xml文件到命令行中。
2. 创建start.d/ssl.ini文件激活和配置SSL keystore。ssl模块增加etc/jetty-ssl.xml文件到命令行。
3. 检查etc/keystore文件是否存在，如果不存在，则下载一个示范keystore文件。



###jetty目录结构如下:
* etc:该路径用于存放Jetty的配置文件
* examples:该路径用于存放Jetty的示例
* legal:该路径用于存放该项目的Lisence信息
* lib:该路径用于存放运行Jetty必需的J缸文件
* modules:该路径用于存放Jetty的模块，包括API文档
* patches:包含一些补丁说明
* pom.xm1:是Jetty的build文件，该文件不是Ant的build文件，而是mavaen2的build文件
* project-site:包含Jetty的网站的必需的样式文件
* readme.txt:包含最基本的使用信息
* start.jar:启动Jetty的启动文件
* version.txt:Jetty版本更新日志的简单版本
* webapps: 该路径用于存放自动部署的 Web 应用，只要将用户的 Web 应用复制到该路径下， Web 应用将自动部署
* webapps-plus: 存放一些用于演示 Jetty 扩展属性的 Web 应用，该路径下的 Web应用也可自动部署
* start.ini (线程数设置)  和start.d目录下的*.ini(http.ini中设置http端口、超时时间)一起构成start.jar的启动参数

###jetty  常用命令
1. 启动Jetty Server：运行命令：Java -jar start.jar。

2. 为了保证关闭服务的安全，可以设置密码，启动命令：java -DSTOP.PORT=8081 -DSTOP.KEY=123 -jar start.jar，这样Jetty会在启动后监听端口8081，并在下次关闭前验证密码（Key），如果密码一致，则关闭jetty服务，这样保证了服务的安全。可以开另一个窗口，输入关闭命令：java -DSTOP.PORT=8081 -DSTOP.KEY=123 -jar start.jar --stop 
3. {JETTY_HOME}/bin目录下，输入命令：./jetty.sh start启动项目，也可以通过./jetty.sh stop关闭，也可以./jetty.sh restart进行重启

###基本配置

* 修改Jetty的端口

Jetty默认使用8080端口，要让它使用其他端口（如7070），那么编辑start.d（Wondows系统是start.ini文件），找到jetty.http.port行，修改为：
```
 Connector port to listen on
jetty.http.port=7070
```
保存并退出，再重启Jetty。
*  修改webapps目录

Jetty下的webapps是默认的Web项目的部署目录，如果想修改此目录，可修改start.d配置文件（start.ini），移除以下行的注释符号“#”
```
# jetty.deploy.monitoredDir=webapps
```
并把内容修改到你指定的目录。保存并退出，再重启Jetty。