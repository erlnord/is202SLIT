DROP SCHEMA IF EXISTS SLIT;

CREATE SCHEMA IF NOT EXISTS SLIT;

USE SLIT;

CREATE TABLE User (
UserID INT NOT NULL AUTO_INCREMENT,
UserType INT,
FirstName VARCHAR(30),
LastName VARCHAR(30),
UserName VARCHAR(20),
PassPhrase VARCHAR(45),
Email VARCHAR(45),
PRIMARY KEY (UserID))
ENGINE = InnoDB;

CREATE TABLE Information (
InfoID INT NOT NULL AUTO_INCREMENT,
InfoText TEXT,
UserID INT NOT NULL,
PRIMARY KEY (InfoID),
CONSTRAINT fk_Information_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

CREATE TABLE Notification (
NotifID INT NOT NULL AUTO_INCREMENT,
Message VARCHAR(255),
UserID INT NOT NULL,
PRIMARY KEY (NotifID),
CONSTRAINT fk_Notification_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

CREATE TABLE Module (
ModuleID INT NOT NULL AUTO_INCREMENT,
ModuleName VARCHAR(65),
ModuleFile MEDIUMBLOB,
ModuleDescription TEXT,
UserID INT NOT NULL,
PRIMARY KEY (ModuleID),
CONSTRAINT fk_Module_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

CREATE TABLE Delivery (
DeliveryID INT NOT NULL AUTO_INCREMENT,
Status INT,
Feedback VARCHAR (255),
DeliveryFile MEDIUMBLOB,
UserID INT NOT NULL,
PRIMARY KEY (DeliveryID),
CONSTRAINT fk_Delivery_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Urlund", "North", "arne", "passord", "arne@urlundmail.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Ola", "Hansen", "olehansen", "passord", "olahansen@gmail.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Kevin", "Pascal", "kevinp", "passord", "kevinpascal@urlundmail.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (2, "Hallgeir", "Nilsen", "hallgeir", "passord", "hallgeir.nilsen@uia.no");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (2, "Even", "Larsen", "evenlarsen", "passord", "even.larsen@uia.no");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Trygve", "Åse Lunde", "superdydde", "megadydde", "dydde@dyddemail.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (3, "Lars Martin", "Risdal", "larsemann", "passord12", "lmrisdal@icloud.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Kjetil", "Lolsen", "kjettil", "passord", "lolsen@yahoo.com");

INSERT INTO Notification (Message, UserID)
VALUES ("Endret frist for levering av modul 5. Fristen er nå 22. November", 1);
INSERT INTO Notification (Message, UserID)
VALUES ("", 1);
INSERT INTO Notification (Message, UserID)
VALUES ("Endret frist for levering av modul 5. Fristen er nå 22. November", 1);
INSERT INTO Notification (Message, UserID)
VALUES ("Endret frist for levering av modul 5. Fristen er nå 22. November", 1);

INSERT INTO Information (InfoText, UserID)
VALUES ("IS-109: Godkjenning av modul 4. Se plan for torsdag 6 og fredag 7. november 
og framover. Jeg og Even kan godkjenne moddul 4, avtal ledig tidspunkt med Even, 
Hallgeir. Husk siste frist for godkjenning av modul 4 er onsdag 26. november kl 12.00 på dagen. 
Både Even og jeg har andre forpliktelser, og er også bortreist noean dager før dette. 
Derfor viktig at dere avtaler tidspunkt for godkjenning. Torsdag 13 november kan dere 
komme innom kontoret mitt uten avtale for å se på godkjenning av modul 4. Ellers er både 
Even og jeg tilgjengelige når vi er på kontoret.", 1);
