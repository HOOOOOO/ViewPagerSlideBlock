package com.example.viewpagerslideblock;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter{

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
			return FragmentA.newInstance(0);
		case 1:
			return FragmentB.newInstance(0);
		case 2:
			return FragmentA.newInstance(0);
		case 3:
			return FragmentB.newInstance(0);
		case 4:
			return FragmentA.newInstance(0);
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}

}
