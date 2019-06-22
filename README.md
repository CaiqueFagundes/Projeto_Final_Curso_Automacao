# Projeto_Final_Curso_Automacao

                                          Desafio - Mercado Livre
                                          ***********************

Neste projeto foi contemplado apenas o cenário proposto - Comuns

para iniciar a execução da automação é necessario garantir que

1º baixe todas as dependencias do projeto para garantir que ele rode.
2º Antes de iniciar verivifque que ja tenha inserido  codigo de verificação antes de iniciar. pois não é uma verificação simles e precisa de um codigo que seja enviado ao propio app ou telefone. 
3º Abra Logins.feature e altere o campo com Usuario e Senha validos para login e o Nome do Perfil para validação do mesmos . 

________________________________________________________________________________________________________________________________________

                                          Desafio - DevOps
                                          ****************
                                          
Para subia do jenkins utilize o script groovy abaixo:

  pipeline {
    environment{
        branchName = "*master"
        urlDoProjeto = "https://github.com/CaiqueFagundes/Projeto_Final_Curso_Automacao.git"
    }
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: branchName]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'UsrGitJenkins', url: urlDoProjeto]]])
            }
        }
        stage('Build') {
            steps {
                runTest();
            }
        }
    }
}

def runTest(){
    try{
        bat "mvn clean test -U -Dcucumber.options=\"--tags ${env.tags}\""
    } catch(Exception e){
        throw e
    }
}
________________________________________________________________________________________________________________________________________

                                                  Desafio - SQL
                                                  *************
Para o desafio de SQL é necesario criar as tabelas 

CREATE TABLE IF NOT EXISTS `mydb`.`TB_CADR_USU` (
  `ID_USU` INT GENERATED ALWAYS AS () VIRTUAL,
  `NAME_PART` VARCHAR(50) NULL,
  `DT_NASC` DATE NULL,
  `SEXO_PART` ENUM('F', 'M') NULL,
  `TELL_PART` VARCHAR(15) NULL,
  `EMAIL_PART` VARCHAR(50) NULL COMMENT 'TABELA DE CADASTRO DOS USUARIOS ',
  `USUARIO` VARCHAR(15) NOT NULL,
  `SENHA` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_USU`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`Rifas` (
  `ID_RIFAS` INT NOT NULL,
  `NAME_ITEM` VARCHAR(50) NULL,
  `VL_BILHETE` DECIMAL(5,2) NULL,
  `QTD_BILHETE` INT NULL,
  `DT_SORTEIO` DATE NULL,
  `NAME_RIFA` VARCHAR(50) NULL,
  PRIMARY KEY (`ID_RIFAS`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`Usuario_Rifa` (
  `ID_Usuario_Rifa` INT NOT NULL,
  `Rifas_ID_RIFAS` INT NOT NULL,
  `TB_CADR_USU_ID_USU` INT NOT NULL,
  PRIMARY KEY (`ID_Usuario_Rifa`, `Rifas_ID_RIFAS`, `TB_CADR_USU_ID_USU`),
  INDEX `fk_Usuario_Rifa_Rifas1_idx` (`Rifas_ID_RIFAS` ASC) VISIBLE,
  INDEX `fk_Usuario_CRIA_Rifa_TB_CADR_USU1_idx` (`TB_CADR_USU_ID_USU` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Rifa_Rifas1`
    FOREIGN KEY (`Rifas_ID_RIFAS`)
    REFERENCES `mydb`.`Rifas` (`ID_RIFAS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_CRIA_Rifa_TB_CADR_USU1`
    FOREIGN KEY (`TB_CADR_USU_ID_USU`)
    REFERENCES `mydb`.`TB_CADR_USU` (`ID_USU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`TB_Bilhete` (
  `ID_Bilhete` INT NOT NULL,
  `NR_BILHETE` INT NULL,
  `STAT_BILHETE` ENUM('G', 'P') NULL DEFAULT 'P',
  `Rifas_ID_RIFAS` INT NOT NULL,
  PRIMARY KEY (`ID_Bilhete`, `Rifas_ID_RIFAS`),
  INDEX `fk_TB_Bilhete_Rifas1_idx` (`Rifas_ID_RIFAS` ASC) VISIBLE,
  CONSTRAINT `fk_TB_Bilhete_Rifas1`
    FOREIGN KEY (`Rifas_ID_RIFAS`)
    REFERENCES `mydb`.`Rifas` (`ID_RIFAS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`TB_COMP_BILHETE` (
  `ID_COMP_BILHETE` INT NOT NULL,
  `TB_CADR_USU_ID_USU` INT NOT NULL,
  `TB_Bilhete_ID_Bilhete` INT NOT NULL,
  PRIMARY KEY (`ID_COMP_BILHETE`, `TB_CADR_USU_ID_USU`, `TB_Bilhete_ID_Bilhete`),
  INDEX `fk_TB_COMP_BILHETE_TB_CADR_USU1_idx` (`TB_CADR_USU_ID_USU` ASC) VISIBLE,
  INDEX `fk_TB_COMP_BILHETE_TB_Bilhete1_idx` (`TB_Bilhete_ID_Bilhete` ASC) VISIBLE,
  CONSTRAINT `fk_TB_COMP_BILHETE_TB_CADR_USU1`
    FOREIGN KEY (`TB_CADR_USU_ID_USU`)
    REFERENCES `mydb`.`TB_CADR_USU` (`ID_USU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_COMP_BILHETE_TB_Bilhete1`
    FOREIGN KEY (`TB_Bilhete_ID_Bilhete`)
    REFERENCES `mydb`.`TB_Bilhete` (`ID_Bilhete`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

________________________________________________________________________________________________________________________________________
                                          Comandos de Manuseio do Banco 
                                          *****************************
Para manusear as informações nas tabelas é preciso criar alguns insert ee alguns selects abaixo 

Cadasro de Usuario 
******************
insert into TB_CADR_USU (ID_USU, NAME_PART, DT_NASC, SEXO_PART, TELL_PART, EMAIL_PART, USUARIO, SENHA)
values(DEFAULT,'Fulano', 2019-05-09, 'M','42514367','email@gmail.com', 'Fulano', 'admin');

insert into TB_Rifas
********************
  insert into TB_Rifas 
  values (ID_RIFAS, NAME_ITEM, VL_BILHETE, QTD_BILHETE, DT_SORTEIO, NAME_RIFA);

  insert into (ID_Usuario_Rifa, Rifas_ID_RIFAS, TB_CADR_USU_ID_USU)
  VALUES(DEFAULT, '1','1');

Definição do Sorteio
********************
  insert into (ID_COMP_BILHETE,TB_CADR_USU_ID_USU, TB_Bilhete_ID_Bilhete, STAT_BILHETE)
  VALUES(DEFAULT, '1', '1','G')
  



