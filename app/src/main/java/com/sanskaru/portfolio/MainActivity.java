package com.sanskaru.portfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import static com.sanskaru.portfolio.MenuUtils.CONTACT;
import static com.sanskaru.portfolio.MenuUtils.EDU;
import static com.sanskaru.portfolio.MenuUtils.HOME;
import static com.sanskaru.portfolio.MenuUtils.PROJECTS;

public class MainActivity extends AppCompatActivity implements CustomCallback
{

    RecyclerView menu;
    List<Item> items;
    MyAdapter adapter;

    private int selected = 0;
    public static int clicked;

    static Boolean darkMode, isDarkSet=false; // isDarkSet denotes that darkMode has been set by the user, darkMode is in general dark mode indicator
    SharedPreferences preferences; // for saving user settings, will crassh if not applied in onCreate
    SharedPreferences.Editor editor;
    public static final String themeKey="themeKey";
    public static final String themeType="DarkMode";

    public void setDarkMode(View view)
    {
        if (darkMode)
        {
            darkMode=false;
            editor.putBoolean(themeType, darkMode).commit(); // saving user preference in the preference file
            ThemeUtils.onActivityCreateSetConditionTheme(this, darkMode); // apply theme on activity

            setContentView(R.layout.activity_main); // refresh layout
            setMenu();

            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();

            RelativeLayout imgh = findViewById(R.id.image_holder);
            imgh.setBackgroundColor(Color.rgb(255, 255, 255));

            FrameLayout von = findViewById(R.id.container);
            von.setBackgroundColor(Color.rgb(255, 255, 255));

            menu.setBackgroundColor(Color.rgb(255,255,255));

        }
        else
        {
            darkMode=true;
            editor.putBoolean(themeType, darkMode).commit();
            ThemeUtils.onActivityCreateSetConditionTheme(this, darkMode);
            setContentView(R.layout.activity_main);
            setMenu();

            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();

            RelativeLayout imgh = findViewById(R.id.image_holder);
            imgh.setBackgroundColor(Color.rgb(32, 32, 32));

            FrameLayout von = findViewById(R.id.container);
            von.setBackgroundColor(Color.rgb(32,32,32));

            menu.setBackgroundColor(Color.rgb(32,32,32));


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(themeKey,0); // declare it here, after super.OnCreate else app crashes
        editor = preferences.edit();

        if(preferences.contains(themeType)) // if user has set dark mode
        {
            darkMode=preferences.getBoolean(themeType, false);
            isDarkSet=true; // true because user had set it

        }
        if(isDarkSet==false) { // if user didn't set
            switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) { // get device dark mode settings
                case Configuration.UI_MODE_NIGHT_YES: { // systemwide dark mode on
                    darkMode = true;
                    ThemeUtils.onActivityCreateSetConditionTheme(this, true); // set dark theme
                    break;
                }
                case Configuration.UI_MODE_NIGHT_NO: { // systemwide dark mode off
                    darkMode = false;
                    ThemeUtils.onActivityCreateSetConditionTheme(this, false); // set light theme
                    break;
                }
            }
        }
        else ThemeUtils.onActivityCreateSetConditionTheme(this, darkMode);

        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menu_holder);

        if (darkMode)
        {
            RelativeLayout imgh = findViewById(R.id.image_holder);
            imgh.setBackgroundColor(Color.rgb(32, 32, 32));

            FrameLayout von = findViewById(R.id.container);
            von.setBackgroundColor(Color.rgb(32,32,32));

            menu.setBackgroundColor(Color.rgb(32,32,32));
        }

        setMenu();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();
    }

    private void setMenu()
    {
        menu = findViewById(R.id.menu_holder);

        items = MenuUtils.getList();

        adapter = new MyAdapter(items, this);

        menu.setLayoutManager(new LinearLayoutManager(this));
        menu.setAdapter(adapter);
    }

    @Override
    public void onSideMenuClick(int position)
    {
        switch (items.get(position).getCode())
        {
            case HOME:
            {

                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();
                break;
            }
            case EDU:
            {

                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Edu()).commit();
                break;
            }
            case CONTACT:
            {

                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Contact()).commit();
                break;
            }
            case PROJECTS:
            {

                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Projects()).commit();
                break;
            }
        }

        items.get(selected).setSelected(false);
        items.get(position).setSelected(true);
        selected = position;

        adapter.notifyDataSetChanged();
    }

    public void openBottomSheet(View view)
    {
        BottomSheet bottomSheet = new BottomSheet();
        clicked = view.getId();
        bottomSheet.show(getSupportFragmentManager(), "Bottom Sheet");
    }
}