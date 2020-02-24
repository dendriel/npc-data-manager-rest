package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.parser.JsonReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Interaction {
    private Integer id;

    private InteractionType type;

    private List<DialogFeedback> messages;

    private DecisionFeedback decision;

    private float priceMultiplier;

    private List<String> items;

    private List<Event> requireEventsState;

    private List<Event> updateEventsState;

    private Integer targetId; // id = -1 -> hero; id >= 0 -> NPC

    private Offset toPos;

    private String targetData;

    public Interaction() {
    }

    public Interaction(int id) {
        this.id = id;
        type = InteractionType.NONE;
        messages = new ArrayList<>();
        items = new ArrayList<>();
        requireEventsState = new ArrayList<>();
        updateEventsState = new ArrayList<>();
        targetId = 0;
        toPos = new Offset();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InteractionType getType() {
        return type;
    }

    public void setType(InteractionType type) {
        this.type = type;
    }

    @JsonIgnore
    public List<Integer> getMessagesIds() {
        if (messages == null || messages.size() == 0) {
            return new ArrayList<>();
        }

        return messages
                .stream()
                .map(DialogFeedback::getId)
                .collect(Collectors.toList());
    }

    public boolean containsMessageId(int id) {
        if (messages == null || messages.size() == 0) {
            return false;
        }

        return messages
                .stream()
                .anyMatch(m -> m.getId() == id);
    }

    public void removeMessage(int id) {
        messages.removeIf(m -> m.getId() == id);
    }

    public List<DialogFeedback> getMessages() {
        return messages;
    }

    public void setMessages(List<DialogFeedback> messages) {
        this.messages = messages;
    }

    public float getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(float priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<Event> getRequireEventsState() {
        return requireEventsState;
    }

    public void setRequireEventsState(List<Event> requireEventsState) {
        this.requireEventsState = requireEventsState;
    }

    public List<Event> getUpdateEventsState() {
        return updateEventsState;
    }

    public void setUpdateEventsState(List<Event> updateEventsState) {
        this.updateEventsState = updateEventsState;
    }

    @JsonIgnore
    public String getRequireEventsStateAsText() {
        if (requireEventsState == null || requireEventsState.isEmpty()) {
            return "";
        }
        return JsonReader.getListAsJson(requireEventsState);
    }

    @JsonIgnore
    public String getUpdateEventsStateAsText() {
        if (updateEventsState == null || updateEventsState.isEmpty()) {
            return "";
        }
        return JsonReader.getListAsJson(updateEventsState);
    }

    @JsonIgnore
    public String getItemsAsText() {
        if (items == null) {
            return "";
        }

        return items
                .toString()
                .replace("[", "")
                .replace("]", "");
    }

    public void addMessage(int id) {
        if (messages == null) {
            messages = new ArrayList<>();
        }

        DialogFeedback newMessage = new DialogFeedback(id);
        messages.add(newMessage);
    }

    public Integer getTargetId() {
        if (targetId == null) {
            targetId = 0;
        }
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Offset getToPos() {
        if (toPos == null) {
            toPos = new Offset();
        }
        return toPos;
    }

    public void setToPos(Offset toPos) {
        this.toPos = toPos;
    }

    public String getTargetData() {
        return targetData;
    }

    public void setTargetData(String targetData) {
        this.targetData = targetData;
    }

    public DecisionFeedback getDecision() {
        return decision;
    }

    public void setDecision(DecisionFeedback decision) {
        this.decision = decision;
    }
}
