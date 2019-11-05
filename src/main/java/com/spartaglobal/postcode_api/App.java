package com.spartaglobal.postcode_api;

import com.spartaglobal.postcode_api.postcodesHTTPClient.SinglePostcodeHTTPService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SinglePostcodeHTTPService singlePostcodeHTTPService = new SinglePostcodeHTTPService("ts160rn");
        singlePostcodeHTTPService.singlePostCodeGetRequest();
        singlePostcodeHTTPService.setSinglePostcodeResponseBody();
        System.out.println(singlePostcodeHTTPService.getSinglePostcodeResponseBody());

    }
}
