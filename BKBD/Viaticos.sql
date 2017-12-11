--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: anticipos_cruce_ctas; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA anticipos_cruce_ctas;


ALTER SCHEMA anticipos_cruce_ctas OWNER TO postgres;

--
-- Name: cargo; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cargo;


ALTER SCHEMA cargo OWNER TO postgres;

--
-- Name: consolidado; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA consolidado;


ALTER SCHEMA consolidado OWNER TO postgres;

--
-- Name: desplazamientos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA desplazamientos;


ALTER SCHEMA desplazamientos OWNER TO postgres;

--
-- Name: month_year; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA month_year;


ALTER SCHEMA month_year OWNER TO postgres;

--
-- Name: relacion_gastos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA relacion_gastos;


ALTER SCHEMA relacion_gastos OWNER TO postgres;

--
-- Name: relacion_otros_gastos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA relacion_otros_gastos;


ALTER SCHEMA relacion_otros_gastos OWNER TO postgres;

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


SET search_path = anticipos_cruce_ctas, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: anticipo; Type: TABLE; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

CREATE TABLE anticipo (
    id_anticipo integer NOT NULL,
    fecha_anticipo timestamp with time zone,
    oficio_anticipo character varying,
    id_mes integer,
    id_anio integer
);


ALTER TABLE anticipos_cruce_ctas.anticipo OWNER TO postgres;

--
-- Name: anticipo_id_anticipo_seq; Type: SEQUENCE; Schema: anticipos_cruce_ctas; Owner: postgres
--

CREATE SEQUENCE anticipo_id_anticipo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE anticipos_cruce_ctas.anticipo_id_anticipo_seq OWNER TO postgres;

--
-- Name: anticipo_id_anticipo_seq; Type: SEQUENCE OWNED BY; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER SEQUENCE anticipo_id_anticipo_seq OWNED BY anticipo.id_anticipo;


--
-- Name: cruce_ctas; Type: TABLE; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

CREATE TABLE cruce_ctas (
    id_cruce_ctas integer NOT NULL,
    id_anticipo integer,
    id_usuario integer,
    fecha_cruce timestamp without time zone
);


ALTER TABLE anticipos_cruce_ctas.cruce_ctas OWNER TO postgres;

--
-- Name: cruce_ctas_id_cruce_ctas_seq; Type: SEQUENCE; Schema: anticipos_cruce_ctas; Owner: postgres
--

CREATE SEQUENCE cruce_ctas_id_cruce_ctas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE anticipos_cruce_ctas.cruce_ctas_id_cruce_ctas_seq OWNER TO postgres;

--
-- Name: cruce_ctas_id_cruce_ctas_seq; Type: SEQUENCE OWNED BY; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER SEQUENCE cruce_ctas_id_cruce_ctas_seq OWNED BY cruce_ctas.id_cruce_ctas;


--
-- Name: detalle_anticipo; Type: TABLE; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_anticipo (
    id_det_ant integer NOT NULL,
    id_usuario integer,
    vlor_anticipo integer,
    ant_cruzado boolean DEFAULT false,
    ant_saldado boolean DEFAULT false,
    id_anticipo integer
);


ALTER TABLE anticipos_cruce_ctas.detalle_anticipo OWNER TO postgres;

--
-- Name: detalle_anticipo_id_det_ant_seq; Type: SEQUENCE; Schema: anticipos_cruce_ctas; Owner: postgres
--

CREATE SEQUENCE detalle_anticipo_id_det_ant_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE anticipos_cruce_ctas.detalle_anticipo_id_det_ant_seq OWNER TO postgres;

--
-- Name: detalle_anticipo_id_det_ant_seq; Type: SEQUENCE OWNED BY; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER SEQUENCE detalle_anticipo_id_det_ant_seq OWNED BY detalle_anticipo.id_det_ant;


--
-- Name: detalle_cruce_ctas; Type: TABLE; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_cruce_ctas (
    id_det_ctas integer NOT NULL,
    cta_relacionada character varying,
    vlor_total_cta integer,
    id_cruce_ctas integer,
    fecha date
);


ALTER TABLE anticipos_cruce_ctas.detalle_cruce_ctas OWNER TO postgres;

--
-- Name: detalle_cruce_ctas_id_det_ctas_seq; Type: SEQUENCE; Schema: anticipos_cruce_ctas; Owner: postgres
--

CREATE SEQUENCE detalle_cruce_ctas_id_det_ctas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE anticipos_cruce_ctas.detalle_cruce_ctas_id_det_ctas_seq OWNER TO postgres;

--
-- Name: detalle_cruce_ctas_id_det_ctas_seq; Type: SEQUENCE OWNED BY; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER SEQUENCE detalle_cruce_ctas_id_det_ctas_seq OWNED BY detalle_cruce_ctas.id_det_ctas;


--
-- Name: pagos; Type: TABLE; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

CREATE TABLE pagos (
    id_pago integer NOT NULL,
    total_causado integer,
    vlor_anticipo integer,
    saldo integer,
    id_cruce_ctas integer
);


ALTER TABLE anticipos_cruce_ctas.pagos OWNER TO postgres;

--
-- Name: pagos_id_pago_seq; Type: SEQUENCE; Schema: anticipos_cruce_ctas; Owner: postgres
--

CREATE SEQUENCE pagos_id_pago_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE anticipos_cruce_ctas.pagos_id_pago_seq OWNER TO postgres;

--
-- Name: pagos_id_pago_seq; Type: SEQUENCE OWNED BY; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER SEQUENCE pagos_id_pago_seq OWNED BY pagos.id_pago;


--
-- Name: saldo_ctas; Type: TABLE; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

CREATE TABLE saldo_ctas (
    id_saldo_ctas integer NOT NULL,
    vlor_saldo integer,
    a_favor boolean DEFAULT false,
    en_contra boolean DEFAULT false,
    id_usuario integer,
    id_cruce_cta integer
);


ALTER TABLE anticipos_cruce_ctas.saldo_ctas OWNER TO postgres;

--
-- Name: saldo_ctas_id_saldo_ctas_seq; Type: SEQUENCE; Schema: anticipos_cruce_ctas; Owner: postgres
--

CREATE SEQUENCE saldo_ctas_id_saldo_ctas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE anticipos_cruce_ctas.saldo_ctas_id_saldo_ctas_seq OWNER TO postgres;

--
-- Name: saldo_ctas_id_saldo_ctas_seq; Type: SEQUENCE OWNED BY; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER SEQUENCE saldo_ctas_id_saldo_ctas_seq OWNED BY saldo_ctas.id_saldo_ctas;


SET search_path = cargo, pg_catalog;

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


SET search_path = month_year, pg_catalog;

--
-- Name: mes; Type: TABLE; Schema: month_year; Owner: postgres; Tablespace: 
--

CREATE TABLE mes (
    id_mes integer NOT NULL,
    descripcion character varying
);


ALTER TABLE month_year.mes OWNER TO postgres;

--
-- Name: mes_id_mes_seq; Type: SEQUENCE; Schema: month_year; Owner: postgres
--

CREATE SEQUENCE mes_id_mes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE month_year.mes_id_mes_seq OWNER TO postgres;

--
-- Name: mes_id_mes_seq; Type: SEQUENCE OWNED BY; Schema: month_year; Owner: postgres
--

ALTER SEQUENCE mes_id_mes_seq OWNED BY mes.id_mes;


--
-- Name: year; Type: TABLE; Schema: month_year; Owner: postgres; Tablespace: 
--

CREATE TABLE year (
    id_year integer NOT NULL,
    descripcion character varying
);


ALTER TABLE month_year.year OWNER TO postgres;

--
-- Name: year_id_year_seq; Type: SEQUENCE; Schema: month_year; Owner: postgres
--

CREATE SEQUENCE year_id_year_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE month_year.year_id_year_seq OWNER TO postgres;

--
-- Name: year_id_year_seq; Type: SEQUENCE OWNED BY; Schema: month_year; Owner: postgres
--

ALTER SEQUENCE year_id_year_seq OWNED BY year.id_year;


SET search_path = relacion_gastos, pg_catalog;

--
-- Name: detalle_relacion_gastos; Type: TABLE; Schema: relacion_gastos; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_relacion_gastos (
    id_detalle integer NOT NULL,
    fecha date,
    usuario character varying,
    total_cta integer,
    factura character varying,
    id_rel_gastos integer,
    nit_usuario bigint,
    cta_cruzada boolean DEFAULT false
);


ALTER TABLE relacion_gastos.detalle_relacion_gastos OWNER TO postgres;

--
-- Name: detalle_relacion_gastos_id_detalle_seq; Type: SEQUENCE; Schema: relacion_gastos; Owner: postgres
--

CREATE SEQUENCE detalle_relacion_gastos_id_detalle_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relacion_gastos.detalle_relacion_gastos_id_detalle_seq OWNER TO postgres;

--
-- Name: detalle_relacion_gastos_id_detalle_seq; Type: SEQUENCE OWNED BY; Schema: relacion_gastos; Owner: postgres
--

ALTER SEQUENCE detalle_relacion_gastos_id_detalle_seq OWNED BY detalle_relacion_gastos.id_detalle;


--
-- Name: relacion_gastos; Type: TABLE; Schema: relacion_gastos; Owner: postgres; Tablespace: 
--

CREATE TABLE relacion_gastos (
    consecutivo integer NOT NULL,
    fecha_generacion timestamp without time zone
);


ALTER TABLE relacion_gastos.relacion_gastos OWNER TO postgres;

--
-- Name: relacion_gastos_consecutivo_seq; Type: SEQUENCE; Schema: relacion_gastos; Owner: postgres
--

CREATE SEQUENCE relacion_gastos_consecutivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relacion_gastos.relacion_gastos_consecutivo_seq OWNER TO postgres;

--
-- Name: relacion_gastos_consecutivo_seq; Type: SEQUENCE OWNED BY; Schema: relacion_gastos; Owner: postgres
--

ALTER SEQUENCE relacion_gastos_consecutivo_seq OWNED BY relacion_gastos.consecutivo;


SET search_path = relacion_otros_gastos, pg_catalog;

--
-- Name: det_rel_otros_gas; Type: TABLE; Schema: relacion_otros_gastos; Owner: postgres; Tablespace: 
--

CREATE TABLE det_rel_otros_gas (
    id_detalle integer NOT NULL,
    fecha date,
    usuario character varying,
    total_cta integer,
    factura character varying,
    id_rel_gas integer,
    nit_usuario bigint
);


ALTER TABLE relacion_otros_gastos.det_rel_otros_gas OWNER TO postgres;

--
-- Name: det_rel_otros_gas_id_detalle_seq; Type: SEQUENCE; Schema: relacion_otros_gastos; Owner: postgres
--

CREATE SEQUENCE det_rel_otros_gas_id_detalle_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relacion_otros_gastos.det_rel_otros_gas_id_detalle_seq OWNER TO postgres;

--
-- Name: det_rel_otros_gas_id_detalle_seq; Type: SEQUENCE OWNED BY; Schema: relacion_otros_gastos; Owner: postgres
--

ALTER SEQUENCE det_rel_otros_gas_id_detalle_seq OWNED BY det_rel_otros_gas.id_detalle;


--
-- Name: rel_otros_gastos; Type: TABLE; Schema: relacion_otros_gastos; Owner: postgres; Tablespace: 
--

CREATE TABLE rel_otros_gastos (
    rel_consecutivo integer NOT NULL,
    rel_fecha_gen timestamp without time zone
);


ALTER TABLE relacion_otros_gastos.rel_otros_gastos OWNER TO postgres;

--
-- Name: rel_otros_gastos_rel_consecutivo_seq; Type: SEQUENCE; Schema: relacion_otros_gastos; Owner: postgres
--

CREATE SEQUENCE rel_otros_gastos_rel_consecutivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relacion_otros_gastos.rel_otros_gastos_rel_consecutivo_seq OWNER TO postgres;

--
-- Name: rel_otros_gastos_rel_consecutivo_seq; Type: SEQUENCE OWNED BY; Schema: relacion_otros_gastos; Owner: postgres
--

ALTER SEQUENCE rel_otros_gastos_rel_consecutivo_seq OWNED BY rel_otros_gastos.rel_consecutivo;


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
    id_firma integer,
    control_cosnsecutivo integer NOT NULL,
    control_otros_cobros integer,
    activo boolean DEFAULT true
);


ALTER TABLE usuarios.usuarios OWNER TO postgres;

--
-- Name: usuarios_control_cosnsecutivo_seq; Type: SEQUENCE; Schema: usuarios; Owner: postgres
--

CREATE SEQUENCE usuarios_control_cosnsecutivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuarios.usuarios_control_cosnsecutivo_seq OWNER TO postgres;

--
-- Name: usuarios_control_cosnsecutivo_seq; Type: SEQUENCE OWNED BY; Schema: usuarios; Owner: postgres
--

ALTER SEQUENCE usuarios_control_cosnsecutivo_seq OWNED BY usuarios.control_cosnsecutivo;


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
    cuenta_generada boolean DEFAULT false NOT NULL,
    id_manejo_cta integer NOT NULL,
    cta_aprobada boolean DEFAULT false NOT NULL,
    persona_aprueba integer,
    desde date,
    hasta date
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
-- Name: cuenta_cobro_id_manejo_cta_seq; Type: SEQUENCE; Schema: viaticos; Owner: postgres
--

CREATE SEQUENCE cuenta_cobro_id_manejo_cta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE viaticos.cuenta_cobro_id_manejo_cta_seq OWNER TO postgres;

--
-- Name: cuenta_cobro_id_manejo_cta_seq; Type: SEQUENCE OWNED BY; Schema: viaticos; Owner: postgres
--

ALTER SEQUENCE cuenta_cobro_id_manejo_cta_seq OWNED BY cuenta_cobro.id_manejo_cta;


--
-- Name: cuenta_otros_cobros; Type: TABLE; Schema: viaticos; Owner: postgres; Tablespace: 
--

CREATE TABLE cuenta_otros_cobros (
    fecha_sistema timestamp without time zone,
    id_usuario integer,
    cta_aprobada boolean DEFAULT false,
    id_otros_cobros integer,
    cta_generada boolean DEFAULT false,
    desde date,
    hasta date,
    id_cta_otros integer NOT NULL,
    persona_aprueba integer
);


ALTER TABLE viaticos.cuenta_otros_cobros OWNER TO postgres;

--
-- Name: cuenta_otros_cobros_id_cta_otros_seq; Type: SEQUENCE; Schema: viaticos; Owner: postgres
--

CREATE SEQUENCE cuenta_otros_cobros_id_cta_otros_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE viaticos.cuenta_otros_cobros_id_cta_otros_seq OWNER TO postgres;

--
-- Name: cuenta_otros_cobros_id_cta_otros_seq; Type: SEQUENCE OWNED BY; Schema: viaticos; Owner: postgres
--

ALTER SEQUENCE cuenta_otros_cobros_id_cta_otros_seq OWNED BY cuenta_otros_cobros.id_cta_otros;


--
-- Name: detalle_cobros_extras; Type: TABLE; Schema: viaticos; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_cobros_extras (
    id_detalle integer NOT NULL,
    concepto character varying,
    tarifa integer,
    fecha_des date,
    id_cta_cobro integer,
    novedad character varying
);


ALTER TABLE viaticos.detalle_cobros_extras OWNER TO postgres;

--
-- Name: detalle_cobros_extras_id_detalle_seq; Type: SEQUENCE; Schema: viaticos; Owner: postgres
--

CREATE SEQUENCE detalle_cobros_extras_id_detalle_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE viaticos.detalle_cobros_extras_id_detalle_seq OWNER TO postgres;

--
-- Name: detalle_cobros_extras_id_detalle_seq; Type: SEQUENCE OWNED BY; Schema: viaticos; Owner: postgres
--

ALTER SEQUENCE detalle_cobros_extras_id_detalle_seq OWNED BY detalle_cobros_extras.id_detalle;


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
-- Name: otros_cobros; Type: TABLE; Schema: viaticos; Owner: postgres; Tablespace: 
--

CREATE TABLE otros_cobros (
    id_otros_cobros integer NOT NULL,
    concepto character varying,
    tarifa integer,
    fecha date,
    id_cta_cobro integer,
    novedad character varying
);


ALTER TABLE viaticos.otros_cobros OWNER TO postgres;

--
-- Name: otros_cobros_id_otros_cobros_seq; Type: SEQUENCE; Schema: viaticos; Owner: postgres
--

CREATE SEQUENCE otros_cobros_id_otros_cobros_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE viaticos.otros_cobros_id_otros_cobros_seq OWNER TO postgres;

--
-- Name: otros_cobros_id_otros_cobros_seq; Type: SEQUENCE OWNED BY; Schema: viaticos; Owner: postgres
--

ALTER SEQUENCE otros_cobros_id_otros_cobros_seq OWNED BY otros_cobros.id_otros_cobros;


SET search_path = anticipos_cruce_ctas, pg_catalog;

--
-- Name: id_anticipo; Type: DEFAULT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY anticipo ALTER COLUMN id_anticipo SET DEFAULT nextval('anticipo_id_anticipo_seq'::regclass);


--
-- Name: id_cruce_ctas; Type: DEFAULT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY cruce_ctas ALTER COLUMN id_cruce_ctas SET DEFAULT nextval('cruce_ctas_id_cruce_ctas_seq'::regclass);


--
-- Name: id_det_ant; Type: DEFAULT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY detalle_anticipo ALTER COLUMN id_det_ant SET DEFAULT nextval('detalle_anticipo_id_det_ant_seq'::regclass);


--
-- Name: id_det_ctas; Type: DEFAULT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY detalle_cruce_ctas ALTER COLUMN id_det_ctas SET DEFAULT nextval('detalle_cruce_ctas_id_det_ctas_seq'::regclass);


--
-- Name: id_pago; Type: DEFAULT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY pagos ALTER COLUMN id_pago SET DEFAULT nextval('pagos_id_pago_seq'::regclass);


--
-- Name: id_saldo_ctas; Type: DEFAULT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY saldo_ctas ALTER COLUMN id_saldo_ctas SET DEFAULT nextval('saldo_ctas_id_saldo_ctas_seq'::regclass);


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


SET search_path = month_year, pg_catalog;

--
-- Name: id_mes; Type: DEFAULT; Schema: month_year; Owner: postgres
--

ALTER TABLE ONLY mes ALTER COLUMN id_mes SET DEFAULT nextval('mes_id_mes_seq'::regclass);


--
-- Name: id_year; Type: DEFAULT; Schema: month_year; Owner: postgres
--

ALTER TABLE ONLY year ALTER COLUMN id_year SET DEFAULT nextval('year_id_year_seq'::regclass);


SET search_path = relacion_gastos, pg_catalog;

--
-- Name: id_detalle; Type: DEFAULT; Schema: relacion_gastos; Owner: postgres
--

ALTER TABLE ONLY detalle_relacion_gastos ALTER COLUMN id_detalle SET DEFAULT nextval('detalle_relacion_gastos_id_detalle_seq'::regclass);


--
-- Name: consecutivo; Type: DEFAULT; Schema: relacion_gastos; Owner: postgres
--

ALTER TABLE ONLY relacion_gastos ALTER COLUMN consecutivo SET DEFAULT nextval('relacion_gastos_consecutivo_seq'::regclass);


SET search_path = relacion_otros_gastos, pg_catalog;

--
-- Name: id_detalle; Type: DEFAULT; Schema: relacion_otros_gastos; Owner: postgres
--

ALTER TABLE ONLY det_rel_otros_gas ALTER COLUMN id_detalle SET DEFAULT nextval('det_rel_otros_gas_id_detalle_seq'::regclass);


--
-- Name: rel_consecutivo; Type: DEFAULT; Schema: relacion_otros_gastos; Owner: postgres
--

ALTER TABLE ONLY rel_otros_gastos ALTER COLUMN rel_consecutivo SET DEFAULT nextval('rel_otros_gastos_rel_consecutivo_seq'::regclass);


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
-- Name: id_manejo_cta; Type: DEFAULT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY cuenta_cobro ALTER COLUMN id_manejo_cta SET DEFAULT nextval('cuenta_cobro_id_manejo_cta_seq'::regclass);


--
-- Name: id_cta_otros; Type: DEFAULT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY cuenta_otros_cobros ALTER COLUMN id_cta_otros SET DEFAULT nextval('cuenta_otros_cobros_id_cta_otros_seq'::regclass);


--
-- Name: id_detalle; Type: DEFAULT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY detalle_cobros_extras ALTER COLUMN id_detalle SET DEFAULT nextval('detalle_cobros_extras_id_detalle_seq'::regclass);


--
-- Name: id_detalle_cuenta; Type: DEFAULT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY detalle_cuenta_cobro ALTER COLUMN id_detalle_cuenta SET DEFAULT nextval('detalle_cuenta_cobro_id_detalle_cuenta_seq'::regclass);


--
-- Name: id_otros_cobros; Type: DEFAULT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY otros_cobros ALTER COLUMN id_otros_cobros SET DEFAULT nextval('otros_cobros_id_otros_cobros_seq'::regclass);


SET search_path = anticipos_cruce_ctas, pg_catalog;

--
-- Name: anticipo_pkey; Type: CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY anticipo
    ADD CONSTRAINT anticipo_pkey PRIMARY KEY (id_anticipo);


--
-- Name: cruce_ctas_pkey; Type: CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cruce_ctas
    ADD CONSTRAINT cruce_ctas_pkey PRIMARY KEY (id_cruce_ctas);


--
-- Name: detalle_anticipo_pkey; Type: CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_anticipo
    ADD CONSTRAINT detalle_anticipo_pkey PRIMARY KEY (id_det_ant);


--
-- Name: detalle_cruce_ctas_pkey; Type: CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_cruce_ctas
    ADD CONSTRAINT detalle_cruce_ctas_pkey PRIMARY KEY (id_det_ctas);


--
-- Name: pagos_pkey; Type: CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pagos
    ADD CONSTRAINT pagos_pkey PRIMARY KEY (id_pago);


--
-- Name: saldo_ctas_pkey; Type: CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY saldo_ctas
    ADD CONSTRAINT saldo_ctas_pkey PRIMARY KEY (id_saldo_ctas);


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


SET search_path = month_year, pg_catalog;

--
-- Name: mes_pkey; Type: CONSTRAINT; Schema: month_year; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mes
    ADD CONSTRAINT mes_pkey PRIMARY KEY (id_mes);


--
-- Name: year_pkey; Type: CONSTRAINT; Schema: month_year; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY year
    ADD CONSTRAINT year_pkey PRIMARY KEY (id_year);


SET search_path = relacion_gastos, pg_catalog;

--
-- Name: detalle_relacion_gastos_pkey; Type: CONSTRAINT; Schema: relacion_gastos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_relacion_gastos
    ADD CONSTRAINT detalle_relacion_gastos_pkey PRIMARY KEY (id_detalle);


--
-- Name: relacion_gastos_pkey; Type: CONSTRAINT; Schema: relacion_gastos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY relacion_gastos
    ADD CONSTRAINT relacion_gastos_pkey PRIMARY KEY (consecutivo);


SET search_path = relacion_otros_gastos, pg_catalog;

--
-- Name: det_rel_otros_gas_pkey; Type: CONSTRAINT; Schema: relacion_otros_gastos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY det_rel_otros_gas
    ADD CONSTRAINT det_rel_otros_gas_pkey PRIMARY KEY (id_detalle);


--
-- Name: rel_otros_gastos_pkey; Type: CONSTRAINT; Schema: relacion_otros_gastos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rel_otros_gastos
    ADD CONSTRAINT rel_otros_gastos_pkey PRIMARY KEY (rel_consecutivo);


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
-- Name: detalle_cobros_extras_pkey; Type: CONSTRAINT; Schema: viaticos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_cobros_extras
    ADD CONSTRAINT detalle_cobros_extras_pkey PRIMARY KEY (id_detalle);


--
-- Name: detalle_cuenta_cobro_pkey; Type: CONSTRAINT; Schema: viaticos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_cuenta_cobro
    ADD CONSTRAINT detalle_cuenta_cobro_pkey PRIMARY KEY (id_detalle_cuenta);


--
-- Name: otros_cobros_pkey; Type: CONSTRAINT; Schema: viaticos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY otros_cobros
    ADD CONSTRAINT otros_cobros_pkey PRIMARY KEY (id_otros_cobros);


--
-- Name: pk_id_cta_otros; Type: CONSTRAINT; Schema: viaticos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuenta_otros_cobros
    ADD CONSTRAINT pk_id_cta_otros PRIMARY KEY (id_cta_otros);


--
-- Name: pk_id_manejo_cta; Type: CONSTRAINT; Schema: viaticos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuenta_cobro
    ADD CONSTRAINT pk_id_manejo_cta PRIMARY KEY (id_manejo_cta);


SET search_path = anticipos_cruce_ctas, pg_catalog;

--
-- Name: fk_ano; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY anticipo
    ADD CONSTRAINT fk_ano FOREIGN KEY (id_anio) REFERENCES month_year.year(id_year);


--
-- Name: fk_anticipo; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY cruce_ctas
    ADD CONSTRAINT fk_anticipo FOREIGN KEY (id_anticipo) REFERENCES anticipo(id_anticipo);


--
-- Name: fk_cruce_cta; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY saldo_ctas
    ADD CONSTRAINT fk_cruce_cta FOREIGN KEY (id_cruce_cta) REFERENCES cruce_ctas(id_cruce_ctas);


--
-- Name: fk_cruce_ctas; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY detalle_cruce_ctas
    ADD CONSTRAINT fk_cruce_ctas FOREIGN KEY (id_cruce_ctas) REFERENCES cruce_ctas(id_cruce_ctas);


--
-- Name: fk_cruce_ctas; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY pagos
    ADD CONSTRAINT fk_cruce_ctas FOREIGN KEY (id_cruce_ctas) REFERENCES cruce_ctas(id_cruce_ctas);


--
-- Name: fk_idanticipo; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY detalle_anticipo
    ADD CONSTRAINT fk_idanticipo FOREIGN KEY (id_anticipo) REFERENCES anticipo(id_anticipo);


--
-- Name: fk_mes; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY anticipo
    ADD CONSTRAINT fk_mes FOREIGN KEY (id_mes) REFERENCES month_year.mes(id_mes);


--
-- Name: fk_usuario; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY cruce_ctas
    ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios.usuarios(id_usuario);


--
-- Name: fk_usuario; Type: FK CONSTRAINT; Schema: anticipos_cruce_ctas; Owner: postgres
--

ALTER TABLE ONLY saldo_ctas
    ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios.usuarios(id_usuario);


SET search_path = relacion_gastos, pg_catalog;

--
-- Name: fk_relacion_gastos; Type: FK CONSTRAINT; Schema: relacion_gastos; Owner: postgres
--

ALTER TABLE ONLY detalle_relacion_gastos
    ADD CONSTRAINT fk_relacion_gastos FOREIGN KEY (id_rel_gastos) REFERENCES relacion_gastos(consecutivo);


SET search_path = relacion_otros_gastos, pg_catalog;

--
-- Name: fk_id_rel; Type: FK CONSTRAINT; Schema: relacion_otros_gastos; Owner: postgres
--

ALTER TABLE ONLY det_rel_otros_gas
    ADD CONSTRAINT fk_id_rel FOREIGN KEY (id_rel_gas) REFERENCES rel_otros_gastos(rel_consecutivo);


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
-- Name: fk_cta_cobro; Type: FK CONSTRAINT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY otros_cobros
    ADD CONSTRAINT fk_cta_cobro FOREIGN KEY (id_cta_cobro) REFERENCES cuenta_otros_cobros(id_cta_otros);


--
-- Name: fk_cta_cobro; Type: FK CONSTRAINT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY detalle_cobros_extras
    ADD CONSTRAINT fk_cta_cobro FOREIGN KEY (id_cta_cobro) REFERENCES cuenta_cobro(id_manejo_cta);


--
-- Name: fk_idctacobro; Type: FK CONSTRAINT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY detalle_cuenta_cobro
    ADD CONSTRAINT fk_idctacobro FOREIGN KEY (id_cuenta_cobro) REFERENCES cuenta_cobro(id_manejo_cta);


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
-- Name: fk_iduusuario; Type: FK CONSTRAINT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY cuenta_otros_cobros
    ADD CONSTRAINT fk_iduusuario FOREIGN KEY (id_usuario) REFERENCES usuarios.usuarios(id_usuario);


--
-- Name: fk_persona_aprueba; Type: FK CONSTRAINT; Schema: viaticos; Owner: postgres
--

ALTER TABLE ONLY cuenta_cobro
    ADD CONSTRAINT fk_persona_aprueba FOREIGN KEY (persona_aprueba) REFERENCES usuarios.usuarios(id_usuario);


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

