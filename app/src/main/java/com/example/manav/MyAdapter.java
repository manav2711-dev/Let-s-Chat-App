package com.example.manav;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;

public class MyAdapter extends FragmentPagerAdapter {


    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Home home = new Home();
                return home;
            case 1:
                Search Search = new Search();
                return Search;
            case 2:
                chat chat = new chat();
                return chat;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        if(position==0)
            title="Chats";

        else if(position==1)
            title="Status";
        else if (position==2)
            title="Calls";
        return title;

        }
    }

