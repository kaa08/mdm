# AI 동영상 분석 기술을 사용한 교통사고 과실비율 측정 서비스 개발

> **프로젝트명**: mdm(몇대몇) <br>
> **기간**: 2024년 3월 ~ 6월 <br>
> **참여인원**: 4명(백엔드 2명, 프론트엔드 1명, AI 1명) <br>
> **담당 역할**: 백엔드 개발 및 AI 모델 연동
<br>

## 전체적인 프로젝트 소개
<img width="1207" height="622" alt="image" src="https://github.com/user-attachments/assets/b7222eed-6f71-46de-b0d5-73f61d21be43" />


- AI 동영상 분석 기술을 활용하여 **교통사고 영상으로 과실비율을 예측**하는 웹 기반 서비스  
- 교통사고 영상 속 객체 인식(DetectoRS)과 사고 상황 분석(VTN)을 통해 과실 비율을 측정하고 그 결과를 시각적으로 사용자에게 제공
- 누구나 간편하게 교통사고 과실비율을 측정할 수 있으며, 측정 시간과 비용을 절감할 수 있음
---

## 기술 스택

| 구분 | 기술 |
|------|------|
| **Frontend** | React, HTML/CSS/JavaScript, Next.js |
| **Backend** | Spring Boot, Spring Data JPA, Spring Security |
| **AI Server** | Flask (Python) |
| **AI Framework** | PyTorch, CUDA, CUDNN, DetectoRS, VTN |
| **Database** | MariaDB |
| **Middleware / 모듈** | Passport.js, Body-parser, Multer, fs, morgan |
| **개발 도구 (IDE/에디터)** | Visual Studio Code, IntelliJ IDEA, PyCharm, ATOM |
| **협업 도구** | Git, GitHub |
| **운영체제 (OS)** | CentOS |
| **서버 정보** | TCP Port: 60011, DNS: ceprj.gachon.ac.kr:60011 |
| **서버 하드웨어** | CPU: Intel Core2Duo / RAM: 4GB / DISK: 500GB (SATAII) / Network: 100Mbps |


---

## 사용 모델

- **DetectoRS**: 교통사고 영상 내 차량, 사람, 도로표지 등 객체 인식
- **VTN (Video Transformer Network)**: 사고 유형 분류 및 과실 비율 예측

---

## AI 서비스 시나리오
<img width="1070" height="554" alt="ai 서비스 시나리오" src="https://github.com/user-attachments/assets/50922c23-01f1-4c22-b80d-e179fe022147" />

1. 사용자가 교통사고 영상을 웹에 업로드
2. 웹 서버(Next.js, Spring Boot)에서 영상을 Flask AI 서버로 전송
3. DetectoRS로 객체 인식 → VTN으로 사고 분석 및 과실비율 예측
4. 예측 결과(JSON)를 다시 웹 서버로 전송
5. 결과를 시각화하여 사용자에게 표시

---

## AI 서비스 주요 시나리오
<img width="956" height="426" alt="AI서비스 주요시나리오" src="https://github.com/user-attachments/assets/56fee3f2-0003-4708-9e5b-b61d71366e8a" />

- 객체 인식 예시: 차량, 보행자, 신호등, 횡단보도 등
- 과실비율 예시: `40:60`, `70:30` 형태로 정량화
- 사고 유형 분류 예시: 차대 사람, 차대 이륜차, 차대 차 등

---

## 서비스 주요 특징

- **실제 교통사고 영상을 활용한 AI 기반 자동 분석**
- **객체 인식 + 시계열 기반 사고 분석 모델 조합**
- **모바일과 데스크탑 대응 웹 인터페이스**
- **과실비율 결과의 시각화 + 커뮤니티 기능 포함**

---

## 주요 기능

- JWT 기반 로그인/회원가입
- 영상 업로드 및 실시간 분석 요청
- AI 결과 수신 및 시각적 결과 렌더링
- 커뮤니티/후기 게시판 + 관리자 페이지
- AI 서버(CORS, 포트 관리 등) 통신 안정화 처리

---

## 웹 페이지 구성

> 1. 사용자 페이지
<img width="956" height="502" alt="사용자페이지 구성도" src="https://github.com/user-attachments/assets/c201d09a-6cef-4b90-93c0-17facd458864" />

> 2. 관리자 페이지
<img width="956" height="383" alt="관리자페이지구성도" src="https://github.com/user-attachments/assets/045d20be-9f55-4037-a18d-bf8ea480007a" />

---

## 주요 개발 기능

- **React + Redux**: 상태 관리
- **Axios**: API 통신
- **Dropzone**: 영상 업로드
- **React-player**: 동영상 최적화 재생
- **Sharp**: 이미지 최적화
- **JWT 기반 인증**: 로그인/회원가입 구현
- **Spring Security + CORS 처리**
- **JPA**: CRUD 및 MariaDB 연동

---

## 트러블슈팅

### 문제1: 프레임 단위로 객체 인식 불가  
- OpenCV로 프레임 단위 분리 후 저장 → 객체 인식 성공

### 문제2: AI 서버와 웹 서버 간 통신 오류  
- Flask 서버에 CORS 허용 설정 적용  
- API 요청 URL 및 포트 명확히 분리하여 해결

### 문제3: JWT 토큰 만료 시 처리 안됨  
- Spring Security에서 JWT 만료 예외 처리 추가 구현

---

## 느낀 점

이번 프로젝트는 백엔드 개발자로서 단순한 기능 구현을 넘어, 서비스 전반의 흐름을 고려한 시스템 설계와 API 연동 경험을 쌓을 수 있는 값진 기회였습니다. Spring Boot 환경에서 AI 모델을 Flask를 통해 연동하고, 프론트엔드와 API를 통해 데이터를 주고받는 과정에서 사용자의 흐름과 인터페이스 **반응을 고려한 구조 설계가 얼마나 중요한지를 체감**했습니다.
프로젝트 전체를 통해 **기술 스택에 대한 이해도는 물론, 협업을 통해 성장하는 방식**까지 체득할 수 있었고, 이러한 경험은 이후 개발자로서 실무에 임하는 데 큰 자산이 될 것이라 확신합니다.

## 시연 동영상


https://github.com/user-attachments/assets/fd9bae9a-2cd7-4d67-8336-cb2d3cc2a10b


## 👥 팀원

| 역할 | 이름 | GitHub |
|------|------|--------|
| 프론트엔드 & 디자인(팀장) | 전민혁 | - |
| 백엔드 & AI 연동 👋 | 가한솔 | https://github.com/kaa08 |
| 백엔드 & AI 연동 | 이연송 | https://github.com/cloud-yeonsong |
| AI 모델 | 이예지 | - |
