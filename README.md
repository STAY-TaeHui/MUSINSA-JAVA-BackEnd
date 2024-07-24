# MUSINSA-JAVA-BackEnd
본 프로젝트는 무신사 JAVA 백엔드 개발자 채용을 위한 과제 프로젝트입니다.
# 구현 범위
## 요구사항 분석
**1.  카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API**
- 요청값 : 없음
- 응답값 : `JSON` 
- 구현 방법
  - 카테고리 별로 최저 가격의 상품을 조회.
  - 해당 상품의 브랜드를 가져온다.
  - API EndPoint: `GET /api/reports/categories/lowest-price`
  - Service : `LowestPriceService`
 
**2.  단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을
조회하는 API**
- 요청값 : 없음
- 응답값 : `JSON`
- 구현 방법
  - 브랜드 별 모든 상품의 총액을 계산.
  - 이후 총액이 가장 작은 브랜드를 찾아서 해당 브랜드의 상품과 카테고리를 조회.
  - API EndPoint : `GET /api/reports/brands/lowest-price`

**3. 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API**
- 요청값 : 카테고리명(String)
- 응답값 : `JSON`
- 구현 방법
  - 카테고리 별로 최저, 최고 가격의 상품을 조회.
  - 이후 해당 카테고리의 브랜드와 상품의 가격을 조회.
  - API EndPoint : `GET /api/reports/categories/{categoryName}/price-range`

**4. 브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API**
- 요청값 : Request Body (JSON)
- 응답값 : `JSON`
  - 성공
  - 실패
- 구현 방법
  - 브랜드의 CUD API 구현:
    - `POST /api/brands`
    - `PUT /api/brands/{brandId}`
    - `DELETE /api/brands/{brandId}`
  - 상품의 CUD API 구현 : 
    - `POST /api/products`
    - `PUT /api/products/{productId}`
    - `DELETE /api/products/{productId}`
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
    - 상품 이름
    - 가격

# 빌드

# 테스트

# 실행

# 기타