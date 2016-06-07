# HibernateManyToManyAssociation
Many To Many Association Mapping Example Using Annotation
---------------------------------------------------------
This is example of Bi-directional Many To Many relationship with join tables.
We will use Person and Address in all the examples.


Person --------#personid------------>Person_Address <---------#addressid--------------- Address

Define RDBMS (MySql) Tables:
----------------------------
#Person
CREATE TABLE `person` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

#Address
CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `buildingName` varchar(255) DEFAULT NULL,
  `postCode` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

#Person_Address
CREATE TABLE `person_address` (
  `person_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  PRIMARY KEY (`person_id`,`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

