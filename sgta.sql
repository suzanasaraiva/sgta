-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: sgta
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `id_agenda` int(11) NOT NULL,
  `id_banca` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_agenda`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arquivos`
--

DROP TABLE IF EXISTS `arquivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arquivos` (
  `id_arquivo` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `file` longblob NOT NULL,
  `nome_arquivo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_arquivo`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arquivos`
--

LOCK TABLES `arquivos` WRITE;
/*!40000 ALTER TABLE `arquivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `arquivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banca`
--

DROP TABLE IF EXISTS `banca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banca` (
  `id_banca` int(11) NOT NULL,
  `id_trabalho` int(11) NOT NULL,
  `id_orientador` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `data_defesa` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id_banca`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banca`
--

LOCK TABLES `banca` WRITE;
/*!40000 ALTER TABLE `banca` DISABLE KEYS */;
/*!40000 ALTER TABLE `banca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convites`
--

DROP TABLE IF EXISTS `convites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convites` (
  `id_convite` int(11) NOT NULL,
  `id_convidante` int(11) NOT NULL,
  `id_convidado` int(11) NOT NULL,
  `tipo_convite` varchar(255) NOT NULL,
  `id_trabalho` int(11) NOT NULL,
  PRIMARY KEY (`id_convite`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convites`
--

LOCK TABLES `convites` WRITE;
/*!40000 ALTER TABLE `convites` DISABLE KEYS */;
/*!40000 ALTER TABLE `convites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensagens`
--

DROP TABLE IF EXISTS `mensagens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensagens` (
  `id_Mensagens` int(11) NOT NULL,
  `id_Remetente` int(11) NOT NULL,
  `id_Destinatario` int(11) NOT NULL,
  `assunto` varchar(255) NOT NULL,
  `mensagem` varchar(255) NOT NULL,
  `isRead` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_Mensagens`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagens`
--

LOCK TABLES `mensagens` WRITE;
/*!40000 ALTER TABLE `mensagens` DISABLE KEYS */;
INSERT INTO `mensagens` VALUES (1,0,0,'Mensagem','que envia',1),(2,1,0,'Colé','e aew, passando aqui pra deixar uma msg. blz?',1),(3,1,0,'Testar mensagem nova','mensagem nova bold.',1),(4,0,1,'RE: Testar mensagem nova','Essa é uma mesnagem pra mostrar que o responder também funciona',1);
/*!40000 ALTER TABLE `mensagens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oportunidades`
--

DROP TABLE IF EXISTS `oportunidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oportunidades` (
  `id_oportunidade` int(11) NOT NULL,
  `id_orientador` int(11) NOT NULL,
  `num_Vagas` int(11) NOT NULL,
  `vagas_Restantes` int(11) NOT NULL,
  `descriçao` varchar(255) NOT NULL,
  `tipo_de_bolsa` varchar(255) NOT NULL,
  `valor_da_bolsa` int(11) NOT NULL,
  `duração` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `requisitos` varchar(255) NOT NULL,
  PRIMARY KEY (`id_oportunidade`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oportunidades`
--

LOCK TABLES `oportunidades` WRITE;
/*!40000 ALTER TABLE `oportunidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `oportunidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orientador_trabalhos`
--

DROP TABLE IF EXISTS `orientador_trabalhos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orientador_trabalhos` (
  `id_usuario` int(11) NOT NULL,
  `id_trabalho` int(11) NOT NULL
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orientador_trabalhos`
--

LOCK TABLES `orientador_trabalhos` WRITE;
/*!40000 ALTER TABLE `orientador_trabalhos` DISABLE KEYS */;
/*!40000 ALTER TABLE `orientador_trabalhos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicacoes`
--

DROP TABLE IF EXISTS `publicacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publicacoes` (
  `id_publicacao` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `requisitos` varchar(255) NOT NULL,
  `qualis` varchar(255) NOT NULL,
  `data_submissao` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `data_evento` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id_publicacao`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicacoes`
--

LOCK TABLES `publicacoes` WRITE;
/*!40000 ALTER TABLE `publicacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultados`
--

DROP TABLE IF EXISTS `resultados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resultados` (
  `id_resultado` int(11) NOT NULL,
  `id_trabalho` int(11) NOT NULL,
  PRIMARY KEY (`id_resultado`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultados`
--

LOCK TABLES `resultados` WRITE;
/*!40000 ALTER TABLE `resultados` DISABLE KEYS */;
/*!40000 ALTER TABLE `resultados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabalho_arquivos`
--

DROP TABLE IF EXISTS `trabalho_arquivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabalho_arquivos` (
  `id_trabalho` int(11) NOT NULL,
  `id_arquivo` int(11) NOT NULL
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabalho_arquivos`
--

LOCK TABLES `trabalho_arquivos` WRITE;
/*!40000 ALTER TABLE `trabalho_arquivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabalho_arquivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabalhos`
--

DROP TABLE IF EXISTS `trabalhos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabalhos` (
  `id_trabalho` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `assunto` varchar(255) NOT NULL,
  PRIMARY KEY (`id_trabalho`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabalhos`
--

LOCK TABLES `trabalhos` WRITE;
/*!40000 ALTER TABLE `trabalhos` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabalhos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(253) NOT NULL,
  `Nome` varchar(253) NOT NULL,
  `Senha` varchar(253) NOT NULL,
  `Matricula` varchar(253) NOT NULL,
  `CPF` varchar(253) NOT NULL,
  `email` varchar(253) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`Matricula`,`CPF`,`email`),
  UNIQUE KEY `Matricula` (`Matricula`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `email` (`email`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (0,'Luiz','senhamassa','082.323.434-78','082.323.434-78','luiz@gmail.com','Aluno'),(1,'suh','senhamassa','096.991.834-89','082.323.434-79','suh@gmail.com','Aluno');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-20  0:14:03
