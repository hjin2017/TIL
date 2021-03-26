# Oracle 정리

# day1

* connect system/system 원형
* conn hr/hr //접속
* disconn //탈출

* alter user hr identified by hr account unlock; // hr 락해제

``` commonline
SQL> conn system/system
Connected.

SQL> alter user hr identified by hr account unlock;
User altered.

SQL> conn hr/hr
Connected.
```

* select*from tab;

``` commonline
SQL> set pagesize 100; // 크기 조졸
SQL> set linesize 150; // 라인 조졸
SQL> select*from tab; // 화면에 올림
TNAME              TABTYPE      CLUSTERID
-----------------------------------------------
COUNTRIES           TABLE
DEPARTMENTS       	TABLE
EMPLOYEES        	TABLE
EMP_DETAILS_VIEW    VIEW
JOBS            	TABLE
JOB_HISTORY      	TABLE
LOCATIONS        	TABLE
REGIONS          	TABLE
```

* DDL 생성-변경-삭제  
* DATA DEFINITION LANG
* DML 저장-수정-삭제
* DATA MANIPULATION LANG
* DCL 접속여부
* DATA  CONTROLL LANG 
* TCL 
* TRANSACTION CONTROLL LANG 
* DQL 조회
* DATA QUERY LANG

| ddl  | create table, alter table, drop table |
| :--- | ------------------------------------- |
| dml  | insert, update, delete                |
| dcl  | grant revoke                          |
| tcl  | commit, rollback                      |
| dql  | select                                |

* select from 필수
  * select  조회이름 from  파일명
  * select *from employees;
  * select salary *12 from employees;//값에 사칙연산 가능
  * 컬럼 이름 임시 변경
    * select first_name as 이름 ,salary as 월급 ,salary *as 월급 from employees; // as 변경이름
  * 직종코드 1번씩만 조회
    * select distinct job_id from employees; // distinct 중복제외
  * 대문자로 변경
    * select first_name,upper(first_name) as 대문자 from employees;// upper()
* where  //목록 세부 조회
  1. where salary >= 10000 and salary <=11000; // 연산자  != (<>), = ,not and or
  2. select employee_id, first_name from employees where employee_id=50 or  employee_id=100;
  3. select employee_id, first_name from employees where employee_id in(50,100,150,200,250,300);//in 목록연산
  5. select first_name from employees where first_name like 'J%'; // first_namedms J 좋와 like 패턴
  6. select first_name from employees where first_name like '%r';
  7. select first_name from employees where first_name like 'er%%';
  8. select job_id from employees where job_id like '___MAN'; // _ 개수 가 글자 개수
  9. where hire_date between '05/01/01' and '05/12/31' //범위 between
  10. desc employees; // 키워드 목록
  11. select sysdate from dual; // 날짜보기
  12. where job_id like '__\_MAN 'escape '\';// \ 를 글자로 인식하도록
* oder by  // 목록 순차 정렬
  1. s f w o 순서가 있음
  2. select first_name from employees order by first_name asc;  //asc//뒤 큰//생략 가능
  3. select first_name from employees order by first_name desc;  //desc//뒤 작//생략 불가능
  5. select salary,first_name from employees order by 1,2 desc;  //배열 인덱스로 표현가능
  6. select salary as 급여,first_name from employees order by 급여,2 desc;  // 별명 사용가능
  6. select commission_pct from employees where commission_pct is not null order by 1 desc; // null==> is not null 널이 아닌것
  7. select rownum 순차 123456 생성
  8. (>=all)(>=any)  all 은 &&  : any는 || 

## ex 

1. 2002년 이후에 입사한 직원들 중에서 급여가 13000 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.

   ``` c
   select first_name,salary,job_id,hire_date  from employees where (hire_date between '02/01/01' and sysdate) and  (salary between 13000 and 20000);
   ```

2. 근무한지 10년이 넘은 사원의 이름과 근무년수를 조회하시오.

   ```c
   select first_name, hire_date  from employees where (sysdate-hire_date) >=all 3650;
   ```

3. 직원 중에서 상관이 없는 직원의 이름과 급여를 조회하시오.
    상관의 정보는 manager_id 컬럼에 있습니다.

  ``` c
  select first_name,salary  from employees where manager_id  is null ;
  ```

4. 10, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오.

   ``` c
   select first_name,salary ,DEPARTMENT_ID from employees where DEPARTMENT_ID in(10,50) and salary >all 1300;
   ```

5. 직종이 clerk 직종인 직원의 이름, 급여, 직종코드를 조회하시오.
    (clerk 직종은 job_id에 CLERK을 포함하거나
    CLERK으로 끝난다.)

  ``` c
  select first_name, salary,job_id from employees where job_id like '%CLERK%';
  ```

6. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.

   ```c
   select first_name,salary,hire_date  from employees where hire_date like '___12%';
   ```

7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.

   ```c
   select first_name,salary,hire_date  from employees where first_name like '%m';
   ```

8. 이름의 세번째 글자가 d인 이름, 급여, 입사일을 조회하시오.

   ```c
   select first_name,salary,hire_date  from employees where first_name like '__d%';
   ```

9. 커미션을 받는 직원의 이름, 커미션, 총급여를 조회하시오.
    총급여는 커미션*급여로 계산합니다 COMMISSION_PCT

  ```c
  select first_name,COMMISSION_PCT,SALARY,SALARY+SALARY*COMMISSION_PCT from employees where COMMISSION_PCT  is not null;
  ```

10. 커미션을 받지 않는 직원의 이름, 급여를 조회하시오.

    ```c
    select first_name, SALARY from employees where COMMISSION_PCT  is null;
    ```

11. 10월에 입사해서 30, 50, 80 번 부서에 속해있으면서, 
    급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
    단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
    먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.

    ```c
    select first_name, salary,hire_date  from employees where (hire_date  like '%10%') and (salary between 5000  and 17000 ) and (COMMISSION_PCT is null) order by hire_date ;
    ```

12. jobs 테이블
    job_id : 직종코드
    job_title : 직종명
    max_salary : 해당직종 최대급여
    min_salary : 해당직종 최소급여

    jobs 테이블에서 회장과 부회장의 직종명, 최소급여,최대급여를 조회하시오.
     job_title은 직종명이고 회장은 president, 부회장은 vise president를 포함합니다.

    ```c
    select job_title, min_salary ,max_salary from jobs where job_title like '%esident';
    ```

13. countries 테이블
    country_id : 국가코드
    country_name : 국가이름

    countries 테이블에서 국가이름이 United Kingdom 인 국가의
    국가코드를 조회하시오.

    ```c
select country_id from countries where country_name='United Kingdom';
    ```
    
14. locations 테이블
    city : 도시이름
    country_id : 도시가 위치한 국가코드

    13번에서 조회한 결과를 이용하여 United Kingdom에 위치한
    도시이름을 조회하시오.

    ```c
    select city ,country_id from locations where country_id =(select country_id from countries where country_name='United Kingdom') ;
    ```

    # day2

    s f w g h o

    | 그룹함수 |                  |
    | -------- | ---------------- |
    | sum      | 총합,숫자        |
    | avg      | 숫자             |
    | count    | 숫자, 문자, 날짜 |
    | max      | 숫자, 문자, 날짜 |
    | min      | 숫자, 문자, 날짜 |
    | stdev    | 표준편차 :숫자   |
    | variance | 분산 :숫자       |

* groub by //select 절에 group과 일반 을 같이 사용가능
  * select first_name ,salary from employees where salary = (select max(salary) from employees) or salary = (select min(salary) from employees) ;
  * select department_id, job_id,sum(salary) from employees where department_id is not null group by department_id ,job_id order by department_id  ;

* having // group 전용 where

  select department_id, sum(salary) from employees group by department_id having sum(salary)>=50000;

* rollup // null 표기는 같은 분류의 총합을 보여줌

  select department_id, job_id,sum(salary) from employees where department_id is not null group by rollup (department_id ,job_id)  ;

* cube// 모든 부서의 총합

  select department_id, job_id,sum(salary) from employees where department_id is not null group by cube(department_id ,job_id) ;

* show user 현재 계정 찾기
* select sysdate from dual; ㄴ날짜
* dual 1행이 있는 더미 테이블
* select tname from tab; 데이터 베이스 보여주기
* cast()형변 cast(? as ?)
* select cast(sysdate as timestamp)from dual; 세부시간
* number(11,2) 11 정수 자리 수 2 실수 자리 수
* 
* TO_CHAR(123456.777,'L999,099.99')

| $               | 달러       |
| --------------- | ---------- |
| L               | 현재 통화  |
| 9,0             | 숫자 1자리 |
| YY-2000,YYYY,RR | S년도      |
| MM              | 월         |
| DD              | 일         |
| HH,HH24         | 시간       |
| MI              | 분         |
| SS              | 초         |
| DAY             | 일         |

* SELECT TABLE_NAME FROM DICT WHERE TABLE_NAME LIKE '%NLS%';

  SELECT*FROM NLS_SESSION_PARAMETERS WHERE PARAMETER = 'NLS_DATE_FORMAT';

  SELECT TO_CHAR(SYSDATE,'YYYY/MM/DD DAY HH24:MI:SS')FROM DUAL;

  SELECT TO_CHAR(SYSDATE, 'FMYYYY"년"MM"월"DD"일" DAY HH24"시"MI"분"SS"초"')FROM DUAL; // FM필요없는것 버리기

  SQL> SELECT TO_DATE('21/03/25','YY/MM/DD')+1 FROM DUAL;

| 형변 | CAST, TO_DATE,TOCAHR,TONUMBER                                |
| ---- | ------------------------------------------------------------ |
| 구룹 | SUM,AVG,MIN,MAX,                                             |
| 문자 | CONCAT('A', '가'),\|\|문자 합체,INSTR(123,3) 인덱스 확인,initcap 초기값 lower,upper,LENGTHB(바이트),LENGTH(글자 수),replace / translate ('this is java','java','oracle')오라클로 변경해줌,substr(대상,4,2)='03' 문자열 자르기 4번째 부터 2개,ltrim 왼쪽 공백제거,rtrim 오른쪽 공백 제거(대상,#)#제거,LPAD |
| 숫자 | mod(3,3) == 3%3 round(대상,-10(정수)~10(소수))-반올림 trunc  반올림 x |
| 날짜 | sysdate,systimestamp,add_months,months_between               |
| 순위 | rownum 별도 row_number,rank,dense_rank //순위 함수()over(partition by 구룹 컴럼 order by 컬럼 desc) |
| null | nvl(salary,0)                                                |

select rtrim(ltrim('$$a$$','$'),'$')from dual;

 select EMPLOYEE_ID from employees where mod(EMPLOYEE_ID,2)=1;

select hire_date,salary, AVG(salary) from employees;

SELECT SYSTIMESTAMP FROM DUAL;

select add_months(sysdate,1) from dual;

select add_months(sysdate,1) from dual;

months_between(a,b);

select first_name as 이름, salary as 급여, row_number() over(order by salary desc ) as 급여순위 from employees ;

select first_name as 이름, salary as 급여, rank() over(order by salary desc ) as 급여순위 from employees ;

select first_name as 이름, salary as 급여, dense_rank () over(order by salary desc ) as 급여순위 from employees ;

select first_name as 이름, salary as 급여, row_number() over(partition by department_id order by salary desc ) as 급여순위 from employees ;

select first_name, salary,nvl(to_char(commission_pct),'읏자')as a1 from employees;

select first_name, salary,nvl(to_char(commission_pct),'읏자')"ㅁ ㅁ ㅁ" from employees;

# ex

1. 이름이 'adam' 인 직원의 급여와 입사일을 조회하시오.

   ```c
   select first_name,salary,hire_date from employees where first_name=initcap('adam');
   ```

2. 나라 명이 'united states of america' 인 나라의 국가 코드를 조회하시오.

   ```c
   countries 테이블
   country_id : 국가코드
   country_name : 국가이름
       select country_name from countries where upper(country_name) = upper('united states of america');
   ```

3. 'Adam의 입사일은 05/11/2 이고, 급여는 7,000\ 입니다.' 의 형식으로 직원
    정보를 조회하시오.

  ```c
  select ((first_name||'의 입사일은 ')||(to_char(hire_date,'yy/mm/fmdd')||'이고, 급여는 ')||(to_char(salary,'99,999')||'\입니다'))"직원정보" from employees;
  ```

4. 이름이 5글자 이하인 직원들의 이름, 급여, 입사일을 조회하시오.

  ```c
  select first_name,salary,hire_date from employees where LENGTH(first_name)< all 5;
  ```

5. 06년도에 입사한 직원의 이름, 입사일을 조회하시오.

  ``` c
  select first_name,hire_date from employees where to_char(hire_date,'yy') ='06';
  ```

6.  10년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무년차를 조회하시오.

  ```c
  select first_name,hire_date,salary,round((sysdate-hire_date)/365)as 년차  from employees;
  ```

7. employees 테이블에서 
    직종이(job_id) 'st_clerk'인 사원 중에서 급여가 1500 이상인 사원의
    first_name, job_id, salary 를 조회하시오. 단 이름은 모두 대문자로 출력하시오.

  ``` c
  select upper(first_name),job_id,salary from employees where job_id = upper('st_clerk') and salary > all 1500;
  ```

8. 급여합계가 20000 이상인 직종(job_id)의
    job_id, 급여합계를 조회하시오.
    단, 급여합계는 10자리로 출력하되 공백은 '0'으로 표시하시오. 으로 정정합니다.

  ```c
  select  job_id,LPAD(to_char(sum(salary)),10,'0')"합" from employees group by job_id having  sum(salary) >all 20000;
  ```

9. 직원의 이름, 급여, 직원의 관리자 사번을 조회하시오. 단, 관리자가 없는 직원은
    '<관리자 없음>'이 출력되도록 합니다.
    9번문제 관리자이름-->관리자사번 으로 정정합니다.

  ``` c
  select first_name,salary,nvl(to_char(MANAGER_ID),'<관리자 없음>') from employees;
  ```

  # day3

* join

  1. select employee_id,first_name,employees.department_id,department_name from employees, departments where employees.department_id = departments .department_id;
     * inner join
  2. select employee_id,first_name, e.department_id,department_name from employees e , departments d where e.department_id = d.department_id;
     * outer join // (+) 체우기
  3. select employee_id,first_name, e.department_id,department_name from employees e , departments d where e.department_id = d.department_id(+);

* ex  **inner join**

  * select first_name ,department_name ,city from employees e, departments d, locations l where e.department_id = d.department_id and d.location_id = l.location_id and upper(city)= 'LONDON';
  * select first_name ,department_name, city from employees e, departments d, locations l where e.department_id = d.department_id and d.location_id = l.location_id and department_name like '%IT%';

* ex **outer join**

  * select e.employee_id ,e.first_name , e.manager_id , m.employee_id, m.first_name from employees  e, employees  m where e.manager_id = m . employee_id(+) ;
  * select e.manager_id, e.salary ,e.first_name ,m.salary, m.employee_id from employees  e, employees  m  where e.salary>=all m.salary  and e.manager_id = m . employee_id;

* cross join 사용하면 안된다

  |       | ansi 표준 문법                        |                      |
  | ----- | ------------------------------------- | -------------------- |
  | inner | form 테이블1 t1 inner 테이블2 t2      | on 대상1=대상2       |
  | outer | form 테이블1 t1 left outer 테이블2 t2 | on 대상1=대상2       |
  | self  | form 테이블1 t1 inner 테이블2 t2      | on t1.대상1=t2.대상2 |

set pagesize 150;

set linesize 150;

* **union**  중복 제거// **union all** 중복 생존 위 조건과 아래 조건을 모두 포함 하는 것 **or**

  > * select first_name,department_id,salary from employees where department_id =50 union all select first_name,department_id,salary from employees where salary <= all 5000 order by first_name ;

* **minus**  위 조건을 포함하고 아래조건이 아닌것 **not**

  > * select first_name,department_id,salary from employees where department_id =50 minus select first_name,department_id,salary from employees where salary <= all 5000 order by first_name ;

* **intersect** 위 조건과 아래 조건을 포함 하는 것 **and**

  > * select first_name,department_id,salary from employees where department_id =50 intersect select first_name,department_id,salary from employees where salary <= all 5000 order by first_name ;

# DDL - 테이블 정의 / 변경 / 삭제

* **CREATE TABLE** :테이블이름(컬럼명1 타입(길이) 제약조건, 컬럼면2 타입(길이) 제약조건......);

* **ALTER TABLE **  

  > ​		 			  :테이블 이름 (ADD 컬럼명1 타입(길이) 제약조건);			
  >
  > ​				   	:테이블 이름 (MODIFY 컬럼명1 타입(길이) 제약조건);
  >
  >  			          : 테이블 이름 (DROP COLUMN 컬럼명1 타입(길이) 제약조건);

* **DROP TABLE** :테이블 이름

- db 테이블 소유주 = schema = 사용자 = 계정

  - 사용자 생성 권한 - systrm 계정

  - conn system/system;

  - create user 이름 identified by 암호

  - create user jdbc identified by jdbc;

  - grant resource , connect to jdbc;

  - grant select on employees to jdbc;

  - select * from hr.employees;

  - conn jdbc/jdbc

    ```c
    /*db 테이블 소유주 = schema = 사용자 = 계정*/
    SQL> conn system/system;
    Connected.
    SQL> create user jdbc identified by jdbc;
    
    User created.
    //jdbc resource에 connect 
    SQL> grant resource , connect to jdbc;
    
    Grant succeeded.
    
    SQL> conn jdbc/jdbc
    Connected.
    ```

    

* 테이블/컬럼  명명법 - java와 동일주석 -- 

  | emp 테이블                            |
  | ------------------------------------- |
  | id 정수 5자리                         |
  | name 문자열 20자리                    |
  | title 문자열 20자리                   |
  | salary 실수 정수 10 자리 소수점 2자리 |
  | dept_id 정수 5자리                    |

* TABLE

  * 생성
    * create table emp (id number(5), name varchar2(20),title varchar2(20),dept_id number(5), salary number(12,2));
    * create table emp_copy as select *from employees;
    * create sequence 이름(start with 10, increment by 5,maxvalue);
  *  삭제 
    * drop table  emp; 

* COLUMN  

  * 추가
    * alter table emp add indate date;
    * alter sequence 이름(start with 10, increment by 5,maxvalue);

  * 변경
    * alter table emp MODIFY name varchar2(20);
  * 삭제
    * alter table emp DROP COLUMN indate ;
    * DROP  sequence 이름;

# DML 

* 정보 추가

  * insert  테이블명(컬럼명) values (값.'''''''') 정보

  * insert   select ~from ??;

  * commit 추가

    ```c
    insert into emp values(100,'이사원','사원', 10,99000.5);
    insert into emp values(200,'김대리',null, null,null);
    insert into emp(id,name) values(300,'박과장');
    insert into emp values(400,'최부장','부장', 20,99000.5);
    insert into emp values(500,'박대리','대리', 20,99000.5);
    ```

* 정보 변경 

  * update   테이블명 set  변경 컬럼 = value where 변경조건식

  * update  emp set title = '대리' where id =200;

    ```c
    update  emp set salary=1000 where salary is null;
    update emp set dept_id= (select dept_id from emp where title = '대리' )where name = '박대리';
    ```

* 정보 삭제

  * delete 테이블명 where 삭제 조건

  * delete 테이블명 데이터 삭제

    ```c
    delete emp where id =100;
    ```

  * commit  or rollback

# TCL

* commit; 데이터에 추가
* rollback; commit전에  rollback
* 시퀀스 졸음

# 시퀀스

* create sequence 시퀀스 이름 1부터 시작
  * create swquence 시퀀스 이름 (start with 10, increment by5 maxvalue 100);
  * 10에서 5씩 100까지
* ex 
  * 시퀀스이름.currval 10->10->10->10
  * 시퀀스이름.nextval 10->15->20->25
  * inert into values(emp_seq.nextval,이자바', '사원', 30, 45000.55);
* 수정 삭제 
  * alter sequence 시퀀스 이름 start with 10
  * alter sequence 시퀀스 이름 increment by 5
  * drop sequence 시퀀스 이름

# 정보 제한

create table테이블 ( 이름 number(5) constraint 이름_2 check 이프문);

이름_2 에러에서 알려줌

​                                                                 unique+null                   primary key 

​																				널안되				not null

​																						하나만					unique



* ex 

  * create table c_dept_id(dept_id number(5) constraint dept_id_pk primary key, dept_name varchar2(20) constraint dept_name_uk unique, city varchar2(20) constraint city_nn not null);

  * create table c_emp( emp_id number(5) constraint c_emp_emp_id_pk primary key,  emp_name varchar2(20) constraint c_emp_name_nn not null, title varchar2(10) constraint c_emp_title_ck check (title in ('사원', '대리', '과장','부장','임원')), salary number(12, 2) constraint c_emp_salary_ck check(salary >= 1000), dept_id number(5) constraint c_emp_dept_id_fk references c_dept(dept_id) );

  * insert into c_dept values(10, '인재개발부', '제주'); 
  * insert into c_dept values(20, '교육부', '서울'); 
  * insert into c_dept values(30, '전산개발부', '대전'); 
  * commit;

  * insert into c_emp values(200, '박대리','대리',1999,10);
  *  insert into c_emp values(300, '안대리','대리',1999,20);
  *  insert into c_emp values(400, '박과장','과장',3000,30);
  *  insert into c_emp values(500, '박부장','부장',5000,10);
  * commit;

* 제거

  * alter table c_emp rename 이전컬럼명 to 새컬럼명;
  *  rename 이전테이블명 to 새로운테이블명; 
  * 아이디입력 – xxxx (자바 + db 연동) --> db c_emp 저장(sql)--> db 전송-->오라클

create table Student(No number(5) constraint No_pk_nn primary key,name varchar2(10),det varchar2(20),addr varchar2(80),tel varchar2(20));

insert into Student values(1,'홍길동','국문학과' ,'서울','010-1111-1111');

insert into Student values(2,'고길동','수학과' ,'인천','010-2222-2222');

