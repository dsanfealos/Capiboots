-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: capiboots
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accesos`
--

DROP TABLE IF EXISTS `accesos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accesos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_fin` datetime DEFAULT NULL,
  `fecha_inicio` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `terminado` bit(1) DEFAULT NULL,
  `id_contenido` bigint NOT NULL,
  `id_usuario` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4k0p34bi26q7sddh30ho8fcap` (`id_contenido`),
  KEY `FKn80td9i3g8h96b7dxdbmyesn6` (`id_usuario`),
  CONSTRAINT `FK4k0p34bi26q7sddh30ho8fcap` FOREIGN KEY (`id_contenido`) REFERENCES `contenidos` (`id`),
  CONSTRAINT `FKn80td9i3g8h96b7dxdbmyesn6` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesos`
--

LOCK TABLES `accesos` WRITE;
/*!40000 ALTER TABLE `accesos` DISABLE KEYS */;
/*!40000 ALTER TABLE `accesos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` text CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci,
  `imagen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'',NULL,'Libros'),(2,'',NULL,'Peliculas'),(3,'',NULL,'Series'),(4,NULL,NULL,'Accion'),(5,NULL,NULL,'CienciaFiccion'),(6,NULL,NULL,'Comedia'),(7,NULL,NULL,'Documental'),(8,NULL,NULL,'Drama'),(9,NULL,NULL,'Fantasia'),(10,NULL,NULL,'Infantil'),(11,NULL,NULL,'Misterio'),(12,NULL,NULL,'Romance'),(13,NULL,NULL,'Terror'),(14,NULL,NULL,'Thriller');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenidos`
--

DROP TABLE IF EXISTS `contenidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenidos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_alta` datetime(6) DEFAULT NULL,
  `nombre` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `idserie` bigint DEFAULT NULL,
  `idtemporada` bigint DEFAULT NULL,
  `descripcion` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `novedad` tinyint(1) DEFAULT '1',
  `imagen_fondo` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `imagen_logo` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `ruta_video` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKje9hyvljmy0i5o1xrm4pleq3d` (`idserie`),
  KEY `FK1oxo5v3bc9xfxlng324jiuvhk` (`idtemporada`),
  CONSTRAINT `FK1oxo5v3bc9xfxlng324jiuvhk` FOREIGN KEY (`idtemporada`) REFERENCES `temporada` (`id`),
  CONSTRAINT `FKje9hyvljmy0i5o1xrm4pleq3d` FOREIGN KEY (`idserie`) REFERENCES `series` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenidos`
--

LOCK TABLES `contenidos` WRITE;
/*!40000 ALTER TABLE `contenidos` DISABLE KEYS */;
INSERT INTO `contenidos` VALUES (1,NULL,'El Padrino',NULL,NULL,NULL,1,NULL,'/files/logo_ElPadrino.jpg','/videos/titanic.jpg'),(2,NULL,'El Padrino 2',NULL,NULL,NULL,1,NULL,'/files/logo_ElPadrino2.jpg',NULL),(3,NULL,'El caballero Oscuro',NULL,NULL,NULL,1,'background-image: url(\'contenidos/fondo_ElCaballeroOscuro.jpg\');','/files/logo_ElCaballeroOscuro.jpg','background-image: url(\'/videos/Imagen de WhatsApp 2023-05-01 a las 16.57.20.jpg\');'),(4,NULL,'La lista de Schindler',NULL,NULL,NULL,1,NULL,'/files/logo_LaListaDeSchindler.jpg','/videos/carnet.jpg'),(5,NULL,'El bueno, el malo y el feo',NULL,NULL,NULL,1,NULL,'/files/logo_ElBuenoElFeoyElMalo.jpg',NULL),(6,NULL,'Titanic',NULL,NULL,NULL,1,'background-image: url(\'/videos/titanic2.jpeg\');','/files/logo_titanic.png','/videos/titanic.jpg'),(7,NULL,'La naranja mecánica',NULL,NULL,NULL,1,NULL,'/files/logo_LaNaranjaMecanica.jpg',NULL),(8,NULL,'Lawrence de Arabia',NULL,NULL,NULL,1,NULL,'/files/logo_LawranceDeArabia.jpg',NULL),(9,NULL,'Your Name',NULL,NULL,NULL,1,'background-image: url(\'/files/fondo_YourName.png\');','/files/logo_YourName.png','/files/Pelicula_YourName.mp4'),(10,NULL,'El viaje de Chihiro',NULL,NULL,NULL,1,'background-image: url(\'/videos/Imagen de WhatsApp 2023-05-01 a las 16.57.20.jpg\');','/files/logo_ElViajeDeChihiro.jpg','/videos/profile.jpg'),(11,NULL,'Libro de \"El señor de los  anillos: La comunidad del anillo\"',NULL,NULL,NULL,1,'background-image: url(\'/files/fondo_LaComunidadDelAnillo.jpg\');','/files/logo_LaComunidadDelAnillo.jpg','/files/Libro_LaComunidadDelAnillo.pdf'),(12,NULL,'Libro de \"El señor de los  anillos: Las Dos Torres\"',NULL,NULL,NULL,1,NULL,'/files/logo_LasDosTorres.jpg',NULL),(13,NULL,'Libro de \"El señor de los  anillos: El Retorno del Rey\"',NULL,NULL,NULL,1,NULL,'/files/logo_ElRetornoDelRey.jpg',NULL),(14,NULL,'Libro de \"El nombre del viento\"',NULL,NULL,NULL,1,NULL,'/files/logo_ElNombreDelViento.jpg',NULL),(15,NULL,'Libro de \"El Valle de los Lobos\"',NULL,NULL,NULL,1,NULL,'/files/logo_ElValleDeLosLobos.jpg',NULL),(16,NULL,'Libro de \"La maldición del Maestro\"',NULL,NULL,NULL,1,NULL,'/files/logo_LaMaldicionDelMaestro.jpg',NULL),(17,NULL,'Libro de \"La llamada de los muertos\"',NULL,NULL,NULL,1,NULL,'/files/logo_LaLlamadaDeLosMuertos.jpg',NULL),(18,NULL,'Libro de \"Fenris, el elfo\"',NULL,NULL,NULL,1,NULL,'/files/logo_FenrisElElfo.jpg',NULL),(19,NULL,'Libro de \"Los juegos del hambre\"',NULL,NULL,NULL,1,'background-image: url(\'/files/fondo_LosJuegosDelHambre.jpg\');','/files/logo_LosJuegosDelHambre.jpg','/files/Libro_LosJuegosDelHambre.pdf'),(20,NULL,'Libro de \"En llamas\"',NULL,NULL,NULL,1,NULL,'/files/logo_EnLlamas.jpg',NULL),(21,NULL,'Libro de \"Sinsajo\"',NULL,NULL,NULL,1,NULL,'/files/logo_Sinsajo.jpg',NULL),(22,NULL,' Principio del fin',1,1,NULL,1,NULL,'/files/logo_1x01_BreakingBad.jpg','/files/1x01_BreakingBad.mp4.mp4'),(23,NULL,'El gato en la bolsa',1,1,NULL,1,NULL,'/files/logo_1x02_BreakingBad.jpg','/files/1x02_BreakingBad.mp4.mp4'),(24,NULL,'Y la bolsa en el río',1,1,NULL,1,NULL,'/files/logo_1x03_BreakingBad.jpg','/files/1x03_BreakingBad.mp4.mp4'),(25,NULL,'Cáncer',1,1,NULL,1,NULL,'/files/logo_1x04_BreakingBad.jpg','/files/1x04_BreakingBad.mp4.mp4'),(26,NULL,'Materia gris',1,1,NULL,1,NULL,'/files/logo_1x05_BreakingBad.jpg','/files/1x05_BreakingBad.mp4.mp4'),(27,NULL,'Un loco puñado de nada',1,1,NULL,1,NULL,'/files/logo_1x06_BreakingBad.jpg','/files/1x06_BreakingBad.mp4.mp4'),(28,NULL,'Acuerdo no violento',1,1,NULL,1,NULL,'/files/logo_1x07_BreakingBad.jpg','/files/1x07_BreakingBad.mp4.mp4'),(29,NULL,'Siete con treinta y siete',1,2,NULL,1,NULL,NULL,NULL),(30,NULL,'A las brasas',1,2,NULL,1,NULL,NULL,NULL),(31,NULL,'Picadura de una abeja muerta',1,2,NULL,1,NULL,NULL,NULL),(32,NULL,'Abajo',1,2,NULL,1,NULL,NULL,NULL),(33,NULL,'Rotura',1,2,NULL,1,NULL,NULL,NULL),(34,NULL,'Cucú',1,2,NULL,1,NULL,NULL,NULL),(35,NULL,'Negro y Azul',1,2,NULL,1,NULL,NULL,NULL),(36,NULL,'Llama a Saul',1,2,NULL,1,NULL,NULL,NULL),(37,NULL,'Cuatro días afuera',1,2,NULL,1,NULL,NULL,NULL),(38,NULL,'Terminado',1,2,NULL,1,NULL,NULL,NULL),(39,NULL,'Mandala',1,2,NULL,1,NULL,NULL,NULL),(40,NULL,'Phoenix',1,2,NULL,1,NULL,NULL,NULL),(41,NULL,'ABQ',1,2,NULL,1,NULL,NULL,NULL),(42,NULL,'No más',1,3,NULL,1,NULL,NULL,NULL),(43,NULL,'Caballo sin Nombre',1,3,NULL,1,NULL,NULL,NULL),(44,NULL,'IFT',1,3,NULL,1,NULL,NULL,NULL),(45,NULL,'Luz verde',1,3,NULL,1,NULL,NULL,NULL),(46,NULL,'Más',1,3,NULL,1,NULL,NULL,NULL),(47,NULL,'Atardecer',1,3,NULL,1,NULL,NULL,NULL),(48,NULL,'Un minuto',1,3,NULL,1,NULL,NULL,NULL),(49,NULL,'Te veo',1,3,NULL,1,NULL,NULL,NULL),(50,NULL,'Kafkiano',1,3,NULL,1,NULL,NULL,NULL),(51,NULL,'Vuelo',1,3,NULL,1,NULL,NULL,NULL),(52,NULL,'Abiquiú',1,3,NULL,1,NULL,NULL,NULL),(53,NULL,'Medias medidas',1,3,NULL,1,NULL,NULL,NULL),(54,NULL,'Medidas totales',1,3,NULL,1,NULL,NULL,NULL),(55,NULL,'Cúter',1,4,NULL,1,NULL,NULL,NULL),(56,NULL,'Calibre 38',1,4,NULL,1,NULL,NULL,NULL),(57,NULL,'Puertas abiertas',1,4,NULL,1,NULL,NULL,NULL),(58,NULL,'Puntos clave',1,4,NULL,1,NULL,NULL,NULL),(59,NULL,'Shotgun',1,4,NULL,1,NULL,NULL,NULL),(60,NULL,'Arrinconado',1,4,NULL,1,NULL,NULL,NULL),(61,NULL,'Perro problemático',1,4,NULL,1,NULL,NULL,NULL),(62,NULL,'Hermanos',1,4,NULL,1,NULL,NULL,NULL),(63,NULL,'Error',1,4,NULL,1,NULL,NULL,NULL),(64,NULL,'Salud',1,4,NULL,1,NULL,NULL,NULL),(65,NULL,'Semisótano',1,4,NULL,1,NULL,NULL,NULL),(66,NULL,'Fin de los tiempos',1,4,NULL,1,NULL,NULL,NULL),(67,NULL,'Cara a cara',1,4,NULL,1,NULL,NULL,NULL),(68,NULL,'Vive libre o muere',1,5,NULL,1,NULL,NULL,NULL),(69,NULL,'Madrigal',1,5,NULL,1,NULL,NULL,NULL),(70,NULL,'Prestación por riesgo',1,5,NULL,1,NULL,NULL,NULL),(71,NULL,'Cincuenta y uno',1,5,NULL,1,NULL,NULL,NULL),(72,NULL,'Carga mortal',1,5,NULL,1,NULL,NULL,NULL),(73,NULL,'Adquisición',1,5,NULL,1,NULL,NULL,NULL),(74,NULL,'Di mi nombre',1,5,NULL,1,NULL,NULL,NULL),(75,NULL,'Deslizándose sobre todo',1,5,NULL,1,NULL,NULL,NULL),(76,NULL,'Dinero sangriento',1,5,NULL,1,NULL,NULL,NULL),(77,NULL,'Buried',1,5,NULL,1,NULL,NULL,NULL),(78,NULL,'Confesiones',1,5,NULL,1,NULL,NULL,NULL),(79,NULL,'Perro rabioso',1,5,NULL,1,NULL,NULL,NULL),(80,NULL,'To\'hajiilee',1,5,NULL,1,NULL,NULL,NULL),(81,NULL,'Ozymandias',1,5,NULL,1,NULL,NULL,NULL),(82,NULL,'Granite State',1,5,NULL,1,NULL,NULL,NULL),(83,NULL,'Felina',1,5,NULL,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `contenidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenidos_categorias`
--

DROP TABLE IF EXISTS `contenidos_categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenidos_categorias` (
  `id_contenido` bigint NOT NULL,
  `id_categoria` bigint NOT NULL,
  KEY `FKio90mp3xrrracjn0b3vx24q81` (`id_categoria`),
  KEY `FK6dqw21nuc9wy8nd0u2e0yd1k4` (`id_contenido`),
  CONSTRAINT `FK6dqw21nuc9wy8nd0u2e0yd1k4` FOREIGN KEY (`id_contenido`) REFERENCES `contenidos` (`id`),
  CONSTRAINT `FKio90mp3xrrracjn0b3vx24q81` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenidos_categorias`
--

LOCK TABLES `contenidos_categorias` WRITE;
/*!40000 ALTER TABLE `contenidos_categorias` DISABLE KEYS */;
INSERT INTO `contenidos_categorias` VALUES (1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(1,4),(1,8),(1,14),(2,4),(2,8),(2,14),(3,4),(3,5),(4,11),(4,14),(5,4),(5,6),(5,8),(6,7),(6,8),(6,12),(7,11),(8,4),(8,8),(8,12);
/*!40000 ALTER TABLE `contenidos_categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `files` (
  `id` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `data` longblob NOT NULL,
  `file_name` varchar(255) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'ROLE_ADMIN'),(3,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimientos`
--

DROP TABLE IF EXISTS `seguimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguimientos` (
  `id_seguidor` bigint NOT NULL,
  `id_seguido` bigint NOT NULL,
  KEY `FKc43xgriym6q8tu7by4g7rllre` (`id_seguido`),
  KEY `FKnvha9gfy4b5hellqemgo3qjwb` (`id_seguidor`),
  CONSTRAINT `FKc43xgriym6q8tu7by4g7rllre` FOREIGN KEY (`id_seguido`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKnvha9gfy4b5hellqemgo3qjwb` FOREIGN KEY (`id_seguidor`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimientos`
--

LOCK TABLES `seguimientos` WRITE;
/*!40000 ALTER TABLE `seguimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `series`
--

DROP TABLE IF EXISTS `series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `series` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `nombre` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `imagen_fondo` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `imagen_logo` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `novedad` tinyint(1) DEFAULT '1',
  `ruta_video` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series`
--

LOCK TABLES `series` WRITE;
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` VALUES (1,'Walter White, un profesor de química de Albuquerque, se enfrenta a un cáncer terminal cuando cumple 50 años. Lejos de dejar a su familia endeudada de por vida, el hombre decide cocinar metanfetamina y comercializarlas','Breaking Bad','background-image: url(\'/files/fondo_BreakingBad.jpg\');','/files/logo_BreakingBad.jpg',NULL,NULL),(2,'El gran Tony Soprano es un padre de familia, pero, al mismo tiempo, es un temible mafioso. Un antihéroe con el que el público logra empatizar y qué, más tarde, se consolidaría en ficciones posteriores como Breaking Bad.','Los Soprano',NULL,'/files/logo_LosSoprano.jpg',NULL,NULL),(3,'Su argumento está basado en los libros de George R.R. Martin y se desarrolla en un mundo ficticio llamado Poniente, donde varias familias disputan por sentarse en el Trono de Hierro.','Juego de Tronos',NULL,'/files/logo_JuegoDeTronos.png',NULL,NULL),(4,'La ficción se centra en los barrios bajos de Baltimore, Estados Unidos, donde se desarrolla una compleja trama policial.','The Wire',NULL,'/files/logo_TheWire.jpg',NULL,NULL),(5,'Es una serie policíaca de HBO, cada temporada abarca diferentes historias y presenta personajes distintos.','True Detective',NULL,'/files/logo_TrueDetective.jpg',NULL,NULL),(6,'Se trata de una de las series de animación más longevas. Conocida por predecir en futuro en algunos de sus episodios, la ficción gira en torno a una familia convencional de Springfield.','Los Simpsons',NULL,'/files/logo_TheSimspon.jpg',NULL,NULL),(7,'Su argumento está centrado en los acontecimientos ocurridos en la Central Nuclear de Chernóbil, antigua Unión Soviética, el 26 de abril de 1986.','Chernóbil',NULL,'/files/logo_Chernobyl.jpg',NULL,NULL),(8,'El argumento se adentra en las ciudades de Piltover y Zaun. Mientras que la primera es rica y llena de lujos, la segunda es todo lo contrario. La disputa entre ambas ciudades pone a prueba también a los núcleos familiares.','Arcane',NULL,'/files/logo_Arcane.jpg',NULL,NULL),(9,'Esta serie británica ha sido calificada por muchos como una obra imprescindible de la televisión en streaming. La ficción está compuesta por episodios autoconclusivos.','Black Mirrror',NULL,'/files/logo_BlackMirror.jpg',NULL,NULL),(10,' Serie de animación destinada al público adulto. Rick, quien cumple con el estereotipo de científico loco”, regresa tras 20 años para vivir con su hija Beth.','Rick y Morty',NULL,'/files/logo_RickYMorty.jpg',NULL,NULL),(11,'La comedia sigue la vida de seis amigos que enfrentan desafíos emocionales y profesionales en la ciudad de Nueva York.','Friends',NULL,'/files/logo_Friends.jpg',NULL,NULL),(12,'La serie supone un rompecabezas que se asienta en un guion inspirado en teorías como la de los agujeros de gusano o el eterno retorno.','Dark',NULL,'/files/logo_Dark.jpg',NULL,NULL),(13,'El Profesor, un tipo aparentemente normal, ha planeado durante años asaltar la Fábrica Nacional de Moneda y Timbre de Madrid.','La casa de papel',NULL,'/files/logo_LaCasaDePapel.jpg',NULL,NULL),(14,'Una familia de gansters, los Shelby, dominan el negocio de las apuestas de las carreras de caballos.','Peaky Blinders',NULL,'/files/logo_PeakyBlinders.jpg',NULL,NULL),(15,'Está basada en la serie británica homónima estrenada en 2001, y se centra en el día a día de los ineptos trabajadores de la empresa Dunder Mifflin y su extravagante jefe.','The Office',NULL,'/files/logo_TheOffice.jpg',NULL,NULL),(16,'BoJack Horseman fue una estrella de una exitosa serie de televisión durante la década de los 90. Ahora, en el ocaso de su carrera profesional, pretende volver a ser quién era publicando unas memorias.','BoJack Horseman',NULL,'/files/logo_BoJackHorseman.jpg',NULL,NULL),(17,'Esta serie británica realizada por la BBC se atreve a rescatar a uno de los personajes más emblemáticos de la literatura, Sherlock Holmes, para reinventarlo y adaptarlo a la ciudad de Londres del siglo XXI.','Sherlock',NULL,'/files/logo_Sherlock.jpg',NULL,NULL),(18,'La serie gira en torno a una agencia de publicidad estadounidense llamada Sterling Cooper. Entre sus empleados, se encuentran el prestigioso publicista llamado Donald Draper, quien no es quien aparenta.','Mad Men',NULL,'/files/logo_MadMen.jpg',NULL,NULL),(19,'Una noche, la desaparición de un niño desencadena una serie de extraños acontecimientos en el lugar. Se embarcaran en una investigación tras los sucesos paranormales que acontecen.','Stranger Things',NULL,'/files/logo_StrangerThings.jpg',NULL,NULL),(20,'The Leftovers narra los acontecimientos ocurridos tres años después de que el 2% de la población global desapareciera misteriosamente en un evento conocido como la “Ascensión”.','The Leftlovers',NULL,'/files/logo_TheLeftlovers.jpg',NULL,NULL),(21,'Es un drama que narra lo ocurrido en una población llamada Twin Peaks, donde una joven es asesinada. Le acompañan una serie de acontecimientos paranormales.','Twin Peaks',NULL,'/files/logo_TwinPeaks.jpg',NULL,NULL),(22,'En ella, un grupo de pasajeros de un avión tratan de sobrevivir en una isla del Pacífico después de que la aeronave en la que viajaban se estrellara allí. Pronto descubren los misterios que envuelven el lugar.','Lost',NULL,'/files/logo_Lost.jpg',NULL,NULL),(23,'El protagonista Rick Grimes se despierta tras varios meses en un hospital y descubre que el mundo que conocía ya no existe. Ahora los caminantes han ocupado las calles.','The Walking Dead',NULL,'/files/logo_TheWalkingDead.jpg',NULL,NULL),(24,'La baja natalidad y los desastres medioambientales han provocado que en Gilead se imponga un régimen fundamentalista en el que las mujeres son categorizadas según su fertilidad.','El cuento de la criada',NULL,'/files/logo_ElCuentoDeLaCriada.jpg',NULL,NULL),(25,'La ficción gira en torno al conocido personaje de Saul Goodman y cómo, seis años antes de conocer a Walter White, pasó de ser un ex-estafador que apenas puede llegar a fin de mes a un abogado.','Better Call Saul',NULL,'/files/logo_BetterCallSaul.jpg',NULL,NULL),(26,'La serie sigue el juego en el que participan más de cuatrocientas personas que están endeudadas.','El juego del calamar',NULL,'/files/logo_ElJuegoDelCalamar.jpg',NULL,NULL),(27,'The Boys, un grupo de vigilantes justicieros que tratan de vencer a los superhéroes corruptos que están deteriorando la sociedad.','The Boys',NULL,'/files/logo_TheBoys.jpg',NULL,NULL),(28,'Inspirada en el personaje legendario nórdico, esta serie sigue la pista a Ragnar y su familia vikinga. Este se supone descendiente de Odín, y se revela con el fin de en el rey lider de los pueblos vikingos.','Vikingos',NULL,'/files/logo_Vikingos.jpg',NULL,NULL),(29,'Su protagonista, Dexter, resulta ser un forense especializado en análisis de salpicaduras de sangre, pero, además, es un psicópata.','Dexter',NULL,'/files/logo_Dexter.jpg',NULL,NULL),(30,'Se trata de una ficción antológica en cada una de sus temporadas, lo cual supone la presentación de historias, tramas y personajes diferentes en cada entrega.','American Horror Story',NULL,'/files/logo_AmericanHorrorStory.jpg',NULL,NULL);
/*!40000 ALTER TABLE `series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporada`
--

DROP TABLE IF EXISTS `temporada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temporada` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `id_serie` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrpwbkv6k64xwngjy8ribqo0rw` (`id_serie`),
  CONSTRAINT `FKrpwbkv6k64xwngjy8ribqo0rw` FOREIGN KEY (`id_serie`) REFERENCES `series` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporada`
--

LOCK TABLES `temporada` WRITE;
/*!40000 ALTER TABLE `temporada` DISABLE KEYS */;
INSERT INTO `temporada` VALUES (1,'T1BRBA','T1',1),(2,'T2BRBA','T2',1),(3,'T3BRBA','T3',1),(4,'T4BRBA','T4',1),(5,'T5BRBA','T5',1),(6,'T1SPR','T1',2),(7,'T2SPR','T2',2),(8,'T3SPR','T3',2),(9,'T4SPR','T4',2),(10,'T5SPR','T5',2),(11,'T6SPR','T6',2),(12,'T1GOT','T1',3),(13,'T2GOT','T2',3),(14,'T3GOT','T3',3),(15,'T4GOT','T4',3),(16,'T5GOT','T5',3),(17,'T6GOT','T6',3),(18,'T7GOT','T7',3),(19,'T8GOT','T8',3),(20,'T1TW','T1',4),(21,'T2TW','T2',4),(22,'T3TW','T3',4),(23,'T4TW','T4',4),(24,'T5TW','T5',4),(25,'T1TD','T1',5),(26,'T2TD','T2',5),(27,'T3TD','T3',5),(28,'LST1','T1',6),(29,'LST2','T2',6),(30,'LST3','T3',6),(31,'LST4','T4',6),(32,'LST5','T5',6),(33,'LST6','T6',6),(34,'LST7','T7',6),(35,'LST8','T8',6),(36,'LST9','T9',6),(37,'LST10','T10',6),(38,'LST11','T11',6),(39,'LST12','T12',6),(40,'LST13','T13',6),(41,'LST14','T14',6),(42,'LST15','T15',6),(43,'LST16','T16',6),(44,'LST17','T17',6),(45,'LST18','T18',6),(46,'LST19','T19',6),(47,'LST20','T20',6),(48,'LST21','T21',6),(49,'LST22','T22',6),(50,'LST23','T23',6),(51,'LST24','T24',6),(52,'LST25','T25',6),(53,'LST26','T26',6),(54,'LST27','T27',6),(55,'LST28','T28',6),(56,'LST29','T29',6),(57,'LST30','T30',6),(58,'LST31','T31',6),(59,'LST32','T32',6),(60,'LST33','T33',6),(61,'LST34','T34',6),(62,'CHT1','T1',7),(63,'ART1','T1',8),(64,'BMT1','T1',9),(65,'BMT2','T2',9),(66,'BMT3','T3',9),(67,'BMT4','T4',9),(68,'BMT5','T5',9),(69,'RMT1','T1',10),(70,'RMT2','T2',10),(71,'RMT3','T3',10),(72,'RMT4','T4',10),(73,'RMT5','T5',10),(74,'RMT6','T6',10),(75,'FRT1','T1',11),(76,'FRT2','T2',11),(77,'FRT3','T3',11),(78,'FRT4','T4',11),(79,'FRT5','T5',11),(80,'FRT6','T6',11),(81,'FRT7','T7',11),(82,'FRT8','T8',11),(83,'FRT9','T9',11),(84,'FRT10','T10',11),(85,'DRKT1','T1',12),(86,'DRKT2','T2',12),(87,'DRKT3','T3',12),(88,'CPT1','T1',13),(89,'CPT2','T2',13),(90,'CPT3','T3',13),(91,'CPT4','T4',13),(92,'CPT5','T5',13),(93,'PBT1','T1',14),(94,'PBT2','T2',14),(95,'PBT3','T3',14),(96,'PBT4','T4',14),(97,'PBT5','T5',14),(98,'PBT6','T6',14),(99,'TOT1','T1',15),(100,'TOT2','T2',15),(101,'TOT3','T3',15),(102,'TOT4','T4',15),(103,'TOT5','T5',15),(104,'TOT6','T6',15),(105,'TOT7','T7',15),(106,'TOT8','T8',15),(107,'TOT9','T9',15),(108,'BHT1','T1',16),(109,'BHT2','T2',16),(110,'BHT3','T3',16),(111,'BHT4','T4',16),(112,'BHT5','T5',16),(113,'BHT6','T6',16),(114,'SKT1','T1',17),(115,'SKT2','T2',17),(116,'SKT3','T3',17),(117,'SKT4','T4',17),(118,'MMT1','T1',18),(119,'MMT2','T2',18),(120,'MMT3','T3',18),(121,'MMT4','T4',18),(122,'MMT5','T5',18),(123,'MMT6','T6',18),(124,'MMT7','T7',18),(125,'STT1','T1',19),(126,'STT2','T2',19),(127,'STT3','T3',19),(128,'STT4','T4',19),(129,'TLT1','T1',20),(130,'TLT2','T2',20),(131,'TLT3','T3',20),(132,'TPT1','T1',21),(133,'TPT2','T2',21),(134,'TPT3','T3',21),(135,'LOST1','T1',22),(136,'LOST2','T2',22),(137,'LOST3','T3',22),(138,'LOST4','T4',22),(139,'LOST5','T5',22),(140,'LOST6','T6',22),(141,'TWDT1','T1',23),(142,'TWDT2','T2',23),(143,'TWDT3','T3',23),(144,'TWDT4','T4',23),(145,'TWDT5','T5',23),(146,'TWDT6','T6',23),(147,'TWDT7','T7',23),(148,'TWDT8','T8',23),(149,'TWDT9','T9',23),(150,'TWDT10','T10',23),(151,'TWDT11','T11',23),(152,'CCT1','T1',24),(153,'CCT2','T2',24),(154,'CCT3','T3',24),(155,'CCT4','T4',24),(156,'CCT5','T5',24),(157,'BCST1','T1',25),(158,'BCST2','T2',25),(159,'BCST3','T3',25),(160,'BCST4','T4',25),(161,'BCST5','T5',25),(162,'BCST6','T6',25),(163,'JCT1','T1',26),(164,'TBT1','T1',27),(165,'TBT2','T2',27),(166,'TBT3','T3',27),(167,'VKT1','T1',28),(168,'VKT2','T2',28),(169,'VKT3','T3',28),(170,'VKT4','T4',28),(171,'VKT5','T5',28),(172,'VKT6','T6',28),(173,'DXT1','T1',29),(174,'DXT2','T2',29),(175,'DXT3','T3',29),(176,'DXT4','T4',29),(177,'DXT5','T5',29),(178,'DXT6','T6',29),(179,'DXT7','T7',29),(180,'DXT8','T8',29),(181,'AHST1','T1',30),(182,'AHST2','T2',30),(183,'AHST3','T3',30),(184,'AHST4','T4',30),(185,'AHST5','T5',30),(186,'AHST6','T6',30),(187,'AHST7','T7',30),(188,'AHST8','T8',30),(189,'AHST9','T9',30),(190,'AHST10','T10',30);
/*!40000 ALTER TABLE `temporada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amigo` bigint DEFAULT NULL,
  `avatar` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `borrar_amigo` bit(1) DEFAULT NULL,
  `cancelar_suscripcion` bit(1) DEFAULT NULL,
  `clave` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `control_parental` bit(1) DEFAULT NULL,
  `correo` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `editar_perfil` bit(1) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `genero` tinyint DEFAULT NULL,
  `nombre_usuario` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `pais` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `soporte` varchar(225) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `suscripcion` bit(1) DEFAULT NULL,
  `token_restaurar_contra` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_of5vabgukahdwmgxk4kjrbu98` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,NULL,NULL,NULL,NULL,'Mikasa123!',NULL,'karim.m.rachidi@gmail.com',28,NULL,NULL,0,'KarimRach','España',NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,'$2a$10$mpnu.0rX5svOLejg9/EMe.hAfxoRsi1HeI4PgCI3XNDLEH6ISxg7y',NULL,'rachiplays@gmail.com',28,NULL,NULL,0,'Karim','Marruecos',NULL,NULL,NULL),(3,NULL,NULL,NULL,NULL,'$2a$10$grlmR42jj0N.9SftG3U6BO4ylTdrbMUZMzX5noVbsIVFvMKIuslHu',NULL,'usuprueba@gmail.com',12,NULL,NULL,1,'usuprueba','Bosnia',NULL,NULL,NULL),(4,NULL,NULL,NULL,NULL,'$2a$10$54Iu1DTaQET3HYK.aWY3ge0VNaijhfnjd66NQfjcbFHW/uCiUBW1i',NULL,'ajo@gmail.com',32,NULL,NULL,2,'Cebolla','México',NULL,NULL,NULL),(5,NULL,NULL,NULL,NULL,'$2a$10$e87JEfSW7UwQ8hyQvyd4d.xTfnY4AySzvua8KP2J4KMDknUd5wV8K',NULL,'juanuser@gmail.com',31,NULL,NULL,0,'JuanUser','Nepal',NULL,NULL,NULL),(6,NULL,NULL,NULL,NULL,'$2a$10$ixWb9BXgGRL6s3LyE3Ncj.kgMBWCkQX.Ri1DWef39.cZPg1uvffEG',NULL,'userprueba@gmail.com',54,NULL,NULL,2,'UserPrueba1','Bélgica',NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_roles`
--

DROP TABLE IF EXISTS `usuarios_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_roles` (
  `usuario_id` bigint NOT NULL,
  `rol_id` bigint NOT NULL,
  KEY `FK5338ehgluufgc8bpj08nrq970` (`rol_id`),
  KEY `FKqcxu02bqipxpr7cjyj9dmhwec` (`usuario_id`),
  CONSTRAINT `FK5338ehgluufgc8bpj08nrq970` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKqcxu02bqipxpr7cjyj9dmhwec` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_roles`
--

LOCK TABLES `usuarios_roles` WRITE;
/*!40000 ALTER TABLE `usuarios_roles` DISABLE KEYS */;
INSERT INTO `usuarios_roles` VALUES (2,1),(3,2),(5,3),(6,3),(4,2);
/*!40000 ALTER TABLE `usuarios_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-08 14:01:57
