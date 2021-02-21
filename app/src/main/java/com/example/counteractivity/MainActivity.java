package com.example.counteractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.counteractivity.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mTodoEditText;
    private TextView mResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room);

        mTodoEditText = findViewById(R.id.todo_edit);
        mResultTextView = findViewById(R.id.result_text);

//        todo-db 데이터베이스 파일이 실제로 생성된다
        //데이터베이스객체 생성
        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db")
                .allowMainThreadQueries()
                .build();
        //allowMainThreadQueries() => 혼자 앱을 만들때 사용해도 되지만, 임시방편이다
        //제거를 하고 insert를 백그라운드에서 처리하도록 해야한다.

        //todo -> lamda라고 부른다
        //UI 갱
        db.todoDao().getAll().observe(this, todos -> {
            mResultTextView.setText(todos.toString());//db.todoDao().getAll() => todos 대신

        });


        //버튼 클릭시 DB에 insert
        findViewById(R.id.add_btn).setOnClickListener(v -> {
            db.todoDao().insert(new Todo(mTodoEditText.getText().toString()));
            //여기에 mResultTextView UI가 변동되도록 코드를 작성하지 않아도
            //LiveData에서 관찰(Observe)하며 UI를 갱신하고 있다.
        });

//        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


//        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
//
//        // UI 갱싱
//        viewModel.getAll().observe(this, todos -> {
//            mResultTextView.setText(todos.toString());
//        });

    }

    // AsyncTask<넘겨줄객체, 중간에 처리할 데이, 리턴할값>
    private static class InsertAsyncTask extends AsyncTask<Todo, Void, Void>{

        @Override
        protected Void doInBackground(Todo... todos) {
            return null;

        }
    }
}