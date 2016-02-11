package com.example.viewpagerslideblock;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class CustomLinearLayout extends LinearLayout{

	private Scroller mScroller;
	
	public CustomLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mScroller = new Scroller(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		if(mScroller.computeScrollOffset()){
			scrollTo(mScroller.getCurrX(), 0);
			invalidate();
		}
	}
	
	public void startScroll(int s){
		mScroller.startScroll(getScrollX(), 0, s, 0, 1000);
		invalidate();
	}

}
