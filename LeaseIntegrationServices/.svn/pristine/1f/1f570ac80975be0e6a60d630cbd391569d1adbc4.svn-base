/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.webservices;

import com.Config.BaseClass;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Ibrahim
 */
@Path("/PostServices")
public class PostCallServices {

    @Path("/supplierSync")
    @GET
    //https://jcs.omniyat.com/LeaseIntegrationServices/webresources/PostServices/supplierSync?P_SUP_ID=10
    public static String CreateSupplier(@QueryParam(value = "P_SUP_ID") String P_SUP_ID) throws ParseException, MalformedURLException {
        String basicAuth = BaseClass.ICS_BASE64;
        String supplierUrl = BaseClass.SUPPLIER_URL;
        URL url = new URL(supplierUrl);
        int responseCode = 0;
        String returnMsg = "NULL";
        try {
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) connection;
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
           
            String JsonInput = "{ \"p_Supplier_num\" : "+P_SUP_ID+" }";
            byte[] buffer = new byte[JsonInput.length()];
            buffer = JsonInput.getBytes();
            bout.write(buffer);
            byte[] b = bout.toByteArray();
            httpConn.setRequestProperty("Content-Length",
                    String.valueOf(b.length));
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Authorization", "Basic "+basicAuth);
            httpConn.setRequestMethod("POST");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            OutputStream out = httpConn.getOutputStream();
            out.write(b);
            out.close();
           
            responseCode = httpConn.getResponseCode();
            if(responseCode==202){
                returnMsg = "SUCCESS";
            }
            System.out.println(responseCode);

        } catch (IOException IOE) {
            System.out.println(IOE.toString());
        }
        return returnMsg;
    }
}