package cn.fx2.common.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.Collectors;

//字符串工具类
public class StringUtils implements Serializable {
    private static final long serialVersionUID = -6566815027256305021L;
    public static final int numberType = 1;
    public static final int stringType = 2;
    public static final int nsType = 3;

    //生成随机字符串
    public static String getRandomString(int length,int type){
        String str = "";
        if(type == numberType) {
            str ="0123456789";
        } else if(type == stringType) {
            str ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        } else {
            str ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        }
        int length1 = str.length();
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            int number=random.nextInt(length1);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    //流文件转字符串
    public static String  inputStreamToString(String pathResource) {
        try {
            ClassPathResource classPathResource = new ClassPathResource(pathResource);
            InputStream inputStream =classPathResource.getInputStream();
            return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //获取资源文件流
    public static InputStream getFileInputStream(String pathResource) {
        try {
            ClassPathResource classPathResource = new ClassPathResource(pathResource);
            return classPathResource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //数据流转为字符串
    public static String inputStreamToString(InputStream inputStream) {
        StringBuilder respomseStrBuilder = new StringBuilder();
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(inputStream , StandardCharsets.UTF_8) );
            String inputStr = "";
            while ((inputStr = streamReader.readLine())!= null){
                respomseStrBuilder.append( inputStr );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return respomseStrBuilder.toString();
    }

    //字符串过滤前后空格
    public static String tryTrim(String str) {
        return str == null ? null : str.trim();
    }
}
