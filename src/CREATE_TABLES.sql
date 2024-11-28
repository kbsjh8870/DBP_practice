-- 카테고리 릴레이션
CREATE TABLE 카테고리 (
    카테고리명 VARCHAR2(100) PRIMARY KEY
);

-- 학과 릴레이션
CREATE TABLE 학과 (
    학과명 VARCHAR2(100) UNIQUE,
    학과번호 NUMBER PRIMARY KEY
);

-- 학생 릴레이션
CREATE TABLE 학생 (
    학번 NUMBER PRIMARY KEY,
    학과번호 NUMBER,
    비밀번호 VARCHAR2(100) NOT NULL,
    이름 VARCHAR2(100) NOT NULL,
    게시글등록수 NUMBER DEFAULT 0,
    가입일자 DATE DEFAULT SYSDATE,
    CONSTRAINT fk_학생_학과 FOREIGN KEY (학과번호) REFERENCES 학과(학과번호)
);

-- 물품 게시글 릴레이션
CREATE TABLE 물품_게시글 (
    게시글번호 NUMBER PRIMARY KEY,
    학번 NUMBER,
    학과명 VARCHAR2(100),
    카테고리명 VARCHAR2(100),
    거래자 NUMBER,
    거래금액 NUMBER,
    물품명 VARCHAR2(200),
    물품설명 VARCHAR2(1000),
    거래여부 VARCHAR2(10) ,
    등록날짜 DATE DEFAULT SYSDATE,
    CONSTRAINT fk_물품_게시글_학생 FOREIGN KEY (학번) REFERENCES 학생(학번),
    CONSTRAINT fk_물품_게시글_학과 FOREIGN KEY (학과명) REFERENCES 학과(학과명),
    CONSTRAINT fk_물품_게시글_카테고리 FOREIGN KEY (카테고리명) REFERENCES 카테고리(카테고리명),
    CONSTRAINT fk_물품_게시글_거래자 FOREIGN KEY (거래자) REFERENCES 학생(학번)
    
);

-- 즐겨찾기 [관계] 릴레이션
CREATE TABLE 즐겨찾기 (
    학번 NUMBER,
    게시글번호 NUMBER,
    PRIMARY KEY (학번, 게시글번호),
    CONSTRAINT fk_즐겨찾기_학생 FOREIGN KEY (학번) REFERENCES 학생(학번),
    CONSTRAINT fk_즐겨찾기_물품 FOREIGN KEY (게시글번호) REFERENCES 물품_게시글(게시글번호)
);

-- 쪽지 [관계] 릴레이션
CREATE TABLE 쪽지 (
    쪽지번호 NUMBER PRIMARY KEY,
    학번 NUMBER,
    게시글번호 NUMBER,
    물품게시글 VARCHAR2(200),
    제목 VARCHAR2(200),
    내용 VARCHAR2(1000),
    쪽지일자 DATE DEFAULT SYSDATE,
    CONSTRAINT fk_쪽지_학생 FOREIGN KEY (학번) REFERENCES 학생(학번),
    CONSTRAINT fk_쪽지_물품 FOREIGN KEY (게시글번호) REFERENCES 물품_게시글(게시글번호)
);

