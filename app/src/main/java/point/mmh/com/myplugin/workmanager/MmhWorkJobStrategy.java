package point.mmh.com.myplugin.workmanager;

import android.content.Context;

import com.evernote.android.job.JobManager;


/**
 * @author guoqj
 * @version 2.5.4
 * @描述:妈妈好兜底策略工具类
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/11/26 0026
 */

public class MmhWorkJobStrategy {
    /**
     * 全局初始化
     *
     * @param context
     */
    public static void initMMhWorkJob(Context context) {
        if (isMMhWorkJobConfig(context)) {
            return;
        }
        try {
            System.out.println("initMMhWorkJob1");
            JobManager.create(context).addJobCreator(new WorkJobCreatorFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动兜底
     */
    public static void startWork(Context context) {
        if (isMMhWorkJobConfig(context)) {
            return;
        }
        try {
            WorkJob.schedulePeriodic(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 停止
     */
    public static void stopWork(Context context) {
        if (isMMhWorkJobConfig(context)) {
            return;
        }
        try {
            JobManager.instance().cancelAll();
        } catch (Exception e) {

        }
    }

    /**
     * 全局开关
     *
     * @param context
     * @return
     */
    public static boolean isMMhWorkJobConfig(Context context) {
        return false;
    }

    /**
     * 全局开关
     *
     * @param context
     * @return
     */
    public static void setMMhWorkJobConfig(Context context, boolean isConfig) {
        System.out.println("setMMhWorkJobConfigsetMMhWorkJobConfigsetMMhWorkJobConfig"+isConfig);
      //  SharedPreference.saveToSP(context, "isMMhWorkConfig", isConfig);
    }
}
