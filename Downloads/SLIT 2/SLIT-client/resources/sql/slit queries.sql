/* Løsning på oppgave 1. Møter brukerhistorien som omhandler følgende: 
Som Student vil jeg ha en oversikst over alle moduler som er levert. 
*/
/*
SELECT FirstName, LastName, ModuleName, Feedback
FROM slit.delivery
INNER JOIN User ON user.UserID = delivery.UserID
INNER JOIN module ON module.ModuleID = delivery.ModuleID
WHERE delivery.UserID = 1;
*/

/* Løsning på oppgave 2. Viser hvor mange innleveringer som er registrert per modul. 
*/
/*
DROP VIEW IF EXISTS DeliveryView;

CREATE VIEW DeliveryView AS
SELECT ModuleName, count(deliveryID) AS Submissions
FROM module
INNER JOIN delivery ON module.ModuleID = delivery.ModuleID
GROUP BY module.ModuleID;


#SELECT * FROM DeliveryView;
*/

/* Løsning på oppgave 3. Viser et view over alle modulene som ikke har fått inn noen innleveringer så langt. 
*/
/*
SELECT ModuleName, count(deliveryID) as Submissions
from module
LEFT JOIN Delivery ON Module.ModuleiD = delivery.ModuleiD
Group by module.moduleiD
HAVING Submissions <= 0;
*/

/* Løsning på oppgave 4. Viser en liste over alle studentene som har gmail som epostleverandør.
Her er to forskjellige måter å gjøre det på; WHERE INSTR og WHERE Email LIKE. Begge to gjør akkurat det samme. 
*/
/*
SELECT FirstName, LastName, Email
From User
WHERE INSTR(email, 'gmail');
#WHERE Email LIKE '%gmail%');
*/

/* Løsning på oppgave 5. Finner ut hvor mange ressurser hver modul har i gjennomsnitt. I vårt system har alle
elevene tilgang på alle modulene, og det blir derfor irrelevant å knytte spørringen opp mot en bruker. 
Vi har ikke lagt inn noe i videorsc-tabellen, og bruker derfor bare hyperlinkrsc i dette eksempelet. 

SELECT (
(select count(hyperlinkrscid) from hyperlinkrsc)
/
(select count(moduleid) from module)) as Average_Modules;
*/