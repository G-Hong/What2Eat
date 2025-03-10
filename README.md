# What2Eat

## 목표와 범위

- 다이어트 시작일, 시작체중/체지방/근육량을 기반으로 현재 다이어트 단계 계산 및 띄우기
- 현재 다이어트 단계를 기반으로 허용식품에 대한 질문 처리

| 주차 | 백엔드                                              | 프론트엔드                                           | 딥러닝                                           | 데이터 분석                                          |
|------|-----------------------------------------------------|----------------------------------------------------|------------------------------------------------|----------------------------------------------------|
| 1주차 | 서버 환경 설정 및 데이터베이스 설계<br>API 구조 설계 | 디자인 와이어프레임 제작<br>UI/UX 요구사항 정리    | 딥러닝 모델 대신 단순 규칙 기반 비교 로직 설계 | 허용식품 데이터 수집<br>다이어트 규칙 및 성분 데이터 분석 |
| 2주차 | 사용자 관리 기능(API) 개발<br>데이터베이스 초기화  | 입력 폼 UI 설계 및 구현<br>React 구조 설계          | 허용 기준을 비교하는 로직 설계 및 테스트       | 데이터 정제 및 전처리<br>다이어트 허용/비허용 규칙 정리 |
| 3주차 | 허용식품 및 알림 관련 API 개발<br>질의처리 로직 개발 | 기본 화면 구현<br>입력폼과 결과 표시 연동          | 규칙 기반 데이터 검증 및 처리 로직 개발       | 허용식품 데이터베이스 구축<br>성분별 다이어트 허용 기준 설정 |
| 4주차 | 알림 기능 및 다이어트 진행 상태 API 구현           | 다이어트 계획 화면 구현<br>API와 통신 연결         | 입력 데이터를 백엔드 규칙 비교로 연동          | 성분 데이터 시각화<br>사용자 맞춤형 데이터 분석    |
| 5주차 | 텍스트 데이터 처리 및 결과 API 개발               | 입력 데이터를 결과 화면에 표시<br>결과 UI 최적화   | 데이터 기반 알림 로직 테스트 및 강화          | 분석된 데이터 검증<br>사용자 피드백 반영 데이터 개선 |
| 6주차 | 백엔드와 프론트엔드 통합 테스트<br>API 최적화      | 모든 화면 완성 및 디자인 최적화<br>반응형 디자인 적용 | 규칙 비교 성능 및 처리 속도 최적화            | 데이터 정확성 점검 및 통합<br>사용자 맞춤형 분석 최적화 |
| 7주차 | 배포 환경 구축<br>AWS 및 CI/CD 파이프라인 설정     | 최종 UI 검토 및 사용자 피드백 반영                 | 최종 데이터 처리 로직 테스트 및 통합          | 최종 데이터 검토<br>보고서 및 다이어트 추천 시스템 정리 |



## 1주차


### 해야할 일

- AI
    
    딥러닝/데이터분석 : 데이터 수집 https://docs.google.com/document/d/1Mgke7QSE4OWnuTru9ldE5ECagasxCmaACewcsf2aoLE/edit?usp=sharing
    
    딥러닝: api 정해서 테스트해보기
    
    https://huggingface.co/meta-llama/Meta-Llama-3-8B
    
    데이터분석 : 단계 별 허용 음식 정리 및 기준 확립 > 영양성분표 DB 수집 > (대략) 분류 기준 구체화
    
- 프론트
    1. 체중 받아서 그래프 띄우는거 리액트로 어떻게 하는지 알아보기
    2. 정해진 색상표 바탕으로 피그마 디자인 만들기
    3. 백엔드랑 프론트 연결하는거 정확히 이해하기(API명세서..)
- 백엔드
    
    DB설계-연결
    
    컨트롤러 설계
    
    1. 로그인+유지
    2. 날짜계산 (디데이, 몇단계 며칠)
    3. 체중입력+저장+수정
    4. 질문텍스트 입력 넘겨주기
 

  ## 2주차

  ### 해야할 일
  - 딥러닝-데이터분석
    
    ![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/0107d0ca-3946-4841-999d-ce0cc4dde0b1/b39dd328-460f-459f-8573-f0a94e1ba316/image.png)
    
    응답형성이 안되는 문제 해결
    
    간단한 챗봇형식 구현 → backend/frotend에 전달하고 소통
    
    # 데이터 준비 부분
    
    diet_info = """
    다이어트 관련 기본 정보:
    
    1. 식사 원칙:
    - 단백질 위주의 식단 구성
    - 탄수화물 조절
    - 충분한 수분 섭취
    1. 권장 식품:
    - 닭가슴살, 생선, 계란
    - 채소류
    - 견과류 (소량)
    1. 식사 시간과 방법:
    - 하루 3끼 규칙적인 식사
    - 과식 피하기
    - 천천히 씹어서 먹기
    1. 주의사항:
    - 야식 피하기
    - 폭식 주의
    - 과도한 제한 금지
    """
    
    # data 폴더에 저장
    
    with open("data/diet_info.txt", "w", encoding="utf-8") as f:
    f.write(diet_info)
    
- 프론트엔드
    1. 회의 내용 바탕으로 피그마 수정 → 디자인 완성
    2. 개발 시작 - React 레이아웃 코드 작성 
- 백엔드
    - [박용우 봇 백엔드 개발](https://www.notion.so/146410bc163480a28a5fc72b0e67a5c4?pvs=21)
    - API 명세서 및 설계 확정
    - 아래 사진에서 3,4번 필수, 5번은 할 수 있는 만큼
    
    ![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/0107d0ca-3946-4841-999d-ce0cc4dde0b1/6c63102f-229c-4e6c-9e63-64f4c2cdbc9b/image.png)





  네, 단계별로 자세히 설명해드리겠습니다.

1. 딥러닝 팀이 가장 먼저 할 일:
   - 구글 코랩에서 OpenAI API 테스트하기
   ```python
   # 코랩에서 openai 설치
   !pip install openai
   
   # API 테스트 코드
   import openai
   
   # API 키 설정
   openai.api_key = 'your-api-key'  # OpenAI에서 발급받은 키
   
   # 테스트 함수
   def test_gpt_api(user_input):
       response = openai.ChatCompletion.create(
           model="gpt-3.5-turbo",
           messages=[
               {"role": "system", "content": "당신은 다이어트 전문가입니다."},
               {"role": "user", "content": user_input}
           ]
       )
       return response.choices[0].message.content

   # 테스트
   result = test_gpt_api("다이어트할 때 어떤 음식을 먹어야 하나요?")
   print(result)
   ```

2. 백엔드 팀이 할 일:
   - Python과 Flask 설치
   ```bash
   pip install python flask flask-cors openai
   ```
   - 제가 위에서 제공한 백엔드 코드를 `app.py` 파일로 저장
   - 터미널/명령 프롬프트에서 실행:
   ```bash
   python app.py
   ```
   - 서버가 `http://localhost:5000`에서 실행됨

3. 프론트엔드 팀이 할 일:
   - Node.js 설치 (https://nodejs.org)
   - React 프로젝트 생성:
   ```bash
   npx create-react-app chatbot-frontend
   cd chatbot-frontend
   ```
   - 필요한 패키지 설치:
   ```bash
   npm install tailwindcss
   ```
   - 제가 위에서 제공한 React 코드를 `src/App.js`에 붙여넣기
   - 프론트엔드 서버 실행:
   ```bash
   npm start
   ```
   - 브라우저에서 `http://localhost:3000` 열기

팀별 작업 환경 설정:

1. 딥러닝 팀:
   - 구글 코랩 사용 (브라우저만 있으면 됨)
   - OpenAI API 키 발급 필요

2. 백엔드 팀:
   - Python 설치 (https://www.python.org)
   - 코드 에디터 설치 (VS Code 추천)
   - OpenAI API 키 공유 받기

3. 프론트엔드 팀:
   - Node.js 설치
   - 코드 에디터 설치 (VS Code 추천)
   - Chrome 개발자 도구 사용법 학습

공통 필요 사항:
1. Github 계정 생성
2. Git 설치
3. 팀 커뮤니케이션 툴 (예: Slack, Discord)

처음에는 각 팀이 로컬에서 개발하고 테스트하는 것을 추천합니다. 코드가 어느 정도 완성되면 Github에 올리고 다른 팀과 통합하면 됩니다.

질문이나 어려운 부분이 있다면 말씀해주세요! 각 단계별로 더 자세한 설명이 필요하시다면 알려주세요.
