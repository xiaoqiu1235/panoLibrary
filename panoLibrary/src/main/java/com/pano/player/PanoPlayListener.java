package com.pano.player;

import com.player.panoplayer.PanoPlayer;

public interface PanoPlayListener {

    /**
     * 播放器数据正在加载中
     */
    void onLoading();

    /**
     * 播放器加载数据完毕
     */
    void onLoaded();

    /**
     * 播放出错
     * @param errorCode 错误码
     */
    void onError(PanoPlayer.PanoPlayerErrorCode errorCode);
}
