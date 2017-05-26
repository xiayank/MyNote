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
//inject LocationRepository 的实例public LocationServiceImpl(LocationRepository locationRepository){
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
<Location> findByMovementTpye(@PathVariable String movementType,
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





