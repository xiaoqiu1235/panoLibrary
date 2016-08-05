package com.pano.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.player.data.panoramas.PanoramaData;
import com.player.panoplayer.IPanoPlayerListener;
import com.player.panoplayer.IPanoPlayerVideoPluginListener;
import com.player.panoplayer.PanoPlayer;
import com.player.panoplayer.Plugin;
import com.player.panoplayer.plugin.VideoPlugin;
import com.player.renderer.PanoPlayerSurfaceView;
import com.player.util.ViewMode;

/**
 * Created by Administrator on 2016-06-03.
 */
public class PanoLiveView extends RelativeLayout implements
		IPanoPlayerListener, IPanoPlayerVideoPluginListener {

	private PanoPlayerSurfaceView glView;
	private PanoPlayer panoPlayer;
	private PanoPlayListener playListener;
	private PlayStateChangedListener stateChangeListener;
	private VideoPlugin videoplugin;

	public PanoLiveView(Context context) {
		this(context, null);
	}

	public PanoLiveView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		glView = new PanoPlayerSurfaceView(context);
		glView.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT));
		ImageView imageView = new ImageView(context);
		LayoutParams lp = new LayoutParams(
				px2dip(context, 180), px2dip(context, 180));
		lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp.setMargins(0, px2dip(context, 40), px2dip(context, 40), 0);
		imageView.setLayoutParams(lp);
		imageView.setImageBitmap(getBitmap());
		panoPlayer = new PanoPlayer(glView, context);
		glView.setRenderer(panoPlayer);
		addView(glView);
		addView(imageView, lp);
	}

	private Bitmap getBitmap() {
		Bitmap bitmap = null;
		try {
			byte[] bitmapArray;
			bitmapArray = Base64.decode(d.c,Base64.DEFAULT);
			bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
					bitmapArray.length);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bitmap;
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public void live(String deviceId) {
		if (panoPlayer != null) {
			panoPlayer.setListener(this);
			panoPlayer.setVideoPluginListener(this);
			c.a(panoPlayer,deviceId);
		}
	}

	public void changeViewModel(ViewMode mode) {
		if (panoPlayer != null) {
			panoPlayer.setViewMode(mode);
		}
	}

	public void setGyroEnable(boolean flag) {
		if (panoPlayer != null) {
			panoPlayer.setGyroEnable(flag);
		}
	}

	public void setOnPanoPlayListener(PanoPlayListener playListener) {
		this.playListener = playListener;
	}

	public void setOnPlayStateChangedListener(
			PlayStateChangedListener stateChangedListener) {
		this.stateChangeListener = stateChangedListener;
	}

	public VideoPlugin getPlugin() {
		return videoplugin;
	}

	public void release() {
		if (panoPlayer != null) {
			panoPlayer.release();
		}
	}

	@Override
	public void PanoPlayOnLoading() {
		if (playListener != null) {
			playListener.onLoading();
		}
	}

	@Override
	public void PanoPlayOnLoaded() {
		Plugin plugin = panoPlayer.getCurPlugin();
		if (plugin != null && plugin instanceof VideoPlugin) {
			videoplugin = (VideoPlugin) plugin;
		}
		if (playListener != null) {
			playListener.onLoaded();
		}
	}

	@Override
	public void PanoPlayOnEnter(PanoramaData panoramaData) {

	}

	@Override
	public void PanoPlayOnLeave(PanoramaData panoramaData) {

	}

	@Override
	public void PanoPlayOnError(
			PanoPlayer.PanoPlayerErrorCode panoPlayerErrorCode) {
		if (playListener != null) {
			playListener.onError(panoPlayerErrorCode);
		}
	}

	@Override
	public void PluginVideoOnInit() {
		Plugin plugin = panoPlayer.getCurPlugin();
		if (plugin != null && plugin instanceof VideoPlugin) {
			videoplugin = (VideoPlugin) plugin;
		}
		if (stateChangeListener != null) {
			stateChangeListener.onStateInit();
		}
	}

	@Override
	public void PluginVideoOnStatusChanged(
			PanoPlayer.PanoVideoPluginStatus panoVideoPluginStatus) {
		if (stateChangeListener != null) {
			stateChangeListener.onStateChanged(panoVideoPluginStatus);
		}
	}

	@Override
	public void PluginVideoOnProgressChanged(int curTime, int bufTime,
			int maxTime) {
		if (stateChangeListener != null) {
			stateChangeListener.onTimeChanged(curTime, bufTime, maxTime);
		}
	}

	@Override
	public void PluginVideoOnSeekFinished() {
		if (stateChangeListener != null) {
			stateChangeListener.onPlayComplete();
		}
	}

	@Override
	public void PluginVideOnPlayerError(
			PanoPlayer.PanoPlayerErrorStatus panoPlayerErrorStatus, String s) {
		if (stateChangeListener != null) {
			stateChangeListener.onPlayError(panoPlayerErrorStatus, s);
		}
	}
}
