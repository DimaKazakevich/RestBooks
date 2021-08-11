-- ************************************** `User`

CREATE TABLE `User`
(
 `id`       int NOT NULL AUTO_INCREMENT ,
 `email`    nvarchar(50) NOT NULL UNIQUE ,
 `password` nvarchar(100) NOT NULL ,
 `role`     nvarchar(50) NOT NULL DEFAULT 'ROLE_USER',

PRIMARY KEY auto_increment(`id`),
CONSTRAINT verify_role CHECK ( role IN ('ROLE_ADMIN', 'ROLE_USER'))
);

-- ************************************** `Author`

CREATE TABLE `Author`
(
 `id`        int NOT NULL AUTO_INCREMENT ,
 `full_name` nvarchar(100) NOT NULL ,
 `country`   nvarchar(100) NOT NULL ,

PRIMARY KEY (`id`)
);


-- ************************************** `Book`

CREATE TABLE `Book`
(
 `id`              int NOT NULL AUTO_INCREMENT ,
 `title`           nvarchar(100) NOT NULL ,
 `publishing_year` int NOT NULL ,
 `author_id`       int NOT NULL ,
 `user_id`         int NOT NULL ,

PRIMARY KEY (`id`),
KEY `fkIdx_19` (`author_id`),
CONSTRAINT `FK_18` FOREIGN KEY `fkIdx_19` (`author_id`) REFERENCES `Author` (`id`),
KEY `fkIdx_22` (`user_id`),
CONSTRAINT `FK_21` FOREIGN KEY `fkIdx_22` (`user_id`) REFERENCES `User` (`id`)
);