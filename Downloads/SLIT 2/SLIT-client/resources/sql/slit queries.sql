#SELECT * FROM DELIVERY WHERE ModuleID=1;

/*
SELECT FirstName, LastName, ModuleName, Feedback
FROM slit.delivery
INNER JOIN User ON user.UserID = delivery.UserID
INNER JOIN module ON module.ModuleID = delivery.ModuleID
WHERE delivery.UserID = 1;
*/

DROP VIEW IF EXISTS DeliveryView;

CREATE VIEW DeliveryView AS

SELECT ModuleName, count(DeliveryID)
FROM module
INNER JOIN delivery ON delivery.ModuleID = module.moduleID;


#SELECT * FROM DeliveryView;


#SELECT 