package com.example.vehicleviotation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class BasePageTitleFragment extends Fragment {
	
	private View mFragmentView;//父控件(由父控件找到子控件)
    private ImageView mIvLogoPage;
    private TextView mTvTitlePage;
    private ImageView mTvSettingPage;
    private FrameLayout mFlTitleContentPage;

	@Override
	public void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	
   @Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {
		// Inflate the menu; this adds items to the action bar if it is present.
	   mFragmentView = inflater.inflate(R.layout.base_top_title_page, container, false);   //通用布局(图片 充值)
	   mIvLogoPage = (ImageView) mFragmentView.findViewById(R.id.iv_logo_page);
       mTvTitlePage = (TextView) mFragmentView.findViewById(R.id.tv_title_page);
       mTvSettingPage = (ImageView) mFragmentView.findViewById(R.id.iv_setting);
       mFlTitleContentPage = (FrameLayout) mFragmentView.findViewById(R.id.fl_title_content_page);
       View view = initView();
       mFlTitleContentPage.addView(view);

		return mFragmentView;
	}
   
   public void setTitleIcon(String msg, boolean show) {    //设置标题和图标
       mTvTitlePage.setText(msg);  //设置标题
       mTvTitlePage.setVisibility(show ? View.VISIBLE : View.GONE);     //设置标题显示  true就是显示  false就是不显示
   }


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
	}
	
	
	
	protected abstract View initView();
    protected abstract void initData();
	
}
