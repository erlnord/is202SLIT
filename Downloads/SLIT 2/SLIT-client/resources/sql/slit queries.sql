#SELECT * FROM DELIVERY WHERE ModuleID=1;

/*
SELECT FirstName, LastName, ModuleName, Feedback
FROM slit.delivery
INNER JOIN User ON user.UserID = delivery.UserID
INNER JOIN module ON module.ModuleID = delivery.ModuleID
WHERE delivery.UserID = 1;
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

/*
SELECT ModuleName, count(deliveryID) as Submissions
from module
LEFT JOIN Delivery ON Module.ModuleiD = delivery.ModuleiD
Group by module.moduleiD
HAVING Submissions <= 0;
*/

/*
SELECT FirstName, LastName, Email
From User
WHERE INSTR(email, 'gmail');
#WHERE Email LIKE '%gmail%');
*/

SELECT (
(select count(hyperlinkrscid) from hyperlinkrsc)
/
(select count(moduleid) from module)) as Average_Modules;






