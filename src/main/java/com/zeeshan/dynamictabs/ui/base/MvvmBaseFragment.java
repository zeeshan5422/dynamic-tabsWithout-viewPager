package com.zeeshan.dynamictabs.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/* ---  Created by akhtarz on 2/28/2020. ---*/
public abstract class MvvmBaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends BaseFragment {

    protected T mBinding;
    protected V mViewModel;

    public abstract int getViewModelBindingVariable();

    public abstract V getViewModel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mBinding.setLifecycleOwner(this);
        view = mBinding.getRoot();
        initViews(view, savedInstanceState);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setVariable(getViewModelBindingVariable(), mViewModel);
        initExtraBindingVariables();
//        mBinding.executePendingBindings();
        loadData();
        subscribeUI();
    }

    public void loadData() {
    }
    public void subscribeUI() {
    }

    public void initExtraBindingVariables() {
    }

}
