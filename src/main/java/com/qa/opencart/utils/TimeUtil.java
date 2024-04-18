package com.qa.opencart.utils;

public class TimeUtil {

	public final static int DEFAULT_TIME = 500;
	public final static int DEFAULT_SHORT_TIME = 2;
	public final static int DEFAULT_MEDIUM_TIME = 5;
	public final static int DEFAULT_LONG_TIME = 10;
	public final static int MAX_TIME = 15;

	public static void applyWait(int waitTime) {
		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void defaultTime() {
		try {
			Thread.sleep(DEFAULT_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void shortTime() {
		try {
			Thread.sleep(DEFAULT_SHORT_TIME * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void mediumTime() {
		try {
			Thread.sleep(DEFAULT_MEDIUM_TIME * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void longTime() {
		try {
			Thread.sleep(DEFAULT_LONG_TIME * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void maxTime() {
		try {
			Thread.sleep(MAX_TIME * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}