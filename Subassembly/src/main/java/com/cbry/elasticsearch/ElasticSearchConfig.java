package com.cbry.elasticsearch;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
	public static final RequestOptions COMMON_OPTIONS;
	public static  RestHighLevelClient esClient = null;
	
    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
//        builder.addHeader("Authorization", "Bearer " + TOKEN);
//        builder.setHttpAsyncResponseConsumerFactory(
//                new HttpAsyncResponseConsumerFactory
//                        .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024));
        COMMON_OPTIONS = builder.build();
    }

    @Bean
    public RestHighLevelClient esRestClient() {
        //官方文档：https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.5/java-rest-high-getting-started-initialization.html
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("192.168.188.128", 9200, "http")));

//        RestClientBuilder builder = null;
//      
//        //public HttpHost(String hostname, int port, String scheme)
//        builder = RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"));
//        RestHighLevelClient client = new RestHighLevelClient(builder);
//        return client;
    	
    	
    	
		 final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
	     credentialsProvider.setCredentials(AuthScope.ANY,
	             new UsernamePasswordCredentials("elastic", "!Wudi_12#34"));  //es账号密码
	     return esClient =new RestHighLevelClient(
	             RestClient.builder(
	                     new HttpHost("133.0.142.46",9200)
	             ).setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
	                 public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
	                     httpClientBuilder.disableAuthCaching();
	                     return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
	                 }
	             })/*.setMaxRetryTimeoutMillis(2000)*/
	     );
    	
    }
    
}
