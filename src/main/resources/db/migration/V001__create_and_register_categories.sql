CREATE TABLE TB_CATEGORY (
	PK_CATEGORY BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    TX_NAME VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO TB_CATEGORY (TX_NAME) VALUES ('Lazer');
INSERT INTO TB_CATEGORY (TX_NAME) VALUES ('Alimentação');
INSERT INTO TB_CATEGORY (TX_NAME) VALUES ('Supermercado');
INSERT INTO TB_CATEGORY (TX_NAME) VALUES ('Farmácia');
INSERT INTO TB_CATEGORY (TX_NAME) VALUES ('Outros');
