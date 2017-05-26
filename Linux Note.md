# Linux Note

#### Environment Path:

```bash
open ~/.zshrc 
#open ~/.bash_profile
export PATH=/usr/local/bin:$PATH

#Note: “:” separate different path
```
-----------
#### Zshr

```bash
open ~/.zshrc 

环境变量

```
-----------

#### Install tar.gz file:
```bash
tar -xzf archive.tar.gz
cd archive
make
```
-----------
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
-----------

#### Change the port on maven server:
```bash
java -jar running-location-service-1.0.0.BUILD-SNAPSHOT.jar --server.port=9000

```
-----------


#### Execute .sh file

```bash
sh ./supply.sh

```
-----------

#### MongoDB

```bash
1.start mongo serve: mongod

2.Inter serve: mongo

3.kill: killall mongod

4.goto express folder: nodemon
```
-----------
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
-----------
#### iTerm2

```bash
Ctrl + u        删除光标之前到行首的字符

```
-----------

#### Generate Code from Protocol Buffer(plugin gRPC)

```bash
/Users/NIC/Documents/GitHub_tools/protoc-3.3.0-osx-x86_64/bin/protoc  --plugin=protoc-gen-grpc-java=/Users/NIC/Documents/GitHub_tools/protoc-gen-grpc-java-1.3.0-osx-x86_64.exe  --grpc-java_out=/Users/NIC/Documents/504_BankEnd/DemoCode/week7_codelab2/SearchAdsRPC --java_out=/Users/NIC/Documents/504_BankEnd/DemoCode/week7_codelab2/SearchAdsRPC  --proto_path=/Users/NIC/Documents/504_BankEnd/DemoCode /Users/NIC/Documents/504_BankEnd/DemoCode/week7_codelab2/SearchAds.proto
#proto_path=up folder path [space] absolute path
```
-----------

#### Open Source Saftware Installl Path

```bash
1.Change name: 
mv spark-1.1-hoop spark

2.Move "spark" to path:
mv spark /usr/local
```
-----------

#### Mysql Access Denied -> Change username 


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
-----------

#### 增加权限

```bash
chmod 777 "fileName"
[enter link description here](dd)
```
-----------

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
-----------


