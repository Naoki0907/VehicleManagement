package com.example.vehicleviotation;


import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HomePageFragment extends BasePageTitleFragment {
	
	private TextView mTvLogin;
    
    private final String TEXT_STRING ="登录绑定车辆信息";
    private final String TEXT_KEY = "登录";

	@Override
	protected View initView() {
		setTitleIcon("",false);
		View homeFragment=View.inflate(getActivity(), R.layout.fg_homepage, null);
		
		

		return homeFragment;
	}
	
	

	@Override
	protected void initData(){
		
		
	}
}
