package com.zero.one.cell.second;

import com.zero.one.utils.CellIDCreater;

import java.io.*;
import java.util.Properties;
/*
*  神经元自我复制-已实现
*  自动生成突触-之间的神经递质-使用对象表示
*
*
* */
public class Neure_second_0 {

    private Properties prop = new Properties();
    private static String filePath_prefix = "src/main/resources/config/cell/second/";
    private static String filePath_suffix = ".properties";
    private static String classPath_prefix = "src/main/java/com/zero/one/cell/second/";
    private static String classPath_suffix = ".java";
    private static String baseName = "Neure_second";
    public Neure_second_0() {
        try{

            String className = this.getClass().getSimpleName();
            File file = new File(filePath_prefix+className+filePath_suffix);
            if (!file.exists()) file.createNewFile();

            InputStream fis = new FileInputStream(file);
            prop.load(fis);
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // 模拟突出的生成
    public void createDendrite(){

    }


    //自身复制的功能－计时＊＊分钟后开始复制自己
    public void copySelf(){
        String className = this.getClass().getSimpleName();

        try {
            String classCopyName = baseName+"_"+CellIDCreater.createID();
            String classPath = classPath_prefix+className+classPath_suffix;
            String classPath_copy = classPath_prefix+classCopyName+classPath_suffix;

            FileInputStream fis = new FileInputStream(classPath);
            InputStreamReader reader = new InputStreamReader(fis, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);

            File file = new File(classPath_copy);
            FileOutputStream fout = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String line = null;
            while((line = bufferedReader.readLine())!=null){

                System.out.println(line);
                bufferedWriter.write(line.replace(className,classCopyName));
                bufferedWriter.newLine();
            }
            reader.close();

            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
            writer.close();
            fis.close();
            fout.close();
            fout.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
