package com.pano.player;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import android.os.Handler;
import android.os.Looper;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class a {

	private static String HOST_URL = null;
	private static final int TIME_OUT = 60 * 1000;
	private static OkHttpClient client;
	private static a instance;
	private Handler handler;

	private a() {
		client = new OkHttpClient();
		client.setConnectTimeout(TIME_OUT, TimeUnit.SECONDS);
		handler = new Handler(Looper.getMainLooper());
		try {
			HOST_URL = new d().h(d.a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static a getInstance() {
		if (instance == null) {
			synchronized (a.class) {
				if (instance == null) {
					instance = new a();
				}
			}
		}
		return instance;
	}

	private void b(String deviceId, ResultCallback callback) {
		Request request = new Request.Builder().url(HOST_URL + deviceId)
				.build();
		d(callback, request);
	}

	public static void c(String deviceId, ResultCallback callback) {
		getInstance().b(deviceId, callback);
	}

	private void d(final ResultCallback callback, Request request) {
		Request.Builder builder = request.newBuilder();
		client.newCall(builder.build()).enqueue(new Callback() {
			@Override
			public void onFailure(Request request, IOException e) {
				e(request, e, callback);
			}

			@Override
			public void onResponse(Response response) {
				try {
					String string = response.body().string();
					h(string, callback);
				} catch (IOException e) {
					e(response.request(), e, callback);
				}
			}
		});
	}

	public static abstract class ResultCallback {

		public abstract void onError(Request request, Exception e);

		public abstract void onResponse(String res);

	}

	private void e(final Request request, final Exception e,
			final ResultCallback callback) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				if (callback != null) {
					callback.onError(request, e);
				}
			}
		});
	}

	private void h(final String res, final ResultCallback callback) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				if (callback != null) {
					callback.onResponse(res);
				}
			}
		});
	}
}
