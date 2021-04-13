* jsp 파일

  <%

  ```html
  <body>
  <h1>jsp 파일</h1>
  <h3>실행 시각은
  <%
  	java.util.Date now = new java.util.Date();
  	out.print(now);
  %>
  </h3>
  </body>
  ```

  <%@

  * <%@page %>

    ```html
    //a page
    <%@ page contentType="text/html; charset=UTF-8" import="java.util.Date" 
     errorPage="b.jsp"%>
        
      //  b page
      <%@ page   isErrorPage="true"%>
        <%
    System.out.print(exception);
    %>
    ```

    

  * <%@include %>

    ```html
    //share.jsp
    <% String name ="/html/images/drink.jpg";%>
    
        <img src="<%=name%>" width="300" height="300">
        
        
       //shop.jsp
     <h1>쇼핑</h1>
    <%@ include file="share.jsp" %>
        <h1>
            <%=name%>
        </h1>
    ```

  * <%@taglib %>

    jsp 추가 태그 사용 알려주는 정의

  <%!  , <%  선언문 태그

  * <%!  전역 위치
  * <% 지역 위치

  <%=  참조 태그

  <%--  주석

  ```html
  <%--> <%@ include file="share.jsp" %></%-->
  ```

  <jsp:xxxx

  ${el}

  <c:xxxx

  

  