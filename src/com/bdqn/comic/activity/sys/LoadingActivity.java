package com.bdqn.comic.activity.sys;

import com.bdqn.comic.activity.core.MainActivity;
import com.bdqn.comic.util.Contents;
import com.bdqn.comic.util.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import cn.com.mythos.touhoucartoonreader.R;

/**
 * loading界面
 */
public class LoadingActivity extends Activity {
	private static final String TAG = "Loading";
	private Intent intent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_loading);
		if(!Utils.createFile()){
        	Toast.makeText(this, "SDCard不存在", Toast.LENGTH_SHORT).show();
        	System.exit(1);
        }else{
        	onLoading();
        }
	}

	private void onLoading() {
		new Thread() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally{
					if(getShowHistory()) {
						intent = new Intent(LoadingActivity.this, MainActivity.class);
						startActivity(intent);
						finish();
					}else {
						intent = new Intent(LoadingActivity.this, InitActivity.class);
						startActivity(intent);
						finish();
					}	
				}
			}
			
		}.start();
	}
	
	//判断是否存在浏览图片的历史记录
	public boolean getShowHistory() {
		String picPath = Utils.getFileRead(Contents.SHOWHISTORY);
		if(picPath != null && picPath.length() > 0) {
			return true;
		}
		return false;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
