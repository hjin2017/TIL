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

* 실습1
  * select from 필수
    * select  조회이름 from  파일명
    * select first_name from employees;
    * select first_name,last_name  from employees;
    * select *from employees;
    * select salary from employees;
    * select salary *12 from employees;//값에 사칙연산 가능
    * select first_name,salary ,salary *12 from employees;
    * 컬럼 이름 임시 변경
      * select first_name as 이름 ,salary as 월급 ,salary *as 월급 from employees; // as 변경이름
    * 직종코드 1번씩만 조회
      * select job_id from employees; //전체 조회
      * select distinct job_id from employees; // distinct 중복제외
    * 대문자로 변경
      * select first_name,upper(first_name) as 대문자 from employees;// upper()
  * where  //목록 세부 조회
    1. where salary >= 10000 and salary <=11000; // 연산자  != (<>), = ,not and or
    2. select employee_id, first_name from employees where employee_id=50 or  employee_id=100;
    3. select employee_id, first_name from employees where employee_id in(50,100,150,200,250,300);//in 목록연산
    4. select first_name from employees where first_name = 'Jennifer'; //찾기
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
    4. select salary,first_name from employees order by salary desc,first_name asc;
    5. select salary,first_name from employees order by 1,2 desc;  //배열 인덱스로 표현가능
    6. select salary as 급여,first_name from employees order by 급여,2 desc;  // 별명 사용가능
    7. select hire_date from employees order by hire_date desc;
    8. select commission_pct from employees where commission_pct is not null order by 1 desc; // null==> is not null 널이 아닌것
  * ex 
    * 임사일  hire_date 
    * 입사년도 x
    * 입사월 6 월 입사 사원 이름 급여 입사일  조회 
    * 입사일이 가장 최근 사원 부터
    * select hire_date,first_name,salary from employees where hire_date like '%/06/%' order by hire_date desc;

``` command Line
select hire_date,first_name,salary from employees where hire_date like '%/06/%' order by hire_date desc;

HIRE_DAT FIRST_NAME                                   SALARY
-------- ---------------------------------------- ----------
07/06/21 Donald                                         2600
07/06/21 Martha                                         2500
06/06/24 Julia                                          3400
05/06/25 David                                          4800
05/06/14 Kelly                                          3800
04/06/14 Jason                                          3300
03/06/17 Steven                                        24000
02/06/07 William                                        8300
02/06/07 Susan                                          6500
02/06/07 Hermann                                       10000
02/06/07 Shelley

11 rows selected.
```

* 
  * where rownum  목차순번123456
  * select rownum, hire_date from employees order by 1 <=5;
* subquery //이중배열 정렬//top n query
  * select .... from(select*from...) where...order...
  * select rownum,hire_date from(select*from employees order by hire_date desc)where rownum;
  *  select first_name from employees where department_id = (select department_id from departments where department_name = 'Sales');
  * (>=all)(>=any) 

## ex 

1. 2002년 이후에 입사한 직원들 중에서 급여가 13000 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.

select first_name,salary,job_id,hire_date  from employees 

where (hire_date between '02/01/01' and sysdate) and  (salary between 13000 and 20000);

2. 근무한지 10년이 넘은 사원의 이름과 근무년수를 조회하시오.

select first_name, hire_date  from employees where (sysdate-hire_date) >=all 3650;

3. 직원 중에서 상관이 없는 직원의 이름과 급여를 조회하시오.
상관의 정보는 manager_id 컬럼에 있습니다.

select first_name,salary  from employees where manager_id  is null ;

4. 10, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오.

select first_name,salary ,DEPARTMENT_ID from employees where DEPARTMENT_ID in(10,50) and salary >all 1300;

5. 직종이 clerk 직종인 직원의 이름, 급여, 직종코드를 조회하시오.
(clerk 직종은 job_id에 CLERK을 포함하거나
CLERK으로 끝난다.)

select first_name, salary,job_id from employees where job_id like '%CLERK%';

6. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.

select first_name,salary,hire_date  from employees where hire_date like '%12%';

7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.

select first_name,salary,hire_date  from employees where first_name like '%m';

8. 이름의 세번째 글자가 d인 이름, 급여, 입사일을 조회하시오.

select first_name,salary,hire_date  from employees where first_name like '__d%';

9. 커미션을 받는 직원의 이름, 커미션, 총급여를 조회하시오.
총급여는 커미션*급여로 계산합니다 COMMISSION_PCT

select first_name,COMMISSION_PCT, SALARY,SALARY+SALARY*COMMISSION_PCT from employees where COMMISSION_PCT  is not null;

10. 커미션을 받지 않는 직원의 이름, 급여를 조회하시오.

select first_name, SALARY from employees where COMMISSION_PCT  is null;

11. 10월에 입사해서 30, 50, 80 번 부서에 속해있으면서, 
급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.

select first_name, salary,hire_date  from employees where (hire_date  like '%10%') and (salary between 5000  and 17000 ) and (COMMISSION_PCT is null) order by hire_date ;

12. jobs 테이블
job_id : 직종코드
job_title : 직종명
max_salary : 해당직종 최대급여
min_salary : 해당직종 최소급여

jobs 테이블에서 회장과 부회장의 직종명, 최소급여,최대급여를 조회하시오.
 job_title은 직종명이고 회장은 president, 부회장은 vise president를 포함합니다.

select job_title, min_salary ,max_salary from jobs where job_title like '%esident';

13. countries 테이블
    country_id : 국가코드
    country_name : 국가이름

    countries 테이블에서 국가이름이 United Kingdom 인 국가의
    국가코드를 조회하시오.

    select country_id from countries where country_name='United Kingdom';

14. locations 테이블
    city : 도시이름
    country_id : 도시가 위치한 국가코드

    13번에서 조회한 결과를 이용하여 United Kingdom에 위치한
    도시이름을 조회하시오.

    select city ,country_id from locations where country_id =(select country_id from countries where country_name='United Kingdom') ;

    



