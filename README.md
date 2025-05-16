# ☎️ Java 전화번호부 관리 프로그램 (MySQL 연동)

이 레포지토리는 Java와 MySQL을 연동하여 전화번호부 정보를 **추가, 삭제, 출력, 검색**할 수 있는 간단한 콘솔 기반 프로그램입니다.

---

## 📦 기술 스택

- Java 17+
- MySQL 8.0+
- JDBC (MySQL Connector/J)
- Maven

---

## 🛠️ 실행 전 필수 설정

### 1. MySQL 데이터베이스 설정

```sql
CREATE DATABASE dbex;
USE dbex;

CREATE TABLE teltbl (
    name VARCHAR(20),
    telnumber VARCHAR(20),
    address VARCHAR(50)
);
```

### 2. `pom.xml` 의존성 추가

Maven 프로젝트라면 다음을 `pom.xml`에 추가합니다:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

### 3. Maven 프로젝트 리로드 (중요)

`pom.xml` 변경 후 IntelliJ에서 **Maven Reimport**를 반드시 수행하세요.

- `View > Tool Windows > Maven` → 상단의 🔄 `Reload All Maven Projects` 클릭
- 또는 `pom.xml` 우클릭 → `Maven` → `Reload Project`

---

## ⚠️ 발생할 수 있는 오류 및 해결

### ❌ 오류

```
java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/dbex
```

### ✅ 해결 방법

1. `mysql-connector-java`가 정상적으로 설치되었는지 확인
2. Maven 프로젝트를 Reload
3. 필요시 수동 드라이버 로딩:

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

---

## ▶️ 실행 방법

1. MySQL 서버 실행
2. IntelliJ 또는 콘솔에서 `TELDB.java` 실행
3. 메뉴에서 원하는 기능(추가/삭제/전체출력/검색)을 선택

---

## 📁 주요 파일 설명

| 파일명 | 설명 |
|--------|------|
| `TELDB.java` | 메인 실행 클래스, 사용자 입력 처리 |
| `SQLConnection.java` | DB 연결 객체 제공 |
| `pom.xml` | Maven 의존성 관리 파일 |

---

## 🙋‍♂️ 문의

궁금한 점이나 오류 발생 시 Issues 탭에 남겨주세요.
