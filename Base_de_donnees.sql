--create database JO;


drop table Epreuve;
drop table Matchs;
drop table Pays;
drop table Athlete;
drop table Equipe;
drop table JeuxOlympique;
drop table Sport;



create table Sport(
    id_sport varchar(70),
    valeurForce INT(100),
    valeurEndurance INT(100),
    valeurAgilite INT(100),
    nbjoueur INT,
     PRIMARY KEY (id_sport));

create table JeuxOlympique(
    id_JeuxOlympique INT,
    nomJeuxOlympique varchar(40),
    lieu varchar(100),
    annee DATE,
    id_sport varchar(70),
    PRIMARY KEY (id_JeuxOlympique));

create table Epreuve(
    id_Epreuve INT,
    id_sport varchar(70),
    nomEpreuve varchar(100),
    categorieEpreuve varchar(100),
    typeEpreuve varchar(100),
    sexEpreuve varchar(1),
    PRIMARY KEY (id_Epreuve));

create table Matchs(
    id_Match INT,
    Matchtypes varchar(10),
    score INT,
    PRIMARY KEY (id_Match,Matchtypes));

create table Pays(
    id_pays varchar(100),
    medpays_or INT,
    medpays_argent INT,
    medpay_bronze INT,
    id_JeuxOlympique INT,
    PRIMARY KEY (id_pays));

create table Athlete(
    id_Athlete INT,
    NomAt varchar(50),
    PrenomAT varchar(50),
    SexeAT varchar(1),
    stats_Force INT(100),
    stats_Endurance INT(100),
    stats_agilite INT(100),
    id_Equipe INT,
    PRIMARY KEY (id_Athlete));

create table Equipe(
    id_Equipe INT,
    medEquipe_or INT,
    medEquipe_argent INT,
    medEquipe_bronze INT,
    sexeEquipe varchar(1),
    PRIMARY KEY (id_Equipe));

ALTER TABLE JeuxOlympique ADD FOREIGN KEY (id_sport) REFERENCES Sport(id_sport);
ALTER TABLE Athlete ADD FOREIGN KEY (id_Equipe) REFERENCES Equipe(id_Equipe);
ALTER TABLE Pays ADD FOREIGN KEY (id_JeuxOlympique) REFERENCES JeuxOlympique(id_JeuxOlympique);
ALTER TABLE Epreuve ADD FOREIGN KEY (id_sport) REFERENCES Sport(id_sport);


/*

insert INTo Sport values ();
insert INTo JeuxOlympique values ();
insert INTo Epreuve values ();
insert INTo Matchs values ();
insert INTo Pays values ();
insert INTo Athlete values ();
insert INTo equipe values ();

*/