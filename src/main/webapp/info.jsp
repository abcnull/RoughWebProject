<%--
  Created by IntelliJ IDEA.
  User: 石磊
  Date: 2018/7/22
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery3.3.1.js"></script>
    <style>
        #whole{
            width:100%;
            height:100%;
            background-color: #FFE4B5;
        }
        #left{
            float: left;
            width: 20%;
            height: 800px;
            background-color: black;
        }
        #right{
            float: left;
            width: 80%;
            height: 800px;
            background-color: #778899;
        }
        input{
            margin-left:10px;
        }
        table{
            margin: 80px auto;
        }
        #button{
            margin-left:60%;
        }
        a{
            text-align:center;
            color:white;
        }
        #top{
            width:100%;
            height:8%;
            background-color:gray;
        }
        #bottom{
            width:100%;
            height:8%;
            background-color:gray;
        }
    </style>
</head>
<body>
    <div id="whole">
        <div id="left">
            <div id="top"><a href="todolist">to-do list</a></div>

            <div id="bottom"><a href="personinfo">person info</a></div>
        </div>
        <div id="right">

            <hr>
            <form action="updateinfo" method="post">
                <table>
                    <tr><td style="font-weight:bold">personal infomation</td></tr>
                    <tr><td><hr></td></tr>
                    <tr>
                        <td class="text">user_name:</td>
                        <td><input type="text" name="user_name" value=${requestScope.user_name}></td>
                        <td class="text">password:</td>
                        <td><input type="password" name="password" value=${requestScope.password}></td>
                    </tr>
                        <td class="text">sex:</td>
                        <td><input type="text" name="sex" value=${requestScope.sex}></td>
                        <td class="text">age:</td>
                        <td><input type="text" name="age" value=${requestScope.age}></td>
                    <tr>
                        <td class="text">phone_number:</td>
                        <td><input type="text" name="phone_number" value=${requestScope.phone_number}></td>
                    </tr>
                        <tr><td style="font-weight:bold">other info</td></tr>
                    <tr><td><hr></td></tr>
                    <tr>
                        <td class="text">creation_date:</td>
                        <td><input type="text" name="creation_date" value=${requestScope.creation_date}></td>
                    </tr>
                    <tr>
                        <td class="text">last_update_date:</td>
                        <td><input type="text" name="last_update_date" value=${requestScope.last_update_date}></td>
                    </tr>
                    <tr>
                        <td>comments:</td>
                        <td><input type="text" name="comments" value=${requestScope.comments}></td>
                    </tr>
                </table>
                <hr>
                <input id="button" type="submit" value="UpdateInfo">
            </form>
        </div>
    </div>
    <script>
        $(document).ready(function(){
            $("#left div").mouseover(function(){
                $(this).css({"color":"black","background-color":"green"});
            });
            $("#left div").mouseleave(function(){
                $(this).css({"color":"white","background-color":"gray"});
            });
        });
    </script>
</body>
</html>
