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
ModuleDescription TEXT,
UserID INT NOT NULL,
PRIMARY KEY (ModuleID),
CONSTRAINT fk_Module_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

CREATE TABLE VideoRsc (
VideoRscID INT NOT NULL AUTO_INCREMENT,
VideoFile LONGBLOB,
ModuleID INT,
PRIMARY KEY (VideoRscID),
CONSTRAINT fk_VideoRsc_Module
FOREIGN KEY (ModuleID) REFERENCES Module(ModuleID))
ENGINE = InnoDB;

CREATE TABLE HyperlinkRsc (
HyperlinkRscID INT NOT NULL AUTO_INCREMENT,
Hyperlink VARCHAR(65),
ModuleID INT,
PRIMARY KEY (HyperlinkRscID),
CONSTRAINT fk_Hyperlink_Module
FOREIGN KEY (ModuleID) REFERENCES Module(ModuleID))
ENGINE = InnoDB;

CREATE TABLE Delivery (
DeliveryID INT NOT NULL AUTO_INCREMENT,
Status INT,
Feedback VARCHAR (255),
DeliveryFile MEDIUMBLOB,
UserID INT NOT NULL,
ModuleID INT NOT NULL,
PRIMARY KEY (DeliveryID),
CONSTRAINT fk_Delivery_User
FOREIGN KEY (UserID) REFERENCES User(UserID),
CONSTRAINT fk_Delivery_Module
FOREIGN KEY (ModuleID) REFERENCES Module(ModuleID))
ENGINE = InnoDB;

INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Urlund", "North", "arne", "passord", "arne@urlundmail.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Ola", "Hansen", "olehansen", "passord", "olahansen@gmail.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Kevin", "Pascal", "kevinp", "passord", "kevinpascal@gmail.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (2, "Hallgeir", "Nilsen", "hallgeir", "passord", "hallgeir.nilsen@uia.no");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (2, "Even", "Larsen", "evenlarsen", "passord", "even.larsen@uia.no");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Trygve", "Åse Lunde", "superdydde", "megadydde", "dydde@dyddemail.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (3, "Lars Martin", "Risdal", "larsemann", "passord12", "lmrisdal@icloud.com");
INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Kjetil", "Lolsen", "kjettil", "passord", "lolsen@gmail.com");

INSERT INTO Notification (Message, UserID)
VALUES ("Endret frist for levering av modul 5. Fristen er nå 22. November", 1);
INSERT INTO Notification (Message, UserID)
VALUES ("Godkjennings Drop in torsdag 20 og fredag 21 nov. Se planen", 4);
INSERT INTO Notification (Message, UserID)
VALUES ("Når du skal treffe Even eller Hallgeir ifm godkjenning av modul 4, ta med egen PC, 
der du viser prosjekt du har gjort selv. Når ikke annet er oppgitt skjer dette på kontoret til henholdsvis Even, Hallgeir.", 1);
INSERT INTO Notification (Message, UserID)
VALUES ("Det blir lab imorgen 4.11, Kenneth er der fra 10.15 til 12.", 2);

INSERT INTO Information (InfoText, UserID)
VALUES ("IS-109: Godkjenning av modul 4. Se plan for torsdag 6 og fredag 7. november 
og framover. Jeg og Even kan godkjenne moddul 4, avtal ledig tidspunkt med Even, 
Hallgeir. Husk siste frist for godkjenning av modul 4 er onsdag 26. november kl 12.00 på dagen. 
Både Even og jeg har andre forpliktelser, og er også bortreist noean dager før dette. 
Derfor viktig at dere avtaler tidspunkt for godkjenning. Torsdag 13 november kan dere 
komme innom kontoret mitt uten avtale for å se på godkjenning av modul 4. Ellers er både 
Even og jeg tilgjengelige når vi er på kontoret.", 4);
INSERT INTO Information (InfoText, UserID)
VALUES ("Hva skal dere gjøre når dere er ferdig med modul 5? Det er noen som (snart) er ferdig med alle fem modulene. 
Dere kan begynne på pensum for IS-110 hvis der vil være litt i forkant til høsten. Pensum er resten av boka. 
Ettersom dette er første gang vi kjører kursene 109/110 er ikke materialet for IS-110 klart ennå, men boka har 
heldigvis gode læringsmål for hvert kapittel. De læringsmålene vi kommer til å lage for 110 vil være ganske 
like de som står i bokaVi kan ikke godkjenne moduler i IS-110 før kurset starter til høsten, men hvis dere 
jobber dere gjennom noen av modulene nå, kan dere få dem godkjent ganske kjapt til høsten", 5);

INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('1', 'Modul 1', '5');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('2', 'Modul 2', '5');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('3', 'Modul 3', '4');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('4', 'Modul 4', '4');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('5', 'Modul 5', '5');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('6', 'Modul 6', '4');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('7', 'Modul 7', '5');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('8', 'Modul 8', '4');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('9', 'Modul 9', '5');
INSERT INTO slit.module (ModuleID, ModuleName, UserID) VALUES ('10', 'Modul 10', '4');

INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (2, 1, 1, "Godkjent");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (2, 1, 2, "Godkjent");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (3, 1, 3, "Ikke godkjent");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (1, 1, 4, "Ikke vurdert");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (1, 2, 1, "Ikke vurdert");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (1, 2, 2, "Ikke vurdert");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (1, 2, 3, "Ikke vurdert");

INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("vg.no", 1);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("dagbladet.no", 1);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("youtube.com", 1);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("vg.no", 2);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("gamer.no", 2);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("itavisen.no", 2);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("java.com", 3);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("vg.no", 3);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("java.com", 4);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("java.com", 4);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("java.com", 5);
INSERT INTO HyperlinkRsc (Hyperlink, ModuleID) VALUES ("java.com", 6);