# npc-data-manager-rest
Spring framework crud-based backend using mongo-db. Features:

- POJO based mongo interaction - we don't need to map each field from an object when writing
or reading from mongo. MongoConnection class abstracts this parsing and is generic;
- Easy to write DAOs - just extend AbstractDao<T> passing the target collection and dto class for read/writes;
- Easy to write controllers with default actions - extend BaseController<T> to provide get, 
getAll, getById, save and delete;
- Import and export infra (ImportHolder, JsonReader and JsonWriter) so we can boot the dataset if
there is any available external data source;
- JWT authentication (user: foo; pass: foo).


# VM Options

- DB_HOST - mongo ip (optional - default is localhost);
- DB_PORT - mongo port (optional - default is 27017);
- DB_NAME - target mongo schema;
- DB_USER - username for authentication;
- DB_PASS - password for authentication.

Ex.:
```
-DDB_HOST=localhost
-DDB_PORT=27017
-DDB_NAME=the-quest
-DDB_USER=root
-DDB_PASS=pass
```

# Standalone executable JAR building:

```
$ mvn clean package
$ java -jar target/npc-data-manager-rest-1.0-SNAPSHOT.jar
```

# Docker image building

Build:
```
$ docker build -t npc-data-manager .
```

Run:

```
$ docker run -p 8080:8080 npc-datamanager
```

Access at: ``localhost:8080/model/action``

Example: ``http://localhost:8080/item/getAll``

# Booting up the whole solution (front + back + database)

Use docker-compose to boot-up everything:

```
$ docker-compose up
```

Use the following to make sure all images are updated:
```
$ docker-compose pull
```

To clear up everything (including the volume used by the database):

```
$ docker-compose stop; docker-compose rm ; docker volume rm npc-data-manager-rest_mongodb_data
```

*Obs.: the compose solutions uses already built images from dockerhub. If we update the npc-data-manager-rest
code, we have to commit/push the changes so a new image can be built from it. (or update the compose to build
the backend image from the project instead of downloading it).

# TODO

- Load user details from database;
- Encrypt password.
