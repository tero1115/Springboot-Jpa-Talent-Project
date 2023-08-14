INSERT INTO `user` (id, username, password,tel)
VALUES(1, 'test', '123','01011112222'),
    (2, 'sample', '123','01022223333'),
    (3, 'temp', '123','01022223333');

INSERT INTO post (id, title, category, content, thumbnail,user_id)
VALUES(1, '프로그램 개발 도와드립니다', '프로그램개발', '안녕하세요', '/images/no_img.png', 1),
    (2, '아무 디자인 그려드려요', '디자인', '반갑습니다', '/images/no_img.png', 1),
    (3, '영어 번역 해드립니다', '번역/외국어', '안녕하세요 번역합니다', '/images/no_img.png', 2);