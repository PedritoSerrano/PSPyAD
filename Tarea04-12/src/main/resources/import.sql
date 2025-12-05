INSERT INTO equipo (id, nombre, juego, region, ano_fundacion) VALUES (1, 'G2 Esports', 'League of Legends', 'Europa', 2014);
INSERT INTO equipo (id, nombre, juego, region, ano_fundacion) VALUES (2, 'Team Liquid', 'Valorant', 'Norteamérica', 2015);
INSERT INTO equipo (id, nombre, juego, region, ano_fundacion) VALUES (3, 'FaZe Clan', 'CS2', 'Internacional', 2010);

ALTER SEQUENCE IF EXISTS equipo_seq RESTART WITH 4;

INSERT INTO jugador (id, nickname, nombre_real, edad, equipo_id) VALUES (nextval('player_seq'), 'Caps', 'Rasmus Winther', 24, 1);
INSERT INTO jugador (id, nickname, nombre_real, edad, equipo_id) VALUES (nextval('player_seq'), 'Mikyx', 'Mihael Mehle', 25, 1);
INSERT INTO jugador (id, nickname, nombre_real, edad, equipo_id) VALUES (nextval('player_seq'), 'BrokenBlade', 'Sergen Çelik', 24, 1);
INSERT INTO jugador (id, nickname, nombre_real, edad, equipo_id) VALUES (nextval('player_seq'), 'ScreaM', 'Adil Benrlitom', 30, 2);
INSERT INTO jugador (id, nickname, nombre_real, edad, equipo_id) VALUES (nextval('player_seq'), 'Jamppi', 'Elias Olkkonen', 23, 2);
INSERT INTO jugador (id, nickname, nombre_real, edad, equipo_id) VALUES (nextval('player_seq'), 'rain', 'Håvard Nygaard', 30, 3);
INSERT INTO jugador (id, nickname, nombre_real, edad, equipo_id) VALUES (nextval('player_seq'), 'karrigan', 'Finn Andersen', 34, 3);
INSERT INTO jugador (id, nickname, nombre_real, edad, equipo_id) VALUES (nextval('player_seq'), 'ropz', 'Robin Kool', 25, 3);

