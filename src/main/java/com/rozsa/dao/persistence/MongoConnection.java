package com.rozsa.dao.persistence;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.model.Npc;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Service;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Service
public class MongoConnection implements DatabaseConnection {
    private final MongoClient client;
    private final MongoDatabase db;

    public MongoConnection() {
        // TODO: inject connection parameters.
        String ip = "localhost";
        int port = 27017;
        String dbName = "the-quest";

        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                fromProviders(
                        PojoCodecProvider
                                .builder()
                                .automatic(true)
                                .build()
                )
        );

        // can't set port while using options?
//        MongoClientOptions options = MongoClientOptions
//                .builder()
//                .codecRegistry(pojoCodecRegistry)
//                .build();
//
//        client = new MongoClient(ip, options);
        client = new MongoClient(ip, port);

        // ? is this necessary?
//        MongoCredential credential;
//        credential = MongoCredential.createCredential("dendriel", "myDb",
//                "".toCharArray());
//        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase plainDb = client.getDatabase(dbName);
        // using this approach to avoid losing the posibility to set the mongoDb server port.
        db = plainDb.withCodecRegistry(pojoCodecRegistry);
    }

    public void save(Npc npc) {
        MongoCollection<Npc> coll = db.getCollection("npcs", Npc.class);
        coll.insertOne(npc);
    }

    public Npc findById(int id) {
        MongoCollection<Npc> coll = db.getCollection("npcs", Npc.class);
        Document targetDoc = new Document("_id", id);
        FindIterable<Npc> iterDoc = coll.find(targetDoc);
        return iterDoc.first();
    }
}
