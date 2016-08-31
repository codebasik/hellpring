package com.helljava.helpring.domain;

/**
 * Created by yongjunjung on 2016. 8. 31..
 */
public class BoardDto {

    private String title;
    private String content;
    private String username;

    public BoardDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
