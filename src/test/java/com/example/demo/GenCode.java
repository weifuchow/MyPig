package com.example.demo;
import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * Created by chuangang.li on 2017/1/20.
 */
public class GenCode {
    public static void main(String[] args) throws Exception {
        String templatePath = ClassLoader.getSystemResource("myTemplate").toString();
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().addTemplateRootDir(templatePath);
        //删除生成器的输出目录// test
        //g.deleteOutRootDir();
        //通过数据库表生成文件11
        g.generateByTable("users");

    }
}
