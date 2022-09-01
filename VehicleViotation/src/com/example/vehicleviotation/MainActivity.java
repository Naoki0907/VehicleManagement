package com.example.vehicleviotation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//import com.example.vehicleviotation.MainActivity.ViewPageTask;
//import com.example.vehicleviotation.MainActivity.ViewPagerAdapter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public  class MainActivity extends Activity implements View.OnClickListener{
	
	 //private ViewPager mViewPager;
	    //private List<ImageView> images;
	    //private List<View> dots;
	  //  private int currentItem;
	    //记录上一次点的位置
	   // private int oldPosition = 0;
	    //存放图片的id
	   /* private int[] imageIds = new int[]{
	    		R.drawable.pic1,
	    		R.drawable.pic2
	    };
	  //存放图片的标题
	    private String[] titles = new String[]{
	    		"查询违章",
	    		"办理缴费"
	    }; */
	 //   private TextView title;
	  //  private ViewPagerAdapter adapter;
	  //  private ScheduledExecutorService scheduledExecutorService;
	    
	    //private Context mContext;
	//初始化fragment
	private HomePageFragment mHomePageFragment;
    private AddPageFragment mAddPageFragment;
    private FoundPageFragment mFoundPageFragment;
    private MinePageFragment mSettingPageFragment;
    
    //片段类容
    private FrameLayout mFlFragmentContent;
    //4个布局
    private RelativeLayout mRlFirstLayout;
    private RelativeLayout mRlSecondLayout;
    private RelativeLayout mRlThirdLayout;
    private RelativeLayout mRlFourLayout;

    private ImageView mIvFirstHome;
    private TextView mTvFirstHome;
    private ImageView mIvSecondMatch;
    private TextView mTvSecondMatch;
    private ImageView mIvThirdRecommend;
    private TextView mTvThirdRecommend;
    private ImageView mIvFourMine;
    private TextView mTvFourMine;
    //private Button mTvMine;
    
    private ImageButton mIvLogin;
	private ImageButton mIvSetting;
	
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;
    

    /*
    //首页菜单的图片数组
    private static final int[] bigModuleDrawables = {
    	R.drawable.homepage_icon_car,
    	R.drawable.homepage_icon_price,
    	R.drawable.homepage_icon_issue,
    	R.drawable.homepage_icon_shop,
    };
    //首页菜单的标题数组
    private static final String[] bigModuleTitles = {
    	"我的车库","实时油价","违章热点","车主商城"	
    };

*/
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mFragmentManager = getFragmentManager();
		//StatusBarUtil.setColor(this, getResources().getColor(R.color.colorStatusBar), 0);

		//绑定控件
		mFlFragmentContent = (FrameLayout) findViewById(R.id.fl_fragment_content);
        mRlFirstLayout = (RelativeLayout) findViewById(R.id.rl_first_layout);
        mIvFirstHome = (ImageView) findViewById(R.id.iv_first_home);
        mTvFirstHome = (TextView) findViewById(R.id.tv_first_home);
        mRlSecondLayout = (RelativeLayout) findViewById(R.id.rl_second_layout);
        mIvSecondMatch = (ImageView) findViewById(R.id.iv_second_add);
        mTvSecondMatch = (TextView) findViewById(R.id.tv_second_add);
        mRlThirdLayout = (RelativeLayout) findViewById(R.id.rl_third_layout);
        mIvThirdRecommend = (ImageView) findViewById(R.id.iv_third_found);
        mTvThirdRecommend = (TextView) findViewById(R.id.tv_third_found);
        mRlFourLayout = (RelativeLayout) findViewById(R.id.rl_forth_layout);
        mIvFourMine = (ImageView) findViewById(R.id.iv_forth_setting);
        mTvFourMine = (TextView) findViewById(R.id.tv_forth_setting);
        //mTvMine = (Button)findViewById(R.id.tv_mine_page);
        
        mIvLogin=(ImageButton)findViewById(R.id.iv_user_login);
		mIvSetting=(ImageButton)findViewById(R.id.iv_setting);
        
      //为按钮设置监听器
        mRlFirstLayout.setOnClickListener(this);
        mRlSecondLayout.setOnClickListener(this);
        mRlThirdLayout.setOnClickListener(this);
        mRlFourLayout.setOnClickListener(this);
        //mTvMine.setOnClickListener(this);
        //默认第一个页面被选中
        mRlFirstLayout.setSelected(true);
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.replace(R.id.fl_fragment_content, new HomePageFragment());
        mTransaction.commit();
        
        
		
		initView();
	}
	
	private void initView()
	{
		
		mFlFragmentContent = (FrameLayout) findViewById(R.id.fl_fragment_content);
        mRlFirstLayout = (RelativeLayout) findViewById(R.id.rl_first_layout);
        mIvFirstHome = (ImageView) findViewById(R.id.iv_first_home);
        mTvFirstHome = (TextView) findViewById(R.id.tv_first_home);
        mRlSecondLayout = (RelativeLayout) findViewById(R.id.rl_second_layout);
        mIvSecondMatch = (ImageView) findViewById(R.id.iv_second_add);
        mTvSecondMatch = (TextView) findViewById(R.id.tv_second_add);
        mRlThirdLayout = (RelativeLayout) findViewById(R.id.rl_third_layout);
        mIvThirdRecommend = (ImageView) findViewById(R.id.iv_third_found);
        mTvThirdRecommend = (TextView) findViewById(R.id.tv_third_found);
        mRlFourLayout = (RelativeLayout) findViewById(R.id.rl_forth_layout);
        mIvFourMine = (ImageView) findViewById(R.id.iv_forth_setting);
        mTvFourMine = (TextView) findViewById(R.id.tv_forth_setting);
        //mTvMine = (Button)findViewById(R.id.tv_mine_page);
        //�������ť���ü�����
        mRlFirstLayout.setOnClickListener(this);
        mRlSecondLayout.setOnClickListener(this);
        mRlThirdLayout.setOnClickListener(this);
        mRlFourLayout.setOnClickListener(this);
        //mTvMine.setOnClickListener(this);
        //Ĭ�ϵ�һ����ҳ��ѡ�и�����ʾ
        mRlFirstLayout.setSelected(true);
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.replace(R.id.fl_fragment_content, new HomePageFragment());
        mTransaction.commit();
        
       // mViewPager =(ViewPager)findViewById(R.id.vp);
        
        /*
        //Banner显示的图片
        images = new ArrayList<ImageView>();
        for(int i=0;i< imageIds.length;i++){
        	ImageView imageView = new ImageView(this);
        	imageView.setBackgroundResource(imageIds[i]);
        	images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        
        title = (TextView) findViewById(R.id.title);
        title.setText(titles[0]);
        
        adapter = new ViewPagerAdapter();
        mViewPager.setAdapter(adapter);
        
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        	@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				title.setText(titles[position]);
				dots.get(position).setBackgroundResource(R.drawable.dot_focused);
				dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
				
				oldPosition = position;
				currentItem = position;
			}
			
			
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        */

	}
	
    
	@Override
	public void onClick(View v) {
		mTransaction = mFragmentManager.beginTransaction(); //��������
        hideAllFragment(mTransaction);
        switch (v.getId())
        {
            //��ҳ
            case R.id.rl_first_layout:
            	seleted();
            	mRlFirstLayout.setSelected(true);
            	if (mHomePageFragment == null) 
            	{
            		mHomePageFragment = new HomePageFragment();
            		mTransaction.add(R.id.fl_fragment_content,mHomePageFragment);    //ͨ������������ӵ�����ҳ
            		}
            	else
            	{
            		mTransaction.show(mHomePageFragment);
            	}
            	break;
            	//���
            case R.id.rl_second_layout:
                seleted();
                mRlSecondLayout.setSelected(true);
                if (mAddPageFragment == null) 
                {
                    mAddPageFragment = new AddPageFragment();
                    mTransaction.add(R.id.fl_fragment_content,mAddPageFragment);    //ͨ������������ӵ�����ҳ
                }
                else{
                    mTransaction.show(mAddPageFragment);
                }
             break;
              //������Ϣ
                case R.id.rl_third_layout:
                	seleted();
                	mRlThirdLayout.setSelected(true);
                	if (mFoundPageFragment == null) {
                		mFoundPageFragment = new FoundPageFragment();
                    mTransaction.add(R.id.fl_fragment_content,mFoundPageFragment);    //ͨ������������ӵ�����ҳ
                }
                else{
                    mTransaction.show(mFoundPageFragment);
                }
                break;
            //�ҵ�
                case R.id.rl_forth_layout:
                seleted();
                mRlFourLayout.setSelected(true);
                if (mSettingPageFragment == null) {
                    mSettingPageFragment = new MinePageFragment();
                    mTransaction.add(R.id.fl_fragment_content,mSettingPageFragment);    //ͨ������������ӵ�����ҳ
                }
                else{
                    mTransaction.show(mSettingPageFragment);
                }
                break;
        /*   //��ҳ������
                case R.id.main_add_car_btn:
                	seleted();
                    mRlSecondLayout.setSelected(true);
                    if (mAddPageFragment == null) 
                    {
                        mAddPageFragment = new AddPageFragment();
                        mTransaction.add(R.id.fl_fragment_content,mAddPageFragment);    //ͨ������������ӵ�����ҳ
                    }
                    else{
                        mTransaction.show(mAddPageFragment);
                    }
                 break;   */
           
        }
        mTransaction.commit();
	}
	
	public void addcar(View view){
		mTransaction = mFragmentManager.beginTransaction(); //��������
        hideAllFragment(mTransaction);
        
        seleted();
        mRlSecondLayout.setSelected(true);
        if (mAddPageFragment == null) 
        {
            mAddPageFragment = new AddPageFragment();
            mTransaction.add(R.id.fl_fragment_content,mAddPageFragment);    //ͨ������������ӵ�����ҳ
        }
        else{
            mTransaction.show(mAddPageFragment);
        }
        
        mTransaction.commit();
	}
	
	public void mycar_manage(View v){
		Intent hp_to_carmanage =new Intent();
		hp_to_carmanage.setClass(MainActivity.this, CarManageActivity.class);
		startActivity(hp_to_carmanage);
	}
	
	public void login(View v){
		Intent mine_to_login =new Intent();
		mine_to_login.setClass(MainActivity.this, LoginActivity.class);
		startActivity(mine_to_login);
	}
	
	public void onClick_setting(View v){
		Intent mine_to_setting =new Intent();
		mine_to_setting.setClass(MainActivity.this, SettingActivity.class);
		startActivity(mine_to_setting);
	}
	
	
	private class ClickSpannable extends ClickableSpan implements OnClickListener {
		
		private View.OnClickListener onClickListener;
		
		public ClickSpannable(View.OnClickListener onClickListener) {
			
			this.onClickListener = onClickListener;
		}
		
		@Override
		public void onClick(View widget){
			onClickListener.onClick(widget);
		}
	
	} 

	
	//�������а�ť����Ĭ�϶���ѡ��
    private void seleted() {
        mRlFirstLayout.setSelected(false);
        mRlSecondLayout.setSelected(false);
        mRlThirdLayout.setSelected(false);
        mRlFourLayout.setSelected(false);
    }
    
  //ɾ������fragment
    private void hideAllFragment(FragmentTransaction transaction) {
        if (mHomePageFragment != null) {
            transaction.hide(mHomePageFragment);
        }
        if (mAddPageFragment != null) {
            transaction.hide(mAddPageFragment);
        }
        if (mFoundPageFragment != null) {
            transaction.hide(mFoundPageFragment);
        }
        if (mSettingPageFragment != null) {
            transaction.hide(mSettingPageFragment);
        }
    }
    
    /*
    
  //自定义Adapter
    private class ViewPagerAdapter extends PagerAdapter{
    	
    	@Override
    	public int getCount(){
    		return images.size();
    	}
    	
    	@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
    	
    	@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			// TODO Auto-generated method stub
//			super.destroyItem(container, position, object);
//			view.removeView(view.getChildAt(position));
//			view.removeViewAt(position);
			view.removeView(images.get(position));
		}
    	
    	@Override
		public Object instantiateItem(ViewGroup view, int position) {
			// TODO Auto-generated method stub
			view.addView(images.get(position));
			return images.get(position);
		}


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	// Inflate the menu; this adds items to the action bar if it is present.
    			getMenuInflater().inflate(R.menu.main, menu);
    			return true;
    }
    
    //利用线程池定时执行动画轮播
    @Override
    protected void onStart(){
    	// TODO Auto-generated method stub
    			super.onStart();
    			scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    			scheduledExecutorService.scheduleWithFixedDelay(
    					new ViewPageTask(), 
    					2, 
    					2, 
    					TimeUnit.SECONDS);

    }
  //图片轮播任务
    private class ViewPageTask implements Runnable{
    	
    	@Override
    	public void run(){
    		currentItem = (currentItem + 1) % imageIds.length;
    		mHandler.sendEmptyMessage(0);
    	}
    }
    
    //接收子线程传递过来的数据
    private Handler mHandler = new Handler(){
    	public void handleMessage(android.os.Message msg){
    		mViewPager.setCurrentItem(currentItem);
    	};
    };
    @Override
    protected void onStop(){
    	// TODO Auto-generated method stub
    			super.onStop();
    			if(scheduledExecutorService != null){
    				scheduledExecutorService.shutdown();
    				scheduledExecutorService = null;
    			}
    }
    
    */
    
   

}
	

