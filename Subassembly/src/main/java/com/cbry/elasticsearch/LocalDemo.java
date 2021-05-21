package com.cbry.elasticsearch;

import java.io.IOException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;

@SpringBootTest
public class LocalDemo {
	
	   @Autowired
	    @Qualifier("restHighLevelClient")
	    private RestHighLevelClient client;
	
	 //测试创建索引库
    @Test
    public void createIndex() throws IOException {
        //创建请求
        CreateIndexRequest request = new CreateIndexRequest("my_Index");
        //执行请求
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());//org.elasticsearch.client.indices.CreateIndexResponse@6a5dc7e
    }
//
//
//    //查看索引库是否存在 true存在，false不存在
//    @Test
//    void existsIndex() throws IOException {
//        //创建请求
//        GetIndexRequest request = new GetIndexRequest("test1");
//        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
//        System.out.println(exists);
//    }
//
//
//    //删除索引库
//    @Test
//    void deleteIndex() throws IOException {
//        DeleteIndexRequest request = new DeleteIndexRequest("test1");
//        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
//        System.out.println(delete.isAcknowledged());//删除成功返回true，失败返回false
//    }
//    
//    //添加文档
//    @Test
//    void createDocument() throws IOException {
//        //创建添加数据
//    	String word = "ES测试JAVA中的SpringBoot项目";
//        //声明要保存到那个索引库
//        IndexRequest request = new IndexRequest("my_Index");
//        request.id("1").timeout("1s");
//
//        //给请求放入数据
//        request.source(JSON.toJSONString(word), XContentType.JSON);
//        //执行请求
//        IndexResponse resp = client.index(request, RequestOptions.DEFAULT);
//        System.out.println(resp);//和我们使用命令添加时显示的差不多
//        System.out.println(resp.status());//CREATED
//    }

}
