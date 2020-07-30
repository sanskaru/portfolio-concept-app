package com.sanskaru.portfolio;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import static com.sanskaru.portfolio.MainActivity.clicked;
import static com.sanskaru.portfolio.MainActivity.darkMode;

public class BottomSheet extends BottomSheetDialogFragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);

        TextView header = view.findViewById(R.id.project_header), desc = view.findViewById(R.id.project_desc);
        ImageView img = view.findViewById(R.id.img);
        if (clicked == R.id.covi)
        {
            header.setText("CoV19Track");
            desc.setText(R.string.covi_desc);
            img.setImageResource(R.drawable.covi_demo_resized);
        }
        else
        {
            header.setText("TicTacToeXO");
            desc.setText(R.string.ttt_desc);
            img.setImageResource(R.drawable.ttt_demo_image_resized);
        }

        desc.setMovementMethod(LinkMovementMethod.getInstance());

        if(darkMode)
        {
            header.setTextColor(Color.WHITE);
            desc.setTextColor(Color.WHITE);
        }

        else
        {
            view.setBackgroundColor(Color.WHITE);
            view.findViewById(R.id.bottomparent).setBackgroundColor(Color.WHITE);
        }

        return view;
    }
}
