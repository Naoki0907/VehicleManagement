package com.example.vehicleviotation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity implements OnClickListener {
	
	private TextView mFeedback;
	private TextView mFunction;
	private TextView mAbout;
	private TextView mVersion;
	
	/*public interface itemClickListener{
		void itemClick(String text);
	}
	
	public itemClickListener listener;
	
	public void setItemClickListener(itemClickListener listener){
		this.listener=listener;
	}*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		mFeedback=(TextView)findViewById(R.id.feedback);
		mFunction=(TextView)findViewById(R.id.function);
		mAbout=(TextView)findViewById(R.id.about);
		mVersion=(TextView)findViewById(R.id.version);
		
		mFeedback.setOnClickListener(this);
		mFunction.setOnClickListener(this);
		mAbout.setOnClickListener(this);
		mVersion.setOnClickListener(this);
		
	}
	
	public void onClick(View v){
		switch (v.getId())
		{
		case R.id.version:
			Toast.makeText(SettingActivity.this, "µ±Ç°°æ±¾1.0.0", Toast.LENGTH_SHORT).show();
		break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
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
