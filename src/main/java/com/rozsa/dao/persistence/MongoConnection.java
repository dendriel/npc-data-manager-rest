package com.rozsa.dao.persistence;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.dao.api.Identifiable;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.*;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@Service
public class MongoConnection implements DatabaseConnection {
    private static final String LOCALHOST_IP = "localhost";
    private static final Integer DEFAULT_MONGO_PORT = 27017;

    private final MongoClient client;
    private final MongoDatabase db;

    public MongoConnection(
            @Value("${DB_HOST:}") String host,
            @Value("${DB_PORT:}") Integer port,
            @Value("${DB_NAME:}") String dbName,
            @Value("${DB_USER:}") String user,
            @Value("${DB_PASS:}") String pass
    ) {
        assert dbName != null : "DB_NAME option must be non-empty (ex.: -DDB_NAME=database-name)";

        client = createClient(host, port, user, pass, dbName);
        db = connect(dbName);
    }

    private MongoClient createClient(String host, Integer port, String user, String pass, String dbName) {
        if (host.isEmpty()) {
            host = LOCALHOST_IP;
        }

        if (port == null) {
            port = DEFAULT_MONGO_PORT;
        }

        MongoClientOptions options = MongoClientOptions.builder()
                .writeConcern(WriteConcern.JOURNALED) // Write operations wait for the server to group commit to the journal file on disk.
                .build();

        ServerAddress serverAddress = new ServerAddress(host, port);

        if (user.isEmpty() && pass.isEmpty()) {
            return new MongoClient(serverAddress, options);
        }
        else {
            MongoCredential mongoCredential = MongoCredential.createCredential(user, dbName, pass.toCharArray());
            return new MongoClient(serverAddress, mongoCredential, options);
        }

        // Connect by using a URI.
//        return new MongoClient(
//                new MongoClientURI( "mongodb://root:pass@localhost:27017/?authSource=npc_data" )
//        );
    }

    // http://mongodb.github.io/mongo-java-driver/3.6/bson/codecs/
    private MongoDatabase connect(String dbName) {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                fromProviders(
                        PojoCodecProvider
                                .builder()
                                .automatic(true)
                                .build()
                )
        );
        //PojoCodecProvider.builder().conventions(asList(ANNOTATION_CONVENTION)).automatic(true).build();

        MongoDatabase plainDb = client.getDatabase(dbName);
        // using this approach to avoid losing the possibility to set the mongoDb server port.
        return plainDb.withCodecRegistry(pojoCodecRegistry);
    }

    public <T> T create(T obj, Class<T> kind, String collection) {
        assert obj != null : String.format("Can't save null obj!");
        MongoCollection<T> coll = db.getCollection(collection, kind);
        coll.insertOne(obj);
        return obj;
    }

    public <T extends Identifiable> T update(T obj, Class<T> kind, String collection) {
        assert obj != null : String.format("Can't update null obj!");
        MongoCollection<T> coll = db.getCollection(collection, kind);
        Document targetDoc = new Document("_id", obj.getObjectId());
        coll.replaceOne(targetDoc, obj);
        return obj;
    }

    public <T> T findById(ObjectId id, Class<T> kind, String collection) {
        MongoCollection<T> coll = db.getCollection(collection, kind);
        Document targetDoc = new Document("_id", id);
        FindIterable<T> iterDoc = coll.find(targetDoc);

        return iterDoc.first();
    }

    public <T> List<T> findAll(Class<T> kind, String collection) {
        MongoCollection<T> coll = db.getCollection(collection, kind);
        FindIterable<T> iterDoc = coll.find();
        List<T> objs = new ArrayList<>();
        iterDoc.into(objs);

        return objs;
    }

    public <T> boolean deleteById(ObjectId id, Class<T> kind, String collection) {
        MongoCollection<T> coll = db.getCollection(collection, kind);
        Document targetDoc = new Document("_id", id);
        DeleteResult result = coll.deleteOne(targetDoc);

        return result.getDeletedCount() > 0;
    }
}
