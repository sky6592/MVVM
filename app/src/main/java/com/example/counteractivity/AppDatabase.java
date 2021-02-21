package com.example.counteractivity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//데이터베이스 객체

@Database(entities = {Todo.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();

}
