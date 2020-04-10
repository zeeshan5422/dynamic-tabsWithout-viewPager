package com.zeeshan.dynamictabs.ui.base;

/* ---  Created by akhtarz on 2/21/2020. ---*/
public interface FragmentNavigationHelper {


    public void addFragment(BaseFragment f, boolean clearBackStack, boolean addToBackstack);

    public void addFragment(BaseFragment f, int layoutId, boolean clearBackStack, boolean addToBackstack);

    public void replaceFragment(BaseFragment f, boolean clearBackStack, boolean addToBackstack);

    public void replaceFragment(BaseFragment f, int layoutId, boolean clearBackStack, boolean addToBackstack);

    public void goBack();
}
