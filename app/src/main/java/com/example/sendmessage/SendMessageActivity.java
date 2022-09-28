package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * <h1>Proyecto SendMessage</h1>
 * En este proyecto aprenderemos a realizar las siguientes operaciones
 * <al>
 *     <li>Crear un evento en un componente Button en codigo XML</li>
 *     <li>Crear un listener del evento conCLick()</li>
 *     <li>Crear un Intent y un elemento Bundle para pasar información entre Activity</li>
 *     <li>El ciclo de vida de una Activity</li>
 *     <li>Manejar la pila de Actividades</li>
 * </al>
 * @author smorrec
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */
public class SendMessageActivity extends AppCompatActivity {
    private EditText etUser;
    private EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        etUser = findViewById(R.id.etUser);
        etMessage = findViewById(R.id.etMessage);
    }

    /**
     * Este método es el que se llama cuando se pulsa sobre el btSend definido en el XML
     * <code>android:onclick="sendMessage"</code>
     * @param view
     */
    public void sendMessage(View view) {
        //Toast.makeText(this, "Hemos pulsado el botón", Toast.LENGTH_SHORT).show();
        //1. Crear el contenedor para añadir los datos
        Bundle bundle = new Bundle();
        bundle.putString("user", etUser.getText().toString());
        bundle.putString("message", etMessage.getText().toString());
        //2. Vamos a crear el objeto intent explicito porque se conoce la actividad destino
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);
        //3. Se inicia la transicion entre una vista y otra
        startActivity(intent);

    }
}