package com.rozsa.model;

import java.util.List;

public class DecisionFeedback {
    private int id;

    private Label title;

    private List<SelectOption> selectOptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public List<SelectOption> getSelectOptions() {
        return selectOptions;
    }

    public void setSelectOptions(List<SelectOption> selectOptions) {
        this.selectOptions = selectOptions;
    }
}
