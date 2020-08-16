--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-08-16 16:39:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 33629)
-- Name: ip4; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ip4 (
    id integer NOT NULL,
    ip character varying,
    mascara character varying,
    tipo character varying,
    clase character varying,
    red character varying,
    broadcast character varying,
    rango character varying,
    hosts character varying,
    fecha character varying
);


ALTER TABLE public.ip4 OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 33632)
-- Name: ip4_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.ip4 ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.ip4_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2814 (class 0 OID 33629)
-- Dependencies: 202
-- Data for Name: ip4; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ip4 (id, ip, mascara, tipo, clase, red, broadcast, rango, hosts, fecha) FROM stdin;
4	198.7.6.5	255.255.224.0	Pública	C	198.7.0.0	198.7.31.255	198.7.0.1-198.7.31.254	8190	2020-08-15 22:43:16.281
5	182.22.2.3	255.255.255.192	Pública	B	182.22.2.0	182.22.2.63	182.22.2.1-182.22.2.62	62	2020-08-15 22:46:50.632
6	162.122.168.2	255.255.254.0	Pública	B	162.122.168.0	162.122.169.255	162.122.168.1-162.122.169.254	510	2020-08-15 23:52:36.398
\.


--
-- TOC entry 2821 (class 0 OID 0)
-- Dependencies: 203
-- Name: ip4_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ip4_id_seq', 6, true);


-- Completed on 2020-08-16 16:39:54

--
-- PostgreSQL database dump complete
--

