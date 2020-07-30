package com.sanskaru.portfolio;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pl.hypeapp.materialtimelineview.MaterialTimelineView;

import static com.sanskaru.portfolio.MainActivity.darkMode;

public class Edu extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edu, container, false);

        LinearLayout lineLayout = view.findViewById(R.id.lineLayout);

        lineLayout.setAlpha(0f);
        lineLayout.setTranslationY(300f);
        lineLayout.animate().alpha(1f).translationYBy(-300f).setDuration(1000);

        if(!darkMode)
        {
            view.setBackgroundColor(Color.rgb(255,255,255));
            view.findViewById(R.id.eduparent).setBackgroundColor(Color.WHITE);
        }

        return view;

    }
}
