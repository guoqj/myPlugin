package point.mmh.com.myplugin.voice;

import com.iflytek.cloud.SynthesizerListener;

/**
 * @author guoqj
 * @描述:声音的监听器
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/28 0028
 */
public interface IVoideSynListener {

    void onInit(int i);

    void onCompleted();

    void onSpeakResumed();

    void onSpeakPaused();

    void onSpeakBegin();


}
