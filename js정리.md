# 자바스크립트

```html
<script type="text/javascript">
alert("클릭");
console.log("출력");
document.write("브라우저 출력");
document.write(10/3 + "<br>");
document.write(parseInt(10/3) + "<br>");
document.write(typeof(10/3)+"<br>");
var a =10;
var b= 10.0;
document.write(a===b);
document.write(a==b);
var b= 10.0;
b="vdl";
document.write(b);
    
let b= 10.0;
b="vdl";<-중복 안됨
document.write(b);
   const c;
    c = "200";
    
 const d =new Date();
let year = d.getFullYear();
let hour = d.getHours();
document.write(year);
document.write(hour);
    
    var ar1 = [1,2,3,4,true,"배열"]
    ar1.push(45);
    ar1.length;
    ar1.join("/");
    ar1.pop();
    ar1.shift();
    for(var i = 0 ; i <ar1.length; i++){
        document.write(i+":"+ar1[i]+t);
    }
        ar1.unshift(200);
    for(var i in ar1){
            document.write(i+":"+ar1[i]+t);
        }
    ar1.unshift(200);
    /*
    <input type="checkbox" name="fu" value=''><span></span>*/
    
    var form = ['과일','우유'];
var inlist = document.getElementsByTagName("input");
var splist = document.getElementsByTagName("span");
document.write(inlist.length);
inlist[0].value = form[0];
splist[0].innerHTML = form[0];
splist[1].innerHTML = form[1];
    
function on() {
	alert('A');
}

var b  = function(){
	alert('B');
}
b();
on();
    
    
    function manytimes(f,n){
	for(var i=0;i<n;i++)
		f("html");
}

function tentimes(f){
	for(var i=0;i<10;i++)
		f();
}

function print(m)
{
	document.write("<h1>"+m+"</h1>");
}
manytimes(print , 10);
    
    confirm('확실?')버튼을 만들어줌
    
    JSON.stringify(함수)
    JSON.parse(함수)
</script>
```

* map 

  ```javascript
  var smap = new Map();
  smap.set(key,value) 키값을 지정함
  smap.get(key) key 값을 물어옴
  smap.has(key) key값을 리턴 true
  smap.delete(key) key 값 제거
  smap.clear() map 제거
  smap.size 사이즈
  ```

  

* for문

  ```javascript
  for(var i =0; i <array.length;i++){
      array[i];
  }
  ```

* 배열

  ```javascript
  var Array = new Array(1, 2, 3,"홍길동", "아무개");
  var Array = [1, 2, 3, "홍길동", "아무개"];
  Array.length 사이즈
  Array[3];3인덱스 값 반환
  Array[3]; 없음 undefined
  Array[3]= 0;3인덱스 값 0으로 변경
  Array[Array.length] = "a"; 배열 끝에 'a'추가
  delete Array[2]; 2인덱스 의 값 제거
  Array.pop();끝에 꺼 꺼내옴 그리고 제거
  Array.shift(); 첫번 꺼 꺼내옴 그리고 제거
  Array.splice(1,1)1번 인덱스에서 1개의 배열 반환 1개 배열 삭제
  Array.splice(1,0,"a")1번 인덱스에서 0개의 배열 반환 0개의 배열 삭제 1번 인덱스에 "a"추가
  Array.unsift("a") 첫번 꺼에 a 추가 
  Array.conat(arr) Array배열에 arr배열 추가
  Array.concat(arr,arr2) Array배열에 arr배열 arr2배열 추가
  ```


* dom

  ```html
  //window.onload window창에 문서 로딩 완료되면 함수 실행
  //window.onload = function(){alert(document.getElementById("second").innerHTML)};
  //         함수, 시간
  setTimeout(function(){
  	//function(){alert(document.getElementById("second").innerHTML)},
  	//document.getElementById("second").style.color="red"}, 
  	//var h1_list = document.getElementsByTagName("h1")
  	//alert(h1_list.length)
  	//h1_list[0].style.color = "blue"
  	//var pink_list = document.getElementsByClassName("pink")
  	//alert(pink_list.length)
  	//pink_list[0].style.color="pink"
  
  	//# id . class
  	document.querySelector("#first");
  	document.querySelectorAll(".pink");
  	document.querySelector("input[type=text]:first");
  	
  	},1000);
  ```

  

* dom2

  ```html
  window.onload = function(){
  	document.querySelector("h1").innerHTML += "제목변경";
  	document.querySelectorAll("div")[1].innerHTML+= "수정";
  	document.querySelectorAll("div")[0].textContent +="<h3 style='color:red'>수정</h3>";
  	document.querySelectorAll("div")[2].style.color="blue";
  	document.querySelectorAll("div")[2].style.backgroundColor="red";
  	for(var i =1; i<=10;i++){
  		document.body.innerHTML+="<div>"+i+"</div>"
  	}
  	//alert
  	var div_list = document.querySelectorAll("div");
  	for(var i =1; i<div_list.length;i++){
  		div_list[i].style.backgroundColor="#00"+(i+1)*7+"00";
  	}
  	//document.getElementsTagName("img")[0];
  	//document.querySelectorAll("img")[0];
  	var img_tag = document.querySelector("img");
  	img_tag.src="/html/images/google.png";
  	img_tag.width =100;
  	img_tag.height=100;
  	img_tag.setAttribute("user-define","이미지");
  	alert(img_tag.getAttribute("user-define"));
  }
  ```

* event

  ```html
  
  window.onload = function(){
  	var click = document.querySelector("#but");
  	click.onclick = function(event){
  		alert(event.target.value);
  		click.value="수정";
  	}
  }
  ```

  

* event

  ```html
  window.onload =function(){
  	document.querySelector("a").onclick =
  		function(e){
  		e.preventDefault();
  	}
  	document.querySelector("#f").onsubmit =
  		function(e){
  		e.preventDefault();
  	}
  }
  ```

  

* foreach()

  ```html
  array.forEach(function(i){i++;})
  
  ```

  

```html
	let mouseevent = document.querySelector("#mousetest");
mouseevent.onmouseover=
		function(){
		mouseevent.style.backgroundColor="red";
	}
	mouseevent.onmouseout=
		function(){
		mouseevent.style.backgroundColor="blue";
	}
	*/
	mouseevent.addEventListener("mouseover",()=>{
		mouseevent.style.backgroundColor="red";
	});
	mouseevent.addEventListener("mouseout",()=>{
		mouseevent.style.backgroundColor="blue";
	});
```

* jqurey 라이브러리 설치

```html
$(document).ready(()=>{
	//alert("jquery시작");
	$("h1").css("color","blue");
	$("#a").css("color","red");
	//$(".b").css("color","red");
	
	//$("img").attr("src","/html/images/google.png");
	//$("img").attr("width","100");
	//$("img").attr("height","100");
	
	/*$("img").attr({
		src:"/html/images/google.png",
		width:100,
		height:100
		});
	*/
	$("img").attr("src","/html/images/google.png");
	$("img").attr("width",(index)=>{
		return (index+1)*100;
	});

	alert($("img").attr("width"));
	alert($("h1").css("color"));
});


$(document).ready(()=>{
	/*
	$("div").html($("div").html()+"<h1>추가변경</h1>");
	alert($("div").html());
	*/
	$("div").text($("div").text()+"<h1>추가변경</h1>");
	alert($("div").text());
});



```

* class

  ```html
  .hover{
  color:red;
  background-color: green;
  padding: 20px;
  margin:10px;
  }
  .test{
  width: 100px;
  height: 50px;
  }
  </style>
  <script src="jquery-3.2.1.min.js"></script>
  <script >
  $(document).ready(()=>{
  	setTimeout(()=>{
  		$("h1").addClass("hover");
  		//$("div").addClass("test");
  		//$("span").removeClass("hover");
  		
  
  		var value = $("input[type=text]").val();
  		var value2 = $("input[type=checkbox]:checked").val();
  		var value3 = $("input[type=checkbox]");
  	//	var value4 = $("input[type=checkbox]").val(function(){
  			//$("#here").html($("#here").html() + $(this).val());
  			//$("#here").append($(this).val()+":");
  	//	});
  		//$("#here").html("<h1>"+value+"<h1>");
  		//$("#here").html("<h1>"+value2+"<h1>");
  		$("#here").html(value3[0].value+"|"+ value3[1].value);
  		//alert(value3.length);
  	},1000);
  
  	
  	
  	$("h1").click(function(){
  		$("h1").on("click",function(){
  		//	$("h1").css("border","solid 3px aqua");
  			$(this).css("border","solid 3px aqua");
  		});
  	});
  	$("#mou").on("mouseover",function(){
  		$(this).css("background-color","blue");
  	});
  	$("#mou").on("mouseout",function(){
  		$(this).css("background-color","orange");
  	});
  	$("button#off").on("click",function(){
  		$("h1").off("click");
  	});
  	$("button#1").one("click",function(){
  			alert(1);
  	});
  	$("a").on("click",function(e){
  		e.preventDefault();
  		$(this).css("text-decoration","none");
  		$(this).css("color","green");
  	});
  	
  	$("#but").on("click",function(){
  		$("#result").append("<button id ='adfter'>add</button>");
  	});
  	$("#result").on("click","#adfter",function(){
  		alert("adter");
  	});
  });
  ```

  

* checkbox

  ```html
  // 전체 갯수
  $("input:checkbox[name=is_check]").length
   
  // 선택된 갯수
  $("input:checkbox[name=is_check]:checked").length
   
  // 전체 체크
  $("input[name=mycheck]:checkbox").prop("checked", true);
   
  // 전체 체크 순회
  $("input:checkbox[name=is_check]").each(function() {
   this.checked = true;
  });
   
  // 체크여부 확인
  if($("input:checkbox[name=complete_yn]").is(":checked") == true) {
    //작업
  }
  ```

  

* 글자 제한

  ```html
  	$("input:text").on("keyup",function(e){
  		
  		if(e.keyCode > 57||e.keyCode<48 )
  		{
  			$("input:text").hide(1000);
  			$("input:text").show(1000);
  			//alert("글자"); 
  		}
  		
  			
  	});
  ```

  