package com.example.wifiswitch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();


    public VPAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //Fragment_Switch.getInstance(position).getPos(position);
        return fragmentArrayList.get(position);
        //return new Fragment_Switch(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment, String title){

        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return fragmentTitle.get(position);

    }
}
