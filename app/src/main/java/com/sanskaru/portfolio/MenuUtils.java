package com.sanskaru.portfolio;

import java.util.ArrayList;
import java.util.List;

public class MenuUtils
{
    public static final int HOME = 0, EDU = 1, CONTACT = 3, PROJECTS = 2;

    public static List<Item> getList()
    {
        List<Item> list = new ArrayList<>();

        list.add(new Item(R.drawable.ic_baseline_home_24, HOME, true));
        list.add(new Item(R.drawable.ic_baseline_school_24, EDU, false));
        list.add(new Item(R.drawable.ic_baseline_work_outline_24, PROJECTS, false));
        list.add(new Item(R.drawable.ic_baseline_local_phone_24, CONTACT, false));

        return list;
    }

}
