package com.martialcoder.friendlychat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BottomSheetDialog extends BottomSheetDialogFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.bottom_sheet_layout,
                container, false);

        TextView algo_button = v.findViewById(R.id.algo_button);
        ImageView circularImageView = v.findViewById(R.id.imageView);


        Bundle mArgs = getArguments();
        String myValue = mArgs.getString("key");
        algo_button.setText(myValue);
        String imgPath = getArguments().getString("url");

        Glide.with(getContext())
                .load(imgPath)
                .into(circularImageView);

        return v;
    }

}

