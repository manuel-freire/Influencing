-- 
-- El contenido de este fichero se cargará al arrancar la aplicación, suponiendo que uses
-- 		application-default ó application-externaldb en modo 'create'
--

-- Usuario de ejemplo con nombre = a y contraseña = aa  

INSERT INTO usuario(id,activo,nombre_cuenta,nombre,password,roles,apellidos,edad,tags,score) VALUES (
	1, 1, 'a','a',
	'{bcrypt}$2a$10$xLFtBIXGtYvAbRqM95JhcOaG23fHRpDoZIJrsF2cCff9xEHTTdK1u',
	'ADMIN',
	'Abundio Ejemplez',
	23,
	'ropa',
	5
);

-- Otro usuario de ejemplo con username = b y contraseña = aa  


INSERT INTO usuario(id,activo,nombre_cuenta,nombre,password,roles,apellidos,edad,tags,score) VALUES (
	2, 1, 'b','b',
	'{bcrypt}$2a$10$xLFtBIXGtYvAbRqM95JhcOaG23fHRpDoZIJrsF2cCff9xEHTTdK1u',
	'INFLUENCER',
	'Berta Muestrez',
	22,
	'Fiesta',
	4
);

INSERT INTO usuario(id,activo,nombre,nombre_cuenta,password,roles,apellidos,edad,tags,score) VALUES (
	3, 1, 'ca', 'c', 
	'{bcrypt}$2a$10$xLFtBIXGtYvAbRqM95JhcOaG23fHRpDoZIJrsF2cCff9xEHTTdK1u',
	'INFLUENCER',
	'Sanchez Garcia',
	22,
	'Videojuegos',
	4
);

INSERT INTO usuario(id,activo,nombre,nombre_cuenta,password,roles,apellidos,edad,tags,score) VALUES (
	4, 1, 'da', 'd',
	'{bcrypt}$2a$10$xLFtBIXGtYvAbRqM95JhcOaG23fHRpDoZIJrsF2cCff9xEHTTdK1u',
	'EMPRESA',
	'Martin Gimeno',
	22,
	'Moda',
	3
);

INSERT INTO propuesta(id,descripcion,nombre,sueldo,tags,empresa_id,activa, edad_min_publico, edad_max_publico, fecha_inicio, fecha_fin, fecha_subida)  VALUES (
	1,
	'Realizar publicidad en metro',
	'Metropubli',
	100,
	'Ciudad',
	4,true,1,5,'2017-07-23','2017-07-23','2017-07-23'
);

INSERT INTO propuesta(id,descripcion,nombre,sueldo,tags,empresa_id,activa, edad_min_publico, edad_max_publico, fecha_inicio, fecha_fin, fecha_subida) VALUES (
	2,
	'Realizar publicidad en metro 2',
	'Metropubli',
	200,
	'Ciudad,Metro,Transporte',
	4,true,1,5,'2019-07-23','2019-07-23','2019-07-23'
);
INSERT INTO propuesta(id,descripcion,nombre,sueldo,tags,empresa_id, activa, edad_min_publico, edad_max_publico, fecha_inicio, fecha_fin, fecha_subida) VALUES (
	3,
	'Publicitar festival',
	'Festipubli',
	500,
	'Musica',
	4,
true,1,5,'2018-07-23','2018-07-23','2018-07-23'
);


INSERT INTO candidatura(id,aceptada,estado,candidato_id,propuesta_id) VALUES (
	1,
	true,
	'EN_CURSO',
	2,
	1
);

INSERT INTO candidatura(id,aceptada,estado,candidato_id,propuesta_id) VALUES (
	2,
	false,
	'EN_CURSO',
	2,
	3
);

INSERT INTO candidatura(id,aceptada,estado,candidato_id,propuesta_id) VALUES (
	3,
	true,
	'FINALIZADA',
	3,
	3
);

INSERT INTO candidatura(id,aceptada,estado,candidato_id,propuesta_id) VALUES (
	4,
	false,
	'EN_CURSO',
	3,
	2
);

INSERT INTO evento(id, descripcion, tipo, fecha_enviado,fecha_recibido, leido, candidatura_id, emisor_id, receptor_id) VALUES(
	1, 'se ha registrado un usuario', 'ADMINISTRACION','2017-07-23','2017-07-23', false,
	NULL,
	2,
	1
);

INSERT INTO evento(id, descripcion, tipo, fecha_enviado,fecha_recibido,leido, candidatura_id, emisor_id, receptor_id) VALUES(
	2, 'se ha registrado otro usuario', 'ADMINISTRACION','2017-07-23','2017-07-23', false,
	NULL,
	2,
	1
);


INSERT INTO evento(id, descripcion, tipo, fecha_enviado,fecha_recibido,leido, candidatura_id, emisor_id, receptor_id) VALUES(
	3, 'se ha registrado un usuario', 'CHAT','2017-07-23','2017-07-23', false,
	1,
	2,
	4
);

INSERT INTO evento(id, descripcion, tipo, fecha_enviado,fecha_recibido, leido, candidatura_id, emisor_id, receptor_id) VALUES(
	4, 'se ha registrado otro usuario', 'CHAT','2017-07-23','2017-07-23', false,
	1,
	4,
	2
);

INSERT INTO evento(id, descripcion, tipo, fecha_enviado,fecha_recibido,leido, candidatura_id, emisor_id, receptor_id) VALUES(
	5, 'Lo siento, la oferta no me interesa. Saludos.', 'PRIVADO','2017-07-23','2017-07-23', false,
	NULL,
	2,
	1
);

INSERT INTO evento(id, descripcion, tipo, fecha_enviado,fecha_recibido,leido, candidatura_id, emisor_id, receptor_id) VALUES(
	6, 'Hola, estoy interesado en participar en la propuesta', 'PRIVADO','2017-07-23','2017-07-23', false,
	NULL,
	2,
	1
);

INSERT INTO evento(id, descripcion, tipo, fecha_enviado,fecha_recibido,leido, candidatura_id, emisor_id, receptor_id) VALUES(
	7, 'Hola, ¿como te encuentras?', 'PRIVADO','2017-07-23','2017-07-23', false,
	NULL,
	2,
	1
);

