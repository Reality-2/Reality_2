package com.reality_2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class splash extends Activity{
	
	MediaPlayer player;
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.splash);
		player = MediaPlayer.create(splash.this, R.raw.e1m1);
		player.start();
        Thread mainTread = new Thread(){
        	public void run(){
        		try{
        			sleep(8500);
        		}catch(InterruptedException e){
        			e.printStackTrace();
        		}finally{
        			Intent openmain = new Intent("com.reality_2.MAINACTIVITY");
        			startActivity(openmain);
        		}
        	}
        };
        mainTread.start();
	}
	
    public void onPause(){
    	super.onPause();
    	player.release();
    	finish();
    }
}
