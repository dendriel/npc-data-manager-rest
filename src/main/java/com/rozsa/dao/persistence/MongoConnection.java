package com.rozsa.dao.persistence;

import com.mongodb.MongoClient;
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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.pojo.Conventions.ANNOTATION_CONVENTION;

@Service
public class MongoConnection implements DatabaseConnection {
    private final MongoClient client;

    private final MongoDatabase db;

    private final static String SEQUENCE_COLLECTION_NAME = "counters";

    public MongoConnection() {
        // TODO: inject connection parameters.
        String ip = "localhost";
        int port = 27017;
        String dbName = "the-quest";

        client = new MongoClient(ip, port);
        db = connect(dbName);
        createCountersCollection();
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

    private void createCountersCollection() {
//        Document document = new Document();
//        document.append("_id", "uniqueid");
//        document.append("seq", 1);

        SequenceCounter counter = new SequenceCounter();
        counter.setId("uniqueid");
        counter.setSeq(1);
        MongoCollection<SequenceCounter> coll = db.getCollection(SEQUENCE_COLLECTION_NAME, SequenceCounter.class);
        coll.insertOne(counter);
    }

    private class SequenceCounter {
        private String id;

        private long seq;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getSeq() {
            return seq;
        }

        public void setSeq(long seq) {
            this.seq = seq;
        }
    }

    public Object getNextSequence() {
        MongoCollection coll = db.getCollection(SEQUENCE_COLLECTION_NAME, SequenceCounter.class);
        Document searchQuery = new Document("_id", "uniqueid");
        Document increase = new Document("seq", 1);
        Document updateQuery = new Document("$inc", increase);
        SequenceCounter result = (SequenceCounter)coll.findOneAndUpdate(searchQuery, updateQuery);

        return result.getSeq();
    }

    public <T> void create(T obj, Class<T> kind, String collection) {
        System.out.println("Next sequence is: " + getNextSequence());
        assert obj != null : String.format("Can't save null obj!");
        MongoCollection<T> coll = db.getCollection(collection, kind);
        coll.insertOne(obj);
    }

    public <T extends Identifiable> void update(T obj, Class<T> kind, String collection) {
        assert obj != null : String.format("Can't update null obj!");
        MongoCollection<T> coll = db.getCollection(collection, kind);
        Document targetDoc = new Document("_id", obj.getObjectId());
        coll.replaceOne(targetDoc, obj);
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
