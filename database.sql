
CREATE TABLE `login` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `salary` (
  `id` int(10) DEFAULT NULL,
  `hra` decimal(12,2) DEFAULT NULL,
  `da` decimal(12,2) DEFAULT NULL,
  `med` decimal(12,2) DEFAULT NULL,
  `pf` decimal(12,2) DEFAULT NULL,
  `basic_salary` decimal(12,2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `attendence` (
  `id` int(10) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `fir_half` varchar(20) DEFAULT NULL,
  `sec_half` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/* insert data */
insert into `login` (`username`,`password`) values ('sahaja', '12345');

 