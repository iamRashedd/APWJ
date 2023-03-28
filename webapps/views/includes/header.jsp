<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${requestScope.title}</title>
	<style>

	button { font-size: 25px;border-radius: 8px;}
	ul {list-style-type: none;margin: 10;padding: 20;overflow: hidden;background-color: #959a9c;}
	li {float: left;display: inline;border-radius: 10px;}
	li a { display: block;color: black;text-align: center;padding: 14px 16px;text-decoration: none;}
	li a:hover {background-color: #555;color: white;border-radius: 10px;}
    .topnav-right {float: right;}
    #u{color:white}
	</style>

</head>
<body>
	<div align="center">

<ul>
<div class="topnav">
<li ><a href="/ricemill/app/product/show">Product Show</a></li>
<li ><a href="/ricemill/app/product/create">Product Add</a></li>
<li></li>
<li ><a href="/ricemill/app/inventory/show">Inventory Show</a></li>
<li></li>
<li ><a href="/ricemill/app/client/show">Client Show</a></li>
<li ><a href="/ricemill/app/client/register">Client Add</a></li>
<li></li>
</div>

<div class="topnav-right">
<li style="background-color: #d1c8ae;"><a style="font-color: white" href="/ricemill/app/user/update">Edit Profile</a></li>
<li style="background-color: #e3aeaa;"><a style="font-color: white" href="/ricemill/app/user/logout">Logout</a></li>
</div>
</ul>
</div>
