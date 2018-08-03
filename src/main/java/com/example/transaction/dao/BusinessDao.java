package com.example.transaction.dao;

import com.example.transaction.bean.Cux_todo_items;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 石磊 on 2018/7/23.
 */
public class BusinessDao {
    private Reader reader;//输入流
    private SqlSessionFactory sqlMapper;//SqlSession工厂
    //无参构造器，初始化SqlSessionFactory
    public BusinessDao(){
        try{
            //获取mybatisConfig.xml资源配置文件，并得到输入流
            reader = Resources.getResourceAsReader("mybatisConfig.xml");
        }catch(IOException e){
            e.printStackTrace();
        }
        //通过SqlSessionFactoryBuilder获取SqlSession工厂
        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
    }
    //通过user_id得到事务表
    public Cux_todo_items selectbusiness(long user_id){
        System.out.println("进入了dao内部");
        //通过SqlSession工厂得到SqlSession
        SqlSession session = sqlMapper.openSession();
        //执行sql查询操作，通过执行mapper配置文件中的此selectId的sql语句，传入str参数来查询
        System.out.println("dao内部：开始查询");
        Cux_todo_items cux_todo_items = session.selectOne("selectbusiness",user_id);
        System.out.println("dao内部：查询结束");
        //关闭session
        session.close();
        return cux_todo_items;
    }

    //将一个新的事务表类插入到事务表中
    public void insertbusiness(Cux_todo_items cux_todo_items){
        System.out.println("进入了dao内部");
        //通过SqlSession工厂得到SqlSession
        SqlSession session = sqlMapper.openSession();
        //执行sql查询操作，通过执行mapper配置文件中的此selectId的sql语句，传入str参数来查询
        System.out.println("dao内部：开始插入");

        session.insert("insertbusiness", cux_todo_items);
        session.commit();
        System.out.println("dao内部：插入结束");
        //关闭session
        session.close();
    }
}
