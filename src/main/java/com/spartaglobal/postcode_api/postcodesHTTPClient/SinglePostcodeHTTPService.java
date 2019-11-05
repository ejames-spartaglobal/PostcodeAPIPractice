package com.spartaglobal.postcode_api.postcodesHTTPClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class SinglePostcodeHTTPService {
    //API URL Management
    private String baseURL ="https://api.postcodes.io";
    private String singlePostCodesEndpoint = "/postcodes/";

    //Manage constructor postcode data
    private String postCode;

    //Capture full response from get request
    private CloseableHttpResponse singlePostcodeFullResponse;

    //Accessing body of the HTTP response
    private String singlePostcodeResponseBody;

    public SinglePostcodeHTTPService(String postCode) {
        this.postCode = postCode;
    }
    //Making the full request and sending the response to the http CloseableHttpResponse
    public void singlePostCodeGetRequest(){
        //Create HTTP client
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        //Instantiating the Get request
        HttpGet getSinglePostCode = new HttpGet(baseURL+singlePostCodesEndpoint+postCode);
        //execute the call
        try {
            singlePostcodeFullResponse=closeableHttpClient.execute(getSinglePostCode);
            //System.out.println(closeableHttpClient.execute(getSinglePostCode));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSinglePostcodeResponseBody(){
        try {
            //set body to a string
            singlePostcodeResponseBody= EntityUtils.toString(singlePostcodeFullResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getSinglePostcodeResponseBody(){
        return singlePostcodeResponseBody;
    }
}
