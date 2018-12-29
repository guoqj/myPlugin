package point.mmh.com.myplugin.voice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;

import point.mmh.com.myplugin.TTSUtils;

/**
 * @author guoqj
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/28 0028
 */
public class MMhVoiceManage {
    private static volatile MMhVoiceManage instance = null;
    Context context;
    MMhVoiceControl voiceControl;


    public MMhVoiceManage(@NonNull Context context) {
        if (null == context || null == context.getApplicationContext())
            return;
        this.context = context.getApplicationContext();
        initVoideControl();
    }

    //单例模式
    public static MMhVoiceManage getInstance(@NonNull Context context) {
        if (instance == null) {
            synchronized (MMhVoiceManage.class) {
                if (instance == null) {
                    instance = new MMhVoiceManage(context);
                }
            }
        }
        return instance;
    }

    public MMhVoiceManage setVoideMode(int mode) {
        initVoideControl();
        voiceControl.setVoideMode(mode);
        return this;
    }

    /**
     * 播放
     *
     *
     * 默认的普通模式播放，来了两个了，当前播放后一个
     *
     * 栈模式，来几个播放几个，顺序播放，根据加入栈中的顺序自动播放
     *
     * @param msg
     */
    public void playVideo(String msg) {
        initVoideControl();
        if (!TextUtils.isEmpty(msg))
            voiceControl.playVideo(msg);
    }

    /**
     * 播放
     *
     * @param strs
     */
    public void playVideo(List<String> strs) {
        initVoideControl();
        if (null != strs && strs.size() > 0)
            voiceControl.playVideo(strs);
    }

    /**
     * 初始化
     */
    void initVoideControl() {
        if (null == voiceControl)
            voiceControl = new MMhVoiceControl(context);
    }
}
