package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
    }

    /**
     * Este método es el que se llama cuando se pulsa sobre el btSend definido en el XML
     * android:onclick="sendMessage"
     * @param view
     */
    public void sendMessage(View view) {
    }
}