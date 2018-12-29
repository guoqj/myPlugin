package point.mmh.com.myplugin.voice;

import android.os.Bundle;

import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SynthesizerListener;

/**
 * @author guoqj
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/28 0028
 */
public class VideoSynMonitor implements SynthesizerListener, InitListener {
    public VideoSynMonitor(IVoideSynListener listener) {
        this.listener = listener;
    }

    IVoideSynListener listener;

    @Override
    public void onInit(int i) {
        if (null == listener)
            return;
        listener.onInit(i);
    }

    @Override
    public void onSpeakBegin() {
        if (null == listener)
            return;
        listener.onSpeakBegin();
    }

    @Override
    public void onBufferProgress(int i, int i1, int i2, String s) {
        if (null == listener)
            return;
    }

    @Override
    public void onSpeakPaused() {
        if (null == listener)
            return;
        listener.onSpeakPaused();
    }

    @Override
    public void onSpeakResumed() {
        if (null == listener)
            return;
        listener.onSpeakResumed();
    }

    @Override
    public void onSpeakProgress(int i, int i1, int i2) {
        if (null == listener)
            return;
    }

    @Override
    public void onCompleted(SpeechError speechError) {
        if (null == listener)
            return;
        listener.onCompleted();
    }

    @Override
    public void onEvent(int i, int i1, int i2, Bundle bundle) {
        if (null == listener)
            return;

    }

}
