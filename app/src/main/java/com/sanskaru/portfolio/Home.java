package com.sanskaru.portfolio;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.sanskaru.portfolio.MainActivity.darkMode;

public class Home extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.home, container, false);



        TextView name = view.findViewById(R.id.name), subhead = view.findViewById(R.id.subhead), desc = view.findViewById(R.id.desc);

        /** Animating the Views **/
        name.setAlpha(0f); // transparency zero
        name.setTranslationX(200f); // off-set on the X-axis
        name.animate().alpha(1f).translationXBy(-200f).setDuration(1000); // animation, duration in ms

        subhead.setAlpha(0f);
        subhead.setTranslationX(-200f);
        subhead.animate().alpha(1f).translationXBy(200f).setDuration(1000);

        desc.setAlpha(0f);
        desc.setTranslationY(200f);
        desc.animate().alpha(1f).translationYBy(-200f).setDuration(1000);

        if (!darkMode)
        {
            view.setBackgroundColor(Color.rgb(255,255,255));
            name.setBackgroundColor(Color.rgb(255,255,255));
            subhead.setBackgroundColor(Color.rgb(255,255,255));
            desc.setBackgroundColor(Color.rgb(255,255,255));
        }

        return view;
    }
}
