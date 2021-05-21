package com.cbry.quartz;

import java.util.concurrent.TimeUnit;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain{
	
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		//调度工厂创建调度器
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();	//throw SchedulerException
		
		//创建JobDetail实例
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class).withIdentity("job_1", "group_1").build();
		
		//构建调度触发器
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_1", "trigger1_group_1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()	//调度方式，注意后面的详细方法依旧在withSchedule中
						.withIntervalInSeconds(1)						//每一秒执行一次
						.repeatForever()								//一直执行
				).startNow()											//立即执行
				.build();
		
		//调度器调用任务实例和触发实例，进行实例调度
		scheduler.scheduleJob(jobDetail,trigger);
		System.out.println("--------scheduler start ! ------------");
		scheduler.start();
		
        //睡眠
        TimeUnit.MINUTES.sleep(1);	//throw InterruptedException
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");
	}
}