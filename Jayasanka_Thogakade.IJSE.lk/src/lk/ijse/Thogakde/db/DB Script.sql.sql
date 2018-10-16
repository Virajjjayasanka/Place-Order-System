drop database jaysanka_thogakade;
CREATE DATABASE Jaysanka_Thogakade;
USE Jaysanka_Thogakade;
create table Customer(
	customerID VARCHAR(10)NOT NULL,
	customerName VARCHAR(20)NOT NULL,
	customerAdderss VARCHAR(50)NOT NULL,
	cutomerTelepone_NO VARCHAR(11)NOT NULL,
        AddDate VARCHAR(10)NOT NULL,
	CONSTRAINT PRIMARY KEY (customerID)
);
create table Orders(
        oderid varchar(10) Not null,
         date varchar(10)Not Null,
        customerID VARCHAR(10)NOT NULL,
        Constraint primary key(oderid),
        CONSTRAINT FOREIGN KEY(customerID) REFERENCES Customer(customerID)
	ON UPDATE CASCADE ON DELETE CASCADE
);

create table Item(
	itemCode VARCHAR(20)NOT NULL,
        itemName VARCHAR(20)not null,
        itemDescription VARCHAR(50) NOT NULL,
	itemQTYHand INT(100) NOT NULL,
	itemUnitPrice DECIMAL(6,2) NOT NULL,
        itemDate VARCHAR(10)NOT NULL,
	CONSTRAINT PRIMARY KEY (itemCode)
);
create table OrderDetil(
	
        oderid varchar(10) Not null,
        itemCode Varchar(10) Not null,
        Description VARCHAR(20)not null,
        unitPrice decimal(6,2),
	itemQTYHand int(5)NOt null,
	Constraint primary key (oderid,itemCode),
	CONSTRAINT FOREIGN KEY (oderid) REFERENCES  Orders(oderid)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (itemCode) REFERENCES Item(itemCode)
	ON UPDATE CASCADE ON DELETE CASCADE
);
create table Batch(
        itemCode VARCHAR(20)NOT NULL,
	batchID VARCHAR(20)NOT NULL,
        btchItemExperDate  VARCHAR(10)Not null,
	batchItemMFDDate VARCHAR(10)NOT NULL,
	Constraint primary key(batchID),
        CONSTRAINT FOREIGN KEY(itemCode) REFERENCES Item(itemCode)
	ON UPDATE CASCADE ON DELETE CASCADE
);
 
create table Payment(
        oderid VARCHAR(10)NOT NULL,
	paymentID VARCHAR(10)NOT NULL,
	paymentDate VARCHAR(10)NOT NULL,
	paymentAmount DECIMAL(6,2) NOT NULL,
	CONSTRAINT PRIMARY KEY (paymentID),
	CONSTRAINT FOREIGN KEY(oderid) REFERENCES Orders(oderid)
	ON UPDATE CASCADE ON DELETE CASCADE
);

create table SupplerOrders(
	suOr_ID VARCHAR(20)NOT NULL,
	SuOr_Name VARCHAR(20)NOT NULL,
        suOR_Date VARCHAR(10)NOT NULL,
	SuOr_QTY INT(100) NOT NULL,
       
	CONSTRAINT PRIMARY KEY (suOr_ID)
);
create table BatchDetail(
	batchID VARCHAR(20)NOT NULL,
	suOr_ID VARCHAR(20)NOT NULL,
	QTY INT(100) NOT NULL,
	UnitPrice DECIMAL(6,2) NOT NULL,
	CONSTRAINT PRIMARY KEY (batchID,suOr_ID),
	CONSTRAINT FOREIGN KEY (batchID) REFERENCES Batch(batchID)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (suOr_ID) REFERENCES SupplerOrders(suOr_ID)
	ON UPDATE CASCADE ON DELETE CASCADE
);
create table Agent(
	agentID VARCHAR(20)NOT NULL,
	agentName VARCHAR(20)NOT NULL,
	agentTelePone_NO INT(11)NOT NULL,
        agentCompany VARCHAR(20)NOT NULL,
	CONSTRAINT PRIMARY KEY (agentID)
);
create table SupplerPayment(
	suOr_ID VARCHAR(20)NOT NULL,
	supplerPaymentID VARCHAR(20)NOT NULL,
	supplerPaymentAmount DECIMAL(6,2) NOT NULL,
	supplerPaymentDate VARCHAR(10)NOT NULL,
	CONSTRAINT PRIMARY KEY (supplerPaymentID),
	CONSTRAINT FOREIGN KEY(suOr_ID) REFERENCES SupplerOrders(suOr_ID)
	ON UPDATE CASCADE ON DELETE CASCADE
);
create table GRN(
	GRN_ID VARCHAR(20)NOT NULL,
        suOr_ID VARCHAR(20)NOT NULL,
	GRN_Description  VARCHAR(50)NOT NULL,
	GRN_Date VARCHAR(10)NOT NULL,
	GRN_Time Time,
	CONSTRAINT PRIMARY KEY (GRN_ID),
	CONSTRAINT FOREIGN KEY(suOr_ID) REFERENCES SupplerPayment(suOr_ID)
	ON UPDATE CASCADE ON DELETE CASCADE
);
create table login(
        userName VARCHAR(20)NOT NULL,
        password VARCHAR(20)NOT NULL,
        CONSTRAINT PRIMARY KEY (userName)

);
Insert values into Login ('1','1');