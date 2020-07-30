package com.sanskaru.portfolio;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import static com.sanskaru.portfolio.MainActivity.darkMode;

public class Projects extends Fragment
{
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.projects, container, false);

        if(!darkMode) view.findViewById(R.id.projparent).setBackgroundColor(Color.WHITE);

        view.setTranslationY(100f);
        view.animate().translationYBy(-100f).setDuration(500);

        view.findViewById(R.id.covi).setAlpha(0f);
        view.findViewById(R.id.covi).setTranslationX(100f);
        view.findViewById(R.id.covi).animate().alpha(1f).translationXBy(-100f).setDuration(1000);

        view.findViewById(R.id.ttt).setAlpha(0f);
        view.findViewById(R.id.ttt).setTranslationX(-100f);
        view.findViewById(R.id.ttt).animate().alpha(1f).translationXBy(100f).setDuration(1000);

        return view;
    }
}
