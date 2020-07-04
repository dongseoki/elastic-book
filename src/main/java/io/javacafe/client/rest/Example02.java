package io.javacafe.client.rest;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class Example02 {
    /**
     * �씤�뜳�뒪 �궘�젣
     * */
    public static void main(String[] args) throws IOException {
        
    	RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        // Index紐�
        String INDEX_NAME = "movie_rest";
        
        
        // �씤�뜳�뒪 �궘�젣
        DeleteIndexRequest request = new DeleteIndexRequest(INDEX_NAME);

//        DeleteIndexResponse deleteIndexResponse = 
//        		client.indices().delete(request,RequestOptions.DEFAULT);
        
        AcknowledgedResponse deleteIndexResponse = 
        		client.indices().delete(request,RequestOptions.DEFAULT);
        
        boolean acknowledged = deleteIndexResponse.isAcknowledged();
        System.out.println("ack value : "+ acknowledged);
        
        client.close();
    }
}
