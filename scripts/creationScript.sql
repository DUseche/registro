CREATE TABLE `COURSES`(
	`name` VARCHAR(255) NOT NULL,
	`principalText` varchar(255),
	`independentCredits` integer,
	`magistralCredits` integer,
	`noteLab` float,
	`noteOne` float,
	`noteTwo` float,
	`noteThree` float,
	`justification` varchar(500),
	`mnemonic` varchar(10),
	`code` integer,
	`objective` varchar(500),
	`summary` varchar(500),
	`approved` boolean,
	`lastMod` timestamp,
	`preLastMod` timestamp,
	`validFrom` timestamp,
	`validTo` timestamp,
	`labIntensity` integer,
	`magistralIntensity` integer,
	`monitorIntensity` integer,
	`methodology` varchar(500),
	`requisites` varchar(100),
	`studyPlans` varchar(100),
	`detailedThemes` varchar(500),
	`otherTexts` varchar(1000),
	`PROGRAM_LINES_name` varchar(255),
	PRIMARY KEY(`name`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `PROGRAM_LINES`(
	`name` varchar(255) NOT NULL,
	`PROGRAMS_name` varchar(255) NOT NULL,
	PRIMARY KEY(`name`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `PERSONS_AUTH`(
	`mail` varchar(255) NOT NULL,
	`authority` varchar(255) NOT NULL,
	`program` varchar(255),
	`line` varchar(255),
	PRIMARY KEY(`mail`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `PROGRAMS`(
	`name` varchar(255) NOT NULL,
	PRIMARY KEY(`name`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

ALTER TABLE `COURSES` ADD CONSTRAINT `COURSES_LINE` FOREIGN KEY(`PROGRAM_LINES_name`) REFERENCES PROGRAM_LINES(`name`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `PROGRAM_LINES` ADD CONSTRAINT `PROGRAM_LINES_PROGRAMS` FOREIGN KEY(`PROGRAMS_name`) REFERENCES PROGRAMS(`name`) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO PROGRAMS (name) VALUES ("Ingenieria de sistemas");
INSERT INTO PROGRAMS (name) VALUES ("Ingenieria electrica");
INSERT INTO PROGRAM_LINES (name, PROGRAMS_name) VALUES ("Plataformas","Ingenieria de sistemas");
INSERT INTO PERSONS_AUTH (mail,authority) VALUES ("david.useche@mail.escuelaing.edu.co","4");
INSERT INTO PERSONS_AUTH (mail,authority,program) VALUES ("daniela.torres-mi@mail.escuelaing.edu.co","3","Ingenieria electrica");
INSERT INTO PERSONS_AUTH (mail,authority,program,line) VALUES ("claudia.santiago@escuelaing.edu.co","2","Ingenieria de sistemas","Plataformas");
