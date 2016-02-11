package com.example.viewpagerslideblock;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentA extends Fragment{
	
	private ListView mListView;
	
	public static FragmentA newInstance(int index){
		FragmentA fragmentA = new FragmentA();
		Bundle args = new Bundle();  
        args.putInt("index", index);  
        fragmentA.setArguments(args);  
		return fragmentA;
	}
	
	public int getShownIndex() {  
        return getArguments().getInt("index", 0);  
    }  
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_a, container, false);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mListView = (ListView) getView().findViewById(R.id.listView);
		String[] data = new String[100];
		for(int i = 0; i < 100; i++){
			data[i] = "Line"+String.valueOf(i);
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, data);
		mListView.setAdapter(adapter);
	}
}
