# Git 정리

## 명령문

* git init
* git remote add origin 주소
* git status 상태
* git add . 전부 추가
* git init 파일기본 셋팅
* git log 로그
* git log --oneline 깃 사이트 버전 확인 가능
* git commit -m '코멘트' 사이트 올리기전에 대기상태
* git push origin master 깃 사이트에 올리기
* git pull  origin master 사이트 버전 받기
* vim 화면에서  esc + :wq 누르면 입력창 나가짐
* git clone  _주소_ 깃 사이트에서 버전 받기
* 로그인 후 아이디 계정 아이디 물어봄
* 다시 비번 입력

# gitignore

* [.gitignore 파일] 깃 사용 금지에 사용

* 메모장 사용x

  ```c++
      data.csv
      secret_forder/
      .zip
      등으로 명시하면 잠김
      /폴더를 뜻함
  ```

  * http://gitignore.io/ <-사이트

    <b/>

  # branch

* 명령어
  * git branch _이름_   :생성
  * git checkout _이름_  :이동
  * git checkout -b _이름_  :생성 후 이동
  * (master)$ git merge _이름_  :마스터에서 병합
  * git branch  :목록
  * git branch -d _이름_  :삭제

# 커밋 메시지 편집기 등록

* git config --global core.editor "code --wait"
* VsCode 받아서 설치 후