package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.dao.api.Identifiable;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Npc implements Identifiable<ObjectId> {
    private ObjectId id;

    private long uid;

    private String name;

    private int behaviorId;

    private boolean isFacingRight;

    private Status status;

    private Sprite sprite;

    private List<Integer> interactionOrder;

    private List<Interaction> interaction;

    private int currMessageId;

    public Npc() {
        interactionOrder = new ArrayList<>();
        interaction = new ArrayList<>();
        currMessageId = 0;
    }

    public Npc(ObjectId id) {
        this.id = id;
        status = new Status();
        sprite = new Sprite();
        name = "FIX ME";
        behaviorId = 2;
        interactionOrder = new ArrayList<>();
        interaction = new ArrayList<>();
        currMessageId = 0;
    }

    public int getCurrMessageId() {
        return currMessageId;
    }

    public void setCurrMessageId(int currMessageId) {
        this.currMessageId = currMessageId;
    }

    public List<Interaction> getInteraction()
    {
        List<Interaction> orderedInteraction = interactionOrder
                .stream()
                .map(id -> getInteractionByid(id))
                .collect(Collectors.toList());

        return orderedInteraction;
    }

    @JsonIgnore
    public Interaction getInteractionByid(int id) {
        return interaction
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @JsonIgnore
    public List<Integer> getInteractionMessagesIds() {
        ArrayList<Integer> allMessagesIds = new ArrayList<>();
        interaction.forEach(i -> allMessagesIds.addAll(i.getMessagesIds()));
        return allMessagesIds;
    }

    public void removeInteractionMessage(int id) {
        Interaction targetInteraction = interaction
                                                .stream()
                                                .filter(i -> i.containsMessageId(id))
                                                .findFirst()
                                                .orElse(null);

        targetInteraction.removeMessage(id);
    }

    public void addMessageToInteraction(int interactionId) {
        Interaction interaction = getInteractionByid(interactionId);
        int newMessageId = findNextMessageId();
        interaction.addMessage(newMessageId);
    }

    public List<Integer> getInteractionOrder()
    {
        return interactionOrder;
    }

    @JsonIgnore
    public String getInteractionOrderAsText()
    {
        return interactionOrder
                .toString()
                .replace("[", "")
                .replace("]", "");
    }

    public void setInteraction(List<Interaction> Interaction)
    {
        this.interaction = Interaction;
    }

    public void setInteractionOrder(List<Integer> interactionOrder)
    {
        this.interactionOrder = interactionOrder;
    }

    public void removeInteraction(int id) {
        interaction.removeIf(i -> i.getId() == id);
        interactionOrder.removeIf(i -> i == id);
    }

    public Interaction addInteraction() {
        int nextId = findNextInteractionId();
        Interaction newData = new Interaction(nextId);
        interaction.add(newData);
        interactionOrder.add(nextId);

        return newData;
    }

    private int findNextInteractionId() {
        int highestId = 0;
        for (Interaction data : interaction) {
            int currId = data.getId();
            if (currId > highestId) {
                highestId = currId;
            }
        }

        return highestId + 1;
    }

    private int findNextMessageId() {
        int newMessageId = currMessageId + 1;
        currMessageId++;
        return newMessageId;
        /* It is all about clarity. We could have used just this line:
         * return ++newMessageIndex;
         * but it is harder to read and we aren't short of coding lines =]
         */
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

    public ObjectId getObjectId() {
        return id;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite spriteData) {
        this.sprite = spriteData;
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
}
