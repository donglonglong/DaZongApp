<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title>会员信息添加</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
    <script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/common.js"></script>
    <script type="text/javascript" src="${basePath}/js/content/adAdd.js"></script>
</head>
<body style="background: #e1e9eb;">
<form id="mainForm" method="post" action="${basePath}/user/add" enctype="multipart/form-data">
    <input type="hidden" id="message" value="${pageCode.msg}"/>
    <input type="hidden" id="basePath" value="${basePath}"/>
    <div class="right">
        <div class="current">当前位置：<a href="${basePath}/ad/initList">内容管理</a> &gt; 广告管理</div>
        <div class="rightCont">
            <p class="g_title fix">新增会员信息</p>
            <table class="tab1" width="100%">
                <tbody>
                <tr>
                    <td align="right" width="10%">用户名：<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="name" name="name" class="allInput" style="width:100%;" type="text"/>
                    </td>
                    <td align="right" width="10%">密码：<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="password" name="password" class="allInput" style="width:100%;" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">昵称：<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="chName" name="chName"  class="allInput" style="width:100%;" type="text"/>
                    </td>
                    <td align="right" width="10%">职位：<font color="red">*</font>：</td>
                    <td width="30%">
                        <select id="groupId" name="groupId">
                            <c:forEach items="${groups}" var="gp">
                                <option value="${gp.id}">${gp.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                </tbody>
            </table>
            <div style="text-align: center; margin-top: 30px;">
                <input class="tabSub" value="保     存" type="button" onclick="add();"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="tabSub" value="返     回" type="button" onclick="goback();"/>
            </div>
        </div>
    </div>
</form>
</body>
</html>