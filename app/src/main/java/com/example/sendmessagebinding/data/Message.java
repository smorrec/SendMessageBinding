package com.example.sendmessagebinding.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Clase modelo que contiene el dato del usuario y el mensaje que manda.
 * Al ser un objeto se debe implementar la interfaz Serializable y Parcelabe en el objeto User
 * @author smorrec
 * @version 1.0
 */
public class Message implements Parcelable, Serializable {
    private User user;
    private String content;

    /**
     * Contructor de la clase Message con parámetros
     * @param user
     * @param content
     */
    public Message(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public Message(User user) {
        this.user = user;
    }

    //Por defecto si no de declara un constructor java implementa el constructor vacio


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Este método devuelve la representacion de un objeto Message
     * @return
     */
    @NonNull
    @Override
    public String toString() {
        return getUser() + " -> " + getContent();
    }


    //region MÉTODOS CREADOS POR LA INTERFAZ
    protected Message(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        content = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(user, i);
        parcel.writeString(content);
    }
    //endregion

}
