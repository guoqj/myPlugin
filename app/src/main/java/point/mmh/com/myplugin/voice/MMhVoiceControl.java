package point.mmh.com.myplugin.voice;

import android.content.Context;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.SpeechSynthesizer;

import java.util.List;

/**
 * @author guoqj
 * @描述:妈妈好声音的控制器
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/28 0028
 */
public class MMhVoiceControl implements IVoideSynListener {
    Context context;

    /**
     * 声音的监听
     */
    VideoSynMonitor videoSynMonitor;
    /**
     * 是否初始化成功
     */
    private boolean isInitSuccess = false;
    /**
     * 声音的队列
     */
    VideoExecutor videoExecutor;
    /**
     * 正在播放的video
     */
    VideoBeans currentVideo;
    /**
     * 讯飞的播放事件和初始化 做一层隔离
     */
    IVideoFlightListener flightListener;
    /**
     * 播放模式
     */
    int typeMode = IVideoConfig.modeComm;

    public MMhVoiceControl(Context context) {
        this.context = context;
        videoSynMonitor = new VideoSynMonitor(this);
        videoExecutor = new VideoExecutor();
        initViode();
    }

    /**
     *
     * 初始化
     *
     */
    void initViode() {
        flightListener = new VideoFlightControl(context, videoSynMonitor);
        flightListener.initVideo();
    }

    public void setVoideMode(int mode) {
      this.typeMode=mode;
    }

    /**
     * 播放
     */
    void play() {
        if (null == flightListener)
            return;
        //如果没有在播放 就取队列中的最先加入的值播放
        if (!flightListener.isSpeaking()) {
            currentVideo = videoExecutor.getVideoOldElement();
            if (null != currentVideo)
                flightListener.playVideo(currentVideo.getMsg());
        }
    }

    /**
     * 加入栈
     *
     * @param msg
     */
    void addStack(String msg) {
        //首先添加到队列中
        videoExecutor.putStack(VideoFactory.getVideoBeans(msg));
        play();
    }

    /**
     * 普通的模式
     *
     * @param msg
     */
    void playComm(String msg) {
        if (null == flightListener)
            return;
        try {
            if (flightListener.isSpeaking()) {
                stop();
            }
            flightListener.playVideo(msg);
        } catch (Exception e) {

        }
    }

    /**
     * 开始播放
     *
     * @param msg
     */
    public synchronized void playVideo(String msg) {
        System.out.println("==================" + msg);
        switch (typeMode) {
            case IVideoConfig.modeComm:
                //普通模式
                playComm(msg);
                break;
            case IVideoConfig.modeStack:
                //连续读模式
                addStack(msg);
                break;
        }
    }

    /**
     * 开始播放
     *
     * @param msg
     */
    public synchronized void playVideo(List<String> msg) {
        videoExecutor.putStacks(VideoFactory.getVideoBeans(msg));
        play();
    }

    /**
     * 暂停播放
     */
    public void pause() {
        if (null == flightListener)
            return;
        flightListener.pause();
    }

    /**
     * 恢复播放
     */
    public void resume() {
        if (null == flightListener)
            return;
        flightListener.resume();
    }

    /**
     * 暂停播放
     */
    public void stop() {
        if (null == flightListener)
            return;
        flightListener.stop();
    }

    /**
     * 是否初始化成功
     *
     * @param code
     */
    @Override
    public void onInit(int code) {
        System.out.println("==================" + code);
        if (code == ErrorCode.SUCCESS) {
            isInitSuccess = true;
        }
    }

    /**
     * 开始播放
     */
    @Override
    public void onSpeakBegin() {

    }

    /**
     * 播放完成
     */
    @Override
    public void onCompleted() {
        //播放完成后就消除队列中的值
        if (null != videoExecutor && null != currentVideo) {
            videoExecutor.remove(currentVideo);
            currentVideo = null;
            //然后在查看队列中是否有值在继续播放
            play();
        }
    }

    /**
     * 继续播放
     */
    @Override
    public void onSpeakResumed() {

    }

    /**
     * 播放暂停
     */
    @Override
    public void onSpeakPaused() {

    }

    /**
     * 销毁
     */
    public void destory() {
        if (null == flightListener)
            return;
        flightListener.destory();
    }
}
