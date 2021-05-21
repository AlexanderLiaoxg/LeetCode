package com.cbry.elasticsearch;

import java.io.IOException;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class UserController {
	 @Autowired
	 UserDao userDao;
	 
	 @ResponseBody
	 @RequestMapping("/test")
	 public String test() {
		 
		userDao.save(new UserBean(0, "ElasticSearch add Kibana add Logstash", 11));
		String str = userDao.findAll().toString();
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		
		//MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "雄霸");
		
		
		WildcardQueryBuilder wqb = QueryBuilders.wildcardQuery("name", "ElasticSearch");
		boolQueryBuilder.must(wqb);
		//SearchResponse searchResponse = 
		str = boolQueryBuilder.toString();
		System.out.println(str);
		return str;
		 
	 }
	 

	 @RequestMapping("/auth")
	public String auth() {
		 
	//参考代码：https://blog.csdn.net/yk80695816/article/details/105378363
	RestHighLevelClient client = ElasticSearchConfig.esClient;
		 
	//CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
   // credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "passwd")); 
    
	userDao.save(new UserBean(0, "ElasticSearch Auth Test", 1));
	
	SearchRequest searchRequest = new SearchRequest();
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    searchSourceBuilder.query(QueryBuilders.matchQuery("name", "ElasticSearch"));
    searchRequest.source(searchSourceBuilder);
    SearchResponse searchResponse = null;
    try {
        searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }

	
	return searchResponse.toString();
	 }
	 
	 @RequestMapping("/hb")
		public String hb() {
	
			RestHighLevelClient client = ElasticSearchConfig.esClient;
			
			SearchRequest searchRequest = new SearchRequest();
		    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		    searchSourceBuilder.query(QueryBuilders.matchQuery("name", "ElasticSearch"));
		    searchRequest.source(searchSourceBuilder);
		    SearchResponse searchResponse = null;
		    try {
		        searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		        System.out.println(searchResponse.toString());
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    
			return searchResponse.toString();
	 }


}
