create database emeresys;
use emeresys;
create table Location(
locationId int PRIMARY KEY AUTO_INCREMENT,
locationName varchar(255) NOT NULL,
coordinates VARCHAR(255) NOT NULL
);
create table User(
userId INT PRIMARY KEY auto_increment,
name VARCHAR(255) NOT NULL,
role ENUM('responder','paramedic','citizen') NOT NULL,
locationId int,
FOREIGN KEY(locationId) references Location(locationId) ON DELETE SET NULL
);
create table Alerts(
alertId INT PRIMARY KEY auto_increment,
alertType enum('flood','fire','other') NOT NULL,
alertDetails TEXT NOT NULL,
locationId INT,
phoneNo VARCHAR(10) NOT NULL,
Description VARCHAR(100),
FOREIGN KEY(locationId) references Location(locationId) ON DELETE cascade 
);
create table Resources(
resourceId int PRIMARY KEY auto_increment,
resourceType enum('ambulance', 'firetruck', 'medical_kit', 'other') NOT NULL,
status enum('available', 'in use', 'maintainance') NOT NULL,
locationId int,
foreign key(locationId) references Location(locationId) on delete set null
);
create table BloodDrive(
driveId INT PRIMARY KEY auto_increment,
locationId Int,
foreign key(locationId) references Location(locationId) on delete CASCADE
);
create table CommunicationLog(
logId INT PRIMARY KEY auto_increment,
userId INT,
alertId INT,
message TEXT NOT NULL,
timestamp DATETIME default current_timestamp,
foreign key(userId) references User(userId) on delete cascade,
foreign key(alertId) references Alerts(alertId) on delete cascade
);
alter table User add column email VARCHAR(255) UNIQUE NOT NULL;
alter table Location DROP COLUMN coordinates;
ALTER TABLE LOCATION ADD COLUMN latitude FLOAT(10,6) NOT NULL;
ALTER TABLE LOCATION ADD COLUMN longitude FLOAT(10,6) NOT NULL;
CREATE TABLE Roles(
roleId int PRIMARY KEY auto_increment,
roleName varchar(50) UNIQUE NOT NULL
);
create table AlertTypes(
alertTypeId INT primary key auto_increment,
alertTypeName varchar(50) unique Not Null

);
create table ResourceTypes(
resourceTypeId INT primary key auto_increment,
resourceTypeName varchar(50) unique Not Null

);

create table MessageTypes(
messageTypeId INT primary key auto_increment,
messageTypeName varchar(50) unique Not Null

);

alter table User drop column role;
alter table User add column roleId int;
alter table User add foreign key(roleId) references Roles(roleId);

alter table Alerts drop column alertType;
alter table Alerts add column alertTypeId int;
alter table User add foreign key(alertTypeId) references AlertTypes(alertTypeId);

alter table Resources drop column resourceType;
alter table Resources add column resourceTypeId int;
alter table Resources add foreign key(resourceTypeId) references ResourceTypes(ResourceTypeId);


alter table CommunicationLog add column messageTypeId int;
alter table CommunicationLog add foreign key(messageTypeId) references MessageTypes(messageTypeId);

