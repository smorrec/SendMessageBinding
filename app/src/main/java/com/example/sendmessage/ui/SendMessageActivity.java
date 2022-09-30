package com.example.sendmessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sendmessage.R;
import com.example.sendmessage.data.Message;

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
    private EditText etUser;
    private EditText etMessage;
    private Button btSend;
    private SendMessageOnClickedListener delegate;
    //region Ciclo de vida de la Activity

    @Override
    /**
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        etUser = findViewById(R.id.etUser);
        etMessage = findViewById(R.id.etMessage);
        btSend = findViewById(R.id.btSend);

        /*//Se inicializa el delegado
        delegate = new SendMessageOnClickedListener();
        //Se establece el vinculo entre el Botón y el delegado
        btSend.setOnClickListener(delegate);*/

        //Establecer el Listener OnClickedLIstener al botón
        //imnplementa la interfaz View.OnClickedListener
        btSend.setOnClickListener(view -> sendMessage());
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
        etUser = null;
        etMessage = null;
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
        //Toast.makeText(this, "Hemos pulsado el botón", Toast.LENGTH_SHORT).show();
        //1. Crear el contenedor para añadir los datos
        Bundle bundle = new Bundle();
        //1.1. Pasar dato a dato
        //1.2. Crear un objeto Message
        Message message = new Message(etUser.getText().toString(), etMessage.getText().toString());
        bundle.putParcelable("message", message);

        //2. Vamos a crear el objeto intent explicito porque se conoce la actividad destino
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);
        //3. Se inicia la transicion entre una vista y otra
        startActivity(intent);

    }


    /**
     * Esta clase no anónima implementa al listener que responde siempre al método OnClicked
     */
    class SendMessageOnClickedListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(SendMessageActivity.this, "Esto es a través de un delegado", Toast.LENGTH_SHORT).show();
        }
    }
}