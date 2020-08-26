# npc-data-manager-rest
Spring framework crud-based backend using mongo-db. Features:

- POJO based mongo interaction - we don't need to map each field from an object when writing
or reading from mongo. MongoConnection class abstracts this parsing and is generic;
- Easy to write DAOs - just extend AbstractDao<T> passing the target collection and dto class for read/writes;
- Easy to write controllers with default actions - extend BaseController<T> to provide get, 
getAll, getById, save and delete;
- Import and export infra (ImportHolder, JsonReader and JsonWriter) so we can boot the dataset if
there is any available external data source.


# VM Options

- DB_HOST = mongo address "ip:port";
- DB_SCHEMA = target mongo schema.

Ex.:
```
-DDB_HOST=localhost:27017
-DDB_SCHEMA=the-quest
```

# Standalone executable JAR building:

```
$ mvn clean package
$ java -jar target/npc-data-manager-rest-1.0-SNAPSHOT.jar
```
