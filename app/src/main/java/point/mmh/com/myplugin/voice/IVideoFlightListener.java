package point.mmh.com.myplugin.voice;

/**
 * @author guoqj
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/29 0029
 */
public interface IVideoFlightListener {


    void initVideo();

    void playVideo(String msg);

    void pause();

    void resume();

    void stop();

    void destory();

    boolean isSpeaking();

}
