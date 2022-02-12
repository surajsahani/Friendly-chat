package com.martialcoder.friendlychat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class aboutMe extends AppCompatActivity {

    CardView about_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);


        about_me = findViewById(R.id.about_me);
        CardView rating = findViewById(R.id.rating);
        rating.setOnClickListener(v -> launchMarket());
        about_me.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://github.com/surajsahani");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

    }
    public void onBackPressed() {
        finish();
    }
    private void launchMarket() {
        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.martialcoder.friendlychat" );
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
        }
    }

    Context context = getApplicationContext(); // or activity.getApplicationContext()
    PackageManager packageManager = context.getPackageManager();
    String packageName = context.getPackageName();

    String myVersionName = "not available"; // initialize String


}