package com.bdqn.comic.activity.sys;

import com.bdqn.comic.activity.core.BaseActivity;
import com.bdqn.comic.activity.sdcard.TabMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import cn.com.mythos.touhoucartoonreader.R;

public class InitActivity extends BaseActivity{
	private ImageButton choose;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_init);
		choose = (ImageButton) findViewById(R.id.choose);
		choose.setOnClickListener(openSDcardButton);
	}
	
	private Button.OnClickListener openSDcardButton = new Button.OnClickListener() {
		
		public void onClick(View v) {
			Intent intent = new Intent(InitActivity.this, TabMainActivity.class);
			startActivity(intent);
			finish();
		}
	};
	
}
