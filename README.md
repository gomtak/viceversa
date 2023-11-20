# 요구사항
과제는 recruit@viceversa.ai 로 첨부파일 포함하여 11/21(화) 오전 10시까지 보내주시기 바랍니다
(클라우드-드라이브, github/gist 등 다운로드 링크도 가능)

* API 서버 데모
- 사용언어 : java
- 타겟환경 : spring-boot, jpa, mysql
- 평가요소 : 기술 이해도 및 실무능력 평가
- 설명
  : 공공데이터 포탈 등의 공개된 json 데이터를 50개 이상 수집하여 로컬 db 에 저장
  > 참고: https://www.data.go.kr/data/15101914/openapi.do (회원가입 후, 활용신청 -> 인증키)
  : 해당 데이터(모델)에 대한 REST API 를 제공하는 서버 구축
  : 전반적인 REST API 동작을 체크할 수 있는 테스트 소스 구현
  : (선택) jpa specification 기반의 확장 용이한 검색 등 임의의 추가 기능

# 시작하기
 * docker-compose up 후 프로젝트 실행
 * ex)
   * http://localhost:8080/api/tourist/search?keyword=고모산성&page=0&size=10
   * http://localhost:8080/api/tourist/search?keyword=인천광역시&page=0&size=10
   * http://localhost:8080/api/tourist/search?keyword=서울
