package com.example.vehicleviotation;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.base.BaseActivity;
import com.example.base.BaseApplication;
import com.example.utils.AsyncHttpClientTool;
import com.example.utils.JsonTool;
import com.example.utils.ToastTool;
import com.example.utils.UserPreference;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity implements OnClickListener {

	private Button startButton;// 登录开始
	private EditText userNameText;// 用户名
	private EditText userPswText;// 密码
	private View navLeftBtn; // 后退按钮
	private UserPreference userPreference;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_userlogin);
		userPreference = BaseApplication.getInstance().getUserPreference();

		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		navLeftBtn = (View) findViewById(R.id.nav_left_btn);
		userNameText = (EditText) findViewById(R.id.user_name);
		userPswText = (EditText) findViewById(R.id.identify_code);
		startButton = (Button) findViewById(R.id.start_button);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		navLeftBtn.setOnClickListener(this);
		startButton.setOnClickListener(this);
		userNameText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub

			}

			// 只要有文字或者内容，则此时注册按钮可以触发
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if (!s.toString().isEmpty()) {
					startButton.setEnabled(true);
				} else {
					startButton.setEnabled(false);
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.nav_left_btn:
			finish();
			break;
		case R.id.start_button:
			String loginName = userNameText.getText().toString();
			String loginPwd = userPswText.getText().toString();
			if ("".equals(loginName) || "".equals(loginPwd)) {
				ToastTool.showLong(getApplicationContext(), "请将信息填写完整再提交！");
			} else {
				loginDocManaUser(loginName, loginPwd);
			}
			break;
		default:
			break;
		}
	}
	
	private void loginDocManaUser(String loginName, String loginPwd) {
		RequestParams params = new RequestParams();
		params.put("flag", "login");
		params.put("loginName", loginName);
		params.put("loginPwd", loginPwd);
		System.out.println("123");
		TextHttpResponseHandler responseHandler = new TextHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] headers, String response) {
				// TODO Auto-generated method stub
				JsonTool jsonTool = new JsonTool(response);
				JSONObject jsonObject = jsonTool.getJsonObject();

				String status = jsonTool.getStatus();
				try {
					if (status.equals("success")) {
						String message = jsonObject.getString("message");
						String loginName = jsonObject.getString("loginName");
						ToastTool.showShort(getApplicationContext(), message);
						LoginActivity.this.finish();
						userPreference.setUserLogin(true);
						userPreference.setUserLoginName(loginName);
					} else {
						ToastTool.showShort(getApplicationContext(), "登录失败");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String errorResponse, Throwable e) {
				// TODO Auto-generated method stub
				if (statusCode != 0) {
					JsonTool jsonTool = new JsonTool(errorResponse);
					if (jsonTool.getStatus().equals("fail")) {
						// mPhoneView.setError(jsonTool.getMessage());
						// focusView = mPhoneView;
					}
				}
			}

		};
		AsyncHttpClientTool.post("api/loginUser", params, responseHandler);
	}

}
