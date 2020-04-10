package com.zeeshan.dynamictabs.ui.activities;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayout;
import com.zeeshan.dynamictabs.BR;
import com.zeeshan.dynamictabs.BlankFragment;
import com.zeeshan.dynamictabs.R;
import com.zeeshan.dynamictabs.data.TabModel;
import com.zeeshan.dynamictabs.databinding.ActivityMainBinding;
import com.zeeshan.dynamictabs.ui.base.MvvmBaseActivity;
import com.zeeshan.dynamictabs.vm.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends MvvmBaseActivity<ActivityMainBinding, MainActivityViewModel> {

    enum TabAnimationType {
        TYPE_IN, TYPE_OUT,
    }

    private List<TabModel> tabsList = new ArrayList<>();

    @Override
    public int getViewModelBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public MainActivityViewModel getViewModel() {
        return new ViewModelProvider(this).get(MainActivityViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);

        setSupportActionBar(mBinding.toolbar);

        setUpTabs();
    }

    private void animate(TextView tv, TabAnimationType type) {

        float startSize = 12; // Size in pixels, check dip and pixel ratio are equal or not.
        float endSize = 25;
        long animationDuration = 250; // Animation duration in ms
        if (type == TabAnimationType.TYPE_OUT) {
            startSize = 25;
            endSize = 12;
        }
        ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);
        animator.setDuration(animationDuration);

        animator.addUpdateListener(valueAnimator -> {
            float animatedValue = (float) valueAnimator.getAnimatedValue();
            tv.setTextSize(animatedValue);
        });
        animator.start();
    }

    private void setUpTabs() {
        tabsList = TabModel.getListOfTabs();

        for (int i = 0; i < tabsList.size(); i++) {
            TabLayout.Tab tab = mBinding.tabLayout.newTab().setTag(tabsList.get(i));
            mBinding.tabLayout.addTab(tab.setCustomView(getTabView(tabsList.get(i).getTabName(), tabsList.get(i).getTabPosition())));
        }

        mBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TabModel selectedTabModel = (TabModel) tab.getTag();
                Log.e("MainActivity", tab.getPosition() + " selected");
                assert selectedTabModel != null;
                loadFragmentForTab(selectedTabModel.getTabPosition());
                TextView tv = Objects.requireNonNull(tab.getCustomView()).findViewById(R.id.custom_text);
                animate(tv, TabAnimationType.TYPE_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                Log.e("MainActivity", tab.getPosition() + " un selected");
                TextView tv = Objects.requireNonNull(tab.getCustomView()).findViewById(R.id.custom_text);
                animate(tv, TabAnimationType.TYPE_OUT);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.e("MainActivity", tab.getPosition() + "  re selected");
            }
        });
        loadFragmentForTab(0);
        TextView tv = mBinding.tabLayout.getTabAt(0).getCustomView().findViewById(R.id.custom_text);
        animate(tv, TabAnimationType.TYPE_IN);
    }

    private void loadFragmentForTab(int position) {

        Fragment fragment = getSelectedFragment(position);
        mBinding.appBarLayout.setExpanded(true);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commitNow();
    }

    public View getTabView(String title, int position) {
        View tab = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab, null);
        TextView tv = tab.findViewById(R.id.custom_text);
        tv.setText(title);
        return tab;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }


    private Fragment getSelectedFragment(int position) {

        Fragment fragment = null;
        switch (position) {
            case A:
                fragment = new BlankFragment(position);
                break;
            case B:
                fragment = new BlankFragment(position);
                break;
            case C:
                fragment = new BlankFragment(position);
                break;
            case D:
                fragment = new BlankFragment(position);
                break;
            case E:
                fragment = new BlankFragment(position);
                break;
            case F:
                fragment = new BlankFragment(position);
                break;
            case G:
                fragment = new BlankFragment(position);
                break;
            case H:
                fragment = new BlankFragment(position);
                break;
            case I:
                fragment = new BlankFragment(position);
                break;
            case J:
                fragment = new BlankFragment(position);
                break;
            case K:
                fragment = new BlankFragment(position);
                break;
            case L:
                fragment = new BlankFragment(position);
                break;
            case M:
                fragment = new BlankFragment(position);
                break;
            case N:
                fragment = new BlankFragment(position);
                break;
            case O:
                fragment = new BlankFragment(position);
                break;
            case P:
                fragment = new BlankFragment(position);
                break;
            default:
                fragment = new BlankFragment(position);
                break;
        }
        return fragment;
    }

    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 4;
    public static final int F = 5;
    public static final int G = 6;
    public static final int H = 7;
    public static final int I = 8;
    public static final int J = 9;
    public static final int K = 10;
    public static final int L = 11;
    public static final int M = 12;
    public static final int N = 13;
    public static final int O = 14;
    public static final int P = 16;
    public static final int Q = 17;
    public static final int RR = 18;
    public static final int S = 19;
    public static final int T = 20;
    public static final int U = 21;
    public static final int V = 22;
    public static final int W = 23;
    public static final int X = 24;
    public static final int Y = 25;
    public static final int Z = 26;

}
