SHOW DATABASES;

CREATE DATABASE LoyaltyProgramChallenge;

USE LoyaltyProgramChallenge;

CREATE TABLE USERS (
	UserID INT AUTO_INCREMENT PRIMARY KEY,
	USERNAME VARCHAR(255),
	PASSWORD VARCHAR(255),
	LOYALTYPOINTS INT
);

alter table users DROP column Loyalty_Points;

ALTER TABLE USERS
ADD LoyaltyPoints int DEFAULT 0; 

INSERT INTO USERS (USERNAME, PASSWORD, LOYALTYPOINTS) VALUES ('DIEGOROLON','PASS123', 45);
INSERT INTO USERS (USERNAME, PASSWORD, LOYALTYPOINTS) VALUES ('root','Admin123', 0);
INSERT INTO USERS (USERNAME, PASSWORD, LOYALTYPOINTS) VALUES ('Admin','Admin123', 0);
INSERT INTO USERS (USERNAME, PASSWORD, LOYALTYPOINTS) VALUES ('DIEGO23','Admin23', 0);

select * from USERS;

CREATE TABLE PRODUCTS (
	ProductID INT AUTO_INCREMENT PRIMARY KEY,
	ProductName VARCHAR(255),
	Qty INT,
	Price DOUBLE,
	LoyaltyPoints INT
);

INSERT INTO PRODUCTS (ProductName, Qty, Price, LoyaltyPoints) VALUES
('PAN BLANCO BIMBO Gde.', 20, 45.00, 10),
('PAN INTEGRAL BIMBO Gde.', 20, 57.80, 15),
('PANQUE MARMOL BIMBO', 20, 45.80, 10),
('PANQUE CON NUEZ BIMBO', 15, 45.80, 10),
('BIMBOLLOS BIMBO 12pz.', 20, 77.00, 25),
('MEDIAS NOCHES BIMBO 8pz.', 20, 35.60, 10),
('NITO', 30, 19.40, 0),
('GANSITO', 30, 19.00, 5);

SELECT * FROM PRODUCTS;

CREATE TABLE PURCHASES (
	ID INT AUTO_INCREMENT PRIMARY KEY,
	PURCHASENUMBER INT,
	UserID INT,
	ProductID INT,
	Qty INT,
	LoyaltyPoints INT,
	foreign key (UserID) REFERENCES USERS(UserID),
	foreign key (ProductID) REFERENCES PRODUCTS(ProductID)
)

select * from PURCHASES

drop table PURCHASES

INSERT INTO PURCHASES (PURCHASENUMBER, UserID, ProductID, Qty, LoyaltyPoints) VALUES
(1, 1, 2, 1, 15),
(1, 1, 3, 1, 10),
(1, 1, 8, 4, 20);

INSERT INTO PURCHASES (PURCHASENUMBER, UserID, ProductID, Qty, LoyaltyPoints) VALUES
(2, 1, 9, 1, 10),
(2, 1, 7, 2, 0);

INSERT INTO PURCHASES (PURCHASENUMBER, UserID, ProductID, Qty, LoyaltyPoints) VALUES
(3, 1, 1, 1, 10),
(3, 1, 7, 4, 0);

SELECT
PURCHASES.ID,
PURCHASES.PURCHASENUMBER,
USERS.USERNAME,
p.ProductName ,
PURCHASES.Qty,
PURCHASES.LoyaltyPoints
FROM PURCHASES
INNER JOIN USERS ON USERS.UserID = PURCHASES.UserID
INNER JOIN PRODUCTS p ON PURCHASES.ProductID = p.ProductID;

select * from USERS -- where USERNAME = ?1;

SELECT DISTINCT PURCHASENUMBER FROM PURCHASES P WHERE P.USERID = 1 ORDER BY PURCHASENUMBER desc

select * from purchases p;

CREATE TABLE REWARDS (
	RewardID INT AUTO_INCREMENT PRIMARY KEY,
	RewardName VARCHAR(255),
	Qty INT,
	PricePoints INT
);

INSERT INTO REWARDS (RewardName, Qty, PricePoints) VALUES
('MOCHILA', 20, 200),
('LONCHERA', 20, 80),
('TOPER', 20, 50),
('BOLIGRAFO', 80, 25);

SELECT * FROM REWARDS;

drop table rewards

CREATE TABLE CLAIMREWARD (
	ClaimID INT AUTO_INCREMENT PRIMARY KEY,
	UserID INT,
	RewardID INT,
	Qty INT,
	foreign key (UserID) REFERENCES USERS(UserID),
	foreign key (RewardID) REFERENCES REWARDS(RewardID)
)

INSERT INTO CLAIMREWARD (UserID, REWARDID, QTY) VALUES
(1, 4, 2)

select 
C.CLAIMID,
U.USERNAME,
R.REWARDNAME,
C.QTY
from CLAIMREWARD C
inner join USERS U on C.USERID = U.USERID
inner join REWARDS R on C.REWARDID = R.REWARDID
