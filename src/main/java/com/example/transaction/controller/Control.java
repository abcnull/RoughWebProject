package com.example.transaction.controller;

import com.example.transaction.bean.Cux_todo_items;
import com.example.transaction.bean.Cux_users;
import com.example.transaction.dao.BusinessDao;
import com.example.transaction.dao.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by 石磊 on 2018/7/22.
 */
@Controller
@SessionAttributes({"user_name","user_id"})

public class Control {
    @Autowired
    private UserDao userdao;
    @Autowired
    private BusinessDao businessdao;

    //登陆操作，通过用户名查找数据库，并匹配密码，返回值到用户信息界面
    @RequestMapping(value="/login")
    public ModelAndView login(@RequestParam("user_name") String user_name, @RequestParam("password") String password, HttpSession session){
        session.setAttribute("user_name", user_name);
        ModelAndView modelAndView = new ModelAndView("info");
        System.out.println("输入的用户名和密码是："+ user_name + "," + password);
        System.out.println("开始通过用户名搜索数据库");
        Cux_users cux_users = userdao.selectuser_name(user_name);//往里头传入参数，参数
        System.out.println("搜索数据库成功，返回一个Cux_user对象");
        //若两个密码相匹配
        //登陆匹配正确则进入用户信息界面
        if(cux_users.getPassword().equals(password)){
            System.out.println("密码正确");
            modelAndView.addObject("user_name",cux_users.getUser_name());
            modelAndView.addObject("password",cux_users.getPassword());
            modelAndView.addObject("sex",cux_users.getSex());
            modelAndView.addObject("age",cux_users.getAge());
            modelAndView.addObject("phone_number",cux_users.getPhone_number());
            modelAndView.addObject("creation_date",cux_users.getCreation_date());
            modelAndView.addObject("last_update_date",cux_users.getLast_update_date());
            modelAndView.addObject("comments",cux_users.getComments());
            return modelAndView;
        }
        //登陆匹配错误返回index，并且提示错误请重新输入
        else{
            System.out.println("密码错误");
            return new ModelAndView("index","error","error");
        }
    }

    @RequestMapping(value="/todolist")
    public ModelAndView list(String user_name, HttpSession session){
        System.out.println("开始搜寻事务");
        user_name = (String)session.getAttribute("user_name");//得到当前用户的user_name值
        System.out.println("用户名"+user_name);
        ModelAndView modelAndView = new ModelAndView("list");//最后返回的页面是list.jsp
        System.out.println("准备查询用户表");
        Cux_users cux_users = userdao.selectuser_name(user_name);//通过user_name值得到用户表
        System.out.println("用户表查询结束");
        long user_id = cux_users.getUser_id();//通过用户表得到用户的id
        session.setAttribute("user_id", user_id);
        System.out.println("准备查询事务表");
        Cux_todo_items cux_todo_items = businessdao.selectbusiness(user_id);//通过用户的id来得到事务表
        System.out.println("事务表查询结束"+cux_todo_items.getPriority()+cux_todo_items.getTodo_item_title());
        modelAndView.addObject("list",cux_todo_items);//modelAndView中添加上这个表类
        System.out.println("准备返回modelAndView");
        return modelAndView;
    }
    //这里添加一列时
    @RequestMapping(value="/updatebusiness")
    public ModelAndView updateBusiness(@RequestParam("todo_item_title") String todo_item_title,
                                       @RequestParam("comments") String comments,
                                       @RequestParam("priority") String priority,
                                       @RequestParam("creation_date") String creation_date,
                                       @RequestParam("last_update_date") String last_update_date,HttpSession session){
        System.out.println("开始搜寻事务222222222");
        String user_name = (String)session.getAttribute("user_name");//得到当前用户的user_name值
        long user_id = (long)session.getAttribute("user_id");//得到当前用户的user_id值
        System.out.println("用户名"+user_name);
        ModelAndView modelAndView = new ModelAndView("list");//最后返回的页面是list.jsp

        Cux_todo_items cux_todo_items = new Cux_todo_items();
        cux_todo_items.setTodo_item_title(todo_item_title);
        cux_todo_items.setComments(comments);
        cux_todo_items.setPriority(priority);
        cux_todo_items.setCreation_date(creation_date);
        cux_todo_items.setLast_update_date(last_update_date);
        cux_todo_items.setUser_id(user_id);


        System.out.println("插入数据"+cux_todo_items.getPriority()+cux_todo_items.getTodo_item_id()+cux_todo_items.getTodo_item_title()+cux_todo_items.getCreation_date());
        //先新插入
        businessdao.insertbusiness(cux_todo_items);//插入事务表类的数据类型，这个方法为自己实现的
        System.out.println("插入成功");
        //查询事务表返回给modelAndView
        modelAndView.addObject("list", cux_todo_items);
        //最后return
        return modelAndView;
    }

    //点击左边的personinfo链接，刷新页面，也就是查询用户信息
    @RequestMapping(value="/personinfo")
    public ModelAndView selectUser(String user_name, HttpSession session){
        user_name = (String)session.getAttribute("user_name");
        System.out.println("开始刷新");
        System.out.println("用户id是：" + user_name);
        ModelAndView modelAndView = new ModelAndView("info");
        System.out.println("定好了转向的页面");
        //通过dao得到用户表实例
        Cux_users cux_users = userdao.selectuser_name(user_name);//往里头传入参数，参数
        System.out.println("通过用户名得到了数据库中的数据");
        //装配ModelAndView
        System.out.println("开始填装数据");
        modelAndView.addObject("user_name",cux_users.getUser_name());
        modelAndView.addObject("password",cux_users.getPassword());
        modelAndView.addObject("sex",cux_users.getSex());
        modelAndView.addObject("age",cux_users.getAge());
        modelAndView.addObject("phone_number",cux_users.getPhone_number());
        modelAndView.addObject("creation_date",cux_users.getCreation_date());
        modelAndView.addObject("last_update_date",cux_users.getLast_update_date());
        modelAndView.addObject("comments",cux_users.getComments());
        System.out.println("填装完毕");
        return modelAndView;
    }

    //修改数据
    @RequestMapping(value="/updateinfo")
    public ModelAndView updateUser(Cux_users cux_users, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("info");//定向info
        String user_name = (String)session.getAttribute("user_name");//得到user_name
        System.out.println("开始更新");
        userdao.updateuser_name(cux_users);//更新操作
        System.out.println("更新完毕");
        //通过dao得到用户表实例
        modelAndView.addObject("user_name",cux_users.getUser_name());
        modelAndView.addObject("password",cux_users.getPassword());
        modelAndView.addObject("sex",cux_users.getSex());
        modelAndView.addObject("age",cux_users.getAge());
        modelAndView.addObject("phone_number",cux_users.getPhone_number());
        modelAndView.addObject("creation_date",cux_users.getCreation_date());
        modelAndView.addObject("last_update_date",cux_users.getLast_update_date());
        modelAndView.addObject("comments",cux_users.getComments());
        System.out.println("填装完毕");
        return modelAndView;
    }

}
