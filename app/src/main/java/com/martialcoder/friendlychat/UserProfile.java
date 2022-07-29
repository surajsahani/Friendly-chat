package com.martialcoder.friendlychat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfile extends AppCompatActivity {


    private FirebaseUser mFirebaseUser;
    private FirebaseAuth mAuth;
    private TextView Name;
    private ImageView userProfile;
    private String mUsername;
    private String mPhotoUrl;
    private String mEmail;
    private String mPhone;
    private TextView Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userProfile = findViewById(R.id.Profile);
        Name = findViewById(R.id.name);
        Email = findViewById(R.id.Email);


        mAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mAuth.getCurrentUser();

        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else {
            mUsername = mFirebaseUser.getDisplayName();
            mEmail = mFirebaseUser.getEmail();
            mPhone = mFirebaseUser.getPhoneNumber();

            if (mFirebaseUser.getPhotoUrl() != null) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }

            Name.setText(mUsername);
            Email.setText(mEmail);

            Glide.with(getApplicationContext())
                    .load(mPhotoUrl)
                    .into(userProfile);

        }

    }

}