package com.example.vehicleviotation;

import java.util.List;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.entiy.DecorateViotation;
import com.example.utils.AsyncHttpClientTool;
import com.example.utils.JsonTool;
import com.example.utils.ToastTool;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class AddPageFragment extends BasePageTitleFragment {

	@Override
	public View initView() {
		setTitleIcon("查询",true);
        View matchFragment = View.inflate(getActivity(), R.layout.fg_addpage, null);
        
        final SharedPreferences pref = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        final EditText platform_edit = (EditText) matchFragment.findViewById(R.id.platform_edit);
        final EditText engineer_edit = (EditText) matchFragment.findViewById(R.id.engineer_edit);
        final EditText caridentity_edit = (EditText) matchFragment.findViewById(R.id.caridentity_edit);
        
        platform_edit.setText(pref.getString("platform", ""));
        engineer_edit.setText(pref.getString("engineer", ""));
        caridentity_edit.setText(pref.getString("caridentity", ""));
        
        matchFragment.findViewById(R.id.btn_save).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				pref.edit()
				.putString("platform", platform_edit.getText().toString().trim())
				.putString("engineer", engineer_edit.getText().toString().trim())
				.putString("caridentity", caridentity_edit.getText().toString().trim())
				.apply();
				
				ToastTool.show(getActivity(), "保存成功", Toast.LENGTH_SHORT);

			}
		});
        
        return matchFragment;
	}

	@Override
	public void initData(){
		
	}
	
}
