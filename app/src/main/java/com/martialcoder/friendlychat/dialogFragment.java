package com.martialcoder.friendlychat;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class dialogFragment extends DialogFragment {

    public OptionListener options;
    private Button btn_ok_dialog_fragment;
    private Button btn_cancel_dialog_fragment;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioGroup radioGroup;
    private EditText et_callback;

    public dialogFragment(OptionListener options) {
        this.options = options;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_ok_dialog_fragment = (Button) view.findViewById(R.id.btn_ok_dialog_fragment);
        btn_cancel_dialog_fragment = (Button) view.findViewById(R.id.btn_cancel_dialog_fragment);
        et_callback = view.findViewById(R.id.et_callback);
        radioButton = (RadioButton) view.findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) view.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) view.findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) view.findViewById(R.id.radioButton4);
        RadioGroup rg = (RadioGroup) view.findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener((radioGroup, i) -> {

        });

        btn_ok_dialog_fragment.setOnClickListener(view1 -> {
            if (et_callback != null)
                options.okOption(et_callback.getText().toString());

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("text/plain");
            intent.setData(Uri.parse("mailto:surajkumarsahani1997@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Report User Friendly Chat");
            intent.putExtra(Intent.EXTRA_TEXT, et_callback.getText());
            startActivity(intent);
            dismiss();

        });

        btn_cancel_dialog_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}