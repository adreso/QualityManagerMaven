/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quality.qm.model.mybatis;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Andrencio
 */
public class MyBatisUtil {

    private MyBatisUtil serviceLocator;
    //private final String resources ="org/quality/qm/model/mybatis/mybatis-config.xml";
    private final String resources ="/mybatis-config.xml";
//    private String resources ="C:\\Users\\facturador\\Documents\\NetBeansProjects\\Otra\\QualityManager\\src\\java\\qm\\mybatis\\mybatis-config.xml";
    
    
    private SqlSession session=null;
    
    public SqlSession getSession(){
        try{
          
            Reader reader=Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            session=sqlMapper.openSession();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return session;
    }

    private MyBatisUtil getServiceLocator() {
        if (serviceLocator == null) {
            serviceLocator = new MyBatisUtil();
        }
        return serviceLocator;
    }
}