-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-01 15:52:13 COT
--   sitio:      Oracle Database 21c
--   tipo:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE cliente (
    id      NUMBER NOT NULL,
    usuario NUMBER NOT NULL
);

CREATE UNIQUE INDEX cliente__idx ON
    cliente (
        usuario
    ASC );

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id );

CREATE TABLE consumo (
    cuenta_habitacion_id NUMBER NOT NULL,
    servicio_id          NUMBER NOT NULL,
    cuenta_reserva_id    NUMBER NOT NULL
);

ALTER TABLE consumo ADD CONSTRAINT consumo_pk PRIMARY KEY ( cuenta,
                                                            servicio );

CREATE TABLE cuenta (
    reserva_id    NUMBER NOT NULL,
    total         NUMBER,
    descripcion   VARCHAR2(255 BYTE),
    habitacion_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX cuenta__idx ON
    cuenta (
        reserva_id
    ASC );

ALTER TABLE cuenta ADD CONSTRAINT cuenta_pk PRIMARY KEY ( reserva_id,
                                                          habitacion_id );

CREATE TABLE gimnasio (
    capacidad   INTEGER,
    nummaquinas INTEGER,
    horain      VARCHAR2(255 BYTE),
    horafin     VARCHAR2(255 BYTE),
    servicio    NUMBER NOT NULL
);

CREATE UNIQUE INDEX gimnasio__idx ON
    gimnasio (
        servicio
    ASC );

ALTER TABLE gimnasio ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( servicio );

CREATE TABLE habitacion (
    id             NUMBER NOT NULL,
    tipohabitacion NUMBER NOT NULL
);

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( id );

CREATE TABLE internet (
    capacidad INTEGER,
    servicio  NUMBER NOT NULL
);

CREATE UNIQUE INDEX internet__idx ON
    internet (
        servicio
    ASC );

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( servicio );

CREATE TABLE local (
    tipo      VARCHAR2(255 BYTE),
    estilo    VARCHAR2(255 BYTE),
    capacidad INTEGER,
    servicio  NUMBER NOT NULL,
    id        NUMBER NOT NULL
);

CREATE UNIQUE INDEX local__idx ON
    local (
        servicio
    ASC );

ALTER TABLE local ADD CONSTRAINT local_pk PRIMARY KEY ( id );

CREATE TABLE piscina (
    capacidad   INTEGER,
    profundidad INTEGER,
    horain      VARCHAR2(255 BYTE),
    horafin     VARCHAR2(255 BYTE),
    servicio    NUMBER NOT NULL
);

CREATE UNIQUE INDEX piscina__idx ON
    piscina (
        servicio
    ASC );

ALTER TABLE piscina ADD CONSTRAINT piscina_pk PRIMARY KEY ( servicio );

CREATE TABLE planconsumo (
    id          NUMBER NOT NULL,
    nombre      VARCHAR2(255 BYTE),
    descripcion VARCHAR2(255 BYTE)
);

ALTER TABLE planconsumo ADD CONSTRAINT planconsumo_pk PRIMARY KEY ( id );

CREATE TABLE producto (
    id     NUMBER NOT NULL,
    nombre VARCHAR2(255 BYTE),
    precio NUMBER,
    spa    NUMBER,
    tienda NUMBER,
    local  NUMBER
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id );

CREATE TABLE reserva (
    id           NUMBER NOT NULL,
    numnoches    INTEGER,
    fechain      DATE,
    estado       VARCHAR2(255 BYTE),
    acompanantes INTEGER,
    planconsumo  NUMBER NOT NULL,
    cliente      NUMBER NOT NULL
);

CREATE UNIQUE INDEX reserva__idx ON
    reserva (
        cliente
    ASC );

ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( id );

CREATE TABLE reservasalon (
    horainicio           VARCHAR2(255 BYTE),
    dia                  VARCHAR2(255 BYTE),
    duracion             INTEGER,
    salon_id             NUMBER NOT NULL,
    cuenta_habitacion_id NUMBER NOT NULL,
    cuenta_reserva_id    NUMBER NOT NULL
);

ALTER TABLE reservasalon ADD CONSTRAINT reservasalon_pk PRIMARY KEY ( cuenta,
                                                                      salon );

CREATE TABLE ReservaSpa (
    costo NUMBER,
    horain VARCHAR2(255 BYTE),
    dia VARCHAR2(dia BYTE),
    spa_id NUMBER NOT NULL,
    cuenta_habitacion_id NUMBER NOT NULL,
    cuenta_reserva_id NUMBER NOT NULL
) 
;

ALTER TABLE reservaspa ADD CONSTRAINT reservaspa_pk PRIMARY KEY ( spa,
                                                                  cuenta );

CREATE TABLE salon (
    id             NUMBER NOT NULL,
    costo          NUMBER,
    capacidad      INTEGER,
    costoadicional NUMBER,
    tipo           VARCHAR2(255 BYTE)
);

ALTER TABLE salon ADD CONSTRAINT salon_pk PRIMARY KEY ( id );

CREATE TABLE servicio (
    id    NUMBER NOT NULL,
    costo NUMBER
);

ALTER TABLE servicio ADD CONSTRAINT servicio_pk PRIMARY KEY ( id );

CREATE TABLE spa (
    id      NUMBER NOT NULL,
    horain  VARCHAR2(255 BYTE),
    horafin VARCHAR2(255 BYTE)
);

ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( id );

CREATE TABLE tienda (
    tipo     VARCHAR2(255 BYTE),
    servicio NUMBER NOT NULL,
    id       NUMBER NOT NULL
);

CREATE UNIQUE INDEX tienda__idx ON
    tienda (
        servicio
    ASC );

ALTER TABLE tienda ADD CONSTRAINT tienda_pk PRIMARY KEY ( id );

CREATE TABLE tipohabitacion (
    id          NUMBER NOT NULL,
    tipo        VARCHAR2(255 BYTE),
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
    id            NUMBER NOT NULL,
    nombre        VARCHAR2(255 BYTE),
    email         VARCHAR2(255 BYTE),
    documento     VARCHAR2(255 BYTE),
    tipodocumento VARCHAR2(255 BYTE),
    tipousuario   NUMBER NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_usuario_fk FOREIGN KEY ( usuario )
        REFERENCES usuario ( id );

ALTER TABLE consumo
    ADD CONSTRAINT consumo_cuenta_fk FOREIGN KEY ( cuenta_reserva_id,
                                                   cuenta_habitacion_id )
        REFERENCES cuenta ( reserva_id,
                            habitacion_id );

ALTER TABLE consumo
    ADD CONSTRAINT consumo_servicio_fk FOREIGN KEY ( servicio )
        REFERENCES servicio ( id );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_habitacion_fk FOREIGN KEY ( habitacion )
        REFERENCES habitacion ( id );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_reserva_fk FOREIGN KEY ( reserva )
        REFERENCES reserva ( id );

ALTER TABLE gimnasio
    ADD CONSTRAINT gimnasio_servicio_fk FOREIGN KEY ( servicio )
        REFERENCES servicio ( id );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_tipohabitacion_fk FOREIGN KEY ( tipohabitacion )
        REFERENCES tipohabitacion ( id );

ALTER TABLE internet
    ADD CONSTRAINT internet_servicio_fk FOREIGN KEY ( servicio )
        REFERENCES servicio ( id );

ALTER TABLE local
    ADD CONSTRAINT local_servicio_fk FOREIGN KEY ( servicio )
        REFERENCES servicio ( id );

ALTER TABLE piscina
    ADD CONSTRAINT piscina_servicio_fk FOREIGN KEY ( servicio )
        REFERENCES servicio ( id );

ALTER TABLE producto
    ADD CONSTRAINT producto_local_fk FOREIGN KEY ( local )
        REFERENCES local ( id );

ALTER TABLE producto
    ADD CONSTRAINT producto_spa_fk FOREIGN KEY ( spa )
        REFERENCES spa ( id );

ALTER TABLE producto
    ADD CONSTRAINT producto_tienda_fk FOREIGN KEY ( tienda )
        REFERENCES tienda ( id );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_cliente_fk FOREIGN KEY ( cliente )
        REFERENCES cliente ( id );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_planconsumo_fk FOREIGN KEY ( planconsumo )
        REFERENCES planconsumo ( id );

ALTER TABLE reservasalon
    ADD CONSTRAINT reservasalon_cuenta_fk FOREIGN KEY ( cuenta_reserva_id,
                                                        cuenta_habitacion_id )
        REFERENCES cuenta ( reserva_id,
                            habitacion_id );

ALTER TABLE reservasalon
    ADD CONSTRAINT reservasalon_salon_fk FOREIGN KEY ( salon )
        REFERENCES salon ( id );

ALTER TABLE reservaspa
    ADD CONSTRAINT reservaspa_cuenta_fk FOREIGN KEY ( cuenta_reserva_id,
                                                      cuenta_habitacion_id )
        REFERENCES cuenta ( reserva_id,
                            habitacion_id );

ALTER TABLE reservaspa
    ADD CONSTRAINT reservaspa_spa_fk FOREIGN KEY ( spa )
        REFERENCES spa ( id );

ALTER TABLE tienda
    ADD CONSTRAINT tienda_servicio_fk FOREIGN KEY ( servicio )
        REFERENCES servicio ( id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_tipousuario_fk FOREIGN KEY ( tipousuario )
        REFERENCES tipousuario ( id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            20
-- CREATE INDEX                             8
-- ALTER TABLE                             41
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
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
-- CREATE SEQUENCE                          0
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
