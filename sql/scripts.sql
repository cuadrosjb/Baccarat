create database bacarratsimulator;

use bacarratsimulator;

create table Shoe(
	id INT NOT NULL,
    PRIMARY KEY (id)
);

create table Spot(
	id INT NOT NULL,
    PRIMARY KEY (id)
);

create table Player(
	id INT NOT NULL,
    spotid INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (spotid) REFERENCES Spot(id)
);

create table Banker(
	id INT NOT NULL,
    spotid INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (spotid) REFERENCES Spot(id)
); 

create table Result(
	id INT NOT NULL,
	winner VARCHAR(255),
	natrl BOOL,
    PRIMARY KEY (id)
); 

create table Card(
	id INT NOT NULL,
    spotid INT NOT NULL,
	symbol VARCHAR(255),
	val INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (spotid) REFERENCES Spot(id)
);


create table Hand(
	id INT NOT NULL,
	shoeid INT NOT NULL,
	bankerid INT NOT NULL,
	playerid INT NOT NULL,
	resultid INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (shoeid) REFERENCES Shoe(id),
    FOREIGN KEY (bankerid) REFERENCES Banker(id),
    FOREIGN KEY (playerid) REFERENCES Player(id),
	FOREIGN KEY (resultid) REFERENCES Result(id)
);