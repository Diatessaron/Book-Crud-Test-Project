package com.fazlyev.bookcrudproject.dto;

public class BookRequest {
    private String id;
    private String title;
    private boolean isLiked;
    private boolean isRead;

    public BookRequest() {
    }

    public BookRequest(String id, String title, boolean isLiked, boolean isRead) {
        this.id = id;
        this.title = title;
        this.isLiked = isLiked;
        this.isRead = isRead;
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

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
