package com.example.sendmessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sendmessage.R;
import com.example.sendmessage.data.Message;

/**
 * Clase que muestra un mensaje de un usuario. Recoge el mensaje que implementa la interfaz Parcelable
 * @author smorrec
 * @version 1.0
 */
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
        Message message = bundle.getParcelable("message");
        textInputUser.setText(message.getUser());
        textInputMessage.setText(message.getContent());

    }
}