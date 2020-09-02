package com.zero.one.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class CellIDCreater {

    private static String filePath = "src/main/resources/config/utils/CellIDCreater.properties";

    //静态方法实现给每个调用着提供一个当前系统唯一的ID
    public static String createID() throws IOException {

        //ID 为当前时间＋随机数
        long l = System.currentTimeMillis();
        int v = (int)Math.random() * 1000;
        //获取配置文件
        String key = l+"_"+v;


        File file = new File(filePath);
        if (!file.exists())
            file.createNewFile();
        InputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        fis.close();
        boolean flag = true;

        while(flag){

            //判断生成的ID 是否存在
            String key_c = prop.getProperty(key);
            if(!"".equals(key_c)&& key_c!=null){
                key = System.currentTimeMillis()+"_"+(int)Math.random() * 1000;
            }else{
                //保存新生成的id
                OutputStream fos = new FileOutputStream(filePath);
                prop.setProperty(key, "1");
                //保存，并加入注释
                prop.store(fos, "Update '" + key + "' value");
                fos.close();
                flag = false;
            }
        }
        return key;



    }
    //静态方法-获取一个类名后缀
    public static String getSecondNeruSuffix(){
        File file = new File(filePath);
        Properties prop = new Properties();
        try{
            if (!file.exists())
                file.createNewFile();
            InputStream fis = new FileInputStream(file);

            prop.load(fis);
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        Enumeration<Object> keys = prop.keys();
        HashMap<String,String> map = new HashMap<>();
        while(keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            map.put(key, "1");
        }
        Set<String> strings = map.keySet();
        return strings.iterator().next();

    }
}
