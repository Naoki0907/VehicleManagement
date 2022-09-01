package com.example.vehicleviotation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MineActivity extends Activity implements OnClickListener {

	private ImageButton mIvLogin;
	private ImageButton mIvSetting;
	private TextView mloginTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fg_settingpage);

		mIvLogin = (ImageButton) findViewById(R.id.iv_user_login);
		mIvSetting = (ImageButton) findViewById(R.id.iv_setting);

		mloginTv = (TextView) findViewById(R.id.tv_loginactivity_login);

		initView();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_loginactivity_login:
			Intent mine_to_login = new Intent();
			mine_to_login.setClass(MineActivity.this, LoginActivity.class);
			startActivity(mine_to_login);
			finish();
			break;
		default:
			break;
		}
	}

	protected void initView() {
		// TODO Auto-generated method stub
		mloginTv.setOnClickListener(this);
	}

	public void login(View v) {
		Intent mine_to_login = new Intent();
		mine_to_login.setClass(MineActivity.this, LoginActivity.class);
		startActivity(mine_to_login);
	}

	public void onClick_setting(View v) {
		Intent mine_to_setting = new Intent();
		mine_to_setting.setClass(MineActivity.this, SettingActivity.class);
		startActivity(mine_to_setting);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mine, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
