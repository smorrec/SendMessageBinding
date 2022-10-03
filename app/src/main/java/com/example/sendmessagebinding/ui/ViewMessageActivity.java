package com.example.sendmessagebinding.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivityViewMessageBinding;

/**
 * Clase que muestra un mensaje de un usuario. Recoge el mensaje que implementa la interfaz Parcelable
 * @author smorrec
 * @version 1.0
 */
public class ViewMessageActivity extends AppCompatActivity {
    private static final String TAG = "ViewMessageActivity";
    private ActivityViewMessageBinding binding;

    //region Ciclo de vida
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1. Recoger el Bundle que me han pasado en el Intent que ha iniciado esta actividad
        Bundle bundle = getIntent().getExtras();
        Message message = bundle.getParcelable("message");
        binding.textInputUser.setText(message.getUser());
        binding.textInputMessage.setText(message.getContent());

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewMessgaeActivity -> onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewMessgaeActivity -> onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewMessgaeActivity -> onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewMessgaeActivity -> onStop()");

    }

    /**
     * Este método se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "ViewMessgaeActivity -> onDestroy()");

    }
    //enregion
}