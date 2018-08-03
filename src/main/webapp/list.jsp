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
    <script src="jquery3.3.1.js"></script>
    <title>Title</title>
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
            width:8%;
        }
        a{
            text-align:center;
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
        <button id="add" style="display:block;width: 50%;">AddItem</button>
        <button id="delete" style="display:block;width: 50%;">DeleteItem</button>
    </div>
    <div id="right">
        <hr>
        <form class="form" action="updatebusiness" method="post">
            todo_item_title:<input type="text" value='${requestScope.list.todo_item_title}'>
            comments:<input type="text" value=${requestScope.list.comments}>
            priority:<input type="text" value=${requestScope.list.priority}>
            creation_date:<input type="text" value=${requestScope.list.creation_date}>
            last_update_date:<input type="text" value=${requestScope.list.last_update_date}>
            <input type="submit" value="update-this">
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
        $("#add").click(function(){
            var a = $("form").length;
            var f = $("<form class='form' action='updatebusiness' method='post'>"+
                "todo_item_title:<input type='text' name='todo_item_title' value=''>"+
                " comments:<input type='text' name='comments'  value=''>"+
                " priority:<input type='text' name='priority'  value=''>"+
                " creation_date:<input type='text' name='creation_date'  value=''>"+
                " last_update_date:<input type='text' name='last_update_date'  value=''>"+
                " <input type='submit' value='update-this'>"+
            "</form>");
            var c = $("form")[a-1];
            f.appendTo(c);
        });
    });
</script>

</body>
</html>
