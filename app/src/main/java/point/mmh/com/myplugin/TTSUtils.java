package point.mmh.com.myplugin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechEvent;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

/**
 * @author guoqj
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/27 0027
 */
public class TTSUtils implements InitListener, SynthesizerListener {
    private static volatile TTSUtils instance = null;
    private boolean isInitSuccess = false;
    private SpeechSynthesizer mTts;
    Context context;

    public TTSUtils(@NonNull Context context) {
        init(context);
    }

    //单例模式
    public static TTSUtils getInstance(@NonNull Context context) {
        if (instance == null) {
            synchronized (TTSUtils.class) {
                if (instance == null) {
                    instance = new TTSUtils(context);
                }
            }
        }
        return instance;
    }

    // 初始化合成对象
     void init(@NonNull Context context) {
        if (null == context.getApplicationContext())
             new NullPointerException("content不能为空");
        this.context=context;
        mTts = SpeechSynthesizer.createSynthesizer(context.getApplicationContext(), this);
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
        // 设置音频保存路径，需要申请WRITE_EXTERNAL_STORAGE权限，如不需保存注释该行代码
        //  mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./sdcard/iflytek.pcm");
    }

    //开始合成
    public void speak(Context context, String msg) {
        if (isInitSuccess) {
            if (mTts.isSpeaking()) {
                stop();
            }
            mTts.startSpeaking(msg, this);
        } else {
            init(context);
        }
    }

    public void stop() {
        mTts.stopSpeaking();
    }

    @Override
    public void onEvent(int eventType, int i1, int i2, Bundle bundle) {
        //以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
        if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            String sid = bundle.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
        }
    }

    @Override
    public void onInit(int code) {
        if (code == ErrorCode.SUCCESS) {
            isInitSuccess = true;
        }
    }

    @Override
    public void onSpeakBegin() {
        // 监听：开始播放
    }

    @Override
    public void onBufferProgress(int percent, int beginPos, int endPos,
                                 String info) {
        // 合成进度
    }

    @Override
    public void onSpeakPaused() {
        // 暂停播放
    }

    @Override
    public void onSpeakResumed() {
        // 继续播放
    }

    @Override
    public void onSpeakProgress(int percent, int beginPos, int endPos) {
        // 播放进度
    }

    @Override
    public void onCompleted(SpeechError speechError) {
        if (speechError != null) {
        }
        System.out.println("onCompletedonCompletedonCompletedonCompleted");
    }

    public void pause() {
        mTts.pauseSpeaking();
    }

    public void resume() {
        mTts.resumeSpeaking();
    }

    public void release() {
        if (null != mTts) {
            mTts.stopSpeaking();
            mTts.destroy();  //退出时释放
        }
    }
}


