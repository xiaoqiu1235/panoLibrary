package com.pano.player;

import com.player.panoplayer.PanoPlayer;

public interface PlayStateChangedListener {

    /**
     * 初始化播放器状态
     */
    void onStateInit();

    /**
     * 播放状态改变
     * 
     * 在这里你可以通过播放状态的改变来更改您的UI状态，如点播放按钮由播放状态变更为暂停状态
     * @param status 当前播放状态值
     */
    void onStateChanged(PanoPlayer.PanoVideoPluginStatus status);

    /**
     * 播放时间的变化
     * 
     * 在这里你可以通过播放时间的变化来改变您的播放进度条
     * @param curTime 当前进度时间
     * @param bufTime 当前缓冲时间
     * @param maxTime 视频总时长
     */
    void onTimeChanged(int curTime, int bufTime, int maxTime);

    /**
     * 播放结束
     */
    void onPlayComplete();

    /**
     * 播放出错
     * 
     * 在这里你可以通过错误状态码来判断当前错误并显示在用户界面
     * @param status 错误码
     * @param msg 错误信息
     */
    void onPlayError(PanoPlayer.PanoPlayerErrorStatus status, String msg);
    
}
