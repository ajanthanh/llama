package com.ajanthan.twoliodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button sendBtn;
    private EditText messageET;

    private static String phoneNo= "6475591892";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
                Intent myIntent = new Intent(MainActivity.this, HomeArticlePageActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        messageET = (EditText) findViewById(R.id.message);
    }

    void sendMessage(){
        String message = messageET.getText().toString();
        MessageHelper.sendSMS(message);
        messageET.setText("");
    }




}
