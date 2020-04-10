package com.zeeshan.dynamictabs.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private FragmentNavigationHelper fragmentHelper;
    //    private EventCommunicationHelper eventCommunicationHelper;
    private SharedPreferences prefs;
    protected View view;

    public abstract int getLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentHelper = (FragmentNavigationHelper) activity;
        } catch (Exception e) {
//            LogUtil.logApplicationException(e, getClass().getSimpleName(), "fragmentHelper: onAttach");
        }

        try {
        } catch (Exception e) {
//            LogUtil.logApplicationException(e, getClass().getSimpleName(), "eventCommunicationHelper: onAttach");
        }


        prefs = activity.getSharedPreferences("", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(getLayoutId(), container, false);
        initViews(view, savedInstanceState);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public FragmentNavigationHelper getHelper() {
        return this.fragmentHelper;
    }

    public void initViews(View parent, Bundle savedInstanceState) {
        view.setClickable(true);
    }

    public SharedPreferences getSharedPreferences() {
        return prefs;
    }

    public String getTitle() {
        return "";
    }


    public boolean shouldConfirmBeforeSwitching() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        FragmentPagerController.getInstance().iAmUnloaded(this);
        hideKeyboard();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public void hideKeyboard() {
        if (getView() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void showKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void hideKeyboard(EditText input) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
    }

    public void onLocationChanged(Location location) {

    }

    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }


}
