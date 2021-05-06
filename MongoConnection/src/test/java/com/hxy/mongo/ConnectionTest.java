package com.hxy.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.Test;

public class ConnectionTest {

    @Test
    public void testMongoConnection() {
        MongoClient client = MongoClients.create("mongodb://10.240.210.206:27017");

        MongoDatabase database = client.getDatabase("mytest1");

        MongoCollection<Document> userCollection = database.getCollection("user");

        userCollection.find().forEach(document -> {
            System.out.println(document.toJson());
        });

        client.close();
    }
}
