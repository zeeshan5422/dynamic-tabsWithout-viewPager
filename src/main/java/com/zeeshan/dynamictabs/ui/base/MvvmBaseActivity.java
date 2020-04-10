package com.zeeshan.dynamictabs.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class MvvmBaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    protected T mBinding;
    protected V mViewModel;

    public abstract int getViewModelBindingVariable();

    public abstract V getViewModel();

    public abstract int getLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mBinding.setLifecycleOwner(this);
        mBinding.setVariable(getViewModelBindingVariable(), mViewModel);
        initViews(savedInstanceState);
    }

    public void initViews(Bundle savedInstanceState) {
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        loadData();
        subscribeUI();
        return super.onCreateView(parent, name, context, attrs);
    }

    public void loadData() {
    }

    public void subscribeUI() {
    }


}

