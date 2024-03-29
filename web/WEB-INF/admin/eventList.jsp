<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이벤트</title>
    <c:set var="path" value="<%=request.getContextPath() %>" />
    <%@ include file="/common.jsp"%>
    <script src=""></script>

    <style>

        .title {
            margin-top: 170px;
            text-align: center;
        }

        .event-item ul {
            padding: 0;
        }

        .event-item li {
            margin-bottom: 20px;
            display: flex;
            align-items: center;
        }

        .thumb-img {
            flex: 0 0 100px;
            margin-right: 20px;
        }

        .thumb-img img {
            width: 100%;
            height: auto;
        }

        .exp {
            flex: 1;
            text-align: left;
        }

        .tab li {
            flex: 1;
        }

        ul {
            list-style: none;
        }

        ul:after {
            content: '';
            display: block;
            clear: both;
        }

        ul {
            margin-top: 0;
            margin-bottom: 1rem;
        }

        ul {
            padding-left: 2rem;
        }

        .tab {
            position: relative;
            display: flex;
            text-align: center;
            border: 1px solid #d7d8da;
        }

        .tab li > a {
            text-decoration: none;
            display: block;
            line-height: 55px;
            border-left: 1px solid #d7d8da;
            background: #fff;
            color: #666;
            font-size: 20px;
            font-weight: 600;
        }

        .tab li > a.active {
            color: #fff;
            background: #69748a;
            font-weight: 600;
        }


        .box_wrap thead th {
            padding: 15px 5px;
            border-bottom: 1px solid #d0cfd5;
            text-align: center;
        }


        .box_wrap tbody td {
            padding: 15px 5px;
            border-bottom: 1px solid #d0cfd5;
            text-align: center;
        }

        .event-list li {
            position: relative;
            padding: 35px 0;
            border-bottom: 1px solid #ddd;
            overflow: hidden;
        }

        .evt-list li .img img {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }

        .event-list {
            list-style: none;
            margin-top: 40px;
            border-top: 2px solid #999;
        }

        event-list li .exp > a {
            position: relative;
        }

        a {
            font-family: inherit;
            text-decoration: none;
            color: inherit;
        }

        .exp strong {
            display: block;
            margin-top: 38px;
            font-size: 25px;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }


        .exp p {
            margin: 10px 0 20px;
            line-height: 1.3;
            color: #666;
            font-size: 18px;
            word-break: keep-all;
        }

        .exp span {
            font-size: 15px;
            display: block;
            color: #888;
        }

        .event-item {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }

        .exp {
            text-align: center;
            display: inline-block;
            width: calc(100%- 600px);
            padding: 6px 0 0 45px;
        }

        .btn {
            text-decoration: none;
            border-radius: 20px;
            padding: 10px;
            margin-top: 40px;
            margin-left: 1200px;
            background-color: #eb9362;
            border-color: #eb9362;
            color: #ffffff;
        }

        .msg {
            line-height: 30px;
            text-align: center;
        }


    </style>

</head>
<body>
<div class="container-fluid" style="height: 80px">
    <%@ include file="/header.jsp"%>
    <h2 class="title">이벤트</h2>
        <p class="msg">관리자만 이용가능합니다.</p>
    <div class="container" id="container">
        <div class="event-list">
            <c:forEach var="event" items="${eventList }" varStatus="status">
                <li>
                    <ul class="event-item">
                        <a href="${path }/AdminEvent.do?no=${event.no }" target="_blank">
                            <div class="thumb-img">
                            <span class="img">
                                <img src="${path }/storage/${event.img}" alt="이벤트 이미지">
                            </span>
                            </div>
                        </a>
                        <div class="exp">
                            <a href="${path }/AdminEvent.do?no=${event.no }" target="_blank">
                                <strong>
                                        ${event.title}
                                </strong>
                                <p>${event.content}</p>
                            </a>
                        </div>
                    </ul>
                </li>
            </c:forEach>
                <a href="${path }/AddEvent.do" class="btn">글 등록</a>
        </div>
    </div>
        <%@ include file="/footer.jsp" %>
</body>
</html>


