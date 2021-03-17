# java 정리

## day1

* 연산자 % / 사용법

  ```java
  int time =10000;//초 단위
  int var = 60;
  		
  int timeTemp = time / var;     //1만 초 ->166분
  int second = time % var;       //40초
  int hour = timeTemp / var;     //166분->2시
  int minute = timeTemp % var;   //46분
  ```

  </b>

  ## day2

* 난수 생성 

  ```java
  (int)(Math.random()*100)+1;
  //(int) 형변
  //Math.random() 난수 생성 0.xxx
  //*100 올림을 위하여
  //+1는 시작값 0이면 0부터 1이면 1부터
  ```

* array

  ``` java
  int two_ar[][]= new int[3][4];
  // 자료형 변수이름 = new 레퍼런스생성 데이터 크기
  ```

## day3

* enum 

  ```java
  public enum Week {
  MONDAY , TUSDAY , WENESDAY , THURSDAY
  ,FRIDAY, SATURDAY , SUNDAY
  }
  //클래스 생성 
  //string형으로 사용 가능
  //int형으로 사용 불가
  ```

## day4

* Singleton

  ``` java
  class A{
  	
  	private static A a1 =new A();
  	
  	private A(){
  		System.out.println("A 생성자 호출");
  	}
  	
  	static A getInstance(){
  		return a1;
  	}
  	
  }
  public class SingletonTest {
  	public static void main(String[] args) {
  			A.getInstance();
  			A.getInstance();
  			A.getInstance();
  	}
  }
  ```

  * static 을 사용 하여 클래스 생성 하여 사용