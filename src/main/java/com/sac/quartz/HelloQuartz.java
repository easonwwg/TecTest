package com.sac.quartz;

import org.quartz.*;

import java.util.Date;

/**
 * @author:eason
 * @Description：
 * @Date: 16:15,2018/1/16
 * @ModifiedBy
 */
public class HelloQuartz implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        Trigger trigger = context.getTrigger();
        //获取trigger信息
        System.out.println("trigger--"+trigger.getKey().getGroup());
        String name = detail.getJobDataMap().getString("name");
        //获取job信息
        System.out.println("job-"+detail.getKey().getGroup()+"-"+detail.getKey().getName());
        System.out.println("say hello to " + name + " at " + new Date());
    }
}
