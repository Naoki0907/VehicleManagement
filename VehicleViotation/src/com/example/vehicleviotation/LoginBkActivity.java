package com.example.vehicleviotation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginBkActivity extends Activity implements OnClickListener {

	public int pwdresetFlag = 0;
	private EditText mAccount; // �û���༭
	private EditText mPwd; // ����༭
	private Button mLoginButton; // ��¼��ť
	private CheckBox mRememberCheck;

	private ImageButton mIvBack; // ���ذ�ť
	private TextView mIvRegister; // ע�ᰴť

	private SharedPreferences login_sp;
	private String userNameValue, passwordValue;

	private View loginView; // ��¼
	private View loginSuccessView;
	private TextView loginSuccessShow;
	private TextView mChangepwdText;
	// private UserDataManager mUserDataManager; //�û���ݹ�����

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mIvBack = (ImageButton) findViewById(R.id.iv_loginactivity_back);
		mIvRegister = (TextView) findViewById(R.id.tv_loginactivity_register);
		mLoginButton = (Button) findViewById(R.id.bt_loginactivity_login);

		init();
	}

	protected void init() {
		// TODO Auto-generated method stub
		mIvRegister.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_loginactivity_register:
			Intent intent_Login_to_Register = new Intent(LoginBkActivity.this, RegisterActivity.class); // �л�Login
																										// Activity��User
																										// Activity
			startActivity(intent_Login_to_Register);
			finish();
			break;
		default:
			break;
		}
	}

	// ����
	public void login_back(View v) {
		Intent intent_Login_to_Mine = new Intent(LoginBkActivity.this, MineActivity.class); // �л�Login
																							// Activity��User
																							// Activity
		startActivity(intent_Login_to_Mine);
		finish();
	}

	// ע��
	public void login_to_register(View v) {
		Intent intent_Login_to_Register = new Intent(LoginBkActivity.this, RegisterActivity.class); // �л�Login
																									// Activity��User
																									// Activity
		startActivity(intent_Login_to_Register);
		finish();
	}

	// ��¼
	public void btn_login(View v) {

	}

	public void login() {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
