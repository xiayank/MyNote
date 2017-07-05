# SpringMVC

## POM
```xml

//using lots of "starter"
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.3.0.RELEASE</version>
</parent>
//<starter-parent> to manage whole spring boot

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
//<starter-web >

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
//<starter-data-jpa>

<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
//<data-rest>

<dependency>
   <groupId>org.springframework.data</groupId>
   <artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>
//<hal-broswer>show info of app

<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
//<mongodb database>

    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
    </dependency>
//memory database 

    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.16.12</version>
    </dependency>
//generate all the Get(), Set() method for bean or domain class
//using with @Data 

</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
   //fat jar, embedded tomcat
    </plugins>
</build>
```
## Annotation:
### Spring
```java
@SpringBootApplication
//mark this class as spring boot Application entrance
public static void main(String[] args) {
}
```
### Spring Data
```java
@Entity
@Table(name = "RUNNING_LOCATIONS")
public class Location {
}
//@Entity:transfer the class into a database table
//@Table: map this class to a specific table name
```
```java
@Id
@GeneratedValue
private Long id;
// auto generate Id
```
```java
@Embedded //put the attributes from embedded bean into this bean database
@AttributeOverride(name = "bandMake", column = @Column(name = "unit_band_maker"))
//override, in embeded bean, mapping "name" to a specific "column"
private  UnitInfo unitInfo;

@AttributeOverrides({
    @AttributeOverride()
    @AttributeOverride()
}) 
```
```java
Also need to put @Embeddable into the sub bean
@Embeddable
public class UnitInfo {
}
```
```java
在domain class里声明转换时，value = null的数据不要了
@Entity@JsonInclude(JsonInclude.Include.NON_NULL)
```
```java
@JsonCreator
public RunningInformationAnlysis(
        @JsonProperty("runningId") String runningId,
        @JsonProperty("latitude") String latitude,
        @JsonProperty("longtitude") String longitude,
        @JsonProperty("runningDistance") String runningDistance,
        @JsonProperty("totalRunningTime") String totalRunningTime,
        @JsonProperty("heartRate") String heartRate,
        @JsonProperty("timestamp") String timestamp,
        @JsonProperty("userInfo") UserInfo userInfo
){
    this.runningId = runningId;
    this.latitude = Double.parseDouble(latitude);
    this.runningDistance = Double.parseDouble(runningDistance);
    this.totalRunningTime = Double.parseDouble(totalRunningTime);
    this.timestamp = new Date();
}}
//@JsonCreator：根据Json数据利用Constructor创建object
//@JsonProperty：声明Json和obejct fiel的对应关系
```
```java
Lombok:
@Data 
//generate Get(), Set() method
@RequiredArgsConstructor
//define global variable, no change later.
//define final type variable
```
```java

```
```java

```
```
*Spring MVC*
从这个例子中，我们实际上已经归纳了构成基于SpringMVC应用程序的最基本要素。它们分别是： 
入口程序 —— DispatcherServlet
    提炼一个核心的Servlet覆盖对所有Http请求的处理 
核心配置 —— [servlet-name]-servlet.xml
控制逻辑 —— UserController
一个通用的Servlet响应程序大致应该包含的逻辑步骤： 
* 步骤1 —— 对Http请求进行初步处理，查找与之对应的Controller处理类（方法）
* 步骤2 —— 调用相应的Controller处理类（方法）完成业务逻辑
* 步骤3 —— 对Controller处理类（方法）调用时可能发生的异常进行处理
* 步骤4 —— 根据Controller处理类（方法）的调用结果，进行Http响应处理
* 在Java语言中，最适合表达逻辑处理语义的语法结构是接口，因此上述的四个流程也就被定义为了四个不同接口，它们分别是： 
* 结合之前我们对流程组件化的解释，这些接口的定义不正是处理流程组件化的步骤嘛？这些接口，就是组件。 
    * 步骤1 —— HandlerMapping
    * 步骤2 —— HandlerAdapter
    * 步骤3 —— HandlerExceptionResolver
    * 步骤4 —— ViewResolver
http://downpour.iteye.com/blog/1330596 
```




## not known

```java
  <dependecy>
      <groupId>com.googlecode.json-simple</groupId>
       <artifactId>json-simple</artifactId>     
           <version>1.1.1</version>
    </dependency>

Note:
public ResponseEntity<List<JSONObject>> findByHeartRateGreatThan(){

List<RunningInformationAnlysis> content = rawGreatThanList.getContent();
//rawGreatThanList is a Page obejct
List<JSONObject> results = new LinkedList<JSONObject>();
        for(RunningInformationAnlysis item: content){
          JSONObject info = new JSONObject();
          info.put(kFieldRuunningId, item.getRunningId());
    ........
    
    results.add(info);

        }
return new ResponseEntity<List<JSONObject>>(results, HttpStatus.OK)
}
```
```java
 List<RunningInformationAnlysis> rawList = 
        Collections.sort(rawList, new Comparator<RunningInformationAnlysis>() {
            @Override
            public int compare(RunningInformationAnlysis o1, RunningInformationAnlysis o2) {
                int x = o1.getHeartRate(), y = o2.getHeartRate();
                return  (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        });
```