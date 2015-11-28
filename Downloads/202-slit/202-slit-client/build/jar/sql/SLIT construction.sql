DROP SCHEMA IF EXISTS slit;

CREATE SCHEMA IF NOT EXISTS slit;

USE slit;

/* Opretter tabellen "bruker"
Tabellen inneholder en brukerID som er unik for hver bruker.
I tillegg fornavn, etternavn, brukernavn, passord og epostadresse.
*/
CREATE TABLE Users (
UserID INT NOT NULL AUTO_INCREMENT,
UserType INT,
FirstName VARCHAR(30),
LastName VARCHAR(30),
UserName VARCHAR(20),
PassPhrase VARCHAR(45),
Email VARCHAR(45),
PRIMARY KEY (UserID))
ENGINE = InnoDB;

/* Oppretter tabellen Informasjon. 
Tabellen brukes til å lagre informasjon som blir lagt ut på informasjon-siden i applikasjonen.
Bruker Foreign key userID for å se hvem som har lagt ut informasjonen.
*/
CREATE TABLE Information (
InfoID INT NOT NULL AUTO_INCREMENT,
InfoText TEXT,
UserID INT NOT NULL,
PRIMARY KEY (InfoID),
CONSTRAINT fk_Information_User
FOREIGN KEY (UserID) REFERENCES Users(UserID))
ENGINE = InnoDB;

/* Oppretter tabellen notifikasjoner. Tabellen lagrer notifikasjoner som blir sendt
innad i programmet. Foreign key er UserID, for å se hvem som har sendt meldingene. 
*/
CREATE TABLE Notification (
NotifID INT NOT NULL AUTO_INCREMENT,
Message VARCHAR(255),
UserID INT NOT NULL,
PRIMARY KEY (NotifID),
CONSTRAINT fk_Notification_User
FOREIGN KEY (UserID) REFERENCES Users(UserID))
ENGINE = InnoDB;

/* Lager tabellen modul. Tabellen lagrer informasjon og unik ID på hver av de forskjellige modulene.
FK UserID blir brukt for å se hvilken lærer som har lagt ut modulen. 
*/
CREATE TABLE Module (
ModuleID INT NOT NULL AUTO_INCREMENT,
ModuleName VARCHAR(65),
ModuleDescription VARCHAR(6500),
ModuleApproval VARCHAR(6500),
ModuleResource VARCHAR(6500),
UserID INT NOT NULL,
PRIMARY KEY (ModuleID),
CONSTRAINT fk_Module_User
FOREIGN KEY (UserID) REFERENCES Users(UserID))
ENGINE = InnoDB;

/* Opretter tabellen Resource. Lagrer en hyperlink som blir brukt som ressurs til en modul.
*/
CREATE TABLE Resource (
ResourceID INT NOT NULL AUTO_INCREMENT,
ResourceLink VARCHAR(100),
ModuleID INT,
PRIMARY KEY (ResourceID),
CONSTRAINT fk_Resource_Module
FOREIGN KEY (ModuleID) REFERENCES Module(ModuleID))
ENGINE = InnoDB;

/* Oppretter tabellen Delivery.
Blir brukt til å lagre informasjon om innleveringen til en fil. 
*/
CREATE TABLE Delivery (
DeliveryID INT NOT NULL AUTO_INCREMENT,
Status INT,
Feedback VARCHAR (255),
DeliveryFile MEDIUMBLOB,
UserID INT NOT NULL,
ModuleID INT NOT NULL,
PRIMARY KEY (DeliveryID),
CONSTRAINT fk_Delivery_User
FOREIGN KEY (UserID) REFERENCES Users(UserID),
CONSTRAINT fk_Delivery_Module
FOREIGN KEY (ModuleID) REFERENCES Module(ModuleID))
ENGINE = InnoDB;

/* Legger inn eksempelinformasjon om brukere. 
*/
INSERT INTO Users (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Urlund", "North", "arne", "passord", "arne@urlundmail.com");
INSERT INTO Users (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Ola", "Hansen", "olehansen", "passord", "olahansen@gmail.com");
INSERT INTO Users (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Kevin", "Pascal", "kevinp", "passord", "kevinpascal@gmail.com");
INSERT INTO Users (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (2, "Hallgeir", "Nilsen", "hallgeir", "passord", "hallgeir.nilsen@uia.no");
INSERT INTO Users (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (2, "Even", "Larsen", "evenlarsen", "passord", "even.larsen@uia.no");
INSERT INTO Users (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Trygve", "Åse Lunde", "superdydde", "megadydde", "dydde@dyddemail.com");
INSERT INTO Users (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (3, "Lars Martin", "Risdal", "larsemann", "passord12", "lmrisdal@icloud.com");
INSERT INTO Users (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Kjetil", "Lolsen", "kjettil", "passord", "lolsen@gmail.com");

/* Legger inn eksempelnotifikasjoner. 
*/
INSERT INTO Notification (Message, UserID)
VALUES ("Endret frist for levering av modul 5. Fristen er nå 22. November", 1);
INSERT INTO Notification (Message, UserID)
VALUES ("Godkjennings Drop in torsdag 20 og fredag 21 nov. Se planen", 4);
INSERT INTO Notification (Message, UserID)
VALUES ("Når du skal treffe Even eller Hallgeir ifm godkjenning av modul 4, ta med egen PC, 
der du viser prosjekt du har gjort selv. Når ikke annet er oppgitt skjer dette på kontoret til henholdsvis Even, Hallgeir.", 1);
INSERT INTO Notification (Message, UserID)
VALUES ("Det blir lab imorgen 4.11, Kenneth er der fra 10.15 til 12.", 2);

/* Legger inn eksempelinformasjonstekster.
*/
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

/* Legger inn eksempelinformasjon om moduler.
*/
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES (1, 'Modul 1', 5, "I denne modulen skal du først og fremst lære å bruke verktøyene du skal bruke i resten av kurset.
I tillegg skal du begynne å lære litt om objektorientert programmering og java.", "Det er ikke noen programmeringsoppgave i modul 1.

Lag en video der du forklarer læringsmålene i modulen. Bruk Camtasia Relay eller annet egnet verktøy for skjermopptak. Link skal inn på bloggen. (PS: Max 5 min). 
Foreleser eller hjelpelærer godkjenner videoen-", 
"Læreboka, kap. 1 

Prosjekter: Figures, House og Lab-classes.

Miniforelsninger
Intro til Modul 1
Bruk av BlueJ
Klasser og objekter I
Klasser og objekter II

Video fra forfatterne av læreboka:
Chapter 1: VN 1.1 Introduction to key concepts
Chapter 1: VN 1.2 Creating and using objects within BlueJ
Chapter 1: VN 1.3 methods and parameters
Chapter 1: VN 1.4 Solving a challenge exercise
");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES (2, 'Modul 2', 5, "I denne modulen skal du lære å lese java klassedefinisjoner. Java programmer 
består av klasser, så du skal egentlig lære å lese javaprogrammer. Du skal også få prøve å skrive enkle 
programmer, men akkurat som når du skal lære andre språk, må du lære å lese før du kan begynne å skrive.", 
"Skriv en klasse selv fra scratch. Lag noe annet enn en kopi av eksemplene i boka (som sjokoladeautomat og lignende)

Godkjennes av foreleser eller hjelpelærer i intervju.", "Læreboka, kap. 2

Prosjekter: Figures, House og Lab-classes

Miniforelsninger
Intro til Modulen
Forstå klassedefinisjoner
Intro til constructor og metoder
Intro til setters og getters
Mer om getters og setters
Lokale variable
If-setninger

Video fra forfatterne av læreboka:
Chapter 2: VN 2.1 The naive ticket machine project
Chapter 2: VN 2.2 introduction to source code - fields and constructors
Chapter 2: VN 2.3 Creating, documenting and testing a new class
");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES ('3', 'Modul 3', '4', "", "", "");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES ('4', 'Modul 4', '4', "", "", "");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES ('5', 'Modul 5', '5', "", "", "");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES ('6', 'Modul 6', '4', "", "", "");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES ('7', 'Modul 7', '5', "", "", "");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES ('8', 'Modul 8', '4', "", "", "");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES ('9', 'Modul 9', '5', "", "", "");
INSERT INTO Module (ModuleID, ModuleName, UserID, ModuleDescription, ModuleApproval, ModuleResource) 
VALUES ('10', 'Modul 10', '4', "", "", "");

/* Legger inn eksempelinformasjon om innleveringer. 
*/
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (2, 1, 1, "Godkjent");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (2, 1, 2, "Godkjent");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (3, 1, 3, "Ikke godkjent");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (1, 1, 4, "Ikke vurdert");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (1, 2, 1, "Ikke vurdert");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (1, 2, 2, "Ikke vurdert");
INSERT INTO Delivery (Status, UserID, ModuleID, Feedback) VALUES (1, 2, 3, "Ikke vurdert");

/* Legger inn eksempelinformasjon om hyperlinkressurser.
*/
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("vg.no", 1);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("dagbladet.no", 1);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("youtube.com", 1);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("vg.no", 2);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("gamer.no", 2);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("itavisen.no", 2);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("java.com", 3);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("vg.no", 3);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("java.com", 4);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("java.com", 4);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("java.com", 5);
INSERT INTO Resource (ResourceLink, ModuleID) VALUES ("java.com", 6);