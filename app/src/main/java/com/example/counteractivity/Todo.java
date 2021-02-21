package com.example.counteractivity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity //Room에서 사용할 수있는 엔터티
public class Todo {
    //알아서 하나씩 증가할 수 있게함 : Primary
    @PrimaryKey(autoGenerate = true)
    private int id;//primary key
    private String title;

    public Todo(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //내용을 확인 할 수 있도

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Todo{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
