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
    
    private final String TEXT_STRING ="��¼�󶨳�����Ϣ";
    private final String TEXT_KEY = "��¼";

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
