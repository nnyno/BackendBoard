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
- 메인화면

<img src="https://github.com/user-attachments/assets/8ed06ca3-5395-4d93-a142-2feb7eee1244" width="50%" height="50%"/>

- 회원가입

<img src="https://github.com/user-attachments/assets/c505f26c-fe34-4e60-b8f0-75a185f6cf16" width="50%" height="50%"/><img src="https://github.com/user-attachments/assets/878673ec-84e5-46b8-aa57-ae2021f37ccc" width="50%" height="50%"/>

- 로그인
<img src="https://github.com/user-attachments/assets/5c2bd247-1ad3-40f2-a9c3-b675dc75a0c9" width="50%" height="50%"/><img src="https://github.com/user-attachments/assets/e5a4e74a-808c-4ea8-9f0a-3efa6b7b6c72" width="50%" height="50%"/>

<img src="https://github.com/user-attachments/assets/82ccb46f-8e1b-45ec-a201-f3a2f515e650" width="50%" height="50%"/>
<img src="https://github.com/user-attachments/assets/9be6c9e5-1b0c-4c41-ae6e-5e52004a12e0" width="50%" height="50%"/>
<img src="https://github.com/user-attachments/assets/00899f67-fc01-48cc-a098-3a80fb9d4e5f" width="50%" height="50%"/>
<img src="https://github.com/user-attachments/assets/34d6a3c9-9f66-4ff8-8cbc-d508294c141c" width="50%" height="50%"/>
<img src="https://github.com/user-attachments/assets/9e25a51c-aae0-4c17-a6b2-70aa335676ad" width="50%" height="50%"/>
<img src="https://github.com/user-attachments/assets/01249c78-ce0f-4364-a0d2-d1a78af685c0" width="50%" height="50%"/>
<img src="https://github.com/user-attachments/assets/faedfda8-df7f-4140-820f-6f1c9ff324a8" width="50%" height="50%"/>
<img src="https://github.com/user-attachments/assets/e6d5ebeb-447f-4b7e-85c6-20af53706302" width="50%" height="50%"/>

# 개발하면서 힘들었던점 및 느낀점
- 삭제, 수정 버튼 생성 시 로그인 아이디가 게시글 DB에 있는 아이디와 일치했을 때 스크립트에서 삭제, 수정 버튼을 활성화 또는비활성화 하는것

  로그인 아이디와 DB에 있는 게시글 아이디를 HTML에서 한 번에 가져오는 법을 검색
  
  페이지에서 JAVASCRIPT로 값을 가져오기 위해 여러 가지 방법을 찾아봄
  
  HTML에 TH:IF를 사용해 A eq B로 성공함

- 느낀점

  인터넷상에는 거짓 정보가 생각보다 많고, 시스템 또는 버전 등이 맞지 않으며 자세하게 나와 있지 않아 정확한 정보를 찾는 것을 반복할 필요성이 있어 보임
  
  개발하면서 GIT을 사용하지 않아 수정했을 때 코드가 이상해져 롤백이 힘들기 때문에 사소한 것을 개발해도 GIT을 사용할 필요성이 있음
