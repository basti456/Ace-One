package com.ace.services.one.capital;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerLoanDetailsAdapter extends FragmentPagerAdapter {
    public ViewPagerLoanDetailsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DetailsFragment();
        } else if (position == 1) {
            return new EMICalendarFragment();
        } else {
            return new TransactionsFragment();
        }
    }

    @Override
    public int getCount() {
        //no of tabs
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Details";
        } else if (position == 1) {
            return "EMI Calendar";
        } else {
            return "Transactions";
        }
    }
}
