INSERT INTO `user` (id, username, password,tel)
VALUES(1, 'test', '123','01011112222'),
    (2, 'sample', '123','01022223333'),
    (3, 'temp', '123','01022223333');

INSERT INTO post (id, title, category, content, thumbnail,user_id)
VALUES(1, '첫번째', '프로그램개발', '안녕하세요', '', 1),
    (2, '두번째', '디자인', '반갑습니다', '', 1),
    (3, '세번째', '번역/외국어', '뉴비입니다', '', 2);