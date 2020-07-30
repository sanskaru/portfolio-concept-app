package com.sanskaru.portfolio;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.sanskaru.portfolio.MainActivity.darkMode;

public class Contact extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact, container, false);

        if(!darkMode)
        {
            view.setBackgroundColor(Color.WHITE);
            view.findViewById(R.id.contparent).setBackgroundColor(Color.WHITE);
        }

        ((TextView) view.findViewById(R.id.ccc)).setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}
