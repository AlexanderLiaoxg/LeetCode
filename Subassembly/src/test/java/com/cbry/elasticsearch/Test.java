package com.cbry.elasticsearch;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Reference;
import org.springframework.test.context.junit4.SpringRunner;

import com.cbry.SubassemblyApplication;

@RunWith(SpringRunner.class)
//设置为主启动类
@SpringBootTest(classes = SubassemblyApplication.class)
public class Test {
	@Reference
	UserDao userDao;
	
	@org.junit.Test
	public void doEasy() {
		// TODO Auto-generated method stub
		userDao.save(new UserBean(0, "ElasticSearch", 11));
		
		System.out.println(userDao.findAll());
	}


}
