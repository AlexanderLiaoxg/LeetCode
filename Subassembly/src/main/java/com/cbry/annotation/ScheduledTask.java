package com.cbry.annotation;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component	//bootapp启动的时候注入容器
public class ScheduledTask {
	//@Scheduled(cron = "0/2 * * * * ?")
	public void test() {
		System.err.println("Scheduled Test");
	}
}
