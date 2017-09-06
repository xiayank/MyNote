# Web开发笔记

### Two ways to inject:
#### In class LocationServiceImpl

1. simple way:
```java
Autowired
private LocationRepository locationRepository;
```
2. Constructor way:
```java
private LocationRepository locationRepository;

@Autowired 
//inject LocationRepository 的实例
public LocationServiceImpl(LocationRepository locationRepository){
    this.locationRepository = locationRepository;
}
//So I think in this way we can make sure that the LocationServiceImpl class will have the depency Repository class, since it is in Constructor method.
```
---------
### Page的使用方法：
```java
//在Repository里面定义的方法，返回Page
@RequestMapping(value = "/running/{movementType}", method = RequestMethod.GET)
public Page
<Location> findByMovementTpye(
	@PathVariable String movementType,
	@RequestParam(name = "page",required = false)int page,
    @RequestParam(name = "size",required = false)int size){

return 
locationSevice.findByRunnerMovementType(movementType,new PageRequest(page, size));
}
//new一个PageRequest 传进去page和size
//URL: localhost:8080/running/stopped?page=0size=2
```
#### domain class里面写constructor
```java
@JsonCreator 
public Location(@JsonProperty("runningId") String  runningId){
    this.unitInfo = new UnitInfo(runningId);
}
//在从JSON String转成object的时候，如果发现runningId的话，就用这个方法来创建Location object.
```
#### Get URL
>http://localhost:9000/heartRateGreatThan/70?page=0&size=10

#### How to sort a List based on a field in Object

```java
Collections.sort(modifiableList, (o1, o2) -> o1.getHeartRate() - o2.getHeartRate());
```
#### JPA to write find all by xx
```java
public interface StudentDAO extends JpaRepository<StudentEntity, Integer>
{
    public List<StudentEntity> findAllByOrderByIdAsc();
}
```

#### Sort A List base on a field in the object
```java
Collections.sort(modifiableList, (o1, o2) -> o1.getHeartRate() - o2.getHeartRate());
```

#### Create a maven web app from scratch
Create dir `Java` in main, make it as source content.
[Reference](https://www.jetbrains.com/help/idea/2017.1/configuring-content-roots.html)

#### Maven jetty web config
##### Web.xml
```xml
<servlet>
    <servlet-name>MonitorServlet</servlet-name>
    <servlet-class>MonitorServlet</servlet-class>
  </servlet>

  <servlet-mapping> 
    <servlet-name>MonitorServlet</servlet-name>
    <url-pattern>/Monitor</url-pattern>
    <!--url-pattern: is the url we need input -->
  </servlet-mapping>
```
##### POM.xml
```xml
<plugin>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-maven-plugin</artifactId>
        <version>9.3.19.v20170502</version>

        <configuration>
          <scanIntervalSeconds>10</scanIntervalSeconds>
          <webApp>
            <contextPath>/Amazon-Price-Monitor</contextPath>
          </webApp>
        </configuration>
      </plugin>
```

`Fianl url: localhost:8080/Amazon-Price-Monitor/Monitor`

----
#### ScheduledExecutorService

```bash
http://tutorials.jenkov.com/java-util-concurrent/scheduledexecutorservice.html
```
#### Intellij导入clone的project

```bash
New project from exist source
如果是multi-module，选上。

```
### Error Collection
#### Spring-boot 启动时碰到的Your ApplicationContext is unlikely to start due to a @ComponentScan of the default package错误

```bash
查了半天终于才stack overflow上看到了解决方案，链接如下：stack overflow 
是因为application.java 文件不能直接放在main/java文件夹下，必须要建一个包把他放进去

```
#### Could not autowire. No beans of 'RestaurantService' type found.


> Service implementation class does not have `@Service` annotation


#### intellij 打开工程在每个java文件上 有个红色的无效符

```bash
说明该类不是可编译文件。在project Structure中（快捷键ctrl+alt+shift+s）选Modules将你带红圈的文件添加上，将你带红圈的文件夹设为Sources。一般是src文件夹，点Sources文件夹，然后点击OK。设置为可编译文件再去工程中看就没红圈了。
```



