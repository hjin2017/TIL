





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
  //static 을 사용 하여 클래스 생성 하여 사용
  ```


# day7

* 컬렉션 프레임워크
  * java.util.List 인터페이스 ,인덱스O ,순서O
  * java.utiil.Set  인터페이스 ,인덱스X, 순서X,데이터 중복 X
  * javaj.util.Map 인터페이스, 인덱스 X, 키 O,순서X
  * 722p~724p

 * ArrayList

    * 724p설명

    * 725p 사용법

    * Arraylist

      ``` java
      		int i =0;
      		float f= 3.14f;
      		double d =3.14;
      		
      		ArrayList list =new ArrayList(5);
      		list.add(i);
      		list.add(f);
      		list.add(d);
      		list.add(2.1);
      		list.add("s");
      		list.add(new Employee(100, "www", 100));
      		list.add(new Employee(200, "azww", 3100));
      		list.add(new Employee(300, "wzww", 4100));
      		list.remove(0);
      		if(list.contains("s")) list.remove(0);
      		System.out.println(list.size());
      		System.out.println("인덱스 오브"+list.indexOf("s"));
      
      		for (int j=0;j<list.size();j++){
      			System.out.println("list츨력 "+list.get(j));
      		}
      ```

   * Vector

     ```java
     Vector<Object> v = new Vector<Object>();
     		v.add(i);
     		v.add(2.1);
     		v.add("s");
     		v.add(f);
     		v.add(d);
     		v.remove(0);
     		System.out.println(v.size());	
     
     		for (int j=0;j<v.size();j++){
     			System.out.println("v츨력 "+v.get(j));
     		}
     ```

   * LinkedList

     ```java
     LinkedList<Object> ll = new LinkedList();
     		ll.add(i);
     		ll.add(2.1);
     		ll.add("s");
     		ll.add(f);
     		ll.add(d);
     		ll.remove(0);
     		System.out.println(ll.size());	
     
     		for (int j=0;j<ll.size();j++){
     			System.out.println("ll츨력 "+ll.get(j));
     		}
     ```

     

* | 배열10 생성 | 삽입                     | 삭제                    |
  | :---------- | ------------------------ | ----------------------- |
  | Arrylist    | 배열(10)+배열(10)로 증가 | 내부에서 인덱스 정리 함 |

* Arrylist 쓰레드 사용시 좋다
* vector 쓰레드 안쓰면 좋다
* LinkedList 삽입이 많으면 좋다
* 형 체크 bool(자료 instanceof 형)

# set

* 무작위 저장 하나의 값 만 저장

  ```java
  		HashSet<Employee> set = new 	HashSet<Employee>();
  		//int a=53512;
  		//set.add(a);
  		//set.add(53512);
  		//set.add(3.14);
  		//set.add("ss");
  		set.add(new Employee(100,"aaas",100));
  		set.add(new Employee(200,"aaas",100));
  		System.out.println(set.size());
  		
  		Iterator<Employee> it = set.iterator();
  		while (it.hasNext()){System.out.println(it.next());}	
  ```

* foreach

* ```java
  for (Integer integer : set) {
  			System.out.println(integer);
  ```

# map

* 740p

* ```java
  		for(String sd : map.keySet())
    			for(String ss: map.get(sd))
    				System.out.println(ss);
  ```

# Generic

```java
class Box<T>{
	T o;

	public Box(T o) {
		this.o = o;
	}

	public T getO() {
		return o;
	}

	public void setO(T o) {
		this.o = o;
	}
	
}
```

```java
class BoxManager{
	public <p1,p2> Box<p1,p2>test(p1 a,p2 p){
		Box<p1,p2> box2 = new Box<p1,p2>(a,p);
		return box2;
	}
}
///////////////////////////////////////////////////////////
	Apple a = new Apple();
	Paper p = new Paper();
	BoxManager manager = new BoxManager();
	Box<Apple,Paper> box2 = manager.test(a, p);
	System.out.println(box2.getT1().origin);
	System.out.println(box2.getK1().size);
```

``` java
//Fruit 상속 받은 아이만
class Box<T extends Fruit>{
  
    public void test(Box<? extends Fruit> b){
```

# day8

#  Innerclass

``` java
class Outer2{
    final int outervar =10;
	final static int outervar2 =20;
    static class Inner{
        class Inner2{
//클레스안에 클레스를 생성 기능 
//스텍틱은 스텍틱 변수만 사용
//이너클레스에서 사용되면 자동으로 파이널 형성됨 명시적으로 붙여야 좋다
```

``` java
	new A("s") {
					void ma() {	
						System.out.println("A");
					}
						
					}.ma();
```



```java
abstract class A{
	String s;
	A(String s){
		this.s =s;
		System.out.println(s);
	}
	abstract void ma();
	public void mb() {System.out.println("B");}
}

interface MyInter{
	void mi1();
	void mi2();
}
인터페이스를 1회용으로 사용 가능
```

# 람다

``` java
@FunctionalInterface
interface  As<T,T2,T3>{
	 T3 calc(T f,T2 s);
}
//함수는 1만 존제
```

```java
//()->{};
As<String,Integer,String> m = (x, y)->{
	String name ="s";
	return x + y+name;
};
```

```java
System.out.println(m.calc("d",1));
```

``` java
As<Integer,Integer,Integer> m3 =C::mc1;
As<Integer,Integer,Integer> m3 =new C::mc1;
//함수가 스텍틱 이여야 함
//NON 스텟틱이면 ()->함수 형임
//다른 함수를 불러서 사용가능
```

# 입출력

``` java
Scanner key = new Scanner(System.in);
		String word="" ;
	
	while(!word.equals("끝")) {
		 word = key.nextLine();
		 System.out.println(word);}
```

# Day9
```java
public static void main(String[] args) {
	FileReader fi = null; 
	FileWriter fo = null;
	try {
		fi = new FileReader(args[0]);
		fo = new FileWriter(args[1],true);
		while(true) {
			int result = fi.read();
			if(result== (int)(''))continue;
			fo.write(result);
			if(result == -1) {break;}
		}
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			fi.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

# day10

* 클라이언트

```java
public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.200.163",9999);
		System.out.println("서버연결중");
		
		OutputStream os =s.getOutputStream();
		DataOutputStream dos =new DataOutputStream(os);
		String data = "hello server";
		dos.writeUTF(data);
	
		InputStream i = s.getInputStream();
		DataInputStream dis = new DataInputStream(i);
		String input_b = dis.readUTF();
		System.out.println("+클라+"+ input_b+" |");
		
		s.close();
		System.out.println("서버와 연결종료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
```

* 서버 

```java
public static void main(String[] args) {
		//0~1024 사용 하지말자
		//1025 - 5000 피하쟈
		String ids[] = {"java","jsp","spring"};
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("+++++++서버대기중++++++");
			while(true) {
				
				Socket s = ss.accept();
				System.out.println("+++++++클라연결중++++++");

				InputStream i = s.getInputStream();
				DataInputStream dis = new DataInputStream(i);
				String input_b = dis.readUTF();
				
				String data = "hello client";
				for(String str :ids)
				{
					if(str.equals(input_b))
					{
						data="불가능";
						break;
					}
					else data="가능" ;
				}
				
				
				OutputStream os =s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF(data);
				
				s.close();
				System.out.println("+++++++클라종료중++++++");
			}
		} catch (IOException e) {e.printStackTrace();}

	}
```

* 패턴 
* 싱글톤 으로 게이트 열어서
* 여러 클레스들의 독립 생태계를 만들어 주고
* 기능별로 다시 묶어서 
* 관리를 한다