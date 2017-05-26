# SpringMVC

## POM
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
 List<RunningInformationAnlysis> rawList = 
        Collections.sort(rawList, new Comparator<RunningInformationAnlysis>() {
            @Override
            public int compare(RunningInformationAnlysis o1, RunningInformationAnlysis o2) {
                int x = o1.getHeartRate(), y = o2.getHeartRate();
                return  (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        });
