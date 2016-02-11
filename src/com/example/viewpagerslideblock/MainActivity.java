package com.example.viewpagerslideblock;

import javax.crypto.Mac;

import com.example.viewpagerslideblock.ChooseBar.OnChooseListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager;
	private ChooseBar mChooseBar;
	private CustomLinearLayout mCustomLinearLayout;
	private int mWidthOfSlideBlock;
	private int mScrollXOfSlide;
	private int mCurrentPosition = 0;
	private boolean mIsBeChoose = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mWidthOfSlideBlock = this.getResources().getDisplayMetrics().widthPixels / 5;
		
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
		mChooseBar = (ChooseBar) findViewById(R.id.choosebar);
		mCustomLinearLayout = (CustomLinearLayout) mChooseBar.findViewById(R.id.customLayout);
		mChooseBar.setOnChooseListener(new OnChooseListener() {
			@Override
			public void beChoose(int id) {
				// TODO Auto-generated method stub
				mIsBeChoose = true;
				mViewPager.setCurrentItem(id, true);
			}
		});
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Log.d("onPageSelected", ""+arg0);
				if(!mIsBeChoose)
					mChooseBar.setCurrentPosition(arg0);
				//mCurrentPosition = arg0;
			}
			
			@Override
			public void onPageScrolled(int position, float arg1, int positionOffsetPixels) {
				// TODO Auto-generated method stub
				Log.i("onPageScrolled", ""+position+" "+arg1+" "+positionOffsetPixels);
				if(arg1 != 0 && mCurrentPosition == position && !mIsBeChoose)
					mCustomLinearLayout.scrollTo((int) (mScrollXOfSlide-mWidthOfSlideBlock*arg1), 0);
				if(arg1 != 0 && mCurrentPosition != position && !mIsBeChoose)
					mCustomLinearLayout.scrollTo((int) (mScrollXOfSlide+mWidthOfSlideBlock*(1-arg1)), 0);
			    if(arg1 == 0)
			    	mCurrentPosition = position;
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				if(arg0 == 1)
				      mScrollXOfSlide = mCustomLinearLayout.getScrollX();
				if(arg0 == 0){
					if(!mIsBeChoose){
						
						mCustomLinearLayout.scrollTo((int) (-mCurrentPosition*mWidthOfSlideBlock), 0);	
					}
				    mIsBeChoose = false;
				}
				Log.e("onPageScrollStateChanged", ""+arg0);
			}
		});
	}
}
