package com.ann.http;

import com.emof.base.BaseApplication;
import com.emof.util.MetaData;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 */
public class NetUtils {

    /**
     * 请求接口的appkey
     */
    public static final String APPKEY = "1001";

    /**
     * baseurl
     */
    public static final String BASE_URL = MetaData.getMetaData(BaseApplication.Companion.getInstance(), "base_url");
    public static final String IMAGE_URL = BASE_URL + "upload/";


    /**
     * 把参数集合加签名验证
     *
     * @param map 被签名验证前的参数集合
     * @return 签名验证后的参数集合
     */
    public static Map<String, String> encodeMap(Map<String, String> map) {
        try {
            map.put("sign", sign(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取sign
     *
     * @param map 需要被签名的参数集合
     * @return 返回签过名的字符串
     * @throws Exception MD5加密异常
     */
    public static String sign(Map<String, String> map) throws Exception {
        map.put("appkey", APPKEY);
        map.put("timestamp", getTimeStamp());

        TreeMap<String, String> treeMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();
        Set es = treeMap.entrySet();
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=9D5BA280D6EF42069A68411F0F119340");
        return encryptMD5(sb.toString());
    }

    /**
     * 获取当前的时间戳
     *
     * @return 当前时间
     */
    public static String getTimeStamp() {
//        return new Date().getTime() + "";
        return "1472121476422";
    }

    /**
     * MD5加密
     *
     * @param data 需要被加密的字符串
     * @return 返回已经加密的字符串
     * @throws Exception MD5加密异常
     */
    private static String encryptMD5(String data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bys = md5.digest(data.getBytes("utf-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : bys) {
            String s = Integer.toHexString(b & 0xFF);
            if (s.length() == 1) {
                sb.append("0");
            }
            sb.append(s.toUpperCase());
        }
        return sb.toString();
    }

    /*
   * Function  :   封装请求体信息
   * Param     :   params请求体内容，encode编码格式
   */
    public static StringBuffer getRequestData(Map<String, Object> params, String encode) {
        StringBuffer stringBuffer = new StringBuffer();        //存储封装好的请求体信息
        try {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(String.valueOf(entry.getValue()), encode))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);    //删除最后的一个"&"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }


}

