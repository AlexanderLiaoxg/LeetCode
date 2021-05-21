package com.cbry.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;


/*
 * 使用STS创建的SpringBoot项目，其中配置文件默认的是application.properties，一般在这个文件里面配置数据源。但是这个文件想要起作用，则必须在配置主类中加入
 * @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})自动注入，否则该配置文件中的配置无效。
 * */



@RunWith(SpringRunner.class)
@SpringBootTest
//这个注解的意义是指定了默认数据源
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.cbry.mybatis")
public class OrderServiceTest {
	@Resource
	OrderDao orderDao;
	
	//@Test
	public void test() {
		System.err.println("hello");
		System.err.println(orderDao.findCustomerById("001"));
		System.err.println(orderDao.findSimpleOrderInfo("0"));
		//System.err.println(orderDao.findOrderInfo("0"));
	}
	
	//@Test
	public void uuIdInsert() {
		 long start = System.currentTimeMillis();
		    for (int i = 0; i < 100000; i++) {
		       HashMap<String, String> customerMap = new HashMap<>();
		       customerMap.put("cid", UUID.randomUUID().toString());
		       customerMap.put("cname", "cbry_uu_id");
		       customerMap.put("cage", "99");
		       orderDao.insertOrderInfo(customerMap);
		    }
		    long end = System.currentTimeMillis();
			System.err.println("uuId，花费时间：" + (end - start) + "ms");
		}
	

	public void snowFlakeIdInsert() {
		
		//雪花Id生成器对象
		SnowflakeIdWorker snowWorker = SnowflakeIdWorker.getInstance();
		
		 long start = System.currentTimeMillis();
		    for (int i = 0; i < 100000; i++) {
		       HashMap<String, String> customerMap = new HashMap<>();
		       customerMap.put("cid",String.valueOf(snowWorker.nextId()));
		       customerMap.put("cname", "cbry_snowflake_id");
		       customerMap.put("cage", "99");
		       orderDao.insertOrderInfo(customerMap);
		    }
		    long end = System.currentTimeMillis();
			System.err.println("雪花id，花费时间：" + (end - start) + "ms");
		}
	
	@Test
	public void autoIncreasingIdInsert() {
		
		//数据库表设计的自增Id
		
		 long start = System.currentTimeMillis();
		    for (int i = 0; i < 100000; i++) {
		       HashMap<String, String> customerMap = new HashMap<>();
		       customerMap.put("cname", "cbry_autoIncrease_id");
		       customerMap.put("cage", "99");
		       orderDao.insertOrderInfo(customerMap);
		    }
		    long end = System.currentTimeMillis();
			System.err.println("自增Id，花费时间：" + (end - start) + "ms");
		}
}
