# Apache tomcat

* 9.0ver 
* ttp1.1connector port 9090

  * htttp:127.0.0.1/0909


* workspace_web ->변경
  * 파일에서 wo변경 클릭 
  * dynamic web 생성
  * ->targetr un
* add block 주석

# html5

* 글자 크기

  ```html
  <h1> kdigitar h1 </h1>
  <h2> kdigitar h2 </h2>
  <h3> kdigitar h3 </h3>
  <h4> kdigitar h4 </h4>
  <h5> kdigitar h5 </h5>
  <hr> <!-- 단락선 -->
  <h6> kdigitar h6 </h6>
  <p> 본문 p <br> 줄바꿈 </p>
  <p> kdigitar &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 스페이스바 </p>
  ```

* 페이지 이동

  ```html
  <!-- 다른 사이트 -->
  <a href="http://google.com/"> 페이지 이동 </a><br>
  <!-- 같은 프로젝트 페이지 이동 -->
  <a href="first.html"> 장난 </a><br>
  <!-- 다른 프로젝트 페이지 이동 -->
  <a href="/프로젝트명/first.html"> 장난 </a><br>
  <!-- id 입력 후 #으로 이동 -->
  <!-- tag 입력 후 #으로 이동 -->
  <h1 id="here">here </h1>
  <a href="#here"> 첫페이지 이동 </a>
  ```

* 글자 모양

  ```html
  <i>진하게</i>
  <b>기울어지기 </b>
  ```

* 표

  ```html
  <table border="1">
  <tr><th> 사번 </th><th> 이름 </th><th> 급여 </th></tr>
  <tr><td> 1행 1열</td><td>1행 2열</td><td> 1행 3열</td></tr>
  <tr><td> 2행 1열</td><td> 2행 2열</td><td> 2행 3열</td></tr>
  <tr><td> 3행 1열</td><td> 3행 2열</td><td> 3행 3열</td></tr>
  </table>
  ```

  

* 목록

  ```html
  <h1> 모록 태그</h1>
  <ol> 1.
      <ol type ="A">
  <li>자바 </li>
  <li>sql</li>
  <li>html</li>
  <li>jquery</li>
  <li>spring</li>
  <li>jsp</li>
  </ol>
  <ul> *_
      <ol type ="A">
  </ul>
  ```

* 오디오 비디오 사진

* 입력 

  ```html
  <h1>입력 양삭 태그</h1>
  <form action="loginprocess.java">
  아이디 :<input type="text" name ="id"><br>
  비번 : <input type="password" name ="pw"><br>
  권한 :<input type="hidden" name ="role" value="admin"><br>
  
  성별 : <input type="radio" name ="gender" value ="mail">남자
  <input type="radio" name ="gender" value="gemail">여자<br>
  수강 과목 <input type="checkbox" name ="subject" value="jsp">jsp
   <input type="checkbox" name ="subject" value="java">java<br>
   
  <input type = "image" name = "myimage" src = "images/google.png" >
  <input type = "file" name = "myifile">
  <input type="color">
  <textarea rows="5" cols="100"> 여긴 글쓰는 곳이다 </textarea><br>
  <select multiple="multiple">
  <optgroup label="라면"> 
  <option> 라면 <option> 김치</optgroup>
   <optgroup label="밥">
   <option>밥 <option>무</optgroup>
   </select>
  <input type="reset"value ="입력취소">
  <input type="submit"value ="로그인"><br>
      
  <form action="loginprocess.java">
  ```

  

* div

  ```html
  <div style="color: red"> 
  	<h1>div 태그 - block</h1>
   div 태그 - block
   div 태그 - block</div>
  
  <span> span 태그 - inline</span>
  <span> span 태그 - inline</span>
  ```

  

* 시그메틱

  ```html
  
  ```

* style

  ```html
  <style> 
      body > a{color : red;} body에 a
      body a {color : red } body의 간접 a
      h1:hover{color : blue;}
      select option:selected {color: red;}
      option:nth-child(2n){color : red;}
      option:first-child
      option:last-child
      h1 {display:none;}
      h1 {display:block;}
      div {background-color: pink 
          blackground-color:#ff0000;
          width:500px; width:50%;
          height:100px;
          border:solid 10px aqua;선종류|두께|색상
          border-style:dotted;
          border-width:20px;
          border-color:#redgreenyello
          margin:20px;
          margin-left:20px;
          margin-right:20px;
          margin-top:20px;
          matgin-bottom:20px;
          padding:50px;
          padding:0 30px 0 30px;
          padding:0 30px;
          font-size:20px; font-size:2em;}
      body{
          background-image:url('/html/image/google.png');
          background-repeat:no-repeat;
          background-size:100px;
            background-size:100% 100px;
           background-size:100% 100%;
      }
    /* id = first*/ #first{
          font-size:10px;
        font-family:sans-serif;
         font-family:serif;
        font-family:monospace;
        font-family:'궁서체';
        font-style:italic;
        text-decoration:underline;
      }
      a{
          color:#00ff00;
          text-decoration:none;
      }
      /*id=align*/#align{
          background-color:#000000;
          width:400px;
          text-align:center;
          margin : auto;
      }
  </style>
  <input type = radio name = gen value = 여 checked = check>
  <select>
      <option> first</option>
      <option selected = "seleted">two</option>
      <optoin>tree</optoin>
  </select>
  ```

* position

  ```html
  <style>
      .box{
          display:inline_block;
          width:100px;
          height:100px;
          background:red;
          color:white;
      }
      #one {
    position: fixed;
    top: 80px;
    left: 100px;
    background: blue;
  }
   	 #two{   	position:absolute;
          top:10px;
          left:10px;
          background-color:aqua;
      }
      #three{
          position:relative;
          top:10px;
          left:10px;
          background-color:pink;
      }
      #four{  position:absolute;
          top:10px;
          left:10px;
          background-color:olive;
      }
  </style>
  <!--body-->
  <div>
      class='box'id='one'
  </div>
  <div>
      class='box'id='two'
  </div>
  <div>
      class='box'id='three'
  </div>
  <div>
      class='box'id='four'
  </div>
  ```

  

* ```html
  <style>
      .box{
          display:inline_block;
          width:100px;
          height:100px;
          background:red;
          color:white;
      }
        #one{
          position:absolute;
          top:10px;
          left:10px;
          background-color:pink;
      }
      #two{
         	position:absolute;
          top:10px;
          left:10px;
          background-color:blue;
      }
       #three{   	position:absolute;
          top:10px;
          left:10px;
          background-color:aqua;
      }
           #four{   	position:absolute;
          top:10px;
          left:10px;
          background-color:silver;
               z-index:2;
      }
  </style>
  <!--body-->
  
  ```

* ```html
  .outer {
      width: 500px;
  	height: 300px;
    	-overflow: scroll;
  	-overlow:hidden;
      padding-left: 150px;
  }
  ```

* ```html
  <style>
     .box{
          display:inline_block;
          width:100px;
          height:100px;
          background:red;
          color:white;
         -float:left;
         -float:right:
      }
      p{
          cleer:both;
      }
  </style>
  <!--body-->
  ```

* ```html
  .outer  p{
  white-space:nowrap;
  overflow:hidden;
  text-overflow:ellipsis;
  }
  ```

* ```html
  @media screen and (max-width:600px){
  body{background-image:none;}
  h1,table{margin : auto;}
  }
  ```

* 

