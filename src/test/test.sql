CREATE TABLE RIIK (
       riik_ID              INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       ISO_kood             VARCHAR(20) NOT NULL,
       kommentaar           LONG VARCHAR,
       ANSI_kood            CHAR(18),
       PRIMARY KEY (riik_ID)
);

CREATE UNIQUE INDEX XPKRIIK ON RIIK
(
       riik_ID
);

INSERT INTO RIIK (riik_ID, ISO_kood, ANSI_kood, avaja, avatud, muutja, muudetud, sulgeja, suletud, kommentaar) VALUES(null, 'EE', 'EST', 'Test', '2011-12-01 00:00:00', 'Test', '2011-12-01 00:00:00', '', '2030-12-01 00:00:00', '');
INSERT INTO RIIK (riik_ID, ISO_kood, ANSI_kood, avaja, avatud, muutja, muudetud, sulgeja, suletud, kommentaar) VALUES(null, 'EN', 'ENG', 'Test', '2011-12-01 00:00:00', 'Test', '2011-12-01 00:00:00', '', '2030-12-01 00:00:00', '');
INSERT INTO RIIK (riik_ID, ISO_kood, ANSI_kood, avaja, avatud, muutja, muudetud, sulgeja, suletud, kommentaar) VALUES(null, 'DE', 'DEU', 'Test', '2011-12-01 00:00:00', 'Test', '2011-12-01 00:00:00', '', '2030-12-01 00:00:00', '');
INSERT INTO RIIK (riik_ID, ISO_kood, ANSI_kood, avaja, avatud, muutja, muudetud, sulgeja, suletud, kommentaar) VALUES(null, 'US', 'USA', 'Test', '2011-12-01 00:00:00', 'Test', '2011-12-01 00:00:00', '', '2030-12-01 00:00:00', '');