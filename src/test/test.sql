DROP TABLE SEADUSE_PUNKT IF EXISTS CASCADE;
DROP TABLE SEADUS IF EXISTS CASCADE;
DROP TABLE KODAKONDSUS IF EXISTS CASCADE;
DROP TABLE RIIK IF EXISTS CASCADE;
DROP TABLE PIIRIRIKKUJA IF EXISTS CASCADE;

CREATE TABLE KODAKONDSUS (
	KODAKONDSUS_ID BIGINT NOT NULL,
	ALATES TIMESTAMP,
	AVAJA VARCHAR(32) NOT NULL,
	AVATUD TIMESTAMP NOT NULL,
	ISIKUKOOD VARCHAR(20),
	KOMMENTAAR VARCHAR(255),
	KUNI TIMESTAMP,
	MUUDETUD TIMESTAMP NOT NULL,
	MUUTJA VARCHAR(32) NOT NULL,
	SULETUD TIMESTAMP NOT NULL,
	SULGEJA VARCHAR(32),
	VERSION INTEGER,
	PIIRIRIKKUJA_ID BIGINT,
	RIIK_ID BIGINT,
	PRIMARY KEY (KODAKONDSUS_ID)
);
CREATE TABLE PIIRIRIKKUJA (
	PIIRIRIKKUJA_ID BIGINT NOT NULL,
	AVAJA VARCHAR(32) NOT NULL,
	AVATUD TIMESTAMP NOT NULL,
	EESNIMI VARCHAR(25),
	ISIKUKOOD VARCHAR(20),
	KOMMENTAAR VARCHAR(255),
	MUUDETUD TIMESTAMP NOT NULL,
	MUUTJA VARCHAR(32) NOT NULL,
	OBJEKT_ID INTEGER,
	PEREK_NIMI VARCHAR(35),
	SUGU VARCHAR(1),
	SULETUD TIMESTAMP NOT NULL,
	SULGEJA VARCHAR(32),
	SYNNIAEG TIMESTAMP,
	VERSION INTEGER,
	PRIMARY KEY (PIIRIRIKKUJA_ID)
);
CREATE TABLE RIIK (
	RIIK_ID BIGINT NOT NULL,
	ANSI_KOOD VARCHAR(20) NOT NULL,
	ISO_KOOD VARCHAR(20) NOT NULL,
	AVAJA VARCHAR(32) NOT NULL,
	AVATUD TIMESTAMP NOT NULL,
	KOMMENTAAR VARCHAR(255) NOT NULL,
	MUUDETUD TIMESTAMP NOT NULL,
	MUUTJA VARCHAR(32) NOT NULL,
	SULETUD TIMESTAMP NOT NULL,
	SULGEJA VARCHAR(32) NOT NULL,
	VERSION INTEGER,
	PRIMARY KEY (RIIK_ID)
);
CREATE TABLE SEADUS (
	SEADUSE_ID BIGINT NOT NULL,
	AVAJA VARCHAR(32) NOT NULL,
	AVATUD TIMESTAMP NOT NULL,
	KEHTIV_ALATES VARCHAR(20) NOT NULL,
	KEHTIV_KUNI VARCHAR(20) NOT NULL,
	KOMMENTAAR VARCHAR(20) NOT NULL,
	KOOD VARCHAR(20) NOT NULL,
	MUUDETUD TIMESTAMP NOT NULL,
	MUUTJA VARCHAR(32) NOT NULL,
	NIMETUS VARCHAR(20) NOT NULL,
	SULETUD TIMESTAMP NOT NULL,
	SULGEJA VARCHAR(32) NOT NULL,
	VERSION INTEGER,
	PRIMARY KEY (SEADUSE_ID)
);
CREATE TABLE SEADUSE_PUNKT (
	ID BIGINT NOT NULL,
	AVAJA VARCHAR(32) NOT NULL,
	AVATUD TIMESTAMP NOT NULL,
	KEHTIV_ALATES VARCHAR(20) NOT NULL,
	KEHTIV_KUNI VARCHAR(20) NOT NULL,
	KOMMENTAAR VARCHAR(20) NOT NULL,
	MUUDETUD TIMESTAMP NOT NULL,
	MUUTJA VARCHAR(32) NOT NULL,
	PAIS VARCHAR(20) NOT NULL,
	PARAGRAHV VARCHAR(20) NOT NULL,
	SEADUSE_PUNKT_ID INTEGER NOT NULL,
	SULETUD TIMESTAMP NOT NULL,
	SULGEJA VARCHAR(32) NOT NULL,
	TEKST VARCHAR(20) NOT NULL,
	VERSION INTEGER,
	SEADUSE_ID BIGINT,
	YLEMUS_SEADUSE_PUNKT_ID BIGINT,
	PRIMARY KEY (ID)
);

INSERT INTO RIIK (RIIK_ID, ANSI_KOOD, ISO_KOOD, AVAJA, AVATUD, KOMMENTAAR, MUUDETUD, MUUTJA, SULETUD, SULGEJA, VERSION) VALUES (1, 'EE', 'EST', 'Test', '2011-10-20 00:00:00', 'Pole', '2011-10-20 00:00:00', 'Test', '2030-10-20 00:00:00', '', '');
INSERT INTO RIIK (RIIK_ID, ANSI_KOOD, ISO_KOOD, AVAJA, AVATUD, KOMMENTAAR, MUUDETUD, MUUTJA, SULETUD, SULGEJA, VERSION) VALUES (1, 'EN', 'ENG', 'Test', '2011-10-20 00:00:00', 'Pole', '2011-10-20 00:00:00', 'Test', '2030-10-20 00:00:00', '', '');
INSERT INTO RIIK (RIIK_ID, ANSI_KOOD, ISO_KOOD, AVAJA, AVATUD, KOMMENTAAR, MUUDETUD, MUUTJA, SULETUD, SULGEJA, VERSION) VALUES (1, 'DE', 'DEU', 'Test', '2011-10-20 00:00:00', 'Pole', '2011-10-20 00:00:00', 'Test', '2030-10-20 00:00:00', '', '');
INSERT INTO RIIK (RIIK_ID, ANSI_KOOD, ISO_KOOD, AVAJA, AVATUD, KOMMENTAAR, MUUDETUD, MUUTJA, SULETUD, SULGEJA, VERSION) VALUES (1, 'FI', 'FIN', 'Test', '2011-10-20 00:00:00', 'Pole', '2011-10-20 00:00:00', 'Test', '2030-10-20 00:00:00', '', '');

ALTER TABLE KODAKONDSUS
	ADD FOREIGN KEY (PIIRIRIKKUJA_ID) 
	REFERENCES PIIRIRIKKUJA (PIIRIRIKKUJA_ID);

ALTER TABLE KODAKONDSUS
	ADD FOREIGN KEY (RIIK_ID) 
	REFERENCES RIIK (RIIK_ID);


ALTER TABLE SEADUSE_PUNKT
	ADD FOREIGN KEY (SEADUSE_ID) 
	REFERENCES SEADUS (SEADUSE_ID);

ALTER TABLE SEADUSE_PUNKT
	ADD FOREIGN KEY (YLEMUS_SEADUSE_PUNKT_ID) 
	REFERENCES SEADUSE_PUNKT (ID);


