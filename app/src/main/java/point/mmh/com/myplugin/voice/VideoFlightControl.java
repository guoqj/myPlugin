package point.mmh.com.myplugin.voice;

import android.content.Context;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechSynthesizer;

/**
 * @author guoqj
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/29 0029
 */
public class VideoFlightControl implements IVideoFlightListener {
    SpeechSynthesizer mTts;
    Context context;
    VideoSynMonitor videoSynMonitor;

    public VideoFlightControl( Context context, VideoSynMonitor videoSynMonitor) {
        this.context = context;
        this.videoSynMonitor = videoSynMonitor;
    }

    public void initVideo() {
        try {
            mTts = SpeechSynthesizer.createSynthesizer(context, videoSynMonitor);
            // 清空参数
            mTts.setParameter(SpeechConstant.PARAMS, null);
            // 设置在线云端
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            // 设置发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
            // 设置发音语速
            mTts.setParameter(SpeechConstant.SPEED, "50");
            // 设置音调
            mTts.setParameter(SpeechConstant.PITCH, "50");
            // 设置合成音量
            mTts.setParameter(SpeechConstant.VOLUME, "100");
            // 设置播放器音频流类型
            mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");
            // 设置播放合成音频打断音乐播放，默认为true
            mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");
        } catch (Exception e) {

        }
    }

    public void playVideo(String msg) {
        if(null==mTts||null==videoSynMonitor)
            return;
        mTts.startSpeaking(msg, videoSynMonitor);
    }

    /**
     * 暂停播放
     */
    public void pause() {
        if(null==mTts||null==videoSynMonitor)
            return;
        mTts.pauseSpeaking();
    }

    /**
     * 恢复播放
     */
    public void resume() {
        if(null==mTts||null==videoSynMonitor)
            return;
        mTts.resumeSpeaking();
    }

    /**
     * 暂停播放
     */
    public void stop() {
        if(null==mTts||null==videoSynMonitor)
            return;
        mTts.stopSpeaking();
    }

    /**
     * 销毁
     */
    public void destory() {
        if (null != mTts) {
            mTts.stopSpeaking();
            mTts.destroy();  //退出时释放
        }
    }

    @Override
    public boolean isSpeaking() {
        return null!=mTts&&mTts.isSpeaking();
    }
}
