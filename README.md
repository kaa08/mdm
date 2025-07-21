# AI 동영상 분석 기술을 사용한 교통사고 과실비율 측정 서비스 개발

> **프로젝트명**: mdm(몇대몇)<br>
> **기간**: 2024년 3월 ~ 6월  
> **참여인원**: 4명  
> **담당 역할**: 백엔드 개발 및 AI 모델 연동
<br>

## 전체적인 프로젝트 소개
![이미지 2025  7  19  오후 8 01](https://github.com/user-attachments/assets/41d6fe90-f78f-46d8-9cbf-efc073c96027)

- AI 동영상 분석 기술을 활용하여 **교통사고 영상으로 과실비율을 예측**하는 웹 기반 서비스  
- 교통사고 영상 속 객체 인식(DetectoRS)과 사고 상황 분석(VTN)을 통해 과실 비율을 측정하고 그 결과를 시각적으로 사용자에게 제공
- 누구나 간편하게 교통사고 과실비율을 측정할 수 있으며, 측정 시간과 비용을 절감할 수 있음
---

## 기술 스택

| 구분 | 기술 |
|------|------|
| **Frontend** | React, HTML/CSS/JS, Next.js |
| **Backend** | Spring Boot, JPA, Spring Security |
| **AI Server** | Flask (Python) |
| **AI Framework** | PyTorch, CUDA, DetectoRS, VTN |
| **Database** | MariaDB |
| **협업/개발 도구** | Git, GitHub, Visual Studio Code, IntelliJ, PyCharm |

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

처음에는 AI 기반 서비스라는 점에서 부담이 있었지만,  
객체 인식부터 사고 유형 분류, 과실 비율 예측까지 **AI 모델을 실제 웹 서비스에 통합**하며  
AI와 백엔드 간 연결 구조에 대한 이해가 깊어졌습니다.

또한 복잡한 데이터를 시각적으로 보여주는 과정에서 **프론트-백엔드-데이터베이스-모델 간 전체 흐름**을 경험할 수 있었고,  
이 경험은 실무에서도 큰 자산이 될 거라고 생각합니다.


## 시연 동영상


## 👥 팀원

| 역할 | 이름 | GitHub |
|------|------|--------|
| 프론트엔드 & 디자인(팀장) | 전민혁 | - |
| 백엔드 & AI 연동 👋 | 가한솔 | https://github.com/kaa08 |
| 백엔드 & AI 연동 | 이연송 | https://github.com/cloud-yeonsong |
| AI 모델 | 이예지 | - |
