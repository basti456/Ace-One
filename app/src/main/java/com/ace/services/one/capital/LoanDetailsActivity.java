package com.ace.services.one.capital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class LoanDetailsActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewPager;
    ViewPagerLoanDetailsAdapter viewPagerLoanDetailsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_details);
        //link XML components
        tab=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
        viewPagerLoanDetailsAdapter=new ViewPagerLoanDetailsAdapter(getSupportFragmentManager());
        //set the adapter
        viewPager.setAdapter(viewPagerLoanDetailsAdapter);
        //used to sync tab layout with view pager
        tab.setupWithViewPager(viewPager);

    }
}