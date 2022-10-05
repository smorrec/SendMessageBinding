package com.example.sendmessagebinding;

import android.app.Application;

import com.example.sendmessagebinding.data.User;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class SendMessageApplication extends Application {
    //Usuario que ha iniciado sesión. DATO GLOBAL porque siempre se va a acceder a él
    //mediante el método getApplication().getUser()
    private User user;
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("Se ha inicializado el objeto logger");
        user = new User("Sergio", "email@email");

    }

    public User getUser(){
        return user;
    }
}
