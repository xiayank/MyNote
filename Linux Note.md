# Linux Note

#### Environment Path:

```bash
open ~/.zshrc 
#open ~/.bash_profile
export PATH=/usr/local/bin:$PATH

#Note: “:” separate different path
```

#### Zshr

```bash
open ~/.zshrc 

环境变量

```


#### Install tar.gz file:
```bash
tar -xzf archive.tar.gz
cd archive
make
```

#### Maven to make Jar:
```bash
mvn clean install    
java -jar {classname}

#Tab:auto-complete
```
#### Back index search:
```bash
Ctrl+R
```


#### Change the port on maven server:
```bash
java -jar running-location-service-1.0.0.BUILD-SNAPSHOT.jar --server.port=9000

```



#### Execute .sh file

```bash
sh ./supply.sh

```


#### MongoDB

```bash
1.start mongo serve: mongod

2.Inter serve: mongo

3.kill: killall mongod

4.goto express folder: nodemon
```

#### Memcached

```
Key-Value: Value can be any type object.

1.start up Memcached:
memcached -d -p 11211
memcached -d -p 11218
memcached -d 
#default port:11211
#-d: 后台运行

2.shut down
ps aux | grep memcached 
pidof memcached
#two ways to 查看进程号
kill -9 'number'

3.telnet 127.0.0.1 11211 #进入memcached进行存储，取数据操作

4.Clear memcached:
echo 'flush_all' | nc localhost 11211

5.Methond
set #
add #如果key存在，则add无效

6.Feature - Distribute system
user just need to provide the memcached server IP, do not need to care where to save the data.
```

#### iTerm2

```bash
Ctrl + u        删除光标之前到行首的字符

```


#### Generate Code from Protocol Buffer(plugin gRPC)

```bash
/Users/NIC/Documents/GitHub_tools/protoc-3.3.0-osx-x86_64/bin/protoc  --plugin=protoc-gen-grpc-java=/Users/NIC/Documents/GitHub_tools/protoc-gen-grpc-java-1.3.0-osx-x86_64.exe  --grpc-java_out=/Users/NIC/Documents/504_BankEnd/DemoCode/week7_codelab2/SearchAdsRPC --java_out=/Users/NIC/Documents/504_BankEnd/DemoCode/week7_codelab2/SearchAdsRPC  --proto_path=/Users/NIC/Documents/504_BankEnd/DemoCode /Users/NIC/Documents/504_BankEnd/DemoCode/week7_codelab2/SearchAds.proto
#proto_path=up folder path [space] absolute path
```


#### Open Source Saftware Installl Path

```bash
1.Change name: 
mv spark-1.1-hoop spark

2.Move "spark" to path:
mv spark /usr/local
```

---
#### Mysql Access Denied -> Change username 
[Ref Link](https://stackoverflow.com/questions/10299148/mysql-error-1045-28000-access-denied-for-user-billlocalhost-using-passw)

Follow the steps below.

- Start the MySQL server instance or daemon with the --skip-grant-tables option (security setting).
```
$ mysqld --skip-grant-tables
```
- Execute these statements.
```
$ mysql -u root mysql
$ mysql> UPDATE user SET Password=PASSWORD('my_password') where USER='root';
$mysql> FLUSH PRIVILEGES;
```
If you face the unknown field Password error above use:
```
update user set authentication_string=password('my_password') where user='root';
```
- Finally, restart the instance/daemon without the --skip-grant-tables option.
```
sudo /usr/local/mysql/support-files/mysql.server restart
```
You should now be able to connect with your new password.
```
$ mysql -u root -p
Enter password: my_password

``` 
---
### Remove MySQL completely

1. Open the Terminal
2. Use `mysqldump` to backup your databases
3. Check for MySQL processes with: `ps -ax | grep mysql`
4. Stop and kill any MySQL processes
5. Analyze MySQL on HomeBrew: 
        
    ```
    brew remove mysql
    brew cleanup
    ```

6. Remove files: 

    ```
    sudo rm /usr/local/mysql
    sudo rm -rf /usr/local/var/mysql
    sudo rm -rf /usr/local/mysql*
    sudo rm ~/Library/LaunchAgents/homebrew.mxcl.mysql.plist
    sudo rm -rf /Library/StartupItems/MySQLCOM
    sudo rm -rf /Library/PreferencePanes/My*
    ```

7. Unload previous MySQL Auto-Login: 
        
    ```
    launchctl unload -w ~/Library/LaunchAgents/homebrew.mxcl.mysql.plist
    ```
        
8. Remove previous MySQL Configuration: 

    ```
    subl /etc/hostconfig` 
    # Remove the line MYSQLCOM=-YES-
    ```
        
9. Remove previous MySQL Preferences: 
    
    ```
    rm -rf ~/Library/PreferencePanes/My*
    sudo rm -rf /Library/Receipts/mysql*
    sudo rm -rf /Library/Receipts/MySQL*
    sudo rm -rf /private/var/db/receipts/*mysql*
    ```
    
10. Restart your computer just to ensure any MySQL processes are killed

---
### Install MySQL on macOS Sierra

Enter the following command : `$ brew info mysql`  
Expected output: **mysql: stable 5.7.15 (bottled)**

To install MySQL enter : `$ brew install mysql`
Then `mysql.server start`

---

### Change Password in MySQL

　1. 命令
```bash
　　 usr/bin/mysqladmin -u root password 'new-password'
　　 格式：mysqladmin -u用户名 -p旧密码 password 新密码
```
　2. 例子
　　 例1：给root加个密码123456。
　　 键入以下命令 ：
　　 ```  /usr/bin/mysqladmin -u root password 123456```
　　 注：因为开始时root没有密码，所以-p旧密码一项就可以省略了。
3. 增加了密码后的登录格式如下：
　　 mysql -u root -p
　　 Enter password: (你自己设的密码)

---

#### 增加权限

```bash
chmod 777 "fileName"
[enter link description here](dd)
```


#### File management 

```bash
1. Check File lines number: 
   wc -l "fileName"
   
2. Split File:
   cat "originalFile.txt" |head -n 5000 > "newFileName.txt" 
   #First 5000 lines
   cat "originalFile.txt" |tail -n 5000 > "newFileName.txt" 
   #Last 5000 lines
```


#### Redis

```bash
redis-serber -daemonize yes
pidof redis

redis-cli ping : check status

```


#### Rabbit MQ
1. Startup MQ server 
`rabbitmq-server start` or `brew services start rabbitmq`
2. Stop               
`rabbitmq-server stop` or `brew services stop rabbitmq`
3. Login :

```  
  http://127.0.0.1:15672/ 
  username: guest   
  psw: guest
```
4. ERROR:
```
ERROR: "node with name "rabbit" already running"
```

   `rabbitmqctl stop `
[Reference](https://stackoverflow.com/questions/8737754/node-with-name-rabbit-already-running-but-also-unable-to-connect-to-node?rq=1) 

---

[RabbitMQ传递对象-序列化](http://blog.csdn.net/btwangzhi/article/details/55001348)
```java
1. Producer
ConnectionFactory connFactory=new ConnectionFactory();
 //设置服务器位置
 connFactory.setHost("localhost");
//设置服务器端口号
//connFactory.setPort(5672);
//创建连接
Connection con=connFactory.newConnection();
//创建channel
Channel channel=con.createChannel();
 //设置队列的属性第一个参数为队列名。第二个参数为是否创建一个持久队列，第三个是否创建一个专用的队列，
//第四个参数为是否自动删除队列，第五个参数为其他属性（结构参数）
channel.queueDeclare(QUEUE_NAME, false, false, false, null);
channel.basicPublish("",QUEUE_NAME,null,SerializationUtils.serialize(user));
channel.close();
con.close();

2. Comsumer
ConnectionFactory connFactory=new ConnectionFactory();

//设置服务器位置
connFactory.setHost("localhost");
//设置端口号
//connFactory.setPort(15672);
//连接登录用户名
//connFactory.setPassword("guest");
//连接登录密码
//connFactory.setUsername("guest");
//创建连接
Connection con=connFactory.newConnection();
//创建channel
Channel channel=con.createChannel();
//设置队列的属性第一个参数为队列名。第二个参数为是否创建一个持久队列，第三个是否创建一个专用的队列，
//第四个参数为是否自动删除队列，第五个参数为其他属性（结构参数）
channel.queueDeclare(QUEUE_NAME, false, false, false, null);
Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,AMQP.BasicProperties properties, byte[] body)
throws IOException {
                Product product = (Product) SerializationUtils.deserialize(body);
//consumer 不需要close，override callback function就行

```

#### Related Path

```bash
G:\site\other\index.htm
G:\site\web\article\01.htm
```
`G:\site\other`是源文件的目录
01.htm要想链接到index.htm这个文件，在01.htm文件里面应该写上这句：
`../../other/index.htm`
这里的 ../ 表示向上一级。

#### 

```bash


```

#### 

```bash


```

#### 

```bash


```

#### 

```bash


```

#### 

```bash


```

#### 

```bash


```

