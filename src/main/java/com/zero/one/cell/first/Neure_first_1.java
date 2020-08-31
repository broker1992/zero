package com.zero.one.cell.first;

import com.zero.one.cell.second.Neure_second_0;

import java.io.*;
import java.util.Properties;

/*
* 接受数据，并将数据保存在配置文件中
* 初始神经元细胞，要可以和附近的细胞进行接触，并传到电信号
* 分成两部分，一是生成树突-接受信号
*           二是生成轴突-传出信号
*
*
* */
public class Neure_first_1 {


    private  Properties prop = new Properties();
    private static String filePath_prefix = "src/main/resources/config/cell/first/";
    private static String filePath_suffix = ".properties";

    //胞体
    public Neure_first_1() {

        try{
            String className = this.getClass().getSimpleName();
            File file = new File(filePath_prefix+className+filePath_suffix);
            if (!file.exists())
                file.createNewFile();
            InputStream fis = new FileInputStream(file);
            prop.load(fis);
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    /*
    * 承担轴突的职责 -轴突可以连接上 其他神经元的树突
    * 可以连接到多个神经元
     */

    private void axon(){
        Neure_second_0 second_0 = new Neure_second_0();
        second_0.copySelf();



    }


    // 承担树突 的职责
    // 记录传入的字符串 的次数
    public  void dendrite_1(String key) {
        //先获取
        int count =1;
        String v = prop.getProperty(key);
        if(!"".equals(v)&& v!=null){
            System.out.println("知道这个");
            count = Integer.valueOf(prop.getProperty(key))+1;

        }else{
            System.out.println("?");
        }

        String value = count+"";
        //保存
        saveToproperties(key,value);
        //传递到轴突
        axon();
    }

    //保存传入值到配置文件重
    private void saveToproperties(String key,String value){

        try {

            String className = this.getClass().getSimpleName();
            OutputStream fos = new FileOutputStream(filePath_prefix+className+filePath_suffix);
            prop.setProperty(key, value);
            //保存，并加入注释
            prop.store(fos, "Update '" + key + "' value");
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Visit " + " for updating " + key + " value error");
        }

    }

}
