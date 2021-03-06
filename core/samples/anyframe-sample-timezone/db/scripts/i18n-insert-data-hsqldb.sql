CREATE MEMORY TABLE MESSAGE_SOURCE(ID VARCHAR(50) NOT NULL, LANGUAGE VARCHAR(2), COUNTRY VARCHAR(3), TEXT VARCHAR(200) NOT NULL);

INSERT INTO MESSAGE_SOURCE VALUES('i18n.error','en', 'US', 'Invaild id or password.');
INSERT INTO MESSAGE_SOURCE VALUES('i18n.id','en', 'US', 'ID');
INSERT INTO MESSAGE_SOURCE VALUES('i18n.password','en', 'US', 'Password');
INSERT INTO MESSAGE_SOURCE VALUES('i18n.logout','en', 'US', 'Logout');
INSERT INTO MESSAGE_SOURCE VALUES('i18n.login','en', 'US', 'Login');

INSERT INTO MESSAGE_SOURCE VALUES('i18n.error','ko', 'KR', '아이디 혹은 비밀번호가 맞지 않습니다.');
INSERT INTO MESSAGE_SOURCE VALUES('i18n.id','ko', 'KR', '아이디');
INSERT INTO MESSAGE_SOURCE VALUES('i18n.password','ko', 'KR', '비밀번호');
INSERT INTO MESSAGE_SOURCE VALUES('i18n.logout','ko', 'KR', '로그아웃');
INSERT INTO MESSAGE_SOURCE VALUES('i18n.login','ko', 'KR', '로그인');

commit;