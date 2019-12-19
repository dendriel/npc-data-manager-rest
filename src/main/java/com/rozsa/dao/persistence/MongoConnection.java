package com.rozsa.dao.persistence;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.rozsa.dao.api.DatabaseConnection;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Service
public class MongoConnection implements DatabaseConnection {

    private final static String countersCollectionName = "counters";

    private final static String countersCollectionSequenceFieldName = "uid";

    private final MongoClient client;

    private final MongoDatabase db;

    public MongoConnection() {
        // TODO: inject connection parameters.
        String ip = "localhost";
        int port = 27017;
        String dbName = "the-quest";

        client = new MongoClient(ip, port);
        db = connect(dbName);
    }

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

        MongoDatabase plainDb = client.getDatabase(dbName);
        // using this approach to avoid losing the possibility to set the mongoDb server port.
        return plainDb.withCodecRegistry(pojoCodecRegistry);
    }

    private long getNextUniqueId() {
//        MongoCollection<Document> coll = db.getCollection(countersCollectionName);
//        Document targetDoc = new Document("_id", countersCollectionSequenceFieldName);


        // TODO:
        https://github.com/SouthGreenPlatform/mgdb/blob/master/src/fr/cirad/mgdb/model/mongo/maintypes/AutoIncrementCounter.java
        return 1;
    }

    public <T> T save(T obj, Class<T> kind, String collection) {
        assert obj != null : String.format("Can't save null obj!");
        MongoCollection<T> coll = db.getCollection(collection, kind);
        coll.insertOne(obj);

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
