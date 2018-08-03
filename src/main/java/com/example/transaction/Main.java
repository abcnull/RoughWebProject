package com.example.transaction;

import com.example.ceshi.User;
import com.example.transaction.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 石磊 on 2018/7/15.
 */
public class Main {
    public static void main(String args[]){
        System.out.println("start working!");//准备开始spring操作
        //通过xml来直接得到ApplicationContext对象
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        System.out.println("1");
        //通过ApplicationContext对象来取得bean实例
        UserDao userdao = (UserDao) applicationContext.getBean("userdao");
        System.out.println("heheh");
//        //获取通过找到的xml的spring配置文件得到applicationContext的ioc容器
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
//        //通过applicationContext这个ioc容器来获得bean的实例对象
//        Person person = (Person)applicationContext.getBean("person");
//        person.shout();

          //1.spring获取bean对象
//        Resource r =  new FileSystemResource("src/main/resources/applicationContext.xml");//在项目的直接子目录下寻找这个xml为r
//        BeanFactory beanFactory = new XmlBeanFactory(r);//通过r资源获取到它的的bean工厂
//        Person person = (Person)beanFactory.getBean("person");//通过bean工厂得到某一个bean的实例对象
//        person.shout();

          //2.spring获取bean对象
//        System.out.println("start test⁄(⁄ ⁄•⁄ω⁄•⁄ ⁄)⁄");
//        //得到资源类
//        Resource resource = new ClassPathResource("applicationContext.xml");
//        //得到bean工厂，还没配这个工厂
//        BeanFactory factory = new DefaultListableBeanFactory();
//        //得到BeanDefinitionReader实例，通过之前的bean工厂实例
//        BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
//        //通过BeanDefinitionReader实例来加载原先的resource这个资源类
//        bdr.loadBeanDefinitions(resource);
//        //最后通过bean工厂得到person实例对象
//        Person person = (Person)factory.getBean("person");
//        person.shout();

//          3.Mybatis操作
//        Reader reader = null;
//        SqlSession session;
//        try {
//            reader = Resources.getResourceAsReader("mybatisConfig.xml");
//        } catch (IOException e) {
//            e.printStackTrace() ;
//        }
//        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
//        System.out.println("前");
//        session = sqlMapper.openSession();
//        System.out.println("后");
//        User user = session.selectOne("idName", "liming");
//        System.out.println("后后");
//        System.out.println(user.getPassword());
//        session.close();
    }
}
