# oracle java 연동

* 환경 설정

  1. 오라클에 있는 라이브러리를 oracle-> procuct->jdbc-> 버전
  2. lib ext 에 복붙 ->이클립스 실행
  3. 자바 class

  ``` java
  try {
  			Class.forName("oracle.jdbc.driver.OracleDriver");
  			
  			Connection conn = DriverManager.getConnection
  			("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
  			
  			System.out.println("db연걸성공");
  			conn.close();
  			System.out.println("db연걸해제");
  			
  		} catch (ClassNotFoundException e) {
  			System.out.println("드라이버 세팅 확인 하세영");
  		} catch (SQLException e) {
  			System.out.println("db연결 정보 확인");
  			e.printStackTrace();
  		}
  ```

* select * from user_constraints; 제약 조건 확인 하는 법

    select constraint_name,constraint_type,search_condition,table_name from user_constraints  2* where table_name ='C_EMP';

* db추가

  ``` java
  String sql ="insert into c_emp values(600,'이자바','임원',10000,10)";
  			//db전송
  			Statement st =conn.createStatement();
  			//실행
  			int insertrow = st.executeUpdate(sql);
  			//결과
  			System.out.println(insertrow + " db 행 추가");
  ```

  ```java
   conn = DriverManager.getConnection
  			("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","jdbc");
  			System.out.println("db연걸성공");
  			//Update
  			String sql ="update c_emp set salary = salary+"+args[1]+" where title = '"+args[0]+"'";
  					//"update c_emp set title ='대리' where emp_name ='이자바'";
  			/*"update c_emp set title ="
  					+ " (select title from c_emp where emp_id = 100)"
  					+ " where c_emp_name = '이자바'" ;*/
  			
  			cst =conn.createStatement();
  			int update =cst.executeUpdate(sql);
  			System.out.println(update + " Update");
  ```

* db 탐색

  ```java
  String sql = "select * from c_emp";
  			st =conn.createStatement();
  			rs =st.executeQuery(sql);
  			while(rs.next()) {
  					int emp_id =	rs.getInt("cnt");
  					String emp_name= rs.getString("emp_name");
  					String title =  rs.getString("title");
  					double salary = rs.getDouble("salary");
  					int dept_id = rs.getInt("dept_id");
  					System.out.println(emp_id+"|"+emp_name+"|"+ title+"|"+ salary+"|"+dept_id);
  					System.out.println(emp_id);
  			}
  ```
  
* prepareStatement()

  ```java
  String sql ="insert into c_emp values(?,?,?,?,?)";
  			PreparedStatement st =conn.prepareStatement(sql);
  			
  			st.setInt(1,800); st.setString(2,"김신입");
  			st.setString(3,"사원"); st.setDouble(4, 10000.99);
  			st.setInt(5,10);
  			
  			int insertrow = st.executeUpdate();
  ```

  ``` java
  String sql = "select first_name,salary  from (select row_number() over(order by salary desc) as r,first_name,salary from employees)where r between ? and ?";
  			st =conn.prepareStatement(sql);
  			st.setInt(1, 5);
  			st.setInt(2, 10);
  			
  			rs =st.executeQuery();
  			
  			while(rs.next()) {
  					String emp_name= rs.getString("first_name");
  					double salary = rs.getDouble("salary");
  					System.out.println(emp_name+"|"+salary);
  					}
  ```

  * window ->show view->data sourece explorer
  * database connections ->new -> oracle
  * new file -> sql file ->