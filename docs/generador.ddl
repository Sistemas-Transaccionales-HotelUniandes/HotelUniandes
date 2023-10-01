-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-01 00:53:56 COT
--   sitio:      Oracle Database 21c
--   tipo:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE cliente (
    cliente_id NUMBER NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( cliente_id );

CREATE TABLE cuenta (
    habitacion_id          NUMBER NOT NULL,
    reserva_id             NUMBER NOT NULL,
    reserva_planconsumo_id NUMBER NOT NULL,
    total                  NUMBER,
    descripcion            VARCHAR2(255 BYTE)
);

CREATE UNIQUE INDEX cuenta__idx ON
    cuenta (
        reserva_id
    ASC,
        reserva_planconsumo_id
    ASC );

ALTER TABLE cuenta ADD CONSTRAINT cuenta_pk PRIMARY KEY ( habitacion_id );

CREATE TABLE gimnasio (
    capacidad   INTEGER,
    nummaquinas INTEGER,
    horainicio  VARCHAR2(255 BYTE),
    horafin     VARCHAR2(255 BYTE),
    gimnasio_id NUMBER NOT NULL
);

ALTER TABLE gimnasio ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( gimnasio_id );

CREATE TABLE habitacion (
    id                NUMBER NOT NULL,
    tipohabitacion_id NUMBER NOT NULL
);

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( id );

CREATE TABLE internet (
    capacidad   INTEGER,
    internet_id NUMBER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( internet_id );

CREATE TABLE local (
    tipo        VARCHAR2(255 BYTE),
    estilo      VARCHAR2(255 BYTE),
    capacidad   INTEGER,
    servicio_id NUMBER NOT NULL,
    local_id    NUMBER NOT NULL
);

CREATE UNIQUE INDEX local__idx ON
    local (
        servicio_id
    ASC );

ALTER TABLE local ADD CONSTRAINT local_pk PRIMARY KEY ( local_id );

CREATE TABLE piscina (
    capacidad   INTEGER,
    profundidad INTEGER,
    horainicio  VARCHAR2(255 BYTE),
    horafin     VARCHAR2(255 BYTE),
    piscina_id  NUMBER NOT NULL
);

ALTER TABLE piscina ADD CONSTRAINT piscina_pk PRIMARY KEY ( piscina_id );

CREATE TABLE planconsumo (
    id          NUMBER NOT NULL,
    nombre      VARCHAR2(255 BYTE),
    descripcion VARCHAR2(255 BYTE)
);

ALTER TABLE planconsumo ADD CONSTRAINT planconsumo_pk PRIMARY KEY ( id );

CREATE TABLE producto (
    id               NUMBER NOT NULL,
    nombre           VARCHAR2(255 BYTE),
    precio           NUMBER,
    spa_id           NUMBER NOT NULL,
    tienda_tienda_id NUMBER NOT NULL,
    local_local_id   NUMBER NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id );

CREATE TABLE reserva (
    id                 NUMBER NOT NULL,
    numnoches          INTEGER,
    fechain            DATE,
    estado             VARCHAR2(255 BYTE),
    acompanantes       INTEGER,
    planconsumo_id     NUMBER NOT NULL,
    cliente_cliente_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX reserva__idx ON
    reserva (
        cliente_cliente_id
    ASC );

ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( id,
                                                            planconsumo_id );

CREATE TABLE reservasalon (
    horainicio           VARCHAR2(255 BYTE),
    dia                  VARCHAR2(255 BYTE),
    duracion             INTEGER,
    salon_id             NUMBER NOT NULL,
    cuenta_habitacion_id NUMBER NOT NULL
);

ALTER TABLE reservasalon ADD CONSTRAINT reservasalon_pk PRIMARY KEY ( cuenta_habitacion_id );

CREATE TABLE ReservaSpa (
    costo NUMBER,
    horainicio VARCHAR2(255 BYTE),
    dia VARCHAR2(dia BYTE),
    spa_id NUMBER NOT NULL,
    cuenta_habitacion_id NUMBER NOT NULL
) 
;

ALTER TABLE reservaspa ADD CONSTRAINT reservaspa_pk PRIMARY KEY ( spa_id,
                                                                  cuenta_habitacion_id );

CREATE TABLE salon (
    id             NUMBER NOT NULL,
    costohora      NUMBER,
    capacidad      INTEGER,
    costoadicional NUMBER,
    tipo           VARCHAR2(255 BYTE)
);

ALTER TABLE salon ADD CONSTRAINT salon_pk PRIMARY KEY ( id );

CREATE TABLE servicio (
    id                   NUMBER NOT NULL,
    costo                NUMBER,
    cuenta_habitacion_id NUMBER NOT NULL,
    piscina_piscina_id   NUMBER NOT NULL,
    internet_internet_id NUMBER NOT NULL,
    gimnasio_gimnasio_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX servicio__idx ON
    servicio (
        piscina_piscina_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv1 ON
    servicio (
        internet_internet_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv2 ON
    servicio (
        gimnasio_gimnasio_id
    ASC );

ALTER TABLE servicio ADD CONSTRAINT servicio_pk PRIMARY KEY ( id );

CREATE TABLE spa (
    id         NUMBER NOT NULL,
    horainicio VARCHAR2(255 BYTE),
    horafin    VARCHAR2(255 BYTE)
);

ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( id );

CREATE TABLE tienda (
    tipo        VARCHAR2(255 BYTE),
    servicio_id NUMBER NOT NULL,
    tienda_id   NUMBER NOT NULL
);

CREATE UNIQUE INDEX tienda__idx ON
    tienda (
        servicio_id
    ASC );

ALTER TABLE tienda ADD CONSTRAINT tienda_pk PRIMARY KEY ( tienda_id );

CREATE TABLE tipohabitacion (
    id          NUMBER NOT NULL,
    descripcion VARCHAR2(255 BYTE),
    precio      NUMBER,
    capacidad   INTEGER
);

ALTER TABLE tipohabitacion ADD CONSTRAINT tipohabitacion_pk PRIMARY KEY ( id );

CREATE TABLE tipousuario (
    id   NUMBER NOT NULL,
    tipo VARCHAR2(255 BYTE)
);

ALTER TABLE tipousuario ADD CONSTRAINT tipousuario_pk PRIMARY KEY ( id );

CREATE TABLE usuario (
    id                 NUMBER NOT NULL,
    nombre             VARCHAR2(255 BYTE),
    email              VARCHAR2(255 BYTE),
    documento          VARCHAR2(255 BYTE),
    tipodocumento      VARCHAR2(255 BYTE),
    tipousuario_id     NUMBER NOT NULL,
    cliente_cliente_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX usuario__idx ON
    usuario (
        cliente_cliente_id
    ASC );

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( id );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_reserva_fk FOREIGN KEY ( reserva_id,
                                                   reserva_planconsumo_id )
        REFERENCES reserva ( id,
                             planconsumo_id );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_tipohabitacion_fk FOREIGN KEY ( tipohabitacion_id )
        REFERENCES tipohabitacion ( id );

ALTER TABLE local
    ADD CONSTRAINT local_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicio ( id );

ALTER TABLE producto
    ADD CONSTRAINT producto_local_fk FOREIGN KEY ( local_local_id )
        REFERENCES local ( local_id );

ALTER TABLE producto
    ADD CONSTRAINT producto_spa_fk FOREIGN KEY ( spa_id )
        REFERENCES spa ( id );

ALTER TABLE producto
    ADD CONSTRAINT producto_tienda_fk FOREIGN KEY ( tienda_tienda_id )
        REFERENCES tienda ( tienda_id );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_cliente_fk FOREIGN KEY ( cliente_cliente_id )
        REFERENCES cliente ( cliente_id );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_planconsumo_fk FOREIGN KEY ( planconsumo_id )
        REFERENCES planconsumo ( id );

ALTER TABLE reservasalon
    ADD CONSTRAINT reservasalon_cuenta_fk FOREIGN KEY ( cuenta_habitacion_id )
        REFERENCES cuenta ( habitacion_id );

ALTER TABLE reservasalon
    ADD CONSTRAINT reservasalon_salon_fk FOREIGN KEY ( salon_id )
        REFERENCES salon ( id );

ALTER TABLE reservaspa
    ADD CONSTRAINT reservaspa_cuenta_fk FOREIGN KEY ( cuenta_habitacion_id )
        REFERENCES cuenta ( habitacion_id );

ALTER TABLE reservaspa
    ADD CONSTRAINT reservaspa_spa_fk FOREIGN KEY ( spa_id )
        REFERENCES spa ( id );

ALTER TABLE servicio
    ADD CONSTRAINT servicio_cuenta_fk FOREIGN KEY ( cuenta_habitacion_id )
        REFERENCES cuenta ( habitacion_id );

ALTER TABLE servicio
    ADD CONSTRAINT servicio_gimnasio_fk FOREIGN KEY ( gimnasio_gimnasio_id )
        REFERENCES gimnasio ( gimnasio_id );

ALTER TABLE servicio
    ADD CONSTRAINT servicio_internet_fk FOREIGN KEY ( internet_internet_id )
        REFERENCES internet ( internet_id );

ALTER TABLE servicio
    ADD CONSTRAINT servicio_piscina_fk FOREIGN KEY ( piscina_piscina_id )
        REFERENCES piscina ( piscina_id );

ALTER TABLE tienda
    ADD CONSTRAINT tienda_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicio ( id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_cliente_fk FOREIGN KEY ( cliente_cliente_id )
        REFERENCES cliente ( cliente_id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_tipousuario_fk FOREIGN KEY ( tipousuario_id )
        REFERENCES tipousuario ( id );

CREATE SEQUENCE cliente_cliente_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER cliente_cliente_id_trg BEFORE
    INSERT ON cliente
    FOR EACH ROW
    WHEN ( new.cliente_id IS NULL )
BEGIN
    :new.cliente_id := cliente_cliente_id_seq.nextval;
END;
/

CREATE SEQUENCE gimnasio_gimnasio_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER gimnasio_gimnasio_id_trg BEFORE
    INSERT ON gimnasio
    FOR EACH ROW
    WHEN ( new.gimnasio_id IS NULL )
BEGIN
    :new.gimnasio_id := gimnasio_gimnasio_id_seq.nextval;
END;
/

CREATE SEQUENCE internet_internet_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER internet_internet_id_trg BEFORE
    INSERT ON internet
    FOR EACH ROW
    WHEN ( new.internet_id IS NULL )
BEGIN
    :new.internet_id := internet_internet_id_seq.nextval;
END;
/

CREATE SEQUENCE local_local_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER local_local_id_trg BEFORE
    INSERT ON local
    FOR EACH ROW
    WHEN ( new.local_id IS NULL )
BEGIN
    :new.local_id := local_local_id_seq.nextval;
END;
/

CREATE SEQUENCE piscina_piscina_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER piscina_piscina_id_trg BEFORE
    INSERT ON piscina
    FOR EACH ROW
    WHEN ( new.piscina_id IS NULL )
BEGIN
    :new.piscina_id := piscina_piscina_id_seq.nextval;
END;
/

CREATE SEQUENCE tienda_tienda_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER tienda_tienda_id_trg BEFORE
    INSERT ON tienda
    FOR EACH ROW
    WHEN ( new.tienda_id IS NULL )
BEGIN
    :new.tienda_id := tienda_tienda_id_seq.nextval;
END;
/



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            19
-- CREATE INDEX                             8
-- ALTER TABLE                             39
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           6
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          6
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
