package com.masud.task.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.masud.task.R;

import java.util.Objects;

public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.about_app);

        Objects.requireNonNull (getSupportActionBar ()).setTitle ("About Task-it");
            getSupportActionBar ().setDisplayHomeAsUpEnabled (true);//add back button manually

        TextView privacy,contact;

        privacy=findViewById (R.id.privacyPolicy);
        contact=findViewById (R.id.contact);

        privacy.setOnClickListener (v -> {
            showBrowser ("http://www.crushtech.unaux.com/privacypolicy/?i=1");
        });

        contact.setOnClickListener (v -> {
            showBrowser ("http://www.crushtech.unaux.com/contact/?i=1");
        });
    }

    public void showBrowser(String url){
        Intent intent=new Intent (Intent.ACTION_VIEW);
        intent.setData (Uri.parse (url));
        startActivity (intent);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId () == android.R.id.home) {
            //if back button is clicked
            finish ();
            return true;
        }
        return super.onOptionsItemSelected (item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
