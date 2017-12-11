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

