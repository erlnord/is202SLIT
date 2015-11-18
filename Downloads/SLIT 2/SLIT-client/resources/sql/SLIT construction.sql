DROP SCHEMA IF EXISTS SLIT;

CREATE SCHEMA IF NOT EXISTS SLIT;

USE SLIT;

CREATE TABLE User (
UserID INT NOT NULL AUTO_INCREMENT,
UserType INT,
LastName VARCHAR(30),
UserName VARCHAR(20),
PassPhrase VARCHAR(45),
Email VARCHAR(45),
PRIMARY KEY (UserID))
ENGINE = InnoDB;

CREATE TABLE Booking (
BookingID INT NOT NULL,
Busy INT,
UserID INT,
PRIMARY KEY (BookingID),
CONSTRAINT fk_Booking_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

CREATE TABLE Schedule (
ScheduleID INT NOT NULL,
Schedule_Date DATE,
Schedule_Time TIME,
UserID INT,
PRIMARY KEY (ScheduleID),
CONSTRAINT fk_Schedule_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

CREATE TABLE Notification (
NotifID INT NOT NULL,
Message VARCHAR(255),
UserID INT,
PRIMARY KEY (NotifID),
CONSTRAINT fk_Notification_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

CREATE TABLE Module (
ModuleID INT NOT NULL,
ModuleName VARCHAR(65),
ModuleFile MEDIUMBLOB,
UserID INT,
PRIMARY KEY (ModuleID),
CONSTRAINT fk_Module_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

CREATE TABLE Delivery (
DeliveryID INT NOT NULL,
Status INT,
Feedback VARCHAR (255),
DeliveryFile MEDIUMBLOB,
UserID INT,
PRIMARY KEY (DeliveryID),
CONSTRAINT fk_Delivery_User
FOREIGN KEY (UserID) REFERENCES User(UserID))
ENGINE = InnoDB;

INSERT INTO User (UserType, FirstName, LastName, UserName, PassPhrase, Email)
VALUES (1, "Urlund", "North", "arne", "passord", "arne@urlundmail.com");
