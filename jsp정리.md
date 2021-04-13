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

  ```html
  <jsp:forward page"xxxx.jsp">
      <jsp:param name = "message" value ="정상">
          </jsp:forward>
      
      <jsp:useBean id="dto" class="board.BoardDTO" scope="session"/>
      <jsp:setProperty property="title" name="dto"/>
      <jsp:getProperty property="title" name="dto"/><br>
  
  ```

  

  ${el}

  ```html
      isELIgnored="true" // 헤드
      ${10} 숫자 
      ${"20"}문자
      ${i=null}
  
      ${empty i}
      <%=pageContext.getAttribute("i")%>
  
      ${param.id}
      <%=request.getParamter("id")%>
      ${paramValues.location[0]}
     
          <% request.setAttribute("message",정상)%>
       ${requestScope.message}
       ${sessionScope.message}
             
  ```

  ```html
  <% pageContext.setAttribute("share1","1"); request.setAttribute("share2","2");     session.setAttribute("share3","3");     application.setAttribute("share4","4"); 
                              %>
  ${pageScope.share1}//현재 페이지
  ${requestScope.share2}다른 페이지 공유
  ${sessionScope.share3}브라우저 공유
  ${applicationScope.share4}
      
  ${share1}
  ${share2}
  ${share3}
  ${share4}
  ```

  * el 전용 추가 태그 설치
  * jstl core 설치
  * java standa templet libaray

  <c:xxxx

  ```html
//이프
  <c:if test ="${empty param.id }">
  <h1>아이디 입력</h1>
  </c:if>
  <c:if test="${!empty param.id}">
  //스위치
  <h1>${param.id}</h1>
  	<c:choose>
  		<c:when test="${param.age<=13}">
  			<h3 style="color:aqua;">초딩</h3>
  		</c:when>
  		<c:when test="${param.age<=16}">
  			<h3 style="color:black;">중딩</h3>
  		</c:when>
  		<c:when test="${param.age<=19}">
  			<h3 style="color:blue;">고딩</h3>
  		</c:when>
  	</c:choose>
  </c:if>
  ```
  
  ```html
  //반복문
  
  ```
  
  
  
  