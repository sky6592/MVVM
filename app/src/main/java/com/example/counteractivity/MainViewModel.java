package com.example.counteractivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

//데이터 관련한 코드를 모두 여기에다 옮긴
public class MainViewModel extends AndroidViewModel {

    private AppDatabase db;

    public MainViewModel(@NonNull Application application) {
        super(application);
        //this : application
    }

//    public LiveData<List<Todo>> getAll(){
//        return db.todoDao().getAll;
//    }
}
