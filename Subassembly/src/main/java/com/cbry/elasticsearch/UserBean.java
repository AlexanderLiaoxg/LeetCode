package com.cbry.elasticsearch;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//通过这个注解，可以不用写gettersetter方法
//@Data
//通过这个注解可以声明一个文档，指定其所在的索引库和type
@Document(indexName = "my_index", type = "_doc")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 必须指定一个id
	 @Id
	int uid;
	 
	// 这里配置了分词器，字段类型，可以不配置，默认也可
	@Field(analyzer = "ik_smart", type = FieldType.Text)
	String name;
	
	 @Field(analyzer = "ik_smart", type = FieldType.Text)
	int age;
	 
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserBean(int uid, String name, int age) {
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserBean [uid=" + uid + ", name=" + name + ", age=" + age + "]";
	}

}
