--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: cargo; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cargo;


ALTER SCHEMA cargo OWNER TO postgres;

--
-- Name: desplazamientos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA desplazamientos;


ALTER SCHEMA desplazamientos OWNER TO postgres;

--
-- Name: usuarios; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA usuarios;


ALTER SCHEMA usuarios OWNER TO postgres;

--
-- Name: viaticos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA viaticos;


ALTER SCHEMA viaticos OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = cargo, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cargo; Type: TABLE; Schema: cargo; Owner: postgres; Tablespace: 
--

CREATE TABLE cargo (
    id_cargo integer NOT NULL,
    descripcion_cargo character varying
);


ALTER TABLE cargo.cargo OWNER TO postgres;

--
-- Name: cargo_id_cargo_seq; Type: SEQUENCE; Schema: cargo; Owner: postgres
--

CREATE SEQUENCE cargo_id_cargo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cargo.cargo_id_cargo_seq OWNER TO postgres;

--
-- Name: cargo_id_cargo_seq; Type: SEQUENCE OWNED BY; Schema: cargo; Owner: postgres
--

ALTER SEQUENCE cargo_id_cargo_seq OWNED BY cargo.id_cargo;


--
-- Name: cargo_id_cargo_seq; Type: SEQUENCE SET; Schema: cargo; Owner: postgres
--

SELECT pg_catalog.setval('cargo_id_cargo_seq', 4, true);


SET search_path = desplazamientos, pg_catalog;

--
-- Name: desplazamiento; Type: TABLE; Schema: desplazamientos; Owner: postgres; Tablespace: 
--

CREATE TABLE desplazamiento (
    id_desplazamiento integer NOT NULL,
    descrip_despla character varying NOT NULL,
    tarifa_despla integer NOT NULL
);


ALTER TABLE desplazamientos.desplazamiento OWNER TO postgres;

--
-- Name: desplazamiento_id_desplazamiento_seq; Type: SEQUENCE; Schema: desplazamientos; Owner: postgres
--

CREATE SEQUENCE desplazamiento_id_desplazamiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE desplazamientos.desplazamiento_id_desplazamiento_seq OWNER TO postgres;

--
-- Name: desplazamiento_id_desplazamiento_seq; Type: SEQUENCE OWNED BY; Schema: desplazamientos; Owner: postgres
--

ALTER SEQUENCE desplazamiento_id_desplazamiento_seq OWNED BY desplazamiento.id_desplazamiento;


--
-- Name: desplazamiento_id_desplazamiento_seq; Type: SEQUENCE SET; Schema: desplazamientos; Owner: postgres
--

SELECT pg_catalog.setval('desplazamiento_id_desplazamiento_seq', 106, true);


SET search_path = usuarios, pg_catalog;

--
-- Name: firmas; Type: TABLE; Schema: usuarios; Owner: postgres; Tablespace: 
--

CREATE TABLE firmas (
    id character(6),
    nombre character(64),
    archivo bytea,
    id_firmas integer NOT NULL
);


ALTER TABLE usuarios.firmas OWNER TO postgres;

--
-- Name: firmas_id_firmas_seq; Type: SEQUENCE; Schema: usuarios; Owner: postgres
--

CREATE SEQUENCE firmas_id_firmas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuarios.firmas_id_firmas_seq OWNER TO postgres;

--
-- Name: firmas_id_firmas_seq; Type: SEQUENCE OWNED BY; Schema: usuarios; Owner: postgres
--

ALTER SEQUENCE firmas_id_firmas_seq OWNED BY firmas.id_firmas;


--
-- Name: firmas_id_firmas_seq; Type: SEQUENCE SET; Schema: usuarios; Owner: postgres
--

SELECT pg_catalog.setval('firmas_id_firmas_seq', 14, true);


--
-- Name: usuarios; Type: TABLE; Schema: usuarios; Owner: postgres; Tablespace: 
--

CREATE TABLE usuarios (
    id_usuario integer NOT NULL,
    nombre_usuario character varying,
    apellido_usuario character varying,
    cedula_usuario bigint,
    id_cargo integer,
    usuario character varying,
    clave character varying,
    id_firma integer
);


ALTER TABLE usuarios.usuarios OWNER TO postgres;

--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: usuarios; Owner: postgres
--

CREATE SEQUENCE usuarios_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuarios.usuarios_id_usuario_seq OWNER TO postgres;

--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: usuarios; Owner: postgres
--

ALTER SEQUENCE usuarios_id_usuario_seq OWNED BY usuarios.id_usuario;


--
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: usuarios; Owner: postgres
--

SELECT pg_catalog.setval('usuarios_id_usuario_seq', 16, true);


SET search_path = viaticos, pg_catalog;

--
-- Name: cuenta_cobro; Type: TABLE; Schema: viaticos; Owner: postgres; Tablespace: 
--

CREATE TABLE cuenta_cobro (
    id_cuenta_cobro integer NOT NULL,
    fecha_sistema timestamp without time zone NOT NULL,
    id_usuario integer NOT NULL,
    cuenta_generada boolean DEFAULT false NOT NULL
);


ALTER TABLE viaticos.cuenta_cobro OWNER TO postgres;

--
-- Name: cuenta_cobro_id_cuenta_cobro_seq; Type: SEQUENCE; Schema: viaticos; Owner: postgres
--

CREATE SEQUENCE cuenta_cobro_id_cuenta_cobro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE viaticos.cuenta_cobro_id_cuenta_cobro_seq OWNER TO postgres;

--
-- Name: cuenta_cobro_id_cuenta_cobro_seq; Type: SEQUENCE OWNED BY; Schema: viaticos; Owner: postgres
--

ALTER SEQUENCE cuenta_cobro_id_cuenta_cobro_seq OWNED BY cuenta_cobro.id_cuenta_cobro;


--
-- Name: cuenta_cobro_id_cuenta_cobro_seq; Type: SEQUENCE SET; Schema: viaticos; Owner: postgres
--

SELECT pg_catalog.setval('cuenta_cobro_id_cuenta_cobro_seq', 1, false);


--
-- Name: detalle_cuenta_cobro; Type: TABLE; Schema: viaticos; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_cuenta_cobro (
    id_detalle_cuenta integer NOT NULL,
    id_desplazamiento integer NOT NULL,
    novedad character varying,
    id_cuenta_cobro integer NOT NULL,
    fecha_despla date
);


ALTER TABLE viaticos.detalle_cuenta_cobro OWNER TO postgres;

--
-- Name: detalle_cuenta_cobro_id_detalle_cuenta_seq; Type: SEQUENCE; Schema: viaticos; Owner: postgres
--

CREATE SEQUENCE detalle_cuenta_cobro_id_detalle_cuenta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE viaticos.detalle_cuenta_cobro_id_detalle_cuenta_seq OWNER TO postgres;

--
-- Name: detalle_cuenta_cobro_id_detalle_cuenta_seq; Type: SEQUENCE OWNED BY; Schema: viaticos; Owner: postgres
--

ALTER SEQUENCE detalle_cuenta_cobro_id_detalle_cuenta_seq OWNED BY detalle_cuenta_cobro.id_detalle_cuenta;


--
-- Name: detalle_cuenta_cobro_id_detalle_cuenta_seq; Type: SEQUENCE SET; Schema: viaticos; Owner: postgres
--

SELECT pg_catalog.setval('detalle_cuenta_cobro_id_detalle_cuenta_seq', 1, false);


SET search_path = cargo, pg_catalog;

--
-- Name: id_cargo; Type: DEFAULT; Schema: cargo; Owner: postgres
--

ALTER TABLE ONLY cargo ALTER COLUMN id_cargo SET DEFAULT nextval('cargo_id_cargo_seq'::regclass);


SET search_path = desplazamientos, pg_catalog;

--
-- Name: id_desplazamiento; Type: DEFAULT; Schema: desplazamientos; Owner: postgres
--

ALTER TABLE ONLY desplazamiento ALTER COLUMN id_desplazamiento SET DEFAULT nextval('desplazamiento_id_desplazamiento_seq'::regclass);


SET search_path = usuarios, pg_catalog;

--
-- Name: id_firmas; Type: DEFAULT; Schema: usuarios; Owner: postgres
--

ALTER TABLE ONLY firmas ALTER COLUMN id_firmas SET DEFAULT nextval('firmas_id_firmas_seq'::regclass);


--
-- Name: id_usuario; Type: DEFAULT; Schema: usuarios; Owner: postgres
--

ALTER TABLE ONLY usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('usuarios_id_usuario_seq'::regclass);


SET search_path = viaticos, pg_catalog;

--
-- Name: id_cuenta_cobro; Type: DEFAULT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY cuenta_cobro ALTER COLUMN id_cuenta_cobro SET DEFAULT nextval('cuenta_cobro_id_cuenta_cobro_seq'::regclass);


--
-- Name: id_detalle_cuenta; Type: DEFAULT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY detalle_cuenta_cobro ALTER COLUMN id_detalle_cuenta SET DEFAULT nextval('detalle_cuenta_cobro_id_detalle_cuenta_seq'::regclass);


SET search_path = cargo, pg_catalog;

--
-- Data for Name: cargo; Type: TABLE DATA; Schema: cargo; Owner: postgres
--

INSERT INTO cargo VALUES (1, 'Tecnico de Sistemas');
INSERT INTO cargo VALUES (2, 'Ingeniero de apoyo');
INSERT INTO cargo VALUES (4, 'Administrador');
INSERT INTO cargo VALUES (3, 'Jefe a cargo - Auditor de sistemas');


SET search_path = desplazamientos, pg_catalog;

--
-- Data for Name: desplazamiento; Type: TABLE DATA; Schema: desplazamientos; Owner: postgres
--

INSERT INTO desplazamiento VALUES (1, 'Cali-Peaje Tunia', 10500);
INSERT INTO desplazamiento VALUES (2, 'Cali-Peaje Villarica', 4500);
INSERT INTO desplazamiento VALUES (3, 'Cali-Peaje Cerrito', 5000);
INSERT INTO desplazamiento VALUES (4, 'Cali-Peaje Paso la Torre', 6000);
INSERT INTO desplazamiento VALUES (5, 'Cali-Peaje Loboguerrero', 12000);
INSERT INTO desplazamiento VALUES (6, 'Cali – Tres esquinas o Pueblo Rozo o Peaje Rozo', 4000);
INSERT INTO desplazamiento VALUES (7, 'Cali – Peaje Cencar', 3000);
INSERT INTO desplazamiento VALUES (8, 'Cali – Peaje Mediacanoa o Básculas T5', 6000);
INSERT INTO desplazamiento VALUES (9, 'Cali – Peaje Estambul', 2700);
INSERT INTO desplazamiento VALUES (10, 'Cali – Peaje CIAT o CCO', 2700);
INSERT INTO desplazamiento VALUES (11, 'Cali – Básculas T3', 7000);
INSERT INTO desplazamiento VALUES (12, 'Cali – Básculas T2', 5500);
INSERT INTO desplazamiento VALUES (13, 'Cali – Tres equinas', 4000);
INSERT INTO desplazamiento VALUES (14, 'Palmira – Peaje Tunía', 13200);
INSERT INTO desplazamiento VALUES (15, 'Palmira – Peaje Villa Rica', 7200);
INSERT INTO desplazamiento VALUES (16, 'Palmira – Peaje Cerrito', 3500);
INSERT INTO desplazamiento VALUES (17, 'Palmira – Peaje Paso Latorre', 10200);
INSERT INTO desplazamiento VALUES (18, 'Palmira – Peaje Loboguerrero', 14700);
INSERT INTO desplazamiento VALUES (19, 'Palmira – Tres esquinas o Pueblo Rozo', 2500);
INSERT INTO desplazamiento VALUES (20, 'Palmira – Peaje Rozo', 5000);
INSERT INTO desplazamiento VALUES (21, 'Palmira – Peaje Cencar (ruta x Aeropuerto)', 4500);
INSERT INTO desplazamiento VALUES (22, 'Palmira – Peaje Mediacanoa o BT5 (ruta x sameco)
', 10200);
INSERT INTO desplazamiento VALUES (23, 'Palmira – Peaje Estambul', 2700);
INSERT INTO desplazamiento VALUES (24, 'Palmira – Peaje CIAT o CCO', 2000);
INSERT INTO desplazamiento VALUES (25, 'Palmira – Básculas T3', 5000);
INSERT INTO desplazamiento VALUES (26, 'Palmira – Básculas T2', 8000);
INSERT INTO desplazamiento VALUES (27, 'Yumbo - Cali', 2200);
INSERT INTO desplazamiento VALUES (28, 'Yumbo – Peaje Cerrito
', 7200);
INSERT INTO desplazamiento VALUES (29, 'Yumbo – Peaje Paso Latorre', 4500);
INSERT INTO desplazamiento VALUES (30, 'Yumbo – Peaje Loboguerrero', 14200);
INSERT INTO desplazamiento VALUES (31, 'Yumbo – Tres esquinas o Pueblo Rozo', 6200);
INSERT INTO desplazamiento VALUES (32, 'Yumbo – Peaje Cencar', 2500);
INSERT INTO desplazamiento VALUES (34, 'Yumbo – Peaje Mediacanoa o BT5', 4000);
INSERT INTO desplazamiento VALUES (35, 'Yumbo - Mulaló', 3000);
INSERT INTO desplazamiento VALUES (36, 'Peaje Ciat - CCO', 1000);
INSERT INTO desplazamiento VALUES (37, 'Peaje Ciat – Peaje Estambul', 2700);
INSERT INTO desplazamiento VALUES (38, 'Peaje Ciat - Aeropuerto', 1500);
INSERT INTO desplazamiento VALUES (39, 'Peaje Ciat – Peaje Cerrito', 5000);
INSERT INTO desplazamiento VALUES (40, 'Peaje Ciat – Básculas T3', 6000);
INSERT INTO desplazamiento VALUES (41, 'Peaje Ciat – Peaje Cencar', 5000);
INSERT INTO desplazamiento VALUES (42, 'Peaje Ciat – Peaje Mediacanoa o Básculas T5', 9000);
INSERT INTO desplazamiento VALUES (43, 'Peaje Ciat – Peaje Loboguerrero', 14700);
INSERT INTO desplazamiento VALUES (44, 'Peaje Ciat – Peaje Paso Latorre', 8200);
INSERT INTO desplazamiento VALUES (45, 'Peaje Ciat – Peaje Rozo', 5000);
INSERT INTO desplazamiento VALUES (46, 'Peaje Ciat – Peaje Villarrica', 7300);
INSERT INTO desplazamiento VALUES (47, 'Peaje Ciat – Básculas T2', 8700);
INSERT INTO desplazamiento VALUES (48, 'Peaje Ciat – Peaje Tunia', 14700);
INSERT INTO desplazamiento VALUES (49, 'Peaje Estambul - Aeropuerto', 2500);
INSERT INTO desplazamiento VALUES (50, 'Peaje Estambul - CCO', 2700);
INSERT INTO desplazamiento VALUES (51, 'Peaje Estambul – Peaje Cerrito', 5000);
INSERT INTO desplazamiento VALUES (52, 'Peaje Estambul – Básculas T3', 6000);
INSERT INTO desplazamiento VALUES (53, 'Peaje Estambul – Peaje Rozo', 6700);
INSERT INTO desplazamiento VALUES (54, 'Peaje Estambul – Peaje Paso Latorre', 8700);
INSERT INTO desplazamiento VALUES (55, 'Peaje Estambul – Peaje Mediacanoa o Básculas T5', 8700);
INSERT INTO desplazamiento VALUES (56, 'Peaje Estambul – Peaje Cencar', 5700);
INSERT INTO desplazamiento VALUES (57, 'Peaje Estambul – Peaje Loboguerrero', 14700);
INSERT INTO desplazamiento VALUES (58, 'Peaje Estambul – Peaje Villarrica', 7200);
INSERT INTO desplazamiento VALUES (59, 'Peaje Estambul – Básculas T2', 8700);
INSERT INTO desplazamiento VALUES (60, 'Peaje Estambul – Peaje Tunia', 13200);
INSERT INTO desplazamiento VALUES (61, 'Peaje Cerrito – Báscula Norte T3', 2000);
INSERT INTO desplazamiento VALUES (62, 'Báscula Norte T3 – Báscula Sur T3', 2000);
INSERT INTO desplazamiento VALUES (63, 'Peaje Cerrito – Peaje Rozo', 4000);
INSERT INTO desplazamiento VALUES (64, 'Peaje Cerrito – Peaje Paso Latorre', 10000);
INSERT INTO desplazamiento VALUES (65, 'Peaje Cerrito – Peaje Cencar', 9500);
INSERT INTO desplazamiento VALUES (66, 'Peaje Cerrito – Peaje Mediacanoa o Básculas T5', 11000);
INSERT INTO desplazamiento VALUES (67, 'Peaje Cerrito – Peaje Loboguerrero', 17000);
INSERT INTO desplazamiento VALUES (68, 'Peaje Cerrito – Peaje Villarrica', 9500);
INSERT INTO desplazamiento VALUES (69, 'Peaje Cerrito – Básculas T2', 11000);
INSERT INTO desplazamiento VALUES (70, 'Peaje Cerrito - Tunía', 15500);
INSERT INTO desplazamiento VALUES (71, 'Peaje Cerrito - CCO', 5000);
INSERT INTO desplazamiento VALUES (72, 'Peaje Mediacanoa – Peaje Loboguerrero', 18000);
INSERT INTO desplazamiento VALUES (73, 'Peaje Mediacanoa – Peaje Paso Latorre', 5000);
INSERT INTO desplazamiento VALUES (74, 'Peaje Mediacanoa – Peaje Cencar', 7500);
INSERT INTO desplazamiento VALUES (75, 'Peaje Mediacanoa – Peaje Rozo', 12000);
INSERT INTO desplazamiento VALUES (76, 'Peaje Mediacanoa – Peaje Villarrica', 10500);
INSERT INTO desplazamiento VALUES (77, 'Peaje Mediacanoa – Básculas T2', 12000);
INSERT INTO desplazamiento VALUES (78, 'Peaje Mediacanoa – Peaje Tunía', 16500);
INSERT INTO desplazamiento VALUES (79, 'Peaje Mediacanoa - CCO', 8700);
INSERT INTO desplazamiento VALUES (80, 'Peaje Cencar – Peaje Loboguerrero', 15500);
INSERT INTO desplazamiento VALUES (81, 'Peaje Cencar – Peaje Paso Latorre', 7500);
INSERT INTO desplazamiento VALUES (82, 'Peaje Cencar – Peaje Rozo', 4000);
INSERT INTO desplazamiento VALUES (83, 'Peaje Cencar – Peaje Villarrica', 8000);
INSERT INTO desplazamiento VALUES (84, 'Peaje Cencar – Básculas T2', 9500);
INSERT INTO desplazamiento VALUES (85, 'Peaje Cencar – Peaje Tunía', 14000);
INSERT INTO desplazamiento VALUES (86, 'Peaje Cencar - CCO', 4500);
INSERT INTO desplazamiento VALUES (87, 'Peaje Rozo – Peaje Paso Latorre', 6500);
INSERT INTO desplazamiento VALUES (88, 'Peaje Rozo – Peaje Loboguerrero', 16000);
INSERT INTO desplazamiento VALUES (89, 'Peaje Rozo – Peaje Villarrica', 8500);
INSERT INTO desplazamiento VALUES (90, 'Peaje Rozo – Básculas T2', 10000);
INSERT INTO desplazamiento VALUES (91, 'Peaje Rozo – Peaje Tunía', 14500);
INSERT INTO desplazamiento VALUES (92, 'Peaje Rozo - CCO', 4000);
INSERT INTO desplazamiento VALUES (93, 'Peaje Paso Latorre – Peaje Loboguerrero', 18000);
INSERT INTO desplazamiento VALUES (94, 'Peaje Paso Latorre – Peaje Villarrica', 10500);
INSERT INTO desplazamiento VALUES (95, 'Peaje Paso Latorre – Básculas T2', 12000);
INSERT INTO desplazamiento VALUES (96, 'Peaje Paso Latorre - Tunía', 16500);
INSERT INTO desplazamiento VALUES (97, 'Peaje Paso Latorre - CCO', 7000);
INSERT INTO desplazamiento VALUES (98, 'Peaje Loboguerrero – Peaje Villarrica', 16500);
INSERT INTO desplazamiento VALUES (99, 'Peaje Loboguerrero – Básculas T2', 18000);
INSERT INTO desplazamiento VALUES (100, 'Peaje Loboguerrero - Tunía', 22500);
INSERT INTO desplazamiento VALUES (101, 'Peaje Loboguerrero - CCO', 14700);
INSERT INTO desplazamiento VALUES (102, 'Peaje Villarrica – Peaje Tunía o BT2 (Lunes a Viernes no festivos)', 6000);
INSERT INTO desplazamiento VALUES (103, 'Peaje Villarrica – Peaje Tunía o BT2 (Sábados, Domingos y', 10000);
INSERT INTO desplazamiento VALUES (104, 'Peaje Villarrica – Básculas T2', 1500);
INSERT INTO desplazamiento VALUES (105, 'Peaje Villarrica - CCO', 7200);
INSERT INTO desplazamiento VALUES (106, 'Peaje Tunía - CCO', 13200);


SET search_path = usuarios, pg_catalog;

--
-- Data for Name: firmas; Type: TABLE DATA; Schema: usuarios; Owner: postgres
--

INSERT INTO firmas VALUES ('035147', 'andres.jpg                                                      ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108004500c903012200021101031101ffc4001c0001000105010100000000000000000000000601030405070208ffc4003b10000103030302050203060309000000000102030400051106122131410713225161147123329115334281a1b10862f1161725265372a2d1e1ffc40017010101010100000000000000000000000000010203ffc4002111010100020301000203010000000000000001021112213141035113324261ffda000c03010002110311003f00fb2e94a66829914c8aa1501d7fb512a49e873482b914cd7952827aa80ab2e4c88dfef25b28ff00b96055d1dfe9939a6466b01576b60c955ce1803ae5e4ff00eeb0a7eaad310185489ba8ad31da4fe671d98da129fb9271524b4d657c8dde47bd3727deb9a4ef18b4c978b164667df0903cb762b788eb24e38794423b75048f9a2b5a6ac900bd1ecfa7a2b05bc844abd20b849f7dbc0fd6b73f1e5f5ab8d9ec74c041a5453456b1857a84f26606adb7088b0d4988b7d2a293b7214920fa9041c83f7a91a66c35fe494cab1ecb06b3ab3d66cac8c8aa6455a5bec21056b750948fe22a007eb58170bfd920c811665de0c790a194b2e3e90b50f84e727f9534babfa6d370f9fd2bcf988f7fe9511d23e20e9ed55a82e563b32a7b926db8fa953d096d36d927006e501c9c1c0ebc1f6adbdd98b94a7db8905ffa56168517a4a71e627918423b0ea79a71ef5535fb6e37a7dfa57aae13e1233725ff00884d7263c9b848d3d0e2b319a71f714e34e3d84050493c1214dba0e3a1041c5775079c54cbaad65357515aa122b19fb940614d25f9b1da2f3a19682dc09dee1e8819eaae3a75ad65d353d9a1a5c4267224c940cfd245fc690bfb369ca88f9c6077e9492d492d6ec2d39c679f6aaa541490a4f435c819d45ab75878976eb55b5a5daac56e52665cc856e71ce0ec656a194a4a95b55b41c948ce304575e6ff0020ce33df156e371eaae58e9ea94a5464a52940af2a0adaadb8dddb35ea941c764c0f175c985377b9484c70e2949558d2c01b79c27f10057191dfb55b6ad2e2fcc4de53e25beb5e7728482518f601b3d2bb2107b2bfa5080460ff006ae93f2efd8d7271a4692d0610932b4f6b493c0daa92b92a27e30179abb22cfe1542825e9da367a5a69254b53d11f56c1ee4951fef5d2ef170911dd442b7451266b83704ab86c24752a3dbd87cd61db74d3265a2eb7a5a6e37419d8e2d39430339dada4f007cf53f19c55971fb12655c6a6b9a6e780de8cf0bc2a1ad0526e53ad6e16f9cf284e095119cf3807159da5b43786f6871771bb691ba5eaeaee3cf90fd955b527b043606d48fd4d760d497eb369c83f5b7a9cd448f9da95b99383827e4f407f4a854cf1c7c2b6e248711ac2d6f29a6d6af292b20b981929191d4d6b96fa91bde5fe567e97c355214a7341388e42885591431ce076f7156928f0aca4799a3d4cb7f94172cee007a718c563e94f12f414c8e67dfb5cd9644b7dc4bc2334fee6a281f91231dc60127dc7c566ea6f1e3c31b3daa54863555b6e52db6d5e4c48ceef71e58070918cf53c67e6b37abe271cea04aff007768d717f7a169e65e6d8871d6d30b84e212e3aa43a9d84edca402949fb1ef5ab7efba4df72242478750adb21d5842df7243de4b671d7084ee2339f6ed53ef0efc48d0765b13a6e5ab132ee93e53b3672d31dd500f2cf284e107d2901281f091522578c7a17f335367be318fc3b73eacff00e35d79ff00c6bbdf8e616cf0efc2e9921f9ba835dcb93e7e439098b8391a337d3809ceec0f93fdabdea6d1de1b69a6c39a32fb353a8eeae18d0833792b59594824a8af71084a46ec7c7bd4a7527f888d0f014f5be147be4fbc963cd8b05bb73e95bf9e98f4f03ae4e3b1eb5a7f0f35cd963266deaefa7b54dcf515cc85cf7c58dddada472961bde386d3ce073c927bf19c796f969a933eed49f46f858fe9eb621bb56bfbd36f2c79925c0a69d0e3a5454b51ca7272a52cf278cd5af125cd6fa3f4b3f73635efd5495b888d0633f6c6b2fc870ed6dbdc9209255d71ce0134b8eb7d34e4375f7fc34be290d24adc548b2a10129c72a255c74f7ae73a5edf1f576a97f57c5f0c2f91ed423a53610c38236010773c70af4ad44ed1db69cf7ab25fed9338eecde49ac36b5ef859a42d5156bb3dde3f985a90e3709ddfe6b854e171c2924e0aca86467950acb675e78b33999acdb3c378ea7184fe14b912d51d970f1c04ac0577ab568b778a512e30dcb6373d9881c1e7337aba34fb61acf29c253bb38c8ce78e2bae23eb158f312c279c1c2c9e39f8ac6574ce59eef8e32c5b1f9ae17bc42d1daa6faf94808755b16db1ce55e5a1b5829e7bf5c719ab1aab5d690d31656b4ce9088ab25f6ecb4b08faa86e34b8c857ef1f5a940956c054460919205756d6da922e96d3eedce765d73725b8f1da054a90f28e10da077255fd066b5de19e98996a8b2ef3a81687b51de56991715a544a5ac27d2c233d1b472074c9c9ef8126535d92ebd8c5f0ae0e8bd37a75162d377c8939b0e2dc756a98971e754a3d55ce781803e122a7a857a4753f3569e8ecc860b525a6df6d5f992e24281fe58a8fcbf0ff00484977cf1638d19eff00a91416159f7f462b16cacdb2d498ac038c2bf4aaa5414322a20ce959f687bccb36a7ba2538caa3cf5fd4b4afd7d49fb83595a66f97891729d6bbe59c4294c294a61e6d7b9a94d02121638ca4e481b4e4f7a9c7ea24d4aa2145439001c0c8cf4aad40a52940a52941e032d852d41382b20a8fbe3a57952b6123f4fbfb55da8feb98571bb69e9769b6b9e4b937115c901cc161a5f0e2c77dfb4903e48353e8da496d992d96df690ea0ff000292143a7b74ff005ad5af4ce9a2d38d1b15b8a1d042d223a06e19e7a0fb7f4a8546d0daa44bb77fccce423666df6614964e43ed29c42da69e6d44e52909d8a39dc7cbce46ec0c391a3353484bae3f6f88a9b22021b6648b8abfe1f23ea24ba5681b7d780f367b676638edda493cacf2ca789327c3bd2e856c8f1de8ed1e12ca76282401d01524abf53c57ab07877a16c7759175b758e199efb65b7a53eb53ce1485038cac9c0ce3a003ed51c91e1cdfbfda36af0dccb7f95fb6d735e6be9d42429a3242d003dbb006d1c829fcb94823391add3fa0356c4d3f79b6cd4c55bf210e8664b0fa52b593237a028a92acfa4e0850c638e339abef56aff267e3b0b512181b9b8d1824f390da700fbd4635a6a391196d5834d351e4dfa623734950f4456fa17dcedb4761fc47ec6a2fa617a9ad9a666e9685a7edf70ba65e2bfc65350da2b4e5297080a193eaca51803d238ce6b57a6fc29b8b5a35dd3f70f25891749a25de6e6cca3be52903721284271e5a37046120f0949ce771a92497ba4de93ed27a36cf67b90bbbc45cb512d8d92ae6fe0bce038270918084f030948007b75adfceb841b7c07e74c9886a3328f31c714e7094f51dfbf6f7ae4579f0f75c3f7737e56a7622dc7f671b74979a53812eb65b2d29f08e5285f3e7048cfa9211bb92aad65bfc32d5339115b9859165722416d111c96a258fa77325c712a492b2a6fa27b64e4e4538cbdda5cadf53980cdcf5e3aa17c0987a6dc054d5b03852fca19c27ce23d494f1bb68c677007818a9e3063c74331501a69253b1942708042471b47b631d0715caacda02f91541af260449a8d40edc957a6e529c75c61535c78325bda0fa9a5f9472ac2464ff0008158ba5fc33d476cb0a2d3737e2dd272d888db375549521eb596594232da71957e2256e0c293b8af69e064cbabd6cdfc76471d4b69fc6525a04800a958249edfe99ad76aad43074dd8a4ddae0b3e5b0d9506d232b74f184a0773c81fcea2be2e693b8ea885005b1a8cebd183edee90b1e5a52e6d1ca4a15bbf2819052a1c9079a83c6d11a875aebeb47882bbaa19b7593cb830ad6a6d65a98da52a43b23255e81bd654804289f293cfab898632c96d37a4d34369dbe5d6e0dea9d7aeb1266b4b53b6a88d00966036e2724f1c2dcc1dbb959384f1d4d4f572e3b7b525f68150ca32b0377db279fbfc8a84dbed3aad1a058d32fb16e8af376e6a1aa7a641748012942d61bd8924eddc40c8e7038ad24fd0376759b7d864c0b35c2cd02529e65c2fa9992e37e6798db1ca55b50951c1f512a01238e4d5b25be973b5d543d8210a292beb807391df1c738c8fd457962632f20a9a71b5e0e0ed56eda7d8e2a0979d237e9faf236af8d738d19c865a61988028a5c8d85f9c82bc8c1529c0afcbd5940e84d5bf0c741ced25323c9973a2cb28b5a2212c30968a560a4aca80fde648c851208c1c856723364d7a4745482b4fac6140f3834f2d3dc64e319eff3fdaaa8e5390723debd565544a427a55694a05294a05294a0550804e7bd56941e4212318cf1f26ac4c7588ad2e43cad8d34da94b51c909039271f001ac9ad6ea1849b95aa65b94b2da6530a64ac1e46e0467f967f9f3520c6fdb96b54696f29e5b288c940783b1968500a242700819c9c818cf35916eb84596c3b211e6321a594ba1e6d4da90a00139dc076239f6ef5ae916ebbcd80f2674c8a89016cb91c34da8b685b6b0b055ce4ee50008e800e39cd6cadccc9315e45c8b0e17164796847a129da06de793df39f723a0ad6a26eb510af5a6ad36d88189692d4c419285a1b52cbb9e4b8a233824e79563a1c74adadd6f102dab6112d4f214fba869bdacad40a9470065208e7ff00b51495a05b2cb218928f385b116e5b8b4afd2da3cc2952369012a1e6af93ec9f6a94ca852245c61487640f262f9abf2f68ca9c50094af3db6a4af8ee48a59137586cea7b43b2df8495c954a8cdf98eb461b84a1390338dbfe60719e873578ea0b526d31ee81d52a3c95111cf94a0b7782484a71b8f0852ba7419ab6e591d36aba4562598f26e0a7d4652061c429cc84a81ebe946d48f6da3daadde2c5225aadcec07998abb63c97e1254d929de59759214918e021ce31dc5350dd5e5dfede99515902528495212c3a23a8b4e952770daae9d3be6afc5bbdae5469925898d2e3c175c6e52d3921b5253b963a7500ff535810b4e2995414bb29c719b7c15448a94a7614e508495f2785009201ea371f7358b68d1cc5b74fde6c299f21d8d710b4a0ac272ca54ca5bc0c6327d3bbe734ba374bb5de3de197ed2daa54143cd65f91210a65296094ee29528632428247231bb3dab696eb85abea116b82b4a92cb0da9b08194041ddb003d08f41f918ac0996ad413e2bccc9b84141206d4c76080a505a544ab728919d840dbcfac9ec2b5fa4f429b1dd58b89b89925a4a93b4378dd953c7a951eceff00415aeb89db7d1aff006a91713062ca4befa5d71a59402528750095364f4c8009db9edd6b2ed77383724661ba1c414858c0c028515252a1ee0ed27351683a3e7c7b75e22267a22bb26eabb84594d0f53617e95050f7d991bbfcdf1522816b6e25e14eb280d466e1331596d27000429640c7b00a159922cdb6fb52a3bb155d89f6aa8e9c1cd2b3f54a52954294a50294a50294a50294a50294a50294a50294a50294a50294a50294a50294a50294a50294a50294a507ffd9', 1);
INSERT INTO firmas VALUES ('035159', 'bayron.jpg                                                      ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108004500d103012200021101031101ffc4001c0000010501010100000000000000000000000102030506040708ffc4003d10000103030301050603060407000000000102030400051106213112071341516114223271819115a1b12333426272c1081652b22443758292a2d1ffc400160101010100000000000000000000000000000102ffc4001e11010101000202030100000000000000000001110221416112315171ffda000c03010002110311003f00fb24714b8da913c529e2804fc22969a8e29d4051494122804f142bc284f141228038f3a8d470297093f10fce8e918c0a0703504d8a896cf72e38f213904f74e1413839c646f8a9bc283c73f6a0cd3ee49b0dee334b7dc7ad3395dd24bab2a54778fc23a8ee50ae37e0fa1db43d3839aa1ed0e326568bbaa3df2b6e3a9e6ca4ee95a075248f5ca4558e9e9a2e96383714e409519b7b1e5d49071bfce8d78d580233c534915491751b4e6b993a55d8a5979a88996cbaa701ef904f49c0e763578a491bd4a966069473822a5a89077cd4b48862bc29f4d59da97c2a845134d0063749269e47ad348df9a05276a75724d9b0e124199298601e3bc70273f7ae2ff33d832948ba30a52be109c9271e581bd172adce73b5349354f3355e9d84d07a6dde34568ff1bc4a13f722baad577b5dd9a53d69b9439eda4e16a8ef25c0938e0f49da865777527ca8a4ea3e54510e4fc39e69de14c41f769d4027c694d20e4d078a04269339347cf34103c28049e7c6979e4522463358ed67a9ae16fbf45b65a10975e4342549696d15075a2ea5be94a81d95ef150d8fc345937e9b1c6f8a140806849c8c9acfea6d67a6f4fc2549b95de2a02561b084b814a2a2700606fcd092d5fa4ed4289af28d3fdb969d973ddb7dde04bb4c869f2cab2a4bc907380af77de293e60115b889ad3494d60bf17515b1c6c72a121381e877d8d316f1b2f683b4996b89a2ee5dca0bb224b7ecac21237538e1e848fbaaae2cec220db224141c88ec21a1ebd2903fb56311a8ec7a8353b5245fadc9b4db144b492fa47b448c11d5cee948ce36dc9c83b56b99bcda1fc16aeb09cfe87d27fbd0acdf6a50a44416fd6b6e614f4eb1385c71a47c4f455029751f300950f515b3b7ca8f3e031322b81d8efb6971b58e14950c83f6358fd65ac27d8a621c6ac22e3660df53f29b9290a46739c277c80064f1b719c1a668ebc5bacac3b6f763dc60dbd4b2f422fc6529b6d0aca9480ea3a91d209c8ca8601c78516ee46e3a00dc52e6b9e1dc204c475c5991df4f9b6e050fcaba4ee32298c2359f74ed4a957ba294e08c1f1a10074d4530f5673803eb5e7a9d4b74d65acae9a6b4dcf16fb6d9ba5bb9dc1080a796f2b3865acec9c00495e09db031cd7a2a935e133d776d13fe2364c9b35a1c9b6ed4b6f2fca86cac25c5ad8e5d6d24805632af7491d40abd2af96f8cd95eb76bd3168b7e56988243c4e54fc9714f3aa3fd4bc9f0ab96d96538296909238c246d55563d4568bc23fe0e627be03df8ee82dbcd9f252158524fcc55c23e1a3150cc87126c75c79719990cac614871014950f506b96cd60b2d954eaad16a8703bec177d9da0d8591c12073c9ab2a289a28a323ce8a0e794f18f15d78365c284950402015103819aaab4caba5d20b52912e1b21c40516d2ca8a9b2467a4e4f23e55780735018ac77a5c0d84acf2524a73f3c7345707b35f924f4dce22f9c75463fd9551b8753b5c7e1323d30e37fdcd5a86c05ecb5ffe548a60a87efdd1f223ff00945d52fe25a81a27da34df7a918de24d4ac9fa2c23f5a15aa61464855c6df77b7a7192a7a1a9484fcd4df5247deaec3209c95387feec7e94e4b6de46539238cef4362a98d456b98d75da64b774591b2222d2bc7f51ce13f522b137f0ec0eda74e5c6e6948897286ec36c070f434fa485a339e491903d4d6eee9a7ecb72783d32db1d6f8180fa53d0e8f92d3850fbd6635b683937bb1390225f252168521e86649ef0c77d0728712bf8b39c739a35c6c6e76c789af13d7da46d6bed73485a60bd3a0333a4499cfa1a78a9a2eb4d95a4f42b290090720739adf68dbe6a35ba9b46acb0390e7a474a65c53dec59184e4ac286e8ce38579d51769a9546ed4fb399e857403364c6512363de33803ebbd3caf0d96cf4bcbce8c45da63335cbbca8d3238e9664c66d0db894ff00a49c7bc9fe5208acd5df406a153eb908ba3770794725c0e2a22d639c38120a1cfaa6bd453f11a523d053b63e55e7f62d6172b7cc8da6f53697950e72d0af66541eedd8efb68f14fbc08206e5006c37e2b44e5cad0f27322d33d470721768757c7c906b8fb4c6db4d8e34d49225c59d1dc88523de2e1584f48f985115a9036a27b66c45b2ca6d498da4d2e058c12ec04309faf580afc8d74dbb4cdae2416a3a63777d036ee9d5a00f418555dab834d076a86ab15a6ad4e3a97bba50707f175752beeac9a9136771b04313de427c0287562ac9b3f3a92a9b559dd5e5bf85e84f01e0a6d4927ea0e3f2a1336e4d2097ed0a5e3c23be959ffdba6ace9134152bbf5bdb3d3356f40273bc9654da463f9c8e8fceb130d48d53db3a6ed05c43b6ad390571bda5a50525e92fe0a9008d8f4200ce382aaf44b8c6725c55c76e4b91bac60b8de3ad23d320807e954d1b47e9f811db66dd07d80a01c3915c536b513ca94a07df24ee4ab39a2cb23baeb6ab6dcc04cd86c3eb1f02dc6c15a0f810ae47d0d79b766dd9b6bdd35a825ccd41dad5c6f5685a57dcc1f664b7d049d89592a3b0cec315b8911f505b12a7e35c19b8c740ea2dcd01b5a40e7f68918fba6b2fa7efa35d5c317643f6cb3a9444184ea4a45cc0e5c2be148d8e103048dce46d562e75abf6675c6e0ae9d3d747a6b009065adb6fb8cf905632b23f9463d7356968b7deda525dbadf4cb50392db3192d23e5e248fad5b32db6cb4969a425b6d00252948c0481c003c053b3bf3519d2514ec8a2880726822807de34b40c3b2852ab8a15c8f9d079a2803e74a0520e69c288457229a5473c1a55722a399ed062ba2216c3fd07bb2e67a42b1b671be3340f2ae9492ac048e4938c5797f68b7db32bb47d0cc2e7b2f0665497d4183de10a4b240184e77c9ad7d9ed5226c527524571e94956141c782d95edf12503603d08cd4d7dd2d6bba468cda5b305f86e87e2488c9095b0e0e08db04781041046c68df1b2546bd46e2d47d834fdda5f1b968349c9f559150cdbc6a46992efe051228df6933b249f000369564d77c78ba8829b448bc5bd684fc4a45bd495afea5d207dabb91063a24192a0a71f231d6b3920790f2fa513a8c342b5ebfbdcf66ed769965b5a1904c486233923bb51ff98bca91efe3200e067cf8bf366d46e2f2f6b07db4ff00a6340651fef0bad100052d12d668e9896afdfeafd48f7980e30dff00b1a49a41a4612882f5db51ba7feb52103ec85a6b4a78a60e286d678e8eb1950539f8abb839fda5e25afd7c5daec1a52c1d454609593e2b7dc57eaaab52054a8f845436aa0698b00c9fc2d839183d593fa9a18d35606547bab3c349f30d0ab8a40306a9b55ff825a40c080ca7e431fa53916e86d0c21a29006061c50c73ebeb5dc720e714c273e0686b31da45bdc91d9edfa2c22e879705d08c38a249e9271cf8f151e8745af50f66363ea8e97a23b6d607764951494a02480ae729208cf3915a9594a924141208df22bccf44ca4e83d692b434fcb36ab93cb97a7de5ec8ca8f53b1b3c0215952478827ca8d4ef8ff1aab04e976ebdaf4cdda4990e96cbf064afe27da07052adb0569dbe6083e75a5ac7f68eb871a5582e5264b315d8d701dc38e39d00929575a33fcc8eadbcc0ad8a46c28cdfd1452e4d14427f17d29d45140d5d079a28a054d2d1450357c504514500091b52e7345140879a751450211494514084e2a31cd14514f0322951b5145443c52637e68a2a8334d52b0ae28a282371cdfa7a6a9f57e9ab3eacb3aad7798ddeb3d416dad2ae9719707c2e214374a878114514371e65da3e8c9da958b6687bd6a05ca8a1f4b8cce546c4b6c60a482a0be952ba491d453c9cef5ecf15bee6334cf78b73a1013d6b3952b03193eb45146f9db7225a28a28c3fffd9', 2);
INSERT INTO firmas VALUES ('035207', 'camilo.jpg                                                      ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0001010002030101000000000000000000000601050304070208ffc40037100002010401030301060405050100000001020300040511060712211331415114223242617115235281161724628208338391c2d1ffc40014010100000000000000000000000000000000ffc40014110100000000000000000000000000000000ffda000c03010002110311003f00fd254a52814a68eab028334a52814a528315a5e157b7d90c35c5c6418b4ab96c9c084a05fe5457f3c510d003da3441bf9d6cec9dd6eea3fa6f2492647992c923bac7c8a4540cc4845fb3db9d0fa0d92743e49fad0585294a05294a0542f5e1ef7fcb0ca478bc81b1c96e3b8b5916531bff00a675ba94230f21bd182523ebad7cd51e7b2b263b2bc7ad122575cae49ecdc93a28059dccfdc3ea77001fb31a9ceb95a997a7595ba492459acf1d91961544eeef738dbb8c03f4f0e4fcf9007cec05c8f6acd1bf11d7b6e940a52940a52940a52940a52940a52940a98ea1e7eff0b8ab6b5c15b43779fcadd2d9e2ede53f71a420bbc8fa3b11c71a48ec7fda07c8aa7a86b5b58b2bd6ebfbdbb2eed80c2dbc56119d148deea498cd28f1b0e560893dfd837f550725af4df8d5c63e3979162ec72f9e9221f6ccc343db7524c4799124fc71e8fe00a47a60205d051ab1b78c430470ab3b2a28505dcb31d78d927c93fa9afba506694a50294a502a43817a51f29e796b1baff2f3d149d9ddb61ea63acdc93f3a2c5f5fb103daabea3f076e90f57f954ab0c68d3e1b12eecaa017224be5d9d7b9d281e7e001f141614a52814a528217ab1964c2e4f805e3c0d389396c369daada20cf6779086fd94c81b5f3ad57075faeeeedba757e96d1a949ecf2493393a68d462af9c32f9f7ef441f3e09fdc7075e2cee6ea1e0b3411f7a5a736c64f39ee03b109923df9f7fbd220d0f3e7e80d55f2e8b117bfc2b1397822b88b25772da24522161277595c975d8fc3b884a09d8f048df9d10deb0d311fad2b159a05294a05294a05294a05294a05294a054e7129277e45ccd66791922cdc49086274a9fc36c5885fd3b99cf8f927f5aa3a97c2dddeff00995c931934cdf644b0c7ddc116868348d731bb6fdfcfa0a347fa3dbcf90a8ac1acd6bb9365edb01c77279dbc591edb1d692dd4ab1805d96342c42ec804903436479a0e9e5393e3ec3351e1c417f7b75a8dee459dbfaab651b921249c83fcb53dae41f3e118ebdb7cbc5793f1ee556125ff001bccda656d6294c324b6eddcaae0062a7f5d303fdea73a1d6b33706b6e4f9028f97e4bacbde4ca807fde1dd146a7c9ec48ca2a8249007c6f434dc0f8edbe1ba89cc178e6f1f6b0e52da57c74522c56b37ad6f1194b0ec66daeddd154a8ee3a3a53f742f731c9b8f61e6f472999b3b497d19e7ec924f3e9c281e56ff8a32b1f9d106ba3c2f935f672e7276395e357fc7efec2500c372e2449e262ca9347200032b34720ff00883f22bc73aa18db5b5e9a7537336b0c71e4313cb53216772fb768a464b2129fbdbee564924528db421b5ad01af74135eff899628ec4be3a6b22f25dfa8008e5571d9185f76ee5773b1f87d300fe2141b3a92c7ca57ac39c87434fc7f1ac4fcf8b8be1ff00d577b1d25daf3fce5ac97265b418eb0b88636752627792ed1d428f21488518161e58be89034bf533e36dfa836b1adb38c9e43133bbce3d9a1b69a2010f9f0435db11a1e76db3e0506c33b97c660b133e5b337d0d8585b8066b898e92304851b3fa9207f7aeaf15e4dc7f9563e4c871bcc5a656d2394c2f2dbb772ac80062a7f5d303fdea23a91865e71d4de3dc46f2eef13098cb46cde56d6243e95e37aca96b14adad052d1ceddbb24846f00e98678de265c075f727696b71671e1f27801796b616f1a422d9e29a38e4fe5a0d104bab7a8da24b151b0a741e9d4a52822bac0e22c161e5236b1f21c5b39f855177192c4fc003649f802b3d4e324790e13711c8e8f0f27808ed3aee0d6f711b29fd0ac8d5c9d4ec5479d5e3f86b99654b2bfc8dc5a5e089fb59e193177c8403a237b607c823601f8a90cf5b73ccade61eff0094a4785c671430e4721776d324d164e68e74f52448f5deb12db24cc41ed60d37680fd81983d787b5705bde5a5c58a5f417504b68f1fa8b3ac80a14d6fbbbbdb5aaeb7269e5b5e3793b9b7bc4b29a1b39648ee5c12b0b0424390012403e7c03edec6a47a43c46cf1bd10c4713c849fc4ecae31ceb3874f4fd48ae0b3b4640627c2c85760eceb7e37417a8cb222bc6c1d586d594ec11f507e4567e2a27a8d670637a29c92db0d753da478bc2dd3593db4da6b736f13347186f7d218c268f9d0d13bd9aeef517397967c2e5b9e2b2dadce5726d1da619c4a0a3cb310a92a901bb9514b4c7408ec8d89d00480a08efec25bb7b38afad24b98f61e159d4c8baf7da83b1aaec8a8ec174e78e612c30d1e3e0116431732ce728b1afdaeee42184ad3484167f5449277024805b6345575dbcdf2618cea2719e352b44b1672d2fda3da31769a010ba8047803d36989dfbf68f3bf0429e95c5757105adb4b75753c56f6f0c6d24b2cae1123451b66663e14000924f802a4307d4be3198ca5a59da9c9c305f471b585f5e63a6b5b5bc790332c71492aa8672abdc07e6076bdda3a0b4a560566814a528152fcdfed18a30f2ec6e1e4cadee36192096d6162269ad652a5d63fcbde1e389fcfe54751e5aaa2b1aa0f21b9ffa88e9fc704cd05b7249e648cb2c3fc22452e7474367db646b75c392e39cb7ac3c6ef6e390cb73c5b097766e98cc27a87bde52371dc5d95d160240ac231e3480fe6af650cc24690121d942b30f7206f409f903675fb9fad60ec9dd042b75378a626cae6df3d70f87c9e3a3edbac6bc2c650eb186ed8bb46a45208ec65d06d8d6b75aee9fe0f3592ea0e7b9be72c2eb1561732aff0009c65d684aacb1081ee654fcae550841ee1257fea35e9ab248a34aec00f806be450790f2bfb5719e17d49cee431f7053f8fdbe431f1fa7ddf6a645b2108d0f26369a308c47903b88f6abac5aba751f2c8ce4a8c163405f807d7bfd9fefe3ff005549af20fd0823f423d8d6be0c67a5c96f333eb6fed3656f69e976fe1f4a49dfbb7bf3bf5f5ad78edf9df80d7e3eddd7a919dbc3f824c363221e3e527c813e7ff20af8cd4171173fe3b9348e16b76b5bdc748ccfa75697d1997b47cf8b56dfd3554753dcc0411e538b5edd348915a667bbbd5490af2da5cdba06d03a05e755df8f2cbe6839ad31ef0f3aca659a54ecbbc5595b471fe62609aedd9bf51fea107e9fdc575f9595ff0011711451fcd39691ce97cfa62c6e8124fd3b993fb915cdcc6d32cf65164b8f240f98b170f0c731545b888b2fab6ecfdac503aa8d11ad3a464ec290753c0b92de731b9b89aff8b67b8f1c5144ecbfd4693dcb07593b029fe6220d00e7eeb7a9bedda8202d294ac504fe760b9bce65c7218e748eded3ed590950aecc8563102807e35f6927e9e3f6ad9722c7265f8fe4b1128668efad25b670ae5095910a90187b1d1f7f8aebc53dcdcf2b91228edcd9595afa724cb2ab3b4f232b7a4540ee4ed44473b23b84c87475badb6f441a0e2c6ded9e42d2d723653c7736572893432a7949236019587d41041a8fe379b4c0748b17757c63bbbfc763e0b19eda19143cd9044589ad57e3d469818c0fa91f1e6a938c6261c0f1cc6e0eda4924831f6b1dac2d2302e52350abdc40009d01bf03cd69b29c0f0b91e7161cb2e24bbfb45938956cd593ec92ceb1c91a4f24654f74aab2101f608ec4fe9140eae82bd20e66a4f71ff0ee43675ad9fb349e6b42b88bec45b7497157fd892e3a75b6b844936a264c55caf83f2076bf9fff006ae7916362cc71ec961e744786fed25b591589019644284123c80413ede6b5fc9adef72789c7e56c714a72965750dfdbdade38578c905264da3767abe8c9320258a066049d0dd06febcf7abb0d947c87a7b93b8481278793476d14ee3efa89a0997d353fef71178f9217e9569c7b2d659ec15966b1d27a969791092327c11f5561f95d4ed594f956041d106b8f356d8dc849698fbc6b3374b3477b6b1cc15a40619518c88a7cf8f0bdc3f0f78fae884cf38b66e41cef8c7197b9518e804d9ac8c219834de83c4b6d1b6bc1432ca5ca9d86f435543cbf016fc938ddc6166b9b8b31218e482e2d9bb24b69a375922950fc1474561f5d6bd8d6bf2705ae3ba83639dbb7644bdb138b8e42da8e397d50e88de3c993642925403185fbcd228aa7a08ee8c720caf25e9ed8dff208d21ce4535c5a64e155ed315c433bc6c0afe524286ed1e0776878d559544f4bb1c71593e7766673329e552dca92bdbda27b3b39ca81b3ec653e7e4ecfcd5b50294a50294a50294a50294a50294a502b8aeade0ba8845710a4b187493b5c6c77230743fb865523f502b96941834f3fad66940a52941c16d696d6d35ccd6f6f1c525d4a26b8651a32b84540cdf53d888bfb28ae6acd28302b34a502b1aacd2821794f4d6c32991bacb6133b9ae2996bb545b8bbc4dc98c4c1493f7e3fc2cde75ddefe056e787712c7f1a8e59927bac8e52e96317d94bd90c97374c88141663ec001e14781bd550d283a39cc55966b173637211b496f2f693d8e55d1958323a30f2aeac15958790ca0fc579d4fc63ad96ae2d713d4cc24b630a2c70c991c387b970aa06e46034cc75b27e7dcf9af53a504974c38b0e258ecbd81bcbfbf92e7286ee5bdbd7ee96ea46b7815e527f56561a1e06b555b58159a05294a05294a05294a05294a05294a05294a05294a05294a05294a05294a05294a05294a05294a05294a05294a0fffd9', 3);
INSERT INTO firmas VALUES ('035214', 'edwin.jpg                                                       ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0001000203010101000000000000000000000506030407020108ffc40040100001030303020404030603060700000001020304000511061221315107134161142232714281a115233352629116c1d11724344344a253568295b1f0f1ffc40014010100000000000000000000000000000000ffc40014110100000000000000000000000000000000ffda000c03010002110311003f00fd974a52814a52814a52814a52814a52814a52814a52814a52814a52814ad1bbdc22dae1bb367494478e80372d471ebd07727a63ed556b65eb516a805fb3b69b65a547f75324b64baf8e39420f4041ce48f6f4a0bbd44ea3bd5bec705532e0f04233b508032b7147184a47a9a82d58ab969b8133530bfbceb315b4a9d89276869481d4271c859cf07a93815e74bda645ee7b1abb50b4bf8929dd6f84b0764341e8ada7fe691c93e9d2837a47f8ba7c64b911d876b715c84b88f376a49c8cff0056339f4a92d2f2e74982ea2e49684b8cfa9874b59d8ac60850cf7041fbe6a49dd89492a2123d4f6a87d1416e59953d649f8f90ecb467a86d6a251ff66da09ba52940a52940a52be28e283ed2bc15e0655848f735a66f16e0ad86631b88240dfd7141bf4af0179191823b8e944ac93ca48fca83dd2bceec72462bd0a052bcbae21a696eb8a09420152944e0003d6ab32759c544b288d6cb94d8e94294b92c30548183fa8f7a0b4578dc4272703dea36c77eb7ded971cb7bdb8b4ac38dad252b476ca7a8cd46416ded46ebf326b99b48736c26104a7cd09382e28fa824703a63ef41654ab3d0e47a1142a3d33cd56ac90a3d8f51bd02dea50873985494b25454969c42825653db3bd271ed5a57cb84ed437c7b4d58a518ec30317498919d80e006907f9c8cf3e98a0cd3b5838ecd91034ec037793186642c2b630d63a8de7aab85703b55b185296d256a42904804a4f51c74ad6b55b215ae0b50a030961868612848fee4f727d49ea6b6fa714057d27150da935045b1c76cba97244990bf2e2c66465c7d7d80ff00e4f4158356ea445a10dc38cc1997697f2c488904ef273f3288fa5231c9ff005ac5a634ea98966f77958957c7d1871cea8613ff0086d8e800efd4d046dab4ccfbcdd937fd625b75e47fc25b9b595311411c923a29678e7a74ed576524019039a6c1fe9ed55df106feab169b79f64a7e364284786923abaa24027d8724fb0a0e6fe355c266a19cd58e0a1e55ba34a0dc871b1f238f01b88ee762704fa75cd763801260b040c0f2d3819f4c55334069f61e613707d0b5454b4a66225cfa9c0afe2bcafea70faf6e3a55e80084ed18c5043eaa90afd9a2ded7126e0bf87463aa411f3aff00f4a727ee054bb08434d25b6d294a12025200c00074a81b579973d492ae0e0498b0818d14839dcb3fc557f7013f91ab024048c0e941f694a50294a502b46f9728768b63d709ef0663b29cad64f4f4e3b9c903f3adeaac788969b95e6d11536754754b8739a96969fcf96f6ccfcaafee0f3ea050465b205df562d9bbdf5d7e0da55fbc8f696f282e2739497cf556463e5e9ed567b93b6eb5da5f79f69b4456d1f324206143a018fd2a9a9bbea876daec9d512ad3a5e3257852d2e6e5a93d307713b7efd7a573e735edcdb9df0e9b7cdd430a0ca5a2d8e2f3fbf74a8f945df55e3a0c7b507598d7745b6db1ad9948b93ad177ca59e23a544ab2bec120f4f5da6b2e958a5c94e5c7e2ae6f254148065b8adae925277210784a460e0e3d6a97a474e6b661f9174bec0833a5c9525f579f2380bf748c0f94678e839c62aefa9ef52ad1a7da2a0c8bc4c526345681252a7d7c7afe11c9fb0a0ccbb9c8b86a255b6d6b4a5b82b419ef14e41c827ca1efd09ed538925239a8bd336a6ecb686a0a5d2ebb92e3eeab953aea8e54b3dc93fa5446a7b8df0419d71b53ec4587012a512e27729f29cef1cfd20118cfde82c9718ed4f82f427bf86fa0a178ec7ad6c250123680027d001554b6dee6ea09b1a5da1d69bb525e48528a7779e0056fc1f400ec03dcd5b370ea78a0a8ea56916dd6b62bab09285dc1e3025f9671e6a4b6a520abdd253c1eb8e2b5eea2e31ed560d296c58853253086dd71bffa761a4a3cd523fab94a41f7adad66b4bdaab4943dd83f1ee3e47b36c39cfebfa8ad6d771e33f7cb0ed997262e4f38b659f817420a9a2029d2ac83f28d893dfa7341197f92dd925a9ab12e439308f818de6ad4e24ca7d492a515124929420acd5c74b58e3d82d0dc06145c5ee2e3ef2bea79d572a715dc93fa62abe23db5ad776eb5b3e5b51ecd6e725149512038eab6254493f5612be4f277560720cbd60862e48d4d3eccb4e1d621c37d206c39d85e1824923923d3a505f7775e3a540eb0d442cccb31a2c7332eb315e5c48a9382a3eaa51f4481c9355ab9f89b6db568b8974712b9b3df29650c3636971dda0aff00219e7df8aad682d505b9eabb5ce1487aef3da71e96eb8e70d328c8436d8e89ca87e7cfb50749d2f62fd9c5fb8ce52645e669df29fedd9b40fc2848c0c7ae3279a9c0a09c1dd9cf03b572bb46b2d533d52e5c95458ac06de0db410094ed591e69fe9002867fa6b59a95a811a76cd759d3a4c8901f2e4665c5602d014545d73fed03d00341d4af379b75a22993719088edfe1ddd547b01ea6b974b717e22f8909890dcdd62b424a1d7124fccb3f5e0f7236a7edbaa0f5039798da5ed5729939f7f515d65036d6559514216afa40f42ae3f2241aeb5e1f6978fa4f4dc6b63452b74242a4ba138f31c2393f6f41ec0504fb0d371da432ca1286d29094212301200c003b0c0a88d55715c78ecc0884fc6dc17e447c7e1c8f9967d80ff002a9692fb4c32b79e5843684952947a003ad406988ef5c24b9a8e6a54971f05b88d93c36c03c1c77575fb628262cd6d8f6ab7b10a3021b651b413d547d49f726b7294a05294a05294a0f8ac14919aab6a1b3dca65c1f952f543f02ccdb4141a8e034b6d4010a5173d47ae3daa6ef374816880ecdb848432ca06493d4fb01eb5514899aa146ef7906dba658479cdc5755b5520279def76471f4fdb3d28206d1a3ecd7d989bc4c69f55aa30e244e78add9d839debddf4a3ed8cd6ac3d4f6f99ab3f69c7b4bd26c368259b788ade186be6dab7c24707b0fbe7ae2b5f593f7dd61654ca694ab6d92449442b5c50362a4ad4bda95b98e8900138391c74f5ab95b20449cfc3d3b682469fb2292641073f10fa4e528cfa807e751f538a0c7a9ee7a9adb7cde85f956e1223a1a25a49429b241754b51e7200238ef9ad1b5de99d4b7fb85fdb01c8f684166d0d67e579c51292f63d7240483f7adcf171d7de4c0b3da98549bc4f2b65a48e430d2865c78f6c6ddb9eca3501aa6c7a8e1c9b5c4b53121d4b70d7b998e70db49687c801fc4b254a3cf5511da83e6a5d577a96e2a1db6e2e336f8ad792fce61b4ee7dec8c948c7ca3851e31c66b6f585d6e6e68589054ea5995a9e686d0509004661d50ce3dc8e727272a35acd78657672de987226b686516f59521b563cc98bce41c7440f97efd7be77afda6673da718b03f3448d4731c696d4a6901288486540a56948fa129191818c951fc825adf788f63b7ae1d96d8ec9b6406cc76760090a534ac3ab2be9b46464f7dd531a66f722fba75e9cc263a6424b8da3c973cc694a48e0a55ea391fad6b685d2f22c1a7c5a2e13d9b834949425b0c042307eadc392a2ae73b89ad6d532d3bd8d1ba7d2d4475f4e5f7194252dc263a1571c051ce00fff006839cdab50df7534c45c2dd2b74db733e4a4bada77236a77c970e0719504b6318c838f5ab046babd71760eaa9933e017736f7b437e44686cfcee049fe6717b47d881527ab8e99b0dae269d82bb7db85c3f7326420a52b44648f9d4a5279c9e139cf557b556ed77ff000f6dee7ece9dbee8cda66b8bb538cb4a75296d63714707e609248f9b3e9418e2c39da93566a18d3997d8767b51a5426544b5e630d2c254dfb020e4a7b9af1e28dc069771896c42b6da24a52b6223319216f2c2d052a5acfa048ce07750a90d677a1ab5b8ef59f4f6a84c88ea52a2dc631f2148dc0020e7f09183552b359f54ea5bcc4bd43d3264458af15b6e5d1ecfc43a158dcb2319030060003e5e879c861d29a7f525de72ee6ed8dc4fc1a99830e3ad1f2c72a0165441ebb5382a57758ed5d12cba1ae4ec8b9adc28b6212531a27968e55b080a7c8ee79dbd8e0d6f891e2d29c5a8dab4e3691f4a7e216a0a1cf5edd7f4ac296fc5d73054fd91ac2f3c10723d7d3dff004a0f6c6869864a5a754cb30dd7fc9790851ca6135fc2692463ebc052f3efdcd7abbe96d4375d4cfbf2dd6516d7de11f6257fc3889482a03d429c5718f4c67dabcb6cf8b237854ab2fd594ab1c918e9d3be2b4eff007bf146cd6a71f976bd3ef8252d34a43eb0e2dc59da9013ea7247141abe1a224eb0d7170d63363845bedee2e25a9a50e1047cb94f6c27f559ed5d69c5a1082a5a92948ea54700573ad057c72c51edba5efd66976b90b25a62438029a94e925470474393ebd6ae57cb241bd34d33704bab69b5eef2d0ea9095f1d1401e47ad04321f1abe40115655638ee7cee0e931693f4fba011cf7ab6a46138e9586147662b09623b2db0d200086d0901291d801c567a05294a05294a05294a0a7db745b09bd7edabecc76ef392e294c07bf811f2491b11dfa7527b8c578f1552ebf6ab5dbd4e8660ceba331e7b99e8d1c9c67d01504a7f3ab9e05609b1a3ca8eb8d2996de65c185a169c82282b9ae34b9d456781061cdfd99f052da90cb8ca7e8d8149c240e070ae3b54b69fb340b159d8b55b99f2a3329da904e4927a927d49ade83199891511d8494b68e120a8ab1f99acaae0505174a498f26e176d6335c425125e544805472a2c36ac7ca3fa9609c0ff3ab9c571c71bcb8d16b27e5493ce3d09ec7daab9a4f4641b03c9744b973dc6505b8e6428111d3939084800027a1575356a007a0a0f8b384e7b5545c5dd2cb0645ecd9e4de2e936404aa332b014cb233b1009fc29f5eea593eb570c53141cd27dd3c4dbc4671169b1c7b2b870a6d725c056339ca4f51d39e9d7151b61f0d1f11e53fabeeb2dd5b854f485b53006d67249246dcf4f7ef5d7303b0ad7b9466a643722bc9dcd3892958ee31cd073cd09e1f698fdedf1eb1a0892eef84892b539b18da3612144f2ae4907a67157c836ab5c0c9b7db614327a96184b67f415be90027000007402a2353ddbf65dbb734df9b35f506a2b23ab8e1e83ec3a93d81a08dd5ae3b7852f4cc0716971e48f8f75b51063b07a8cff32c12001d393e9562b6c58f060310e23496a3b28086d03a048e0569699b5aedb00892f09335f579b29fc63cc70f5c7648e807a0a95a052b964cd7facae12dc8fa5f463ce21b7d4d2e44ac94f07015b41494f43c64ff00ae15699f15afde73579d5d1ed318ad2a4a2120294ae4e4050092903f3a0e9f2a5c48a952e4ca659091b95bd606077e6b95eb5f11b4fa754c1f266353e3dad0b9250db984b8f905081939c948513f7c1f4adcb9f861a661c29578d453aed7d2c4725499928e09483800a70793d324d49f875e1d69db2d8637c5d922bb7079bf32479ed8736295cec0159c6dcedc8eb8cd052ad7ae6d977bcc6bc6a9b9bae7c1afce8b6b831cb8db4a2061c59eaa23191fcb9ec40173ff0069b1a5a928b169bbddd1c3d5218f2f1f99abadbed56c80a2b836e8715646d2a6584a0e38e381d381fdab72839faf546b89a52ddb3423b157f8973e4009fd056296e78bb29250cc2d3b0391b5c4bea5903d783c5745c0ec298a0e7b1acde29bcd0f88d616d8aaf5d96f4acff90ac6ee90d7d29f4aa6788596d38e18821b3c1cfa1c7e95d1a941cf8e8bd51b1bd9afae1809015969273c751815b49d2fab196ffdd75d4b0bc000bb11b5a7fb62aef4a0a3ff0087fc41ff00cfad7fed8dd2af14a050d29401423230694a0f9b457da52814a528142334a506b4b92cc565d75f752d34d277294ae8077a83b2415dcef0352ce0e0cb7b2030b18f21a239511fceaebec38afba9ff007da8ac301df9a33cf3ae38d9e8b2846539ef83ce3a74ed56140c9c9ce47bff00f7bd0788a5e5070bcca5a21c50480e6edc9cf0ae8304f6f4acd4a507c201183cd368eb8afb4a0ae6a1426eb7983635a816107e325a4752842bf7693eca5fe883562da339c73dea134f80bb9de9e572e7c7f95bbd7625a4103ec0a95fdea72814a52814a52814a52814a52814a5283fffd9', 4);
INSERT INTO firmas VALUES ('035224', 'fernando.jpg                                                    ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0000030100030101000000000000000000000107060405080203ffc4004d100001030401020303060907080b000000010203040005061107122113315108224114151623326152577176819495d1d317365674a1b4b518343738539296b324253342546291a2b1c2d2ffc40014010100000000000000000000000000000000ffc40014110100000000000000000000000000000000ffda000c03010002110311003f00f6568d1a34e8a05a3468d3a28168d1a34e8a05a3453af9140e8a29503a295140e8a28a028a28a028a28a0e064177b7582c736f7779488b020b0b7e43cbf24212364fdff9077351db5dcb95796263f7cc4f225e03870525bb73b22d287e74e001eb78a1dec84157603cc81bae7f27a5ce44e57b4718b0e25ec76dad26ed9636101487405a4c488b568e8ad692b28edb40ab0a5294212842425291a000d002826bc3b7bcb1bc9728c0736ba3379b9d8d51e4c5ba37183066449015d05684fba169536b49e9ede5e9b34ba99c0d23da9aee94e921cc2a12d7aedd4a1365004fa9d76aa58a07451450145145014514503a2a44ee6dce4971494707c05a41212afa5ec0d8f5ff00b3ae2dcf9079c20db654d7b842dedb71d95bab59cb58504848249d06f67cbca82cf4542f10e51e6ac8b16b65fa0f0b5b65c59f1512197d394b2d0712a1b0a0852094efd09d8aed7e9c73a7e23207fc5ec7f0e82bf45483e9c73a7e23207fc5ec7f0ebbac2b28e54b9e44c43ca38b22582d6b4acbb39bc89a94a6c849291e1a5009d9d0f3edbdd0516be7e14f669507e535721b86fb91594bd212da8b4da95d216b03b249f86cf6dd497e9bf37fe27a17edd6ff0075587628a08f7d37e6ff00c4f42fdbadfeea0e6dcdff0089e83fb79bfdd561a5bef41e7fc3792b9c2e6f5fc7f2656e9e21de1e88026ec86be4dd0847d51edef91bdf5fc7abeead07d36e6ffc4f41fdbcdfeeaefb857fce33dfcf099ff2d9aa16cd047fe9b737fe27a0fede6ff756b38defb9e5e1f9c9ccb0b8f8e36d250632dbb826417892aea1a03b6b43bfdf5b4d9a280acf723e596cc1b07bae5777594c3b731e228049256a242508007c54a5253fa6b43529e634fd27e43c138ed6952edf2a53b7bbaa529d85b10fa4b6d2c6b5d0b796def7f8007c6839fecf7884ac6b0545d2fa5c7b29c8542e97c90e9dad4fb83a837f706d242024761a3af3aa37df4cfa564b97b30560b804fc858822e135b2db10a1f89d064c875c4b6da01d13dd4adf61e40d04431ee6ee32473e66395ddf3b86d5bd36f8769b527e46f7d6368dbae2b6104f675c5a7b81f1f8689a0ff949708ebf9fb13f5491fc3ad3f0c618ac238d6d18fcf75332e2da16fcf7cfbde249756a75d20fc475ad407dc056c3c163fd8b7fee8a0948f692e11fe9ec4fd5247f0eb3d8b7b4be1aed824c9b9b9769f291367061502d0f29b7d84c9744728574eb65a0def7aefbdeaaf1e0b1fec5bff74562783529fa08f7ba3b6417bd76f2ff00ad65d0656d9ed39c2f320b725fcb7e6e755b0b8d2e13c975b2091a504a5437dbe04d7247b49708ff004f61fea923f875d9fb3a34d2b88ed84b6827e573fb948ffc6bf5bd996f813632e2cc83164b0e682da75a4a92ad1df70468f702825ffe525c21fd3d87faa48fe1d15bcfa1b887f456c7fa835ffe68a0efab819130dc9c7ee51de04b6ec4750a00eb60a0835f778bbda6cd15326f174856e614b084bb29f4b492ad13d20a881bd03dbeeaebee1905864d8a53b1af76c79b7232ca16dcb4292a1d27c883de8323ecb8fbb23d9ef0a71d20916c4363435d924a47f60154aa927b2cddad4c7b3e61ad3f7384d38981a5216fa411efabcc1354e45e6d0b574a2eb054a3f012104fff00341cda2a656ae78e31ba6431ac706fcb7644a982147704573c075e2be84a52e74f49dabb03bef5a2ca790f10c6729b56317abb2635daecb6d1063784a5178b8e7869d1035f6bcfd3ccd06ae8acb645c878563b26e31efb91c0b6bb6d6d97252642fa7a12ef5f87afc227c35f61b3dabeacbc83855e7119196db725b73f628a54244ef17a5b68a75b0aead107b8ec7cf635e62834f4ab0dc77cb580e7f3ddb76317d4499cd35e3aa338d2da73c2f77df01406d3ef27b8f5ae973be65b7daaf6c62f88d9e565d93bd31e8aab744506fe4ea652da9c53ab5764a425d4e8f913b1f0a0a9d31e7595e29cb559c6090b2476d8eda9f79c7d97e1baada98719796d2d24fa8520d66dce7be296f23f98be96475be24263a9e436b5474b8a20005d03a077206f7aa0e670aff9c67bf9e133fe5b3542ac3f19252de4bc8edb694a10328490948d00556c80a51d7dea5127d4927e359cb5e7b9be7fc670f2fe33b4da90fbb364b2a877771402da6dc5a12a0a4f928940ede5ef79f6ee15ba2a59c51ca378c8734b960999e24ee3393408a2606d2f879892c75f4171b58f8756b5bf307ee3552a075389bfeb3567fccc9ffdf61d51f46a0bed1d9f63bc719e61d9baef31dc9b08c9b75c2d2c2c2a44986fa428ab5bf77c37596cf7d6f67bec505da4bec458ceca94f36cb0ca0b8e38e282528481b2a24f6000efba852ef78fe759b5b392728bec3b1e018fca2d6382eb21b8cd5d67e9c0b99f59ada1207d577d92852b4076a71ad998f3ab1687b35b1bf89e0cd84cc76d2266e45e5646db4bbd3ae86003d4524ec923b02011a29967b2deb9c1fc4ef16db74fb0db71387220da24c669c8acb8a9325b2e21a52480a086d08047d94923e341bec6f28c672669d771cc8acf7a6d9574baab7cd6e4041f451413a3f96bb7a87f376038fe198b4ae4dc0adf6fc5722c6a3aa536a80ca23c798d020b91df6d0025c4ad2081f1048d1dd736f1cdb70839cc8c3a2f1a64775b988e89d10445b5d3221a8767f6a50034ada08f5141b8e3acb2e594b97c6ee588ddf1d55aee6ec364ce6d41335a4fd97da2529da55dfcb6076ee775c3e0dfe623ff009c17cff15975ceb366f6e9d9340c565c39b6dbfcab2a6f0b84fb60f82d1584142969253d6951d100fc2b83c1bfcc47ff00382f7fe2b2e8387ece7fe88ad9fd6e7ff7d7ea895e7fc6a564dfc8a61362c4ef29b25c2fd934c82ab8f8297551994bd3a438a42140a4a8a63948dfe17e9aeff12959fe059fd8b0fcbf22465d67c8449441b9aa306254690d24bbd0e807a5485202b4477053af2d505868a545067f3ac2715ce6dacdb72bb2c6bac565df19a43c0fb8bd11b04771d89158e3ecf5c385050307829046bdd71c1aff00dd552a079d079bfd9db85b8c321e12c56f579c461cbb84b87d6fbcb5ac15abad43674ad7c2b99ce5c2bc618f70fe577bb36231225c21db1e763be852ca9b504fda1b51ee2b6deca9feaef85ff50ffeeaaa5bed34fb2b61f6d0eb4e24a1685a4292a491a2083e608a0f37d8255832fbedb32e7e7d96c5c4f803a05a41e8426e135b6c27e507a80096db2be9401b256927e3a1b1cd6d8c49f6a4e37bc38965f6dcb25d0470a46ca16d868f58df96c3da1f1f3aecdae02e276ef82ec8c4a38507fe5023171663789afb5e093d1fd95afba62b0ee19b5832a71f75122c91a5c78eca00085091e10513f1ec1a1ad7a9a0995e711c7320f6bb4c9bd5a589eb8587b32d84bc0a901ef95bcd85947d95109510360ebcc68f7ac67385bd9b27216610adb6a7e5daae562b4e4175b64367acbaa8976652eb886fececb09575761be904d7a1138c5b539e399a02f7ce6e5ad36b3eff00d5f829754e8f77f0ba947bfa51f45edbf4f7e9a6dff9cfe6bf9afedfd5f83e2f8bf67f0babe3e9410b5f23e059473cf1f4dc3a2bf263c06e6c7b84d66c525b5301d6d0d466d4a2d8d3656a56f63a53a04948dd6cf8571cb543e58e56bf370ba6e2f5f5b8e6428924b462b0ef48f801d6e28f6f3edbf2155defeb5f294210a5a9284a4acf52c81aea3a0367d4e801fa05079f2eb36ed0b8ef9bf104bb3932ad5365dc21aa33450e889387ca494148f7b4b5481bee7435f0afdf25cbf836c9c122cb6118f64501d8288f6bb136e254fdc5d0a4a1b49481d6565ce92a56ba81d93deaf810d8714e7427a949092ad77206f43f2773ff00a9acb59b8df00b35d1574b5e1b638934b9e207db8480b4af7b0a49d7ba41efdb54196f675897d871b366b257d976eebc8d2f4a0cb7d0d32b72db057e0b6367eadaeaf0d249d94a013deb049b94af67ae589512e8a793c55933cb911241d293689cadadc6f43b86c9075b1ad14e89295efd2012904900024ece879d71ee30615ca1b90ae30e3cc8ae0d38cbed8710a1f7a4f63411ce2cba47e49e72bdf2658d04e356cb48c7214b5288f9c1d0e87dc7109201084f504827cfcc7c40da72cf29629c65061bf91ae6b8fce52d30e2428c5e79f2800aba4761dba93b2481ef0f5ad7dba0c2b6c36e15ba1c78715a0436cb0d25b423befb252001debf55b2cade6de5b2dadc6b7e1aca41523634747e1b1410b45c39c7951a31a2db11c5d8cc8eea9afeddbb948093d284752437d47a86c8d81fdbdb46f66ee2d8b854ec7d9b221e9b3212a32af133ebe625652407828fd950277a4f483ad6b5daac44ee95044d95fb4ac0b726c31edf81dc1d68782ddf64c9790169f838a6123614076d027b8de88af9c9b8eb3db443c7334b35e11977205896e372dd9086a10bb4375654b8a4e88404924a3b809da8fc6adfaa541e7cca73bb972edb2071f59f03c8ed522e335af9f5cbd5bd4d336e8ecba1c73defb2e2896c2523637d5df44e8506e7684b1ed1b61bf34873ae662b3e1c85689404b3262adb1e80edf77f2ebeeed42fd34e83059363728f3462398c067694429b6ab9282093e0ad21d6893f001c6c8eff001700f8d7ebc1bfcc37ff00382f7fe2b2eb715c2b25ae05960aa15b638623aa43d20a0127eb1e756eb8aefeab5a8fe9a081596f50f18e21e39ca6ea9922d369cb2e0f4f7988eb78b0dad373612b52500aba7c479b4ec0ff00bc2bb891c898a72273371f41c2ae2bbd2ad6fcd9f3dd618586a33262ada495a9400d95b89000dfdfad8dd6b11c7adf8be3cd58ad81d311a71e7121d5752beb5d5b8a04fc7bacfe8aec21c2870c2844891e385ebabc26c23ab5e5bd507ef453a280a05140a0987b2990af677c2ca483ff0040d763ff009d754fa997b2f436adfc2164b7c7eaf062bf3586fa8ecf4a663c91bfbf42a9b405145140514514051451405145140514514051451405028a280d5314b669834051a14bbd3a05aa28f2a540e8a28a028a28a0281e74f43d28d0a09d7b38ff00a22b7ff5eb87f7e7ea895c3b2daadd66b78b7dae1b30e225c71c4b2d27a52952d6a5ac81f0da94a3fa6b9ba1e940a8a7a1e94687a502a3f453d0f4a343d2817e4a55f5a141a05453d0f4a343d281514f43d28d0f4a05453d0f4a343d281514f43d28d0f4a05453d0f4a343d2816cd1de9e87a51a1e941f34e9e87a51a1e940a8a7a1e94687a502a29e87a5141fffd9', 5);
INSERT INTO firmas VALUES ('035230', 'frederick.jpg                                                   ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0001000203010101000000000000000000000506010304070208ffc4003a10000103030302040405020309000000000102030400051106122131410713225114324261152352718116333491c108254353626382a3b1ffc400160101010100000000000000000000000000000102ffc40023110101010001040201050000000000000000011121415161f0023171128191a1b1ffda000c03010002110311003f00fd974a52814a52814a52814ac66a2b51ea2b569f8e876e7252da9d56c6194fa9d7d7d90da07a96afb01412d4aad69efea19f3c5daef9b6c629223dad0a4ad401fadf58ce5781c251e94e4e4acf22c8734359a5074a1a052b5bcf2196d4e3aa4a10919529440007b93588d21992ca5f8eeb6f34b194ad0a0a491f623ad346da57ca95b467155f87acec33351aec11a4b8e4c42dc6b2195f945c6c24b880e6369524293900f19c750453ec58a943c8ac01824f73419a52940a50d6a5c8690f21953890e2c1294679207538a0db4a52814a52814a52814a5280694a8fbddd63d9e199b352f7c2a5403ae36da97e50fd4a032768ee7b753c7341204d7ca9400e6a32f77eb45a6d26ed3e7b4cc248c8777642f3d0240e544f400649aac262ea5d6880bb8aa469db0afa436965336527fee2c7f6927f4a7d5824123a50fcbaef3ab9e7ee4ed8b48c56eed7668e2438a511160e78cbab1d4e41fcb4fa8e3b0e6baf4d6964409cbbddd64fe297e75252e4d713b43693ff000d9473e5b7f6c927a926a62cf6ab7d9e03702d90988715b07634d2025233d4fdc9ee4f26b5dfaef6eb1db9cb85d25b512323037ad58dcaec91eea3d80e4d5de385fb6cbcdca0da2d726e3719088d123365c79d59c0424557746dc754dfae8f5e65c76adba7dc68a214379a5096e1dc0879c39f402376118ce0827078ae5b55a6e1ab2e11efda9a32a2dbda5076dd677324a55d9e7c1032e72708e88ef93d2f09480300629384f0ca738e68a3815915157fb8b919b662c3f2d73e5afcb610b3c7ba9471ced48e4ff1ef5041eacb32f55de60c6766edb1db9c2f4f8a1292263a305b6d791f2271b88e8494839e71abc208e1ad2efcc69bf262cfb94a971590004a1953a437b40e025494858c7ebaceb75c883a718d3b6a7fcbb9dddcf818eefd69dc32f3e40ee946f567df6fb8a9c9722d7a534ba54521883023a1a69b4f5c00128427dc9e00fb9a9b92f63ed1baf2f9f0acb56a892da8b2a4a4baec97140221c64105c7d44f0303d29cf5511ec715ef09b4bc64b8352b51170e106551acb1560853718a8153ebcf25c7880b24f44ed1ef5c7a4edd275b5cdebadc4a5db417838f70364e710708653faa3b5cf3d1c5951e839f5640da9c6315ae7e3fbadecfaed41cd29510ac1501d6b0a52402735e7f77badcb586a097a52c0fbb0ed90941bbbdd5b242f76398cc1ece608dcbfa41e39c1a73d0f293b8ea79571bdb961d28d3329f60e274f70e63c239e5071f3bb8e420631d491d2a72c9686ada82b2fbd2e539cbd25f56e71cef8f6091d92381dbbe76d8ad36fb2dad8b65b2235122474ed69a6c60247fa927924f249c9e6bba9e205294a05294a05294a0529434024555f556ad8d6a98cd9a0c576ed7d94852e3dbd8500ada9e0adc51e1b6f3c6e5753c0c9e2a7ee2894e467110dd43320a708716d95a527dc80467fcea2f4a698b669d8eea6221c7654973cd9731f56f7e4b87ea5abbf5e0741d80a92f71e6cc69d7347dfed3a9756bb1e5b1224a9a2db5bbe0ecaf3caf4a99493c2493b14b232320fa466bd8d38da3b546eaab3c5bfe9f9b66988dcc4b64b6afb13d143ee0e08fb8aaee8dd5494f8696fbbde1e52a4b2d98af909cade90d294d101239dca520903ef5778cecbe562d4f7d8160b439719cb7362484a5b69056e3ab3c04213dd44f6fe7a5576c365b8df6f08d4faad96d0a609fc32d9f32618cff007167a29d3c76f4f41cf35d1a62c9366dd46a8d48d94dc1c462243ddb916f68fd20f7708c6e57bf038cd5b528c127728fb03da938400e3a1ff3afaa74a647bd06a952188ac392243a86596d256b7167094a40c924f618155fd33ba7addd4d290a6fe291b62a1cc6598c0e47ec57f39fdd23e9ae6d56a4deb5243d26169f203627dc924677b015b50d1fb2d60e7dc36aae7d7929fb84b89a32dae2db7ee20ae73ad8ff000d093c2d59eca5f0da7f727b527fab8d7a390ad45a9666b47db5262212a83664a8f05904798f81d3f3169c03fa523b2b9ae6a071ff0010b56bd6e6e42e2e8db22d62e5312e797f16fa4616d255dd09190a5023193ce704766aabe2ae5786fc2fd16e7c149432917098c0c26d91400308f7708c2523a0cf383c56cb5d96cb74d4ae69368349b06976d84fe1e85712642c15853c3ea4a46d23390a52964fcb8ab3a5f7f266ac8deadd3b1d9426de89d2e3368094396fb6bf219091c612b6d05040c7626bb21ea4817684f39a7e5459f29b46ef865bc59583d82c149523f94d4ca1284001236803000f6aa37894eb6e5f74e5b6d610350bf39b5b2ea07e6478c93b9f5a8e3fb650148c1e14a200e79136224bf11d78e8096f4cd9593dd6f5e17c7fe29615ff00dac7c1eba9a00977eb4da53b8653020a9e731ede63aadbff00aebb759ea7b7e96b29b84d2b756b58663466b9764bca384b481dd44ff9753c0aa9787da6afc8b8bdadbc41b893772973e1e125e022db183ced18f4a958e14ae9fbe3357c8bbdb6d5f0ae25e7ee5709b2368056fbd807afd080940ea7e9ff004aec8b0a1c571d723466995bc77385090371f73ef5e30bd73ab75b6be66dda5a53368d356f751267cf50497171c7a8295bfe44b9b48401c94face138a9cbff008817e76c53b51d8e3c285a7e3b588b2e6b0b75fb93c4ed4259652a4909528a5214ac939c849a655b2ce1ea7b8038ace6bca350ea0d47a9a6dbb425994987765c765ed4d3a23d84db1b382b69b50cfe6a8ee48e4948e7ee3d4a3349623b4c20aca1b48424ad656ac018e544924fdc9c9a988db4a52814a52814a52814a52814a57c9e868392f770896bb5c9b94e9088f16334a75e7567010903249af2bf02a1377d55cb564a0ea63a6ed2936a80e8c7c124b8a52d4539c798a2bc13d80e3a9a9fd4b0ff00ad358b7677d64e9db2ad322e2803d32a48c29b6547ba123d640e09c035d3e0cb67fa253314d86cce9d2e58fba56fac83fca707f9a7c7bfbd16e498bce295add79b65214eb886d3d32a3815f608232391da88c9af859c0ce6becf4af873efd2a51e7fa6eed06d565d53acef120b6d397291e62b392969857908401ef96ce3b92a1f6aaae9dbfcfb85baf570b5ba866ed3829ebbde5c4ef8b666520ec6104f0ebada33e81e90b2a2a23a194bce96d3dab3c497ad6d46dd6d818977b69b79c4b12a5ac0f29b5b615b4a80056a38cfc8093ce2c3e275be341f0be7c181104680d25b4bacc36b6ec8e1c4f99b129f646e38ab6e4e7afbfdaf5c8d3e0ce9b8f67d3ce5cca1c126ecb1255e672e25b3cb695abaa9783b944f552d47ef58d14d45b57889ab6d8b486e54b7d17268948cbcc2d212483d4ec712e023a0de9fd55332f5a6928305a90eea0b6065d482c06df4ad4e03d02109ca95fc03debccbc5abaea0b846675969ab4cab3356527fded2d01b7a4b2e2836b436c2c64a790b0a736e08e056b2eef44ce1e93ac757336775bb55b631baea09292625b9a500a575fcc715d1b6c7759fd8649150909946905aae57775cd41acaf2420263a0254b09e7c9692a386d94752a27fea393815b08b768c4a6d5a7a0bb76d4b72c38a2f3bb9f7cf42fc974f2940fe07d281d8466b3b6bda6b464d9666aa5ea3bebcc5b9eba2c04f95e73811847fcb6d014ada07427272726a49efbd1767468f0b2d13350ea697e216a39299ce852e2da529cf931d09510b5b40f405594857cca0371c6e012f1c6e17abbdc6d7e1d6962d99d740a7ae0eac6511e1a72095e3b28f18fab1b7eaa9bb86a88d6e6d9d25a222b374bb34d2596d967fc34140180b7969e1091c7a73b8f000e7355fd22c5e745ea5d42e5cec1a83545d2e7210e37758f1da0975bf293f97953890d252bdd84fb63ae29d7c4596cbbd5ae5dbad16b4ff43b139b62cd01afc4f564f918dd202be56d47a02bc64fb212123daa0b5cea69b2be06fe602d975d77e1345599d4ec53f214027e39d41e1294850d895631dc0246363363d5af6b2bcdc6ff00a165ce3365225c282896caa085842521521d24295b0a410809291951014706a55ed392adde2ae9ed57acae0992e2a3be953812530a23de90d32de7e51852cee51f5287638035677befbfc1b22f5e16e8f6347e9b1114f9977392e193729aae552a42b952c93dbb01f6fb9ab6e2be5856e46e041079041c822beeb36ed6214a52a294a52814a52814a52815a64ac371dc755d1092a3fc56eaf879b4bacada5a4292b494a811c107a8a948f398771169f09e34e82832ee97d6fcd88820ee912248dc8cfd805649ec941271573d216a162d2b6ab285f99f010da8c578c6e2840493fce335cb61d1f62b2160c186b263361a8e5f90e3fe4200c04a3cc2760c7184e38e2a7d2001803154af2ff143c359faa357db35243b9c352a0465b0dc1b9b25e8885ab3f9a1bf954af572140fca9e98156ff0fb4ec8d35657a1499e996b7a52e46d69a2db2c6e03f2da41528a5008240cf551c60600b1607b50003a5597262dba1e95cb725494427150da43b231f96951c2777627ec3f7aeaa607b54440e8cd3ece9fb418c1e5499521d5499b25606f90f2ce54b56001ec00180000000062a7719ac800741434bb47143b4dae1c9724c4b6c38efb9f3bad3094297fb90326a81fed04fca91a458d316b65122e77d9ad448eca9406e00ef5ad5ec9484727071579d4b788d63b43d719416b4b63d2da0654e2cf09481ee4903f9af37f0a2d575beeaf9baff503c1e754d7c2c04a53869a4920b81a3d54818080bfa8859e98a49fa9671caf3a274da2c115f71f94e5c2e9317e6cf9ce8f5bcbec07e942470948e001ee49a98b8dbe15ca2b912e1123cc8ce0c2d990d0710afdd27835d207b56696eb32638ed56bb7daa2221db21468519b24a598ed25b4027ae02702bb294a294a52814a52814a52814a52814a52814a52814a52814a52814a52814a52815858253c1c1ed59a1a0a76abd1f3752ea18cf4fbc3ad59232411023a4a14f39ce54b5e7b0c630323920827356b891988b15a8f1d9434d3480842103012903000fb600add4a74c0c5294a05294a05294a05294a05294a05294a05294a0fffd9', 6);
INSERT INTO firmas VALUES ('035240', 'henry.jpg                                                       ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0000020301010101000000000000000000000501020403060708ffc400371000010303020404050303030500000000010203110004051221063141511322617114325281911553a10733b1234282163443c1e1ffc400160101010100000000000000000000000000000102ffc4001e11010101000203000300000000000000000001112141021231325161ffda000c03010002110311003f00fd788d94a27daae950004f7ae2d1da7ac6f562a824fe2b383aea03aec2a12484f977ae63cc82076daac90ae6761caa60e89501b74ab8df6fe6b88290be7eb141583f9a68ed213cf6dea754c47b57224810475a90e0d30ada4d6a0e923f22aa9200200e7b0a84aa523ee054f423a9aa261025246e79d4a484898906a864ef1cf6a9313ffaa82d33b7206890044fa9aac981063b50a253eb4c1791ca26a440da39573931aa39d5a0c13304f2a920b8efd681cfdaa88248f4a856de6eb1ca6a8ed3b022ab2adb6a50788f089cd230a722d2722b5694b067528e9d503ed269b12a0279d3e0b0ff001520ed5511ca93e573ccdb2ef2d31ecab2592b4436e3964d185e85aa01df6ee7ed490392a113dab05f6671d6592b2c6dc5ca51777ca526dd104eb20127db60691e69cbdbabbbdc6b8a379677819b772d98f2b9649701d4e295d475fb531e1dc0378e62d9ebb5a6ef20ddb36c3afa848251ab7483ca751ab93b0ec6d475a06f475a8268a28a0569569107ef53220f7aa4125524015254528120551d13b208ec373d26a53f3733bd7299494cf3352dba3b19e95075f293b983ca8488dfa8e95c55e6057da27d6a4156fbcfb567076983befdab37ea58f19618b55cb5fa8167e205bcf98b53a754769dab265326cd9a916a80b7af5c52129651ba9b0b3a438a1f403ccd72e1dc39b55af2793434ee66e40370f2448479520a1079844a018ee4d5c0e9640020c0e71533ac1026a35220af925224cf6a457398babfb872c387db4a9cd0dbc9bc704b0b415c2d293f50135a9346fcb66adac6e3e0900dcdf94a1c168d9ff53c353894173d86a93ed5c3118cbc66e9cc8652ebc6be7016c86cc361b0a25303bc1dcd74c1e16d312252577373e78b977cce69528a8a357d33d3d2999d8927ad2ff04894a26361ca6a546524f5a882480391e95872394b5b30f35e207aeda68be6d9b32e290246c3dc454903040d24f33b72acd7391b1b7bab7b2b8b84357375a8b0da8eebd31aa3da47e6b1307239373c4527e1b1b716c3ca76790b3ffcad36b8bb3b562cd0b47c5396a92869f786a713313bfac0fc55c906537595c8e36ed18f60e3eedb70b6daae53295c18d43d08ae59ec5d83afe3b2b94be7d872c9c4046874a50b70a930143acaa07de9e38ea1b654b71694a5224a89d80ef5e5b0f6ebe25c9a73b7c879bb26094595aaf60b13bb8b4f53212527b5597b45f118b6f3796b5e27bec69b27ad7c44dab4b4c3a92494294b3d6425253d8135eab90d20ed55f313239914b7319ab5c6dbdc84a1777756ed87576ac6ee9493008153f2aa5d9cbe19255f5922e936f8ab442dbca5c4c1d0a697294287caa49d0a27b1aad930fde136b8cb7f84b66169b4b8ba7932e5e5bf820a5485f3d8aa24f506bcfe138378899e34b8babbbdb77386d6edc5d376b275bae3c84a4a5c1c8a400adbdabe8c8486d21b400942400903a7a56bcb2711233e2ec18c75a356cc052821b08f116656b0396a3d6b6522e2a4f141659ffa6576097351f1be281223d22b6e0065c631b19b55b2af37d65807473da27d22b19c6a9803b4f7a0934749a0501454fde8a684ca33b1ef53a81590676aa9d9627de82525220907ad0586f1c81e750a5e922075a091247531158f2f91b5c5e39ebebd58432d8924f351ec9ee7d2a8de16a5c0d300f28a4d7f98745c2acb148439708425e53ce7f602039a5c4957d40255b77149adaff3bc5c5b5635b5637879d652e357a7c9741d4ae54d941e492047de9970b70e2303617f62e642e324cdddcbb7052f0d91e228a9481e9249fbd5cc1df85f1f8fc7e38dedb5faf2ce10b06f54a0b71682ad5a011cc035b5acddab98e37ce21e65252bd0cb898717a449091d4c0358f559e16c9189e1fb2683c439f0f6e8feda1406a2167fdb35669164cdc35759bbfb617657e332879d09f0096c25494771f37e6b388adab77b9b4b376f29cb3b2d6ddcdb213e571c4946e8747b93b7a53cb4b766d1845b5a34865940f2b681094fb529cef146270f8e55f3ce2eeda4a9295a6d13e2ac4c8981ea08fb55f29c438dc7e33f5370bceb5adb4290ca35b8852e20292391df7ab368750a1f2ee69764f356761677af38af8a76cdb0e3d6f6fe77403cbcbeb3586f6cf37976b238fb8b8fd259f1106ceeed952e2d020aa474dc47b1a65658eb0b5c8bf9266d508bdb94250fbe3e6702764cfb5552fb9b6cce617756aa7459626e2cc065f695172874f3f681fcd76ca7e9bc3ec33957acdfbbb84a5bb4f1da6f5bc524ed3e9324fbd380b84ee24d01442811b0353473b5bc1736c9b84b6e212ae8b10aab38a78b4a2c8495e93a42b94d582caa08dc5413e953b0978812ee41c6b02d95245ca35dcad3cd2d03d3d4911ed34d5cbcb1b37d9b271f61879c410c30540296123fda3ac528730976fa72e4e52e2ddebd70065e47cd6cd8884a7d2413ff00235185e15b2b4559dc64df733391b25ad56f7b723fd46c2e240f4dab564fda2f6590bce22b165eb369eb2c75d5bbe8754ea4a2e1a73504a0a47b6b3f8add83c3dae2d9655a977576db09b75de3bbbaea472d47ad30d4482a3ed4254930279f234d55d5227481f7a91bd579eddb6a90ad827a8daa091b9a81c89ed446fce2a63f9a8276899fb500cc11501300770680472a0bcd15145302551e7559e667af2aaad530350200933b529bebd7ef1c731f8c25b5ca9b7aee3fed95a65263ac98ab06cc8e5ad6cd6d324eb7de5f84d213bffa9a4a80576e5585386773018b9e236c286969c18f99430fa093ac1ea778ad988c45b58a9d7ffb97970106e1e3ff0091694c6a8e9b56e513a419d8d5dcf83a294a0920246a8e9d694e4afdcbab95e231c4f8c5005c3e395ba169584ad27aa82920456dbe43ceda38d5bbde0bab4e943913a7d6af62c5bd95b780c242121457dcca8c9dfdc9350257786ae9395b5bfb3cd3d6694ad2bbc692891785223cddbed59b88f807159fe2cb6cfe5d46e1ab6b52c22ccc84824c95c8ea7957a92b32481edeb42dc86e56a4a527992600a6f9263ca5af03b761c4dfad61f2aee3d85690e59211a90b00951049eea5295f7af5563616364edd3f6b6e96dcbc7bc6b83cfc45c44ff1574b8d19d2eb6b48ea14081574ad21bd41490399513b477a7b5bf4c7589054768daae4808db98af1795fea5f08e2726fe2eff20f3772c901c486144024c0dc0f5a676fc4766fe7ad31a9902f2c7e32d9c50202d2144281ed020fdeae557a00bdc7aff3525692629466b2c71d758a6116fe31c85d1b72a0766c6852f57afcb1f7a67be804193d6982c092991f6f4a94154f3924f2af0fc6b9aca359361ac35de838e7995dd329009bc71d3a5bb53f4ea1e6d5d2297ff50b8b3894e715c2bc158b55ee410d87deb9d5a43494a90548df63a92a03fe5e956785a9afa4852a440e74b335957d8696ce2186aff2694788860ae014850064f43bf2a4983471764b86ee6fafc9c3e4ae9c0a66d765fc2a500274cf5d7a4abd35d61fe9ef0ee5f199eccf13e45d532acbf9bf4c267c05a4c0215ea07f34cce47a0bd51b2e246f2173997be15d6c59a6c1280478aa512974f51b0229da5db50f78087d9f15224b6160a87ac73a41c258cb84b6acc65d8d399bc0a0f499f0d1e22d4db7dbc816133d62b25a7045ada7133dc4c8ba58cabd78a75c7a4906dc9fecc72e5b4d2c83d805493e95295411aab9eff3eadea06ca8267d6b2aeaa5241dea75280df69e554df5020c9a08247cd13fc505faeeada22a06a9e7cbad516414f2d85402a4a7ca276a0d3451450790ced95d6471eab4b5ba16c1c3a5e5113a9b321691d891d6b6db30866dd2cb291a529089ea401026a02c1dc1824c115744a4c13049e7da9d60bf9b623a511260d7313aa553bf214a38d9fcbb1c35748c230a7efdfd2c365227c3d5b159f40269053877257994cf67653a71768b659b470f25ac257e31fce8ae7fd3fc9e57336191bdc9a74dabb7eb562d71fddb329496d5f7dcfdeb758e0ed18e174e00a9c0c1b72cbaa4aa16a2a10a54f72677ad784c7358ac3dae32dc9f06c9a0c3009921b480123f0055b83cd719dff13a320dd860da23e2e2d997762185fcc6e08ea94a7cb14b3faa0bcb3180c170fa6c1fcd5cdedc245da2dd7e1a9ff0d05c541ff6ca933f68af697d84b3c865f1f957d4fa6e2c35160217093a841d43ad325212561c294a96d9f2aa374f4307a6c69ec8f9be37116d8ae0ebcc5e2ae1e53b9dcb2ed4ea5951b5528a829127e84b653efbd7b8cb621abce197f0695ad2872d3e1c2c28c8f2e9066b7210d2602586c79b58f28d95d55efb9dfd6b4a4c4276914f6d31e03fa72ef160bcbfc4718e099b836eb51632c59404be81a42531ce7999af4bc59867b3583bac6b374d5b7c469405844290d6dad00f49834e8181a7599ec4d5409f988001a6f3aae28b2b64b16d6c1a25bb5d21893253a440dfdab4a600f4ed46a9e444450820c002077350796e09e1a6ac6f6fb88ef995a32d94796ebc85aa43482a94a6394a606feb5e9ad6d2dad96ead96d295baa2b5ae3cc663af6d8574539b11cf68ae844276d88156db6e8028441edbd549f59a164403d7b5483c931cfad4015010a07d2ac9954a4efdbd6a9255000dbfc5024989de83a111e9e955882544f5a123626677deacad2069998a099dfd6aba4970999dea35c294024c745504ea1a6623f8a0bea3ae28d50773b4d5349046f2072a3cc0081b8ef41ae8a28a0f38348481b6fcaa53f2f98f4a7ff0ec7ed23f14780cfed27f1408428000cced47891b827b48a7df0ecfed23f14780cfed23f1408c1949d2773deac5c8d8f334e830c8e4da7f14780cfeda7f140981933313570a56927634dfc16bf6d3f8a3c26a23c34fe2a605122410a1e9562b8320ed4d3c16bf6d3f8a9f05afdb4fe292058954f389a98244cf4a65e137f427f153e1a3e91542a820403ceaf062262362299786dfd0282da099291340b904fcbb6dd6ba820a4cefed5b3c347d03f1406d039245061052775900cd58a86903f15b3c36fe81f8a3c347d2283202236eb41d224f7deb5e847d2282841e69141981d8491b0a852a0c1893fe2b56847d228d0899d228328926236a9501c8113fe6b5694f6151a1133a45065d452081bd54f532666b6e84fd22a3423e91406f454d141fffd9', 7);
INSERT INTO firmas VALUES ('035247', 'jairo.jpg                                                       ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0000020203010100000000000000000000000104050203060708ffc400481000010303030202060409070d0000000001020304000511061221315113410714226171a1158191b11623243234527292d108334262a2b2c11725263543446382838494c2e1ffc4001501010100000000000000000000000000000001ffc4001511010100000000000000000000000000000011ffda000c03010002110311003f00fb2b1452c8ed4e801d69d2a540cd006691c79d30401d680c7be953c8ef4b8ee281d14a8c0140c75a758f141c0a0ca966b1c8a7e54051471dc5191de80e7bd319cf5a28a07489e681c51e740a9d00f14a803492909ce33c9c9c926b2278a3ce81534d30691eb40e8ac68a07b4518a09e3a573b7bd42fc7b8a6d366b78ba5cb1b9c6d4f169a8e8f2538e04ab693e4900a8f5c632683a2f3e94294123271542ec1d413e33a8917a16b2e251e1fd1aca56e32a072afc63c952560f4fe6d27159dc34cdaae85b378617714a42773325f716c2c8e412c93e193919fcdeb41263dfac92662e146bbc07a520656c37250a713f14839f2a872752b4894a8b16cd7c98f2545276405b48c8ece3db107e2146ae22c68d1584b1158698650004a1a404a52074000e95b0e07000c76a0a4b7dcef92d4adfa6d70920647ad4c464f3d30defc1ac548d5af387c37ac7093bb8cb2ec938fa94df357a081f1ad32e6468915c932de44761b19538e28252077cf4a080c44bf14012aed09447f4a3415367fb6eaeb53b659ee2828ea8bc37dc211180f9b24fceabdff489a39276c3bc26ecb0ad8a4da1972e050ace30a11d2b29ff009b15ad7ac27c8901bb7686d532d93822414478c8fad2f3a8707ee734165f83a56d843b7dbe39c75f5a0827f7122b35e9d88afcf977550c63fd64f8fb962ab1dba6bb5adb545d236b43454a0b132f85b7001d0e1b61c1cfed54f8323563cce665b2cd0ddcf21b9eec81f365ba0926c301439f5d38e4667be7ff007ac9362b7824e2492719ccb74f41ef556b5b3a894d28353ed8cb99f64b90dc71207c03a9cd54bb07d2305282754697009f67fd1d90703ff379f9505d8b1c2090019400c63f2c7491d38ceee9c7dfdeb1fa0e1f885c4bb704a8f6b83f8fb37e2aba145d76823d775069c7c03ed066c8f35c7c4ca555923e9c437edbb6e7d649e885b431f6ace68313646c105171ba231e5ebab57f789a42cd252416f505d91820e32cab3eef69b350ee52b5a32316db0d8e51cf2645e5d67ecc46556b76f5a9e1c74ae5e8c725af1cb76ab934f107febf820fdb417288731b6c84dd643ab23014fb6d903df8425351a531a8f6831ae56ac8ea1d82e1cfd61ee3e3835508d751994b66eba6b555b14e2b6252bb52e560fbd51bc5481ef271efabbb5ea0b2dcdf54781738b2242065c650e0f11b1fd647e727eb028308ebbfa777ac45b5abf554894b467e20b67efad32eeb788ae233a6e44b68e772e1c9695b401d9c2827b719fe177b8639148ad1d31cf6c72282a606a18b3242a37a85e23ba9ce43f6d7929e3b2f6ec3f528fdd52137ab3aa7fd1e2eb04cc03263fac23c5c7ece73f2a9d9c1c6d3c79e2ab35031639513c1bdb36f7590784cb4b6a483f0570282d01cf9629d7251ede5a9f051a7aeb706a334e15c88cacbb15e6d43c96e02a484f1b52dac01db15d5a41a0ca8a3068a0e4fd2ecebfdb3d196a2b8697654f5e63c171c8a809dc4a80c9c0f3206703b8ae8a0262222b488096445081e106b1b0271c6dc718c631524a723040c1eb5c7db743a74e4c6dcd1d3c59a02d6a54bb62d92f455ee39dcd237a4b0bcf4d876609ca09c28075e4718e07c2829edf7d72d75bdeafb6dc004e8c17780a504a5db6dcdbf1c7752da7c34903f65c51ebeecdb4ebd47b7404cc9d12e690a4825b660b925c4123a14b2959cfc33f1a0b4483462b91ff295a3d08dd2a7ccb78e7f4fb649898c79fe35b4f1efa910fd21e829af86226b5d3afbca56d0db77364ab3db1bb39a09dab5cd40dd924ab4c478126e98c32dcd7d4d35f125295138ede7dc55469233e2c36dc9ba4a7337374e663e1d8cb2eb84fb4bdde267693c818180400302ba266ed6b7965b66e311d50382943c951f91a92971b5a7705a4a49eb918a088b9f212726d13bae07b4d1fb975a957293b429bb1dc1ce3a6e653f7b82ac42c718e86b5f8892b03dd9a0a1957dd429fd1b44cf70e40cb93a32063bf0b51f95723abfd216b4b04e84daf425b54c4824b85ed41b16d361c6d05d210c2c6c4f880ab9c81cf957a7ef39e9907a571fe94b4735abe046683ee47763971b70a178f1633c9f0df68fb8a791d9484505adba66ad71b2a9d63b2b0ac7b219bc3ae83f1263271f6559a0dc56c92a115870f4c153a91fdd35e4fe85b5d3e8b4de34bea89096ae7a490dc7953243a02248fc66c737018e50849239209e7cb3c9c0fe50f73d61f90e92d38f3531721a0c843a8795218dcaf1dc429610cb7b1294901d5277071278e321eef399d461bdd1ef16860279597ad8e2f8fa9f4e2bcca245d68f7a76756c6a68061ced30971b991edab31d45b938c2525f5242f0e0cab3c8f2a9acdc3d204bd572e735010ab5aed696fe8cbbdc633315520b8028a16c079ce5bce42d25390403ed6e171a02c5260e86b7d87525d23c6971de7ca99b5dc569425a53ae165a0e00870ed42903236f29edd42ed163d48b0a0f6b6983238f020474edf86e42be79ad326c32a3b6e3d3f5edf5a64e0a94b544692903a8c86463e39f3ad7f81ba30a97eb6876e495672ddc6eafcc4649ce763ce2920fd59ab0b2e9dd1b66783f66b158edeee76a5c8b11a6944e0700a403d283969372d0e95865cf485366b98c86e35e94e2cf183ecb2771aca2c5b05d5b53706dbadae6109c14cc953a336aedfa42d015df80ac76af43f1d9271e2a01cf42ae69f88d9246f4123a8cf4a0f36f47be8aad362933e63d6a83123cd0dadbb4b4fbb25886b4856e285b98e1594fb294240dbe75db33a674f32a4a9bb1db52a42b7255eaa8241ee0e339ab44a91bb1b8530a07ff00b41a530e2270531584903030d815b92909184a401ee14fcb346680c0ed4eb10a04e06698239e8681d1471eea281d1452e7b1a0781da96076a06734e81103a62b4b91d870fb6cb6ac7eb241adc68c504376dd017c2a0c657c5949ff000a88fe9cd3921799162b53caea4b911b51f98ab7ac4a7dc28289cd1ba4164297a5ac848e84c06b8fecd24e90d2882149d33644e3a1101b18fecd5ea8653f1f315cd5da6df66ae540d2cd414b8ca92db936738a2db4a2013b5b40cb84248ca4a9b1ed0e7ad06bbb5a740da63a64dd6d9a6e03255843925861a4951f205400c9aa972ddf4ca15f82fa76c96f61973025dcad2a1e29c7b45a6fd856dc70164807c811c9e874fe95816b5372a429eba5cd2a52d5709ea0ebfb9430ada700360803d9404a7dd57bf9a3a0141e6563f44ba763eb1b9dd2f7120dfdb97163865a9f02394c6750a77c42da10da5290a496473951d8324e0577b0ec16388d25b8966b74742461296e321200ec0015cc7a419f71b16afd217a69f06d8ec97ad33d9c1ff79f0cb4e83d3d95b21247521c38aee8038eb41085a2d40922db0c13d7f109e7e559a2db6e4fe6dbe227e0ca47f854ae7bd1411be8fb7856ef518d9efe1273f75354284a05b54260a4f2416860d48c67ad3028218b65b0702dd1067fe0a7f8562ab55ac83fe6c8673d7f109e7e553f029639a0af365b4ab1bad705407918e8fe148d8eca7ad9ede7fed91fc3dc2ac40e28c1a0adfa02c5927e85b6e4f5fc951cfca97e0fd8376efa0ed99efea88fe1567da823b50436ad56c6b1e15ba1a31d36b291fe15bda8ec3492969a4363ae1231f756d03bd3c0a51abc247f5bf7cd15b78a2a50514515414519a280a28a280c0ac4f4acab9ed7d26e11b4a4d36bde99af6c61a711fec4b8a08f13a7f473bbeaa0d1eb4f6a4972adf11e9d12044754c4894d84a0c858e14db6ae4800e42940039180455edb6043b74611a1466e3b29248436909192724e077249ac2cb098b75ae25be3ee2d46652d24ab393818c9ee4f527bd4ec0a05c52201f2cd65814628388f4db688d78f4657b65e52db5c58e66c775b38534f35eda140f910a48f9d5d683bb397dd1565bcba9525c9b0597d60f50a52013f3aa5f4c1267bfa71ed2d638cec9bcdf58723c64842bc369bf652ebce2f1b5094a563a90544809c9aea74fdb59b458a05a98fe6a1c76d84fbc252067e541329914714027b501cf6a075a628a0473e5403de9d18a028a296450001a74b278a740518a28a4060514515205cd33d296699aa10eb4e90a6680a28348d03a8d72831ae101f8529af11979052b4ee29cfd63907de3a548c9a7e541cb25ed436075a8cec17af96cddb1b7e36d4c88e80303c64b8b1e2e3f5d1ed1fd4279ab283a86db2652e2f8afb2ea0e0a64c5758cfc3c448c8f78cd5baba1ac71cd0467ee30da1cbc167b3692e1fb1209a8b2a7dc5eda8b5400bdd8dcfca25a4201383ece37a94073b70907a6e1e5643ae3ca9800741415364b75c585bf26eb7433e5be120ec6bc165a090786dbca88c92492a5294738dd8000b74f000cd028a054c9c0a54503dd9a334795140668cd14a8183c52a28f3a063ca9d623a53cd03a28f3a280a28a283ffd9', 8);
INSERT INTO firmas VALUES ('035253', 'jonathan.jpg                                                    ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0000010501010100000000000000000000000102030406050708ffc4003a1000010303030203060404050500000000010203040005110612213141135161071422327181234291a124b1c1f017526272d182a2b2e1f1ffc40017010101010100000000000000000000000001000203ffc4001b11010101000301010000000000000000000001110221311241ffda000c03010002110311003f00fb1853540e7814a33e74139adb26f43411de97807d690e7ae69469ce683ce7ce8c718f2a43dc76a410671cf51de97e9fca933cf953bf7a8e8c74a073d78a4ef8e334b9e7a1a901d79c53c118a68fde97bffc508e4f5a9874a8054c9e958a6168a28a08a28a2a46e690d2923ce909a4129bc50a349dfc85301ddf14a05252fdaaa8ea70a68e074a70a29828a28a0a1e3cb141c1f4a07f6690f4e79adb2a7789f1ed56a977294a298f1195bce9039da9049c7af15c0d077bbddc5d9b0751448d1a7308664a52c642432f2494a4e493b92a438927a1c022a4d78b5c8169b23653bae570692e6471e0b5f8cef1df296f67fd629ce92cfb468c028624da5ddc9c75f09e6f049f4f1958fa9a53479f5a4efc75a4cfde82413fd33481c74ebf7a3ae690e28c83f4ab11c0ff00668e94ddc315cfb85dd88777b6db5685a9db82dc4b653d00420a893fb0fbd585d2fd29c3af34c0467d6941cf4a11e3a8a993d2a0491e753a7a5679185a28a0d649a5d6c3c964ad21c524a929cf240c0271e4323f514eaca3aead5ed122c9ddf025a76dc120e7e2286df24fd9207ff6b5751b311a8e2b27a1b543b7fbb6a3b7c98deeebb54ff05a49041532a4e5b59cff009b0a3f422b54a38acb6938a946add5b381c7bc4d611803a6c8cd0feb5a9186ab2290e73d7028e3c8d1c11c5285387349d29c391454514ea414bdeb34c1451454554939ec6954703a1a518dd4103ad74619898daa4fb48b615360b706d725c4ab3d1c75c6920e3fda85fea689a55fe245af85002d333271c0fc68bc7f3ab57798c5b654fb9bad296a6223494253f33a4ad7b509edb94ac247a9154adbe2bbaf657bcecf1a2d9a2a54a40c052dc75e2bc7a7e127f5ad6269339c73dfb5314a5738fef9a909ed49f7c1a91995608c64d0a241a76e48009007fee9a4f04d2996b3cc7e4ebbd4084a806634786c633c9730e38afa7c2e3750cc2647b55b5a1dcff056890fa463a29c75a467f4428543a0ae50dc97752ecc43b3ee17694e865b19521b6945841563e51b581f11c024800e48a96d0ea247b51d472dd5808816c851428f44ee53eeac9fb291fa5471ad495f993f6a7a37f079c5363becbcc25e65d438d293b92b4ab208f3c8a58f2197d1e232e21c41e8a4a8107ee29d189da0ada3775ab49f945639dd73676b53b1620dcd714ec9f7432d0cff000c891b0ac345c27e7c24f001c1e0e0d6c1bf90572e4d487507a515ccd4d7466d36876438afc457e1308009538e2b84a5207249f21ce01ac1721c4ed9b6294521264de5e709cfcc931a40411f548456aab0f74b88763d963c6b6dcdb6625ce2b624c963c24fcc1be8a21472167909c66bb9ac2e171850a347b3a5955ca7c94c68e5d19423852d6b50c8c84a10b38ee401deaf5aaeaac8e6b2becf96e4917f9eb2a2dbf7b921addfe56b6b1c7a65a552c5b85eec5a6bdeb53055e6725c3b936786a24a4f40104e4e3cfe95e6763bb6b67bd9e5aa226245b141bbce4c74cf5bde249704a7d4b2b6d092037c2d582a2559c60027237d461ecd6fbbdb27cb91120dc23497e31dafb6d3a14a6cf9103a77fd2ad2a5474c94465c8692fb892a4365602940752075205652cba7ecfecf7494e950982f391a1a9d90f2c80b783482427c929182001c0cf9924e4598ba52d1a4a1eb4bc20dd7504b6517112144a9f5b8078c52de01f09b480412900040e734fab1e91a8b52d9b4fa18374945a54856d69a6da5bae2f1d4842015100724e303bd749c94c371152d4e243096cb856391b40ce7f4af1cb55cf5642b9dcef172b23b2ee73ad4cbd1a7786911613212b5ada52ba85254ac6c192bc03ea340a4c98dec42d098d124cd0214154e8eca4ade759516cc8091dc9495f1e5914749b0d3b75bbdcdf71c976355ba0a901719c75f49757fee40f978e7a9fd6bba9214320f15e57adf515faf1a1ee97281167d82d2cc65e1d94cec952d67e14a1283cb6dee232b5614474001dd5e87a66d8dd974fdbed2d28a910e336c2547aab6a40c9f538cd653a5451450557bd388c9ef8a5faf155eeb3a3db2d926e32d7b23c5656f38a03384a4127f615bd67198701bb7b4572302150ed2c34ec819eb255bbc2491d084a14b59f225b239153d81485df3535c0a082d4e4460a0324b6dc76d5ff9b8e556f67f6e9d02e37055c1a0893362c7992149391ef0e3920b8807c91f0247fa426af6836d0e69c54d5252a37195225a891f325c754500fd11b07dab5a993947502ac63da00d4725b09b7a66356b42408de1901cd8b4f5528a0eddd9ce48230060c57f9d78be593525ea05da6dad1625496a1b319c4a43cfb00952dd2a07720a801b38180739ce6bb10b4d6a1f0a069d9efdb95a72038921d4ad6a912da41cb2cad053b521384ee56e56f091c2726b42bd3d6c5592e367285889712f99090b2092f125cc1edca8fd2afad5accdd6047d4326f4e5da625306dcb4464a1c00219fc16dd71dc9e8bc3984aff2e011cd269f972b56e9db9dc5f9f3625be64a598463a834e371db21390a0320a948593e8a0062ba92743d99fbd1b9adc9de1abc32ec21255eeaf2db484216b6ff0031094a473c1da9c82455cb258e1da2c66cf096fa63a7784971d2b5277127827b0cf03d29968d66fd90d9a15b743db644465a4c89d1d3265ba9216b71d5fc4a0b5f55149514f278c76acf696b535acb586aa9d73425fb3b174f0511f71f0e43ad348402b1d149484e403c12e13ce057a3e97b3c6d3fa7a0d9621dcd43652defdb8de40f89447624927ef4eb15a2d96386a896c8c23b2a714ea86f528a96a39528a944924fa9a73c8b5e73a7da830e23ba7e43b1e0da25deee0bf0fc4f01bf746b39424f0024a883818f8777606a797a8665b341dfeeba7a22e0db6032c37680e3200793bb05e191921655c64f200571bb277972b1d8ee709b8571b5c29515b73c5432eb295212ae79092319e4fea6ba6e782b05b71295a543904647deaeff000eb1b274eb897f4ada3c35b8dc396bb8c97d20e0ba842b927fd4e3b9c7d6bd119186c0aa80a538ce2ae36414f158e6a1d542e11d1364c78ebced65c4c85828252ac6768cf9eec1eff2fa8abf457369cbd536e7ae96576245750d48dedbacad63212b6dc4ad24fdd22aa6a0b74f97a934e4b8fb4c48521e7257c5838530b42303bfc4ae9f4aefd141d554b5850cd64f4d6912efb3083a5754b4c4a5223069e082709da728daa182149013c8ee9cd6cb72474a0a938addb6b0c1b3eccadfb4b573d47aa6f314e37459f7352d9501d88484e47a1241ef9abd62d05a66cd12444876d0a6a4b263bc5f756f294ce36f85b96490de3f2838fbd6adc584839a605a55d29915bac6fb4f93074ffb38bb14b296db1057122b0ca401b94d94212948e80673c74009ed5ddd211d4c699b5b2a5249443653c0c0384247f4ac17b679c6509d09b0e162d966952df3c6cf19e6d6c30927cfe2755f615e9b6f4223c466324821a4040c7a0c7f4ad5d2b0b65b75a534e212b42860a543208f515301834d48e29e2b9d505145141570938cd67b5fba0dae1dbcb68705c6e31a2a90ae42db2e053893e796d0e67d335a20a159fd4bf1ea5d2c90b20227bcb29f3fe11f4e7feefdeb7db316b56cd72d5a66e7718c13ef4cc5598f9fceee0f869f52564003ccd5ab4414dbed10eded001b8ac2184fd129091fcab9babd2996ab45acad204ab8b4b5646729672fe3ee5a48fbd77f8c1eb4a47e1e075fd28520927cbd6a4cf1df8ef4d2a1939191df9ab6842b69454da838a46c564a401f18c118391d39cf1839039c6414537924f4cd4ea38a8d4a1d79a654854d9c1e4f9f4a629a2ac05739ebc559cf3d29aa5791ed5ad488320e067a0a7784071bbbf4a7a48e075ed4789ce020fd6ada8388ca709f2ab8d0da802aa8278f538c8ab4d7c82b9f3f0c3a8a28ac3428a28a921520e473d0f7a0278e7f7a793cd21e95ad651ba8ddc8eb51ed09c9a9f39aa9725494427d70d085c94b6a2d257f2a958e01f4ce2b52a798cf604eb3dd2714075cd497d62232a04f319b79284fd06c6dd5f1fe726bd49a6d3bb72864e319ac3683b75d66c0b03d768ef4245a61a1b4b0e8295bd27c3dab71433f28f8824119e49e38adea47a7ef4da9327a53aa34e40e29e0f3cd7325a28a282ae9475ff9ae46a80b8e981726e2bb27dce505b89651bdc0da90a6d45200cab1bc12073806bb23ad1f97ef5b6598b44e8f7fd5befd0c3a625ba096c29d61c68975f5a54a4ed5804292969390464789f5ad46d18c528e9f6a077a3499b7af7cf7a0a12538a75227ad208afef9a6ec04104714f1ce6907f4a918538e0d22db0460fed4f55354709511d474a4114838f8700e7b8a42de48231d0f7a71e338a0939a504a3078fe75650309e2ab20f35653d2b1c8c2d14515968514515244a23ae4519005317d0d2a89da2b78c9723b8a69a621449ebda90a8fc5cf45629c5a7003352a6aaa144e39ee2a660957539e05562d5818c50050296b9914514545ffd9', 9);
INSERT INTO firmas VALUES ('035301', 'jovan.jpg                                                       ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0000010501010100000000000000000000000102040506030708ffc4003d1000010303020306040306050501000000010203040005110621123151071322416171143291a115528123424392a2d1165362b1c124256472f082ffc40017010101010100000000000000000000000000010203ffc4001b11010101010101010100000000000000000001112112024161ffda000c03010002110311003f00fb2a8a28a028a28a028a28a028a28a028a28a028a28a028a28a028a28a028a69581ce9bc5be7ed415572bd2635da1db1b8ea79f907270a00368dfc47af23b55cf956074e369bef68371d42085c280830622f27f68e6fdeafa10364fb835bd27140d50c8e1dff00438aa3d657a4596c2f4b00adf5e198e81cd6eafc2903aefbd5e2c908cf9d79f215fe29ed1ca810ab569d50e11938765ac7df806def43fad5e97b4fe156a6a2adc71d75254e3ceace4ad6bdd47eb5734c6fe507aee69f4052d252d0145145025145140514514051451405149bd1bd02d145267a502d14c2a0373b0f5a42e009c9d87d3fde83a5279e2b8aa4361453c492a0324710cfad740b04057204677a07d2138a8770b8c7811552a6bad4661032a71d58481ffdff00c2b03da2f6822df624a2c6cc8952a6a1423ba11c2948271c5bee4f90db7a62c96a43d255ac35cb7063beafc22cce07a4774b290f3e3e54920f21d3ceaeb5e5d64c482d5b6d6126e97370478c0fee83f339ec90739aabeca188967d26f34fa7b8971de51b9158e4e8dcefe78046f52346b4fddae92356cd6ca7e2406adcd2f9b51c13957a159dfda85c6874e59d8b1d961dae31cb719a0d851e6a3cd4a3ea55b9a9e5c25ce046e473f4ae951a54a8f0e2b8fbaa4b6d3492b7144ec00f3cd127547ae6f4edb20b312de80e5d27ba23c46c9e6ac12547d001cea4694b1b363b2316c8c49291c6f3a7e675c3ba967d49aa9d2b05cbcde9dd5d706ca54e27bab6b4b182c31bf888fccace7dab5e9086c70f179e4e68bb930f48e14803c8629d5cfbc18e63eb4bc7d066887d2d734af8b97df63f4ae94051451409451450148907ce968a029b93e82b849756db454da7bc5632120f33ef902b09363f68f7c90e04cd85a7a0f1908ee807a414676ca882907da836f3ee702ded77b3a6478c8c672e2c01f7ac8debb51d316d5a51f10fcace388b0d82940271925440c7b673e5515beca6cb25df88be5c6e776938c29c7a42803fa03b5696d5a3f4cdaca550ecb0d0b0301c53614bfa9de8bc40735eda16a28b73170ba380e0089156a076cfcc404fdeb2cfeb7d6778d43162e9cd38198a14a2eaa7bc121c4a79ee9cf0f3d88cf2ad56bfbaa6cd6967188d15d5f0c8746470b41392074511b0f5aafece63ce36e7ef4fc4ee64dc70a65973c288cc01fb3401cf96e4d3f716766bb087af26a78a66a2b65ad077298510b8af62b73fb5405e9b44a516ddd437fbec80305289418647b940007b649ad69b7092e71ce7fe28a760d7269b3ffa8e7fad43bf6a081662d416db5ca9ef2731e147038d5ee39253fea56d44daa6d3da160d8ae6bbe4c98e77c804a51f10b0c3408c13e23e2563cd46a4af52dcef0a2c69280890d6785573960a62a4f9840f99d23d303d6abecac2b54dcd4f5fe509a86ca8b7023254a82c9ff5b9801d5feb8adcbab8f0a3296ea9a65869393e41091e944bc6367db6db638c6fba9a4bd7db885a52cfc42460baaf952d343c28c9d8733d6b211d4e1d4f26fb7a097956d7429f420f177935470cc547fa509c138df88d49d5daa5a6233babee0ea1ac12c69f8ee91919f0aa4a923d771e9543a6aeedc784c488f0a6cd94da962d51511d4aef24afe792ea8e13c7e2c84efc22a6ba4e3696bb7c99888fa61d595fed0cdd42e83e1e358cf700fae467d135e8b1d0db4df7694f0a520009036091c80f4af32b7df2469f87f87bcab5dbe538e171e726cc0f4879e57cc4b4d0273d0576b65e917c8d265ccd7125a8b19c0cbc88d1445016af9539502a27d07eb4d66fcebd224cb623b65c7dd6da40f35a801f538af3bd47a8acb7bbca6c5f882156d8c90e4d0c656a7d5fbad24273b63c47e9536f561b64771a816f8df1d78999287a6b8a7fb940e6e282b23039018dcd4656a2d27a35d8fa72008ab90da0974f184849239ad43395abf2e09aa4e2ecea87d6122d1a62f12c1002545a0c2001cb759ff8a553fade5f11444b25ad27977eeadf58fe5c0ad0459697e3b4f83e075016140e46e36e63353303a519ac78b26ab9092266af5340f3106121bfea51268ff07070832750ea27c8ff00cc280afe502b60403e546286d57586d4c5a2008518be5a049fdabc5c51279e4a8935674da75014514502514d0a4924020e39d1c4281d49485490324ed51a74f8909aef65bed476ff0033ae048fbd04ac8f4a323a8acdab575a16e704112ae6ace0260c7539fd5b27ef5c9fbeded4852dbd3c21b43f8b719686927f4049a2e353464579f4dd752a313c0ab0ce5a464b512538e2c8f4c229970ed250cd9e6cd6f4fdcc2e2a40790ea43610b5ee9193b927d28926a97b60d4f013778d6594a5bd0612d1227b0d6eb90bfe0b091cb73ba89e5502fee5dff0655c7522dd5dc630f8d5c68ab5062dccf3436318e3709e11939db3496dd09a9ae96f8f3a5351a15d9e9099ef4d75de3790e288294848494a71803aec6ad2e90b53595883a72df7d61574b92ca509447cf08c12e3ee38a24e46f8f7159dbbaeb324c6566769172d336b8ec88e266a0ba2bbc7a2293971394e7bc5241f0efb041dc8e759b857ad52d5ee4c331de766dde2a177071b01f7bcf2d0c1c360f841e250dabd3257652989a5df8563b9c8375512b4c990b1c4e2cecb2b206724722738ae3a7fb379ccc4119cb169bb583e179d0ebb316b1d70bc273ef9a653dfcb93777d58cc56da55e74f69b84c8e06db79d69c5a07900946718f7ac8ea2d5376bd5d05a63dfa65fed0004cc763c7f868ee2c731c694952903cf1b9f2ad43fa2acd72bdbb62b66653cc949b9dc9c42422383fc26d2309ef0ff4d58eafd41a76ce983a3eda38a304e6433013deb81b07e4f0f22bc6093d6ae92e283b37b3c36e72f524fd3d74bb49738c5bf82090cb2d838e31c67e65000e4e4d6825392f524c993e558ee2d5b994aa345509edc5e0e0510e1cf167729c67a5457b576acbd136fd376b62ded707020247c43c918db7186d18f5271e59a97a47b2d5aa2455eaa96f4f5b48188ca74a9b04925448c63724ec33ef513591d4baa916d8b2ad7a274e31f1ee238a5dc213aa98b6d3c882e0049511eb5122d97b4276c08b8af4fc1b73308079912de202128dc94b09dcb8b3f32964935f425a6d702d511316db1188ad018e06d0123ed531495e49046dfef5713dbc7ecba5b544d42eeda9da91739723056cb773319b4a31b20a50919c7bd71d2ba675b69f9f2e445d3ba79b32a4975c50571ac27f7109e5c213f7f3af67413e9ff148b095a70797de989e95e8716e3085b8d96dc29f124e36f6c54d8e95f0f12ca89f207ca9430d85050076f235d6ab185a28a28a296929680a28a283895a5249384f3cfae06f59d9dab61a65ae1db187ee92504a5423ecd36a1cc2dc38483e99abe9b15a9515d8b2101c65e4143883fbc08c1e55416ed09a6e0b65a8f05c4b273fb0549754d0cf3f09563f4e545e296e37994eacb173d46c40528e7e0ecc92fc8c7ab9838fa57287111224176dfa2a4c8715b7c5de5edcfae15c4afa62b750ad90a0a3821c6663a4f3eedb09fb8dfeb9a90961031cc90739277cd11984d9753cc1ff005ba81bb6b7fe45b1809feb56f5da2e87b0b4e77b25a7ee0f7f9935f53bf63e1fb5694818df150ee573876d63be9f21b6104e13c47751e807327d0503a2c1890d0111a330c01b0086c26bcaa7b6d5f7b66948757ff6bb3a18912893e15be12aeec1fcc47172f415b5bddf2e0d59a5dd54c8b6c08cca9d2b7c65d5003f2f96fd6b29d96bf68d3fa61bb95d66f1de2ecb5ce7d23f6afa8ace52303246138e6051a9726bd0da7dc7080c4574233f3afc23fb9fa564b4ebcc3fda76a5727388131a6d866232a202831c2495a73cc289c123a0ab655d3504ecfe1d62f834793d725f01fd10327ef595ed16c9185b99b9ea371cba490ea5889162244505d5f24f1fcd8f73814bc6675b5bc6a0b0d9cad53a7b0cad29e2524ab2b23ae3a579b6a3ed4a56a075561d0505e933def07c52c61b6927e6231ccfbed5374bf64b674b9f19a8986e53ae1e2f834bab2c339e4012789c3ea4d6fda8fa7b4ec65a9b4dbed6d1ddc2021a07dfaffb55d6a49f2f31b2e86d56f5b9312e0e382321656b8ea74b0d2cf9a9486cf13a4f995ab7ab7ece3b386a2dbdc9ba8a203325aca9c869f0b0d273848294eca38eb9ad6af55db4e116e6e65cd6790891ca87f36c29bf13aa662496e2c3b4359f99f577ce04e3cc27c23eb530f4bc8ecc784c7751586d9693fba84003fb557cad53638ef2a3b93db71f4ec5a8f97579e984e4e7d2a28d37f14b26ef709d74c7f09d5f76c8ff00f09c67f5cd5e4081120b1dcc38ccc66ff2b4d840fb628ca9557cba3ca3f01a767ba93c96fad0ca7efbfdab83f70d6012b5b363b69094e52855c0f1afd3e5c7deb521206361b7a51c3fde832309dd7730a7e27f04b4364e484f1ca700e9cc27ef57715a90c3787ee0f4b59e6a294a07d00ab3e1f5cfbd2e2839c7e2eec151c93d6bad2639636c52d0145145014b494b4051451409bd34a8a71b13938f6a7e074a303a5034ec32795350b0a4f10d857420118236a409484f0848c74a0c16a3d6efa2f0ab1dae3b8dbad9c3d31f8ae2909f4421232e1fa27d692dec5cfbff008c81645489646f70bcbbc27dd284e4a47a0c56f3853f945094212721201f6a34c7ced30fdee2aa3ea5babb3597400e45613dc30a19ce08f995fa9abab0d86d9686f82dd6f8f153c213c48400a207204f33caae303a52e28c9812072daabef96a897786e41b84344a8ae270a6d7c8fafbfad59e074a28322de8c80c8436ccbbcb6c83e16917070a3db9ec2a65bf46e9d86b0e8b736fbc392e428ba47f366b4581d28c0e941c52cb694842470a4724a7614e4b680721201ea2ba6074a303a50371eb41df9d3b03a5181d28128a5c0e946074a04a29703a5181d28128a5c0e946074a04a29703a5181d2812968c0e945014514507ffd9', 10);
INSERT INTO firmas VALUES ('035312', 'orlando.jpg                                                     ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0000010501010100000000000000000000000102030405060708ffc4003d1000010303020403050703040007000000010203040005111221061331514161910714152271163252535581922342d1082443b12633627383a1c1ffc4001801010101010100000000000000000000000001030204ffc4001b11010003010101010000000000000000000001111202512141ffda000c03010002110311003f00fab8b43f0e28e50ed5608a68c671d4d7b18a1e58ed416f6a9f6ed4631e141072c7e114140fc22a6cb64e35a33db50a5d18dcf4a82b86cf52294b63f0d4e3046460f9839a5c0c74a7c29072f7ce28d1e5539029348ed56e043a3ca828dfa54b83da9306add88b47714a109ec2a4d34ba6970230d8cf851cbfa54a051ff74b1086f2371b51ca07c054a318c52ed4b10f2c76a4e58f14d4fb51b526443a3b0da8d1531e9b5000a9f043cbdfa52f2fff0048a9702969621e5e074a0b7e553628c6d4b1a545145792dad330a4118233504b91eeec95e853ae615a1b4900ac819d209d86ddea3bc5d60da6389139ed095381b6d3824b8b3f75231dced58f12d770bd464bdc4cbe5b6f30b69eb53470ca92a394f33c7983a1c1c6d5e9b6711fb25957b9f21a4b96388994a428352e3ffccd28f5d27eeed576dcdbb6f7931552ee3705bcacacbc53fd1494a88271fda74e9ef935a3163b51d8430c349434da425291e0074151499916284179e4b7cc586d3e39576da94b6accd86ccd485486e0361d27515ea39cfad12a685a8c4b6b425be15cb7083fd3614505492bee93d36ace664ccbd4e931d529501b8ae35fedd950e7ff007021c3ba742874c6f5b76d810ad70d3120b088f1db074a13d123393d6927c867db043e1db4c2893e636dbaf3896f27242df7092509f2c92067c00ad9ae51494f13713b6f1d5f0bb33c4359202254bc9493e7cbd240f351ea2baa252927529231d7247a50ea0b40a8cbcd05a505d402afbbf30f9be9de9fa86705401c7427151c83f74d22540ec0824101433d36cffd566dc2f36f8b11f7dc9280db2d29c5ec7384efb7a566fb3c6e427865173b9922e1705aa54ae6286a4e4ff4d27b61b0818ae9d67e5ba6a4f2a01cf4fad2d4724c67ad18c52fed4555a3477c5579331965f4c72b0a7dc429686875504e323c8ee3ad60f16711aadb164bac32eae345ca65bcd635851c2421beebcad0aed8cd695ba3c582cae5a9a521c710932243a46a70818d4af33e555728aef76990ec9f1552635bd96d1a9f4cc04a907fb47cbd72481572c12e5cfb242993e32634b79842df693d10e1482a03cb3d3cab0e1a07105d7e2b29f58b43042e0c756c87b4e4f3d40f62463e8722b7d571828b737715484888b09525dc6df31c0f5a8b31f1728aa29bbdb953588499493264254b69183f3253d4e7a54accf86fcf9105a7d2a911824be8c11a02b3a773b6f8351cd2ce4781de8f1ac66388632b885cb1c987261ca014a60ba014be91d4a48fa83bf7ad9f0cf7a24c50a0d1479511a54518a2bcaddc99b7486b8adfbbc89087e2fb986a3c757df697abe629f0c103d6af4698643ba571d71004e073569dcfec6a79115890bd4f3416718c9aa0ff000e591d3a9cb7344f89c9ff0035e9677e98e42bacb78aa45ddb88cb6e6b6c435005c4fe05e7ff00ca9d2c5ba2b6f250869a0fab98e632752bbd31be1fb33782ddbda491e209ff0035763c4618186d94815534e56c10386786a6dc25c79cf29eb839cc925d493f3649c8c0f335a52788f879e8ee32bb97cab494921b5743b76ae8015246d81fb0da9a004f8271e691516e1ce3523855eb74380dada31a1f2cc7468580d96f6463cc6055f6a359e4c57985e97db92e29c781ce164f5cfa0f4ad320608d291dbe51469f9464035534cd4d82cab8b023082c96a03a97e227270d2d3d142af4ab64596ec67a4b2875d8ee87d9249f916010143cf04fad4db8480293c7b542d0cf871a74631e5b0dbcd95255a5436d492083ea05537edb6e522421cb7256653c1f7803f7d6121215d7b002b4b4e37c521009071d3a557572a6ecb7db0345ba42f1b7ca4540bb9ce4f4b14e57d149ff0035a86803ce96e3e31557a9e0e3ecc5c8f98523fcd31778b8ad0a48e1ab9a72938f991dbeb5bb484ef45b711c296d970025cba5a674e92cc85bb19c71493ca0a4e9247990559fad74b25b66e71d0ccfb53ae210e25c4a56460292720ec7c0d688233d29c3c71565666d138d332a3b91a431965d494ad27a107c36a6a60c24c16e0a5a488cda03686bc0240000ff00e854f40f4a891281711be5069096c251ba463a7d2a098c4c7dbe594437119c90b0772371d2af5142d98e0e2027e5f8591e1a92ada86cf100185fc30efe0155a62838a25a92be2e4ec608fd954e63e27cff00f72617271ff1856acfef56c1f2a5f0e942da3452ef45795ab3c8a69eb8c13563dd5cfc69a3dd17f8d35bee19e65063b52818a9bdd17f8c52fbaaf1f7d34df266501f2a0f4a91d6394da9c75f421091952947000f3351475479092a8f3a3bc9040250e050c9e836a6f933241d290ee3c054bca6d2d25cf78642178d2ad5b2b3d307c739a471a6db2439259414a4ac852b1848ea7e9e74dc199479341fad3e406186c38fcb61a41e8a5a8241fdcd44e3d09b436e3b72868439f714a7400afa1cef4df2664ede8a952c051f95f6d5b03b1cec7a1a62c474070ae6b080d901654b034138c03db391eb4df3e9993681b539ee447495489919a483a72b5848c9e837fa1a6b8b8686132173e2a5959c25c2e00951ec0f43d0fa537cac4481e541183bd4bca6cb3ce121ae569d7af57cb8ef9e98a89d7a134db6b76e311097065b529d002c6dd0e77ea3d69be7d2a463b0a3f6a1e5c563407ae115ae60ca35b806a1dc67ad2b86336f861d9d190f2ba36a70051fdbad37cfa9992518a5cc6f7af75f7e8fef1f95cc1afa67eef5e943aa8acbc965e9d19b717f750b70052bc3607ad37cfa664940f5a950da149d4892d11ab46cafeeedf5f2a879b0f9896be231038bc694f3464e7a6078e7c3bd37cfa664b4b803c29c390a926309ac17c0c96b58d7e9d6a6f7459df98314df3e999573dbc690d59f745fe3147ba39f9829be7d332b3453b1e74560d4b45370aef4615de81d45370aef4615de8395f6bd6e9175f66f7fb745b73974724415a04142825527bb609c0054323f7af28f661c27718b26f322d7ece64f05dadfbb59dd62dcebc852cf25e2a7ddf954469d253b673f29afa070aef4615de83e746871e4cf621c3f617bd9a5f63dcb84deb02b90e4860aae022ba82e968856060339f9b1f7d3e75d9710f0e4bf69369b1dd6e9c3d78e1c94f3ee5bee50dc7db2e9b7a89538db8524a4a16a69bce37c28d7aabcea59c731c4a012120a9400c938037f12680ea0ab487539d5a7ef78f6faf5f4a0f29f6f3c3926e0df0fad7c1cef18f0f422ea65d8e3ac21c71d294865d05440d2801c0467395a7cebceaedec9f89788d3c0f16370758dab7dbe2dd96b81c4016e31010f4b6dc8f1c869592e25ac241048c255e55f4f6e0649c014c43a160a92a046a29c839e871ff741e49c3b2b89b8678bed7123f015fa75ba7592d90dc9bef0ce212d95c84ac3a0ab2484b893f2e735e6974f66bed46e56de2476f96f8d258e3230e7ca87116ae74371ab9c77036e151d25498eeba8ca76d31523af5fa94beda4e14e252719dce3600127e832282f25294a96b090aee761d7c7f6341f3a7b56e13e31bdc46957be093c4e989c5f124c9890569437361b7164242d3ad4318e63695027750563622b46f5c32f2bd9df0fc799ec8dfbbf0fb3264adae1243a812202d64725c528ac20a523de41c13ff9ede3a1c7bda9e424289713841c28ea1b138c03e7b8a52b485049580a51c004e32773b77e87d283c724704716dd7fd3948e0661df845c2e41c8f150e2b57c3a138f6b430e91d4a19fe91d39f2cf5ae3667b29e33bcd9385ac73b853849f3c3ac5d2228dc90f2a1a90a7a32995464a15a924a029235f4d0acf515f49a1e4b817ca5a5c28569504a81c1c6707b1c11b79d1cf6c35cd2ea437a756bcfcba7be7a63c683e73bdf067318e196ef5ecaf88f8b61b1c3d0e143e7ca67dead4eb6b74baa715a9292b50531ba411fd2a938bb832f523da15e9fbafb3f95c43789f724bb64e288cea12d59e3610186ca54a0acb4a4a96ac039d6715f456b569c80a3e5481d416f989712518cea076c633d7e941e116ae18badbff00d4e2aeb0fd9c2df83265ca93338aee2e256eb65514a5088e12a1a5a184b785249f995f5ab1c6dc2aebded88dcaff00ecde5f1734f4b86bb4dd62bc84a6d0d234652a0a50248742dc38072950f1af6e6df69c290dbc85eace9d2a0738383e8763da952f36a4158792500e09ced9ce31ebb50794f0470d5fe0d9a5b32edcf32e2f8fa6dd005286f1572dc5a5cd8f42920e2b97b17b2460f15fb20be5cf851b326d3c3c137c90a5e4b5323c78898daf0add485a1dc6323639af7d2fb5c8e7f3d1c9d1af99a869d3d739e98f3a9124ab383d0e283e7e85c1dc4e8f6b31a623844c7bf337c5cd99c60a701625dbd4b51f740907582195a1a194e3537d71bd7d068c636ef498577a30aef40ea29b8577a30aef40ea293068a0673d8fce6ff90a39ec7e737fc8550fb3f65fd398f4a3ecfd97f4e63d282ff3d8fce6ff0090a39ec7e737fc8550fb3f65fd398f4a3ecfd97f4e63d282ff003d8fce6ff90a39ec7e737fc8550fb3f65fd398f4a3ecfd97f4e63d2839ef69509eb8af875c660a6eb121df234995112e2415246b4a5cdc81869c536f1ffdada98203aae36b55c9883eed6f61cb825f6cb8920bee72b44bebd34a1e6fbff5fa75ae93e0166fd398f4faff00934a6c3672306dec91f4fde82e879809239cdf9fce2aa4162df0592cc52c30dade75e5250a1bb8e2d4b5abea54a51fa9a67d9fb36ad5f0e633df140b059874b731e94191c64c0991e4b4c5b932652ecf3996650712394561b1caebd5c2127ff88f9562710db6f771b3cc8090ea588f624468cc21e481225aca4952b7ff008f94803a6ce39d7231d99b0d9c820dbd9c1ebb506c3673d6decee00e9e028399e09b54d30ef6d717260bb2265c1892e9654430f38989152a5b609c84739a5e9077f9466acdd84cbade385e77b8aa3a205ea4ae4256ea728644696ca1dd8fdd5953640ea03833d0d6e9b0d9c9c9b7b24e00e9e03a521b0598e736e60e460ed418dc1b6c45aef7c60fa986a3b373bca65b2a0e021e061456d4bebb7cedac7d535c7de3877885eff4ff000f87e2bfcab8b3c1af40916fe68d6f493039486f567190e78e6bd28586ce318b7b3b74dbcf349f67ecb8c7c398c7d2825b82cbd11f6a3cc699796d2c36bd43e5563e53fb5724e44b833ec8a35962c10d5c1cb747b798c5c49f772e0434b5ab7dc3614a59c1c90938deba8570fd9540055b982074da97e0367c93f0f677ebb7ed41c570e70e2ac1c7f6b6603321566856fbc29535e79052a7e6ce8d24360039db4ba06dd122aa8892ad7ecfcb3704f2bff184896f235856633b7a71d428e3c0b6b42b1d8d77ff0001b3e9d3f0f6719ce31486c1663d6dcc1fa8a0e193674da6cb2ecf7a90c47e06b331383aca8957bc42532343242724b2d21c908d38d5fd16719c1cf55ecf15746780b87dae247f37a45ae326e25c71256640693cdd446c4ebd59c5682ac16651caadcc1392771de93ecfd9718f8731e9417f9ec7e737fc851cf63f39bfe42a87d9fb2fe9cc7a51f67ecbfa731e9417f9ec7e737fc851cf63f39bfe42a87d9fb2fe9cc7a51f67ecbfa731e941a791de8a6e84fe114507ffd9', 11);
INSERT INTO firmas VALUES ('035320', 'oscar.jpg                                                       ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001b00010002030101000000000000000000000001040203050608ffc4003810000202020004040502030607000000000102000304110512213113415181062261719132a114152333425262d1f03443728292c1e1ffc40014010100000000000000000000000000000000ffc40014110100000000000000000000000000000000ffda000c03010002110311003f00fab6222022255e239f8dc3ea4b325d979dc256a8a599d8f9281d49d75f6816a26ac6b93231ebbebdf258bcc363447b4db011110111101111011110111101111011110111101111011110111101224ca39cd6645dfc0d163d7b50f7dabd0aa13a001f56d7b0fb88177739f8b526567bf10b395c57cd563f43f28ecedf727637e8a35de52e2983570bc25bf86b594e4974a431b19f983b8525813d740f37fdbf79dcaab5aeb4aab0422285504f90e8206340214ececf331fcb13d3f336485fd23bfbc980888808881d6069c8c9a71d41bac0bbe8a3b96fb0ee7da573c4e8423c6af22842c14596d4caa77f5d74f796568abc7fe279078857979cf703d07a49baa4baa7aad50f5ba95653d88f4303679c4a9c30b8c7f06de6e7a58d44b9db103f493f52bca7de5b808890cc154b31d00364fa409890372602222022220222202222022220617589554f6d8dca88a599bd00ea4fe257e194b263f8b6d6a97dede2da07f888edec34a3e8265c4395eb4c664e717b8ac83db5a2cdbfa72a91ef2c790814b3cf3ba14adac3532740be6cc177bfa02c48971ce937b1f998d1d41b3a12e77bedb1d87ec07bcc32ac6aebb2c5a9ed34d66ce44eec7474a3ea7a881bb63726792e05c7f8d67714e1af763610e1fc46ab2c514bb33d01157ab376d9240d6ba169dbe13c5e9e255e45d553757452c42dd68e54b540eaea7fc3bdf5fa6e074a279ccef8cb84609a6cca1954e2deea94e4b527c3b093a2479e8021b64751bd4df5fc4fc36ea2d7a3c76beb2aab8ef514b6c2c74ba07c8907af61a303b7b907ae80ee4ebfdfa7de6ac44b8521b21b76b80cea0ed54ebb2fd07ff663c4d9d30721ea602c1537275d7cdae9fbc0abf0ce56466f095cac93d6db6c7abe5e5dd7cedc9d3fe9d7b4e9cd5894ae362d38c8c592a454527cc01a133774ad1acb182a28e624f6007781ab1bfe232b4badd8093bee7917fd04df2a70ce76a5f21d4a1c87367291a20682aec791e555dfd65b815efcca69ccc7c47e6f172039ac05d8d280493e83a81f72264edcf90b503ae51ceda3ff008fefd7da515b691c433788d961f0f180c75f601db5f5259575eab35714e295f02e0adc433c7f5ad61fd31e6e47ca9ec068fd8981d8fc475f49e3be1cb7e22e2dc66ae277661af86aab135aae91b635ca37d580efcc7a7a4ebd3c69edcce2d6354a9c37876d5efd9e76754e66017d07481dbf2dc4f29fcc38de67c398b98cc9c3f2f32dad28ad139880cfddb987401031d7d37bf297be2ce32dc353171b1dea5c8cbb96b0efd56943d3c46fa0240ebd09303b8364796e6296d6f63d6b62174d73283d46fb6c4f23c0aa7cbf8a32929e3d9b9989848afccd6020dee1d495d742a003d3b6fe92d708c6c0c0f8ab889a85386b5535d5a6b34d7336dcbfcc7ec3f303d3cd54645191cc68be9b429e56f0ec0da3e8747bca078af0fcae2391c26c60374f3733372adaa490429f3d74debd7ef39786f815fc6f5e2f08af1c28c27397e06820f99793b742ddfd8c0f51111011110355c407ab7adf3f4dfd8c9b4808aa3fbe4281befebfb6cfb4c72aa16a29de9d1b9d1b5bd1ff00420907b6c123ce5447e276e73a363e2a5752e859e296db1f30baf21e5bf3ee605e7708a3a1663fa5477329710cfaf86d55f894df7df7b155af1ea2cceda1f8006ba9d7979cb888bb2fd4b1f33e43d3e9367bc0f3f81c3f37229e35e327f2fa7888d5158219eb66ac2bd848f363a3adf753e6499a72fe19cbcef87cf0acbe356a8f052a438f5f8689cbcbfdd076dbe53dcf9f613d2ebaee207169e0f7645d8177141885787f5c7a685254372e8312de9d7435d37d77d25e6e1784dc6138bb520e6253e023ecfca9b27407bf7973526040985f4a5e812c50cbceadca7cca90c3f7026c88147f99e29e88d6d966f5c8b5316dfdb520d3919aead96be063290c29d82d61ff003eba6bfca3cfb9f297fafac8d40c10d9e338655f0f4391831d9f5d8f2fc9fd84ccf69310383c370f2aecdb3f8ba0d38f8b956d9503ff003dd9d995feca08d7d7ed27e24e13667712e1f989898d9a98c2c0d45f6155db0003f620eb5d883de7735102ae3e3e4165b32ee5e65fd3555d113ebd7ab1efd4fe04c38470dab8770d18418ddb2cd6d96005ad763b666f524932efd24c0adc430a8cea16abb9c7238746ad8ab230ec548ec66189c330b1bc535d219eefed5ec62ecff727acb91034a63509778c952a59e18ab6bd3e507607ee66c6ad18ed9149fb4ca2057cbc2c3cb555cac5a2e0bfa43d60ebedb9a70387d18997917554d750b0222045000550743f2cd2f488131110111102199554b33055036493a026ba148405800cdd5bef3271cc397dfdbfdf4f7990fcc09888808888088880888808888088880888808888088880888808888088880888810075dffee4c44044440444404444044440444404444044440444404444044440444404444044440fffd9', 12);
INSERT INTO firmas VALUES ('035329', 'roosvelt.jpg                                                    ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108005b00d103012200021101031101ffc4001c0001000105010100000000000000000000000601020304050708ffc400411000010303030106030504070901000000010203040005110612213107132241516114327108528191f015234262168292a1a2b1d11724335355637293c1e1ffc400160101010100000000000000000000000000000102ffc4001a110101010003010000000000000000000000110102213151ffda000c03010002110311003f00fb2e94a50294a50294a50294a50294a50294a50294a50294a50294a50294a50294a50407b73d291758693896c94fc8650d4f43e14ceddd90db89c788118f11af03b976476e3a9a0d8a1ce99b96c2a4ca714db6b0c309dc37700654a5e13d7807cf15f51eaa4855bdb49f3780ff000aabc97b3d42ee1a93596a17a1263976f06dd1d455bfbc6a23696c2c724252b5959c719c723a5675accc8f9c3535aadf60ed1e669690a724c68cfa5b53eda12164161b7738c9f2708c63f84fbd7a833d8a4159466e9270a1b90421b2149f220e3a608e6acd6ed5857abef295c547c6bdaaad0ccd7bbbe432f4471839574186ca88f4c83e7c7a4761b7217deca2c13d0c9682595c609520a55861d5b2320f39c360f975abcaa71cbbda07fec42ddff5599ffadbff004a57b8f72bf7a562eb7313551c739a020f4ac6e91c03eb583bc39f08ce4e00add623729514d3badb4eea57653760be45b82a2101f0d1394056769e4720e3850c83ebcd77d9959561c181f7bd2891b94ab52e21432920fe355dc2a8ad2a9b85370a0ad2a9b85370a0ad2ad53894f5501f53540eb67a2d07e8aa0be956175b03256903dcd3bd47df4fe7417d2acef5bce37a7f3a77cd7fcc47f68508be958cbcce397103fac2a82447c9c3cd6475f18a0cb4ab12e2163c0a0a1ec73575056954c8a645072f553ccc6b52a5485a1b65825d5ad6404a5294a89249e800cf3e5d6bc93ecf969936aec7b4eb531f0ebd223b934b9bcab72643ab7904a89393b5d464927eb52dfb425cd16eec8b533a1650e0b7ad0950495614e7ee91c0fe6707ff0078ae95aad11ad1688b67b736a6e2c1651163a16aced6db4842467d7091537b6b8be65d6ea59ed075fbea5e50c5eac24257b8270969e4919e07503a673cf1e218f5cfb37b096bb21b4b69c8407250482e05ed024ba3a800751d30315e57da2428cf5cfb597de69614ccfb2badac0f957b143090064f1b8924e0057033cd7b3761709307b27d3ec8515f791952324839ef5c53bc63cbc7c7b537c33ad4cffae3f5f852b2f83eeff79a565aaeb973712bce46339e6b42f8c19d6799092ef766430e3695e4f84a92403918231ec735b9b94719233d7351eed09c5c6d19729ff10b65305a139d5a481e06087569e7d52823f1aa88d6b8b6c7d3d78d27a8accc4763e126b367943bb090a8525496805a8608d8e06949f2f504e089eee25209e9f5e950eedd3f75d985ed5ddb4e3ad7c3a9a0f2f6a54e264b451c8239dc13e639c0cd4c32304eec240f5f2f6f6a0ca956e4fca3d0f354493e67ea3351bfe91cb9fa5a1ea1d336c4dd99931c4944772418eead053b82519429257ce30a52467cc5566ea58ffb020dce12125eb838db10d896b2d65e5f56d6539daa4ed592307e43ed5a125dde123278aaee03839cfad45a3cdd470aff001d8babf064409a1686dc65a2daa3bc304239f9d2a1bb93820a7a60d5d7dbecb8da8acb60b6c50f4db83aa7df253b84688d11de2d58e9b8a92da7f997edc4126cf076f4cfad144a53c6726b0477597c28b2b6d7ddacb6e14a82b6ac632938cf233c8ae7e99bb9bc353d4f3458721dc64c15a73d7ba59095633e68293f8d074c81b87b1f2ab653a88cc38fad7b50da4a89f6033fafd1ae42f50c46b4da6f8f36ea1a53615dc230e38564e0213c8c9270319039e4e3246e586ed6dbe4779d82f36f34c3ea8d2507e669c4e096d60f456d524e09e8aa60e24fbe3afc1d117467fddd8ba4e64bed901476bd0a414249e9ff0010b7cf9918f3a96a4610324abcc2b039f7af9f5bd562dbd95daed922c7a924c9d3d2028cf621a5c8ad390642ca90e292ade329654824a38de09c035ef36e9912e111a9b09d0fc67d216db806378f5e7915746c94e4f23d79ad3bc5c625b2209128a8a4b886929405296a2a2060247271d78f204f956ef1b79cf3e58a82f6c6c29cb769b94adddcc3d4d6f92f9ea3605a93c8f31950fc71504d4206fe98f7f2355daae983cf9827fd6aedbc641c8f5ce6a03a8d37abcea4bac7b65caea63da598c810add2910d4a7dc25c56e7168214437dd148c84f8b0704935304e436a1c27c20f98fff002ae0dba08c2d5f813515ecf6e53156b931ae5739171113c6d4990c86dfeef2a4f76ea07475b536b428f39c0393935cd91da44bb6ba27ddb475d1bd36fa9262de633cdc86cb2a08297dc6d277b6df889c9f21e67682dc2a7610b1b885ac13d7c448aa2b7e701c51fc48c7f7d504d865519a3299ef25a54a8e9de0f7c948c928fbc0020e47ad682efb66fdbc9b08b94517528ca627789ef1436956427a9e0138eb8e714f079ffda6db92f764d3a1b2b587664a88c2523c4544be8207427a804e39c0f6af4b4a0e494852411c839c8fc4f9d407ed1ccb87b25b8ce8ddf7c4dbde8f2980c91bf7a5e4004678e37679047b67047a214849c67183efe5e7cd15f2af6c32a13178ed563a1212e2ae16665cca725c5ae33eb4a539e323e6f0f239f4e7e8ad11667ac3a2ac76494a4adfb75b63457084803736d2504e3ea0d7ce5da7c49337ed1afe8d71b7245bef57fb54e79bd81236311121d083ea5b5b9923ee24791cfd4cd9502028252b23e518c9f6c7b55d670eed5ed4acdb57f795fe1a548ac801037240c8c715a3a8edc8be582e56671dee9bb8447a238a23e54b882827f235d37d9536a0af993ebd4d6b856158079cfe7fe943d417b40fdbb7ad1f6a89034fb9777643b1674a684d4309408ee3724b456be095adb0d8fa9dc53d47534aeb485789eab74ab7dcac97968778bb6dc9b0dbaa48eaa6c8252e241e3724e2a44db21a49427246e2a39eb927358a5418921d8eeca8ccbab8ae77d1d6a1e2697823724f549209071d4120e452885f635310d69f7f4ab8f38ab9d8a64886eb4e8c38a6d2e6e6dc4a72496d4db8d90a1ebcd45aeb785c7685fad9216edbb4f6b5509d2a48538447793b246c0002ac29f4a5270a213c92ae55539d67a0f4eea89289d318910ae4de0267c2703123683c24a80e4727a838c9c6335d2b0e9cb2d9f4d37a7214341b7210a42da77f79df05677efcfcfbb71ce7820e3a714bf1638dacaf2d3d74d316bb6bd1664997746e4610f2543b86925c7159e838e7df9c64d6a6add113b51ea97a5cbd4332359655bda892a0474a52e3c90e2d4a47798f0a15b920e012a1b86461253d6d2da0b4a699b948b959ad0d4696f0d85e2e2dc5a1048f0a0a89d8384f09c7ca3d2ba72ec6c3b28ca666dce12d454a52634b5a5b5156324b649413c7ddf5f5a544124e9eb4767ba92c9a834d44f82893a6376bbbb21c7169710f1dacb8a5289dbb1cc0cffddc799cf52defa74cf6ab3edceb8862dda99089d0091b51f1880969f6c7f3293dcb83279390335d0b9e8d374ba419776d4376991a0cc6e6330406db614f37f21596d214b00f3b49c67a820e2bb1a86c76cd476f55bef11d2fb255bd0ae8b6d60602d0a1ca55c9191e448e8714ab1e610af3a86f70edf0e2b8c5acced4971f859e1b52995a1b65dc1d8719ca8ac01e1cf779c54fb4858a2e8ab03ad3d749b73932a607644c9853de3f25cd8d800240090484809e7ae49249358e4e82b3ff0042e269984a9505980a0ec294d3855223bc0a887428f255b96a27ff00238c7154d2fa56f91ae22e1aab5948d48f30add0db10911588e48292b284a9456e10a50dca3c0278e734bd4466b15ad36fd45a8edd222855baf0f7c7b4a0da5285a9c6836fb2539254a05b0e151090aeff0003250a35b9d9e34fc7d0d66872c0f898b0d111fdaa24071a1dda864f27949e4d77b61249c78879e7e9e7e9ed5469aeedb0949380a27c4a24e49c9e4f964f4f2a5171270322a3fda05855aa3475cac6973ba7a4b5fb95925203a8216dee23909de94eec738c81d72245b77704e4f9e0d0a57b791cf4f4aa233d9e6a54ea5d38992f30b8f708c447b8b0b484a99909f0b80e0e08dc0e08e3c8e14081c9b6c966cfdb0df2df70723a3f6f458d2600dd8515b48ee5d68e4f5c06943a641e326bab7ed0b63ba5c0dd108976bb92d4953d3ad721515f74001202d69e55e1013cf384819c01549fa074c4fd3c2c73a0194ca5cefcbeeb8a324bfb7697cba4ef2ee3037673800740054dd446adf2e25afb7cb95a9b5128bbdad2fa864009949572d7b1284a9ce7ef1c7b66ec89322140bf682b932b537a7657c3c57243fdfae540782951f7f00e7bb25b3907e4c73826b6ee3a221d9348a9ad3f11f9570832dab9c654870bcf3aeb24612544f3946f401c0f193d49264c2cd0d5a9d1a8d3de2277c1984bd85252eb457bd21581e2daadc53cf1de2fef1ab4797c179cd35adf4c595c8c1c81699d3ed664a9cca9a6e4a59761e41ea48cb791c61b59e31e19af6b10a1cbd0d3ae7254b8aed9195dd62cadb95c67584a9614383c100823072952863a636755e8fb6ea18d3d0fa830f4e8adc771e4021682d385c6160e470852dce06376f209c71507b95ff5ec4b19d1978d092ef53a54454445ce390fc1712a4f765c905c4e3a282885e3778b2060d2f826fa9e0235b767570b6b7b5a376b7a90d9706e4b6e293e02a1e612b033c8cedebcd41bb3aed7b4a47ecf2dedeaabbb96bbc5ada4439f12630eaa6175bf015969082a2a56ddcada0ec51503ca4d7a4e95b5bd6ad336fb4c9784976346436e3d8202d613859009240273819e9e66bce7b77d3d680e46bcc3ec9ad7abafb3dcf87f8976de1e2d2c27f745dc208d99182b73084a460a8022915e53a235ab7ad7ed2f23525bad4fbc550dc8d684b6d654c2c341097dc50e31b0bf9f201684f273bbea2b6b4fa61a3bf5ee78a121648ea73ce00240192481e4303cabc1fb05d0f274176bd26cd782c4cba4fd3867b8fb314210c28c9085b285755a7294925381f28206135f4401d4139cfbfeb34dd31abb0fdd1fd9a56cec1fa34a83a840c56b986c956eda73f5ad9a5698ad6f836f1fc5fdaaa184d7f38fa1adaa5069fc0b39c8de0fd6aa21343c95f89adba516b544267d0fe755f83647202b3f5ad9a511adf08d139215f9d57e11adc15b493ee6b62945ac263b64007271ef54f856ff0098fd4d67a5118bb8479e7f3a7708f4acb4a0c5dca700609c7a9ab4b008e5449f7159e9520d5f8623f8f3ff00caa061dcfce2b6e9556b50c657b66ad315c272543dfaf35bb434895a2eb0b43795292403cd6b75575c83e79fd7e85746563b9567dbfceb9c523248073e783e751bcd644821383ebcd1401e770e339356058ce094e39e957ab24601ce3a0c1a8af3bbfc28f0fb7ad2d786d084caba58e6db4b81ceadb4a6df1e02707952b9009e4678af43c2783e49e99a827687152d6b9ecfef8b28436c5d5d80338ca4c88ee60a78c9c96d29ebfc7ed53d19f53d3a8e9414c9f5fef34abb7ff31fc852891d1a5295a60a52940a52940a52940a52940a52940a52940a52940a52940a529418660258501d78ff003ae6282ba85608f6aec2be53f4ae39030063f8ab3beb5c57a338dbd47d0d51b754a2b050b4ed56dc91c2b80723d7d39c720fa7363672819f535993c0e3f5d68a8776bf68b85cb47b52ecb11c9577b45c62dce13214121c71975254939201f015f1ebef529b6aa518118cd4a512cb292fa52bde12e606e0158008ce46703a795665800248001c0e7f3a33e34a8ab9239a11764fde1fafc694a507ffd9', 13);
INSERT INTO firmas VALUES ('035337', 'ruben.jpg                                                       ', '\xffd8ffe000104a46494600010101004800480000fffe00134372656174656420776974682047494d50ffdb0043000503040404030504040405050506070c08070707070f0b0b090c110f1212110f111113161c1713141a1511111821181a1d1d1f1f1f13172224221e241c1e1f1effdb0043010505050706070e08080e1e1411141e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1e1effc0001108001f00f603012200021101031101ffc4001c0001000300030101000000000000000000000405060102070308ffc400391000020104020101060501040b00000000010203000405110612211307141531519122416171a1321623244226336263728182a2a3b1b2ffc40014010100000000000000000000000000000000ffc40014110100000000000000000000000000000000ffda000c03010002110311003f00fd974a52814a52814a5469afece296784ceaf3c10fad2411fe394279d3745db1de881a1e48d0a0934a896f7e9738d37b6b6d7920ea4ac4f03412b7e9d65ea41fdf55db1b7335dda2cd3e3ee6c1c9f30dc3465c7fce3665fe6824d2b3dc833797c1d9e4f2f7d89b27c3e3ad65ba92482f99ae5d2342e4088c417b100e87a9af979ab7c45e7c47156790f75bab4f798126f77ba8fa4d176507a3aff9586f447e441a0954aa7beb7e50f3936598c3c316fc2cd8b924603f7170bffaaaebee43756ef3632d66b5c9655248e092482ddc41652483f019c07661bdafe11e74ca4f553dc06a6ba892332b441d4c8aa19977e403bd123e8747ec6bc9ef79760b2d75eef719bb5b643209a7be16f2ce2320a002d4ba94e81e3473390230523609d9fbadbf1af685ecd2cf1eeb8cc82595a1903b4d2dbcaa6666ea3d6919876ecc77b6974c423b9da82f41e8755f659bc65f64a6c7d95cfbccd003eb3431b3c51b06ea51a503a0901f9c65bb01e75af3582e45cd71399bd38b9720d8cc3ab2acf34d148925c1e864f4fd3688fe02a07e162a5bbc7b56491167d35af2de1f6365e9c197b75b788369c1670e7b68e9fcfa8ece587824bbac806d95f41a7a553f17cfc5c86192eececaee2b204ac53ce157d560eeac02efb0d7504f6008efa2032b2af3c8b2471e910192b5b6966244513da3dc4b3686d82468c19c81e4f50740127c505bd2bc927e67ccee6f63b5b4c860d0dc4e22c7aa58f77be65650e414b99163855bb24921075e026dc8036d83cbe330f89871f98e578db8bdb7859e7792e9415552e1bfa98b154f4dd7b392dfdd9ecc5831a0d2d75324625588ba89194b2a6fc9035b207d06c7dc563b90f3481edaca0c05d5afa97b134ef7b7320861b281365da4ee369210b2055653e6372c351b0ae30b2dcdadc5e59f1c8b8ee5ef2128b91964cdc82e038055448045230d052076627c1d9276683694af85935dbdbab5ec104337f992198c8a3fea2aa4fdaba64aea7b483d4831d757edbff576ed186ffc8ea3f9a0954a8965792cd626e6e71f7762c012619ba3c800fd226707f6049ae2d72767716905d7a925ba5c3f4896ea17b7766de82f4902b0275e06bcd04ca52940a52940a52940aaec963ef2eaf6dee2df3b90b08e107bdbc31c0d1cdff1f78d9fc7fb2cb5634a0a6bdb5e50cc3dc73388893fdfe2e495beeb3a0fe2a2af1ec8de16f8e65fd70c347e1cf7763ffcdcb6ab474a0cc2f06c2a6cade72627e8dc9b2247f33d44e3583ce60246b2b1b3b7f86a8096cb3e7a79bdd6354555448cc236a3aef4ce4f93e75a03654a0aec5439b8bd4f8a6431f740b6e316d62f0755fa1ed2becfebe3f6aeb8fc9dedcdf496f371ec9d944bf2b89e4b731bfec12566fba8ab3a50673da3d8dbdff09ccd8bc1da4bcb29ad6265b492728f2215562b1ab36812092078a89828b8af20b7863bfe398db6ca9b78e6b9c7ddd8a896225577a0e80ba027af703a9208076081aea506766e0bc2a52ccdc438f966d6dbe1d16ce89237f87c8f27c7ea7eb5517fecdf04f6e2dec38df06822077d27e3492afd848bf99adcd283cd07b2db7330924c37b3463f5fec580df7f79ab2b0f665c5221fe3388f06949f0de871b8a2dfdd9bf5adcd283333f06e0715b387e15c79a22e1dd171113f66f903d421d9f27cebf3355f75ecff008de72f20bdc9f15c1db42be9cc2dfe1d0fbc338db949655d8ebd986d13c12876eeaec95b6a504336ff000fc50b7c35859a182211db5b76f42101469576aadd5401af0a75f4a80fc7ec32315ecd97c745ef592b64b6bd58eea4910a21728aac7aeb45d882aaa7649f9f9abba506378d7b3fc4632467c863f09929238e18adee1b1bab80b11057d491ddfb9055082a100e8a00d050b325f67fc2a4dffa318c88b46b131861111645218292ba2402aa40fa81f4ad352830727b21f67f24ef39c25cc6ed1884fa794ba41e98014280b280174aa35f4007e42bbe03d9df19b7c7836b67c9b0e243f8ed8724bd461d408d49f4ae4aff0042201a274a1478d686e69414d8ce338ec7b87b7b9cd391f2f78ccddce3ed24ac0d5c228550a37a1f5249fe6b9a502a9790f1bb4ce14f7bbdc8c68a086862b92b0caa7c159233b49148f055810413e2aea9419f3c7b240a88799e7608d400b147058f5007c80ddb9356b6169716cba9b27777875f3996207fec45a974a05294a05294a0ffd9', 14);


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: usuarios; Owner: postgres
--

INSERT INTO usuarios VALUES (16, 'GIOVANNY', 'PAZ', 98387334, 3, 'giovanny', '', NULL);
INSERT INTO usuarios VALUES (15, 'FERNANDO', 'MORILLO', 87513982, 1, 'fernando', NULL, 5);
INSERT INTO usuarios VALUES (14, 'OSCAR', 'VERNAZA', 87061691, 1, 'oscar', NULL, 12);
INSERT INTO usuarios VALUES (11, 'JONATHAN', 'ARTEAGA', 1130639614, 1, 'admin', 'df20d125770ba0c73e7995cbe5ac23c3', 9);
INSERT INTO usuarios VALUES (13, 'HENRY', 'TORRES', 12981551, 1, 'henry', NULL, 7);
INSERT INTO usuarios VALUES (12, 'RUBEN DARIO', 'SANCHEZ RIVERA', 16379400, 1, 'ruben', NULL, 14);
INSERT INTO usuarios VALUES (10, 'Frederick', 'Mejía Cifuentes', 1143835907, 1, 'frederick', NULL, 6);
INSERT INTO usuarios VALUES (9, 'CAMILO', 'MURCIA', 1144025705, 1, 'camilo', NULL, 3);
INSERT INTO usuarios VALUES (8, 'ORLANDO', 'ARCOS', 16379511, 1, 'orlando', NULL, 11);
INSERT INTO usuarios VALUES (7, 'JOVAN  CELISQUI', 'ALZATE  BONILLA', 94449866, 1, 'jovan', NULL, 10);
INSERT INTO usuarios VALUES (6, 'ROOSVELT', 'CANO', 94474470, 1, 'roosvelt', NULL, 13);
INSERT INTO usuarios VALUES (5, 'JAIRO ANDRES', 'SAMUDIO MARTINEZ', 87573691, 1, 'jairo', NULL, 8);
INSERT INTO usuarios VALUES (4, 'ALVARO EDWIN', 'GUERRERO VALLEJOS', 13070371, 1, 'edwin', NULL, 4);
INSERT INTO usuarios VALUES (3, 'BAYRON RAUL', 'ERAZO LAOS', 98326794, 1, 'bayron', NULL, 2);
INSERT INTO usuarios VALUES (2, 'ANDRES', 'ZAMUDIO SALAZAR', 16777074, 2, 'andres
', NULL, 1);


SET search_path = viaticos, pg_catalog;

--
-- Data for Name: cuenta_cobro; Type: TABLE DATA; Schema: viaticos; Owner: postgres
--



--
-- Data for Name: detalle_cuenta_cobro; Type: TABLE DATA; Schema: viaticos; Owner: postgres
--



SET search_path = cargo, pg_catalog;

--
-- Name: cargo_pkey; Type: CONSTRAINT; Schema: cargo; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id_cargo);


SET search_path = desplazamientos, pg_catalog;

--
-- Name: desplazamiento_pkey; Type: CONSTRAINT; Schema: desplazamientos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desplazamiento
    ADD CONSTRAINT desplazamiento_pkey PRIMARY KEY (id_desplazamiento);


SET search_path = usuarios, pg_catalog;

--
-- Name: pk_idfirmas; Type: CONSTRAINT; Schema: usuarios; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY firmas
    ADD CONSTRAINT pk_idfirmas PRIMARY KEY (id_firmas);


--
-- Name: usuarios_pkey; Type: CONSTRAINT; Schema: usuarios; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);


SET search_path = viaticos, pg_catalog;

--
-- Name: cuenta_cobro_pkey; Type: CONSTRAINT; Schema: viaticos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuenta_cobro
    ADD CONSTRAINT cuenta_cobro_pkey PRIMARY KEY (id_cuenta_cobro);


--
-- Name: detalle_cuenta_cobro_pkey; Type: CONSTRAINT; Schema: viaticos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_cuenta_cobro
    ADD CONSTRAINT detalle_cuenta_cobro_pkey PRIMARY KEY (id_detalle_cuenta);


SET search_path = usuarios, pg_catalog;

--
-- Name: fk_idcargo; Type: FK CONSTRAINT; Schema: usuarios; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT fk_idcargo FOREIGN KEY (id_cargo) REFERENCES cargo.cargo(id_cargo);


--
-- Name: fk_idfirma; Type: FK CONSTRAINT; Schema: usuarios; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT fk_idfirma FOREIGN KEY (id_firma) REFERENCES firmas(id_firmas);


SET search_path = viaticos, pg_catalog;

--
-- Name: fk_idcuentacobro; Type: FK CONSTRAINT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY detalle_cuenta_cobro
    ADD CONSTRAINT fk_idcuentacobro FOREIGN KEY (id_cuenta_cobro) REFERENCES cuenta_cobro(id_cuenta_cobro);


--
-- Name: fk_iddesplazamiento; Type: FK CONSTRAINT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY detalle_cuenta_cobro
    ADD CONSTRAINT fk_iddesplazamiento FOREIGN KEY (id_desplazamiento) REFERENCES desplazamientos.desplazamiento(id_desplazamiento);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY cuenta_cobro
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES usuarios.usuarios(id_usuario);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

