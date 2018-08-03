package com.example.transaction.dao;

import com.example.transaction.bean.Cux_todo_items;
import com.example.transaction.bean.Cux_users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 石磊 on 2018/7/23.
 */
public class UserDao {
    private Reader reader;//输入流
    private SqlSessionFactory sqlMapper;//SqlSession工厂
    //无参构造器，初始化SqlSessionFactory
    public UserDao(){
        try{
            //获取mybatisConfig.xml资源配置文件，并得到输入流
            reader = Resources.getResourceAsReader("mybatisConfig.xml");
        }catch(IOException e){
            e.printStackTrace();
        }
        //通过SqlSessionFactoryBuilder获取SqlSession工厂
        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
    }
    //通过user_name查询cux_user表
    public Cux_users selectuser_name(String user_name){
        //通过SqlSession工厂得到SqlSession
        SqlSession session = sqlMapper.openSession();
        //执行sql查询操作，通过执行mapper配置文件中的此selectId的sql语句，传入str参数来查询
        Cux_users cux_users = session.selectOne("selectuser_name",user_name);
        //关闭session
        session.close();
        return cux_users;
    }
    //通过user_id查询cux_user表
//    public Cux_users selectuser_id(long user_id){
//        //通过SqlSession工厂得到SqlSession
//        SqlSession session = sqlMapper.openSession();
//        //执行sql查询操作，通过执行mapper配置文件中的此selectId的sql语句，传入str参数来查询
//        Cux_users cux_users = session.selectOne("selectuser_id",user_id);
//        //关闭session
//        session.close();
//        return cux_users;
//    }
    //user_name更新Cru_users表
    public void updateuser_name(Cux_users cux_users){
        //通过SqlSession工厂得到SqlSession
        SqlSession session = sqlMapper.openSession();
        //执行sql查询操作，通过执行mapper配置文件中的此selectId的sql语句，传入str参数来查询
        System.out.println("1");
        session.update("updateuser_name",cux_users);
        System.out.println("2");
        session.commit();
        System.out.println("3");
        //关闭session
        session.close();
    }

}
