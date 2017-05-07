CREATE TABLE `COURSES`(
	`name` VARCHAR(255) NOT NULL,
	`principalText` varchar(255),
	`independentCredits` integer,
	`magistralCredits` integer,
	`noteLab` float,
	`noteOne` float,
	`noteTwo` float,
	`noteThree` float,
	`justification` varchar(255),
	`mnemonic` varchar(255),
	`code` integer,
	`objective` varchar(255),
	`summary` varchar(255),
	`approved` boolean,
	`lastMod` timestamp,
	`preLastMod` timestamp,
	`validFrom` timestamp,
	`validTo` timestamp,
	`labIntensity` varchar(255),
	`magistralIntensity` varchar(255),
	`monitorIntensity` varchar(255),
	`PROGRAM_LINES_name` varchar(255),
	PRIMARY KEY(`name`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `COURSES_detailedThemes`(
	`COURSES_name` varchar(255) NOT NULL,
	`detailedThemes` varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `COURSES_methodology`(
	`COURSES_name` varchar(255) NOT NULL,
	`methodology` varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `COURSES_otherTexts`(
	`COURSES_name` varchar(255) NOT NULL,
	`otherTexts` varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `COURSES_requisites`(
	`COURSES_name` varchar(255) NOT NULL,
	`requisites` varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `COURSES_studyPlans`(
	`COURSES_name` varchar(255) NOT NULL,
	`studyPlans` integer
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `PROGRAM_LINES`(
	`name` varchar(255) NOT NULL,
	`PROGRAMS_name` varchar(255) NOT NULL,
	PRIMARY KEY(`name`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `PERSONS_AUTH`(
	`mail` varchar(255) NOT NULL,
	`pass` varchar(255) NOT NULL,
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
ALTER TABLE `COURSES_detailedThemes` ADD CONSTRAINT `COURSES_detailedThemes_COURSES` FOREIGN KEY(`COURSES_name`) REFERENCES COURSES(`name`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `COURSES_methodology` ADD CONSTRAINT `COURSES_methodology_COURSES` FOREIGN KEY(`COURSES_name`) REFERENCES COURSES(`name`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `COURSES_otherTexts` ADD CONSTRAINT `COURSES_otherTexts_COURSES` FOREIGN KEY(`COURSES_name`) REFERENCES COURSES(`name`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `COURSES_requisites` ADD CONSTRAINT `COURSES_requisites_COURSES` FOREIGN KEY(`COURSES_name`) REFERENCES COURSES(`name`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `COURSES_studyPlans` ADD CONSTRAINT `COURSES_studyPlans_COURSES` FOREIGN KEY(`COURSES_name`) REFERENCES COURSES(`name`) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO PROGRAMS (name) VALUES ("Ingenieria de sistemas");
INSERT INTO PROGRAM_LINES (name, PROGRAMS_name) VALUES ("Plataformas","Ingenieria de sistemas");

