package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.dao.api.Identifiable;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Npc implements Identifiable<ObjectId> {
    private ObjectId id;

    private long uid;

    private String name;

    private String mapName;

    private int behaviorId;

    private boolean isFacingRight;

    private Status status;

    private Sprite spriteData;

    private LootHolder lootHolder;

    private NpcWearableHolder wearableHolder;

    private List<Integer> interactionOrder;

    private List<Interaction> interactionData;

    public Npc() {
        interactionOrder = new ArrayList<>();
        interactionData = new ArrayList<>();
        status = new Status();
        spriteData = new Sprite();
        lootHolder = new LootHolder();
    }

    public List<Interaction> getInteractionData() {
        return interactionData;
    }

    public void setInteractionData(List<Interaction> Interaction) {
        this.interactionData = Interaction;
    }

    public List<Integer> getInteractionOrder() {
        return interactionOrder;
    }

    public void setInteractionOrder(List<Integer> interactionOrder) {
        this.interactionOrder = interactionOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBehaviorId() {
        return behaviorId;
    }

    public void setBehaviorId(int behaviorId) {
        this.behaviorId = behaviorId;
    }

    @JsonIgnore
    @BsonIgnore
    public ObjectId getObjectId() {
        return id;
    }

    @JsonIgnore
    public ObjectId getId() {
        return id;
    }

    @JsonIgnore
    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIdAsText() {
        return id.toString();
    }

    public void setIdAsText(String idAsText) {
        if (idAsText != null && !idAsText.isEmpty()) {
            id = new ObjectId(idAsText);
        }
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Sprite getSpriteData() {
        return spriteData;
    }

    public void setSpriteData(Sprite spriteData) {
        this.spriteData = spriteData;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean facingRight) {
        isFacingRight = facingRight;
    }

    public LootHolder getLootHolder() {
        return lootHolder;
    }

    public void setLootHolder(LootHolder lootHolder) {
        this.lootHolder = lootHolder;
    }

    public NpcWearableHolder getWearableHolder() {
        return wearableHolder;
    }

    public void setWearableHolder(NpcWearableHolder wearableHolder) {
        this.wearableHolder = wearableHolder;
    }
}
