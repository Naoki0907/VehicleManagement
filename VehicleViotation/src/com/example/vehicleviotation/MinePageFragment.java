package com.example.vehicleviotation;

import com.example.base.BaseApplication;
import com.example.utils.UserPreference;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MinePageFragment extends BasePageTitleFragment implements OnClickListener {
	private TextView mloginTv;
	private View mineFragment;
	private UserPreference userPreference;
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		init();
	}

	@Override
	public View initView() {
		setTitleIcon("", true);
		mineFragment = View.inflate(getActivity(), R.layout.fg_settingpage, null);
		init();
		return mineFragment;
	}

	protected void init() {
		// TODO Auto-generated method stub
		userPreference = BaseApplication.getInstance().getUserPreference();
		mloginTv = (TextView) mineFragment.findViewById(R.id.tv_loginactivity_login);
		mloginTv.setOnClickListener(this);
		
		if(userPreference.getUserLogin()){
			mloginTv.setText(userPreference.getUserLoginName());
		}
	}

	@Override
	public void initData() {

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_loginactivity_login:
			Intent mine_to_login = new Intent();
			mine_to_login.setClass(getActivity(), RegisterActivity.class);
			startActivity(mine_to_login);
			break;
		default:
			break;
		}
	}
}
