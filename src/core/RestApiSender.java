package core;

import java.io.IOException;
import models.*;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * RestApiSender
 */
public class RestApiSender {

    private final CloseableHttpClient httpClient;

    public RestApiSender() {
        httpClient = HttpClients.createDefault();
    }

    public SimpleHttpResponse sendGetRequest(String url) throws IOException{
        
        var httpGet = new HttpGet(url);
        
        try(var httpResponse = httpClient.execute(httpGet)){
            
            var resp = new SimpleHttpResponse();
            resp.statusCode = httpResponse.getStatusLine().getStatusCode();
            
            if(resp.statusCode == HttpStatus.SC_OK)
                resp.responseContentString = EntityUtils.toString(httpResponse.getEntity());
            
            return resp;            
        }
    }

    public SimpleHttpResponse sendPostRequest(String baseUrl, String jsonReqString) throws IOException{
        
        var httpPost = new HttpPost(baseUrl);
        httpPost.setEntity(new StringEntity(jsonReqString));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        
        try(var httpResponse = httpClient.execute(httpPost)){
            
            var resp = new SimpleHttpResponse();
            resp.statusCode = httpResponse.getStatusLine().getStatusCode();
            
            if(resp.statusCode == HttpStatus.SC_OK)
                resp.responseContentString = EntityUtils.toString(httpResponse.getEntity());
            
            return resp;            
        }
    }
    
    public void dispose() throws IOException{
        
        httpClient.close();
    }
}