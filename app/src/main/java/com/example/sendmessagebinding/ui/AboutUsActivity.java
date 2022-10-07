package com.example.sendmessagebinding.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageApplication;
import com.example.sendmessagebinding.databinding.ActivityAboutUsBinding;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {
    private ActivityAboutUsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutView view = AboutBuilder.with(this)
                .setName(((SendMessageApplication)getApplication()).getUser().getName())
                .setSubTitle("Android Developer")
                .setBrief("Esto es un intento de un About us.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink("smorrec")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .addLinkedInLink("Sergio Morales Recio")
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();



        setContentView(view);
    }
}