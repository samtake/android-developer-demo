package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {


    private ListView mLlvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.tv_test);
        textView.setText(message);

        mLlvTest = findViewById(R.id.lv_test);
        List<String> data = new ArrayList<>();
        for(int i=0 ; i< 20;i++){
            data.add("Test"+i);
        }
        ListViewAdapter adapter = new ListViewAdapter(this,data);
        mLlvTest.setAdapter(adapter);



    }
}
