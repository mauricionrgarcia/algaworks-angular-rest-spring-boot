CREATE TABLE TB_PERSON (
	PK_PERSON           BIGINT(20)    PRIMARY KEY AUTO_INCREMENT,
    TX_NAME             VARCHAR (255) NOT NULL,
    ID_ACTIVE           BOOLEAN       NOT NULL,
    TX_ADDRESS_STREET   VARCHAR (255) NOT NULL,
    TX_ADDRESS_NUMBER   VARCHAR (55) ,
    TX_ADDRESS_DISTRICT VARCHAR (255),
    TX_ADDRESS_ZIP_CODE VARCHAR (55) ,
    TX_ADDRESS_CITY     VARCHAR (255),
    TX_ADDRESS_STATE    VARCHAR (255)      
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Bruna', 
							    true,
                                'Rua Fernando de Noronha', 
                                '387',
                                'Brasil Novo',
                                '85145-987',
                                'Macapá',
                                'Amapá'
                              );

INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Francisco', 
							    false,
                                'Largo 8', 
                                '874',
                                'Jardim das Oliveiras',
                                '60820-780',
                                'Fortaleza',
                                'Ceará'
                              );


INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Daniela', 
							    true,
                                'Rua Coronel César', 
                                '874',
                                'Morada do Sol',
                                '64056-475',
                                'Teresinha',
                                'Piauí'
                              );


INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Mariana', 
							    true,
                                'Rua Getúlio Vargas', 
                                '141',
                                'Vila Isabel',
                                '65082-079',
                                'São Luís',
                                'Maranhão'
                              );                              
                              
                              


INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Maria', 
							    true,
                                'Rua Pedro das Neves', 
                                '966',
                                'Santa Tereza',
                                '29026-758',
                                'Vitória',
                                'Espirito Santo'
                              );                                                            
                              


INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Ana', 
							    true,
                                'Rua Seis', 
                                '854',
                                'Justinópolis',
                                '33903-425',
                                'Riberão das Neves',
                                'Minas Gerais'
                              );                                                            
                              


INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Carlos', 
							    true,
                                'Quadra 19 MR 4', 
                                '429',
                                'Setor Norte',
                                '73751-533',
                                'Plaaltina',
                                'Goiás '
                              );                                                            
                              


INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Rafael', 
							    true,
                                'Rua Francesco de Martini', 
                                '715',
                                'Osvaldo Cruz',
                                '09571-210',
                                'São Caetano do Sul',
                                'São Paulo'
                              );                                                            
                              


INSERT INTO TB_PERSON (
    TX_NAME,
    ID_ACTIVE,
    TX_ADDRESS_STREET,
    TX_ADDRESS_NUMBER,
    TX_ADDRESS_DISTRICT,
    TX_ADDRESS_ZIP_CODE,
    TX_ADDRESS_CITY,
    TX_ADDRESS_STATE) VALUES (  'Fernanda', 
							    true,
                                'Rua Sebastião Luiz Primo', 
                                '640',
                                'Parque Santa Hilda',
                                '14403-708',
                                'Franca',
                                'São Paulo'
                              );                                                            
                              