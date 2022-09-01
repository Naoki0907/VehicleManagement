package com.example.vehicleviotation;

import java.util.List;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.adapter.ViotationAdapter;
import com.example.entiy.DecorateViotation;
import com.example.utils.AsyncHttpClientTool;
import com.example.utils.JsonTool;
import com.example.utils.ToastTool;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FoundPageFragment extends BasePageTitleFragment {

	private SharedPreferences pref;
	private TextView tv_car_no;
	private TextView tv_times;
	private TextView tv_fine;
	private TextView tv_duct;
	private ListView lv;

	@Override
	public View initView() {
		setTitleIcon("����", true);
		View recommendFragment = View.inflate(getActivity(), R.layout.fg_foundpage, null);
		tv_car_no = (TextView) recommendFragment.findViewById(R.id.tv_car_no);
		tv_times = (TextView) recommendFragment.findViewById(R.id.tv_times);
		tv_fine = (TextView) recommendFragment.findViewById(R.id.tv_fine);
		tv_duct = (TextView) recommendFragment.findViewById(R.id.tv_duct);
		lv = (ListView) recommendFragment.findViewById(R.id.lv);
		pref = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				final DecorateViotation dv = (DecorateViotation) lv.getAdapter().getItem(arg2);
				
				if(dv.getPunish_flag().equals("已办理")) {
					ToastTool.show(getActivity(), "该违章信息已处理", Toast.LENGTH_SHORT);
					return;
				}
				
				View dialog_view = View.inflate(getActivity(), R.layout.dialog_layout, null);
				
				TextView tv_desc = (TextView) dialog_view.findViewById(R.id.tv_desc);
				tv_desc.setText("违章编号："+dv.getViotation_id()+"\n扣"+dv.getDeduct()+"分，是否缴纳罚款"+dv.getFine()+"元？");
				
				AlertDialog dialog = new AlertDialog.Builder(getActivity())
						.setTitle("处理违章")
						.setView(dialog_view)
						.setPositiveButton("支付", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								updatePunish(dv.getPunish_id());
							}
						})
						.setNegativeButton("取消", null)
						.create();
				dialog.setCanceledOnTouchOutside(false);
				dialog.show();
			}
		});

		update();
		return recommendFragment;

	}

	@Override
	public void initData() {

	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		// TODO Auto-generated method stub
		super.onHiddenChanged(hidden);
		if (!hidden) {
			update();
		}
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		update();
	}

	private void update() {
		String car_no = pref.getString("platform", "");
		tv_car_no.setText(car_no);
		if (TextUtils.isEmpty(car_no)) {
			ToastTool.show(getActivity(), "请先添加车辆信息", Toast.LENGTH_SHORT);
		} else {
			getData(car_no);
		}
		
	}

	private void getData(String car_no) {

		RequestParams params = new RequestParams();
		params.put("car_no", car_no);
		TextHttpResponseHandler responseHandler = new TextHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] headers, String response) {
				// TODO Auto-generated method stub
				JsonTool jsonTool = new JsonTool(response);
				JSONObject jsonObject = jsonTool.getJsonObject();

				String status = jsonTool.getStatus();
				try {
					if (status.equals("success")) {
						String data = jsonObject.getString("data");
						if (data.equals("null")) {
							ToastTool.show(getActivity(), "暂无数据", Toast.LENGTH_SHORT);
						} else {
							List<DecorateViotation> list = new Gson().fromJson(data,
									new TypeToken<List<DecorateViotation>>() {
									}.getType());
							
							ViotationAdapter adapter = new ViotationAdapter(getActivity(), list);
							lv.setAdapter(adapter);
							
							tv_times.setText(String.valueOf(list.size()));
							int fine=0;
							int deduct=0;
							for(DecorateViotation dv:list) {
								fine+=dv.getFine();
								deduct+=dv.getDeduct();
							}
							tv_fine.setText(String.valueOf(fine));
							tv_duct.setText(String.valueOf(deduct));
							
						}
					} else {
						ToastTool.show(getActivity(), jsonTool.getMessage(), Toast.LENGTH_SHORT);
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
						ToastTool.show(getActivity(), jsonTool.getMessage(), Toast.LENGTH_SHORT);
					}
				} else {
					ToastTool.show(getActivity(), errorResponse, Toast.LENGTH_SHORT);
				}
			}

		};
		AsyncHttpClientTool.post("api/getViotation", params, responseHandler);
	}
	
	private void updatePunish(String punish_id) {

		RequestParams params = new RequestParams();
		params.put("punish_id", punish_id);
		TextHttpResponseHandler responseHandler = new TextHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] headers, String response) {
				// TODO Auto-generated method stub
				JsonTool jsonTool = new JsonTool(response);
				JSONObject jsonObject = jsonTool.getJsonObject();
				ToastTool.show(getActivity(), jsonTool.getMessage(), Toast.LENGTH_SHORT);
				String status = jsonTool.getStatus();
				if (status.equals("success")) {
					update();
				}
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String errorResponse, Throwable e) {
				// TODO Auto-generated method stub
				if (statusCode != 0) {
					JsonTool jsonTool = new JsonTool(errorResponse);
					if (jsonTool.getStatus().equals("fail")) {
						ToastTool.show(getActivity(), jsonTool.getMessage(), Toast.LENGTH_SHORT);
					}
				} else {
					ToastTool.show(getActivity(), errorResponse, Toast.LENGTH_SHORT);
				}
			}

		};
		AsyncHttpClientTool.post("api/updatePunish", params, responseHandler);
	}
}
