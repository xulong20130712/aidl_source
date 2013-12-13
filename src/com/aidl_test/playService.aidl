package com.aidl_test;

interface playService {

	void play();

	void pause();

	void stop();

	int getDuration();

	int getCurrentPosition();
	void seekTo(int current);
	boolean setLoop(boolean loop);
}