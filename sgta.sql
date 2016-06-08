/*
Navicat MySQL Data Transfer

Source Server         : SGTA
Source Server Version : 100113
Source Host           : localhost:3306
Source Database       : sgta

Target Server Type    : MYSQL
Target Server Version : 100113
File Encoding         : 65001

Date: 2016-06-08 17:46:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agenda
-- ----------------------------
DROP TABLE IF EXISTS `agenda`;
CREATE TABLE `agenda` (
  `id_agenda` int(11) NOT NULL,
  `id_banca` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_agenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agenda
-- ----------------------------

-- ----------------------------
-- Table structure for arquivos
-- ----------------------------
DROP TABLE IF EXISTS `arquivos`;
CREATE TABLE `arquivos` (
  `id_arquivo` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  PRIMARY KEY (`id_arquivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of arquivos
-- ----------------------------

-- ----------------------------
-- Table structure for banca
-- ----------------------------
DROP TABLE IF EXISTS `banca`;
CREATE TABLE `banca` (
  `id_banca` int(11) NOT NULL,
  `id_trabalho` int(11) NOT NULL,
  `id_orientador` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `data_defesa` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_banca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banca
-- ----------------------------

-- ----------------------------
-- Table structure for convites
-- ----------------------------
DROP TABLE IF EXISTS `convites`;
CREATE TABLE `convites` (
  `id_convite` int(11) NOT NULL,
  `id_convidante` int(11) NOT NULL,
  `id_convidado` int(11) NOT NULL,
  `tipo_convite` varchar(255) NOT NULL,
  `id_trabalho` int(11) NOT NULL,
  PRIMARY KEY (`id_convite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of convites
-- ----------------------------

-- ----------------------------
-- Table structure for mensagens
-- ----------------------------
DROP TABLE IF EXISTS `mensagens`;
CREATE TABLE `mensagens` (
  `id_Mensagens` int(11) NOT NULL,
  `id_Remetente` int(11) NOT NULL,
  `id_Destinatario` int(11) NOT NULL,
  `Assunto` varchar(255) NOT NULL,
  PRIMARY KEY (`id_Mensagens`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mensagens
-- ----------------------------

-- ----------------------------
-- Table structure for oportunidades
-- ----------------------------
DROP TABLE IF EXISTS `oportunidades`;
CREATE TABLE `oportunidades` (
  `id_oportunidade` int(11) NOT NULL,
  `id_orientador` int(11) NOT NULL,
  `num_Vagas` int(11) NOT NULL,
  `vagas_Restantes` int(11) NOT NULL,
  `descriçao` varchar(255) NOT NULL,
  `tipo_de_bolsa` varchar(255) NOT NULL,
  `valor_da_bolsa` int(11) NOT NULL,
  `duração` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `requisitos` varchar(255) NOT NULL,
  PRIMARY KEY (`id_oportunidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oportunidades
-- ----------------------------

-- ----------------------------
-- Table structure for orientador_trabalhos
-- ----------------------------
DROP TABLE IF EXISTS `orientador_trabalhos`;
CREATE TABLE `orientador_trabalhos` (
  `id_usuario` int(11) NOT NULL,
  `id_trabalho` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orientador_trabalhos
-- ----------------------------

-- ----------------------------
-- Table structure for publicacoes
-- ----------------------------
DROP TABLE IF EXISTS `publicacoes`;
CREATE TABLE `publicacoes` (
  `id_publicacao` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `requisitos` varchar(255) NOT NULL,
  `qualis` varchar(255) NOT NULL,
  `data_submissao` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `data_evento` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_publicacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicacoes
-- ----------------------------

-- ----------------------------
-- Table structure for resultados
-- ----------------------------
DROP TABLE IF EXISTS `resultados`;
CREATE TABLE `resultados` (
  `id_resultado` int(11) NOT NULL,
  `id_trabalho` int(11) NOT NULL,
  PRIMARY KEY (`id_resultado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resultados
-- ----------------------------

-- ----------------------------
-- Table structure for trabalhos
-- ----------------------------
DROP TABLE IF EXISTS `trabalhos`;
CREATE TABLE `trabalhos` (
  `id_trabalho` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `assunto` varchar(255) NOT NULL,
  PRIMARY KEY (`id_trabalho`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trabalhos
-- ----------------------------

-- ----------------------------
-- Table structure for trabalho_arquivos
-- ----------------------------
DROP TABLE IF EXISTS `trabalho_arquivos`;
CREATE TABLE `trabalho_arquivos` (
  `id_trabalho` int(11) NOT NULL,
  `id_arquivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trabalho_arquivos
-- ----------------------------

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(253) NOT NULL,
  `Nome` varchar(253) NOT NULL,
  `Senha` varchar(253) NOT NULL,
  `Matricula` varchar(253) NOT NULL,
  `CPF` varchar(253) NOT NULL,
  `email` varchar(253) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`Matricula`,`CPF`,`email`),
  UNIQUE KEY `Matricula` (`Matricula`) USING HASH,
  UNIQUE KEY `CPF` (`CPF`) USING HASH,
  UNIQUE KEY `email` (`email`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
