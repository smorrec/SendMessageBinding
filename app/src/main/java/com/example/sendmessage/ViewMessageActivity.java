package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewMessageActivity extends AppCompatActivity {
    private TextView textInputUser;
    private TextView textInputMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        textInputUser = findViewById(R.id.textInputUser);
        textInputMessage = findViewById(R.id.textInputMessage);
        //1. Recoger el Bundle que me han pasado en el Intent que ha iniciado esta actividad
        Bundle bundle = getIntent().getExtras();
        textInputUser.setText(bundle.getString("user"));
        textInputMessage.setText(bundle.getString("message"));

    }
}