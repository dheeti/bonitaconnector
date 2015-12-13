package com.lh.connectors.twistle;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jayramj on 6/12/15.
 */
public class RestClient implements StringConstants{

    public String execute(List<NameValuePair> nameValuePairs,String endpoint){

        String result = null;
        try {

       // HttpHost target = new HttpHost("app.twistle.com","https");
        HttpPost postRequest = new HttpPost ("https://app.twistle.com/api/send_message");
            postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        CloseableHttpClient client = HttpClients.custom().build();
        HttpResponse response = client.execute(postRequest);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String args[]){
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair(SYSTEMID,"jj@learninghealth.io"));
        nameValuePairs.add(new BasicNameValuePair(PASSWORD,"Kmfpakx@1"));
        nameValuePairs.add(new BasicNameValuePair(MESSAGEID,"LH"+System.currentTimeMillis()));
        nameValuePairs.add(new BasicNameValuePair(RECEPIENTID,"jj@learninghealth.io"));
        nameValuePairs.add(new BasicNameValuePair(CONTENT,"Testing from Code"+System.currentTimeMillis()));

        RestClient client = new RestClient();
        System.out.println(client.execute(nameValuePairs,null));
    }
}
