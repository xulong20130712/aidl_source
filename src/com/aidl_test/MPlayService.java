package com.aidl_test;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class MPlayService extends Service {

	public static MediaPlayer mPlayer;
	
	playService.Stub stub= new playService.Stub() {
		
		@Override
		public void play() throws RemoteException {
			
			System.out.println("`1234567890");
//			try {
//				TimeUnit.SECONDS.sleep(300);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			new Thread() {
				
				public void run() {
					
					mPlayer.start();
				}
			}.start();
		}

		@Override
		public void pause() throws RemoteException {
			mPlayer.pause();
		}

		@Override
		public void stop() throws RemoteException {
			mPlayer.stop();
		}

		@Override
		public int getDuration() throws RemoteException {
			return mPlayer.getDuration();
		}

		@Override
		public int getCurrentPosition() throws RemoteException {
			return mPlayer.getCurrentPosition();
		}

		@Override
		public void seekTo(int current) throws RemoteException {
			mPlayer.seekTo(current);
		}

		@Override
		public boolean setLoop(boolean loop) throws RemoteException {
			return false;
		}

	};
	MyBinder b;
	@Override
	public IBinder onBind(Intent intent) {

		System.out.println("---------------------------onBind");
		return stub;
//		return b;
	}
	
	public class MyBinder extends Binder {
		
		public Service getService() {
			
			return MPlayService.this;
		}
	}
	
	public void my_start() {
		
		System.out.println("mPlayer== null-->"+ (mPlayer== null));
		mPlayer.start();
	}
	
	public void pause() {
		
		mPlayer.pause();
	}
	
	public void stop() {
		
		mPlayer.stop();
	}
	private Person p;
	public void sendPerson(Person p) {
		
		this.p= p;
	}
	
	@Override
	public boolean stopService(Intent name) {

		System.out.println("---------------------------stopService");
		return super.stopService(name);
	}
	
	public int getCurr() {
		
		return mPlayer.getCurrentPosition();
	}
	
	@Override
	public void onCreate() {

		super.onCreate();
		b= new MyBinder();
		mPlayer= MediaPlayer.create(getApplicationContext(), R.raw.test);
	}
	
	@Override
	public void onDestroy() {

		super.onDestroy();
		mPlayer.stop();
		System.out.println("onDestroy");
	}
}