<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal agent management system</title>
        <style>
            #whole{
                width:100%;
                height:100%;
                background-color: #FFE4B5;
            }
            #title{
                width: 100%;
                height: 40px;
                margin-top: 20px;
                background-color: #778899;
                text-align: center;
            }
            #content{
                width: 20%;
                height: 360px;
                margin-top: 80px;
                margin-left:auto;
                margin-right:auto;

            }
            form{
                margin:20% auto;
                border:2px solid black;
                background-color: #778899;
            }
            .text{
                text-align: right;
            }
            tr{
                margin-top:20px;
            }
            table{
                margin: 20px auto;
            }
            #button{
                margin-top:10px;
                margin-left:70%;
            }
        </style>
    </head>
    <body>
        <div id="whole">
            <div id="title"><h1>Personal agent management system</h1></div>
            <div id="content">
                <form action="login" method="post">
                    <table>
                        <tr>
                            <td class="text">user_name:</td>
                            <td><input type="text" name="user_name"></td>
                        </tr>
                        <tr>
                            <td class="text">password:</td>
                            <td><input type="password" name="password"></td>
                        </tr>
                    </table>
                    <input id="button" type="submit" value="Submit">
                </form>
            </div>
        </div>
    <script>
        var a = '${requestScope.error}';
        if( a=='error' ){
            alert("error,please login again!");
        }
    </script>
    </body>
</html>
