# Kotlin + MyBatis + SpringBoot

A simple example to use Kotlin and MyBatis with SpringBoot

## Notes
* This example uses a in-memory database H2
* Please use at least Java 8  

## 

## Create executable

`mvn clean package`

## Execute
`java -jar target/kbatis-0.0.1-SNAPSHOT.jar`

## Test

```
curl localhost:8080/articles`
##########
[
  {
    "id": 1,
    "title": "Given a try to Kotlin+MyBatis",
    "author": "@fagonerx"
  }
]
```
## Demo data
You can modify the demo data on the file: 

`src/main/resources/sql/data.sql`

