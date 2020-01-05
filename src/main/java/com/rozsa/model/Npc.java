package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.dao.api.Identifiable;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Npc implements Identifiable<ObjectId> {
    private ObjectId id;

    private String name;

    private int behaviorId;

    private boolean isFacingRight;

    private Status status;

    private Sprite spriteData;

    private List<Integer> interactionOrder;

    private List<Interaction> interactionData;

    private int currMessageId;

    public Npc() {
        interactionOrder = new ArrayList<>();
        interactionData = new ArrayList<>();
        status = new Status();
        spriteData = new Sprite();
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
        id = new ObjectId(idAsText);
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

    // Remove when the new npc data manager is fully working.
    @Deprecated
    public int getCurrMessageId() {
        return currMessageId;
    }

    public void setCurrMessageId(int currMessageId) {
        this.currMessageId = currMessageId;
    }
}
