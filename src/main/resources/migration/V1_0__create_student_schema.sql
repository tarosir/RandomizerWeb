CREATE TABLE IF NOT EXISTS students(
                        id int PRIMARY KEY AUTO_INCREMENT,
                        lastname varchar(45) NOT NULL,
                        name varchar(45) NOT NULL,
                        team varchar(45) NOT NULL,
                        question varchar(45) NOT NULL,

)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;