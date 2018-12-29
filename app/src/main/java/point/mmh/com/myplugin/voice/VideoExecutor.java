package point.mmh.com.myplugin.voice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guoqj
 * @描述:声音的队列
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/28 0028
 */
public class VideoExecutor {


    //一个保存的队列

    private List<VideoBeans> videoStacks;

    public VideoExecutor() {
        initStack();
    }

    void initStack() {
        if (null == videoStacks)
            videoStacks = new ArrayList<>();
    }

    /**
     *加入栈
     * @param beans
     */
    public synchronized void putStack(VideoBeans beans) {
        initStack();
        videoStacks.add(beans);
    }
    /**
     *加入栈
     * @param beans
     */
    public synchronized void putStacks(List<VideoBeans> beans) {
        initStack();
        videoStacks.addAll(beans);
    }
    /**
     * 获取最先入栈的元素
     * @return
     */
    public VideoBeans getVideoOldElement() {
        if (hasElements() && null != videoStacks.get(0)) {
            return videoStacks.get(0);
        }
        return null;
    }

    /**
     * 获取最近加入栈的元素
     * @return
     */
    public VideoBeans getVideoRecentElement() {
        if (hasElements() && null != videoStacks.get(0)) {
            return videoStacks.get(0);
        }
        return null;
    }

    /**
     * 移除栈里的某个元素
     * @param beans
     */
    void remove(VideoBeans beans) {
        if (hasElements())
            this.videoStacks.remove(beans);
    }

    /**
     * 是否有元素
     * @return
     */
    boolean hasElements() {
        return null != videoStacks && videoStacks.size() > 0;
    }

    /**
     * 清空栈
     */
    void clearStack() {
        if (null != videoStacks)
            videoStacks.clear();
    }
}
