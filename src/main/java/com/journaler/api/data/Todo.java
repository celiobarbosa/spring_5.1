package com.journaler.api.data;

public class Todo {
    private String id;
    private String title;
    private String message;
    private Long schedule;

    public Todo() {}

    public Todo(String id, String title, String message, Long schedule) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getSchedule() {
        return schedule;
    }

    public void setSchedule(Long schedule) {
        this.schedule = schedule;
    }
}
