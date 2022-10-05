package com.example.sendmessagebinding.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Clase que contiene la información del usuario que ha iniciado sesión en la aplicación
 */
public class User implements Parcelable, Serializable {
    private String name;
    private String enail;

    /**
     * Constructor con parámetros
     * @param name
     * @param enail
     */
    public User(String name, String enail) {
        this.name = name;
        this.enail = enail;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", enail='" + enail + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnail() {
        return enail;
    }

    public void setEnail(String enail) {
        this.enail = enail;
    }

    //region IMPLEMENTACION PARCELABLE
    protected User(Parcel in) {
        name = in.readString();
        enail = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(enail);
    }
    //endregion
}
