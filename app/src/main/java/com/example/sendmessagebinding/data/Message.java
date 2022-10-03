package com.example.sendmessagebinding.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Clase modelo que contiene el dato del usuario y el mensaje que manda
 * @author smorrec
 * @version 1.0
 */
public class Message implements Parcelable {
    private String user;
    private String content;

    /**
     * Contructor de la clase Message con parámetros
     * @param user
     * @param content
     */
    public Message(String user, String content) {
        this.user = user;
        this.content = content;
    }

    //Por defecto si no de declara un constructor java implementa el constructor vacio

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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
        user = in.readString();
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
        parcel.writeString(user);
        parcel.writeString(content);
    }
    //endregion

}
