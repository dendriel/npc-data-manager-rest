package com.rozsa.model;

public class DialogFeedback {
    private static final String htmlTemplate = "<html><body></body></html>";

    private int id;

    private Label title;

    private Label text;

    public DialogFeedback() {
    }

    public DialogFeedback(int id) {
        this.id = id;
        title = new Label(22, new Rect(12, 4, 920, 32), 2, 0, htmlTemplate);
        text = new Label(20, new Rect(16, 32, 920, 64), 2, 1, htmlTemplate);
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public Label getText() {
        return text;
    }

    public void setText(Label text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
