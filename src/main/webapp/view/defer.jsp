<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>defer</title>
    <script src="static/jquery-1.7.1.min.js"></script>
</head>
<body>

</body>
<script>
    defer();

    function defer() {
        $.get('defer', function (data) {
            console.log(data);
            defer();
        })
    }
</script>
</html>
