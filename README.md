# MUSINSA-JAVA-BackEnd
본 프로젝트는 무신사 JAVA 백엔드 개발자 채용을 위한 과제 프로젝트입니다.
프론트도 같이 구현했습니다. 부족하지만 잘 부탁드립니다!!
# 구현 범위
- 요구사항에 따른 API 개발
- Brand/Product 추가, 삭제 및 수정 API 개발
- JPA를 이용하여 데이터베이스 연동 및 연관관계 설정
- 테스트 코드 작성
# 요구사항 분석
**1.  카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API**
- 요청값 : 없음
- 응답값 : `JSON` 
- 구현 방법
  - 모든 카테고리를 조회 후 각 카테고리를 순회.
  - 각 카테고리 별로 최저가격을 가진 상품을 조회.
  - API EndPoint: `GET /api/reports/categories/lowest-price`
 
**2.  단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을
조회하는 API**
- 요청값 : 없음
- 응답값 : `JSON`
- 구현 방법
  - 브랜드의 상품 가격 총 합산 금액 중 가장 저렴한 브랜드를 조회. 
  - 해당 브랜드의 상품 정보를 조회.
  - API EndPoint : `GET /api/reports/brands/lowest-price`

**3. 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API**
- 요청값 : `categoryName` (String)
- 응답값 : `JSON`
- 구현 방법
  - 카테고리 이름으로 최저 가격의 상품과 최고 가격의 상품을 조회
  - 서브쿼리를 이용하여 조건을 주었음.
  - API EndPoint : `GET /api/reports/categories/lowest-and-highest-price`

**4. 브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API**
- 요청값 : Request Body (JSON)
- 응답값 : `JSON`
- 구현 방법
  - 브랜드의 CUD API 구현:
    - `POST /api/brands` 
    - `PUT /api/brands/{id}`
    - `DELETE /api/brands/{id}`
  - 상품의 CUD API 구현 : 
    - `POST /api/products`
    - `PUT /api/products/{id}`
    - `DELETE /api/products/{id}`
  - 

## 도메인 설계
1. 브랜드
    - id
    - 브랜드 이름
2. 카테고리
    - id
    - 카테고리 이름
3. 상품
    - id
    - 브랜드 ID
    - 카테고리 ID
    - 가격

## Backend
1. clean 및 build

    터미널에서 프로젝트 루트 디렉토리로 이동
    ```shell
    ./gradlew clean build
    ```
2. 결과 확인

    build/libs 디렉토리에서 .jar파일 확인
3. 서버에서 실행

    ```shell
    java -jar build/libs/musinsa-java-0.0.1-SNAPSHOT.jar
    ```
## Front
1. front 폴더로 이동
2. node 설치되어있는지 확인. `node -v`  18버전 사용 
3. node 설치 되어있다면 `npm install`로 관련 패키지 설치
4. `npm start`로 front 실행


# 테스트

# 기타
- JAVA : 17 
- SpringBoot Framwork : 3.3.2 
- Node.js : 18.20.4
