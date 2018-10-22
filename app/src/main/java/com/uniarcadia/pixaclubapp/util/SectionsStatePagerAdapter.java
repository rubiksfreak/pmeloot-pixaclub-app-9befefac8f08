package com.uniarcadia.pixaclubapp.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final HashMap<Fragment, Integer> mFragments = new HashMap<>();
    private final HashMap<String, Integer> mFragmentNumbers = new HashMap<>();
    private final HashMap<Integer, String> mFragmentNames = new HashMap<>();

    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String name) {

        mFragmentList.add(fragment);
        Integer fragmentNumber = new Integer(mFragmentList.size() - 1);

        mFragments.put(fragment, fragmentNumber);
        mFragmentNumbers.put(name, fragmentNumber);
        mFragmentNames.put(fragmentNumber, name);
    }

    public Integer getFragmentNumber(String name) {
        return Optional.of(mFragmentNumbers.get(name)).orElse(null);
    }

    public Integer getFragmentNumber(Fragment fragment) {
        return Optional.of(mFragments.get(fragment)).orElse(null);
    }

    public String getFragmentName(Integer fragmentNumber) {
        return Optional.of(mFragmentNames.get(fragmentNumber)).orElse(null);
    }
}
