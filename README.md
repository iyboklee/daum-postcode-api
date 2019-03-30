###  빌드 및 실행
* maven으로 빌드 후 실행하기
  * mvn clean package spring-boot:run
* java 명령으로 실행하기
  * mvn clean package
  * java -jar ./target/daum-postcode-api-1.0.0.jar

### 주소검색
http://localhost:8080/api/search?query={query}&page=1

* query: 도로명 또는 지번 주소
* page: 페이지 번호 **(기본값 1)**

예시
* http://localhost:8080/api/search?query=테헤란로33길 5
* http://localhost:8080/api/search?query=역삼동 678-29
* http://localhost:8080/api/search?query=역삼동&page=2


### 출력결과

```json
{
    "success": true,
    "response": {
        "totalCount": 1,
        "page": 1,
        "size": 1,
        "list": [
            {
                "zonecode": "06141",
                "postcode": "135-915",
                "sido": "서울특별시",
                "sigungu": "강남구",
                "sigunguCode": "11680",
                "bcode": "1168010100",
                "bname": "역삼동",
                "bname2": "역삼동",
                "buildingCode": "1168010100106780029023268",
                "buildingName": "비엘타워",
                "roadAddress": "서울특별시 강남구 테헤란로33길 5",
                "roadname": "테헤란로33길",
                "roadnameCode": "4166734",
                "jibunAddresses": [
                    "서울특별시 강남구 역삼동 678-29"
                ]
            }
        ]
    }
}
```

각 항목에 대한 자세한 내용은 [다음 주소 검색 API](http://postcode.map.daum.net/guide) 참고
