package point.mmh.com.myplugin.workmanager;//package cn.atmobi.base_module.utils.workmanager;

import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;

//
//import android.support.annotation.NonNull;
//
//import com.evernote.android.job.Job;
//import com.evernote.android.job.JobManager;
//import com.evernote.android.job.JobRequest;
//
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//
//
///**
// * @author guoqj
// * @version 2.5.4
// * @描述:
// * @Copyright Copyright (c) 2016
// * @Company 昆山妈妈好网络科技有限公司
// * @date 2018/11/23 0023
// */
//
public class ShowNotificationTestJob extends Job {

    public static final String TAG = "show_notification_job_test_tag";

    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        System.out.println("-----------ShowNotificationTestJob--------------------------");
        handleWork();
        return Result.SUCCESS;
    }

    /**
     * 执行任务
     */
    private synchronized void handleWork() {

    }

    public static void schedulePeriodic() {
        try {
            JobManager.instance().cancelAll();
           // System.out.println("schedulePeriodic----------------------------------------" + new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(new Date(System.currentTimeMillis())));
            new JobRequest.Builder(ShowNotificationTestJob.TAG)
                    .startNow()
                    .build()
                    .schedule();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        int jobId = new JobRequest.Builder(ShowNotificationTestJob.TAG)
//                .setExecutionWindow(30_000L, 40_000L)
//                .setBackoffCriteria(5_000L, JobRequest.BackoffPolicy.EXPONENTIAL)
//                .setRequiresCharging(true)
//                .setRequiresDeviceIdle(false)
//                .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
//                .setRequirementsEnforced(true)
//                .setUpdateCurrent(true)
//                .build()
//                .schedule();
//        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this, TestService.class));  //指定哪个JobService执行操作
//        builder.setMinimumLatency(TimeUnit.MILLISECONDS.toMillis(10)); //执行的最小延迟时间
//        builder.setOverrideDeadline(TimeUnit.MILLISECONDS.toMillis(15));  //执行的最长延时时间
//        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_NOT_ROAMING);  //非漫游网络状态
//        builder.setBackoffCriteria(TimeUnit.MINUTES.toMillis(10), JobInfo.BACKOFF_POLICY_LINEAR);  //线性重试方案
//        builder.setRequiresCharging(false); // 未充电状态
//        jobScheduler.schedule(builder.build());
    }

}
