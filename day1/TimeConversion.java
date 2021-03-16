package day1;

public class TimeConversion {

	public static void main(String[] args) {
		
		//시분초단위 변경 출력 
		int time =10000;//초 단위
		int var = 60;
		
		int timeTemp = time / var;  //1만 초 ->166분
		int second = time % var;  //40초
		int hour = timeTemp / var;     //166분->2시
		int minute = timeTemp % var;     //46분
		
		//결과
		System.out.println(time+"초는 "+hour+"시"+minute+"분"+second+"초");
		
		//hour 변수가 24시 지나면 1일 경과했습니다 24시 미만 이면 1일 이내입니다
		System.out.println(hour>24?"만 1일 경과했습니다.":"1일 이내입니다.");
	}
}
