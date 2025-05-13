# 백엔드의 게시판 개발
JAVA, SPRINGBOOT를 이용한 백엔드 게시판
# 개발 환경
- 언어: JAVA
- 개발 Tool: Intellij IDEA, SPRINGBOOT
- DB: H2, JPA
# 인원
JAVA와 SPRING의 연습을 위해 혼자 개발
# 기간
2024/02 ~ 2024/03 약 두 달간 개발
# 기능
- 회원 가입과 로그인이 있는 간단한 게시판
- 로그인시 글 작성 가능
- 제목 클릭시 상세페이지로 이동
- 로그인 아이디를 가져와 작성자와 일치시 수정, 삭제 버튼 생성
# 화면
![Image](https://github.com/user-attachments/assets/547e5327-d206-4427-bc29-d891403c9f65)

![Image](https://github.com/user-attachments/assets/2838a827-b7b4-4498-aec2-46156bd047c4)

![Image](https://github.com/user-attachments/assets/e34ca704-4602-4e51-9ea4-257c6edfd973)

![Image](https://github.com/user-attachments/assets/64ae160d-b9d8-4c5a-ae4f-6d2ceb469f51)

![Image](https://github.com/user-attachments/assets/b53f502a-34b9-4e9b-adad-05024e9a3fee)

![Image](https://github.com/user-attachments/assets/43b99a67-6d53-4ba8-8add-636b9b1f3fd2)

![Image](https://github.com/user-attachments/assets/4d5abd84-233f-4dfd-9b07-5e94498487ea)

![Image](https://github.com/user-attachments/assets/d0e1e572-9bf7-4055-9554-5e23e4a220da)

![Image](https://github.com/user-attachments/assets/d172742c-3622-464e-bc9f-4accdd142a75)

![Image](https://github.com/user-attachments/assets/300f5f61-0be0-40ac-b3a5-f599636e9adc)

![Image](https://github.com/user-attachments/assets/40cfcc4f-84f2-4b8a-9a11-b42f7c902c7e)

![Image](https://github.com/user-attachments/assets/4977d7cd-e3a1-45fc-80ed-7d9376adef02)

# 개발하면서 힘들었던점 및 느낀점
- 삭제, 수정 버튼 생성 시 로그인 아이디가 게시글 DB에 있는 아이디와 일치했을 때 스크립트에서 삭제, 수정 버튼을 활성화 또는비활성화 하는것

  로그인 아이디와 DB에 있는 게시글 아이디를 HTML에서 한 번에 가져오는 법을 검색
  
  페이지에서 JAVASCRIPT로 값을 가져오기 위해 여러 가지 방법을 찾아봄
  
  HTML에 TH:IF를 사용해 A eq B로 성공함

- 느낀점

  인터넷상에는 거짓 정보가 생각보다 많고, 시스템 또는 버전 등이 맞지 않으며 자세하게 나와 있지 않아 정확한 정보를 찾는 것을 반복할 필요성이 있어 보임
  
  개발하면서 GIT을 사용하지 않아 수정했을 때 코드가 이상해져 롤백이 힘들기 때문에 사소한 것을 개발해도 GIT을 사용할 필요성이 있음
