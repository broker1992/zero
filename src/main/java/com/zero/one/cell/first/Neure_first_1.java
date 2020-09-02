package com.zero.one.cell.first;

import com.zero.one.cell.NeuroTrans.Mitter;
import com.zero.one.cell.second.Neure_second;
import com.zero.one.cell.second.Neure_second_0;
import com.zero.one.utils.CellIDCreater;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

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
@Service
public class Neure_first_1 implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
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
    // 根据配置文件中的记录，需要连接的树突
    public  void dendrite_1(String key) {
        //先获取

        String v = prop.getProperty(key);
        Neure_second neure_second = null;
        if(!"".equals(v)&& v!=null){
            System.out.println("知道这个");
            //拼接 二层神经元的名称
            String className = "Neure_second_"+v;
            neure_second = (Neure_second)getBean(className);

        }else{
            System.out.println("?");
            //如果是第一次连接 需要从已经存在的 第二层神经元中随机获取一个
            String suffix = CellIDCreater.getSecondNeruSuffix();
            String className = "Neure_second_"+suffix;
            neure_second = (Neure_second)getBean(className);
            //保存
            saveToproperties(key,suffix);

        }
        Mitter mitter = new Mitter(key);
        neure_second.dendrite(mitter);

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

    //根据类名获取bean
    public static <T> T getBean(String beanName) {
        if(applicationContext.containsBean(beanName)){
            return (T) applicationContext.getBean(beanName);
        }else{
            return null;
        }
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Neure_first_1.applicationContext = applicationContext;

    }
}
