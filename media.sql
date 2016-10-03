--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: jacksonmeyer
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    lifestage character varying
);


ALTER TABLE animals OWNER TO jacksonmeyer;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: jacksonmeyer
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO jacksonmeyer;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jacksonmeyer
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: jacksonmeyer
--

CREATE TABLE sightings (
    id integer NOT NULL,
    location character varying,
    rangername character varying,
    animalid integer,
    seenat timestamp without time zone
);


ALTER TABLE sightings OWNER TO jacksonmeyer;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: jacksonmeyer
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO jacksonmeyer;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jacksonmeyer
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: jacksonmeyer
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: jacksonmeyer
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: jacksonmeyer
--

COPY animals (id, name, health, lifestage) FROM stdin;
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: jacksonmeyer
--

SELECT pg_catalog.setval('animals_id_seq', 1, false);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: jacksonmeyer
--

COPY sightings (id, location, rangername, animalid, seenat) FROM stdin;
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: jacksonmeyer
--

SELECT pg_catalog.setval('sightings_id_seq', 1, false);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: jacksonmeyer
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: jacksonmeyer
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: jacksonmeyer
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM jacksonmeyer;
GRANT ALL ON SCHEMA public TO jacksonmeyer;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

