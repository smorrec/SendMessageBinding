package com.example.sendmessagebinding.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageApplication;
import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivitySendMessageBinding;

/**
 * <h1>Proyecto SendMessage</h1>
 * En este proyecto aprenderemos a realizar las siguientes operaciones
 * <al>
 * <li>Crear un evento en un componente Button en codigo XML</li>
 * <li>Crear un listener del evento conCLick()</li>
 * <li>Crear un Intent y un elemento Bundle para pasar información entre Activity</li>
 * <li>El ciclo de vida de una Activity</li>
 * <li>Manejar la pila de Actividades</li>
 * </al>
 *
 * @author smorrec
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */
public class SendMessageActivity extends AppCompatActivity {
    private static final String TAG = "SendMessageActivity";
    //private SendMessageOnClickedListener delegate;
    private ActivitySendMessageBinding binding;
    //region Ciclo de vida de la Activity

    /**
     * Nétodo callback que crea el menú
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Este método callback se llama cuando se pulsa sobre una de las opciones del menu de la aplicación
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_aboutus:
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SendMessageApplication app = (SendMessageApplication) getApplication();
        binding.setMessage(new Message(app.getUser()));
        binding.btSend.setOnClickListener(view -> sendMessage());
                //view -> Toast.makeText(SendMessageActivity.this, "Esto es un evento", Toast.LENGTH_SHORT).show());
        Log.d(TAG, "SendMessgaeActivity -> onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessgaeActivity -> onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessgaeActivity -> onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessgaeActivity -> onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessgaeActivity -> onStop()");

    }

    /**
     * Este método se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessgaeActivity -> onDestroy()");

    }

    //endregion

    /**
     * Este método es el que se llama cuando se pulsa sobre el btSend definido en el XML
     * <code>android:onclick="sendMessage"</code>
     *
     * @param view
     */
    public void sendMessage(View view) {
        sendMessage();
    }

    public void sendMessage() {
        //TODO Se modificará este ejercicio para estudiar ViewBinding

        Bundle bundle = new Bundle();

        bundle.putParcelable("message", binding.getMessage());

        //2. Vamos a crear el objeto intent explicito porque se conoce la actividad destino
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);
        //3. Se inicia la transicion entre una vista y otra
        startActivity(intent);

    }

    /*
    /**
     * Esta clase no anónima implementa al listener que responde siempre al método OnClicked

    class SendMessageOnClickedListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(SendMessageActivity.this, "Esto es a través de un delegado", Toast.LENGTH_SHORT).show();
        }
    }
    */
}