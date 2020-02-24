package com.rozsa.model;

import java.util.ArrayList;
import java.util.List;

public class SelectOption {
    private Label label;

    private List<Event> updateEventsState;

    private boolean isLoopback;

    private int loopbackToChapter;

    public SelectOption() {
        label = new Label();
        updateEventsState = new ArrayList<>();
        isLoopback = false;
        loopbackToChapter = -1;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<Event> getUpdateEventsState() {
        return updateEventsState;
    }

    public void setUpdateEventsState(List<Event> updateEventsState) {
        this.updateEventsState = updateEventsState;
    }

    public boolean getIsLoopback() {
        return isLoopback;
    }

    public void setIsLoopback(boolean loopback) {
        isLoopback = loopback;
    }

    public int getLoopbackToChapter() {
        return loopbackToChapter;
    }

    public void setLoopbackToChapter(int loopbackToChapter) {
        this.loopbackToChapter = loopbackToChapter;
    }
}
