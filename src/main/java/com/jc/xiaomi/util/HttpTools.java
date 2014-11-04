package com.jc.xiaomi.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/11/4 0004.
 */
public class HttpTools {

    private static CloseableHttpClient hc = HttpClients.createDefault();


    public static String get(String url) {
        return get(url, null);
    }

    /**
     * Get
     *
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        String body = null;
        try {
            HttpGet httpget = new HttpGet(url);
            String str = EntityUtils.toString(new UrlEncodedFormEntity(mapToParamList(params)));
            httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
            HttpResponse httpresponse = hc.execute(httpget);
            HttpEntity entity = httpresponse.getEntity();
            body = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * // Post
     *
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, Map<String, String> params) {
        String body = null;
        try {
            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(new UrlEncodedFormEntity(mapToParamList(params)));
            HttpResponse httpresponse = hc.execute(httppost);
            HttpEntity entity = httpresponse.getEntity();
            body = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    public static List<NameValuePair> mapToParamList(Map<String, String> map) {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (map == null) {
            return params;
        }

        map.forEach((key, val) -> {
            params.add(new BasicNameValuePair(key, val));

        });

        return params;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        String url = "http://www.jincan.com";

        String body = get(url);
        System.out.println(body);
    }

}
