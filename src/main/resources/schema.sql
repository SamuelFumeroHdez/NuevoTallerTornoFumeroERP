DROP TABLE IF EXISTS USUARIO;

CREATE TABLE USUARIO(
    ID INTEGER NOT NULL AUTO_INCREMENT,
    NOMBRE VARCHAR(55) NOT NULL,
    PASSWORD VARCHAR(55) NOT NULL,
    HABILITADO INTEGER NOT NULL,
    PRIMARY KEY(ID)
);

--CREATE TABLE DEPARTMENT(
--    ID BIGINT NOT NULL AUTO_INCREMENT,
--    DESCRIPTION VARCHAR(55) NOT NULL,
--    FK_LOCATION BIGINT NOT NULL,
--    PRIMARY KEY(ID),
--    FOREIGN KEY(FK_LOCATION) REFERENCES LOCATION(ID)
--);