package com.cbry.mybatis.plus;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
//这个注解的意义是指定了默认数据源
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.cbry.mybatis.plus")	//开启mybatis-plus
public class MybatisPlusDoIt {
	@Autowired
	MPDao mpDao;
	
	@Test
	public void testMybatisPlus() {
		 System.out.println(("----- selectAll method test ------"));
	        List<MPUserPoJo> userList = mpDao.selectList(null);
	        userList.forEach(System.out::println);
		//mpDao.insert(new MPUserPoJo("20210605","cbry",25 , new Date()));
	}
	
}
