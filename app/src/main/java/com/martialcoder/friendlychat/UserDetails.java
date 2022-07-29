package com.martialcoder.friendlychat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UserDetails extends AppCompatActivity implements OptionListener {

    private TextView tvName;
    private TextView vc;
    private ImageView url;
    private Button report;

    private Button tvChat;

    public String imagePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        initialize();
        OnClick();
        tvChat = findViewById(R.id.tvChat);

    }

    private void initialize() {
        tvName = findViewById(R.id.tv_name);
        url = findViewById(R.id.IvUserProfile);

        report = findViewById(R.id.tvReport);

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        imagePath = intent.getStringExtra("url");

        tvName.setText(str);

        Glide.with(getApplicationContext())
                .load(imagePath)
                .into(url);


    }

    private void OnClick() {
        report.setOnClickListener(v -> {

            FragmentTransaction Ft = getSupportFragmentManager().beginTransaction();
            dialogFragment dialog = new dialogFragment(UserDetails.this);
            dialog.show(Ft, "dialog");
        });

        url.setOnClickListener(view -> {
            Intent intent = new Intent(UserDetails.this, SingleClick.class);
            intent.putExtra("url", imagePath);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_stay, R.anim.slide_out_up);
    }

    @Override
    public void cancelOption() {
        Toast.makeText(this, "The operation canceled !!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void okOption(String data) {

        Toast.makeText(this, "Thank you! \n Your report will be reviewed by our team.", Toast.LENGTH_SHORT).show();

    }

}